package com.upuphone.xr.sapp.vu;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnPreDraw$1\n+ 2 VuTouchpadActivity.kt\ncom/upuphone/xr/sapp/vu/VuTouchpadActivity\n*L\n1#1,414:1\n306#2,7:415\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/core/view/ViewKt$doOnPreDraw$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuTouchpadActivity$onArSpaceOpened$$inlined$doOnPreDraw$1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f8032a;
    public final /* synthetic */ VuTouchpadActivity b;

    public VuTouchpadActivity$onArSpaceOpened$$inlined$doOnPreDraw$1(View view, VuTouchpadActivity vuTouchpadActivity) {
        this.f8032a = view;
        this.b = vuTouchpadActivity;
    }

    public final void run() {
        this.b.G1(false);
        new Handler(Looper.getMainLooper()).postDelayed(new VuTouchpadActivity$onArSpaceOpened$1$1(this.b), 3000);
    }
}
