package com.xjmz.myvu.flutter;

import android.os.Bundle;
import com.xjmz.myvu.flutter.base.BaseFlutterFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/xjmz/myvu/flutter/FlutterRouteFragment;", "Lcom/xjmz/myvu/flutter/base/BaseFlutterFragment;", "<init>", "()V", "", "getInitialRoute", "()Ljava/lang/String;", "f", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FlutterRouteFragment extends BaseFlutterFragment {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/xjmz/myvu/flutter/FlutterRouteFragment$Companion;", "", "<init>", "()V", "", "initialRoute", "Landroid/os/Bundle;", "a", "(Ljava/lang/String;)Landroid/os/Bundle;", "KEY_INITIAL_ROUTE", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(String str) {
            Intrinsics.checkNotNullParameter(str, "initialRoute");
            Bundle bundle = new Bundle();
            bundle.putString("key_init_route", str);
            return bundle;
        }

        public Companion() {
        }
    }

    public String getInitialRoute() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getString("key_init_route");
        }
        return null;
    }
}
