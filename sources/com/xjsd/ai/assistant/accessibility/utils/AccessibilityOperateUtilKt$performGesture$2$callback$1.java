package com.xjsd.ai.assistant.accessibility.utils;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/xjsd/ai/assistant/accessibility/utils/AccessibilityOperateUtilKt$performGesture$2$callback$1", "Landroid/accessibilityservice/AccessibilityService$GestureResultCallback;", "onCancelled", "", "gestureDescription", "Landroid/accessibilityservice/GestureDescription;", "onCompleted", "accessibility_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AccessibilityOperateUtilKt$performGesture$2$callback$1 extends AccessibilityService.GestureResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f8378a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;
    public final /* synthetic */ Continuation e;

    public AccessibilityOperateUtilKt$performGesture$2$callback$1(float f, float f2, float f3, float f4, Continuation continuation) {
        this.f8378a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = continuation;
    }

    public void onCancelled(GestureDescription gestureDescription) {
        super.onCancelled(gestureDescription);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AccessibilityOperateUtil", "performGesture onCancelled. startX=" + this.f8378a + " startY=" + this.b + " endX=" + this.c + " endY=" + this.d);
        Continuation continuation = this.e;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m20constructorimpl(Boolean.FALSE));
    }

    public void onCompleted(GestureDescription gestureDescription) {
        super.onCompleted(gestureDescription);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AccessibilityOperateUtil", "performGesture onCompleted. startX=" + this.f8378a + " startY=" + this.b + " endX=" + this.c + " endY=" + this.d);
        Continuation continuation = this.e;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m20constructorimpl(Boolean.TRUE));
    }
}
