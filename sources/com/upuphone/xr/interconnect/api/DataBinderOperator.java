package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.common.IDataBinder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/interconnect/api/DataBinderOperator;", "Lcom/upuphone/xr/interconnect/common/IDataBinder$Stub;", "()V", "getSlice", "Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "prefix", "", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class DataBinderOperator extends IDataBinder.Stub {
    @NotNull
    public final DataBinderSlice getSlice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "prefix");
        return new DataBinderSlice(this, str, (CoroutineDispatcher) null, 4, (DefaultConstructorMarker) null);
    }
}
