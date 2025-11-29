package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.entity.GlassUpdateState;
import com.upuphone.xr.sapp.entity.GlassUpdateStateKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00070\u0001¢\u0006\u0002\b\u00022\r\u0010\u0003\u001a\t\u0018\u00010\u0004¢\u0006\u0002\b\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/jvm/JvmSuppressWildcards;", "it", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "invoke", "(Lcom/upuphone/xr/sapp/entity/GlassUpdateState;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassUpdateHelper$glassUpdatingData$1 extends Lambda implements Function1<GlassUpdateState, Boolean> {
    public static final GlassUpdateHelper$glassUpdatingData$1 INSTANCE = new GlassUpdateHelper$glassUpdatingData$1();

    public GlassUpdateHelper$glassUpdatingData$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@Nullable GlassUpdateState glassUpdateState) {
        return Boolean.valueOf(GlassUpdateStateKt.isUpdating(glassUpdateState));
    }
}
