package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class AccessibilityClickableSpanCompat extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    public final int f922a;
    public final AccessibilityNodeInfoCompat b;
    public final int c;

    public AccessibilityClickableSpanCompat(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i2) {
        this.f922a = i;
        this.b = accessibilityNodeInfoCompat;
        this.c = i2;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f922a);
        this.b.Y(this.c, bundle);
    }
}
