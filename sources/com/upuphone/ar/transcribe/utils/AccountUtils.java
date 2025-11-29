package com.upuphone.ar.transcribe.utils;

import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.xr.interconnect.entity.AccountInfo;
import com.upuphone.xr.sapp.context.SdkContext;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/transcribe/utils/AccountUtils;", "", "<init>", "()V", "Lcom/upuphone/xr/interconnect/entity/AccountInfo;", "b", "()Lcom/upuphone/xr/interconnect/entity/AccountInfo;", "", "a", "()Ljava/lang/String;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AccountUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final AccountUtils f6173a = new AccountUtils();

    public final String a() {
        AccountInfo b = b();
        if (b != null) {
            return b.id;
        }
        return null;
    }

    public final AccountInfo b() {
        String str;
        try {
            str = SdkContext.f6675a.b().a();
        } catch (Exception e) {
            String message = e.getMessage();
            LogExt.e("getAccountInfo exception: " + message, "AccountUtils");
            str = "";
        }
        if (!StringsKt.isBlank(str)) {
            return (AccountInfo) GsonUtils.a(str, AccountInfo.class);
        }
        LogExt.e("getAccountInfo accountInfo is null", "AccountUtils");
        return null;
    }
}
