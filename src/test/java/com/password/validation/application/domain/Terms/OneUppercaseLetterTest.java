package com.password.validation.application.domain.Terms;

import com.password.validation.application.domain.enumeration.Validation;
import com.password.validation.application.domain.mappers.PasswordTermsMapper;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class OneUppercaseLetterTest {

    static Stream<Arguments> passwordsAndExpectedOutputDataProvider() {
        return Stream.of(
                arguments("zxc12345678", false),
                arguments("123456789", false),
                arguments("aszs", false),
                arguments("!@#%zxc12354", false),
                arguments("!@", false),
                arguments("", false),
                arguments(" ", false),
                arguments("             ", false),
                arguments("AAAAAAAAA", true),
                arguments("!@%!@%!@Z%!*&(", true),
                arguments("ZZZZzZZZZZ", true),
                arguments("Pzxci", true)
        );
    }

    @ParameterizedTest
    @MethodSource("passwordsAndExpectedOutputDataProvider")
    void checkIfPasswordsHasAtLeastOneUppercaseLetterTest(String password, boolean expectedOutput) {
        boolean result = PasswordTermsMapper.isValid(password, Validation.ONE_UPPERCASE_LETTER);

        Assert.assertEquals(result, expectedOutput);
    }

}