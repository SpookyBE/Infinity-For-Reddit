package com.spookybe.infinityforreddit.settings;

import android.os.Bundle;

import com.spookybe.infinityforreddit.R;
import com.spookybe.infinityforreddit.customviews.CustomFontPreferenceFragmentCompat;

public class NumberOfColumnsInPostFeedPreferenceFragment extends CustomFontPreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.number_of_columns_in_post_feed_preferences, rootKey);
    }
}
