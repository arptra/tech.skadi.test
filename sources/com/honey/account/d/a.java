package com.honey.account.d;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class a implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivityResultRegistry f3045a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ActivityResultCallback c;
    public final /* synthetic */ ActivityResultContract d;

    public /* synthetic */ a(ActivityResultRegistry activityResultRegistry, String str, ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract) {
        this.f3045a = activityResultRegistry;
        this.b = str;
        this.c = activityResultCallback;
        this.d = activityResultContract;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ActivityResultRegistry.n(this.f3045a, this.b, this.c, this.d, lifecycleOwner, event);
    }
}
