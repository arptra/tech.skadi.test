package com.upuphone.xr.account.interfaces;

import android.content.Context;
import android.content.Intent;

public abstract class XJAbstractAuthenticator {
    public XJAbstractAuthenticator(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
    }

    public abstract void getMzAuthToken(Boolean bool, MzAuthListener mzAuthListener);

    public abstract void isSetPassword(XJPasswordListener xJPasswordListener);

    public abstract void logout();

    public abstract void showWxLogin(Boolean bool);

    public abstract Intent skipPasswordPageIntent();
}
