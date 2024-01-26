package com.ecommerce.registeruserapi.components;

import java.util.Map;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

/**
 * This class is responsible for customizing the response for exceptions thrown to the user.
 * It allows removal, addition, and updating of attributes in the error response returned to the user.
 * <p>
 * CustomErrorAttributes implements the ErrorAttributes interface to provide a customized error response format.
 * It removes the 'trace' attribute from the default error attributes to enhance security by not exposing sensitive information.
 * <p>
 * ErrorAttributes:
 * The ErrorAttributes interface provides a contract for classes that can extract error attributes from a web request.
 * <p>
 * Usage:
 * This component is automatically scanned and registered in the Spring context due to the @Component annotation.
 * It is used by Spring Boot to handle error responses, and it customizes the attributes returned to the user.
 */

@Component
public class CustomErrorAttributes implements ErrorAttributes {

    private final DefaultErrorAttributes defaultErrorAttributes = new DefaultErrorAttributes();

    /**
     * Retrieves the error attributes for a given web request, customizing the response format.
     * The 'trace' attribute is removed for security reasons.
     *
     * @param webRequest The current web request
     * @param options    Additional options for error attribute retrieval
     * @return A Map of error attributes for the response
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = defaultErrorAttributes.getErrorAttributes(webRequest, options);
        errorAttributes.remove("trace");

        return errorAttributes;
    }

    /**
     * Retrieves the Throwable instance representing the error for a given web request.
     *
     * @param webRequest The current web request
     * @return The Throwable instance representing the error
     */
    @Override
    public Throwable getError(WebRequest webRequest) {
        return defaultErrorAttributes.getError(webRequest);
    }
}
