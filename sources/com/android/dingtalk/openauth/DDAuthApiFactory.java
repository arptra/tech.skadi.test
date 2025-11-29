package com.android.dingtalk.openauth;

import android.content.Context;

public class DDAuthApiFactory {
    public static IDDAuthApi createDDAuthApi(Context context, AuthLoginParam authLoginParam) {
        return new DDAuthApi(context, authLoginParam);
    }
}
