package com.honey.account.d5;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.upuphone.ar.translation.phone.activity.TranslatorIntelExtnActivity;

public final /* synthetic */ class c implements TabLayoutMediator.TabConfigurationStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorIntelExtnActivity f4306a;

    public /* synthetic */ c(TranslatorIntelExtnActivity translatorIntelExtnActivity) {
        this.f4306a = translatorIntelExtnActivity;
    }

    public final void onConfigureTab(TabLayout.Tab tab, int i) {
        TranslatorIntelExtnActivity.initTabLayout$lambda$2(this.f4306a, tab, i);
    }
}
