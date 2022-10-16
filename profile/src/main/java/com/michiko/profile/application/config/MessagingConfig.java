package com.michiko.profile.application.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.michiko.profile.domain.event.UserRegisteredEventHandler;

@Configuration
public class MessagingConfig {

	private static final String TOPIC = "userRegisteredTopic";
	private static final String QUEUE_NAME = "user.registered.profile";
	
	/**
	 *  SpringBoot AMQP Setup
	 * 	1. Configure listener
 		2. Create queue, topic exchange, and binding
		3. Configure sender
		
		Management UI listen on port 15672
		Default username/password: guest
	 */

	
	//
	@Bean
	public Queue userRegisteredQueue() {
		return new Queue(QUEUE_NAME, false);
	}
	
	@Bean
	public TopicExchange userRegisteredTopic() {
		return new TopicExchange(TOPIC);
	} 
	
	@Bean
	public Binding binding(Queue queue, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue).to(topicExchange).with("user.#");
	}
	
	@Bean
	public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter messageListenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(QUEUE_NAME);
		container.setMessageListener(messageListenerAdapter);
		return container;	
	}
	
	@Bean
	public MessageListenerAdapter userRegisteredEventListener(UserRegisteredEventHandler userRegisteredEventHandler) {
		return new MessageListenerAdapter(userRegisteredEventHandler, "handleUserRegistration");
	}
}
