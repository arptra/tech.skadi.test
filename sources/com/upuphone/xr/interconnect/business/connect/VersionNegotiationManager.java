package com.upuphone.xr.interconnect.business.connect;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006Jj\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2F\u0010\f\u001aB\u0012\u0004\u0012\u00020\u0003\u00128\u00126\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b0\u000ej\u0002`\u00120\rH&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/VersionNegotiationManager;", "", "getVersion", "", "deviceId", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "handleMessage", "", "uniteCode", "data", "", "consumerMap", "", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "logTag", "Lcom/upuphone/xr/interconnect/business/messenger/MessageConsumer;", "isVersionReceived", "", "isVersionSent", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface VersionNegotiationManager {
    @Nullable
    Integer getVersion(@NotNull String str);

    void handleMessage(@NotNull String str, @Nullable String str2, @NotNull byte[] bArr, @NotNull Map<Integer, ? extends Function2<? super byte[], ? super String, Unit>> map);

    boolean isVersionReceived(@NotNull String str);

    boolean isVersionSent(@NotNull String str);
}
