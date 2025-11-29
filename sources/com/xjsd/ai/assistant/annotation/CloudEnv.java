package com.xjsd.ai.assistant.annotation;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Keep
@Retention(RetentionPolicy.CLASS)
public @interface CloudEnv {
    public static final int DEV = 0;
    public static final int DEV_SA = 4;
    public static final int FAT = 1;
    public static final int FAT_SA = 5;
    public static final int PROD = 3;
    public static final int PROD_SA = 7;
    public static final int UAT = 2;
    public static final int UAT_SA = 6;
}
