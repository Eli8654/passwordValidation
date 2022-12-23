package com.password.validation.application.domain.mappers;

import com.password.validation.application.domain.enumeration.Validation;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class PasswordTermsMapper {

    public boolean isValid(String password, Validation... validations) {

        for (Validation validation : validations) {
            boolean isAnInvalidPassword = !validation.getPasswordTermsInterface().verify(password);

            if (isAnInvalidPassword) {
                log.info("The password is invalid!");
                return false;
            }
        }

        log.info("The password is valid!");

        return true;
    }

}
