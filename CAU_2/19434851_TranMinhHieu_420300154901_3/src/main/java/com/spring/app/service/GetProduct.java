package com.spring.app.service;

import lombok.extern.slf4j.Slf4j;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
@Slf4j
public class GetProduct implements MessageListener {
	

    @Override
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(Message message) {
        try{
        	if (message instanceof ActiveMQTextMessage) {
        		ActiveMQTextMessage msg =(ActiveMQTextMessage) message;
        		log.info("Received Message from Topic: "+ msg.getText());
        	}
        	else {
        		
        		ObjectMessage objectMessage = (ObjectMessage)message;
        	}
            
        } catch(Exception e) {
            log.error("Received Exception while processing message: "+ e);
        }

    }
}
