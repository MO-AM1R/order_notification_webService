package com.web.service.orderApp.Models;

public class Email extends BaseChannel {

    /**
     * @param channel
     */
    public Email(IChannel channel) {
        super(channel);
    }

    @Override
    public String toString() {
        return "Email";
    }
}