package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

final class Java8Usage {

    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SomeTypeAnnotation {
    }

    private Java8Usage() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$performCheck$0() {
    }

    @CanIgnoreReturnValue
    public static String performCheck() {
        new a().run();
        return "";
    }
}
