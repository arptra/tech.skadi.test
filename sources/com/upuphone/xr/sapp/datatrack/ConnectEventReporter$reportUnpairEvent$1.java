package com.upuphone.xr.sapp.datatrack;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.datatrack.ConnectEventReporter;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.datatrack.ConnectEventReporter$reportUnpairEvent$1", f = "ConnectEventReporter.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
public final class ConnectEventReporter$reportUnpairEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $success;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectEventReporter$reportUnpairEvent$1(boolean z, Continuation<? super ConnectEventReporter$reportUnpairEvent$1> continuation) {
        super(2, continuation);
        this.$success = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ConnectEventReporter$reportUnpairEvent$1(this.$success, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.f6446a.g("ConnectEventReporter", "reportUnpairEvent, success: " + this.$success);
            AppUtils appUtils = AppUtils.f7842a;
            Context f = GlobalExtKt.f();
            this.label = 1;
            obj = appUtils.h(f, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str = (String) obj;
        boolean z = !this.$success;
        ConnectEventReporter connectEventReporter = ConnectEventReporter.b;
        int i2 = connectEventReporter.c() ? 2 : 3;
        String romVersion = ControlUtils.f7858a.g().getRomVersion();
        if (romVersion == null) {
            romVersion = "";
        }
        String str2 = romVersion;
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        ConnectEventReporter.UnpairEvent unpairEvent = new ConnectEventReporter.UnpairEvent(z ? 1 : 0, i2, (String) null, str2, bool.booleanValue() ^ true ? 1 : 0, str, 4, (DefaultConstructorMarker) null);
        connectEventReporter.n(false);
        DataTrackUtil.n(DataTrackUtil.f7875a, unpairEvent.get_event_name_(), EventExtKt.b(unpairEvent), false, 4, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ConnectEventReporter$reportUnpairEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
