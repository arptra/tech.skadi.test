package com.airbnb.epoxy;

public class IllegalEpoxyUsage extends RuntimeException {
    public IllegalEpoxyUsage(String str) {
        super(str);
    }
}
