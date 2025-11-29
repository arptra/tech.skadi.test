package io.flutter.embedding.engine.systemchannels;

import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.ArrayList;
import java.util.Map;

public class ProcessTextChannel {
    private static final String CHANNEL_NAME = "flutter/processtext";
    private static final String METHOD_PROCESS_TEXT_ACTION = "ProcessText.processTextAction";
    private static final String METHOD_QUERY_TEXT_ACTIONS = "ProcessText.queryTextActions";
    private static final String TAG = "ProcessTextChannel";
    public final MethodChannel channel;
    public final PackageManager packageManager;
    @NonNull
    public final MethodChannel.MethodCallHandler parsingMethodHandler;
    /* access modifiers changed from: private */
    public ProcessTextMethodHandler processTextMethodHandler;

    public interface ProcessTextMethodHandler {
        void processTextAction(@NonNull String str, @NonNull String str2, @NonNull boolean z, @NonNull MethodChannel.Result result);

        Map<String, String> queryTextActions();
    }

    public ProcessTextChannel(@NonNull DartExecutor dartExecutor, @NonNull PackageManager packageManager2) {
        AnonymousClass1 r0 = new MethodChannel.MethodCallHandler() {
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                if (ProcessTextChannel.this.processTextMethodHandler != null) {
                    String str = methodCall.method;
                    Object obj = methodCall.arguments;
                    str.hashCode();
                    if (str.equals(ProcessTextChannel.METHOD_PROCESS_TEXT_ACTION)) {
                        try {
                            ArrayList arrayList = (ArrayList) obj;
                            boolean booleanValue = ((Boolean) arrayList.get(2)).booleanValue();
                            ProcessTextChannel.this.processTextMethodHandler.processTextAction((String) arrayList.get(0), (String) arrayList.get(1), booleanValue, result);
                        } catch (IllegalStateException e) {
                            result.error("error", e.getMessage(), (Object) null);
                        }
                    } else if (!str.equals(ProcessTextChannel.METHOD_QUERY_TEXT_ACTIONS)) {
                        result.notImplemented();
                    } else {
                        try {
                            result.success(ProcessTextChannel.this.processTextMethodHandler.queryTextActions());
                        } catch (IllegalStateException e2) {
                            result.error("error", e2.getMessage(), (Object) null);
                        }
                    }
                }
            }
        };
        this.parsingMethodHandler = r0;
        this.packageManager = packageManager2;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, CHANNEL_NAME, StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r0);
    }

    public void setMethodHandler(@Nullable ProcessTextMethodHandler processTextMethodHandler2) {
        this.processTextMethodHandler = processTextMethodHandler2;
    }
}
