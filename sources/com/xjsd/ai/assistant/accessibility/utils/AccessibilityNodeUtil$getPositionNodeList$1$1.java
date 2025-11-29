package com.xjsd.ai.assistant.accessibility.utils;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "node", "Landroid/view/accessibility/AccessibilityNodeInfo;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAccessibilityNodeUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccessibilityNodeUtil.kt\ncom/xjsd/ai/assistant/accessibility/utils/AccessibilityNodeUtil$getPositionNodeList$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,333:1\n1#2:334\n*E\n"})
final class AccessibilityNodeUtil$getPositionNodeList$1$1 extends Lambda implements Function1<AccessibilityNodeInfo, Comparable<?>> {
    public static final AccessibilityNodeUtil$getPositionNodeList$1$1 INSTANCE = new AccessibilityNodeUtil$getPositionNodeList$1$1();

    public AccessibilityNodeUtil$getPositionNodeList$1$1() {
        super(1);
    }

    @Nullable
    public final Comparable<?> invoke(@NotNull AccessibilityNodeInfo accessibilityNodeInfo) {
        Intrinsics.checkNotNullParameter(accessibilityNodeInfo, "node");
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        return Integer.valueOf(rect.top);
    }
}
