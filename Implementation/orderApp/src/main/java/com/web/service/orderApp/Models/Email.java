package com.web.service.orderApp.Models;

import java.util.Objects;

public class Email extends BaseChannel {

    /**
     * @param channel
     */
    public Email(IChannel channel) {
        super(channel);
    }
    @Override
    public String toString() {
        return Objects.equals(super.toString(), "") ? "Email"
                : ("Email and "  + super.toString()) ;
    }
}