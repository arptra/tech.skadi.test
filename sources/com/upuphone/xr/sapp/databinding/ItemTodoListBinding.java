package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.MultiFuncEditText;

public final class ItemTodoListBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6854a;
    public final CheckBox b;
    public final CheckBox c;
    public final MultiFuncEditText d;
    public final TextView e;
    public final ConstraintLayout f;

    public ItemTodoListBinding(LinearLayout linearLayout, CheckBox checkBox, CheckBox checkBox2, MultiFuncEditText multiFuncEditText, TextView textView, ConstraintLayout constraintLayout) {
        this.f6854a = linearLayout;
        this.b = checkBox;
        this.c = checkBox2;
        this.d = multiFuncEditText;
        this.e = textView;
        this.f = constraintLayout;
    }

    public static ItemTodoListBinding a(View view) {
        int i = R.id.cb_select;
        CheckBox checkBox = (CheckBox) ViewBindings.a(view, i);
        if (checkBox != null) {
            i = R.id.cb_todo_state;
            CheckBox checkBox2 = (CheckBox) ViewBindings.a(view, i);
            if (checkBox2 != null) {
                i = R.id.et_todo_content;
                MultiFuncEditText multiFuncEditText = (MultiFuncEditText) ViewBindings.a(view, i);
                if (multiFuncEditText != null) {
                    i = R.id.tv_todo_content;
                    TextView textView = (TextView) ViewBindings.a(view, i);
                    if (textView != null) {
                        i = R.id.vg_main;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i);
                        if (constraintLayout != null) {
                            return new ItemTodoListBinding((LinearLayout) view, checkBox, checkBox2, multiFuncEditText, textView, constraintLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemTodoListBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_todo_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6854a;
    }
}
