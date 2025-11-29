package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.CardItemView;

public final class FragmentHearingAssistBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6795a;
    public final CardItemView b;
    public final CardItemView c;
    public final CardItemView d;
    public final CardItemView e;
    public final TextView f;
    public final ScrollView g;
    public final LinearLayout h;
    public final CardItemView i;
    public final TextView j;
    public final CardItemView k;
    public final CardItemView l;

    public FragmentHearingAssistBinding(ConstraintLayout constraintLayout, CardItemView cardItemView, CardItemView cardItemView2, CardItemView cardItemView3, CardItemView cardItemView4, TextView textView, ScrollView scrollView, LinearLayout linearLayout, CardItemView cardItemView5, TextView textView2, CardItemView cardItemView6, CardItemView cardItemView7) {
        this.f6795a = constraintLayout;
        this.b = cardItemView;
        this.c = cardItemView2;
        this.d = cardItemView3;
        this.e = cardItemView4;
        this.f = textView;
        this.g = scrollView;
        this.h = linearLayout;
        this.i = cardItemView5;
        this.j = textView2;
        this.k = cardItemView6;
        this.l = cardItemView7;
    }

    public static FragmentHearingAssistBinding a(View view) {
        int i2 = R.id.app_list_set;
        CardItemView cardItemView = (CardItemView) ViewBindings.a(view, i2);
        if (cardItemView != null) {
            i2 = R.id.gpt_broadcast_response;
            CardItemView cardItemView2 = (CardItemView) ViewBindings.a(view, i2);
            if (cardItemView2 != null) {
                i2 = R.id.gpt_text_response;
                CardItemView cardItemView3 = (CardItemView) ViewBindings.a(view, i2);
                if (cardItemView3 != null) {
                    i2 = R.id.hearing_assinst;
                    CardItemView cardItemView4 = (CardItemView) ViewBindings.a(view, i2);
                    if (cardItemView4 != null) {
                        i2 = R.id.hearing_assinst_back;
                        TextView textView = (TextView) ViewBindings.a(view, i2);
                        if (textView != null) {
                            i2 = R.id.hearing_assinst_scroll;
                            ScrollView scrollView = (ScrollView) ViewBindings.a(view, i2);
                            if (scrollView != null) {
                                i2 = R.id.hearing_assinst_set;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i2);
                                if (linearLayout != null) {
                                    i2 = R.id.hide_show_music_switch;
                                    CardItemView cardItemView5 = (CardItemView) ViewBindings.a(view, i2);
                                    if (cardItemView5 != null) {
                                        i2 = R.id.myvu_hearing_mode_desp;
                                        TextView textView2 = (TextView) ViewBindings.a(view, i2);
                                        if (textView2 != null) {
                                            i2 = R.id.myvu_navi_voice_switch;
                                            CardItemView cardItemView6 = (CardItemView) ViewBindings.a(view, i2);
                                            if (cardItemView6 != null) {
                                                i2 = R.id.notify_message_broadcast;
                                                CardItemView cardItemView7 = (CardItemView) ViewBindings.a(view, i2);
                                                if (cardItemView7 != null) {
                                                    return new FragmentHearingAssistBinding((ConstraintLayout) view, cardItemView, cardItemView2, cardItemView3, cardItemView4, textView, scrollView, linearLayout, cardItemView5, textView2, cardItemView6, cardItemView7);
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

    public static FragmentHearingAssistBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_hearing_assist, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6795a;
    }
}
