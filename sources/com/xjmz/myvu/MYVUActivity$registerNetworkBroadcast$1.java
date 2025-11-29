package com.xjmz.myvu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.assistant.LlmProtocolStateDelegate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/xjmz/myvu/MYVUActivity$registerNetworkBroadcast$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "p0", "Landroid/content/Context;", "p1", "Landroid/content/Intent;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MYVUActivity$registerNetworkBroadcast$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MYVUActivity f8213a;

    public MYVUActivity$registerNetworkBroadcast$1(MYVUActivity mYVUActivity) {
        this.f8213a = mYVUActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (Intrinsics.areEqual((Object) "android.net.conn.CONNECTIVITY_CHANGE", (Object) intent != null ? intent.getAction() : null)) {
            Object systemService = this.f8213a.getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                MYVUActivity mYVUActivity = this.f8213a;
                if (activeNetworkInfo.isConnected()) {
                    ULog.f6446a.g("MYVUActivity", "the network is access");
                    Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(mYVUActivity), Dispatchers.b(), (CoroutineStart) null, new MYVUActivity$registerNetworkBroadcast$1$onReceive$1$1((Continuation<? super MYVUActivity$registerNetworkBroadcast$1$onReceive$1$1>) null), 2, (Object) null);
                    new LlmProtocolStateDelegate().u();
                    mYVUActivity.c1();
                }
            }
        }
    }
}
