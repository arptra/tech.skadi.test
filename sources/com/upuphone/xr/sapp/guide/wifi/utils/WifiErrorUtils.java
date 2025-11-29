package com.upuphone.xr.sapp.guide.wifi.utils;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/guide/wifi/utils/WifiErrorUtils;", "", "<init>", "()V", "", "change", "", "errorCode", "b", "(Ljava/lang/String;I)Ljava/lang/String;", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WifiErrorUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f7100a = new Companion((DefaultConstructorMarker) null);
    public static final Lazy b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, WifiErrorUtils$Companion$instance$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/guide/wifi/utils/WifiErrorUtils$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/guide/wifi/utils/WifiErrorUtils;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/upuphone/xr/sapp/guide/wifi/utils/WifiErrorUtils;", "instance", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WifiErrorUtils a() {
            return (WifiErrorUtils) WifiErrorUtils.b.getValue();
        }

        public Companion() {
        }
    }

    public final String b(String str, int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WifiErrorUtils", "getErrorStr::error code is: " + i);
        String str2 = "";
        if (i != 1000) {
            switch (i) {
                case 12:
                    String string = GlobalExtKt.f().getString(R.string.connect_fail_please_retry);
                    Intrinsics.checkNotNull(string);
                    return string;
                case 13:
                    String string2 = GlobalExtKt.f().getString(R.string.disconnect_fail);
                    Intrinsics.checkNotNull(string2);
                    return string2;
                case 14:
                    String string3 = GlobalExtKt.f().getString(R.string.ignore_wifi_fail);
                    Intrinsics.checkNotNull(string3);
                    return string3;
                default:
                    return str2;
            }
        } else {
            if (Intrinsics.areEqual((Object) str, (Object) "0")) {
                str2 = GlobalExtKt.f().getString(R.string.connect_fail_please_retry);
            }
            Intrinsics.checkNotNull(str2);
            return str2;
        }
    }
}
