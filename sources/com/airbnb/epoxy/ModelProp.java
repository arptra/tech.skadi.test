package com.airbnb.epoxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface ModelProp {

    public enum Option {
        DoNotHash,
        IgnoreRequireHashCode,
        GenerateStringOverloads,
        NullOnRecycle
    }
}
