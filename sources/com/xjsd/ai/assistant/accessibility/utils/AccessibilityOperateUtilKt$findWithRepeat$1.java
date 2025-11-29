package com.xjsd.ai.assistant.accessibility.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.accessibility.utils.AccessibilityOperateUtilKt", f = "AccessibilityOperateUtil.kt", i = {0, 0, 0, 0}, l = {78}, m = "findWithRepeat", n = {"$this$findWithRepeat", "judgeBlock", "count", "delayMillis"}, s = {"L$0", "L$1", "I$0", "J$0"})
public final class AccessibilityOperateUtilKt$findWithRepeat$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public AccessibilityOperateUtilKt$findWithRepeat$1(Continuation<? super AccessibilityOperateUtilKt$findWithRepeat$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AccessibilityOperateUtilKt.a((Function0) null, 0, 0, (Function1) null, this);
    }
}
