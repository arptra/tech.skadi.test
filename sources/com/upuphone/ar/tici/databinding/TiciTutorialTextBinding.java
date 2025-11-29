package com.upuphone.ar.tici.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.upuphone.ar.tici.R;

public final class TiciTutorialTextBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f5874a;

    public TiciTutorialTextBinding(TextView textView) {
        this.f5874a = textView;
    }

    public static TiciTutorialTextBinding a(View view) {
        if (view != null) {
            return new TiciTutorialTextBinding((TextView) view);
        }
        throw new NullPointerException("rootView");
    }

    public static TiciTutorialTextBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.tici_tutorial_text, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public TextView getRoot() {
        return this.f5874a;
    }
}
