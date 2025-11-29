package com.upuphone.xr.sapp.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/utils/PackageHelper$packageChange$mBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "p0", "Landroid/content/Context;", "p1", "Landroid/content/Intent;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PackageHelper$packageChange$mBroadcastReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PackageHelper f7906a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Function1 d;

    public PackageHelper$packageChange$mBroadcastReceiver$1(PackageHelper packageHelper, Context context, boolean z, Function1 function1) {
        this.f7906a = packageHelper;
        this.b = context;
        this.c = z;
        this.d = function1;
    }

    public void onReceive(Context context, Intent intent) {
        this.d.invoke(this.f7906a.e(this.b, this.c));
    }
}
