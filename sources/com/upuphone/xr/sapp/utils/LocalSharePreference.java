package com.upuphone.xr.sapp.utils;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/sapp/utils/LocalSharePreference;", "", "<init>", "()V", "", "key", "", "c", "(Ljava/lang/String;)V", "Landroid/content/SharedPreferences;", "a", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences$Editor;", "b", "()Landroid/content/SharedPreferences$Editor;", "editor", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LocalSharePreference {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);
    public static final Lazy c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, LocalSharePreference$Companion$instance$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f7896a;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/utils/LocalSharePreference$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/utils/LocalSharePreference;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/upuphone/xr/sapp/utils/LocalSharePreference;", "instance", "", "ACTION_IOT_PREFERENCE_CHANGED", "Ljava/lang/String;", "KEY_INTERNATIONAL_PRIVACY_OUT_DATE", "PREFERENCE_KEY", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocalSharePreference a() {
            return (LocalSharePreference) LocalSharePreference.c.getValue();
        }

        public Companion() {
        }
    }

    public LocalSharePreference() {
        SharedPreferences sharedPreferences = GlobalExtKt.f().getSharedPreferences("mv-iot", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.f7896a = sharedPreferences;
    }

    public final SharedPreferences.Editor b() {
        SharedPreferences.Editor edit = this.f7896a.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "edit(...)");
        return edit;
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(com.upuphone.starrynet.common.LocalSharePreference.ACTION_IOT_PREFERENCE_CHANGED);
            intent.putExtra(com.upuphone.starrynet.common.LocalSharePreference.PREFERENCE_KEY, str);
            LocalBroadcastManager.b(GlobalExtKt.f()).d(intent);
        }
    }
}
