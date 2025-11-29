package com.geetest.captcha;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.upuphone.starrynet.common.StarryNetConstant;
import com.zx.sdk.api.PermissionCallback;
import com.zx.sdk.api.ZXManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/geetest/captcha/utils/ZxIdUtils;", "", "()V", "TAG", "", "get", "", "context", "Landroid/content/Context;", "getZxID", "isZxIDAvailable", "", "start", "captcha_release"}, k = 1, mv = {1, 4, 1})
public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    public static final k0 f2865a = new k0();

    public static final class a implements PermissionCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f2866a;

        public a(Context context) {
            this.f2866a = context;
        }
    }

    public final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Class.forName("com.zx.sdk.api.ZXManager");
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("gt_zid_sp", 0);
                String string = sharedPreferences.getString("gt_zid", (String) null);
                long j = sharedPreferences.getLong("gt_zid_et", 0);
                if (string == null || !(!StringsKt.isBlank(string)) || j <= 0) {
                    b(context);
                    return StarryNetConstant.DEVICE_NAME_UNKNOWN;
                }
                if (j - System.currentTimeMillis() < ((long) 86400000)) {
                    b(context);
                }
                return string;
            } catch (Exception e) {
                e.printStackTrace();
                return StarryNetConstant.DEVICE_NAME_UNKNOWN;
            }
        } catch (Exception unused) {
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        }
    }

    public final void b(Context context) {
        ZXManager.init(context);
        ZXManager.setDebug(false);
        ZXManager.setEnable(true);
        ZXManager.allowPermissionDialog(false);
        if (context != null) {
            ZXManager.checkPermission((Activity) context, new a(context));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
}
