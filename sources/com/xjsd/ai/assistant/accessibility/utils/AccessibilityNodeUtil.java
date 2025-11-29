package com.xjsd.ai.assistant.accessibility.utils;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u000e\u001a\u00020\r*\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0011\u001a\u00020\r*\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0013*\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0013*\u00020\u00102\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0013*\u00020\u00182\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/xjsd/ai/assistant/accessibility/utils/AccessibilityNodeUtil;", "", "<init>", "()V", "Landroid/view/accessibility/AccessibilityWindowInfo;", "Landroid/accessibilityservice/AccessibilityService;", "service", "", "targetDisplayId", "", "divider", "", "duration", "", "e", "(Landroid/view/accessibility/AccessibilityWindowInfo;Landroid/accessibilityservice/AccessibilityService;IFJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/view/accessibility/AccessibilityNodeInfo;", "d", "(Landroid/view/accessibility/AccessibilityNodeInfo;Landroid/accessibilityservice/AccessibilityService;IFJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Pair;", "b", "(Landroid/view/accessibility/AccessibilityWindowInfo;F)Lkotlin/Pair;", "a", "(Landroid/view/accessibility/AccessibilityNodeInfo;F)Lkotlin/Pair;", "Landroid/graphics/Rect;", "c", "(Landroid/graphics/Rect;F)Lkotlin/Pair;", "accessibility_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nAccessibilityNodeUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccessibilityNodeUtil.kt\ncom/xjsd/ai/assistant/accessibility/utils/AccessibilityNodeUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,333:1\n1855#2,2:334\n1549#2:337\n1620#2,3:338\n1726#2,3:341\n1747#2,3:344\n1#3:336\n*S KotlinDebug\n*F\n+ 1 AccessibilityNodeUtil.kt\ncom/xjsd/ai/assistant/accessibility/utils/AccessibilityNodeUtil\n*L\n28#1:334,2\n239#1:337\n239#1:338,3\n265#1:341,3\n298#1:344,3\n*E\n"})
public final class AccessibilityNodeUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final AccessibilityNodeUtil f8377a = new AccessibilityNodeUtil();

    public final Pair a(AccessibilityNodeInfo accessibilityNodeInfo, float f) {
        Intrinsics.checkNotNullParameter(accessibilityNodeInfo, "<this>");
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        return c(rect, f);
    }

    public final Pair b(AccessibilityWindowInfo accessibilityWindowInfo, float f) {
        Intrinsics.checkNotNullParameter(accessibilityWindowInfo, "<this>");
        Rect rect = new Rect();
        accessibilityWindowInfo.getBoundsInScreen(rect);
        return c(rect, f);
    }

    public final Pair c(Rect rect, float f) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        return new Pair(Float.valueOf(((float) (rect.left + rect.right)) * f), Float.valueOf(((float) (rect.top + rect.bottom)) * f));
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(android.view.accessibility.AccessibilityNodeInfo r15, android.accessibilityservice.AccessibilityService r16, int r17, float r18, long r19, kotlin.coroutines.Continuation r21) {
        /*
            r14 = this;
            r0 = r14
            r1 = r21
            boolean r2 = r1 instanceof com.xjsd.ai.assistant.accessibility.utils.AccessibilityNodeUtil$globalClick$2
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.xjsd.ai.assistant.accessibility.utils.AccessibilityNodeUtil$globalClick$2 r2 = (com.xjsd.ai.assistant.accessibility.utils.AccessibilityNodeUtil$globalClick$2) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
        L_0x0015:
            r11 = r2
            goto L_0x001d
        L_0x0017:
            com.xjsd.ai.assistant.accessibility.utils.AccessibilityNodeUtil$globalClick$2 r2 = new com.xjsd.ai.assistant.accessibility.utils.AccessibilityNodeUtil$globalClick$2
            r2.<init>(r14, r1)
            goto L_0x0015
        L_0x001d:
            java.lang.Object r1 = r11.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r11.label
            r12 = 0
            r13 = 1
            if (r3 == 0) goto L_0x0037
            if (r3 != r13) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0085
        L_0x002f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r15
            r3 = r18
            kotlin.Pair r0 = r14.a(r15, r3)
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 30
            if (r1 < r3) goto L_0x008f
            if (r16 == 0) goto L_0x0098
            java.lang.Object r1 = r0.getFirst()
            java.lang.Number r1 = (java.lang.Number) r1
            float r4 = r1.floatValue()
            java.lang.Object r1 = r0.getSecond()
            java.lang.Number r1 = (java.lang.Number) r1
            float r5 = r1.floatValue()
            java.lang.Object r1 = r0.getFirst()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            float r3 = (float) r13
            float r6 = r1 + r3
            java.lang.Object r0 = r0.getSecond()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            float r7 = r0 + r3
            r11.label = r13
            r3 = r16
            r8 = r17
            r9 = r19
            java.lang.Object r1 = com.xjsd.ai.assistant.accessibility.utils.AccessibilityOperateUtilKt.b(r3, r4, r5, r6, r7, r8, r9, r11)
            if (r1 != r2) goto L_0x0085
            return r2
        L_0x0085:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r0 = r1.booleanValue()
            if (r0 == 0) goto L_0x0098
            r12 = r13
            goto L_0x0098
        L_0x008f:
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = "AccessibilityNodeUtil"
            java.lang.String r2 = "Build.VERSION too low."
            r0.a(r1, r2)
        L_0x0098:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.accessibility.utils.AccessibilityNodeUtil.d(android.view.accessibility.AccessibilityNodeInfo, android.accessibilityservice.AccessibilityService, int, float, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(android.view.accessibility.AccessibilityWindowInfo r15, android.accessibilityservice.AccessibilityService r16, int r17, float r18, long r19, kotlin.coroutines.Continuation r21) {
        /*
            r14 = this;
            r0 = r14
            r1 = r21
            boolean r2 = r1 instanceof com.xjsd.ai.assistant.accessibility.utils.AccessibilityNodeUtil$globalClick$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.xjsd.ai.assistant.accessibility.utils.AccessibilityNodeUtil$globalClick$1 r2 = (com.xjsd.ai.assistant.accessibility.utils.AccessibilityNodeUtil$globalClick$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
        L_0x0015:
            r11 = r2
            goto L_0x001d
        L_0x0017:
            com.xjsd.ai.assistant.accessibility.utils.AccessibilityNodeUtil$globalClick$1 r2 = new com.xjsd.ai.assistant.accessibility.utils.AccessibilityNodeUtil$globalClick$1
            r2.<init>(r14, r1)
            goto L_0x0015
        L_0x001d:
            java.lang.Object r1 = r11.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r11.label
            r12 = 0
            r13 = 1
            if (r3 == 0) goto L_0x0037
            if (r3 != r13) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0085
        L_0x002f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r15
            r3 = r18
            kotlin.Pair r0 = r14.b(r15, r3)
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 30
            if (r1 < r3) goto L_0x008f
            if (r16 == 0) goto L_0x0098
            java.lang.Object r1 = r0.getFirst()
            java.lang.Number r1 = (java.lang.Number) r1
            float r4 = r1.floatValue()
            java.lang.Object r1 = r0.getSecond()
            java.lang.Number r1 = (java.lang.Number) r1
            float r5 = r1.floatValue()
            java.lang.Object r1 = r0.getFirst()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            float r3 = (float) r13
            float r6 = r1 + r3
            java.lang.Object r0 = r0.getSecond()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            float r7 = r0 + r3
            r11.label = r13
            r3 = r16
            r8 = r17
            r9 = r19
            java.lang.Object r1 = com.xjsd.ai.assistant.accessibility.utils.AccessibilityOperateUtilKt.b(r3, r4, r5, r6, r7, r8, r9, r11)
            if (r1 != r2) goto L_0x0085
            return r2
        L_0x0085:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r0 = r1.booleanValue()
            if (r0 == 0) goto L_0x0098
            r12 = r13
            goto L_0x0098
        L_0x008f:
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = "AccessibilityNodeUtil"
            java.lang.String r2 = "Build.VERSION too low."
            r0.a(r1, r2)
        L_0x0098:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.accessibility.utils.AccessibilityNodeUtil.e(android.view.accessibility.AccessibilityWindowInfo, android.accessibilityservice.AccessibilityService, int, float, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
