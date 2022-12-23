package com.password.validation.application.domain.Terms;


import com.password.validation.application.domain.enumeration.Validation;
import com.password.validation.application.domain.mappers.PasswordTermsMapper;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class SpacesTest {

    static Stream<Arguments> passwordsAndExpectedOutputDataProvider() {
        return Stream.of(
                arguments(" ", false),
                arguments("", true),
                arguments("Aiushda 123!", false),
                arguments("asoid!Pajs%", true)
        );
    }

    @ParameterizedTest
    @MethodSource("passwordsAndExpectedOutputDataProvider")
    void checkIfPasswordsHaveNonSpacesTest(String password, boolean expectedOutput) {
        boolean result = PasswordTermsMapper.isValid(password, Validation.SPACES);

        Assert.assertEquals(result, expectedOutput);
    }
}