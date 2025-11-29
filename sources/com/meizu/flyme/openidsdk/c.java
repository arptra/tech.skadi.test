package com.meizu.flyme.openidsdk;

import android.text.TextUtils;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f3146a;
    public String b;
    public boolean c;

    public c(String str, boolean z) {
        String str2;
        boolean z2 = !TextUtils.isEmpty(str);
        this.c = z2;
        if (z2) {
            if (z) {
                this.f3146a = "com.meizu.flyme.openid.permission.SECURESERVICE_OPEN_ID_CHANGE";
                str2 = "content://com.flyme.secureservice.openidsdk/";
            } else {
                this.f3146a = "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE";
                str2 = "content://com.meizu.flyme.openidsdk/";
            }
            this.b = str2;
        }
    }
}
