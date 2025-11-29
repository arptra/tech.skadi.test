package com.upuphone.xr.sapp.vu;

import androidx.lifecycle.Observer;
import com.upuphone.xr.sapp.entity.AccountInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/vu/VuGlassesActivity$listenLoginState$1", "Landroidx/lifecycle/Observer;", "Lcom/upuphone/xr/sapp/entity/AccountInfo;", "value", "", "a", "(Lcom/upuphone/xr/sapp/entity/AccountInfo;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuGlassesActivity$listenLoginState$1 implements Observer<AccountInfo> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuGlassesActivity f8028a;

    public VuGlassesActivity$listenLoginState$1(VuGlassesActivity vuGlassesActivity) {
        this.f8028a = vuGlassesActivity;
    }

    /* renamed from: a */
    public void onChanged(AccountInfo accountInfo) {
        if (accountInfo != null) {
            this.f8028a.m();
        } else {
            this.f8028a.B();
        }
    }
}
