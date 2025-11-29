package com.upuphone.xr.sapp.utils;

import android.os.SystemClock;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/sapp/utils/ViewDebounceClickListener;", "Landroid/view/View$OnClickListener;", "", "interval", "listener", "<init>", "(JLandroid/view/View$OnClickListener;)V", "Landroid/view/View;", "v", "", "onClick", "(Landroid/view/View;)V", "a", "J", "b", "Landroid/view/View$OnClickListener;", "c", "clickTime", "lib_common_release"}, k = 1, mv = {1, 9, 0})
public final class ViewDebounceClickListener implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final long f7931a;
    public final View.OnClickListener b;
    public long c = SystemClock.elapsedRealtime();

    public ViewDebounceClickListener(long j, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f7931a = j;
        this.b = onClickListener;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.c > this.f7931a) {
            this.c = elapsedRealtime;
            this.b.onClick(view);
        }
    }
}
