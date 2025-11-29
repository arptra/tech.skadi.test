package com.upuphone.ai.ttsengine.flavor.service;

import com.upuphone.ai.ttsengine.base.utils.AILOG;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;

@SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n+ 2 LicenceSender.kt\ncom/upuphone/ai/ttsengine/flavor/service/LicenceSender\n*L\n1#1,110:1\n37#2,3:111\n*E\n"})
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LicenceSender$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LicenceSender f5561a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LicenceSender$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key key, LicenceSender licenceSender) {
        super(key);
        this.f5561a = licenceSender;
    }

    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        AILOG d = this.f5561a.c;
        d.h("error: " + th, new Object[0]);
        this.f5561a.f = false;
    }
}
