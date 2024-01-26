package com.ecommerce.registeruserapi.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Configuration class for customizing the Jackson ObjectMapper used for JSON serialization and deserialization.
 * <p>
 * The ObjectMapperConfig class provides a customized Jackson ObjectMapper bean with specific configurations.
 * It configures the ObjectMapper to handle Java 8 time types, use snake_case for property naming, and customize date formatting.
 * Additionally, it disables the serialization of dates as timestamps and ignores unknown properties during deserialization.
 * <p>
 * Configuration Details:
 * - Date Format: "yyyy-MM-dd'T'HH:mm:ss'Z'"
 * - Time Zone: UTC
 * - Property Naming Strategy: Snake Case
 * - Serialization Features: WRITE_DATES_AS_TIMESTAMPS is disabled
 * - Deserialization Features: FAIL_ON_UNKNOWN_PROPERTIES is disabled
 * <p>
 * Usage:
 * To use this configuration, annotate your application configuration class with @Import(ObjectMapperConfig.class).
 * This will ensure that the custom ObjectMapper is available for use in your application.
 */

@Configuration
public class ObjectMapperConfig {

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    /**
     * Creates and returns a customized Jackson ObjectMapper bean.
     *
     * @return Customized Jackson ObjectMapper
     */
    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        objectMapper.setDateFormat(sdf);
        return objectMapper;
    }
}
