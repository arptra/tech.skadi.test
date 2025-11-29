package com.meizu.account.oauth;

import android.content.Intent;

public class MzAuthException extends Exception {
    private String accountName;
    private int code;
    private Intent mHandleIntent;

    public MzAuthException(Intent intent) {
        this.mHandleIntent = intent;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public int getCode() {
        return this.code;
    }

    public Intent getHandleIntent() {
        return this.mHandleIntent;
    }

    public String getMessage() {
        return this.mHandleIntent != null ? "intent need to be handled." : super.getMessage();
    }

    public MzAuthException(int i, String str) {
        super(str);
        this.code = i;
    }

    public MzAuthException(int i, String str, String str2) {
        super(str);
        this.code = i;
        this.accountName = str2;
    }

    public MzAuthException(int i, String str, Throwable th) {
        super(str, th);
        this.code = i;
    }
}
