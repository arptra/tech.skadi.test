package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class DebugLoginActivityBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6745a;
    public final Button b;
    public final Button c;
    public final Button d;
    public final Button e;
    public final Button f;
    public final Button g;
    public final TextView h;
    public final Button i;
    public final Button j;
    public final Button k;
    public final TextView l;

    public DebugLoginActivityBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, TextView textView, Button button7, Button button8, Button button9, TextView textView2) {
        this.f6745a = linearLayout;
        this.b = button;
        this.c = button2;
        this.d = button3;
        this.e = button4;
        this.f = button5;
        this.g = button6;
        this.h = textView;
        this.i = button7;
        this.j = button8;
        this.k = button9;
        this.l = textView2;
    }

    public static DebugLoginActivityBinding a(View view) {
        int i2 = R.id.agree_ai_state_btn;
        Button button = (Button) ViewBindings.a(view, i2);
        if (button != null) {
            i2 = R.id.agree_pp_agree_btn;
            Button button2 = (Button) ViewBindings.a(view, i2);
            if (button2 != null) {
                i2 = R.id.disagree_ai_state_btn;
                Button button3 = (Button) ViewBindings.a(view, i2);
                if (button3 != null) {
                    i2 = R.id.disagree_pp_agree_btn;
                    Button button4 = (Button) ViewBindings.a(view, i2);
                    if (button4 != null) {
                        i2 = R.id.get_mz_token_btn;
                        Button button5 = (Button) ViewBindings.a(view, i2);
                        if (button5 != null) {
                            i2 = R.id.get_user_info_btn;
                            Button button6 = (Button) ViewBindings.a(view, i2);
                            if (button6 != null) {
                                i2 = R.id.mz_token_text;
                                TextView textView = (TextView) ViewBindings.a(view, i2);
                                if (textView != null) {
                                    i2 = R.id.query_policys;
                                    Button button7 = (Button) ViewBindings.a(view, i2);
                                    if (button7 != null) {
                                        i2 = R.id.query_pp_expire_btn;
                                        Button button8 = (Button) ViewBindings.a(view, i2);
                                        if (button8 != null) {
                                            i2 = R.id.request_ai_state_btn;
                                            Button button9 = (Button) ViewBindings.a(view, i2);
                                            if (button9 != null) {
                                                i2 = R.id.user_info_text;
                                                TextView textView2 = (TextView) ViewBindings.a(view, i2);
                                                if (textView2 != null) {
                                                    return new DebugLoginActivityBinding((LinearLayout) view, button, button2, button3, button4, button5, button6, textView, button7, button8, button9, textView2);
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

    public static DebugLoginActivityBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static DebugLoginActivityBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.debug_login_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6745a;
    }
}
