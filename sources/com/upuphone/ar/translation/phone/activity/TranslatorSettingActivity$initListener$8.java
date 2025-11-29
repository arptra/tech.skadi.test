package com.upuphone.ar.translation.phone.activity;

import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslatorSettingActivity$initListener$8 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TranslatorSettingActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorSettingActivity$initListener$8(TranslatorSettingActivity translatorSettingActivity) {
        super(0);
        this.this$0 = translatorSettingActivity;
    }

    public final void invoke() {
        TranslationApp.startRoleVprintActivity$ar_translator_intlRelease(this.this$0);
        PreferencesUtils.r(false);
        this.this$0.getMBinding().n.setSettingTipVisible(false);
    }
}
