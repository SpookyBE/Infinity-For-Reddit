package com.spookybe.infinityforreddit.events;

public class ChangeHideTheNumberOfCommentsEvent {
    public boolean hideTheNumberOfComments;

    public ChangeHideTheNumberOfCommentsEvent(boolean hideTheNumberOfComments) {
        this.hideTheNumberOfComments = hideTheNumberOfComments;
    }
}
