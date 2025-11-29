package com.upuphone.starrynetsdk.ability.cast;

import android.os.Bundle;
import androidx.annotation.NonNull;

public abstract class SinkStartListener implements SinkListener {
    public void onSinkConnected() {
    }

    public void onSinkDisconnected() {
    }

    public void onSinkError(int i) {
    }

    public void onSinkEvent(int i, @NonNull Bundle bundle) {
    }
}
