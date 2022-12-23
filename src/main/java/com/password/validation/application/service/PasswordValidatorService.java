package com.password.validation.application.service;

import com.password.validation.application.domain.entity.PasswordStatus;
import com.password.validation.application.domain.enumeration.Validation;
import com.password.validation.application.domain.mappers.PasswordTermsMapper;
import com.password.validation.application.resources.entity.PasswordDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PasswordValidatorService {

    public PasswordStatus isValidPasswordWithAllCriteria(PasswordDTO passwordDTO) {
        String password = passwordDTO.getPassword();

        boolean isValidStatus = PasswordTermsMapper.isValid(password,
                Validation.ONE_LOWERCASE_LETTER,
                Validation.ONE_UPPERCASE_LETTER,
                Validation.NINE_CHARACTERS,
                Validation.ONE_SPECIAL_CHARACTER,
                Validation.REPEATING_CHARACTERS,
                Validation.SPACES);

        return PasswordStatus.builder()
                .isValid(isValidStatus)
                .build();
    }
}
