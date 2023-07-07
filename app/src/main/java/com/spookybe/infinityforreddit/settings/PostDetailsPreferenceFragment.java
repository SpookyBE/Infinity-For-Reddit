package com.spookybe.infinityforreddit.settings;

import android.os.Bundle;

import androidx.preference.PreferenceManager;

import com.spookybe.infinityforreddit.R;
import com.spookybe.infinityforreddit.customviews.CustomFontPreferenceFragmentCompat;
import com.spookybe.infinityforreddit.utils.SharedPreferencesUtils;

public class PostDetailsPreferenceFragment extends CustomFontPreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        PreferenceManager preferenceManager = getPreferenceManager();
        preferenceManager.setSharedPreferencesName(SharedPreferencesUtils.POST_DETAILS_SHARED_PREFERENCES_FILE);
        setPreferencesFromResource(R.xml.post_details_preferences, rootKey);
    }
}
