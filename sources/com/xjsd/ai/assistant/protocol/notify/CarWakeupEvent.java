package com.xjsd.ai.assistant.protocol.notify;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class CarWakeupEvent {
    public static final int TYPE_CONNECT = 0;
    public static final int TYPE_WAKEUP = 1;
    private boolean state;
    private int type;

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface NotifyType {
    }

    public CarWakeupEvent(int i, boolean z) {
        this.type = i;
        this.state = z;
    }

    public int getType() {
        return this.type;
    }

    public boolean isState() {
        return this.state;
    }

    public void setState(boolean z) {
        this.state = z;
    }

    public void setType(int i) {
        this.type = i;
    }
}
