package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import com.upuphone.hub.annotation.BinderThread;
import com.upuphone.hub.annotation.Hub;
import com.upuphone.hub.annotation.Parcelable;
import com.upuphone.runasone.uupcast.SourceDisplayConfig;

@Hub
public interface ISinkListener {
    void onSinkConnected();

    void onSinkDisconnected();

    void onSinkError(int i, String str);

    void onSinkEvent(int i, @Parcelable Bundle bundle);

    void onSinkStart();

    void onSinkStartWithConfig(SourceDisplayConfig sourceDisplayConfig);

    @BinderThread
    void onSinkSyncError(int i, String str);

    @BinderThread
    void onSinkSyncEvent(int i, @Parcelable Bundle bundle);
}
