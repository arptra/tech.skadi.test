package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

@Deprecated
@RestrictTo
public class PreferenceRecyclerViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f1690a;
    public final AccessibilityDelegateCompat b = super.getItemDelegate();
    public final AccessibilityDelegateCompat c = new AccessibilityDelegateCompat() {
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Preference j;
            PreferenceRecyclerViewAccessibilityDelegate.this.b.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int childAdapterPosition = PreferenceRecyclerViewAccessibilityDelegate.this.f1690a.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = PreferenceRecyclerViewAccessibilityDelegate.this.f1690a.getAdapter();
            if ((adapter instanceof PreferenceGroupAdapter) && (j = ((PreferenceGroupAdapter) adapter).j(childAdapterPosition)) != null) {
                j.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return PreferenceRecyclerViewAccessibilityDelegate.this.b.performAccessibilityAction(view, i, bundle);
        }
    };

    public PreferenceRecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        super(recyclerView);
        this.f1690a = recyclerView;
    }

    public AccessibilityDelegateCompat getItemDelegate() {
        return this.c;
    }
}
