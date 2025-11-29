package com.upuphone.xr.sapp.fragment;

import androidx.core.util.Consumer;
import com.upuphone.xr.sapp.contract.UserGuideAuthResult;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VoiceAssistantsSettingsFragment f7030a;

    public /* synthetic */ f(VoiceAssistantsSettingsFragment voiceAssistantsSettingsFragment) {
        this.f7030a = voiceAssistantsSettingsFragment;
    }

    public final void accept(Object obj) {
        VoiceAssistantsSettingsFragment$checkProtocolState$1.invokeSuspend$lambda$0(this.f7030a, (UserGuideAuthResult) obj);
    }
}
