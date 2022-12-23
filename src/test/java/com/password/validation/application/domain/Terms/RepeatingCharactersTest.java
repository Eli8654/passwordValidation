package com.password.validation.application.domain.Terms;

import com.password.validation.application.domain.enumeration.Validation;
import com.password.validation.application.domain.mappers.PasswordTermsMapper;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class RepeatingCharactersTest {

    static Stream<Arguments> passwordsAndExpectedOutputDataProvider() {
        return Stream.of(
                arguments("ZXCvbn1235", true),
                arguments("aoplAz15", false),
                arguments("!zxpoM15!", false),
                arguments("kz18mK8+", false),
                arguments("123456789", true),
                arguments("12355678", false),
                arguments("zeP 159Z", false),
                arguments("", true),
                arguments(" ", true),
                arguments("zeP 159m", true)
        );
    }

    @ParameterizedTest
    @MethodSource("passwordsAndExpectedOutputDataProvider")
    void checkIfPasswordsHaveNonRepeatingCharactersTest(String password, boolean expectedOutput) {
        boolean result = PasswordTermsMapper.isValid(password, Validation.REPEATING_CHARACTERS);

        Assert.assertEquals(result, expectedOutput);
    }
}