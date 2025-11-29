package com.upuphone.starrynetsdk.ability.cast;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.upuphone.runasone.uupcast.SourceDisplayConfig;

public interface SinkListener {
    void onSinkConnected();

    void onSinkDisconnected();

    void onSinkError(int i);

    void onSinkEvent(int i, @NonNull Bundle bundle);

    void onSinkStart();

    void onSinkStart(@NonNull SourceDisplayConfig sourceDisplayConfig) {
    }

    void onSyncSinkError(int i) {
    }

    void onSyncSinkEvent(int i, @NonNull Bundle bundle) {
    }
}
