package com.ecommerce.registeruserapi.producer;

import com.ecommerce.registeruserapi.dto.request.UserCreateRequest;
import com.ecommerce.registeruserapi.dto.response.EmailResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;

    /**
     * Inject RabbitTemplate by constructor in UserProducer
     *
     * @param rabbitTemplate
     */
    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Maps the name of the queue where the message will be published.
     */
    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserCreateRequest user) {

        EmailResponse response = EmailResponse.builder()
                .userName(user.getUserName())
                .emailTo(user.getEmail())
                .subject("Registration Successfully Completed!")
                .text("Welcome to the user registration system sr " + user.getFirstName() + "!")
                .build();

        rabbitTemplate.convertAndSend("", routingKey, response);
    }
}
