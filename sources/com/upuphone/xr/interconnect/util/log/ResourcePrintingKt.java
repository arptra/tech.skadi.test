package com.upuphone.xr.interconnect.util.log;

import com.upuphone.xr.interconnect.entity.ResourceDescription;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"stringify", "", "Lcom/upuphone/xr/interconnect/entity/ResourceDescription;", "SharedImpl_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ResourcePrintingKt {
    @NotNull
    public static final String stringify(@NotNull ResourceDescription resourceDescription) {
        Intrinsics.checkNotNullParameter(resourceDescription, "<this>");
        byte b = resourceDescription.type;
        String str = resourceDescription.deviceId;
        String str2 = resourceDescription.identifier;
        return "Resource(" + b + "): dev=" + str + ", id=" + str2;
    }
}
