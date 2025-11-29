package com.xjsd.ai.assistant.accessibility.utils;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.os.Handler;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\u001aM\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aK\u0010\u0013\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"T", "Lkotlin/Function0;", "", "count", "", "delayMillis", "Lkotlin/Function1;", "", "judgeBlock", "a", "(Lkotlin/jvm/functions/Function0;IJLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/accessibilityservice/AccessibilityService;", "", "startX", "startY", "endX", "endY", "targetDisplayId", "duration", "b", "(Landroid/accessibilityservice/AccessibilityService;FFFFIJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accessibility_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nAccessibilityOperateUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccessibilityOperateUtil.kt\ncom/xjsd/ai/assistant/accessibility/utils/AccessibilityOperateUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n1#1,304:1\n1855#2,2:305\n1855#2,2:307\n1726#2,3:309\n1726#2,3:312\n1747#2,3:315\n1360#2:318\n1446#2,2:319\n1448#2,3:322\n766#2:325\n857#2,2:326\n49#3:321\n*S KotlinDebug\n*F\n+ 1 AccessibilityOperateUtil.kt\ncom/xjsd/ai/assistant/accessibility/utils/AccessibilityOperateUtilKt\n*L\n114#1:305,2\n122#1:307,2\n143#1:309,3\n152#1:312,3\n161#1:315,3\n221#1:318\n221#1:319,2\n221#1:322,3\n228#1:325\n228#1:326,2\n223#1:321\n*E\n"})
public final class AccessibilityOperateUtilKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(kotlin.jvm.functions.Function0 r7, int r8, long r9, kotlin.jvm.functions.Function1 r11, kotlin.coroutines.Continuation r12) {
        /*
            boolean r0 = r12 instanceof com.xjsd.ai.assistant.accessibility.utils.AccessibilityOperateUtilKt$findWithRepeat$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.xjsd.ai.assistant.accessibility.utils.AccessibilityOperateUtilKt$findWithRepeat$1 r0 = (com.xjsd.ai.assistant.accessibility.utils.AccessibilityOperateUtilKt$findWithRepeat$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.accessibility.utils.AccessibilityOperateUtilKt$findWithRepeat$1 r0 = new com.xjsd.ai.assistant.accessibility.utils.AccessibilityOperateUtilKt$findWithRepeat$1
            r0.<init>(r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            int r7 = r0.I$1
            long r8 = r0.J$0
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$1
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0076
        L_0x0037:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = 0
            r5 = r8
            r8 = r7
            r7 = r12
            r12 = r11
            r10 = r9
            r9 = r5
        L_0x0049:
            if (r7 >= r9) goto L_0x007d
            java.lang.Object r2 = r8.invoke()
            java.lang.Object r4 = r12.invoke(r2)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x005c
            return r2
        L_0x005c:
            if (r7 >= r9) goto L_0x007b
            r0.L$0 = r8
            r0.L$1 = r12
            r0.I$0 = r9
            r0.J$0 = r10
            r0.I$1 = r7
            r0.label = r3
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.b(r10, r0)
            if (r2 != r1) goto L_0x0071
            return r1
        L_0x0071:
            r2 = r8
            r5 = r10
            r10 = r9
            r8 = r5
            r11 = r12
        L_0x0076:
            r12 = r11
            r5 = r8
            r9 = r10
            r10 = r5
            r8 = r2
        L_0x007b:
            int r7 = r7 + r3
            goto L_0x0049
        L_0x007d:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.accessibility.utils.AccessibilityOperateUtilKt.a(kotlin.jvm.functions.Function0, int, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object b(AccessibilityService accessibilityService, float f, float f2, float f3, float f4, int i, long j, Continuation continuation) {
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        int i2 = i;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        ULog.Delegate delegate = ULog.f6446a;
        StringBuilder sb = new StringBuilder();
        sb.append("performGesture targetDisplayId=");
        sb.append(i2);
        sb.append(" duration=");
        long j2 = j;
        sb.append(j2);
        sb.append(" startX=");
        sb.append(f5);
        sb.append(" startY=");
        sb.append(f6);
        sb.append(" endX=");
        sb.append(f7);
        sb.append(" endY=");
        sb.append(f8);
        delegate.a("AccessibilityOperateUtil", sb.toString());
        Path path = new Path();
        path.moveTo(f5, f6);
        path.lineTo(f7, f8);
        GestureDescription.Builder builder = new GestureDescription.Builder();
        builder.addStroke(new GestureDescription.StrokeDescription(path, 0, j2));
        GestureDescription.Builder unused = builder.setDisplayId(i2);
        GestureDescription build = builder.build();
        AccessibilityOperateUtilKt$performGesture$2$callback$1 accessibilityOperateUtilKt$performGesture$2$callback$1 = new AccessibilityOperateUtilKt$performGesture$2$callback$1(f5, f6, f7, f8, safeContinuation);
        AccessibilityService accessibilityService2 = accessibilityService;
        accessibilityService.dispatchGesture(build, accessibilityOperateUtilKt$performGesture$2$callback$1, (Handler) null);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
