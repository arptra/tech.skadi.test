package com.xjmz.myvu.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/xjmz/myvu/location/LocationHelper$broadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LocationHelper$broadcastReceiver$1 extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ULog.Delegate delegate = ULog.f6446a;
        String action = intent.getAction();
        delegate.g("LocationHelper", "onReceive, action: " + action);
        if (Intrinsics.areEqual((Object) intent.getAction(), (Object) "android.location.PROVIDERS_CHANGED")) {
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.b(), (CoroutineContext) null, (CoroutineStart) null, new LocationHelper$broadcastReceiver$1$onReceive$1((Continuation<? super LocationHelper$broadcastReceiver$1$onReceive$1>) null), 3, (Object) null);
        }
    }
}
