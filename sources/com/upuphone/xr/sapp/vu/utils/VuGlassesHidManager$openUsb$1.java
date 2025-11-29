package com.upuphone.xr.sapp.vu.utils;

import android.hardware.usb.UsbDevice;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager", f = "VuGlassesHidManager.kt", i = {0, 0, 0}, l = {225}, m = "openUsb", n = {"usbDevice", "retryCount", "openResult"}, s = {"L$0", "I$0", "Z$0"})
public final class VuGlassesHidManager$openUsb$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VuGlassesHidManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesHidManager$openUsb$1(VuGlassesHidManager vuGlassesHidManager, Continuation<? super VuGlassesHidManager$openUsb$1> continuation) {
        super(continuation);
        this.this$0 = vuGlassesHidManager;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.s((UsbDevice) null, this);
    }
}
