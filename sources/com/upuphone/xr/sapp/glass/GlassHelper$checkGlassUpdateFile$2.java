package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.entity.CheckGlassUpdateFileCmd;
import com.upuphone.xr.sapp.entity.CheckGlassUpdateFileResult;
import com.upuphone.xr.sapp.utils.JsonUtils;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nGlassHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassHelper.kt\ncom/upuphone/xr/sapp/glass/GlassHelper$checkGlassUpdateFile$2\n+ 2 GlassHelper.kt\ncom/upuphone/xr/sapp/glass/GlassHelper\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n*L\n1#1,649:1\n448#2:650\n409#2:651\n410#2,12:661\n433#2,5:673\n314#3,9:652\n323#3,2:678\n29#4,5:680\n*S KotlinDebug\n*F\n+ 1 GlassHelper.kt\ncom/upuphone/xr/sapp/glass/GlassHelper$checkGlassUpdateFile$2\n*L\n384#1:650\n384#1:651\n384#1:661,12\n384#1:673,5\n384#1:652,9\n384#1:678,2\n384#1:680,5\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/sapp/entity/CheckGlassUpdateFileResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassHelper$checkGlassUpdateFile$2", f = "GlassHelper.kt", i = {0, 0}, l = {652}, m = "invokeSuspend", n = {"action$iv", "message$iv"}, s = {"L$0", "L$1"})
public final class GlassHelper$checkGlassUpdateFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CheckGlassUpdateFileResult>, Object> {
    final /* synthetic */ CheckGlassUpdateFileCmd $cmd;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassHelper$checkGlassUpdateFile$2(CheckGlassUpdateFileCmd checkGlassUpdateFileCmd, Continuation<? super GlassHelper$checkGlassUpdateFile$2> continuation) {
        super(2, continuation);
        this.$cmd = checkGlassUpdateFileCmd;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassHelper$checkGlassUpdateFile$2(this.$cmd, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        JsonUtils jsonUtils;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GlassHelper glassHelper = GlassHelper.f7049a;
            JsonUtils jsonUtils2 = JsonUtils.f7893a;
            String d = jsonUtils2.d(this.$cmd);
            this.L$0 = "check_glass_update_file";
            this.L$1 = d;
            this.L$2 = jsonUtils2;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            GlassHelper$sendOtaMessageAndWait$2$messageListener$1 glassHelper$sendOtaMessageAndWait$2$messageListener$1 = new GlassHelper$sendOtaMessageAndWait$2$messageListener$1(cancellableContinuationImpl);
            GlassHelper glassHelper2 = GlassHelper.f7049a;
            glassHelper2.n("check_glass_update_file", glassHelper$sendOtaMessageAndWait$2$messageListener$1);
            cancellableContinuationImpl.E(new GlassHelper$sendOtaMessageAndWait$2$1(glassHelper2.N(jsonUtils2.d(glassHelper2.r("ota", "check_glass_update_file", d)), new GlassHelper$sendOtaMessageAndWait$2$uid$1("check_glass_update_file", glassHelper$sendOtaMessageAndWait$2$messageListener$1, cancellableContinuationImpl)), "check_glass_update_file", glassHelper$sendOtaMessageAndWait$2$messageListener$1));
            Object u = cancellableContinuationImpl.u();
            if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (u == coroutine_suspended) {
                return coroutine_suspended;
            }
            jsonUtils = jsonUtils2;
            obj = u;
        } else if (i == 1) {
            jsonUtils = (JsonUtils) this.L$2;
            String str = (String) this.L$1;
            String str2 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str3 = (String) obj;
        Type type = new GlassHelper$checkGlassUpdateFile$2$invokeSuspend$$inlined$sendMessageAndWaitResult$1().getType();
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
            Intrinsics.checkNotNull(type);
            return jsonUtils.a("{}", type);
        }
        Intrinsics.checkNotNull(type);
        return jsonUtils.a(str3, type);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super CheckGlassUpdateFileResult> continuation) {
        return ((GlassHelper$checkGlassUpdateFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
