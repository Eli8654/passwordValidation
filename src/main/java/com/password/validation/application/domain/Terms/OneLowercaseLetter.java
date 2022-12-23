package com.password.validation.application.domain.Terms;

import com.password.validation.application.domain.interfaces.PasswordTermsInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OneLowercaseLetter implements PasswordTermsInterface {
    @Override
    public boolean verify(String password) {
        final String atLeastOneLowerCaseLetterRegex = "^(?=.*[a-z]).*$";

        log.info("Checking if the password has at least one lowercase letter");

        return password.matches(atLeastOneLowerCaseLetterRegex);
    }
}
