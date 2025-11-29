package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import flyme.support.v7.widget.MzRecyclerView;

public final class FragmentOpinionFeedbackBinding implements ViewBinding {
    public final CheckBox A;

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6808a;
    public final Button b;
    public final TextView c;
    public final EditText d;
    public final Button e;
    public final Button f;
    public final GridLayout g;
    public final Button h;
    public final Button i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final EditText m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final RadioGroup t;
    public final MzRecyclerView u;
    public final NestedScrollView v;
    public final ConstraintLayout w;
    public final RadioButton x;
    public final RadioButton y;
    public final TextView z;

    public FragmentOpinionFeedbackBinding(ConstraintLayout constraintLayout, Button button, TextView textView, EditText editText, Button button2, Button button3, GridLayout gridLayout, Button button4, Button button5, TextView textView2, TextView textView3, TextView textView4, EditText editText2, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, RadioGroup radioGroup, MzRecyclerView mzRecyclerView, NestedScrollView nestedScrollView, ConstraintLayout constraintLayout2, RadioButton radioButton, RadioButton radioButton2, TextView textView11, CheckBox checkBox) {
        this.f6808a = constraintLayout;
        this.b = button;
        this.c = textView;
        this.d = editText;
        this.e = button2;
        this.f = button3;
        this.g = gridLayout;
        this.h = button4;
        this.i = button5;
        this.j = textView2;
        this.k = textView3;
        this.l = textView4;
        this.m = editText2;
        this.n = textView5;
        this.o = textView6;
        this.p = textView7;
        this.q = textView8;
        this.r = textView9;
        this.s = textView10;
        this.t = radioGroup;
        this.u = mzRecyclerView;
        this.v = nestedScrollView;
        this.w = constraintLayout2;
        this.x = radioButton;
        this.y = radioButton2;
        this.z = textView11;
        this.A = checkBox;
    }

    public static FragmentOpinionFeedbackBinding a(View view) {
        View view2 = view;
        int i2 = R.id.commit_feedback;
        Button button = (Button) ViewBindings.a(view2, i2);
        if (button != null) {
            i2 = R.id.contact_information;
            TextView textView = (TextView) ViewBindings.a(view2, i2);
            if (textView != null) {
                i2 = R.id.contact_information_content;
                EditText editText = (EditText) ViewBindings.a(view2, i2);
                if (editText != null) {
                    i2 = R.id.frequency_always;
                    Button button2 = (Button) ViewBindings.a(view2, i2);
                    if (button2 != null) {
                        i2 = R.id.frequency_few;
                        Button button3 = (Button) ViewBindings.a(view2, i2);
                        if (button3 != null) {
                            i2 = R.id.frequency_layout;
                            GridLayout gridLayout = (GridLayout) ViewBindings.a(view2, i2);
                            if (gridLayout != null) {
                                i2 = R.id.frequency_mul_a_day;
                                Button button4 = (Button) ViewBindings.a(view2, i2);
                                if (button4 != null) {
                                    i2 = R.id.frequency_once_a_day;
                                    Button button5 = (Button) ViewBindings.a(view2, i2);
                                    if (button5 != null) {
                                        i2 = R.id.help_feedback_back_title;
                                        TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                                        if (textView2 != null) {
                                            i2 = R.id.occurrence_frequency;
                                            TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                                            if (textView3 != null) {
                                                i2 = R.id.problem_description;
                                                TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                                                if (textView4 != null) {
                                                    i2 = R.id.problem_description_content;
                                                    EditText editText2 = (EditText) ViewBindings.a(view2, i2);
                                                    if (editText2 != null) {
                                                        i2 = R.id.problem_description_count;
                                                        TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                                                        if (textView5 != null) {
                                                            i2 = R.id.problem_occur_time;
                                                            TextView textView6 = (TextView) ViewBindings.a(view2, i2);
                                                            if (textView6 != null) {
                                                                i2 = R.id.problem_occur_time_content;
                                                                TextView textView7 = (TextView) ViewBindings.a(view2, i2);
                                                                if (textView7 != null) {
                                                                    i2 = R.id.problem_screenshot;
                                                                    TextView textView8 = (TextView) ViewBindings.a(view2, i2);
                                                                    if (textView8 != null) {
                                                                        i2 = R.id.problem_screenshot_count;
                                                                        TextView textView9 = (TextView) ViewBindings.a(view2, i2);
                                                                        if (textView9 != null) {
                                                                            i2 = R.id.problem_type;
                                                                            TextView textView10 = (TextView) ViewBindings.a(view2, i2);
                                                                            if (textView10 != null) {
                                                                                i2 = R.id.problem_type_group;
                                                                                RadioGroup radioGroup = (RadioGroup) ViewBindings.a(view2, i2);
                                                                                if (radioGroup != null) {
                                                                                    i2 = R.id.screenshot_recyclerview;
                                                                                    MzRecyclerView mzRecyclerView = (MzRecyclerView) ViewBindings.a(view2, i2);
                                                                                    if (mzRecyclerView != null) {
                                                                                        i2 = R.id.scroll_view;
                                                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.a(view2, i2);
                                                                                        if (nestedScrollView != null) {
                                                                                            i2 = R.id.scroll_view_layout;
                                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
                                                                                            if (constraintLayout != null) {
                                                                                                i2 = R.id.star_device_problem;
                                                                                                RadioButton radioButton = (RadioButton) ViewBindings.a(view2, i2);
                                                                                                if (radioButton != null) {
                                                                                                    i2 = R.id.superapp_problem;
                                                                                                    RadioButton radioButton2 = (RadioButton) ViewBindings.a(view2, i2);
                                                                                                    if (radioButton2 != null) {
                                                                                                        i2 = R.id.tmp_show_button;
                                                                                                        TextView textView11 = (TextView) ViewBindings.a(view2, i2);
                                                                                                        if (textView11 != null) {
                                                                                                            i2 = R.id.upload_problem_log;
                                                                                                            CheckBox checkBox = (CheckBox) ViewBindings.a(view2, i2);
                                                                                                            if (checkBox != null) {
                                                                                                                return new FragmentOpinionFeedbackBinding((ConstraintLayout) view2, button, textView, editText, button2, button3, gridLayout, button4, button5, textView2, textView3, textView4, editText2, textView5, textView6, textView7, textView8, textView9, textView10, radioGroup, mzRecyclerView, nestedScrollView, constraintLayout, radioButton, radioButton2, textView11, checkBox);
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
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static FragmentOpinionFeedbackBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View inflate = layoutInflater.inflate(R.layout.fragment_opinion_feedback, viewGroup, false);
        if (z2) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6808a;
    }
}
