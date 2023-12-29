package com.web.service.orderApp.Models;

public abstract class BaseChannel implements IChannel {

	private final IChannel channel;

	/**
	 * 
	 * @param channel
	 */
	public BaseChannel(Channel channel) {
		this.channel = channel ;
	}

}