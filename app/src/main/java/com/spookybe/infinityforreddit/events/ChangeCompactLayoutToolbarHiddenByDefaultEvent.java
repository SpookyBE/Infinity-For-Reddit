package com.spookybe.infinityforreddit.events;

public class ChangeCompactLayoutToolbarHiddenByDefaultEvent {
    public boolean compactLayoutToolbarHiddenByDefault;

    public ChangeCompactLayoutToolbarHiddenByDefaultEvent(boolean compactLayoutToolbarHiddenByDefault) {
        this.compactLayoutToolbarHiddenByDefault = compactLayoutToolbarHiddenByDefault;
    }
}
