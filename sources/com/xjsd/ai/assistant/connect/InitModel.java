package com.xjsd.ai.assistant.connect;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Keep
@Retention(RetentionPolicy.CLASS)
public @interface InitModel {
    public static final int APP = 0;
    public static final int MODULE = 1;
    public static final int MODULE_ALONE = 2;
}
