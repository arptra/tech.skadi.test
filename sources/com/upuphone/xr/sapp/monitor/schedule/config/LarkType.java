package com.upuphone.xr.sapp.monitor.schedule.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/config/LarkType;", "", "(Ljava/lang/String;I)V", "XR_FS_DEBUG", "XR_FS_THRID", "XR_FS_FLYME", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum LarkType {
    XR_FS_DEBUG,
    XR_FS_THRID,
    XR_FS_FLYME;

    static {
        LarkType[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
    }

    @NotNull
    public static EnumEntries<LarkType> getEntries() {
        return $ENTRIES;
    }
}
