package com.upuphone.xr.sapp.unicron;

import com.upuphone.xr.sapp.context.RingContext;
import com.upuphone.xr.sapp.entity.UnicronInfo;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.VersionExtKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/unicron/RingContextImpl;", "Lcom/upuphone/xr/sapp/context/RingContext;", "<init>", "()V", "", "a", "()Ljava/lang/Boolean;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class RingContextImpl implements RingContext {

    /* renamed from: a  reason: collision with root package name */
    public static final RingContextImpl f7830a = new RingContextImpl();

    public Boolean a() {
        String version;
        UnicronInfo q = ControlUtils.f7858a.q();
        if (q == null || (version = q.getVersion()) == null || version.length() == 0) {
            return null;
        }
        return Boolean.valueOf(VersionExtKt.a(q.getVersion(), "0.1.0.46") >= 0);
    }
}
