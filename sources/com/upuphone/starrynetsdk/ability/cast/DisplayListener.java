package com.upuphone.starrynetsdk.ability.cast;

import android.os.Bundle;
import androidx.annotation.NonNull;

public interface DisplayListener {
    void onDisplayConnected();

    void onDisplayDisconnected();

    void onDisplayError(int i);

    void onDisplayEvent(int i, @NonNull Bundle bundle) {
    }

    void onSyncDisplayError(int i) {
    }

    void onSyncDisplayEvent(int i, @NonNull Bundle bundle) {
    }

    void onUibcCustomEvent(String str);
}
