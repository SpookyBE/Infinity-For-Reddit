package com.spookybe.infinityforreddit.events;

public class ChangeSavePostFeedScrolledPositionEvent {
    public boolean savePostFeedScrolledPosition;

    public ChangeSavePostFeedScrolledPositionEvent(boolean savePostFeedScrolledPosition) {
        this.savePostFeedScrolledPosition = savePostFeedScrolledPosition;
    }
}
