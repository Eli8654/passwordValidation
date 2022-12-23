package com.password.validation.application.domain.Terms;

import com.password.validation.application.domain.interfaces.PasswordTermsInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Slf4j
@Component
public class RepeatingCharacters implements PasswordTermsInterface {
    @Override
    public boolean verify(String password) {
        final String haveNonRepeatingCharactersRegex = "^(?!.*(.).*\\1).*$";

        log.info("Checking if the password doesn't repeat characters");

        Pattern haveNonRepeatingCharactersPattern = Pattern.compile(haveNonRepeatingCharactersRegex,
                Pattern.CASE_INSENSITIVE);

        return haveNonRepeatingCharactersPattern.matcher(password).find();
    }
}
