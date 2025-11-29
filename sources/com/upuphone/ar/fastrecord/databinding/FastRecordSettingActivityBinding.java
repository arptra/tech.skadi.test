package com.upuphone.ar.fastrecord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.Switch;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordTitleBar;

public final class FastRecordSettingActivityBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5612a;
    public final ImageView b;
    public final ConstraintLayout c;
    public final ConstraintLayout d;
    public final ConstraintLayout e;
    public final Switch f;
    public final Switch g;
    public final Switch h;
    public final FastRecordTitleBar i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;

    public FastRecordSettingActivityBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, Switch switchR, Switch switchR2, Switch switchR3, FastRecordTitleBar fastRecordTitleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.f5612a = constraintLayout;
        this.b = imageView;
        this.c = constraintLayout2;
        this.d = constraintLayout3;
        this.e = constraintLayout4;
        this.f = switchR;
        this.g = switchR2;
        this.h = switchR3;
        this.i = fastRecordTitleBar;
        this.j = textView;
        this.k = textView2;
        this.l = textView3;
        this.m = textView4;
        this.n = textView5;
        this.o = textView6;
        this.p = textView7;
    }

    public static FastRecordSettingActivityBinding a(View view) {
        View view2 = view;
        int i2 = R.id.bg_fast_record_lan_more;
        ImageView imageView = (ImageView) ViewBindings.a(view2, i2);
        if (imageView != null) {
            i2 = R.id.ll_pre_record;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
            if (constraintLayout != null) {
                i2 = R.id.ll_setting_language;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view2, i2);
                if (constraintLayout2 != null) {
                    i2 = R.id.ll_setting_location;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.a(view2, i2);
                    if (constraintLayout3 != null) {
                        i2 = R.id.sw_location;
                        Switch switchR = (Switch) ViewBindings.a(view2, i2);
                        if (switchR != null) {
                            i2 = R.id.sw_pre_rec;
                            Switch switchR2 = (Switch) ViewBindings.a(view2, i2);
                            if (switchR2 != null) {
                                i2 = R.id.sw_sound_check;
                                Switch switchR3 = (Switch) ViewBindings.a(view2, i2);
                                if (switchR3 != null) {
                                    i2 = R.id.title_bar;
                                    FastRecordTitleBar fastRecordTitleBar = (FastRecordTitleBar) ViewBindings.a(view2, i2);
                                    if (fastRecordTitleBar != null) {
                                        i2 = R.id.tv_language;
                                        TextView textView = (TextView) ViewBindings.a(view2, i2);
                                        if (textView != null) {
                                            i2 = R.id.tv_language_choose;
                                            TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                                            if (textView2 != null) {
                                                i2 = R.id.tv_location;
                                                TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                                                if (textView3 != null) {
                                                    i2 = R.id.tv_pre_rce;
                                                    TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                                                    if (textView4 != null) {
                                                        i2 = R.id.tv_pre_rce_detail;
                                                        TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                                                        if (textView5 != null) {
                                                            i2 = R.id.tv_sound_info;
                                                            TextView textView6 = (TextView) ViewBindings.a(view2, i2);
                                                            if (textView6 != null) {
                                                                i2 = R.id.tv_sound_info_status;
                                                                TextView textView7 = (TextView) ViewBindings.a(view2, i2);
                                                                if (textView7 != null) {
                                                                    return new FastRecordSettingActivityBinding((ConstraintLayout) view2, imageView, constraintLayout, constraintLayout2, constraintLayout3, switchR, switchR2, switchR3, fastRecordTitleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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

    public static FastRecordSettingActivityBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FastRecordSettingActivityBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fast_record_setting_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5612a;
    }
}
