package com.upuphone.xr.interconnect.pm;

public interface AppArchiveListener {
    void onAppInstalled(String str, boolean z);

    void onAppReplaced(String str);

    void onAppUninstalled(String str, boolean z);
}
