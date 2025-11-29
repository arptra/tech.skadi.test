package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;
import org.libpag.PAGImageView;

public final class FragmentVoiceprintSrRecordingBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6828a;
    public final MzButton b;
    public final PAGImageView c;
    public final NestedScrollView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;

    public FragmentVoiceprintSrRecordingBinding(ConstraintLayout constraintLayout, MzButton mzButton, PAGImageView pAGImageView, NestedScrollView nestedScrollView, TextView textView, TextView textView2, TextView textView3) {
        this.f6828a = constraintLayout;
        this.b = mzButton;
        this.c = pAGImageView;
        this.d = nestedScrollView;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
    }

    public static FragmentVoiceprintSrRecordingBinding a(View view) {
        int i = R.id.mbt_next;
        MzButton mzButton = (MzButton) ViewBindings.a(view, i);
        if (mzButton != null) {
            i = R.id.pag_record;
            PAGImageView pAGImageView = (PAGImageView) ViewBindings.a(view, i);
            if (pAGImageView != null) {
                i = R.id.sv_spoken;
                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.a(view, i);
                if (nestedScrollView != null) {
                    i = R.id.tv_countdown;
                    TextView textView = (TextView) ViewBindings.a(view, i);
                    if (textView != null) {
                        i = R.id.tv_spoken;
                        TextView textView2 = (TextView) ViewBindings.a(view, i);
                        if (textView2 != null) {
                            i = R.id.tv_spoken_tip;
                            TextView textView3 = (TextView) ViewBindings.a(view, i);
                            if (textView3 != null) {
                                return new FragmentVoiceprintSrRecordingBinding((ConstraintLayout) view, mzButton, pAGImageView, nestedScrollView, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6828a;
    }
}
