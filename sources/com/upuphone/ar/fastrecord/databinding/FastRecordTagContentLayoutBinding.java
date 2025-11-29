package com.upuphone.ar.fastrecord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.ui.widget.labels.RecordDetailHistoryTagView;
import com.upuphone.ar.fastrecord.phone.ui.widget.labels.RecordDetailInputTagView;

public final class FastRecordTagContentLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5619a;
    public final ConstraintLayout b;
    public final ConstraintLayout c;
    public final RecordDetailHistoryTagView d;
    public final RecordDetailInputTagView e;
    public final TextView f;
    public final TextView g;

    public FastRecordTagContentLayoutBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, RecordDetailHistoryTagView recordDetailHistoryTagView, RecordDetailInputTagView recordDetailInputTagView, TextView textView, TextView textView2) {
        this.f5619a = constraintLayout;
        this.b = constraintLayout2;
        this.c = constraintLayout3;
        this.d = recordDetailHistoryTagView;
        this.e = recordDetailInputTagView;
        this.f = textView;
        this.g = textView2;
    }

    public static FastRecordTagContentLayoutBinding a(View view) {
        int i = R.id.cl_content;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
            i = R.id.record_content_history_tag;
            RecordDetailHistoryTagView recordDetailHistoryTagView = (RecordDetailHistoryTagView) ViewBindings.a(view, i);
            if (recordDetailHistoryTagView != null) {
                i = R.id.record_Input_normal_tag;
                RecordDetailInputTagView recordDetailInputTagView = (RecordDetailInputTagView) ViewBindings.a(view, i);
                if (recordDetailInputTagView != null) {
                    i = R.id.tv_tag_tip;
                    TextView textView = (TextView) ViewBindings.a(view, i);
                    if (textView != null) {
                        i = R.id.tv_tip_history_tag;
                        TextView textView2 = (TextView) ViewBindings.a(view, i);
                        if (textView2 != null) {
                            return new FastRecordTagContentLayoutBinding(constraintLayout2, constraintLayout, constraintLayout2, recordDetailHistoryTagView, recordDetailInputTagView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5619a;
    }
}
