package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.StringCodec;
import java.util.Locale;

public class LifecycleChannel {
    private static final String CHANNEL_NAME = "flutter/lifecycle";
    private static final String TAG = "LifecycleChannel";
    @NonNull
    private final BasicMessageChannel<String> channel;
    private AppLifecycleState lastAndroidState;
    private AppLifecycleState lastFlutterState;
    private boolean lastFocus;

    /* renamed from: io.flutter.embedding.engine.systemchannels.LifecycleChannel$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$LifecycleChannel$AppLifecycleState;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.flutter.embedding.engine.systemchannels.LifecycleChannel$AppLifecycleState[] r0 = io.flutter.embedding.engine.systemchannels.LifecycleChannel.AppLifecycleState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$flutter$embedding$engine$systemchannels$LifecycleChannel$AppLifecycleState = r0
                io.flutter.embedding.engine.systemchannels.LifecycleChannel$AppLifecycleState r1 = io.flutter.embedding.engine.systemchannels.LifecycleChannel.AppLifecycleState.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$flutter$embedding$engine$systemchannels$LifecycleChannel$AppLifecycleState     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.embedding.engine.systemchannels.LifecycleChannel$AppLifecycleState r1 = io.flutter.embedding.engine.systemchannels.LifecycleChannel.AppLifecycleState.INACTIVE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$flutter$embedding$engine$systemchannels$LifecycleChannel$AppLifecycleState     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.flutter.embedding.engine.systemchannels.LifecycleChannel$AppLifecycleState r1 = io.flutter.embedding.engine.systemchannels.LifecycleChannel.AppLifecycleState.HIDDEN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$flutter$embedding$engine$systemchannels$LifecycleChannel$AppLifecycleState     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.flutter.embedding.engine.systemchannels.LifecycleChannel$AppLifecycleState r1 = io.flutter.embedding.engine.systemchannels.LifecycleChannel.AppLifecycleState.PAUSED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$flutter$embedding$engine$systemchannels$LifecycleChannel$AppLifecycleState     // Catch:{ NoSuchFieldError -> 0x003e }
                io.flutter.embedding.engine.systemchannels.LifecycleChannel$AppLifecycleState r1 = io.flutter.embedding.engine.systemchannels.LifecycleChannel.AppLifecycleState.DETACHED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.LifecycleChannel.AnonymousClass1.<clinit>():void");
        }
    }

    public enum AppLifecycleState {
        DETACHED,
        RESUMED,
        INACTIVE,
        HIDDEN,
        PAUSED
    }

    public LifecycleChannel(@NonNull DartExecutor dartExecutor) {
        this((BasicMessageChannel<String>) new BasicMessageChannel(dartExecutor, CHANNEL_NAME, StringCodec.INSTANCE));
    }

    private void sendState(AppLifecycleState appLifecycleState, boolean z) {
        AppLifecycleState appLifecycleState2 = this.lastAndroidState;
        if (appLifecycleState2 != appLifecycleState || z != this.lastFocus) {
            if (appLifecycleState == null && appLifecycleState2 == null) {
                this.lastFocus = z;
                return;
            }
            int i = AnonymousClass1.$SwitchMap$io$flutter$embedding$engine$systemchannels$LifecycleChannel$AppLifecycleState[appLifecycleState.ordinal()];
            AppLifecycleState appLifecycleState3 = i != 1 ? (i == 2 || i == 3 || i == 4 || i == 5) ? appLifecycleState : null : z ? AppLifecycleState.RESUMED : AppLifecycleState.INACTIVE;
            this.lastAndroidState = appLifecycleState;
            this.lastFocus = z;
            if (appLifecycleState3 != this.lastFlutterState) {
                String str = "AppLifecycleState." + appLifecycleState3.name().toLowerCase(Locale.ROOT);
                Log.v(TAG, "Sending " + str + " message.");
                this.channel.send(str);
                this.lastFlutterState = appLifecycleState3;
            }
        }
    }

    public void aWindowIsFocused() {
        sendState(this.lastAndroidState, true);
    }

    public void appIsDetached() {
        sendState(AppLifecycleState.DETACHED, this.lastFocus);
    }

    public void appIsInactive() {
        sendState(AppLifecycleState.INACTIVE, this.lastFocus);
    }

    public void appIsPaused() {
        sendState(AppLifecycleState.PAUSED, this.lastFocus);
    }

    public void appIsResumed() {
        sendState(AppLifecycleState.RESUMED, this.lastFocus);
    }

    public void noWindowsAreFocused() {
        sendState(this.lastAndroidState, false);
    }

    @VisibleForTesting
    public LifecycleChannel(@NonNull BasicMessageChannel<String> basicMessageChannel) {
        this.lastAndroidState = null;
        this.lastFlutterState = null;
        this.lastFocus = true;
        this.channel = basicMessageChannel;
    }
}
