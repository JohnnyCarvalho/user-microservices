package com.ecommerce.registeruserapi.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityUtils {

    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
