package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import com.upuphone.hub.annotation.BinderThread;
import com.upuphone.hub.annotation.Hub;
import com.upuphone.hub.annotation.Parcelable;

@Hub
public interface IDisplayListener {
    void onDisplayConnected();

    void onDisplayDisconnected();

    void onDisplayError(int i, String str);

    void onDisplayEvent(int i, @Parcelable Bundle bundle);

    @BinderThread
    void onDisplaySyncError(int i, String str);

    @BinderThread
    void onDisplaySyncEvent(int i, @Parcelable Bundle bundle);

    void onUibcCustomEvent(String str);
}
