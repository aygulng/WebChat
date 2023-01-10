package com.example.webchat.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // Регистрация конечной точки веб-сокета, которую клиенты будут использовать для подключения к нашему серверу веб-сокета    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //определяет, что сообщения, пункт назначения которых начинается с «/app», должны направляться в методы обработки сообщений.

        registry.setApplicationDestinationPrefixes("/app");

        //определяет, что сообщения, пункт назначения которых начинается с «/topic», должны направляться брокеру сообщений.
        registry.enableSimpleBroker("/topic");

    }
}
