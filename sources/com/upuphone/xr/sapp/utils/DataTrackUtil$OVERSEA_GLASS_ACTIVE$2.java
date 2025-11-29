package com.upuphone.xr.sapp.utils;

import com.upuphone.xr.sapp.config.NetConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DataTrackUtil$OVERSEA_GLASS_ACTIVE$2 extends Lambda implements Function0<String> {
    public static final DataTrackUtil$OVERSEA_GLASS_ACTIVE$2 INSTANCE = new DataTrackUtil$OVERSEA_GLASS_ACTIVE$2();

    public DataTrackUtil$OVERSEA_GLASS_ACTIVE$2() {
        super(0);
    }

    @NotNull
    public final String invoke() {
        String v = NetConfig.f6666a.v("sAccountService");
        return v + "/report/activation";
    }
}
