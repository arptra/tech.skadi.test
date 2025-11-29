package com.upuphone.xr.sapp.glass;

import com.tencent.mmkv.MMKV;
import com.upuphone.xr.sapp.entity.BasicGlassInfo;
import com.upuphone.xr.sapp.utils.JsonUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassPreference;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "value", "a", "()Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "b", "(Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;)V", "savedGlassInfo", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GlassPreference {

    /* renamed from: a  reason: collision with root package name */
    public static final GlassPreference f7059a = new GlassPreference();

    public final BasicGlassInfo a() {
        return (BasicGlassInfo) JsonUtils.f7893a.b(MMKV.n().j("glass._glass_info_cache"));
    }

    public final void b(BasicGlassInfo basicGlassInfo) {
        if (basicGlassInfo == null) {
            MMKV.n().E("glass._glass_info_cache");
            return;
        }
        MMKV.n().u("glass._glass_info_cache", JsonUtils.f7893a.e(basicGlassInfo));
    }
}
