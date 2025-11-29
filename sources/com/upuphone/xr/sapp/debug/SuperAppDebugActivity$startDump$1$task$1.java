package com.upuphone.xr.sapp.debug;

import com.upuphone.xr.sapp.utils.ZipUtils;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.debug.SuperAppDebugActivity$startDump$1$task$1", f = "SuperAppDebugActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SuperAppDebugActivity$startDump$1$task$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $source;
    final /* synthetic */ String $target;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperAppDebugActivity$startDump$1$task$1(String str, String str2, Continuation<? super SuperAppDebugActivity$startDump$1$task$1> continuation) {
        super(2, continuation);
        this.$source = str;
        this.$target = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SuperAppDebugActivity$startDump$1$task$1(this.$source, this.$target, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(ZipUtils.f7938a.e(this.$source, this.$target));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((SuperAppDebugActivity$startDump$1$task$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
