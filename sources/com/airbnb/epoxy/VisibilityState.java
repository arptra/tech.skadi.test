package com.airbnb.epoxy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class VisibilityState {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Visibility {
    }
}
