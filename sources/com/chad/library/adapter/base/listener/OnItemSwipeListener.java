package com.chad.library.adapter.base.listener;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;

public interface OnItemSwipeListener {
    void a(RecyclerView.ViewHolder viewHolder, int i);

    void b(RecyclerView.ViewHolder viewHolder, int i);

    void c(Canvas canvas, RecyclerView.ViewHolder viewHolder, float f, float f2, boolean z);

    void d(RecyclerView.ViewHolder viewHolder, int i);
}
