package com.training.innova.test.tdd.project.database;


public class MyMockTest {


    public String hello() {
        return "hello";
    }

    public String helloExt(final String name) {
        return "hello " + name;
    }

    public String greet() {
        return "greetings";
    }

    public String help() {
        try {
            Thread.sleep(100);
        } catch (Exception eLoc) {
        }
        return "help";
    }


}
