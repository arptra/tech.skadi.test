package com.upuphone.ar.transcribe.phone.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f6127a;
    public int b;
    public boolean c;

    public GridSpacingItemDecoration(int i, int i2, boolean z) {
        this.f6127a = i;
        this.b = i2;
        this.c = z;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.f6127a;
        int i2 = childAdapterPosition % i;
        if (this.c) {
            int i3 = this.b;
            rect.left = i3 - ((i2 * i3) / i);
            rect.right = ((i2 + 1) * i3) / i;
            if (childAdapterPosition < i) {
                rect.top = i3;
            }
            rect.bottom = i3;
            return;
        }
        int i4 = this.b;
        rect.left = (i2 * i4) / i;
        rect.right = i4 - (((i2 + 1) * i4) / i);
        if (i2 == 0) {
            rect.left = 0;
            rect.right = 0;
        } else if (i2 == i - 1) {
            rect.left = 0;
            rect.right = 0;
        }
        rect.bottom = i4;
    }
}
