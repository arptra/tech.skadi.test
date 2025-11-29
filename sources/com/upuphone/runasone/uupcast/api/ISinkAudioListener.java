package com.upuphone.runasone.uupcast.api;

import androidx.annotation.NonNull;
import com.upuphone.hub.annotation.BinderThread;
import com.upuphone.hub.annotation.Hub;
import com.upuphone.runasone.uupcast.CastAudioAttributes;

@Hub
public interface ISinkAudioListener {
    @BinderThread
    @NonNull
    CastAudioAttributes convertAudioAttributes(int i);

    void onForceMuteStart(int i);

    void onForceMuteStop(int i);
}
