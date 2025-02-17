package com.spookybe.infinityforreddit;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.Executor;

import com.spookybe.infinityforreddit.apis.GfycatAPI;
import com.spookybe.infinityforreddit.apis.RedgifsAPI;
import com.spookybe.infinityforreddit.utils.APIUtils;
import com.spookybe.infinityforreddit.utils.JSONUtils;
import com.spookybe.infinityforreddit.utils.SharedPreferencesUtils;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FetchGfycatOrRedgifsVideoLinks {

    public interface FetchGfycatOrRedgifsVideoLinksListener {
        void success(String webm, String mp4);
        void failed(int errorCode);
    }

    public static void fetchGfycatVideoLinks(Executor executor, Handler handler, Retrofit gfycatRetrofit,
                                             String gfycatId,
                                             FetchGfycatOrRedgifsVideoLinksListener fetchGfycatOrRedgifsVideoLinksListener) {
        executor.execute(() -> {
            try {
                Response<String> response = gfycatRetrofit.create(GfycatAPI.class).getGfycatData(gfycatId).execute();
                if (response.isSuccessful()) {
                    parseGfycatVideoLinks(handler, response.body(), fetchGfycatOrRedgifsVideoLinksListener);
                } else {
                    handler.post(() -> fetchGfycatOrRedgifsVideoLinksListener.failed(response.code()));
                }
            } catch (IOException e) {
                e.printStackTrace();
                handler.post(() -> fetchGfycatOrRedgifsVideoLinksListener.failed(-1));
            }
        });
    }

    public static void fetchRedgifsVideoLinks(Context context, Executor executor, Handler handler, Retrofit redgifsRetrofit,
                                              SharedPreferences currentAccountSharedPreferences,
                                              String gfycatId,
                                              FetchGfycatOrRedgifsVideoLinksListener fetchGfycatOrRedgifsVideoLinksListener) {
        executor.execute(() -> {
            try {
                Response<String> response = redgifsRetrofit.create(RedgifsAPI.class).getRedgifsData(APIUtils.getRedgifsOAuthHeader(currentAccountSharedPreferences.getString(SharedPreferencesUtils.REDGIFS_ACCESS_TOKEN, "")),
                         gfycatId).execute();
                if (response.isSuccessful()) {
                    parseRedgifsVideoLinks(handler, response.body(), fetchGfycatOrRedgifsVideoLinksListener);
                } else {
                    handler.post(() -> fetchGfycatOrRedgifsVideoLinksListener.failed(response.code()));
                }
            } catch (IOException e) {
                e.printStackTrace();
                handler.post(() -> fetchGfycatOrRedgifsVideoLinksListener.failed(-1));
            }
        });
    }

    public static void fetchGfycatOrRedgifsVideoLinksInRecyclerViewAdapter(Executor executor, Handler handler,
                                                                           Call<String> gfycatCall,
                                                                           boolean isGfycatVideo,
                                                                           boolean automaticallyTryRedgifs,
                                                                           FetchGfycatOrRedgifsVideoLinksListener fetchGfycatOrRedgifsVideoLinksListener) {
        executor.execute(() -> {
            try {
                Response<String> response = gfycatCall.execute();
                if (response.isSuccessful()) {
                    if (isGfycatVideo) {
                        parseGfycatVideoLinks(handler, response.body(), fetchGfycatOrRedgifsVideoLinksListener);
                    } else {
                        parseRedgifsVideoLinks(handler, response.body(), fetchGfycatOrRedgifsVideoLinksListener);
                    }
                } else {
                    if (response.code() == 404 && isGfycatVideo && automaticallyTryRedgifs) {
                        fetchGfycatOrRedgifsVideoLinksInRecyclerViewAdapter(executor, handler, gfycatCall.clone(),
                                false, false, fetchGfycatOrRedgifsVideoLinksListener);
                    } else {
                        handler.post(() -> fetchGfycatOrRedgifsVideoLinksListener.failed(response.code()));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                handler.post(() -> fetchGfycatOrRedgifsVideoLinksListener.failed(-1));
            }
        });
    }

    private static void parseGfycatVideoLinks(Handler handler, String response,
                                              FetchGfycatOrRedgifsVideoLinksListener fetchGfycatOrRedgifsVideoLinksListener) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            String mp4 = jsonObject.getJSONObject(JSONUtils.GFY_ITEM_KEY).has(JSONUtils.MP4_URL_KEY) ?
                    jsonObject.getJSONObject(JSONUtils.GFY_ITEM_KEY).getString(JSONUtils.MP4_URL_KEY)
                    : jsonObject.getJSONObject(JSONUtils.GFY_ITEM_KEY)
                    .getJSONObject(JSONUtils.CONTENT_URLS_KEY)
                    .getJSONObject(JSONUtils.MP4_KEY)
                    .getString(JSONUtils.URL_KEY);
            String webm;
            if (jsonObject.getJSONObject(JSONUtils.GFY_ITEM_KEY).has(JSONUtils.WEBM_URL_KEY)) {
                webm = jsonObject.getJSONObject(JSONUtils.GFY_ITEM_KEY).getString(JSONUtils.WEBM_URL_KEY);
            } else if (jsonObject.getJSONObject(JSONUtils.GFY_ITEM_KEY).getJSONObject(JSONUtils.CONTENT_URLS_KEY).has(JSONUtils.WEBM_KEY)) {
                webm = jsonObject.getJSONObject(JSONUtils.GFY_ITEM_KEY)
                        .getJSONObject(JSONUtils.CONTENT_URLS_KEY)
                        .getJSONObject(JSONUtils.WEBM_KEY)
                        .getString(JSONUtils.URL_KEY);
            } else {
                webm = mp4;
            }
            handler.post(() -> fetchGfycatOrRedgifsVideoLinksListener.success(webm, mp4));
        } catch (JSONException e) {
            e.printStackTrace();
            handler.post(() -> fetchGfycatOrRedgifsVideoLinksListener.failed(-1));
        }
    }

    private static void parseRedgifsVideoLinks(Handler handler, String response,
                                              FetchGfycatOrRedgifsVideoLinksListener fetchGfycatOrRedgifsVideoLinksListener) {
        try {
            String mp4 = new JSONObject(response).getJSONObject(JSONUtils.GIF_KEY).getJSONObject(JSONUtils.URLS_KEY)
                    .getString(JSONUtils.HD_KEY);
            handler.post(() -> fetchGfycatOrRedgifsVideoLinksListener.success(mp4, mp4));
        } catch (JSONException e) {
            e.printStackTrace();
            handler.post(() -> fetchGfycatOrRedgifsVideoLinksListener.failed(-1));
        }
    }
}
