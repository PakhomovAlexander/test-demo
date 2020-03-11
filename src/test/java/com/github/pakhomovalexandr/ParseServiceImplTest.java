package com.github.pakhomovalexandr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.management.MXBean;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

class ParseServiceImplTest {

    ParseServiceImpl service;

    NameParser nameParser;

    @BeforeEach
    void setUp() {
        nameParser = mock(NameParser.class);
        when(nameParser.parse(eq("Alexander Pakhomov"))).thenReturn("Pakhomov");

        service = new ParseServiceImpl(nameParser);
    }

    @ParameterizedTest
    @MethodSource("provider")
    void parse(String firstAndSecondName, String expectedSecondName) {
        String actualSecondName = service.parse(firstAndSecondName);
        assertThat(actualSecondName).isEqualTo(expectedSecondName);
    }

    @ParameterizedTest
    @MethodSource("providerGreeting")
    void greetingTest(String firstAndSecondName, String expectedSecondName) {
        String actualSecondName = service.hello(firstAndSecondName);
        assertThat(actualSecondName).isEqualTo(expectedSecondName);
    }

    private static Stream<Arguments> providerGreeting() {
        return Stream.of(
                of("Alexander Pakhomov" , "Hello, Pakhomov!")
        );
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                of("Alexander Pakhomov" , "Pakhomov")
        );
    }
}