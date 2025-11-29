package com.chad.library.adapter.base.listener;

import androidx.recyclerview.widget.RecyclerView;

public interface OnItemDragListener {
    void a(RecyclerView.ViewHolder viewHolder, int i);

    void b(RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder2, int i2);

    void c(RecyclerView.ViewHolder viewHolder, int i);
}
