package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoController {

	@Autowired
	public DemoController(String myString) {
		System.out.println("myString is dependency injected. The name of myString is: " + myString);
	}
}
