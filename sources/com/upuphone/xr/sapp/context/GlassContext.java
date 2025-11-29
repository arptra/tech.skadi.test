package com.upuphone.xr.sapp.context;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/sapp/context/GlassContext;", "", "", "d", "()Ljava/lang/String;", "", "isAir", "()Z", "isAirPro", "", "value", "", "f", "(I)V", "Landroidx/lifecycle/LiveData;", "c", "()Landroidx/lifecycle/LiveData;", "getPeerVersionData$annotations", "()V", "peerVersionData", "e", "()I", "getPeerVersionOrCache$annotations", "peerVersionOrCache", "Lcom/upuphone/xr/sapp/context/IGlassInfo;", "b", "glassInfoData", "a", "()Lcom/upuphone/xr/sapp/context/IGlassInfo;", "glassInfoOrCache", "lib_context_release"}, k = 1, mv = {1, 9, 0})
public interface GlassContext {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    IGlassInfo a();

    LiveData b();

    LiveData c();

    String d();

    int e();

    void f(int i);

    boolean isAir();

    boolean isAirPro();
}
