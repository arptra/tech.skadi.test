package com.upuphone.ar.transcribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.phone.view.ClipboardEditText;
import com.upuphone.ar.transcribe.phone.view.TransTitleBar;

public final class ActivityTranscribeDetailBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6033a;
    public final ConstraintLayout b;
    public final ConstraintLayout c;
    public final View d;
    public final Group e;
    public final NestedScrollView f;
    public final NestedScrollView g;
    public final RecyclerView h;
    public final TransTitleBar i;
    public final TextView j;
    public final ClipboardEditText k;
    public final TextView l;
    public final ClipboardEditText m;

    public ActivityTranscribeDetailBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, View view, Group group, NestedScrollView nestedScrollView, NestedScrollView nestedScrollView2, RecyclerView recyclerView, TransTitleBar transTitleBar, TextView textView, ClipboardEditText clipboardEditText, TextView textView2, ClipboardEditText clipboardEditText2) {
        this.f6033a = constraintLayout;
        this.b = constraintLayout2;
        this.c = constraintLayout3;
        this.d = view;
        this.e = group;
        this.f = nestedScrollView;
        this.g = nestedScrollView2;
        this.h = recyclerView;
        this.i = transTitleBar;
        this.j = textView;
        this.k = clipboardEditText;
        this.l = textView2;
        this.m = clipboardEditText2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r1 = com.upuphone.ar.transcribe.R.id.divider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding a(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.upuphone.ar.transcribe.R.id.content_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x008e
            int r1 = com.upuphone.ar.transcribe.R.id.detail_header
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x008e
            int r1 = com.upuphone.ar.transcribe.R.id.divider
            android.view.View r7 = androidx.viewbinding.ViewBindings.a(r0, r1)
            if (r7 == 0) goto L_0x008e
            int r1 = com.upuphone.ar.transcribe.R.id.location_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.Group r8 = (androidx.constraintlayout.widget.Group) r8
            if (r8 == 0) goto L_0x008e
            int r1 = com.upuphone.ar.transcribe.R.id.nsv_list
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r9 = r2
            androidx.core.widget.NestedScrollView r9 = (androidx.core.widget.NestedScrollView) r9
            if (r9 == 0) goto L_0x008e
            int r1 = com.upuphone.ar.transcribe.R.id.nsv_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r10 = r2
            androidx.core.widget.NestedScrollView r10 = (androidx.core.widget.NestedScrollView) r10
            if (r10 == 0) goto L_0x008e
            int r1 = com.upuphone.ar.transcribe.R.id.recycler_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r11 = r2
            androidx.recyclerview.widget.RecyclerView r11 = (androidx.recyclerview.widget.RecyclerView) r11
            if (r11 == 0) goto L_0x008e
            int r1 = com.upuphone.ar.transcribe.R.id.title_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r12 = r2
            com.upuphone.ar.transcribe.phone.view.TransTitleBar r12 = (com.upuphone.ar.transcribe.phone.view.TransTitleBar) r12
            if (r12 == 0) goto L_0x008e
            int r1 = com.upuphone.ar.transcribe.R.id.tv_location
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x008e
            int r1 = com.upuphone.ar.transcribe.R.id.tv_record
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r14 = r2
            com.upuphone.ar.transcribe.phone.view.ClipboardEditText r14 = (com.upuphone.ar.transcribe.phone.view.ClipboardEditText) r14
            if (r14 == 0) goto L_0x008e
            int r1 = com.upuphone.ar.transcribe.R.id.tv_record_time
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x008e
            int r1 = com.upuphone.ar.transcribe.R.id.tv_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r0, r1)
            r16 = r2
            com.upuphone.ar.transcribe.phone.view.ClipboardEditText r16 = (com.upuphone.ar.transcribe.phone.view.ClipboardEditText) r16
            if (r16 == 0) goto L_0x008e
            com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding r1 = new com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r1
        L_0x008e:
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding.a(android.view.View):com.upuphone.ar.transcribe.databinding.ActivityTranscribeDetailBinding");
    }

    public static ActivityTranscribeDetailBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTranscribeDetailBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_transcribe_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6033a;
    }
}
