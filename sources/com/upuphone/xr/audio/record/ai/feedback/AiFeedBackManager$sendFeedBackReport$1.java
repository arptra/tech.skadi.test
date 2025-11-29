package com.upuphone.xr.audio.record.ai.feedback;

import com.upuphone.xr.audio.record.ai.bean.AiFeedBackRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager", f = "AiFeedBackManager.kt", i = {0}, l = {164}, m = "sendFeedBackReport", n = {"this"}, s = {"L$0"})
public final class AiFeedBackManager$sendFeedBackReport$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiFeedBackManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiFeedBackManager$sendFeedBackReport$1(AiFeedBackManager aiFeedBackManager, Continuation<? super AiFeedBackManager$sendFeedBackReport$1> continuation) {
        super(continuation);
        this.this$0 = aiFeedBackManager;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h((String) null, (AiFeedBackRequest) null, this);
    }
}
