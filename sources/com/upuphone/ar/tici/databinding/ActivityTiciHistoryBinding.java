package com.upuphone.ar.tici.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.phone.widget.BubbleWidget;
import com.upuphone.ar.tici.phone.widget.TiciTitleBar;

public final class ActivityTiciHistoryBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5857a;
    public final LinearLayout b;
    public final TiciImportFailedBinding c;
    public final TiciImportingFileBinding d;
    public final RecyclerView e;
    public final BubbleWidget f;
    public final TiciTitleBar g;

    public ActivityTiciHistoryBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, TiciImportFailedBinding ticiImportFailedBinding, TiciImportingFileBinding ticiImportingFileBinding, RecyclerView recyclerView, BubbleWidget bubbleWidget, TiciTitleBar ticiTitleBar) {
        this.f5857a = constraintLayout;
        this.b = linearLayout;
        this.c = ticiImportFailedBinding;
        this.d = ticiImportingFileBinding;
        this.e = recyclerView;
        this.f = bubbleWidget;
        this.g = ticiTitleBar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.upuphone.ar.tici.R.id.lay_tici_import_failed;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.tici.databinding.ActivityTiciHistoryBinding a(android.view.View r10) {
        /*
            int r0 = com.upuphone.ar.tici.R.id.lay_empty_file
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r10, r0)
            r4 = r1
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x004e
            int r0 = com.upuphone.ar.tici.R.id.lay_tici_import_failed
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r10, r0)
            if (r1 == 0) goto L_0x004e
            com.upuphone.ar.tici.databinding.TiciImportFailedBinding r5 = com.upuphone.ar.tici.databinding.TiciImportFailedBinding.a(r1)
            int r0 = com.upuphone.ar.tici.R.id.lay_tici_importing_file
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r10, r0)
            if (r1 == 0) goto L_0x004e
            com.upuphone.ar.tici.databinding.TiciImportingFileBinding r6 = com.upuphone.ar.tici.databinding.TiciImportingFileBinding.a(r1)
            int r0 = com.upuphone.ar.tici.R.id.recycler_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r10, r0)
            r7 = r1
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x004e
            int r0 = com.upuphone.ar.tici.R.id.tip_widget
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r10, r0)
            r8 = r1
            com.upuphone.ar.tici.phone.widget.BubbleWidget r8 = (com.upuphone.ar.tici.phone.widget.BubbleWidget) r8
            if (r8 == 0) goto L_0x004e
            int r0 = com.upuphone.ar.tici.R.id.title_bar
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r10, r0)
            r9 = r1
            com.upuphone.ar.tici.phone.widget.TiciTitleBar r9 = (com.upuphone.ar.tici.phone.widget.TiciTitleBar) r9
            if (r9 == 0) goto L_0x004e
            com.upuphone.ar.tici.databinding.ActivityTiciHistoryBinding r0 = new com.upuphone.ar.tici.databinding.ActivityTiciHistoryBinding
            r3 = r10
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x004e:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.databinding.ActivityTiciHistoryBinding.a(android.view.View):com.upuphone.ar.tici.databinding.ActivityTiciHistoryBinding");
    }

    public static ActivityTiciHistoryBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTiciHistoryBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_tici_history, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5857a;
    }
}
