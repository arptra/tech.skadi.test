package com.upuphone.xr.sapp.datatrack;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.datatrack.ConnectEventReporter;
import com.upuphone.xr.sapp.utils.AppUtils;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.datatrack.ConnectEventReporter$reportPairEvent$1", f = "ConnectEventReporter.kt", i = {1}, l = {40, 41}, m = "invokeSuspend", n = {"romVersion"}, s = {"L$0"})
public final class ConnectEventReporter$reportPairEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $code;
    final /* synthetic */ String $reason;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectEventReporter$reportPairEvent$1(int i, String str, Continuation<? super ConnectEventReporter$reportPairEvent$1> continuation) {
        super(2, continuation);
        this.$code = i;
        this.$reason = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ConnectEventReporter$reportPairEvent$1(this.$code, this.$reason, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        Object obj2;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.Delegate delegate = ULog.f6446a;
            int i2 = this.$code;
            String str2 = this.$reason;
            delegate.g("ConnectEventReporter", "reportPairEvent, code: " + i2 + ", reason: " + str2);
            ConnectEventReporter connectEventReporter = ConnectEventReporter.b;
            this.label = 1;
            obj3 = connectEventReporter.p(this);
            if (obj3 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            obj3 = obj;
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
            str = (String) this.L$0;
            int i3 = this.$code;
            String str3 = this.$reason;
            Boolean bool = BuildConfig.b;
            Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
            ConnectEventReporter.PairEvent pairEvent = new ConnectEventReporter.PairEvent(i3, 0, str3, 0, 0, (String) null, str, bool.booleanValue() ^ true ? 1 : 0, (String) obj2, 58, (DefaultConstructorMarker) null);
            DataTrackUtil.n(DataTrackUtil.f7875a, pairEvent.get_event_name_(), EventExtKt.b(pairEvent), false, 4, (Object) null);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str4 = (String) obj3;
        AppUtils appUtils = AppUtils.f7842a;
        Context f = GlobalExtKt.f();
        this.L$0 = str4;
        this.label = 2;
        obj2 = appUtils.h(f, this);
        if (obj2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        str = str4;
        int i32 = this.$code;
        String str32 = this.$reason;
        Boolean bool2 = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool2, "THIRD_PLATFOM");
        ConnectEventReporter.PairEvent pairEvent2 = new ConnectEventReporter.PairEvent(i32, 0, str32, 0, 0, (String) null, str, bool2.booleanValue() ^ true ? 1 : 0, (String) obj2, 58, (DefaultConstructorMarker) null);
        DataTrackUtil.n(DataTrackUtil.f7875a, pairEvent2.get_event_name_(), EventExtKt.b(pairEvent2), false, 4, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ConnectEventReporter$reportPairEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
