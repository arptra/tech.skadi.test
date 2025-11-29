package com.upuphone.xr.sapp.context;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u001d¢\u0006\u0004\b!\u0010\"J\r\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020#¢\u0006\u0004\b'\u0010(J\r\u0010*\u001a\u00020)¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020)¢\u0006\u0004\b-\u0010.R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X.¢\u0006\u0006\n\u0004\b!\u0010/R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000f\u00100R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\t\u00101R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u00102R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b*\u00103R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0015\u00104R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001f\u00105¨\u00066"}, d2 = {"Lcom/upuphone/xr/sapp/context/SdkContext;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/context/DataTrackContext;", "dataTrackContext", "", "k", "(Lcom/upuphone/xr/sapp/context/DataTrackContext;)V", "d", "()Lcom/upuphone/xr/sapp/context/DataTrackContext;", "Lcom/upuphone/xr/sapp/context/AppContext;", "appContext", "i", "(Lcom/upuphone/xr/sapp/context/AppContext;)V", "c", "()Lcom/upuphone/xr/sapp/context/AppContext;", "Lcom/upuphone/xr/sapp/context/RingContext;", "ringContext", "n", "(Lcom/upuphone/xr/sapp/context/RingContext;)V", "g", "()Lcom/upuphone/xr/sapp/context/RingContext;", "Lcom/upuphone/xr/sapp/context/GlassContext;", "glassContext", "l", "(Lcom/upuphone/xr/sapp/context/GlassContext;)V", "e", "()Lcom/upuphone/xr/sapp/context/GlassContext;", "Lcom/upuphone/xr/sapp/context/AccountContext;", "accountContext", "h", "(Lcom/upuphone/xr/sapp/context/AccountContext;)V", "b", "()Lcom/upuphone/xr/sapp/context/AccountContext;", "Lcom/upuphone/xr/sapp/context/DataStoreContext;", "a", "()Lcom/upuphone/xr/sapp/context/DataStoreContext;", "dataStoreContext", "j", "(Lcom/upuphone/xr/sapp/context/DataStoreContext;)V", "Lcom/upuphone/xr/sapp/context/PermissionContext;", "f", "()Lcom/upuphone/xr/sapp/context/PermissionContext;", "permissionContext", "m", "(Lcom/upuphone/xr/sapp/context/PermissionContext;)V", "Lcom/upuphone/xr/sapp/context/DataTrackContext;", "Lcom/upuphone/xr/sapp/context/AppContext;", "Lcom/upuphone/xr/sapp/context/RingContext;", "Lcom/upuphone/xr/sapp/context/GlassContext;", "Lcom/upuphone/xr/sapp/context/DataStoreContext;", "Lcom/upuphone/xr/sapp/context/PermissionContext;", "Lcom/upuphone/xr/sapp/context/AccountContext;", "lib_context_release"}, k = 1, mv = {1, 9, 0})
public final class SdkContext {

    /* renamed from: a  reason: collision with root package name */
    public static final SdkContext f6675a = new SdkContext();
    public static DataTrackContext b;
    public static AppContext c;
    public static RingContext d;
    public static GlassContext e;
    public static DataStoreContext f;
    public static PermissionContext g;
    public static AccountContext h;

    public final DataStoreContext a() {
        DataStoreContext dataStoreContext = f;
        if (dataStoreContext != null) {
            return dataStoreContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dataStoreContext");
        return null;
    }

    public final AccountContext b() {
        AccountContext accountContext = h;
        if (accountContext != null) {
            return accountContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("accountContext");
        return null;
    }

    public final AppContext c() {
        AppContext appContext = c;
        if (appContext != null) {
            return appContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
        return null;
    }

    public final DataTrackContext d() {
        DataTrackContext dataTrackContext = b;
        if (dataTrackContext != null) {
            return dataTrackContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dataTrackContext");
        return null;
    }

    public final GlassContext e() {
        GlassContext glassContext = e;
        if (glassContext != null) {
            return glassContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("glassContext");
        return null;
    }

    public final PermissionContext f() {
        PermissionContext permissionContext = g;
        if (permissionContext != null) {
            return permissionContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("permissionContext");
        return null;
    }

    public final RingContext g() {
        RingContext ringContext = d;
        if (ringContext != null) {
            return ringContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ringContext");
        return null;
    }

    public final void h(AccountContext accountContext) {
        Intrinsics.checkNotNullParameter(accountContext, "accountContext");
        h = accountContext;
    }

    public final void i(AppContext appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        c = appContext;
    }

    public final void j(DataStoreContext dataStoreContext) {
        Intrinsics.checkNotNullParameter(dataStoreContext, "dataStoreContext");
        f = dataStoreContext;
    }

    public final void k(DataTrackContext dataTrackContext) {
        Intrinsics.checkNotNullParameter(dataTrackContext, "dataTrackContext");
        b = dataTrackContext;
    }

    public final void l(GlassContext glassContext) {
        Intrinsics.checkNotNullParameter(glassContext, "glassContext");
        e = glassContext;
    }

    public final void m(PermissionContext permissionContext) {
        Intrinsics.checkNotNullParameter(permissionContext, "permissionContext");
        g = permissionContext;
    }

    public final void n(RingContext ringContext) {
        Intrinsics.checkNotNullParameter(ringContext, "ringContext");
        d = ringContext;
    }
}
