package com.upuphone.xr.interconnect.api;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Keep
@Retention(RetentionPolicy.CLASS)
public @interface SappAbilityType {
    public static final String AR_CARD = "AR_CARD";
    public static final String AR_LIFE = "AR_LIFE";
    public static final String AR_MEDIA = "AR_MEDIA_DOU_YIN";
    public static final String NAVI = "NAVIGATION";
    public static final String NOT_DISTURB = "NOT_DISTURB";
    public static final String SHOW_AI_MODEL = "SHOW_AI_MODEL";
    public static final String TRANSLATION = "TRANSLATION";
}
