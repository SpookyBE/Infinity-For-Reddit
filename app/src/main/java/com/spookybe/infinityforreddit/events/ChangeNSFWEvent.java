package com.spookybe.infinityforreddit.events;

public class ChangeNSFWEvent {
    public boolean nsfw;

    public ChangeNSFWEvent(boolean nsfw) {
        this.nsfw = nsfw;
    }
}
