package com.luck.picture.lib.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public final int f9407a;
    public final int b;

    public HorizontalItemDecoration(int i, int i2) {
        this.f9407a = i;
        this.b = i2;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.f9407a;
        int i2 = childAdapterPosition % i;
        if (childAdapterPosition == 0) {
            int i3 = this.b;
            rect.left = i3 - ((i2 * i3) / i);
        } else {
            rect.left = (this.b * i2) / i;
        }
        int i4 = this.b;
        rect.right = i4 - (((i2 + 1) * i4) / i);
        if (childAdapterPosition < i) {
            rect.top = i4;
        }
        rect.bottom = i4;
    }
}
