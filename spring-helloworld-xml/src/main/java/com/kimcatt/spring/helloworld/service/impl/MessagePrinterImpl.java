package com.kimcatt.spring.helloworld.service.impl;

import com.kimcatt.spring.helloworld.repository.MessageSource;
import com.kimcatt.spring.helloworld.service.MessagePrinter;

public class MessagePrinterImpl implements MessagePrinter {

	private MessageSource messageSource;
	
	public void print() {
		System.out.println(messageSource.getMessage());
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}
