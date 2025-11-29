package com.upuphone.ar.fastrecord.phone.datatrack;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.xr.sapp.context.SdkContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/datatrack/FastRecordDataTrackUtil;", "", "()V", "TAG", "", "reportEvent", "", "eventName", "attributes", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordDataTrackUtil {
    @NotNull
    public static final FastRecordDataTrackUtil INSTANCE = new FastRecordDataTrackUtil();
    @NotNull
    private static final String TAG = "FastRecordDataTrackUtil";

    private FastRecordDataTrackUtil() {
    }

    public final void reportEvent(@NotNull @FastRecordDataEventType String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "attributes");
        LogExt.logI("reportEvent, event: " + str + ", attributes: " + map, TAG);
        try {
            SdkContext.f6675a.d().reportEvent(str, map);
            LogExt.logI("reportEvent, end", TAG);
        } catch (Exception e) {
            LogExt.logE("reportEvent, error: " + e, TAG);
        }
    }
}
