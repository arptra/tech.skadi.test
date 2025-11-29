package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.Switch;
import com.upuphone.xr.sapp.R;

public final class NotificationAppItemLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6885a;
    public final ConstraintLayout b;
    public final TextView c;
    public final ImageFilterView d;
    public final TextView e;
    public final Switch f;

    public NotificationAppItemLayoutBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, TextView textView, ImageFilterView imageFilterView, TextView textView2, Switch switchR) {
        this.f6885a = linearLayout;
        this.b = constraintLayout;
        this.c = textView;
        this.d = imageFilterView;
        this.e = textView2;
        this.f = switchR;
    }

    public static NotificationAppItemLayoutBinding a(View view) {
        int i = R.id.app_content;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i);
        if (constraintLayout != null) {
            i = R.id.app_desc;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                i = R.id.app_icon;
                ImageFilterView imageFilterView = (ImageFilterView) ViewBindings.a(view, i);
                if (imageFilterView != null) {
                    i = R.id.app_name;
                    TextView textView2 = (TextView) ViewBindings.a(view, i);
                    if (textView2 != null) {
                        i = R.id.app_switch;
                        Switch switchR = (Switch) ViewBindings.a(view, i);
                        if (switchR != null) {
                            return new NotificationAppItemLayoutBinding((LinearLayout) view, constraintLayout, textView, imageFilterView, textView2, switchR);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static NotificationAppItemLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.notification_app_item_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6885a;
    }
}
