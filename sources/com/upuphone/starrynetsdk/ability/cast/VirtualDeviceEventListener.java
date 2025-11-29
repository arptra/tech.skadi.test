package com.upuphone.starrynetsdk.ability.cast;

import android.os.Bundle;
import androidx.annotation.NonNull;

public interface VirtualDeviceEventListener {
    void onError(int i, String str);

    void onEvent(int i, @NonNull Bundle bundle);
}
