package com.upuphone.xr.interconnect.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.xr.interconnect.common.IDialerListener;

public interface StarryNetDialerManager {
    boolean dial(@NonNull int i, @Nullable String str);

    void registerDialerListener(IDialerListener iDialerListener);

    boolean syncPhoneBook();

    void unregisterDialerListener(IDialerListener iDialerListener);
}
