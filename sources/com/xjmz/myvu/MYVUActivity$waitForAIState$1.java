package com.xjmz.myvu;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.ability.PhoneSappAbility;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.contract.UserGuideAuthResult;
import com.upuphone.xr.sapp.entity.AIModelResult;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.MYVUActivity$waitForAIState$1", f = "MYVUActivity.kt", i = {}, l = {999, 1005}, m = "invokeSuspend", n = {}, s = {})
public final class MYVUActivity$waitForAIState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $aiStateKey;
    final /* synthetic */ boolean $forceToShow;
    int label;
    final /* synthetic */ MYVUActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MYVUActivity$waitForAIState$1(boolean z, String str, MYVUActivity mYVUActivity, Continuation<? super MYVUActivity$waitForAIState$1> continuation) {
        super(2, continuation);
        this.$forceToShow = z;
        this.$aiStateKey = str;
        this.this$0 = mYVUActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MYVUActivity$waitForAIState$1(this.$forceToShow, this.$aiStateKey, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.f6446a.a("MYVUActivity", "waitForAIState, start");
            PhoneSappAbility a2 = PhoneSappAbility.h.a();
            this.label = 1;
            obj = a2.q(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("MYVUActivity", "waitForAIState, userGuideAuthResult: " + ((UserGuideAuthResult) obj));
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AIModelResult aIModelResult = (AIModelResult) obj;
        ULog.Delegate delegate2 = ULog.f6446a;
        delegate2.a("MYVUActivity", "waitForAIState, aiModelResult: " + aIModelResult);
        if ((this.$forceToShow || aIModelResult.getState() != Integer.parseInt("1")) && (this.$forceToShow || !((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), this.$aiStateKey, Boxing.boxBoolean(false), (Context) null, 4, (Object) null)).booleanValue())) {
            DataStoreUtils.e.a().o(this.$aiStateKey, Boxing.boxBoolean(true));
            ContractEntry contractEntry = ContractEntry.f6691a;
            MYVUActivity mYVUActivity = this.this$0;
            this.label = 2;
            obj = contractEntry.z(mYVUActivity, 1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            ULog.Delegate delegate3 = ULog.f6446a;
            delegate3.a("MYVUActivity", "waitForAIState, userGuideAuthResult: " + ((UserGuideAuthResult) obj));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MYVUActivity$waitForAIState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
