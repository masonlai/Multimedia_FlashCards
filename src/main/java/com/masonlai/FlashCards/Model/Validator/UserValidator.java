package com.masonlai.FlashCards.Model.Validator;

import com.masonlai.FlashCards.Model.Entities.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User user = (User) obj;
        if (checkInputString(user.getUserName())) {
            errors.rejectValue("username", "username is empty, which is required");
        }

        if (checkInputString(user.getPassword())) {
            errors.rejectValue("password", "password is empty, which is required");
        }
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
