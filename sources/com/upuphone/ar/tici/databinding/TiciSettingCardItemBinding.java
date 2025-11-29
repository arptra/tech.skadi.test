package com.upuphone.ar.tici.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.meizu.common.widget.Switch;
import com.upuphone.ar.tici.R;

public final class TiciSettingCardItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f5871a;
    public final View b;
    public final View c;
    public final View d;
    public final ProgressBar e;
    public final Switch f;
    public final TextView g;
    public final TextView h;
    public final View i;

    public TiciSettingCardItemBinding(View view, View view2, View view3, View view4, ProgressBar progressBar, Switch switchR, TextView textView, TextView textView2, View view5) {
        this.f5871a = view;
        this.b = view2;
        this.c = view3;
        this.d = view4;
        this.e = progressBar;
        this.f = switchR;
        this.g = textView;
        this.h = textView2;
        this.i = view5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        r0 = com.upuphone.ar.tici.R.id.view_bottom_line;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = com.upuphone.ar.tici.R.id.check_view;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = com.upuphone.ar.tici.R.id.padding_placeholder;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.tici.databinding.TiciSettingCardItemBinding a(android.view.View r11) {
        /*
            int r0 = com.upuphone.ar.tici.R.id.arrow_view
            android.view.View r3 = androidx.viewbinding.ViewBindings.a(r11, r0)
            if (r3 == 0) goto L_0x0054
            int r0 = com.upuphone.ar.tici.R.id.check_view
            android.view.View r4 = androidx.viewbinding.ViewBindings.a(r11, r0)
            if (r4 == 0) goto L_0x0054
            int r0 = com.upuphone.ar.tici.R.id.padding_placeholder
            android.view.View r5 = androidx.viewbinding.ViewBindings.a(r11, r0)
            if (r5 == 0) goto L_0x0054
            int r0 = com.upuphone.ar.tici.R.id.progress_bar
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r11, r0)
            r6 = r1
            android.widget.ProgressBar r6 = (android.widget.ProgressBar) r6
            if (r6 == 0) goto L_0x0054
            int r0 = com.upuphone.ar.tici.R.id.switch_setting
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r11, r0)
            r7 = r1
            com.meizu.common.widget.Switch r7 = (com.meizu.common.widget.Switch) r7
            if (r7 == 0) goto L_0x0054
            int r0 = com.upuphone.ar.tici.R.id.tv_setting_sub_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r11, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0054
            int r0 = com.upuphone.ar.tici.R.id.tv_setting_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r11, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0054
            int r0 = com.upuphone.ar.tici.R.id.view_bottom_line
            android.view.View r10 = androidx.viewbinding.ViewBindings.a(r11, r0)
            if (r10 == 0) goto L_0x0054
            com.upuphone.ar.tici.databinding.TiciSettingCardItemBinding r0 = new com.upuphone.ar.tici.databinding.TiciSettingCardItemBinding
            r1 = r0
            r2 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0054:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.databinding.TiciSettingCardItemBinding.a(android.view.View):com.upuphone.ar.tici.databinding.TiciSettingCardItemBinding");
    }

    public static TiciSettingCardItemBinding b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.tici_setting_card_item, viewGroup);
            return a(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    public View getRoot() {
        return this.f5871a;
    }
}
