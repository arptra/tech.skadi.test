package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IDataBinderServer;
import com.upuphone.xr.interconnect.entity.DataBinderValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0002 \u0003*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0001¨\u0006\u00010\u0001¨\u0006\u0001*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "", "kotlin.jvm.PlatformType", "Lcom/upuphone/xr/interconnect/common/IDataBinderServer;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DataBinderOperatorImpl$get$2 extends Lambda implements Function1<IDataBinderServer, DataBinderValue> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $name;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderOperatorImpl$get$2(String str, String str2) {
        super(1);
        this.$deviceId = str;
        this.$name = str2;
    }

    public final DataBinderValue invoke(@NotNull IDataBinderServer iDataBinderServer) {
        Intrinsics.checkNotNullParameter(iDataBinderServer, "$this$safeRemoteCall");
        return iDataBinderServer.get(this.$deviceId, this.$name);
    }
}
