package com.github.pakhomovalexandr;

public class ParseServiceImpl implements ParseService {
    private final NameParser nameParser;

    public ParseServiceImpl(NameParser nameParser) {this.nameParser = nameParser;}

    @Override
    public String parse(String firstAndSecondName) {
        return nameParser.parse(firstAndSecondName);
    }

    @Override
    public String hello(String firstAndSecondName) {
        String secondName = parse(firstAndSecondName);

        return "Hello, " + secondName + "!";
    }


}
