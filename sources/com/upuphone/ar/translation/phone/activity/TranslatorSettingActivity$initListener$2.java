package com.upuphone.ar.translation.phone.activity;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isChecked", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslatorSettingActivity$initListener$2 extends Lambda implements Function1<Boolean, Unit> {
    public static final TranslatorSettingActivity$initListener$2 INSTANCE = new TranslatorSettingActivity$initListener$2();

    public TranslatorSettingActivity$initListener$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        LogExt.j("tsiRecord isChecked=" + z, "TranslatorSettingActivity");
        PreferencesUtils.t(z);
    }
}
