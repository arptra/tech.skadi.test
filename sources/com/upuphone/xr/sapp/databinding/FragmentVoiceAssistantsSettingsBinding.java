package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.SettingView;

public final class FragmentVoiceAssistantsSettingsBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6824a;
    public final TextView b;
    public final SettingView c;
    public final SettingView d;
    public final SettingView e;
    public final SettingView f;
    public final SettingView g;
    public final SettingView h;

    public FragmentVoiceAssistantsSettingsBinding(LinearLayout linearLayout, TextView textView, SettingView settingView, SettingView settingView2, SettingView settingView3, SettingView settingView4, SettingView settingView5, SettingView settingView6) {
        this.f6824a = linearLayout;
        this.b = textView;
        this.c = settingView;
        this.d = settingView2;
        this.e = settingView3;
        this.f = settingView4;
        this.g = settingView5;
        this.h = settingView6;
    }

    public static FragmentVoiceAssistantsSettingsBinding a(View view) {
        int i = R.id.back;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.item_asr_display;
            SettingView settingView = (SettingView) ViewBindings.a(view, i);
            if (settingView != null) {
                i = R.id.item_continue_dialog;
                SettingView settingView2 = (SettingView) ViewBindings.a(view, i);
                if (settingView2 != null) {
                    i = R.id.item_llm_reply;
                    SettingView settingView3 = (SettingView) ViewBindings.a(view, i);
                    if (settingView3 != null) {
                        i = R.id.item_tts_timbre;
                        SettingView settingView4 = (SettingView) ViewBindings.a(view, i);
                        if (settingView4 != null) {
                            i = R.id.item_voice_wakeup;
                            SettingView settingView5 = (SettingView) ViewBindings.a(view, i);
                            if (settingView5 != null) {
                                i = R.id.item_voice_wakeup_on_screen_off;
                                SettingView settingView6 = (SettingView) ViewBindings.a(view, i);
                                if (settingView6 != null) {
                                    return new FragmentVoiceAssistantsSettingsBinding((LinearLayout) view, textView, settingView, settingView2, settingView3, settingView4, settingView5, settingView6);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentVoiceAssistantsSettingsBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_voice_assistants_settings, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6824a;
    }
}
