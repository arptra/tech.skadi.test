package com.xjsd.ai.assistant.annotation;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Keep
@Retention(RetentionPolicy.CLASS)
public @interface TtsOverNextStep {
    public static final int STEP_CUSTOM = 3;
    public static final int STEP_EXIT_NOW = 1;
    public static final int STEP_EXIT_OPTIONAL = 0;
    public static final int STEP_WAKEUP = 2;
}
