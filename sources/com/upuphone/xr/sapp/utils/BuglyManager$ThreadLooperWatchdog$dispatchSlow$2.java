package com.upuphone.xr.sapp.utils;

import android.util.Printer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/sapp/utils/BuglyManager$ThreadLooperWatchdog$dispatchSlow$2", "Landroid/util/Printer;", "println", "", "str", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BuglyManager$ThreadLooperWatchdog$dispatchSlow$2 implements Printer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f7852a;
    public final /* synthetic */ StringBuilder b;

    public BuglyManager$ThreadLooperWatchdog$dispatchSlow$2(Ref.IntRef intRef, StringBuilder sb) {
        this.f7852a = intRef;
        this.b = sb;
    }

    public void println(String str) {
        if (this.f7852a.element <= 70) {
            StringBuilder sb = this.b;
            sb.append(str);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(10);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        }
        this.f7852a.element++;
    }
}
