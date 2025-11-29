package com.upuphone.xr.sapp.vu;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuTouchpadActivity$onArSpaceOpened$1$1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuTouchpadActivity f8036a;

    public VuTouchpadActivity$onArSpaceOpened$1$1(VuTouchpadActivity vuTouchpadActivity) {
        this.f8036a = vuTouchpadActivity;
    }

    public final void run() {
        if (!this.f8036a.isDestroyed() && !this.f8036a.isFinishing()) {
            this.f8036a.g1();
        }
    }
}
