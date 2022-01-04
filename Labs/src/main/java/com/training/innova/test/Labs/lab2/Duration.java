package com.training.innova.test.Labs.lab2;


public class Duration {

    private long   value;
    private String string;

    public Duration() {
    }

    public Duration(final long valueParam) {
        super();
        this.value = valueParam;
    }


    public Duration(final long valueParam,
                    final String stringParam) {
        super();
        this.value = valueParam;
        this.string = stringParam;
    }

    public long getValue() {
        return this.value;
    }


    public void setValue(final long valueParam) {
        this.value = valueParam;
    }

    public int getIntValue() {
        return (int) this.value;
    }

    public String getStringValue() {
        return "" + this.value;
    }

    public String getString() {
        return this.string;
    }

    public void setString(final String stringParam) {
        this.string = stringParam;
    }

    @Override
    public String toString() {
        return "[(value=" + this.value + ")(string=" + this.string + ")]";
    }


}
