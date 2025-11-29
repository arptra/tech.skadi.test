package com.upuphone.xr.sapp.utils;

import com.upuphone.xr.sapp.entity.GlassActiveData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class DataTrackUtil$reportGlassActiveIntl$romVersion$1 extends Lambda implements Function0<String> {
    final /* synthetic */ GlassActiveData $activeData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataTrackUtil$reportGlassActiveIntl$romVersion$1(GlassActiveData glassActiveData) {
        super(0);
        this.$activeData = glassActiveData;
    }

    @NotNull
    public final String invoke() {
        return this.$activeData.getRomVersionOld();
    }
}
