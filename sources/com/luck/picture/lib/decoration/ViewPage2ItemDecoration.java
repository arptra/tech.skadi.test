package com.luck.picture.lib.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPage2ItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public final int f9408a;
    public final int b;

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.f9408a;
        int i2 = childAdapterPosition % i;
        int i3 = this.b;
        rect.left = i3 - ((i2 * i3) / i);
        rect.right = ((i2 + 1) * i3) / i;
    }
}
