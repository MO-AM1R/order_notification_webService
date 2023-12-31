package com.web.service.orderApp.Models;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Component
@AllArgsConstructor
@Getter
@Setter
public abstract class BaseChannel implements IChannel {

	private IChannel channel;

	@Override
	public String toString() {
		return channel.toString();
	}
}