package com.upuphone.ar.navi.lite.datatrack;

import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.context.SdkContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/navi/lite/datatrack/NaviDataTrackUtil;", "", "<init>", "()V", "", "eventName", "", "attributes", "", "a", "(Ljava/lang/String;Ljava/util/Map;)V", "ar-navi_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NaviDataTrackUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final NaviDataTrackUtil f5757a = new NaviDataTrackUtil();

    public final void a(String str, Map map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "attributes");
        CLog.c("NaviDataTrackUtil", "reportEvent, event: " + str + ", attributes: " + map);
        try {
            if (!NaviUtil.s0()) {
                SdkContext.f6675a.d().reportEvent(str, map);
            }
            ULog.f6446a.g("NaviDataTrackUtil", "reportEvent, end");
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("NaviDataTrackUtil", "reportEvent, error: " + e);
        }
    }
}
