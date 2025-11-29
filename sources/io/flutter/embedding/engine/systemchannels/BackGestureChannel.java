package io.flutter.embedding.engine.systemchannels;

import android.annotation.TargetApi;
import android.window.BackEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.upuphone.starrynet.payload.PayloadConstant;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BackGestureChannel {
    private static final String TAG = "BackGestureChannel";
    @NonNull
    public final MethodChannel channel;
    private final MethodChannel.MethodCallHandler defaultHandler;

    public BackGestureChannel(@NonNull DartExecutor dartExecutor) {
        AnonymousClass1 r0 = new MethodChannel.MethodCallHandler() {
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                result.success((Object) null);
            }
        };
        this.defaultHandler = r0;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/backgesture", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r0);
    }

    @RequiresApi
    @TargetApi(34)
    private Map<String, Object> backEventToJsonMap(@NonNull BackEvent backEvent) {
        HashMap hashMap = new HashMap(3);
        float a2 = backEvent.getTouchX();
        float a3 = backEvent.getTouchY();
        hashMap.put("touchOffset", (Float.isNaN(a2) || Float.isNaN(a3)) ? null : Arrays.asList(new Float[]{Float.valueOf(a2), Float.valueOf(a3)}));
        hashMap.put(PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS, Float.valueOf(backEvent.getProgress()));
        hashMap.put("swipeEdge", Integer.valueOf(backEvent.getSwipeEdge()));
        return hashMap;
    }

    @RequiresApi
    @TargetApi(34)
    public void cancelBackGesture() {
        Log.v(TAG, "Sending message to cancel back gesture");
        this.channel.invokeMethod("cancelBackGesture", (Object) null);
    }

    @RequiresApi
    @TargetApi(34)
    public void commitBackGesture() {
        Log.v(TAG, "Sending message to commit back gesture");
        this.channel.invokeMethod("commitBackGesture", (Object) null);
    }

    public void setMethodCallHandler(@Nullable MethodChannel.MethodCallHandler methodCallHandler) {
        this.channel.setMethodCallHandler(methodCallHandler);
    }

    @RequiresApi
    @TargetApi(34)
    public void startBackGesture(@NonNull BackEvent backEvent) {
        Log.v(TAG, "Sending message to start back gesture");
        this.channel.invokeMethod("startBackGesture", backEventToJsonMap(backEvent));
    }

    @RequiresApi
    @TargetApi(34)
    public void updateBackGestureProgress(@NonNull BackEvent backEvent) {
        Log.v(TAG, "Sending message to update back gesture progress");
        this.channel.invokeMethod("updateBackGestureProgress", backEventToJsonMap(backEvent));
    }
}
