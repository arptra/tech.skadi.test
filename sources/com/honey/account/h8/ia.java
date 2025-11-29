package com.honey.account.h8;

import android.view.View;
import com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment;
import com.upuphone.xr.sapp.view.SettingView;

public final /* synthetic */ class ia implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VoiceAssistantsSettingsFragment f4640a;
    public final /* synthetic */ String b;
    public final /* synthetic */ SettingView c;

    public /* synthetic */ ia(VoiceAssistantsSettingsFragment voiceAssistantsSettingsFragment, String str, SettingView settingView) {
        this.f4640a = voiceAssistantsSettingsFragment;
        this.b = str;
        this.c = settingView;
    }

    public final void onClick(View view) {
        VoiceAssistantsSettingsFragment.M0(this.f4640a, this.b, this.c, view);
    }
}
