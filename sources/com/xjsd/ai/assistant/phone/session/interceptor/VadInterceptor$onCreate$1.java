package com.xjsd.ai.assistant.phone.session.interceptor;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "data", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor$onCreate$1", f = "VadInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VadInterceptor$onCreate$1 extends SuspendLambda implements Function3<CoroutineScope, byte[], Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VadInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VadInterceptor$onCreate$1(VadInterceptor vadInterceptor, Continuation<? super VadInterceptor$onCreate$1> continuation) {
        super(3, continuation);
        this.this$0 = vadInterceptor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            byte[] bArr = (byte[]) this.L$0;
            this.this$0.e.feedData(ArraysKt.copyOfRange(bArr, 2, bArr.length));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull byte[] bArr, @Nullable Continuation<? super Unit> continuation) {
        VadInterceptor$onCreate$1 vadInterceptor$onCreate$1 = new VadInterceptor$onCreate$1(this.this$0, continuation);
        vadInterceptor$onCreate$1.L$0 = bArr;
        return vadInterceptor$onCreate$1.invokeSuspend(Unit.INSTANCE);
    }
}
