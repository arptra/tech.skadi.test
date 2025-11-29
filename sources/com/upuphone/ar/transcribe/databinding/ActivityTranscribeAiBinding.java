package com.upuphone.ar.transcribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.phone.view.TransTitleBar;

public final class ActivityTranscribeAiBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6032a;
    public final TabLayout b;
    public final TransTitleBar c;
    public final ViewPager2 d;

    public ActivityTranscribeAiBinding(ConstraintLayout constraintLayout, TabLayout tabLayout, TransTitleBar transTitleBar, ViewPager2 viewPager2) {
        this.f6032a = constraintLayout;
        this.b = tabLayout;
        this.c = transTitleBar;
        this.d = viewPager2;
    }

    public static ActivityTranscribeAiBinding a(View view) {
        int i = R.id.tb_intel;
        TabLayout tabLayout = (TabLayout) ViewBindings.a(view, i);
        if (tabLayout != null) {
            i = R.id.title_bar;
            TransTitleBar transTitleBar = (TransTitleBar) ViewBindings.a(view, i);
            if (transTitleBar != null) {
                i = R.id.vp_intel;
                ViewPager2 viewPager2 = (ViewPager2) ViewBindings.a(view, i);
                if (viewPager2 != null) {
                    return new ActivityTranscribeAiBinding((ConstraintLayout) view, tabLayout, transTitleBar, viewPager2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityTranscribeAiBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTranscribeAiBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_transcribe_ai, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6032a;
    }
}
