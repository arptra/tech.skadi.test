package com.xjmz.myvu;

import android.view.View;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/xjmz/myvu/MYVUActivity$getNavigationBarHeight$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MYVUActivity$getNavigationBarHeight$1 implements View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MYVUActivity f8212a;
    public final /* synthetic */ View b;

    public MYVUActivity$getNavigationBarHeight$1(MYVUActivity mYVUActivity, View view) {
        this.f8212a = mYVUActivity;
        this.b = view;
    }

    public void onViewAttachedToWindow(View view) {
        Intrinsics.checkNotNullParameter(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
        int unused = this.f8212a.N0(this.b);
    }

    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkNotNullParameter(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
    }
}
