package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.CardItemView;
import com.upuphone.xr.sapp.view.SappTitleBar;

public final class FragmentVoiceprintInfoBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6825a;
    public final CardItemView b;
    public final CardItemView c;
    public final SappTitleBar d;

    public FragmentVoiceprintInfoBinding(ConstraintLayout constraintLayout, CardItemView cardItemView, CardItemView cardItemView2, SappTitleBar sappTitleBar) {
        this.f6825a = constraintLayout;
        this.b = cardItemView;
        this.c = cardItemView2;
        this.d = sappTitleBar;
    }

    public static FragmentVoiceprintInfoBinding a(View view) {
        int i = R.id.civ_separate_role;
        CardItemView cardItemView = (CardItemView) ViewBindings.a(view, i);
        if (cardItemView != null) {
            i = R.id.civ_voice_wake;
            CardItemView cardItemView2 = (CardItemView) ViewBindings.a(view, i);
            if (cardItemView2 != null) {
                i = R.id.title_bar;
                SappTitleBar sappTitleBar = (SappTitleBar) ViewBindings.a(view, i);
                if (sappTitleBar != null) {
                    return new FragmentVoiceprintInfoBinding((ConstraintLayout) view, cardItemView, cardItemView2, sappTitleBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentVoiceprintInfoBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_voiceprint_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6825a;
    }
}
