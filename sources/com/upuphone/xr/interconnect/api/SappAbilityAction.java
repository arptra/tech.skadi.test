package com.upuphone.xr.interconnect.api;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Keep
@Retention(RetentionPolicy.CLASS)
public @interface SappAbilityAction {
    public static final String CLOSE = "CLOSE";
    public static final String OPEN = "open";
    public static final String STATE = "STATE";
}
