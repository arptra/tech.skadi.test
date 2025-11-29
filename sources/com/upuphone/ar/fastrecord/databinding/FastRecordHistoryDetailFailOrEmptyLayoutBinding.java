package com.upuphone.ar.fastrecord.databinding;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;

public final class FastRecordHistoryDetailFailOrEmptyLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ScrollView f5597a;
    public final FastRecordFailTipLayoutBinding b;
    public final FastRecordFailTipLayoutBinding c;
    public final FastRecordFailTipLayoutBinding d;
    public final FastRecordFailTipLayoutBinding e;
    public final FastRecordFailTipLayoutBinding f;
    public final TextView g;
    public final ScrollView h;
    public final TextView i;

    public FastRecordHistoryDetailFailOrEmptyLayoutBinding(ScrollView scrollView, FastRecordFailTipLayoutBinding fastRecordFailTipLayoutBinding, FastRecordFailTipLayoutBinding fastRecordFailTipLayoutBinding2, FastRecordFailTipLayoutBinding fastRecordFailTipLayoutBinding3, FastRecordFailTipLayoutBinding fastRecordFailTipLayoutBinding4, FastRecordFailTipLayoutBinding fastRecordFailTipLayoutBinding5, TextView textView, ScrollView scrollView2, TextView textView2) {
        this.f5597a = scrollView;
        this.b = fastRecordFailTipLayoutBinding;
        this.c = fastRecordFailTipLayoutBinding2;
        this.d = fastRecordFailTipLayoutBinding3;
        this.e = fastRecordFailTipLayoutBinding4;
        this.f = fastRecordFailTipLayoutBinding5;
        this.g = textView;
        this.h = scrollView2;
        this.i = textView2;
    }

    public static FastRecordHistoryDetailFailOrEmptyLayoutBinding a(View view) {
        int i2 = R.id.ll_fast_record_fail_four;
        View a2 = ViewBindings.a(view, i2);
        if (a2 != null) {
            FastRecordFailTipLayoutBinding a3 = FastRecordFailTipLayoutBinding.a(a2);
            i2 = R.id.ll_fast_record_fail_one;
            View a4 = ViewBindings.a(view, i2);
            if (a4 != null) {
                FastRecordFailTipLayoutBinding a5 = FastRecordFailTipLayoutBinding.a(a4);
                i2 = R.id.ll_fast_record_fail_three;
                View a6 = ViewBindings.a(view, i2);
                if (a6 != null) {
                    FastRecordFailTipLayoutBinding a7 = FastRecordFailTipLayoutBinding.a(a6);
                    i2 = R.id.ll_fast_record_fail_two;
                    View a8 = ViewBindings.a(view, i2);
                    if (a8 != null) {
                        FastRecordFailTipLayoutBinding a9 = FastRecordFailTipLayoutBinding.a(a8);
                        i2 = R.id.ll_fast_record_for_empty_intl;
                        View a10 = ViewBindings.a(view, i2);
                        if (a10 != null) {
                            FastRecordFailTipLayoutBinding a11 = FastRecordFailTipLayoutBinding.a(a10);
                            i2 = R.id.re_asr_btn;
                            TextView textView = (TextView) ViewBindings.a(view, i2);
                            if (textView != null) {
                                ScrollView scrollView = (ScrollView) view;
                                i2 = R.id.tv_re_asr_fail_tip;
                                TextView textView2 = (TextView) ViewBindings.a(view, i2);
                                if (textView2 != null) {
                                    return new FastRecordHistoryDetailFailOrEmptyLayoutBinding(scrollView, a3, a5, a7, a9, a11, textView, scrollView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    /* renamed from: b */
    public ScrollView getRoot() {
        return this.f5597a;
    }
}
