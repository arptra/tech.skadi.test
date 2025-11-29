package com.xjsd.ai.assistant.protocol.stks;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class HotWordControl {
    public static final int FEEDBACK = 2;
    public static final int NOTIFY_SYNC_HOT_WORD = 4;
    public static final int OFFLINE_KEY = 3;
    public static final int REGISTER = 0;
    public static final int UNREGISTER = 1;
    @Control
    private int control;
    private String data;
    private boolean isOffline = false;
    private String packageName;

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    @Keep
    @Retention(RetentionPolicy.CLASS)
    public @interface Control {
    }

    @Control
    public int getControl() {
        return this.control;
    }

    public String getData() {
        return this.data;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public boolean isOffline() {
        return this.isOffline;
    }

    public void setControl(@Control int i) {
        this.control = i;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setOffline(boolean z) {
        this.isOffline = z;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }
}
