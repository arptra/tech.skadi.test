package io.flutter.embedding.engine.plugins.broadcastreceiver;

import android.content.BroadcastReceiver;
import androidx.annotation.NonNull;

public interface BroadcastReceiverPluginBinding {
    @NonNull
    BroadcastReceiver getBroadcastReceiver();
}
