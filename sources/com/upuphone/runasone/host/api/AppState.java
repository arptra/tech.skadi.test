package com.upuphone.runasone.host.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface AppState {
    public static final int STATE_DIED = 0;
    public static final int STATE_RUNNING = 1;
}
