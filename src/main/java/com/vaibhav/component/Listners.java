package com.vaibhav.component;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.vaibhav.bean.Welcome;

@Component
public class Listners {
	
	public String receiveMessage(final Message jsonMessage) throws JMSException {
		String messageData = null;
		System.out.println("Received message " + jsonMessage);
		String response = null;
		if(jsonMessage instanceof TextMessage) {
			TextMessage textMessage = (TextMessage)jsonMessage;
			messageData = textMessage.getText();
			Map map = new Gson().fromJson(messageData, Map.class);
			response  = "Hello " + map.get("message");
		}
		return response;
	}
	
	@JmsListener(destination = "caseform-queue2")
	public void receivePayLoad(@Payload Welcome welcome) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Received message " + welcome.toString());
	}
	
}
