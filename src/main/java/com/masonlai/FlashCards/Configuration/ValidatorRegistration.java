package com.masonlai.FlashCards.Configuration;

import com.masonlai.FlashCards.Model.Validator.UserValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorRegistration {

    @Bean
    public UserValidator beforeCreateUserValidator() {
        return new UserValidator();
    }

}
