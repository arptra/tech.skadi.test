package com.honey.account.d5;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.upuphone.ar.translation.phone.activity.TranslatorMainActivity;

public final /* synthetic */ class f implements TabLayoutMediator.TabConfigurationStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranslatorMainActivity f4311a;

    public /* synthetic */ f(TranslatorMainActivity translatorMainActivity) {
        this.f4311a = translatorMainActivity;
    }

    public final void onConfigureTab(TabLayout.Tab tab, int i) {
        TranslatorMainActivity.initTabLayout$lambda$9(this.f4311a, tab, i);
    }
}
