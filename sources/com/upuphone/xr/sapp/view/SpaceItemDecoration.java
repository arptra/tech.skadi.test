package com.upuphone.xr.sapp.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f7986a;
    public int b;

    public SpaceItemDecoration(int i, int i2) {
        this.f7986a = i;
        this.b = i2;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (recyclerView.getChildPosition(view) == 0) {
            rect.left = this.b;
            rect.right = this.f7986a;
        } else if (recyclerView.getChildPosition(view) == linearLayoutManager.getItemCount() - 1) {
            rect.right = this.b;
        } else {
            rect.right = this.f7986a;
        }
    }
}
