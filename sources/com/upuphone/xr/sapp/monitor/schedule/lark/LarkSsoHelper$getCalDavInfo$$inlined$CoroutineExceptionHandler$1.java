package com.upuphone.xr.sapp.monitor.schedule.lark;

import android.app.Activity;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;

@SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n+ 2 LarkSsoHelper.kt\ncom/upuphone/xr/sapp/monitor/schedule/lark/LarkSsoHelper\n*L\n1#1,110:1\n82#2,3:111\n*E\n"})
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LarkSsoHelper$getCalDavInfo$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LarkSsoHelper f7788a;
    public final /* synthetic */ Activity b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LarkSsoHelper$getCalDavInfo$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key key, LarkSsoHelper larkSsoHelper, Activity activity) {
        super(key);
        this.f7788a = larkSsoHelper;
        this.b = activity;
    }

    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        String message = th.getMessage();
        ILog.i("Schedule-LarkSsoHelper", "数据获取异常：" + message);
        this.f7788a.h(this.b);
    }
}
