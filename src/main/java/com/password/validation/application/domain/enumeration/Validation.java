package com.password.validation.application.domain.enumeration;

import com.password.validation.application.domain.interfaces.PasswordTermsInterface;
import com.password.validation.application.domain.Terms.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Validation {

    ONE_UPPERCASE_LETTER(new OneUppercaseLetter()),

    ONE_LOWERCASE_LETTER(new OneLowercaseLetter()),

    ONE_SPECIAL_CHARACTER(new OneSpecialCharacter()),

    NINE_CHARACTERS(new NineCharacters()),

    REPEATING_CHARACTERS(new RepeatingCharacters()),

    ONE_DIGIT(new OneDigit()),

    SPACES(new Spaces());

    private final PasswordTermsInterface passwordTermsInterface;

}
