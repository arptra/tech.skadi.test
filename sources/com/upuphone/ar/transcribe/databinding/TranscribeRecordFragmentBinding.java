package com.upuphone.ar.transcribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.upuphone.ar.transcribe.R;

public final class TranscribeRecordFragmentBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6048a;
    public final Group b;
    public final ImageView c;
    public final ImageView d;
    public final ClassicsFooter e;
    public final RecyclerView f;
    public final SmartRefreshLayout g;
    public final TextView h;

    public TranscribeRecordFragmentBinding(ConstraintLayout constraintLayout, Group group, ImageView imageView, ImageView imageView2, ClassicsFooter classicsFooter, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView) {
        this.f6048a = constraintLayout;
        this.b = group;
        this.c = imageView;
        this.d = imageView2;
        this.e = classicsFooter;
        this.f = recyclerView;
        this.g = smartRefreshLayout;
        this.h = textView;
    }

    public static TranscribeRecordFragmentBinding a(View view) {
        int i = R.id.gp_no_data;
        Group group = (Group) ViewBindings.a(view, i);
        if (group != null) {
            i = R.id.iv_no_data;
            ImageView imageView = (ImageView) ViewBindings.a(view, i);
            if (imageView != null) {
                i = R.id.iv_to_top;
                ImageView imageView2 = (ImageView) ViewBindings.a(view, i);
                if (imageView2 != null) {
                    i = R.id.refresh_footer;
                    ClassicsFooter classicsFooter = (ClassicsFooter) ViewBindings.a(view, i);
                    if (classicsFooter != null) {
                        i = R.id.rv_records;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i);
                        if (recyclerView != null) {
                            i = R.id.smart_refresh;
                            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.a(view, i);
                            if (smartRefreshLayout != null) {
                                i = R.id.tv_no_data;
                                TextView textView = (TextView) ViewBindings.a(view, i);
                                if (textView != null) {
                                    return new TranscribeRecordFragmentBinding((ConstraintLayout) view, group, imageView, imageView2, classicsFooter, recyclerView, smartRefreshLayout, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static TranscribeRecordFragmentBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static TranscribeRecordFragmentBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.transcribe_record_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6048a;
    }
}
