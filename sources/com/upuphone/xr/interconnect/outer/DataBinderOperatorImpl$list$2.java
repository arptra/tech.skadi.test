package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IDataBinderServer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "", "Lcom/upuphone/xr/interconnect/common/IDataBinderServer;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DataBinderOperatorImpl$list$2 extends Lambda implements Function1<IDataBinderServer, List<String>> {
    final /* synthetic */ String $deviceId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderOperatorImpl$list$2(String str) {
        super(1);
        this.$deviceId = str;
    }

    public final List<String> invoke(@NotNull IDataBinderServer iDataBinderServer) {
        Intrinsics.checkNotNullParameter(iDataBinderServer, "$this$safeRemoteCall");
        return iDataBinderServer.list(this.$deviceId);
    }
}
