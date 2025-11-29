package com.airbnb.epoxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface EpoxyAttribute {

    public enum Option {
        NoGetter,
        NoSetter,
        DoNotHash,
        IgnoreRequireHashCode,
        DoNotUseInToString
    }
}
