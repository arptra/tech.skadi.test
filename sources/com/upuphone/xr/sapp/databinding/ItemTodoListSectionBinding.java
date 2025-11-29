package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.xr.sapp.R;

public final class ItemTodoListSectionBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6855a;

    public ItemTodoListSectionBinding(ConstraintLayout constraintLayout) {
        this.f6855a = constraintLayout;
    }

    public static ItemTodoListSectionBinding a(View view) {
        if (view != null) {
            return new ItemTodoListSectionBinding((ConstraintLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static ItemTodoListSectionBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_todo_list_section, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6855a;
    }
}
