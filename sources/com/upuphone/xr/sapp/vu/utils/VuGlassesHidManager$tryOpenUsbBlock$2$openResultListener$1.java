package com.upuphone.xr.sapp.vu.utils;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "result", "", "b", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
public final class VuGlassesHidManager$tryOpenUsbBlock$2$openResultListener$1 implements VuGlassesHidManager.UsbOpenResultListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f8103a;

    public VuGlassesHidManager$tryOpenUsbBlock$2$openResultListener$1(CancellableContinuation cancellableContinuation) {
        this.f8103a = cancellableContinuation;
    }

    public final Object b(boolean z, Continuation continuation) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassesHidManager", "tryOpenUsbBlock: result: " + z);
        if (this.f8103a.isActive()) {
            this.f8103a.resumeWith(Result.m20constructorimpl(Boxing.boxBoolean(z)));
        }
        return Unit.INSTANCE;
    }
}
