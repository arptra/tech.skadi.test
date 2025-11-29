package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;

public class KeyboardChannel {
    public final MethodChannel channel;
    /* access modifiers changed from: private */
    public KeyboardMethodHandler keyboardMethodHandler;
    @NonNull
    public final MethodChannel.MethodCallHandler parsingMethodHandler;

    public interface KeyboardMethodHandler {
        Map<Long, Long> getKeyboardState();
    }

    public KeyboardChannel(@NonNull BinaryMessenger binaryMessenger) {
        AnonymousClass1 r0 = new MethodChannel.MethodCallHandler() {
            Map<Long, Long> pressedState = new HashMap();

            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                if (KeyboardChannel.this.keyboardMethodHandler == null) {
                    result.success(this.pressedState);
                    return;
                }
                String str = methodCall.method;
                str.hashCode();
                if (!str.equals("getKeyboardState")) {
                    result.notImplemented();
                    return;
                }
                try {
                    this.pressedState = KeyboardChannel.this.keyboardMethodHandler.getKeyboardState();
                } catch (IllegalStateException e) {
                    result.error("error", e.getMessage(), (Object) null);
                }
                result.success(this.pressedState);
            }
        };
        this.parsingMethodHandler = r0;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "flutter/keyboard", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r0);
    }

    public void setKeyboardMethodHandler(@Nullable KeyboardMethodHandler keyboardMethodHandler2) {
        this.keyboardMethodHandler = keyboardMethodHandler2;
    }
}
