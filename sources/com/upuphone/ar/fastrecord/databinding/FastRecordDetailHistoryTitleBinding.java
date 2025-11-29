package com.upuphone.ar.fastrecord.databinding;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordDetailTitleBar;
import com.upuphone.ar.fastrecord.phone.ui.widget.SpeechRecognitionPlayerView;

public final class FastRecordDetailHistoryTitleBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5584a;
    public final ImageView b;
    public final FastRecordLayoutRecordDetailTagBinding c;
    public final LinearLayout d;
    public final FastRecordDetailTitleBar e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final SpeechRecognitionPlayerView i;

    public FastRecordDetailHistoryTitleBinding(ConstraintLayout constraintLayout, ImageView imageView, FastRecordLayoutRecordDetailTagBinding fastRecordLayoutRecordDetailTagBinding, LinearLayout linearLayout, FastRecordDetailTitleBar fastRecordDetailTitleBar, TextView textView, TextView textView2, TextView textView3, SpeechRecognitionPlayerView speechRecognitionPlayerView) {
        this.f5584a = constraintLayout;
        this.b = imageView;
        this.c = fastRecordLayoutRecordDetailTagBinding;
        this.d = linearLayout;
        this.e = fastRecordDetailTitleBar;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = speechRecognitionPlayerView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.upuphone.ar.fastrecord.R.id.ll_all_record_tag;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.fastrecord.databinding.FastRecordDetailHistoryTitleBinding a(android.view.View r12) {
        /*
            int r0 = com.upuphone.ar.fastrecord.R.id.iv_split
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0063
            int r0 = com.upuphone.ar.fastrecord.R.id.ll_all_record_tag
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            if (r1 == 0) goto L_0x0063
            com.upuphone.ar.fastrecord.databinding.FastRecordLayoutRecordDetailTagBinding r5 = com.upuphone.ar.fastrecord.databinding.FastRecordLayoutRecordDetailTagBinding.a(r1)
            int r0 = com.upuphone.ar.fastrecord.R.id.ll_location
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r6 = r1
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x0063
            int r0 = com.upuphone.ar.fastrecord.R.id.title_bar
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r7 = r1
            com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordDetailTitleBar r7 = (com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordDetailTitleBar) r7
            if (r7 == 0) goto L_0x0063
            int r0 = com.upuphone.ar.fastrecord.R.id.tv_create_time
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0063
            int r0 = com.upuphone.ar.fastrecord.R.id.tv_record_location
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0063
            int r0 = com.upuphone.ar.fastrecord.R.id.tv_record_time
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0063
            int r0 = com.upuphone.ar.fastrecord.R.id.v_record_cpt
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r12, r0)
            r11 = r1
            com.upuphone.ar.fastrecord.phone.ui.widget.SpeechRecognitionPlayerView r11 = (com.upuphone.ar.fastrecord.phone.ui.widget.SpeechRecognitionPlayerView) r11
            if (r11 == 0) goto L_0x0063
            com.upuphone.ar.fastrecord.databinding.FastRecordDetailHistoryTitleBinding r0 = new com.upuphone.ar.fastrecord.databinding.FastRecordDetailHistoryTitleBinding
            r3 = r12
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x0063:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.databinding.FastRecordDetailHistoryTitleBinding.a(android.view.View):com.upuphone.ar.fastrecord.databinding.FastRecordDetailHistoryTitleBinding");
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5584a;
    }
}
