package com.web.service.orderApp.Models;

import java.util.Objects;

public class SMS extends BaseChannel {
    /**
     * @param channel
     */
    public SMS(IChannel channel) {
        super(channel);
    }
    @Override
    public String toString() {
        return Objects.equals(super.toString(), "") ? "SMS"
                : ("SMS and " + super.toString()) ;
    }
}