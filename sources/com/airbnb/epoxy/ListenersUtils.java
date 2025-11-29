package com.airbnb.epoxy;

import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;

public class ListenersUtils {
    public static RecyclerView a(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof RecyclerView) {
            return (RecyclerView) parent;
        }
        if (parent instanceof View) {
            return a((View) parent);
        }
        return null;
    }

    public static EpoxyViewHolder b(View view) {
        RecyclerView.ViewHolder findContainingViewHolder;
        RecyclerView a2 = a(view);
        if (a2 == null || (findContainingViewHolder = a2.findContainingViewHolder(view)) == null || !(findContainingViewHolder instanceof EpoxyViewHolder)) {
            return null;
        }
        return (EpoxyViewHolder) findContainingViewHolder;
    }
}
