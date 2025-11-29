package com.xingin.xhssharesdk.o;

import com.android.dingtalk.openauth.web.AuthWebviewActivity;
import com.upuphone.runasone.api.ApiConstant;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import java.util.HashMap;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f8195a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public a(String str, String str2, String str3, String str4, String str5) {
        this.c = str;
        this.f8195a = str2;
        this.e = str3;
        this.d = str4;
        this.b = str5;
    }

    public final void a(HashMap hashMap) {
        String md5 = XhsShareSdkTools.md5(this.f8195a + this.c + this.b);
        hashMap.put("app_package", this.f8195a);
        hashMap.put("timestamp", this.b);
        hashMap.put(ApiConstant.KEY_TOKEN, md5);
        hashMap.put(AuthWebviewActivity.m, this.d);
        hashMap.put("app_version", this.e);
    }
}
