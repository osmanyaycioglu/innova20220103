package com.training.innova.test.Labs.lab1.refactor;


public class StringCamelAdvanced implements IStringCamelOperation {


    private final String sep;

    public StringCamelAdvanced(final String sep) {
        this.sep = sep;
    }

    @Override
    public String convert(final String str) {
        if (str == null) {
            return "nil";
        }
        if (str.length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder(str.length() + 10);
        char c = str.charAt(0);
        result.append(Character.toLowerCase(c));
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                result.append(this.sep);
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
