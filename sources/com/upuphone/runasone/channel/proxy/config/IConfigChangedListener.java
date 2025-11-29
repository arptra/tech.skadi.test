package com.upuphone.runasone.channel.proxy.config;

import androidx.annotation.Nullable;

public interface IConfigChangedListener {
    void onChanged(@Nullable VpnConfig vpnConfig);
}
