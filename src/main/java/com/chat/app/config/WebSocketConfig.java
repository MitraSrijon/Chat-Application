package com.chat.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        registry.addEndpoint("/chat") // will get this on page http://localhost:8080/chat
                .setAllowedOrigins("http://localhost:8080") //this is post that will able to communicate with us i.e. with port 8080
                .withSockJS(); //makes client compatible that doesn't use websockets, making it accessible

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        registry.enableSimpleBroker("/topic"); //whoever is added to /topic get access to see all the messages
        registry.setApplicationDestinationPrefixes("/app"); //anything with /app prefix process it
        

    }
}
