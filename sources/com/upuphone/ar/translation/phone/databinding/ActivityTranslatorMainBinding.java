package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.view.TransFuncItem;
import com.upuphone.ar.translation.phone.view.TransTitleBar;

public final class ActivityTranslatorMainBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6238a;
    public final CoordinatorLayout b;
    public final LinearLayout c;
    public final ConstraintLayout d;
    public final ConstraintLayout e;
    public final ConstraintLayout f;
    public final Guideline g;
    public final Group h;
    public final ImageView i;
    public final ImageView j;
    public final LinearLayout k;
    public final TabLayout l;
    public final TransFuncItem m;
    public final TransFuncItem n;
    public final TransFuncItem o;
    public final TransTitleBar p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final View v;
    public final View w;
    public final ViewPager2 x;

    public ActivityTranslatorMainBinding(ConstraintLayout constraintLayout, CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, Guideline guideline, Group group, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, TabLayout tabLayout, TransFuncItem transFuncItem, TransFuncItem transFuncItem2, TransFuncItem transFuncItem3, TransTitleBar transTitleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view, View view2, ViewPager2 viewPager2) {
        this.f6238a = constraintLayout;
        this.b = coordinatorLayout;
        this.c = linearLayout;
        this.d = constraintLayout2;
        this.e = constraintLayout3;
        this.f = constraintLayout4;
        this.g = guideline;
        this.h = group;
        this.i = imageView;
        this.j = imageView2;
        this.k = linearLayout2;
        this.l = tabLayout;
        this.m = transFuncItem;
        this.n = transFuncItem2;
        this.o = transFuncItem3;
        this.p = transTitleBar;
        this.q = textView;
        this.r = textView2;
        this.s = textView3;
        this.t = textView4;
        this.u = textView5;
        this.v = view;
        this.w = view2;
        this.x = viewPager2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e7, code lost:
        r1 = com.upuphone.ar.translation.phone.R.id.v_tab_disable;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ef, code lost:
        r1 = com.upuphone.ar.translation.phone.R.id.v_telephone_line;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.translation.phone.databinding.ActivityTranslatorMainBinding a(android.view.View r28) {
        /*
            r0 = r28
            int r1 = com.upuphone.ar.translation.phone.R.id.cl_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r5 = r2
            androidx.coordinatorlayout.widget.CoordinatorLayout r5 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r5
            if (r5 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.cl_multi_foot
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r6 = r2
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.cl_multi_head
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.cl_telephone_user_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.cl_trans_head
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r9 = r2
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.gl_tfi
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r10 = r2
            androidx.constraintlayout.widget.Guideline r10 = (androidx.constraintlayout.widget.Guideline) r10
            if (r10 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.gp_multi
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r11 = r2
            androidx.constraintlayout.widget.Group r11 = (androidx.constraintlayout.widget.Group) r11
            if (r11 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.iv_multi_delete
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.iv_telephone_delete
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.ll_no_data
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r14 = r2
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            if (r14 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.tb_records
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r15 = r2
            com.google.android.material.tabs.TabLayout r15 = (com.google.android.material.tabs.TabLayout) r15
            if (r15 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.tf_dialog_trans
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r16 = r2
            com.upuphone.ar.translation.phone.view.TransFuncItem r16 = (com.upuphone.ar.translation.phone.view.TransFuncItem) r16
            if (r16 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.tf_simul_trans
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r17 = r2
            com.upuphone.ar.translation.phone.view.TransFuncItem r17 = (com.upuphone.ar.translation.phone.view.TransFuncItem) r17
            if (r17 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.tf_transcribe
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r18 = r2
            com.upuphone.ar.translation.phone.view.TransFuncItem r18 = (com.upuphone.ar.translation.phone.view.TransFuncItem) r18
            if (r18 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.title_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r19 = r2
            com.upuphone.ar.translation.phone.view.TransTitleBar r19 = (com.upuphone.ar.translation.phone.view.TransTitleBar) r19
            if (r19 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.tv_multi_cancel
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.tv_multi_delete
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.tv_multi_options
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.tv_multi_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.tv_telephone_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.v_tab_disable
            android.view.View r25 = androidx.viewbinding.ViewBindings.a(r0, r1)
            if (r25 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.v_telephone_line
            android.view.View r26 = androidx.viewbinding.ViewBindings.a(r0, r1)
            if (r26 == 0) goto L_0x010d
            int r1 = com.upuphone.ar.translation.phone.R.id.vp_records
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r27 = r2
            androidx.viewpager2.widget.ViewPager2 r27 = (androidx.viewpager2.widget.ViewPager2) r27
            if (r27 == 0) goto L_0x010d
            com.upuphone.ar.translation.phone.databinding.ActivityTranslatorMainBinding r1 = new com.upuphone.ar.translation.phone.databinding.ActivityTranslatorMainBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x010d:
            android.content.res.Resources r0 = r28.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.databinding.ActivityTranslatorMainBinding.a(android.view.View):com.upuphone.ar.translation.phone.databinding.ActivityTranslatorMainBinding");
    }

    public static ActivityTranslatorMainBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTranslatorMainBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_translator_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6238a;
    }
}
