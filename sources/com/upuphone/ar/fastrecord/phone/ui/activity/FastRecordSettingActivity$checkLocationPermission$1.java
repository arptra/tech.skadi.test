package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.tencent.mmkv.MMKV;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordSettingActivity$checkLocationPermission$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ FastRecordSettingActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordSettingActivity$checkLocationPermission$1(FastRecordSettingActivity fastRecordSettingActivity) {
        super(1);
        this.this$0 = fastRecordSettingActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        LogExt.logE("checkLocationPermission requestPermission " + z, "FastRecordSettingActivity");
        if (z) {
            MMKV.n().w(FastRecordSettingActivity.IS_START_LOCATION, true);
            this.this$0.getLayout().f.setChecked(true);
        }
    }
}
