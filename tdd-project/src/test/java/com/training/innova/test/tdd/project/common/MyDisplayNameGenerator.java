package com.training.innova.test.tdd.project.common;

import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;

public class MyDisplayNameGenerator extends ReplaceUnderscores {

    @Override
    public String generateDisplayNameForMethod(final Class<?> testClass,
                                               final Method testMethod) {
        String disLoc = testMethod.getName()
                                  .replace("_",
                                           "--->");
        MyGroup annotationLoc = testMethod.getAnnotation(MyGroup.class);
        if (annotationLoc == null) {
            annotationLoc = testClass.getAnnotation(MyGroup.class);
        }
        if (annotationLoc != null) {
            return annotationLoc.value() + " ---- " + this.camelToSnake(disLoc);
        }
        return this.camelToSnake(disLoc);
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
                result.append(" ");
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }


}
