package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.meizu.common.widget.Switch;
import com.tencent.mmkv.MMKV;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/meizu/common/widget/Switch;", "isChecked", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordSettingActivity$initView$4 extends Lambda implements Function2<Switch, Boolean, Unit> {
    public static final FastRecordSettingActivity$initView$4 INSTANCE = new FastRecordSettingActivity$initView$4();

    public FastRecordSettingActivity$initView$4() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Switch) obj, ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Switch switchR, boolean z) {
        Intrinsics.checkNotNullParameter(switchR, "<anonymous parameter 0>");
        MMKV.n().w(FastRecordSettingActivity.IS_START_SOUND_CHECK, z);
    }
}
