package com.spookybe.infinityforreddit.events;

public class ToggleSecureModeEvent {
    public boolean isSecureMode;

    public ToggleSecureModeEvent(boolean isSecureMode) {
        this.isSecureMode = isSecureMode;
    }
}
