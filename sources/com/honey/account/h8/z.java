package com.honey.account.h8;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.upuphone.xr.sapp.fragment.AboutSuperAppFragment;

public final /* synthetic */ class z implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f4826a;
    public final /* synthetic */ LifecycleCoroutineScope b;

    public /* synthetic */ z(Activity activity, LifecycleCoroutineScope lifecycleCoroutineScope) {
        this.f4826a = activity;
        this.b = lifecycleCoroutineScope;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AboutSuperAppFragment.Companion.l(this.f4826a, this.b, dialogInterface, i);
    }
}
