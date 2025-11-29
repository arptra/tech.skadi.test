package com.upuphone.xr.interconnect.api.info;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J1\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/interconnect/api/info/InfoEndpoint;", "T", "", "subscribe", "Lkotlin/Function0;", "", "onUpdate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface InfoEndpoint<T> {
    @NotNull
    Function0<Unit> subscribe(@NotNull Function1<? super T, Unit> function1);
}
