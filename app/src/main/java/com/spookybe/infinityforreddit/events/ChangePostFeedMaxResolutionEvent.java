package com.spookybe.infinityforreddit.events;

public class ChangePostFeedMaxResolutionEvent {
    public int postFeedMaxResolution;

    public ChangePostFeedMaxResolutionEvent(int postFeedMaxResolution) {
        this.postFeedMaxResolution = postFeedMaxResolution;
    }
}
