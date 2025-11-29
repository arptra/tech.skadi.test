package com.honey.account.v;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.fragment.app.FragmentActivity;

public final /* synthetic */ class f implements OnContextAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f3121a;

    public /* synthetic */ f(FragmentActivity fragmentActivity) {
        this.f3121a = fragmentActivity;
    }

    public final void onContextAvailable(Context context) {
        this.f3121a.i0(context);
    }
}
