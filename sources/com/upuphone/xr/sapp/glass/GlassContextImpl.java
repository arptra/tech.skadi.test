package com.upuphone.xr.sapp.glass;

import androidx.lifecycle.LiveData;
import com.upuphone.xr.sapp.context.GlassContext;
import com.upuphone.xr.sapp.context.IGlassInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00168VX\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001e\u001a\u00020\u000b8VX\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0018R\u0016\u0010#\u001a\u0004\u0018\u00010\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassContextImpl;", "Lcom/upuphone/xr/sapp/context/GlassContext;", "<init>", "()V", "", "d", "()Ljava/lang/String;", "", "isAir", "()Z", "isAirPro", "", "value", "", "f", "(I)V", "Lcom/upuphone/xr/sapp/glass/GlassContextDelegate;", "b", "Lkotlin/Lazy;", "g", "()Lcom/upuphone/xr/sapp/glass/GlassContextDelegate;", "glassContextDelegate", "Landroidx/lifecycle/LiveData;", "c", "()Landroidx/lifecycle/LiveData;", "getPeerVersionData$annotations", "peerVersionData", "e", "()I", "getPeerVersionOrCache$annotations", "peerVersionOrCache", "Lcom/upuphone/xr/sapp/context/IGlassInfo;", "glassInfoData", "a", "()Lcom/upuphone/xr/sapp/context/IGlassInfo;", "glassInfoOrCache", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GlassContextImpl implements GlassContext {

    /* renamed from: a  reason: collision with root package name */
    public static final GlassContextImpl f7047a = new GlassContextImpl();
    public static final Lazy b = LazyKt.lazy(GlassContextImpl$glassContextDelegate$2.INSTANCE);

    public IGlassInfo a() {
        return g().a();
    }

    public LiveData b() {
        return g().b();
    }

    public LiveData c() {
        return g().c();
    }

    public String d() {
        return g().d();
    }

    public int e() {
        return g().e();
    }

    public void f(int i) {
        g().f(i);
    }

    public final GlassContextDelegate g() {
        return (GlassContextDelegate) b.getValue();
    }

    public boolean isAir() {
        return g().isAir();
    }

    public boolean isAirPro() {
        return g().isAirPro();
    }
}
