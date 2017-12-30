package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.demo.web.HelloController;

public class DemoApplicationTests {

	@Test
	public void testSayHello() {
		assertEquals("Hello World!", new HelloController().index());
	}

}
