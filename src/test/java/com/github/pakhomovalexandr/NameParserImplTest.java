package com.github.pakhomovalexandr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.*;

class NameParserImplTest {

    NameParserImpl parser;

    @BeforeEach
    void setUp() {
        parser = new NameParserImpl();
    }

    @ParameterizedTest
    @MethodSource("provider")
    void test(String firstAndSecondName, String expected) {
        String secondName = parser.parse(firstAndSecondName);
        assertThat(secondName).isEqualTo(expected);
    }

    private static Stream<Arguments> provider() {
        return Stream.of(
                of("Alexander Pakhomov" , "Pakhomov"),
                of("", ""),
                of("Vasya  Pypkin", "Pypkin"),
                of("  Vasya  Pypkin    ", "Pypkin"),
                of("Alx Pkmv.", "Pkmv"),
                of("Alx Pkmv!!", "Pkmv"),
                of("A P", "P"),
                of(null, null)
        );
    }
}