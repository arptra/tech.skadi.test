package com.honey.account.h8;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment;
import com.xjsd.ai.assistant.connect.OnDeviceStateChangeListener;

public final /* synthetic */ class ga implements OnDeviceStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VoiceAssistantsSettingsFragment f4614a;

    public /* synthetic */ ga(VoiceAssistantsSettingsFragment voiceAssistantsSettingsFragment) {
        this.f4614a = voiceAssistantsSettingsFragment;
    }

    public final void a(StarryNetDevice starryNetDevice, boolean z) {
        VoiceAssistantsSettingsFragment.H0(this.f4614a, starryNetDevice, z);
    }
}
