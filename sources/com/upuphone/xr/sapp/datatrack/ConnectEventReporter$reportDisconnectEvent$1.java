package com.upuphone.xr.sapp.datatrack;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.datatrack.ConnectEventReporter;
import com.upuphone.xr.sapp.monitor.GlassWearStateMonitor;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.datatrack.ConnectEventReporter$reportDisconnectEvent$1", f = "ConnectEventReporter.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
public final class ConnectEventReporter$reportDisconnectEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ConnectEventReporter$reportDisconnectEvent$1(Continuation<? super ConnectEventReporter$reportDisconnectEvent$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ConnectEventReporter$reportDisconnectEvent$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.f6446a.g("ConnectEventReporter", "reportDisconnectEvent");
            AppUtils appUtils = AppUtils.f7842a;
            Context f = GlobalExtKt.f();
            this.label = 1;
            obj2 = appUtils.h(f, this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str = (String) obj2;
        boolean booleanValue = ((Boolean) GlassWearStateMonitor.f7735a.a().getValue()).booleanValue();
        String romVersion = ControlUtils.f7858a.g().getRomVersion();
        if (romVersion == null) {
            romVersion = "";
        }
        String str2 = romVersion;
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        ConnectEventReporter.DisconnectEvent disconnectEvent = new ConnectEventReporter.DisconnectEvent("", booleanValue ? 1 : 0, (String) null, str2, bool.booleanValue() ^ true ? 1 : 0, str, 4, (DefaultConstructorMarker) null);
        DataTrackUtil.n(DataTrackUtil.f7875a, disconnectEvent.get_event_name_(), EventExtKt.b(disconnectEvent), false, 4, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ConnectEventReporter$reportDisconnectEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
