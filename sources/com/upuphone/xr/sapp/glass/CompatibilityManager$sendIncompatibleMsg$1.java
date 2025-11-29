package com.upuphone.xr.sapp.glass;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/glass/CompatibilityManager$sendIncompatibleMsg$1", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "onFail", "", "p0", "", "p1", "", "onSuccess", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CompatibilityManager$sendIncompatibleMsg$1 extends SendMessageListener {
    public void onFail(@Nullable String str, int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassCompatHelper", "sendIncompatibleMsg-fail: " + str + ", " + i);
    }

    public void onSuccess(@Nullable String str) {
        ULog.f6446a.a("GlassCompatHelper", "sendIncompatibleMsg-success");
    }
}
