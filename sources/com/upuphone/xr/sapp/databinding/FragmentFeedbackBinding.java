package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import flyme.support.v7.widget.MzRecyclerView;

public final class FragmentFeedbackBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6784a;
    public final RelativeLayout b;
    public final Button c;
    public final LinearLayout d;
    public final EditText e;
    public final TextView f;
    public final TextView g;
    public final EditText h;
    public final TextView i;
    public final RelativeLayout j;
    public final RelativeLayout k;
    public final RelativeLayout l;
    public final MzRecyclerView m;
    public final CheckBox n;
    public final TextView o;
    public final ScrollView p;
    public final LinearLayout q;
    public final TextView r;
    public final MzRecyclerView s;
    public final TextView t;

    public FragmentFeedbackBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, Button button, LinearLayout linearLayout2, EditText editText, TextView textView, TextView textView2, EditText editText2, TextView textView3, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, MzRecyclerView mzRecyclerView, CheckBox checkBox, TextView textView4, ScrollView scrollView, LinearLayout linearLayout3, TextView textView5, MzRecyclerView mzRecyclerView2, TextView textView6) {
        this.f6784a = linearLayout;
        this.b = relativeLayout;
        this.c = button;
        this.d = linearLayout2;
        this.e = editText;
        this.f = textView;
        this.g = textView2;
        this.h = editText2;
        this.i = textView3;
        this.j = relativeLayout2;
        this.k = relativeLayout3;
        this.l = relativeLayout4;
        this.m = mzRecyclerView;
        this.n = checkBox;
        this.o = textView4;
        this.p = scrollView;
        this.q = linearLayout3;
        this.r = textView5;
        this.s = mzRecyclerView2;
        this.t = textView6;
    }

    public static FragmentFeedbackBinding a(View view) {
        View view2 = view;
        int i2 = R.id.awlays_layout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.a(view2, i2);
        if (relativeLayout != null) {
            i2 = R.id.commit_tv;
            Button button = (Button) ViewBindings.a(view2, i2);
            if (button != null) {
                i2 = R.id.common_problem_layout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view2, i2);
                if (linearLayout != null) {
                    i2 = R.id.contact_edit;
                    EditText editText = (EditText) ViewBindings.a(view2, i2);
                    if (editText != null) {
                        i2 = R.id.contact_error;
                        TextView textView = (TextView) ViewBindings.a(view2, i2);
                        if (textView != null) {
                            i2 = R.id.describe_count_tv;
                            TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                            if (textView2 != null) {
                                i2 = R.id.describe_edit;
                                EditText editText2 = (EditText) ViewBindings.a(view2, i2);
                                if (editText2 != null) {
                                    i2 = R.id.feedback_back_title;
                                    TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                                    if (textView3 != null) {
                                        i2 = R.id.many_layout;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.a(view2, i2);
                                        if (relativeLayout2 != null) {
                                            i2 = R.id.never_layout;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.a(view2, i2);
                                            if (relativeLayout3 != null) {
                                                i2 = R.id.ones_layout;
                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.a(view2, i2);
                                                if (relativeLayout4 != null) {
                                                    i2 = R.id.problem_listview;
                                                    MzRecyclerView mzRecyclerView = (MzRecyclerView) ViewBindings.a(view2, i2);
                                                    if (mzRecyclerView != null) {
                                                        i2 = R.id.push_log;
                                                        CheckBox checkBox = (CheckBox) ViewBindings.a(view2, i2);
                                                        if (checkBox != null) {
                                                            i2 = R.id.submit_back;
                                                            TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                                                            if (textView4 != null) {
                                                                i2 = R.id.submit_layout;
                                                                ScrollView scrollView = (ScrollView) ViewBindings.a(view2, i2);
                                                                if (scrollView != null) {
                                                                    i2 = R.id.submit_success_layout;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view2, i2);
                                                                    if (linearLayout2 != null) {
                                                                        i2 = R.id.time_select_tv;
                                                                        TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                                                                        if (textView5 != null) {
                                                                            i2 = R.id.video_listview;
                                                                            MzRecyclerView mzRecyclerView2 = (MzRecyclerView) ViewBindings.a(view2, i2);
                                                                            if (mzRecyclerView2 != null) {
                                                                                i2 = R.id.video_select_limit;
                                                                                TextView textView6 = (TextView) ViewBindings.a(view2, i2);
                                                                                if (textView6 != null) {
                                                                                    return new FragmentFeedbackBinding((LinearLayout) view2, relativeLayout, button, linearLayout, editText, textView, textView2, editText2, textView3, relativeLayout2, relativeLayout3, relativeLayout4, mzRecyclerView, checkBox, textView4, scrollView, linearLayout2, textView5, mzRecyclerView2, textView6);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static FragmentFeedbackBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_feedback, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6784a;
    }
}
