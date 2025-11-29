package com.upuphone.xr.sapp.air;

import com.upuphone.xr.sapp.entity.BaseActionData;
import com.upuphone.xr.sapp.entity.BasicGlassResponse;
import com.upuphone.xr.sapp.glass.GlassMessageHelper;
import com.upuphone.xr.sapp.glass.GlassMessageHelper$sendMessageAndWait$2$1;
import com.upuphone.xr.sapp.glass.GlassMessageHelper$sendMessageAndWait$2$listener$1;
import com.upuphone.xr.sapp.glass.GlassMessageHelper$sendMessageAndWait$2$messageListener$1;
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

@SourceDebugExtension({"SMAP\nAirHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirHelper.kt\ncom/upuphone/xr/sapp/air/AirHelper$sendOpenGlassUpdateAppCmd$2\n+ 2 GlassMessageHelper.kt\ncom/upuphone/xr/sapp/glass/GlassMessageHelper\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n*L\n1#1,576:1\n293#2,2:577\n186#2:579\n187#2,11:589\n209#2,11:600\n314#3,9:580\n323#3,2:611\n29#4,5:613\n*S KotlinDebug\n*F\n+ 1 AirHelper.kt\ncom/upuphone/xr/sapp/air/AirHelper$sendOpenGlassUpdateAppCmd$2\n*L\n259#1:577,2\n259#1:579\n259#1:589,11\n259#1:600,11\n259#1:580,9\n259#1:611,2\n259#1:613,5\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/sapp/entity/BasicGlassResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.air.AirHelper$sendOpenGlassUpdateAppCmd$2", f = "AirHelper.kt", i = {0, 0, 0}, l = {580}, m = "invokeSuspend", n = {"action$iv", "subAction$iv", "needSendMessageCallback$iv"}, s = {"L$0", "L$1", "I$0"})
public final class AirHelper$sendOpenGlassUpdateAppCmd$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BasicGlassResponse>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public AirHelper$sendOpenGlassUpdateAppCmd$2(Continuation<? super AirHelper$sendOpenGlassUpdateAppCmd$2> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AirHelper$sendOpenGlassUpdateAppCmd$2(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        JsonUtils jsonUtils;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GlassMessageHelper glassMessageHelper = GlassMessageHelper.f7054a;
            JsonUtils jsonUtils2 = JsonUtils.f7893a;
            this.L$0 = "air_ota";
            this.L$1 = "open_air_glass_update_app";
            this.L$2 = jsonUtils2;
            this.I$0 = 0;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            GlassMessageHelper$sendMessageAndWait$2$messageListener$1 glassMessageHelper$sendMessageAndWait$2$messageListener$1 = new GlassMessageHelper$sendMessageAndWait$2$messageListener$1(cancellableContinuationImpl);
            GlassMessageHelper glassMessageHelper2 = GlassMessageHelper.f7054a;
            glassMessageHelper2.c("air_ota", "open_air_glass_update_app", glassMessageHelper$sendMessageAndWait$2$messageListener$1);
            BaseActionData d = glassMessageHelper2.d("air_ota", "open_air_glass_update_app", (String) null);
            cancellableContinuationImpl.E(new GlassMessageHelper$sendMessageAndWait$2$1(glassMessageHelper2.i(jsonUtils2.d(d), (byte[]) null, new GlassMessageHelper$sendMessageAndWait$2$listener$1("air_ota", "open_air_glass_update_app", glassMessageHelper$sendMessageAndWait$2$messageListener$1, cancellableContinuationImpl), false), "air_ota", "open_air_glass_update_app", glassMessageHelper$sendMessageAndWait$2$messageListener$1));
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
        Type type = new AirHelper$sendOpenGlassUpdateAppCmd$2$invokeSuspend$$inlined$sendMessageAndWaitResult$1().getType();
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
            Intrinsics.checkNotNull(type);
            return jsonUtils.a("{}", type);
        }
        Intrinsics.checkNotNull(type);
        return jsonUtils.a(str3, type);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super BasicGlassResponse> continuation) {
        return ((AirHelper$sendOpenGlassUpdateAppCmd$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
