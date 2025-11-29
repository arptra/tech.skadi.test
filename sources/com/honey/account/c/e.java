package com.honey.account.c;

import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.OnContextAvailableListener;

public final /* synthetic */ class e implements OnContextAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f3015a;

    public /* synthetic */ e(ComponentActivity componentActivity) {
        this.f3015a = componentActivity;
    }

    public final void onContextAvailable(Context context) {
        ComponentActivity.R(this.f3015a, context);
    }
}
