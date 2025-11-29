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
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.arspace.WebsiteBlackListHelper$updateIncrement$1", f = "WebsiteBlackListHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WebsiteBlackListHelper$updateIncrement$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public WebsiteBlackListHelper$updateIncrement$1(Continuation<? super WebsiteBlackListHelper$updateIncrement$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WebsiteBlackListHelper$updateIncrement$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                WebsiteBlackListHelper.f = true;
                WebsiteBlackListHelper.c.n();
                WebsiteBlackListHelper websiteBlackListHelper = WebsiteBlackListHelper.f8056a;
                websiteBlackListHelper.H(false);
                boolean o = websiteBlackListHelper.N(0);
                ULog.Delegate delegate = ULog.f6446a;
                delegate.g("WebsiteBlackListHelper", "updateIncrement: blackListResult: " + o);
                if (!o) {
                    WebsiteBlackListHelper.f = false;
                    return Unit.INSTANCE;
                }
                boolean o2 = websiteBlackListHelper.N(1);
                delegate.g("WebsiteBlackListHelper", "updateIncrement: dangerListResult: " + o2);
                if (!o2) {
                    WebsiteBlackListHelper.f = false;
                    return Unit.INSTANCE;
                }
                WebsiteBlackListHelper.c.c();
                websiteBlackListHelper.H(true);
                websiteBlackListHelper.I(System.currentTimeMillis());
                WebsiteBlackListHelper.f = false;
                delegate.g("WebsiteBlackListHelper", "updateIncrement success: ");
                return Unit.INSTANCE;
            } catch (Exception e) {
                ULog.f6446a.d("WebsiteBlackListHelper", "updateIncrement error: ", e);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WebsiteBlackListHelper$updateIncrement$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
