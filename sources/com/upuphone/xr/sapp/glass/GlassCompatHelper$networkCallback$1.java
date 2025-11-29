package com.upuphone.xr.sapp.glass;

import android.net.ConnectivityManager;
import android.net.Network;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nGlassCompatHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassCompatHelper.kt\ncom/upuphone/xr/sapp/glass/GlassCompatHelper$networkCallback$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,275:1\n1855#2,2:276\n*S KotlinDebug\n*F\n+ 1 GlassCompatHelper.kt\ncom/upuphone/xr/sapp/glass/GlassCompatHelper$networkCallback$1\n*L\n55#1:276,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/glass/GlassCompatHelper$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassCompatHelper$networkCallback$1 extends ConnectivityManager.NetworkCallback {
    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassCompatHelper", "NetworkCallback-onAvailable: " + network);
        for (Runnable run : GlassCompatHelper.f) {
            run.run();
        }
        GlassCompatHelper.f.clear();
    }

    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassCompatHelper", "NetworkCallback-onLost: " + network);
    }
}
