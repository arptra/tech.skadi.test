package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.utils.ControlUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.PageAdjustFragment$syncToGlass$1", f = "PageAdjustFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PageAdjustFragment$syncToGlass$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PageAdjustFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageAdjustFragment$syncToGlass$1(PageAdjustFragment pageAdjustFragment, Continuation<? super PageAdjustFragment$syncToGlass$1> continuation) {
        super(2, continuation);
        this.this$0 = pageAdjustFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PageAdjustFragment$syncToGlass$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ControlUtils controlUtils = ControlUtils.f7858a;
            String packageName = this.this$0.m0().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            controlUtils.P(packageName, this.this$0.n);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PageAdjustFragment$syncToGlass$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
