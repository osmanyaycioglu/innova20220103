package com.training.innova.test.Labs.lab1.refactor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CamelToSnakeCache {

    private final Map<String, String>   cache = new ConcurrentHashMap<>();
    private final IStringCamelOperation camelOperation;


    public CamelToSnakeCache(final IStringCamelOperation camelOperationParam) {
        this.camelOperation = camelOperationParam;
    }

    public String converCamelToSnake(final String str) {
        String stringLoc = this.cache.get(str);
        if (stringLoc == null) {
            stringLoc = this.camelOperation.convert(str);
            this.cache.put(str,
                           stringLoc);
        }
        return stringLoc;
    }


    public String searchHistory(final String string) {
        return this.cache.get(string);
    }


}
