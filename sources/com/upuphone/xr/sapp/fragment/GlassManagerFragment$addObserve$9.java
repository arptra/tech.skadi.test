package com.upuphone.xr.sapp.fragment;

import androidx.activity.OnBackPressedCallback;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.view.GenericMenuView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/upuphone/xr/sapp/fragment/GlassManagerFragment$addObserve$9", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassManagerFragment$addObserve$9 extends OnBackPressedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlassManagerFragment f6962a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassManagerFragment$addObserve$9(GlassManagerFragment glassManagerFragment) {
        super(true);
        this.f6962a = glassManagerFragment;
    }

    public void handleOnBackPressed() {
        ULog.Delegate delegate = ULog.f6446a;
        boolean Z0 = this.f6962a.o;
        delegate.g("GlassManagerFragment", "handleOnBackPressed==>> isExistScreenOffView:" + Z0);
        if (this.f6962a.o) {
            this.f6962a.o = false;
            GenericMenuView X0 = this.f6962a.n;
            if (X0 != null) {
                X0.d();
                return;
            }
            return;
        }
        StaticMethodUtilsKt.q(this.f6962a);
    }
}
