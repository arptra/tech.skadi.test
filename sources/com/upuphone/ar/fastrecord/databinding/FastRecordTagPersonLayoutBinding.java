package com.upuphone.ar.fastrecord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.ui.widget.labels.RecordDetailHistoryTagView;
import com.upuphone.ar.fastrecord.phone.ui.widget.labels.RecordDetailInputTagView;

public final class FastRecordTagPersonLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5621a;
    public final ConstraintLayout b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ConstraintLayout g;
    public final ConstraintLayout h;
    public final ConstraintLayout i;
    public final ConstraintLayout j;
    public final ConstraintLayout k;
    public final RecordDetailHistoryTagView l;
    public final RecordDetailInputTagView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;

    public FastRecordTagPersonLayoutBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, RecordDetailHistoryTagView recordDetailHistoryTagView, RecordDetailInputTagView recordDetailInputTagView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f5621a = constraintLayout;
        this.b = constraintLayout2;
        this.c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = constraintLayout3;
        this.h = constraintLayout4;
        this.i = constraintLayout5;
        this.j = constraintLayout6;
        this.k = constraintLayout7;
        this.l = recordDetailHistoryTagView;
        this.m = recordDetailInputTagView;
        this.n = textView;
        this.o = textView2;
        this.p = textView3;
        this.q = textView4;
        this.r = textView5;
    }

    public static FastRecordTagPersonLayoutBinding a(View view) {
        View view2 = view;
        int i2 = R.id.cl_content;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
        if (constraintLayout != null) {
            i2 = R.id.iv_more_other;
            ImageView imageView = (ImageView) ViewBindings.a(view2, i2);
            if (imageView != null) {
                i2 = R.id.iv_more_self;
                ImageView imageView2 = (ImageView) ViewBindings.a(view2, i2);
                if (imageView2 != null) {
                    i2 = R.id.iv_other;
                    ImageView imageView3 = (ImageView) ViewBindings.a(view2, i2);
                    if (imageView3 != null) {
                        i2 = R.id.iv_self;
                        ImageView imageView4 = (ImageView) ViewBindings.a(view2, i2);
                        if (imageView4 != null) {
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view2;
                            i2 = R.id.ll_person_other_tip_container;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.a(view2, i2);
                            if (constraintLayout3 != null) {
                                i2 = R.id.ll_person_self_tip_container;
                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                if (constraintLayout4 != null) {
                                    i2 = R.id.ll_person_tag_tip_content_container;
                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                    if (constraintLayout5 != null) {
                                        i2 = R.id.ll_person_tag_value_content_container;
                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                        if (constraintLayout6 != null) {
                                            i2 = R.id.record_person_history_tag;
                                            RecordDetailHistoryTagView recordDetailHistoryTagView = (RecordDetailHistoryTagView) ViewBindings.a(view2, i2);
                                            if (recordDetailHistoryTagView != null) {
                                                i2 = R.id.record_person_input_tag;
                                                RecordDetailInputTagView recordDetailInputTagView = (RecordDetailInputTagView) ViewBindings.a(view2, i2);
                                                if (recordDetailInputTagView != null) {
                                                    i2 = R.id.tv_person_tag_value_tag_tip;
                                                    TextView textView = (TextView) ViewBindings.a(view2, i2);
                                                    if (textView != null) {
                                                        i2 = R.id.tv_person_tip_one;
                                                        TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                                                        if (textView2 != null) {
                                                            i2 = R.id.tv_person_tip_two;
                                                            TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                                                            if (textView3 != null) {
                                                                i2 = R.id.tv_tag_tip;
                                                                TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                                                                if (textView4 != null) {
                                                                    i2 = R.id.tv_tip_history_person;
                                                                    TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                                                                    if (textView5 != null) {
                                                                        return new FastRecordTagPersonLayoutBinding(constraintLayout2, constraintLayout, imageView, imageView2, imageView3, imageView4, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, constraintLayout6, recordDetailHistoryTagView, recordDetailInputTagView, textView, textView2, textView3, textView4, textView5);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
    public ConstraintLayout getRoot() {
        return this.f5621a;
    }
}
