package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

final class AnimateLayoutChangeDetector {
    public static final ViewGroup.MarginLayoutParams b;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayoutManager f1928a;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public AnimateLayoutChangeDetector(LinearLayoutManager linearLayoutManager) {
        this.f1928a = linearLayoutManager;
    }

    public static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (c(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean a() {
        int top2;
        int i;
        int bottom;
        int i2;
        int childCount = this.f1928a.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z = this.f1928a.getOrientation() == 0;
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = childCount;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.f1928a.getChildAt(i3);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : b;
                int[] iArr3 = iArr2[i3];
                if (z) {
                    top2 = childAt.getLeft();
                    i = marginLayoutParams.leftMargin;
                } else {
                    top2 = childAt.getTop();
                    i = marginLayoutParams.topMargin;
                }
                iArr3[0] = top2 - i;
                int[] iArr4 = iArr2[i3];
                if (z) {
                    bottom = childAt.getRight();
                    i2 = marginLayoutParams.rightMargin;
                } else {
                    bottom = childAt.getBottom();
                    i2 = marginLayoutParams.bottomMargin;
                }
                iArr4[1] = bottom + i2;
                i3++;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr2, new Comparator<int[]>() {
            /* renamed from: a */
            public int compare(int[] iArr, int[] iArr2) {
                return iArr[0] - iArr2[0];
            }
        });
        for (int i4 = 1; i4 < childCount; i4++) {
            if (iArr2[i4 - 1][1] != iArr2[i4][0]) {
                return false;
            }
        }
        int[] iArr5 = iArr2[0];
        int i5 = iArr5[1];
        int i6 = iArr5[0];
        return i6 <= 0 && iArr2[childCount - 1][1] >= i5 - i6;
    }

    public final boolean b() {
        int childCount = this.f1928a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (c(this.f1928a.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        return (!a() || this.f1928a.getChildCount() <= 1) && b();
    }
}
