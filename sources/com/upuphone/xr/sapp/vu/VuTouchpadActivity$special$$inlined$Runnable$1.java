package com.upuphone.xr.sapp.vu;

import android.view.WindowManager;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 VuTouchpadActivity.kt\ncom/upuphone/xr/sapp/vu/VuTouchpadActivity\n*L\n1#1,18:1\n817#2,5:19\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuTouchpadActivity$special$$inlined$Runnable$1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuTouchpadActivity f8033a;

    public VuTouchpadActivity$special$$inlined$Runnable$1(VuTouchpadActivity vuTouchpadActivity) {
        this.f8033a = vuTouchpadActivity;
    }

    public final void run() {
        ULog.f6446a.a("VuTouchpadActivity", "dim screen");
        WindowManager.LayoutParams attributes = this.f8033a.getWindow().getAttributes();
        attributes.screenBrightness = 0.01f;
        this.f8033a.getWindow().setAttributes(attributes);
    }
}
