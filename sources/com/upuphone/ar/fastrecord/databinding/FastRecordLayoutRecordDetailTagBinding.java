package com.upuphone.ar.fastrecord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;

public final class FastRecordLayoutRecordDetailTagBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f5606a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final LinearLayout i;
    public final LinearLayout j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;

    public FastRecordLayoutRecordDetailTagBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.f5606a = linearLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = imageView4;
        this.f = linearLayout2;
        this.g = linearLayout3;
        this.h = linearLayout4;
        this.i = linearLayout5;
        this.j = linearLayout6;
        this.k = textView;
        this.l = textView2;
        this.m = textView3;
        this.n = textView4;
        this.o = textView5;
        this.p = textView6;
    }

    public static FastRecordLayoutRecordDetailTagBinding a(View view) {
        View view2 = view;
        int i2 = R.id.iv_content_show_more;
        ImageView imageView = (ImageView) ViewBindings.a(view2, i2);
        if (imageView != null) {
            i2 = R.id.iv_content_tag_tip;
            ImageView imageView2 = (ImageView) ViewBindings.a(view2, i2);
            if (imageView2 != null) {
                i2 = R.id.iv_person_show_more;
                ImageView imageView3 = (ImageView) ViewBindings.a(view2, i2);
                if (imageView3 != null) {
                    i2 = R.id.iv_person_tag_tip;
                    ImageView imageView4 = (ImageView) ViewBindings.a(view2, i2);
                    if (imageView4 != null) {
                        i2 = R.id.ll_content_container;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view2, i2);
                        if (linearLayout != null) {
                            i2 = R.id.ll_content_tag;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view2, i2);
                            if (linearLayout2 != null) {
                                LinearLayout linearLayout3 = (LinearLayout) view2;
                                i2 = R.id.ll_person_container;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.a(view2, i2);
                                if (linearLayout4 != null) {
                                    i2 = R.id.ll_person_tag;
                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.a(view2, i2);
                                    if (linearLayout5 != null) {
                                        i2 = R.id.tv_content_label_tag_more;
                                        TextView textView = (TextView) ViewBindings.a(view2, i2);
                                        if (textView != null) {
                                            i2 = R.id.tv_content_label_tag_single;
                                            TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                                            if (textView2 != null) {
                                                i2 = R.id.tv_content_label_tag_tip;
                                                TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                                                if (textView3 != null) {
                                                    i2 = R.id.tv_person_label_tag_more;
                                                    TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                                                    if (textView4 != null) {
                                                        i2 = R.id.tv_person_label_tag_single;
                                                        TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                                                        if (textView5 != null) {
                                                            i2 = R.id.tv_person_label_tag_tip;
                                                            TextView textView6 = (TextView) ViewBindings.a(view2, i2);
                                                            if (textView6 != null) {
                                                                return new FastRecordLayoutRecordDetailTagBinding(linearLayout3, imageView, imageView2, imageView3, imageView4, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, textView, textView2, textView3, textView4, textView5, textView6);
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
    public LinearLayout getRoot() {
        return this.f5606a;
    }
}
