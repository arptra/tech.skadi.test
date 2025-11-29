package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.entity.DataBinderValue;
import com.upuphone.xr.interconnect.util.DataBinderValueExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/interconnect/outer/InfoOperatorImpl$InnerDeviceOperator$ipv4Address$1$subscribe$listener$1", "Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener$Stub;", "onUpdate", "", "newValue", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InfoOperatorImpl$InnerDeviceOperator$ipv4Address$1$subscribe$listener$1 extends IDataBinderItemUpdateListener.Stub {
    final /* synthetic */ Function1<String, Unit> $onUpdate;

    public InfoOperatorImpl$InnerDeviceOperator$ipv4Address$1$subscribe$listener$1(Function1<? super String, Unit> function1) {
        this.$onUpdate = function1;
    }

    public void onUpdate(@Nullable DataBinderValue<?> dataBinderValue) {
        this.$onUpdate.invoke(dataBinderValue != null ? DataBinderValueExtKt.asString(dataBinderValue) : null);
    }
}
