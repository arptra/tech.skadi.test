package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;

public class MouseCursorChannel {
    private static final String TAG = "MouseCursorChannel";
    @NonNull
    public final MethodChannel channel;
    /* access modifiers changed from: private */
    @Nullable
    public MouseCursorMethodHandler mouseCursorMethodHandler;
    @NonNull
    private final MethodChannel.MethodCallHandler parsingMethodCallHandler;

    public interface MouseCursorMethodHandler {
        void activateSystemCursor(@NonNull String str);
    }

    public MouseCursorChannel(@NonNull DartExecutor dartExecutor) {
        AnonymousClass1 r0 = new MethodChannel.MethodCallHandler() {
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                if (MouseCursorChannel.this.mouseCursorMethodHandler != null) {
                    String str = methodCall.method;
                    Log.v(MouseCursorChannel.TAG, "Received '" + str + "' message.");
                    try {
                        if (str.hashCode() == -1307105544) {
                            if (str.equals("activateSystemCursor")) {
                                try {
                                    MouseCursorChannel.this.mouseCursorMethodHandler.activateSystemCursor((String) ((HashMap) methodCall.arguments).get("kind"));
                                    result.success(Boolean.TRUE);
                                } catch (Exception e) {
                                    result.error("error", "Error when setting cursors: " + e.getMessage(), (Object) null);
                                }
                            }
                        }
                    } catch (Exception e2) {
                        result.error("error", "Unhandled error: " + e2.getMessage(), (Object) null);
                    }
                }
            }
        };
        this.parsingMethodCallHandler = r0;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/mousecursor", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r0);
    }

    public void setMethodHandler(@Nullable MouseCursorMethodHandler mouseCursorMethodHandler2) {
        this.mouseCursorMethodHandler = mouseCursorMethodHandler2;
    }

    @VisibleForTesting
    public void synthesizeMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        this.parsingMethodCallHandler.onMethodCall(methodCall, result);
    }
}
