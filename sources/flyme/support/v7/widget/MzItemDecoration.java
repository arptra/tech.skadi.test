package flyme.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import flyme.support.v7.R;
import flyme.support.v7.widget.MzRecyclerView;

public class MzItemDecoration extends MzRecyclerView.ItemDecoration {
    private Drawable mDivider;
    private int mDividerHeight;
    public DividerPadding mDividerPadding;
    private int mDividerWidth;
    private RecyclerView mRecyclerView;

    public interface DividerPadding {
        int[] getDividerPadding(int i);
    }

    public MzItemDecoration(Context context) {
        Drawable drawable = context.getResources().getDrawable(R.drawable.mz_recyclerview_item_divider);
        this.mDivider = drawable;
        setDivider(drawable);
    }

    private int getOrientation(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation();
        }
        throw new IllegalStateException("DividerItemDecoration can only be used with a LinearLayoutManager.");
    }

    public int getDividerHeight() {
        return this.mDividerHeight;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.set(0, 0, 0, this.mDividerHeight);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0094 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00eb A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDrawOverChildren(android.graphics.Canvas r19, androidx.recyclerview.widget.RecyclerView r20, androidx.recyclerview.widget.RecyclerView.State r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            android.graphics.drawable.Drawable r3 = r0.mDivider
            if (r3 != 0) goto L_0x000e
            super.onDrawOverChildren(r19, r20, r21)
            return
        L_0x000e:
            r0.mRecyclerView = r2
            int r3 = r0.getOrientation(r2)
            r4 = 2
            r5 = 0
            r6 = 1
            if (r3 != r6) goto L_0x0098
            int r3 = r20.getPaddingLeft()
            int r7 = r20.getWidth()
            int r8 = r20.getPaddingRight()
            int r7 = r7 - r8
            int r8 = r20.getChildCount()
            r9 = r5
        L_0x002b:
            if (r9 >= r8) goto L_0x00ee
            android.view.View r10 = r2.getChildAt(r9)
            android.view.ViewGroup$LayoutParams r11 = r10.getLayoutParams()
            androidx.recyclerview.widget.RecyclerView$LayoutParams r11 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r11
            int r12 = r10.getBottom()
            int r11 = r11.bottomMargin
            int r12 = r12 + r11
            int r11 = r0.mDividerHeight
            int r11 = r11 + r12
            int r13 = r2.getChildLayoutPosition(r10)
            flyme.support.v7.widget.MzItemDecoration$DividerPadding r14 = r0.mDividerPadding
            if (r14 == 0) goto L_0x0066
            int[] r14 = r14.getDividerPadding(r13)
            int r15 = r14.length
            if (r15 != r4) goto L_0x0066
            androidx.recyclerview.widget.RecyclerView r15 = r0.mRecyclerView
            int r15 = r15.getLayoutDirection()
            if (r15 != r6) goto L_0x0060
            r15 = r14[r6]
            int r15 = r15 + r3
            r14 = r14[r5]
        L_0x005d:
            int r14 = r7 - r14
            goto L_0x0068
        L_0x0060:
            r15 = r14[r5]
            int r15 = r15 + r3
            r14 = r14[r6]
            goto L_0x005d
        L_0x0066:
            r15 = r3
            r14 = r7
        L_0x0068:
            boolean r13 = r0.canDrawDivider(r13)
            if (r13 == 0) goto L_0x0094
            android.graphics.drawable.Drawable r13 = r0.mDivider
            float r16 = r10.getAlpha()
            r17 = 1132396544(0x437f0000, float:255.0)
            float r6 = r16 * r17
            int r6 = (int) r6
            r13.setAlpha(r6)
            android.graphics.drawable.Drawable r6 = r0.mDivider
            float r12 = (float) r12
            float r13 = r10.getTranslationY()
            float r12 = r12 + r13
            int r12 = (int) r12
            float r11 = (float) r11
            float r10 = r10.getTranslationY()
            float r11 = r11 + r10
            int r10 = (int) r11
            r6.setBounds(r15, r12, r14, r10)
            android.graphics.drawable.Drawable r6 = r0.mDivider
            r6.draw(r1)
        L_0x0094:
            int r9 = r9 + 1
            r6 = 1
            goto L_0x002b
        L_0x0098:
            int r3 = r20.getPaddingTop()
            int r6 = r20.getHeight()
            int r7 = r20.getPaddingBottom()
            int r6 = r6 - r7
            int r7 = r20.getChildCount()
            r8 = r5
        L_0x00aa:
            if (r8 >= r7) goto L_0x00ee
            android.view.View r9 = r2.getChildAt(r8)
            android.view.ViewGroup$LayoutParams r10 = r9.getLayoutParams()
            androidx.recyclerview.widget.RecyclerView$LayoutParams r10 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r10
            int r11 = r9.getRight()
            int r10 = r10.rightMargin
            int r11 = r11 + r10
            int r10 = r0.mDividerWidth
            int r10 = r10 + r11
            int r9 = r2.getChildLayoutPosition(r9)
            flyme.support.v7.widget.MzItemDecoration$DividerPadding r12 = r0.mDividerPadding
            if (r12 == 0) goto L_0x00d8
            int[] r12 = r12.getDividerPadding(r9)
            int r13 = r12.length
            if (r13 != r4) goto L_0x00d8
            r13 = r12[r5]
            int r13 = r13 + r3
            r14 = 1
            r12 = r12[r14]
            int r12 = r6 - r12
            goto L_0x00db
        L_0x00d8:
            r14 = 1
            r13 = r3
            r12 = r6
        L_0x00db:
            boolean r9 = r0.canDrawDivider(r9)
            if (r9 == 0) goto L_0x00eb
            android.graphics.drawable.Drawable r9 = r0.mDivider
            r9.setBounds(r11, r13, r10, r12)
            android.graphics.drawable.Drawable r9 = r0.mDivider
            r9.draw(r1)
        L_0x00eb:
            int r8 = r8 + 1
            goto L_0x00aa
        L_0x00ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.MzItemDecoration.onDrawOverChildren(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    public void setDivider(Drawable drawable) {
        if (drawable != null) {
            this.mDividerHeight = drawable.getIntrinsicHeight();
            this.mDividerWidth = drawable.getIntrinsicWidth();
        } else {
            this.mDividerHeight = 0;
            this.mDividerWidth = 0;
        }
        this.mDivider = drawable;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.invalidate();
        }
    }

    public void setDividerHeight(int i) {
        this.mDividerHeight = i;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.requestLayout();
            this.mRecyclerView.invalidate();
        }
    }

    public void setDividerPadding(DividerPadding dividerPadding) {
        this.mDividerPadding = dividerPadding;
    }

    public MzItemDecoration(Context context, Drawable drawable) {
        if (drawable != null) {
            setDivider(drawable);
        }
    }
}
