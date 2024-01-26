package com.ecommerce.registeruserapi.config;

import com.ecommerce.registeruserapi.components.CustomErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.RequestContextFilter;


/**
 * Configuration class for customizing error handling and attributes in Spring Boot applications.
 * <p>
 * The CustomErrorConfig class provides configuration beans related to error handling and attributes in the application.
 * It defines beans for RequestContextListener, RequestContextFilter, and CustomErrorAttributes.
 * <p>
 * Configuration Details:
 * 1. RequestContextListener: A bean for handling the lifecycle of a request's context, enabling request-scoped beans.
 * 2. RequestContextFilter: A bean for managing the lifecycle of a request's context and making it available during HTTP requests.
 * 3. CustomErrorAttributes: A custom implementation of ErrorAttributes to customize the format of error responses sent to clients.
 * <p>
 * Usage:
 * To use this configuration, annotate your application configuration class with @Import(CustomErrorConfig.class).
 * This will ensure that the custom error handling configurations are applied to your Spring Boot application.
 */
@Configuration
public class CustomErrorConfig {


    /**
     * Creates and returns a RequestContextListener bean.
     *
     * @return RequestContextListener bean
     */
    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    /**
     * Creates and returns a RequestContextFilter bean.
     *
     * @return RequestContextFilter bean
     */
    @Bean
    public RequestContextFilter requestContextFilter() {
        return new RequestContextFilter();
    }

    /**
     * Creates and returns a CustomErrorAttributes bean.
     *
     * @return CustomErrorAttributes bean
     */
    @Bean
    public CustomErrorAttributes customErrorAttributes() {
        return new CustomErrorAttributes();
    }
}
