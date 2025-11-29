package com.upuphone.xr.sapp.vu.vm;

import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00070\u0001¢\u0006\u0002\b\u00022\r\u0010\u0003\u001a\t\u0018\u00010\u0004¢\u0006\u0002\b\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/jvm/JvmSuppressWildcards;", "it", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;", "invoke", "(Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuGlassControlModel$connectState$1 extends Lambda implements Function1<VuGlassControlModel.ViewGlassesInfo, Boolean> {
    public static final VuGlassControlModel$connectState$1 INSTANCE = new VuGlassControlModel$connectState$1();

    public VuGlassControlModel$connectState$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@Nullable VuGlassControlModel.ViewGlassesInfo viewGlassesInfo) {
        boolean z = false;
        if (viewGlassesInfo != null && viewGlassesInfo.e()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
