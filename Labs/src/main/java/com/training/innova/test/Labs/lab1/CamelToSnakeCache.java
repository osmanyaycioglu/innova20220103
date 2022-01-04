package com.training.innova.test.Labs.lab1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CamelToSnakeCache {

    private final Map<String, String> cache = new ConcurrentHashMap<>();

    public String converCamelToSnake(final String str) {
        String stringLoc = this.cache.get(str);
        if (stringLoc == null) {
            stringLoc = this.camelToSnake(str);
            this.cache.put(str,
                           stringLoc);
        }
        return stringLoc;
    }


    public String searchHistory(final String string) {
        return this.cache.get(string);
    }

    public String camelToSnake(final String str) {
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
                result.append("-");
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }


}
