package com.spookybe.infinityforreddit.asynctasks;

import android.os.Handler;

import java.util.concurrent.Executor;

import com.spookybe.infinityforreddit.RedditDataRoomDatabase;
import com.spookybe.infinityforreddit.user.FetchUserData;
import com.spookybe.infinityforreddit.user.UserDao;
import com.spookybe.infinityforreddit.user.UserData;
import retrofit2.Retrofit;

public class LoadUserData {

    public static void loadUserData(Executor executor, Handler handler, RedditDataRoomDatabase redditDataRoomDatabase, String userName,
                                    Retrofit retrofit, LoadUserDataAsyncTaskListener loadUserDataAsyncTaskListener) {
        executor.execute(() -> {
            UserDao userDao = redditDataRoomDatabase.userDao();
            if (userDao.getUserData(userName) != null) {
                String iconImageUrl = userDao.getUserData(userName).getIconUrl();
                handler.post(() -> loadUserDataAsyncTaskListener.loadUserDataSuccess(iconImageUrl));
            } else {
                handler.post(() -> FetchUserData.fetchUserData(retrofit, userName, new FetchUserData.FetchUserDataListener() {
                    @Override
                    public void onFetchUserDataSuccess(UserData userData, int inboxCount) {
                        InsertUserData.insertUserData(executor, handler, redditDataRoomDatabase, userData,
                                () -> loadUserDataAsyncTaskListener.loadUserDataSuccess(userData.getIconUrl()));
                    }

                    @Override
                    public void onFetchUserDataFailed() {
                        loadUserDataAsyncTaskListener.loadUserDataSuccess(null);
                    }
                }));
            }
        });
    }

    public interface LoadUserDataAsyncTaskListener {
        void loadUserDataSuccess(String iconImageUrl);
    }
}
