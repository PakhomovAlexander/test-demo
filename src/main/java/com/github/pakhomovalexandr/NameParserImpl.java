package com.github.pakhomovalexandr;

public class NameParserImpl implements NameParser {
    public String parse(String input) {
        if (input == null) {
            return null;
        }

        String[] array = input.trim().split("\\W+");

        if (array.length < 2) {
            return "";
        }

        return array[1];
    }
}
