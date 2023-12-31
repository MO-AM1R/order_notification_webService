package com.web.service.orderApp.Models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class BaseChannel implements IChannel {

	private IChannel channel;

	@Override
	public String toString() {
		return channel.toString();
	}
}