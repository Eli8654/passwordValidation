package com.password.validation.application.domain.Terms;

import com.password.validation.application.domain.interfaces.PasswordTermsInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OneDigit implements PasswordTermsInterface {
    @Override
    public boolean verify(String password) {
        final String atLeastOneDigitRegex = "^(?=.*[0-9]).*$";

        log.info("Checking if the password has at least one digit");

        return password.matches(atLeastOneDigitRegex);
    }
}
