package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.view.TransSettingItem;
import com.upuphone.ar.translation.phone.view.TransSubtitleCard;
import com.upuphone.ar.translation.phone.view.TransTitleBar;

public final class ActivityTranslatorSettingBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6241a;
    public final ConstraintLayout b;
    public final TransSubtitleCard c;
    public final TransSubtitleCard d;
    public final Group e;
    public final TransTitleBar f;
    public final TransSettingItem g;
    public final TransSettingItem h;
    public final TransSettingItem i;
    public final TransSettingItem j;
    public final TransSettingItem k;
    public final TransSettingItem l;
    public final TransSettingItem m;
    public final TransSettingItem n;
    public final TextView o;
    public final TextView p;
    public final TextView q;

    public ActivityTranslatorSettingBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TransSubtitleCard transSubtitleCard, TransSubtitleCard transSubtitleCard2, Group group, TransTitleBar transTitleBar, TransSettingItem transSettingItem, TransSettingItem transSettingItem2, TransSettingItem transSettingItem3, TransSettingItem transSettingItem4, TransSettingItem transSettingItem5, TransSettingItem transSettingItem6, TransSettingItem transSettingItem7, TransSettingItem transSettingItem8, TextView textView, TextView textView2, TextView textView3) {
        this.f6241a = constraintLayout;
        this.b = constraintLayout2;
        this.c = transSubtitleCard;
        this.d = transSubtitleCard2;
        this.e = group;
        this.f = transTitleBar;
        this.g = transSettingItem;
        this.h = transSettingItem2;
        this.i = transSettingItem3;
        this.j = transSettingItem4;
        this.k = transSettingItem5;
        this.l = transSettingItem6;
        this.m = transSettingItem7;
        this.n = transSettingItem8;
        this.o = textView;
        this.p = textView2;
        this.q = textView3;
    }

    public static ActivityTranslatorSettingBinding a(View view) {
        View view2 = view;
        int i2 = R.id.cl_subtitle;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
        if (constraintLayout != null) {
            i2 = R.id.cv_sub_other_all;
            TransSubtitleCard transSubtitleCard = (TransSubtitleCard) ViewBindings.a(view2, i2);
            if (transSubtitleCard != null) {
                i2 = R.id.cv_sub_other_trans;
                TransSubtitleCard transSubtitleCard2 = (TransSubtitleCard) ViewBindings.a(view2, i2);
                if (transSubtitleCard2 != null) {
                    i2 = R.id.gp_telephone_trans;
                    Group group = (Group) ViewBindings.a(view2, i2);
                    if (group != null) {
                        i2 = R.id.title_bar;
                        TransTitleBar transTitleBar = (TransTitleBar) ViewBindings.a(view2, i2);
                        if (transTitleBar != null) {
                            i2 = R.id.tsi_call_audio;
                            TransSettingItem transSettingItem = (TransSettingItem) ViewBindings.a(view2, i2);
                            if (transSettingItem != null) {
                                i2 = R.id.tsi_call_trans_tip;
                                TransSettingItem transSettingItem2 = (TransSettingItem) ViewBindings.a(view2, i2);
                                if (transSettingItem2 != null) {
                                    i2 = R.id.tsi_geo_location;
                                    TransSettingItem transSettingItem3 = (TransSettingItem) ViewBindings.a(view2, i2);
                                    if (transSettingItem3 != null) {
                                        i2 = R.id.tsi_only_other;
                                        TransSettingItem transSettingItem4 = (TransSettingItem) ViewBindings.a(view2, i2);
                                        if (transSettingItem4 != null) {
                                            i2 = R.id.tsi_record;
                                            TransSettingItem transSettingItem5 = (TransSettingItem) ViewBindings.a(view2, i2);
                                            if (transSettingItem5 != null) {
                                                i2 = R.id.tsi_voice_myself;
                                                TransSettingItem transSettingItem6 = (TransSettingItem) ViewBindings.a(view2, i2);
                                                if (transSettingItem6 != null) {
                                                    i2 = R.id.tsi_voice_other;
                                                    TransSettingItem transSettingItem7 = (TransSettingItem) ViewBindings.a(view2, i2);
                                                    if (transSettingItem7 != null) {
                                                        i2 = R.id.tsi_vprint;
                                                        TransSettingItem transSettingItem8 = (TransSettingItem) ViewBindings.a(view2, i2);
                                                        if (transSettingItem8 != null) {
                                                            i2 = R.id.tv_settings_general;
                                                            TextView textView = (TextView) ViewBindings.a(view2, i2);
                                                            if (textView != null) {
                                                                i2 = R.id.tv_settings_telephone;
                                                                TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                                                                if (textView2 != null) {
                                                                    i2 = R.id.tv_sub_other;
                                                                    TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                                                                    if (textView3 != null) {
                                                                        return new ActivityTranslatorSettingBinding((ConstraintLayout) view2, constraintLayout, transSubtitleCard, transSubtitleCard2, group, transTitleBar, transSettingItem, transSettingItem2, transSettingItem3, transSettingItem4, transSettingItem5, transSettingItem6, transSettingItem7, transSettingItem8, textView, textView2, textView3);
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

    public static ActivityTranslatorSettingBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTranslatorSettingBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_translator_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6241a;
    }
}
