package com.spookybe.infinityforreddit.events;

public class ChangeAutoplayNsfwVideosEvent {
    public boolean autoplayNsfwVideos;

    public ChangeAutoplayNsfwVideosEvent(boolean autoplayNsfwVideos) {
        this.autoplayNsfwVideos = autoplayNsfwVideos;
    }
}
