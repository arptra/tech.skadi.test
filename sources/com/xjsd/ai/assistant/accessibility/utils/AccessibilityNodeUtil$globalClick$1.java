package com.xjsd.ai.assistant.accessibility.utils;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityWindowInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.accessibility.utils.AccessibilityNodeUtil", f = "AccessibilityNodeUtil.kt", i = {}, l = {115}, m = "globalClick", n = {}, s = {})
public final class AccessibilityNodeUtil$globalClick$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AccessibilityNodeUtil this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccessibilityNodeUtil$globalClick$1(AccessibilityNodeUtil accessibilityNodeUtil, Continuation<? super AccessibilityNodeUtil$globalClick$1> continuation) {
        super(continuation);
        this.this$0 = accessibilityNodeUtil;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e((AccessibilityWindowInfo) null, (AccessibilityService) null, 0, 0.0f, 0, this);
    }
}
