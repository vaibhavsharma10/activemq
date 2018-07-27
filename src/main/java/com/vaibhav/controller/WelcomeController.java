package com.vaibhav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.bean.Welcome;

@RestController
public class WelcomeController {
	private static final String welcomemsg = "Welcome Mr. %s!";
	
	@Autowired 
	private JmsTemplate jmsTemplate;

	@GetMapping("/welcome/user")
	@ResponseBody
	public Welcome welcomeUser(@RequestParam(name = "name", required = false, defaultValue = "Friend") String name) {
		System.out.println("Called Web Service Welcome 1");
		return new Welcome(String.format(welcomemsg, name));
	}

	@GetMapping("/testservice1")
	@ResponseBody
	public Welcome testService1() {
		System.out.println("1   Called Test Service 1");
		return new Welcome("Called Test Service 1");
	}

	@GetMapping("/testservice2")
	@ResponseBody
	public Welcome testService2() {
		System.out.println("2   Called Test Service 2");
		return new Welcome("Called Test Service 1");
	}
	
	@GetMapping("/testservice3")
	@ResponseBody
	public Welcome testService3() {
		System.out.println("Testing MQ");
		sendMessage();
		return new Welcome("Testing MQ");
	}
	
	
	public void sendMessage() {
		int count = 0;
		while (count < 10) {
			count++;
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			Welcome welcome = new Welcome("I am testing " + count);
			jmsTemplate.convertAndSend("caseform-queue2", welcome);
		}
	}
	
	
}
