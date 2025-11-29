package com.ss.android.larksso;

public enum SSOErrorType {
    BAD_STATE("-1"),
    NO_VALID_CODE("-2"),
    CANCELLED("-3"),
    CAN_NOT_JUMP_TO_LARK("-4"),
    AUTH_FAILED("-5"),
    PARAMETER_ERROR("-6");
    

    /* renamed from: a  reason: collision with root package name */
    public String f10011a;

    /* access modifiers changed from: public */
    SSOErrorType(String str) {
        this.f10011a = str;
    }
}
