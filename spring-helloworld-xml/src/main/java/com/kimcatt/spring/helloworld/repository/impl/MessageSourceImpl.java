package com.kimcatt.spring.helloworld.repository.impl;

import com.kimcatt.spring.helloworld.repository.MessageSource;

public class MessageSourceImpl implements MessageSource {

	public String getMessage() {
		return "Hello World";
	}

}
