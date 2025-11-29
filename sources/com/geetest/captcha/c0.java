package com.geetest.captcha;

public enum c0 {
    AUTO(0),
    NORMAL(1),
    DARK(2);
    
    public int value;

    /* access modifiers changed from: public */
    c0(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int i) {
        this.value = i;
    }
}
