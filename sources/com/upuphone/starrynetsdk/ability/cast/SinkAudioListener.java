package com.upuphone.starrynetsdk.ability.cast;

import androidx.annotation.NonNull;
import com.upuphone.runasone.uupcast.CastAudioAttributes;

public interface SinkAudioListener {
    @NonNull
    CastAudioAttributes convertAudioAttributes(int i);

    void onForceMuteStart(int i);

    void onForceMuteStop(int i);
}
