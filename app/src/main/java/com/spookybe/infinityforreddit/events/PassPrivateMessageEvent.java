package com.spookybe.infinityforreddit.events;

import com.spookybe.infinityforreddit.message.Message;

public class PassPrivateMessageEvent {
    public Message message;

    public PassPrivateMessageEvent(Message message) {
        this.message = message;
    }
}
