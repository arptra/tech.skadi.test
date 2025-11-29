package com.upuphone.ar.fastrecord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordTitleBar;
import com.upuphone.ar.fastrecord.phone.ui.widget.RecordIngDetailSoundVisualizerView;

public final class FastRecordDuringDetailActivityBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5589a;
    public final FastRecordDuringDetailBottomLayoutBinding b;
    public final FastRecordTitleBar c;
    public final TextView d;
    public final TextView e;
    public final RecordIngDetailSoundVisualizerView f;

    public FastRecordDuringDetailActivityBinding(ConstraintLayout constraintLayout, FastRecordDuringDetailBottomLayoutBinding fastRecordDuringDetailBottomLayoutBinding, FastRecordTitleBar fastRecordTitleBar, TextView textView, TextView textView2, RecordIngDetailSoundVisualizerView recordIngDetailSoundVisualizerView) {
        this.f5589a = constraintLayout;
        this.b = fastRecordDuringDetailBottomLayoutBinding;
        this.c = fastRecordTitleBar;
        this.d = textView;
        this.e = textView2;
        this.f = recordIngDetailSoundVisualizerView;
    }

    public static FastRecordDuringDetailActivityBinding a(View view) {
        int i = R.id.ll_command;
        View a2 = ViewBindings.a(view, i);
        if (a2 != null) {
            FastRecordDuringDetailBottomLayoutBinding a3 = FastRecordDuringDetailBottomLayoutBinding.a(a2);
            i = R.id.title_bar;
            FastRecordTitleBar fastRecordTitleBar = (FastRecordTitleBar) ViewBindings.a(view, i);
            if (fastRecordTitleBar != null) {
                i = R.id.tv_record_name;
                TextView textView = (TextView) ViewBindings.a(view, i);
                if (textView != null) {
                    i = R.id.tv_record_time;
                    TextView textView2 = (TextView) ViewBindings.a(view, i);
                    if (textView2 != null) {
                        i = R.id.v_record_cpt;
                        RecordIngDetailSoundVisualizerView recordIngDetailSoundVisualizerView = (RecordIngDetailSoundVisualizerView) ViewBindings.a(view, i);
                        if (recordIngDetailSoundVisualizerView != null) {
                            return new FastRecordDuringDetailActivityBinding((ConstraintLayout) view, a3, fastRecordTitleBar, textView, textView2, recordIngDetailSoundVisualizerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FastRecordDuringDetailActivityBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FastRecordDuringDetailActivityBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fast_record_during_detail_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5589a;
    }
}
