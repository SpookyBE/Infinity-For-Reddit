package com.spookybe.infinityforreddit.customviews;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;

import com.spookybe.infinityforreddit.utils.SharedPreferencesUtils;
import com.spookybe.infinityforreddit.videoautoplay.Config;
import com.spookybe.infinityforreddit.videoautoplay.DefaultExoCreator;
import com.spookybe.infinityforreddit.videoautoplay.ToroExo;

public class LoopAvailableExoCreator extends DefaultExoCreator {
    private final SharedPreferences sharedPreferences;

    public LoopAvailableExoCreator(@NonNull ToroExo toro, @NonNull Config config, SharedPreferences sharedPreferences) {
        super(toro, config);
        this.sharedPreferences = sharedPreferences;
    }

    @NonNull
    @Override
    public ExoPlayer createPlayer() {
        ExoPlayer player = super.createPlayer();
        if (sharedPreferences.getBoolean(SharedPreferencesUtils.LOOP_VIDEO, true)) {
            player.setRepeatMode(Player.REPEAT_MODE_ALL);
        } else {
            player.setRepeatMode(Player.REPEAT_MODE_OFF);
        }

        return player;
    }
}
