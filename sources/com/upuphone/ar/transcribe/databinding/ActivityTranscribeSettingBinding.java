package com.upuphone.ar.transcribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.phone.view.TransSettingItem;
import com.upuphone.ar.transcribe.phone.view.TransSettingSubCard;
import com.upuphone.ar.transcribe.phone.view.TransTitleBar;

public final class ActivityTranscribeSettingBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6034a;
    public final TransSettingSubCard b;
    public final TransSettingSubCard c;
    public final TransSettingItem d;
    public final ConstraintLayout e;
    public final TransTitleBar f;
    public final TextView g;
    public final TextView h;

    public ActivityTranscribeSettingBinding(ConstraintLayout constraintLayout, TransSettingSubCard transSettingSubCard, TransSettingSubCard transSettingSubCard2, TransSettingItem transSettingItem, ConstraintLayout constraintLayout2, TransTitleBar transTitleBar, TextView textView, TextView textView2) {
        this.f6034a = constraintLayout;
        this.b = transSettingSubCard;
        this.c = transSettingSubCard2;
        this.d = transSettingItem;
        this.e = constraintLayout2;
        this.f = transTitleBar;
        this.g = textView;
        this.h = textView2;
    }

    public static ActivityTranscribeSettingBinding a(View view) {
        int i = R.id.item_full_screen;
        TransSettingSubCard transSettingSubCard = (TransSettingSubCard) ViewBindings.a(view, i);
        if (transSettingSubCard != null) {
            i = R.id.item_half_screen;
            TransSettingSubCard transSettingSubCard2 = (TransSettingSubCard) ViewBindings.a(view, i);
            if (transSettingSubCard2 != null) {
                i = R.id.location_switch;
                TransSettingItem transSettingItem = (TransSettingItem) ViewBindings.a(view, i);
                if (transSettingItem != null) {
                    i = R.id.screen_type;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i);
                    if (constraintLayout != null) {
                        i = R.id.title_bar;
                        TransTitleBar transTitleBar = (TransTitleBar) ViewBindings.a(view, i);
                        if (transTitleBar != null) {
                            i = R.id.tv_captions;
                            TextView textView = (TextView) ViewBindings.a(view, i);
                            if (textView != null) {
                                i = R.id.tv_settings_general;
                                TextView textView2 = (TextView) ViewBindings.a(view, i);
                                if (textView2 != null) {
                                    return new ActivityTranscribeSettingBinding((ConstraintLayout) view, transSettingSubCard, transSettingSubCard2, transSettingItem, constraintLayout, transTitleBar, textView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityTranscribeSettingBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTranscribeSettingBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_transcribe_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6034a;
    }
}
