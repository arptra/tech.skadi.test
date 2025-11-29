package com.upuphone.ar.tici.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.phone.widget.TiciScreenLocationView;
import com.upuphone.ar.tici.phone.widget.TiciSettingCardItem;
import com.upuphone.ar.tici.phone.widget.TiciTitleBar;

public final class TiciSettingBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5870a;
    public final TiciSettingCardItem b;
    public final TiciSettingCardItem c;
    public final TiciSettingCardItem d;
    public final TiciSettingCardItem e;
    public final TiciSettingCardItem f;
    public final TiciModeAutoSettingBinding g;
    public final TiciSettingCardItem h;
    public final TiciScreenLocationView i;
    public final TiciTitleBar j;

    public TiciSettingBinding(ConstraintLayout constraintLayout, TiciSettingCardItem ticiSettingCardItem, TiciSettingCardItem ticiSettingCardItem2, TiciSettingCardItem ticiSettingCardItem3, TiciSettingCardItem ticiSettingCardItem4, TiciSettingCardItem ticiSettingCardItem5, TiciModeAutoSettingBinding ticiModeAutoSettingBinding, TiciSettingCardItem ticiSettingCardItem6, TiciScreenLocationView ticiScreenLocationView, TiciTitleBar ticiTitleBar) {
        this.f5870a = constraintLayout;
        this.b = ticiSettingCardItem;
        this.c = ticiSettingCardItem2;
        this.d = ticiSettingCardItem3;
        this.e = ticiSettingCardItem4;
        this.f = ticiSettingCardItem5;
        this.g = ticiModeAutoSettingBinding;
        this.h = ticiSettingCardItem6;
        this.i = ticiScreenLocationView;
        this.j = ticiTitleBar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = com.upuphone.ar.tici.R.id.lay_tici_mode_auto_setting;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.tici.databinding.TiciSettingBinding a(android.view.View r13) {
        /*
            int r0 = com.upuphone.ar.tici.R.id.lay_do_not_disturb_setting
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            r4 = r1
            com.upuphone.ar.tici.phone.widget.TiciSettingCardItem r4 = (com.upuphone.ar.tici.phone.widget.TiciSettingCardItem) r4
            if (r4 == 0) goto L_0x006e
            int r0 = com.upuphone.ar.tici.R.id.lay_notification_setting
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            r5 = r1
            com.upuphone.ar.tici.phone.widget.TiciSettingCardItem r5 = (com.upuphone.ar.tici.phone.widget.TiciSettingCardItem) r5
            if (r5 == 0) goto L_0x006e
            int r0 = com.upuphone.ar.tici.R.id.lay_reset_tici_file
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            r6 = r1
            com.upuphone.ar.tici.phone.widget.TiciSettingCardItem r6 = (com.upuphone.ar.tici.phone.widget.TiciSettingCardItem) r6
            if (r6 == 0) goto L_0x006e
            int r0 = com.upuphone.ar.tici.R.id.lay_tici_mode_ai
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            r7 = r1
            com.upuphone.ar.tici.phone.widget.TiciSettingCardItem r7 = (com.upuphone.ar.tici.phone.widget.TiciSettingCardItem) r7
            if (r7 == 0) goto L_0x006e
            int r0 = com.upuphone.ar.tici.R.id.lay_tici_mode_auto
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            r8 = r1
            com.upuphone.ar.tici.phone.widget.TiciSettingCardItem r8 = (com.upuphone.ar.tici.phone.widget.TiciSettingCardItem) r8
            if (r8 == 0) goto L_0x006e
            int r0 = com.upuphone.ar.tici.R.id.lay_tici_mode_auto_setting
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            if (r1 == 0) goto L_0x006e
            com.upuphone.ar.tici.databinding.TiciModeAutoSettingBinding r9 = com.upuphone.ar.tici.databinding.TiciModeAutoSettingBinding.a(r1)
            int r0 = com.upuphone.ar.tici.R.id.lay_tici_mode_manual
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            r10 = r1
            com.upuphone.ar.tici.phone.widget.TiciSettingCardItem r10 = (com.upuphone.ar.tici.phone.widget.TiciSettingCardItem) r10
            if (r10 == 0) goto L_0x006e
            int r0 = com.upuphone.ar.tici.R.id.tici_screen_location_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            r11 = r1
            com.upuphone.ar.tici.phone.widget.TiciScreenLocationView r11 = (com.upuphone.ar.tici.phone.widget.TiciScreenLocationView) r11
            if (r11 == 0) goto L_0x006e
            int r0 = com.upuphone.ar.tici.R.id.title_bar
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r13, r0)
            r12 = r1
            com.upuphone.ar.tici.phone.widget.TiciTitleBar r12 = (com.upuphone.ar.tici.phone.widget.TiciTitleBar) r12
            if (r12 == 0) goto L_0x006e
            com.upuphone.ar.tici.databinding.TiciSettingBinding r0 = new com.upuphone.ar.tici.databinding.TiciSettingBinding
            r3 = r13
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x006e:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.databinding.TiciSettingBinding.a(android.view.View):com.upuphone.ar.tici.databinding.TiciSettingBinding");
    }

    public static TiciSettingBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static TiciSettingBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.tici_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5870a;
    }
}
