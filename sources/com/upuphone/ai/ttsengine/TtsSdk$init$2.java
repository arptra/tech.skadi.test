package com.upuphone.ai.ttsengine;

import android.media.MediaRouter;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTtsSdk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TtsSdk.kt\ncom/upuphone/ai/ttsengine/TtsSdk$init$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,416:1\n1855#2,2:417\n*S KotlinDebug\n*F\n+ 1 TtsSdk.kt\ncom/upuphone/ai/ttsengine/TtsSdk$init$2\n*L\n169#1:417,2\n*E\n"})
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/upuphone/ai/ttsengine/TtsSdk$init$2", "Landroid/media/MediaRouter$SimpleCallback;", "onRouteSelected", "", "router", "Landroid/media/MediaRouter;", "type", "", "info", "Landroid/media/MediaRouter$RouteInfo;", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TtsSdk$init$2 extends MediaRouter.SimpleCallback {
    public void onRouteSelected(MediaRouter mediaRouter, int i, MediaRouter.RouteInfo routeInfo) {
        AILOG b = TtsSdk.b;
        b.c("onRouteSelected: " + routeInfo, new Object[0]);
        if (routeInfo == null || routeInfo.getDeviceType() != 3) {
            for (String u : TtsSdk.f) {
                TtsSdk.u(TtsSdk.f5490a, u, (String) null, 2, (Object) null);
            }
        }
    }
}
