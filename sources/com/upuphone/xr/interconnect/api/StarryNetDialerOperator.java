package com.upuphone.xr.interconnect.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.xr.interconnect.listener.DialerListener;

public interface StarryNetDialerOperator {
    void dial(@NonNull int i, @Nullable String str);

    void registerDialerListener(DialerListener dialerListener);

    void syncPhoneBook();

    void unregisterDialerListener(DialerListener dialerListener);
}
