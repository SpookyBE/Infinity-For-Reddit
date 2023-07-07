package com.spookybe.infinityforreddit.events;

public class ChangeOnlyDisablePreviewInVideoAndGifPostsEvent {
    public boolean onlyDisablePreviewInVideoAndGifPosts;

    public ChangeOnlyDisablePreviewInVideoAndGifPostsEvent(boolean onlyDisablePreviewInVideoAndGifPosts) {
        this.onlyDisablePreviewInVideoAndGifPosts = onlyDisablePreviewInVideoAndGifPosts;
    }
}
