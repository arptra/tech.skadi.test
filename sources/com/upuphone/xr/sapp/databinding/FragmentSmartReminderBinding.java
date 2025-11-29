package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.meizu.common.widget.Switch;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.CardItemView;

public final class FragmentSmartReminderBinding implements ViewBinding {
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final Switch D;
    public final TextView E;
    public final TextView F;
    public final ConstraintLayout G;
    public final Switch H;
    public final TextView I;
    public final TextView J;
    public final ConstraintLayout K;
    public final TextView L;
    public final TextView M;

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6816a;
    public final TextView b;
    public final View c;
    public final ConstraintLayout d;
    public final CardItemView e;
    public final TextView f;
    public final TextView g;
    public final ImageView h;
    public final TextView i;
    public final ConstraintLayout j;
    public final TextView k;
    public final ConstraintLayout l;
    public final ConstraintLayout m;
    public final AppCompatTextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final AppCompatImageView r;
    public final ConstraintLayout s;
    public final TextView t;
    public final Switch u;
    public final TextView v;
    public final TextView w;
    public final LinearLayout x;
    public final ConstraintLayout y;
    public final ConstraintLayout z;

    public FragmentSmartReminderBinding(ConstraintLayout constraintLayout, TextView textView, View view, ConstraintLayout constraintLayout2, CardItemView cardItemView, TextView textView2, TextView textView3, ImageView imageView, TextView textView4, ConstraintLayout constraintLayout3, TextView textView5, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, AppCompatTextView appCompatTextView, TextView textView6, TextView textView7, TextView textView8, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout6, TextView textView9, Switch switchR, TextView textView10, TextView textView11, LinearLayout linearLayout, ConstraintLayout constraintLayout7, ConstraintLayout constraintLayout8, TextView textView12, TextView textView13, TextView textView14, Switch switchR2, TextView textView15, TextView textView16, ConstraintLayout constraintLayout9, Switch switchR3, TextView textView17, TextView textView18, ConstraintLayout constraintLayout10, TextView textView19, TextView textView20) {
        this.f6816a = constraintLayout;
        this.b = textView;
        this.c = view;
        this.d = constraintLayout2;
        this.e = cardItemView;
        this.f = textView2;
        this.g = textView3;
        this.h = imageView;
        this.i = textView4;
        this.j = constraintLayout3;
        this.k = textView5;
        this.l = constraintLayout4;
        this.m = constraintLayout5;
        this.n = appCompatTextView;
        this.o = textView6;
        this.p = textView7;
        this.q = textView8;
        this.r = appCompatImageView;
        this.s = constraintLayout6;
        this.t = textView9;
        this.u = switchR;
        this.v = textView10;
        this.w = textView11;
        this.x = linearLayout;
        this.y = constraintLayout7;
        this.z = constraintLayout8;
        this.A = textView12;
        this.B = textView13;
        this.C = textView14;
        this.D = switchR2;
        this.E = textView15;
        this.F = textView16;
        this.G = constraintLayout9;
        this.H = switchR3;
        this.I = textView17;
        this.J = textView18;
        this.K = constraintLayout10;
        this.L = textView19;
        this.M = textView20;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.upuphone.xr.sapp.R.id.mock_test;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.xr.sapp.databinding.FragmentSmartReminderBinding a(android.view.View r43) {
        /*
            r0 = r43
            int r1 = com.upuphone.xr.sapp.R.id.back_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r5 = r2
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.mock_test
            android.view.View r6 = androidx.viewbinding.ViewBindings.a(r0, r1)
            if (r6 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.no_answer_call_alert_off
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.no_answer_call_alert_on
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r8 = r2
            com.upuphone.xr.sapp.view.CardItemView r8 = (com.upuphone.xr.sapp.view.CardItemView) r8
            if (r8 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.no_answer_subtitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.no_answer_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.notify_dismiss_arrow_right
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.notify_dismiss_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.notify_dismiss_item
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r13 = r2
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            if (r13 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.notify_dismiss_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.notify_miss_call
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r15 = r2
            androidx.constraintlayout.widget.ConstraintLayout r15 = (androidx.constraintlayout.widget.ConstraintLayout) r15
            if (r15 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.notify_setting
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r16 = r2
            androidx.constraintlayout.widget.ConstraintLayout r16 = (androidx.constraintlayout.widget.ConstraintLayout) r16
            if (r16 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.notify_type_setting_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r17 = r2
            androidx.appcompat.widget.AppCompatTextView r17 = (androidx.appcompat.widget.AppCompatTextView) r17
            if (r17 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.open_alert_permission
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_broadcast
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_broadcast_pause
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_broadcast_pause_image
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r21 = r2
            androidx.appcompat.widget.AppCompatImageView r21 = (androidx.appcompat.widget.AppCompatImageView) r21
            if (r21 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_broadcast_pause_lay
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r22 = r2
            androidx.constraintlayout.widget.ConstraintLayout r22 = (androidx.constraintlayout.widget.ConstraintLayout) r22
            if (r22 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_broadcast_pause_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_broadcast_switch
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r24 = r2
            com.meizu.common.widget.Switch r24 = (com.meizu.common.widget.Switch) r24
            if (r24 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_broadcast_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r25 = r2
            android.widget.TextView r25 = (android.widget.TextView) r25
            if (r25 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_notify
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r26 = r2
            android.widget.TextView r26 = (android.widget.TextView) r26
            if (r26 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_notify_broadcast
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r27 = r2
            android.widget.LinearLayout r27 = (android.widget.LinearLayout) r27
            if (r27 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_notify_broadcast_lay
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r28 = r2
            androidx.constraintlayout.widget.ConstraintLayout r28 = (androidx.constraintlayout.widget.ConstraintLayout) r28
            if (r28 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_notify_screen
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r29 = r2
            androidx.constraintlayout.widget.ConstraintLayout r29 = (androidx.constraintlayout.widget.ConstraintLayout) r29
            if (r29 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_notify_state
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r30 = r2
            android.widget.TextView r30 = (android.widget.TextView) r30
            if (r30 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_notify_sub
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r31 = r2
            android.widget.TextView r31 = (android.widget.TextView) r31
            if (r31 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_screen
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r32 = r2
            android.widget.TextView r32 = (android.widget.TextView) r32
            if (r32 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_screen_switch
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r33 = r2
            com.meizu.common.widget.Switch r33 = (com.meizu.common.widget.Switch) r33
            if (r33 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_screen_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r34 = r2
            android.widget.TextView r34 = (android.widget.TextView) r34
            if (r34 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_using_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r35 = r2
            android.widget.TextView r35 = (android.widget.TextView) r35
            if (r35 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_using_lay
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r36 = r2
            androidx.constraintlayout.widget.ConstraintLayout r36 = (androidx.constraintlayout.widget.ConstraintLayout) r36
            if (r36 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_using_switch
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r37 = r2
            com.meizu.common.widget.Switch r37 = (com.meizu.common.widget.Switch) r37
            if (r37 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.phone_using_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r38 = r2
            android.widget.TextView r38 = (android.widget.TextView) r38
            if (r38 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.wise_notify
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r39 = r2
            android.widget.TextView r39 = (android.widget.TextView) r39
            if (r39 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.wise_notify_item
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r40 = r2
            androidx.constraintlayout.widget.ConstraintLayout r40 = (androidx.constraintlayout.widget.ConstraintLayout) r40
            if (r40 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.wise_notify_state
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r41 = r2
            android.widget.TextView r41 = (android.widget.TextView) r41
            if (r41 == 0) goto L_0x01c6
            int r1 = com.upuphone.xr.sapp.R.id.wise_notify_sub_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r42 = r2
            android.widget.TextView r42 = (android.widget.TextView) r42
            if (r42 == 0) goto L_0x01c6
            com.upuphone.xr.sapp.databinding.FragmentSmartReminderBinding r1 = new com.upuphone.xr.sapp.databinding.FragmentSmartReminderBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
            return r1
        L_0x01c6:
            android.content.res.Resources r0 = r43.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.databinding.FragmentSmartReminderBinding.a(android.view.View):com.upuphone.xr.sapp.databinding.FragmentSmartReminderBinding");
    }

    public static FragmentSmartReminderBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View inflate = layoutInflater.inflate(R.layout.fragment_smart_reminder, viewGroup, false);
        if (z2) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6816a;
    }
}
