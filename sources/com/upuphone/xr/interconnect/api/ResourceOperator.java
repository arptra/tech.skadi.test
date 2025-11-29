package com.upuphone.xr.interconnect.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0002\u0010\bJ*\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H&J \u0010\u000e\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/interconnect/api/ResourceOperator;", "", "getAvailability", "", "deviceId", "", "type", "identifier", "(Ljava/lang/String;BLjava/lang/String;)Ljava/lang/Byte;", "open", "", "targetDeviceId", "registerOpener", "taskExecutorName", "setAvailability", "available", "", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ResourceOperator {
    @Nullable
    Byte getAvailability(@Nullable String str, byte b, @NotNull String str2);

    void open(@Nullable String str, @NotNull String str2, byte b, @NotNull String str3);

    void registerOpener(byte b, @NotNull String str);

    void setAvailability(byte b, @NotNull String str, boolean z);
}
