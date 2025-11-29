package com.upuphone.ar.translation.interconnect;

import com.upuphone.xr.interconnect.common.IAIModelResult;
import com.upuphone.xr.interconnect.entity.AIModelResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ar/translation/interconnect/TransInterConnectManager$requestAIState$1", "Lcom/upuphone/xr/interconnect/common/IAIModelResult$Stub;", "aiResult", "", "result", "Lcom/upuphone/xr/interconnect/entity/AIModelResult;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TransInterConnectManager$requestAIState$1 extends IAIModelResult.Stub {
    final /* synthetic */ Function1<Boolean, Unit> $callBack;
    final /* synthetic */ TransInterConnectManager this$0;

    public TransInterConnectManager$requestAIState$1(TransInterConnectManager transInterConnectManager, Function1<? super Boolean, Unit> function1) {
        this.this$0 = transInterConnectManager;
        this.$callBack = function1;
    }

    public void aiResult(@Nullable AIModelResult aIModelResult) {
        Job unused = BuildersKt__Builders_commonKt.d(this.this$0.q(), (CoroutineContext) null, (CoroutineStart) null, new TransInterConnectManager$requestAIState$1$aiResult$1(aIModelResult, this.$callBack, (Continuation<? super TransInterConnectManager$requestAIState$1$aiResult$1>) null), 3, (Object) null);
    }
}
