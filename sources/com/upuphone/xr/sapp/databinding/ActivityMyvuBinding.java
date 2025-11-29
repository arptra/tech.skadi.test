package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.BlockEventFrameLayout;

public final class ActivityMyvuBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6724a;
    public final FragmentContainerView b;
    public final View c;
    public final ConstraintLayout d;
    public final BlockEventFrameLayout e;
    public final LottieAnimationView f;
    public final ConstraintLayout g;

    public ActivityMyvuBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView, View view, ConstraintLayout constraintLayout2, BlockEventFrameLayout blockEventFrameLayout, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout3) {
        this.f6724a = constraintLayout;
        this.b = fragmentContainerView;
        this.c = view;
        this.d = constraintLayout2;
        this.e = blockEventFrameLayout;
        this.f = lottieAnimationView;
        this.g = constraintLayout3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.upuphone.xr.sapp.R.id.bottom_view;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.xr.sapp.databinding.ActivityMyvuBinding a(android.view.View r10) {
        /*
            int r0 = com.upuphone.xr.sapp.R.id.android_navi
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r10, r0)
            r4 = r1
            androidx.fragment.app.FragmentContainerView r4 = (androidx.fragment.app.FragmentContainerView) r4
            if (r4 == 0) goto L_0x003f
            int r0 = com.upuphone.xr.sapp.R.id.bottom_view
            android.view.View r5 = androidx.viewbinding.ViewBindings.a(r10, r0)
            if (r5 == 0) goto L_0x003f
            int r0 = com.upuphone.xr.sapp.R.id.factory_resetting_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r10, r0)
            r6 = r1
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x003f
            int r0 = com.upuphone.xr.sapp.R.id.home_fragment_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r10, r0)
            r7 = r1
            com.upuphone.xr.sapp.view.BlockEventFrameLayout r7 = (com.upuphone.xr.sapp.view.BlockEventFrameLayout) r7
            if (r7 == 0) goto L_0x003f
            int r0 = com.upuphone.xr.sapp.R.id.lottie_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r10, r0)
            r8 = r1
            com.airbnb.lottie.LottieAnimationView r8 = (com.airbnb.lottie.LottieAnimationView) r8
            if (r8 == 0) goto L_0x003f
            r9 = r10
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            com.upuphone.xr.sapp.databinding.ActivityMyvuBinding r10 = new com.upuphone.xr.sapp.databinding.ActivityMyvuBinding
            r2 = r10
            r3 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r10
        L_0x003f:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.databinding.ActivityMyvuBinding.a(android.view.View):com.upuphone.xr.sapp.databinding.ActivityMyvuBinding");
    }

    public static ActivityMyvuBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMyvuBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_myvu, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6724a;
    }
}
