package com.spookybe.infinityforreddit.events;

public class ChangeTimeFormatEvent {
    public String timeFormat;

    public ChangeTimeFormatEvent(String timeFormat) {
        this.timeFormat = timeFormat;
    }
}
