package com.spookybe.infinityforreddit.events;

public class ChangeHideTheNumberOfAwardsEvent {
    public boolean hideTheNumberOfAwards;

    public ChangeHideTheNumberOfAwardsEvent(boolean hideTheNumberOfAwards) {
        this.hideTheNumberOfAwards = hideTheNumberOfAwards;
    }
}
