package com.spookybe.infinityforreddit.events;

public class ChangeMuteAutoplayingVideosEvent {
    public boolean muteAutoplayingVideos;

    public ChangeMuteAutoplayingVideosEvent(boolean muteAutoplayingVideos) {
        this.muteAutoplayingVideos = muteAutoplayingVideos;
    }
}
