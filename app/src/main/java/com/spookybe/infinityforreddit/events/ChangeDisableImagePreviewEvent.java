package com.spookybe.infinityforreddit.events;

public class ChangeDisableImagePreviewEvent {
    public boolean disableImagePreview;

    public ChangeDisableImagePreviewEvent(boolean disableImagePreview) {
        this.disableImagePreview = disableImagePreview;
    }
}
