package com.password.validation.application.domain.Terms;

import com.password.validation.application.domain.interfaces.PasswordTermsInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OneUppercaseLetter implements PasswordTermsInterface {

    @Override
    public boolean verify(String password) {
        final String atLeastOneUpperCaseLetterRegex = "^(?=.*[A-Z]).*$";

        log.info("Checking if the password has at least one uppercase letter");

        return password.matches(atLeastOneUpperCaseLetterRegex);
    }
}
