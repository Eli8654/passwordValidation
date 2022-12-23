package com.password.validation.application.domain.Terms;

import com.password.validation.application.domain.interfaces.PasswordTermsInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Spaces implements PasswordTermsInterface {
    @Override
    public boolean verify(String password) {
        final String haveNonSpacesRegex = "^(?!.*\\h).*$";

        log.info("Checking if the password doesn't have spaces");

        return password.matches(haveNonSpacesRegex);
    }
}
