package com.honey.account.v4;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.upuphone.ar.transcribe.phone.activity.TranscribeAIActivity;

public final /* synthetic */ class h implements TabLayoutMediator.TabConfigurationStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeAIActivity f5253a;

    public /* synthetic */ h(TranscribeAIActivity transcribeAIActivity) {
        this.f5253a = transcribeAIActivity;
    }

    public final void onConfigureTab(TabLayout.Tab tab, int i) {
        TranscribeAIActivity.initTabLayout$lambda$1(this.f5253a, tab, i);
    }
}
