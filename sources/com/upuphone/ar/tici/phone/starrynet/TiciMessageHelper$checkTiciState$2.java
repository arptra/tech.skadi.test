package com.upuphone.ar.tici.phone.starrynet;

import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import com.upuphone.ar.tici.phone.TiciApp;
import com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateMsg;
import com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@SourceDebugExtension({"SMAP\nTiciMessageHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciMessageHelper.kt\ncom/upuphone/ar/tici/phone/starrynet/TiciMessageHelper$checkTiciState$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,364:1\n314#2,11:365\n*S KotlinDebug\n*F\n+ 1 TiciMessageHelper.kt\ncom/upuphone/ar/tici/phone/starrynet/TiciMessageHelper$checkTiciState$2\n*L\n151#1:365,11\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/upuphone/ar/tici/phone/starrynet/msg/CheckTiciStateReply;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper$checkTiciState$2", f = "TiciMessageHelper.kt", i = {}, l = {365}, m = "invokeSuspend", n = {}, s = {})
public final class TiciMessageHelper$checkTiciState$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends CheckTiciStateReply>>, Object> {
    int label;

    public TiciMessageHelper$checkTiciState$2(Continuation<? super TiciMessageHelper$checkTiciState$2> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciMessageHelper$checkTiciState$2(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            TiciMessageHelper$checkTiciState$2$1$msgListener$1 ticiMessageHelper$checkTiciState$2$1$msgListener$1 = new TiciMessageHelper$checkTiciState$2$1$msgListener$1(BaseActionMsg.MSG_CHECK_TICI_STATE_REPLY, cancellableContinuationImpl);
            TiciApp.b.q().getReceiveMsgHandler().c(BaseActionMsg.MSG_CHECK_TICI_STATE_REPLY, ticiMessageHelper$checkTiciState$2$1$msgListener$1);
            cancellableContinuationImpl.E(new TiciMessageHelper$checkTiciState$2$1$1(BaseActionMsg.MSG_CHECK_TICI_STATE_REPLY, ticiMessageHelper$checkTiciState$2$1$msgListener$1));
            TiciMessageHelper$checkTiciState$2$1$listener$1 ticiMessageHelper$checkTiciState$2$1$listener$1 = new TiciMessageHelper$checkTiciState$2$1$listener$1(BaseActionMsg.MSG_CHECK_TICI_STATE_REPLY, ticiMessageHelper$checkTiciState$2$1$msgListener$1, cancellableContinuationImpl);
            TiciMessageHelper ticiMessageHelper = TiciMessageHelper.f5973a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WebJs.ACTION, BaseActionMsg.MSG_CHECK_TICI_STATE);
            jSONObject.put(AccountConstantKt.RESPONSE_VALUE, new CheckTiciStateMsg().toJsonString());
            ticiMessageHelper.f(jSONObject, ticiMessageHelper$checkTiciState$2$1$listener$1);
            obj = cancellableContinuationImpl.u();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Result<CheckTiciStateReply>> continuation) {
        return ((TiciMessageHelper$checkTiciState$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
