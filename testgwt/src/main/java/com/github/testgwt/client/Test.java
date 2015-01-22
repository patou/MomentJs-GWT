package com.github.testgwt.client;

import com.google.gwt.core.client.js.JsProperty;
import com.google.gwt.core.client.js.JsType;

@JsType
public interface Test {
	@JsProperty
	String getName();
	String ask();
}
