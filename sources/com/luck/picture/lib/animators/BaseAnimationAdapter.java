package com.luck.picture.lib.animators;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseAnimationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView.Adapter f9378a;
    public int b = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    public Interpolator c = new LinearInterpolator();
    public int d = -1;
    public boolean e = true;

    public BaseAnimationAdapter(RecyclerView.Adapter adapter) {
        this.f9378a = adapter;
    }

    public abstract Animator[] g(View view);

    public int getItemCount() {
        return this.f9378a.getItemCount();
    }

    public long getItemId(int i) {
        return this.f9378a.getItemId(i);
    }

    public int getItemViewType(int i) {
        return this.f9378a.getItemViewType(i);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f9378a.onAttachedToRecyclerView(recyclerView);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        this.f9378a.onBindViewHolder(viewHolder, i);
        int adapterPosition = viewHolder.getAdapterPosition();
        if (!this.e || adapterPosition > this.d) {
            for (Animator animator : g(viewHolder.itemView)) {
                animator.setDuration((long) this.b).start();
                animator.setInterpolator(this.c);
            }
            this.d = adapterPosition;
            return;
        }
        ViewHelper.a(viewHolder.itemView);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.f9378a.onCreateViewHolder(viewGroup, i);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f9378a.onDetachedFromRecyclerView(recyclerView);
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        this.f9378a.onViewAttachedToWindow(viewHolder);
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        this.f9378a.onViewDetachedFromWindow(viewHolder);
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        this.f9378a.onViewRecycled(viewHolder);
        super.onViewRecycled(viewHolder);
    }

    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.f9378a.registerAdapterDataObserver(adapterDataObserver);
    }

    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.f9378a.unregisterAdapterDataObserver(adapterDataObserver);
    }
}
