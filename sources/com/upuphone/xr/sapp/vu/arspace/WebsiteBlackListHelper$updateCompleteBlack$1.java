package com.upuphone.xr.sapp.vu.arspace;

import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.arspace.WebsiteBlackListHelper$updateCompleteBlack$1", f = "WebsiteBlackListHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WebsiteBlackListHelper$updateCompleteBlack$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public WebsiteBlackListHelper$updateCompleteBlack$1(Continuation<? super WebsiteBlackListHelper$updateCompleteBlack$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WebsiteBlackListHelper$updateCompleteBlack$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                WebsiteBlackListHelper.g = true;
                WebsiteBlackListHelper.c.i();
                WebsiteBlackListHelper websiteBlackListHelper = WebsiteBlackListHelper.f8056a;
                websiteBlackListHelper.D(false);
                boolean n = websiteBlackListHelper.L(0);
                ULog.Delegate delegate = ULog.f6446a;
                delegate.g("WebsiteBlackListHelper", "updateCompleteBlack result: " + n);
                if (n) {
                    WebsiteBlackListHelper.c.a();
                    websiteBlackListHelper.D(true);
                    websiteBlackListHelper.E(System.currentTimeMillis());
                }
                WebsiteBlackListHelper.g = false;
            } catch (Exception e) {
                ULog.f6446a.d("WebsiteBlackListHelper", "updateCompleteBlack error: ", e);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WebsiteBlackListHelper$updateCompleteBlack$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
