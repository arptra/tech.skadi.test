package com.upuphone.xr.sapp.fragment;

import android.os.Build;
import com.ucar.vehiclesdk.MDevice;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class WakeupRecordMainFragment$Companion$isMeizu$2 extends Lambda implements Function0<Boolean> {
    public static final WakeupRecordMainFragment$Companion$isMeizu$2 INSTANCE = new WakeupRecordMainFragment$Companion$isMeizu$2();

    public WakeupRecordMainFragment$Companion$isMeizu$2() {
        super(0);
    }

    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(StringsKt.contentEquals(MDevice.MANUFACTURERS_MEIZU, Build.MANUFACTURER, true));
    }
}
