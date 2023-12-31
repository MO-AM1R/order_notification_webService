package com.web.service.orderApp.Models;

public class SMS extends BaseChannel {
    /**
     * @param channel
     */
    public SMS(IChannel channel) {
        super(channel);
    }
    @Override
    public String toString() {
        return "Email";
    }
}