package com.upuphone.xr.sapp.unicron;

import com.upuphone.xr.sapp.entity.BaseActionData;
import com.upuphone.xr.sapp.entity.UnicronInfo;
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

@SourceDebugExtension({"SMAP\nUnicronHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnicronHelper.kt\ncom/upuphone/xr/sapp/unicron/UnicronHelper$getUnicronInfo$2\n+ 2 GlassMessageHelper.kt\ncom/upuphone/xr/sapp/glass/GlassMessageHelper\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n*L\n1#1,185:1\n287#2,8:186\n186#2:194\n187#2,11:204\n209#2,11:215\n314#3,9:195\n323#3,2:226\n29#4,5:228\n*S KotlinDebug\n*F\n+ 1 UnicronHelper.kt\ncom/upuphone/xr/sapp/unicron/UnicronHelper$getUnicronInfo$2\n*L\n66#1:186,8\n66#1:194\n66#1:204,11\n66#1:215,11\n66#1:195,9\n66#1:226,2\n66#1:228,5\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/sapp/entity/UnicronInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.unicron.UnicronHelper$getUnicronInfo$2", f = "UnicronHelper.kt", i = {0, 0, 0}, l = {195}, m = "invokeSuspend", n = {"action$iv", "subAction$iv", "needSendMessageCallback$iv"}, s = {"L$0", "L$1", "I$0"})
public final class UnicronHelper$getUnicronInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UnicronInfo>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public UnicronHelper$getUnicronInfo$2(Continuation<? super UnicronHelper$getUnicronInfo$2> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UnicronHelper$getUnicronInfo$2(continuation);
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
            this.L$0 = "unicron_ota";
            this.L$1 = "get_unicron_info";
            this.L$2 = jsonUtils2;
            this.I$0 = 1;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            GlassMessageHelper$sendMessageAndWait$2$messageListener$1 glassMessageHelper$sendMessageAndWait$2$messageListener$1 = new GlassMessageHelper$sendMessageAndWait$2$messageListener$1(cancellableContinuationImpl);
            GlassMessageHelper glassMessageHelper2 = GlassMessageHelper.f7054a;
            glassMessageHelper2.c("unicron_ota", "get_unicron_info", glassMessageHelper$sendMessageAndWait$2$messageListener$1);
            BaseActionData d = glassMessageHelper2.d("unicron_ota", "get_unicron_info", (String) null);
            cancellableContinuationImpl.E(new GlassMessageHelper$sendMessageAndWait$2$1(glassMessageHelper2.i(jsonUtils2.d(d), (byte[]) null, new GlassMessageHelper$sendMessageAndWait$2$listener$1("unicron_ota", "get_unicron_info", glassMessageHelper$sendMessageAndWait$2$messageListener$1, cancellableContinuationImpl), true), "unicron_ota", "get_unicron_info", glassMessageHelper$sendMessageAndWait$2$messageListener$1));
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
        Type type = new UnicronHelper$getUnicronInfo$2$invokeSuspend$$inlined$sendMessageAndWaitResult$default$1().getType();
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
            Intrinsics.checkNotNull(type);
            return jsonUtils.a("{}", type);
        }
        Intrinsics.checkNotNull(type);
        return jsonUtils.a(str3, type);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super UnicronInfo> continuation) {
        return ((UnicronHelper$getUnicronInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
