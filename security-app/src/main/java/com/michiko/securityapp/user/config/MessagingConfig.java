package com.michiko.securityapp.user.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class MessagingConfig {

	//private static final String TOPIC = "userRegisteredTopic";
	//private static final String QUEUE_NAME = "user.registered";
	
	/**
	 *  SpringBoot AMQP Setup
	 * 	1. Configure listener
 		2. Create queue, topic exchange, and binding
		3. Configure sender
		
		Management UI listen on port 15672
		Default username/password: guest
	 */

	
	//
	/*@Bean
	public Queue userRegisteredQueue() {
		return new Queue(QUEUE_NAME, false);
	}
	
	@Bean
	public TopicExchange userRegisteredTopic() {
		return new TopicExchange(TOPIC);
	}
	
	@Bean
	ConnectionFactory connectionFactory() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		return connectionFactory;
	}
	
	@Bean
	public Binding binding(Queue queue, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue).to(topicExchange).with("user.#");
	}*/
}
