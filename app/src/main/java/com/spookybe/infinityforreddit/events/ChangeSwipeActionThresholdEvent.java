package com.spookybe.infinityforreddit.events;

public class ChangeSwipeActionThresholdEvent {
    public float swipeActionThreshold;

    public ChangeSwipeActionThresholdEvent(float swipeActionThreshold) {
        this.swipeActionThreshold = swipeActionThreshold;
    }
}
