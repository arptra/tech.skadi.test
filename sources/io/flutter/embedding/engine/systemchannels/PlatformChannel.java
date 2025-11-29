package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlatformChannel {
    private static final String TAG = "PlatformChannel";
    @NonNull
    public final MethodChannel channel;
    @VisibleForTesting
    @NonNull
    final MethodChannel.MethodCallHandler parsingMethodCallHandler;
    /* access modifiers changed from: private */
    @Nullable
    public PlatformMessageHandler platformMessageHandler;

    /* renamed from: io.flutter.embedding.engine.systemchannels.PlatformChannel$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0073 */
        static {
            /*
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiMode[] r0 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode = r0
                r1 = 1
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiMode r2 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiMode.LEAN_BACK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiMode r3 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiMode.IMMERSIVE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiMode r4 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiMode.IMMERSIVE_STICKY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiMode r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiMode.EDGE_TO_EDGE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiOverlay[] r4 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay = r4
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiOverlay r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay.TOP_OVERLAYS     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r4 = $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay     // Catch:{ NoSuchFieldError -> 0x004e }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiOverlay r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay.BOTTOM_OVERLAYS     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                io.flutter.embedding.engine.systemchannels.PlatformChannel$DeviceOrientation[] r4 = io.flutter.embedding.engine.systemchannels.PlatformChannel.DeviceOrientation.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation = r4
                io.flutter.embedding.engine.systemchannels.PlatformChannel$DeviceOrientation r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.DeviceOrientation.PORTRAIT_UP     // Catch:{ NoSuchFieldError -> 0x005f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                int[] r1 = $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation     // Catch:{ NoSuchFieldError -> 0x0069 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$DeviceOrientation r4 = io.flutter.embedding.engine.systemchannels.PlatformChannel.DeviceOrientation.PORTRAIT_DOWN     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                int[] r0 = $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation     // Catch:{ NoSuchFieldError -> 0x0073 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$DeviceOrientation r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.DeviceOrientation.LANDSCAPE_LEFT     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                int[] r0 = $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation     // Catch:{ NoSuchFieldError -> 0x007d }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$DeviceOrientation r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.DeviceOrientation.LANDSCAPE_RIGHT     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.PlatformChannel.AnonymousClass2.<clinit>():void");
        }
    }

    public static class AppSwitcherDescription {
        public final int color;
        @NonNull
        public final String label;

        public AppSwitcherDescription(int i, @NonNull String str) {
            this.color = i;
            this.label = str;
        }
    }

    public enum Brightness {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");
        
        @NonNull
        private String encodedName;

        private Brightness(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static Brightness fromValue(@NonNull String str) throws NoSuchFieldException {
            for (Brightness brightness : values()) {
                if (brightness.encodedName.equals(str)) {
                    return brightness;
                }
            }
            throw new NoSuchFieldException("No such Brightness: " + str);
        }
    }

    public enum ClipboardContentFormat {
        PLAIN_TEXT("text/plain");
        
        @NonNull
        private String encodedName;

        private ClipboardContentFormat(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static ClipboardContentFormat fromValue(@NonNull String str) throws NoSuchFieldException {
            for (ClipboardContentFormat clipboardContentFormat : values()) {
                if (clipboardContentFormat.encodedName.equals(str)) {
                    return clipboardContentFormat;
                }
            }
            throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
        }
    }

    public enum DeviceOrientation {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");
        
        @NonNull
        private String encodedName;

        private DeviceOrientation(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static DeviceOrientation fromValue(@NonNull String str) throws NoSuchFieldException {
            for (DeviceOrientation deviceOrientation : values()) {
                if (deviceOrientation.encodedName.equals(str)) {
                    return deviceOrientation;
                }
            }
            throw new NoSuchFieldException("No such DeviceOrientation: " + str);
        }
    }

    public enum HapticFeedbackType {
        STANDARD((String) null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick");
        
        @Nullable
        private final String encodedName;

        private HapticFeedbackType(@Nullable String str) {
            this.encodedName = str;
        }

        @NonNull
        public static HapticFeedbackType fromValue(@Nullable String str) throws NoSuchFieldException {
            for (HapticFeedbackType hapticFeedbackType : values()) {
                String str2 = hapticFeedbackType.encodedName;
                if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                    return hapticFeedbackType;
                }
            }
            throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
        }
    }

    public interface PlatformMessageHandler {
        boolean clipboardHasStrings();

        @Nullable
        CharSequence getClipboardData(@Nullable ClipboardContentFormat clipboardContentFormat);

        void playSystemSound(@NonNull SoundType soundType);

        void popSystemNavigator();

        void restoreSystemUiOverlays();

        void setApplicationSwitcherDescription(@NonNull AppSwitcherDescription appSwitcherDescription);

        void setClipboardData(@NonNull String str);

        void setFrameworkHandlesBack(boolean z) {
        }

        void setPreferredOrientations(int i);

        void setSystemUiChangeListener();

        void setSystemUiOverlayStyle(@NonNull SystemChromeStyle systemChromeStyle);

        void share(@NonNull String str);

        void showSystemOverlays(@NonNull List<SystemUiOverlay> list);

        void showSystemUiMode(@NonNull SystemUiMode systemUiMode);

        void vibrateHapticFeedback(@NonNull HapticFeedbackType hapticFeedbackType);
    }

    public enum SoundType {
        CLICK("SystemSoundType.click"),
        ALERT("SystemSoundType.alert");
        
        @NonNull
        private final String encodedName;

        private SoundType(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static SoundType fromValue(@NonNull String str) throws NoSuchFieldException {
            for (SoundType soundType : values()) {
                if (soundType.encodedName.equals(str)) {
                    return soundType;
                }
            }
            throw new NoSuchFieldException("No such SoundType: " + str);
        }
    }

    public static class SystemChromeStyle {
        @Nullable
        public final Integer statusBarColor;
        @Nullable
        public final Brightness statusBarIconBrightness;
        @Nullable
        public final Integer systemNavigationBarColor;
        @Nullable
        public final Boolean systemNavigationBarContrastEnforced;
        @Nullable
        public final Integer systemNavigationBarDividerColor;
        @Nullable
        public final Brightness systemNavigationBarIconBrightness;
        @Nullable
        public final Boolean systemStatusBarContrastEnforced;

        public SystemChromeStyle(@Nullable Integer num, @Nullable Brightness brightness, @Nullable Boolean bool, @Nullable Integer num2, @Nullable Brightness brightness2, @Nullable Integer num3, @Nullable Boolean bool2) {
            this.statusBarColor = num;
            this.statusBarIconBrightness = brightness;
            this.systemStatusBarContrastEnforced = bool;
            this.systemNavigationBarColor = num2;
            this.systemNavigationBarIconBrightness = brightness2;
            this.systemNavigationBarDividerColor = num3;
            this.systemNavigationBarContrastEnforced = bool2;
        }
    }

    public enum SystemUiMode {
        LEAN_BACK("SystemUiMode.leanBack"),
        IMMERSIVE("SystemUiMode.immersive"),
        IMMERSIVE_STICKY("SystemUiMode.immersiveSticky"),
        EDGE_TO_EDGE("SystemUiMode.edgeToEdge");
        
        @NonNull
        private String encodedName;

        private SystemUiMode(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static SystemUiMode fromValue(@NonNull String str) throws NoSuchFieldException {
            for (SystemUiMode systemUiMode : values()) {
                if (systemUiMode.encodedName.equals(str)) {
                    return systemUiMode;
                }
            }
            throw new NoSuchFieldException("No such SystemUiMode: " + str);
        }
    }

    public enum SystemUiOverlay {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");
        
        @NonNull
        private String encodedName;

        private SystemUiOverlay(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static SystemUiOverlay fromValue(@NonNull String str) throws NoSuchFieldException {
            for (SystemUiOverlay systemUiOverlay : values()) {
                if (systemUiOverlay.encodedName.equals(str)) {
                    return systemUiOverlay;
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + str);
        }
    }

    public PlatformChannel(@NonNull DartExecutor dartExecutor) {
        AnonymousClass1 r0 = new MethodChannel.MethodCallHandler() {
            /* JADX WARNING: Can't fix incorrect switch cases order */
            /* JADX WARNING: Can't wrap try/catch for region: R(2:67|68) */
            /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
                r7.error("error", "No such clipboard content format: " + r6, (java.lang.Object) null);
             */
            /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x012c */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x014d A[Catch:{ JSONException -> 0x003f }] */
            /* JADX WARNING: Removed duplicated region for block: B:73:0x015a A[Catch:{ JSONException -> 0x003f }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onMethodCall(@androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r6, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r7) {
                /*
                    r5 = this;
                    java.lang.String r0 = "error"
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r1 = r1.platformMessageHandler
                    if (r1 != 0) goto L_0x000b
                    return
                L_0x000b:
                    java.lang.String r1 = r6.method
                    java.lang.Object r6 = r6.arguments
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Received '"
                    r2.append(r3)
                    r2.append(r1)
                    java.lang.String r3 = "' message."
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    java.lang.String r3 = "PlatformChannel"
                    io.flutter.Log.v(r3, r2)
                    r2 = 0
                    int r3 = r1.hashCode()     // Catch:{ JSONException -> 0x003f }
                    switch(r3) {
                        case -1501580720: goto L_0x00ce;
                        case -931781241: goto L_0x00c3;
                        case -766342101: goto L_0x00b8;
                        case -720677196: goto L_0x00ad;
                        case -577225884: goto L_0x00a3;
                        case -548468504: goto L_0x0099;
                        case -247230243: goto L_0x008f;
                        case -215273374: goto L_0x0085;
                        case 241845679: goto L_0x007b;
                        case 875995648: goto L_0x0070;
                        case 1128339786: goto L_0x0065;
                        case 1390477857: goto L_0x0059;
                        case 1514180520: goto L_0x004d;
                        case 1674312266: goto L_0x0042;
                        case 2119655719: goto L_0x0034;
                        default: goto L_0x0032;
                    }     // Catch:{ JSONException -> 0x003f }
                L_0x0032:
                    goto L_0x00d9
                L_0x0034:
                    java.lang.String r3 = "SystemChrome.setPreferredOrientations"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x003f }
                    if (r1 == 0) goto L_0x00d9
                    r1 = 2
                    goto L_0x00da
                L_0x003f:
                    r5 = move-exception
                    goto L_0x0272
                L_0x0042:
                    java.lang.String r3 = "SystemChrome.setEnabledSystemUIOverlays"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x003f }
                    if (r1 == 0) goto L_0x00d9
                    r1 = 4
                    goto L_0x00da
                L_0x004d:
                    java.lang.String r3 = "Clipboard.getData"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x003f }
                    if (r1 == 0) goto L_0x00d9
                    r1 = 11
                    goto L_0x00da
                L_0x0059:
                    java.lang.String r3 = "SystemChrome.setSystemUIOverlayStyle"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x003f }
                    if (r1 == 0) goto L_0x00d9
                    r1 = 8
                    goto L_0x00da
                L_0x0065:
                    java.lang.String r3 = "SystemChrome.setEnabledSystemUIMode"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x003f }
                    if (r1 == 0) goto L_0x00d9
                    r1 = 5
                    goto L_0x00da
                L_0x0070:
                    java.lang.String r3 = "Clipboard.hasStrings"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x003f }
                    if (r1 == 0) goto L_0x00d9
                    r1 = 13
                    goto L_0x00da
                L_0x007b:
                    java.lang.String r3 = "SystemChrome.restoreSystemUIOverlays"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x003f }
                    if (r1 == 0) goto L_0x00d9
                    r1 = 7
                    goto L_0x00da
                L_0x0085:
                    java.lang.String r3 = "SystemSound.play"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x003f }
                    if (r1 == 0) goto L_0x00d9
                    r1 = 0
                    goto L_0x00da
                L_0x008f:
                    java.lang.String r3 = "HapticFeedback.vibrate"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x003f }
                    if (r1 == 0) goto L_0x00d9
                    r1 = 1
                    goto L_0x00da
                L_0x0099:
                    java.lang.String r3 = "SystemChrome.setApplicationSwitcherDescription"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x003f }
                    if (r1 == 0) goto L_0x00d9
                    r1 = 3
                    goto L_0x00da
                L_0x00a3:
                    java.lang.String r3 = "SystemChrome.setSystemUIChangeListener"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x003f }
                    if (r1 == 0) goto L_0x00d9
                    r1 = 6
                    goto L_0x00da
                L_0x00ad:
                    java.lang.String r3 = "Clipboard.setData"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x003f }
                    if (r1 == 0) goto L_0x00d9
                    r1 = 12
                    goto L_0x00da
                L_0x00b8:
                    java.lang.String r3 = "SystemNavigator.pop"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x003f }
                    if (r1 == 0) goto L_0x00d9
                    r1 = 10
                    goto L_0x00da
                L_0x00c3:
                    java.lang.String r3 = "Share.invoke"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x003f }
                    if (r1 == 0) goto L_0x00d9
                    r1 = 14
                    goto L_0x00da
                L_0x00ce:
                    java.lang.String r3 = "SystemNavigator.setFrameworkHandlesBack"
                    boolean r1 = r1.equals(r3)     // Catch:{ JSONException -> 0x003f }
                    if (r1 == 0) goto L_0x00d9
                    r1 = 9
                    goto L_0x00da
                L_0x00d9:
                    r1 = -1
                L_0x00da:
                    java.lang.String r3 = "text"
                    switch(r1) {
                        case 0: goto L_0x0256;
                        case 1: goto L_0x023a;
                        case 2: goto L_0x021c;
                        case 3: goto L_0x01fd;
                        case 4: goto L_0x01dd;
                        case 5: goto L_0x01bd;
                        case 6: goto L_0x01af;
                        case 7: goto L_0x01a1;
                        case 8: goto L_0x0181;
                        case 9: goto L_0x016d;
                        case 10: goto L_0x015f;
                        case 11: goto L_0x0123;
                        case 12: goto L_0x010f;
                        case 13: goto L_0x00f5;
                        case 14: goto L_0x00e5;
                        default: goto L_0x00e0;
                    }
                L_0x00e0:
                    r7.notImplemented()     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x00e5:
                    java.lang.String r6 = (java.lang.String) r6     // Catch:{ JSONException -> 0x003f }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x003f }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ JSONException -> 0x003f }
                    r5.share(r6)     // Catch:{ JSONException -> 0x003f }
                    r7.success(r2)     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x00f5:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x003f }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ JSONException -> 0x003f }
                    boolean r5 = r5.clipboardHasStrings()     // Catch:{ JSONException -> 0x003f }
                    org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x003f }
                    r6.<init>()     // Catch:{ JSONException -> 0x003f }
                    java.lang.String r1 = "value"
                    r6.put(r1, r5)     // Catch:{ JSONException -> 0x003f }
                    r7.success(r6)     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x010f:
                    org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ JSONException -> 0x003f }
                    java.lang.String r6 = r6.getString(r3)     // Catch:{ JSONException -> 0x003f }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x003f }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ JSONException -> 0x003f }
                    r5.setClipboardData(r6)     // Catch:{ JSONException -> 0x003f }
                    r7.success(r2)     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x0123:
                    java.lang.String r6 = (java.lang.String) r6     // Catch:{ JSONException -> 0x003f }
                    if (r6 == 0) goto L_0x0140
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$ClipboardContentFormat r6 = io.flutter.embedding.engine.systemchannels.PlatformChannel.ClipboardContentFormat.fromValue(r6)     // Catch:{ NoSuchFieldException -> 0x012c }
                    goto L_0x0141
                L_0x012c:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x003f }
                    r1.<init>()     // Catch:{ JSONException -> 0x003f }
                    java.lang.String r4 = "No such clipboard content format: "
                    r1.append(r4)     // Catch:{ JSONException -> 0x003f }
                    r1.append(r6)     // Catch:{ JSONException -> 0x003f }
                    java.lang.String r6 = r1.toString()     // Catch:{ JSONException -> 0x003f }
                    r7.error(r0, r6, r2)     // Catch:{ JSONException -> 0x003f }
                L_0x0140:
                    r6 = r2
                L_0x0141:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x003f }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ JSONException -> 0x003f }
                    java.lang.CharSequence r5 = r5.getClipboardData(r6)     // Catch:{ JSONException -> 0x003f }
                    if (r5 == 0) goto L_0x015a
                    org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x003f }
                    r6.<init>()     // Catch:{ JSONException -> 0x003f }
                    r6.put(r3, r5)     // Catch:{ JSONException -> 0x003f }
                    r7.success(r6)     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x015a:
                    r7.success(r2)     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x015f:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x003f }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ JSONException -> 0x003f }
                    r5.popSystemNavigator()     // Catch:{ JSONException -> 0x003f }
                    r7.success(r2)     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x016d:
                    java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ JSONException -> 0x003f }
                    boolean r6 = r6.booleanValue()     // Catch:{ JSONException -> 0x003f }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x003f }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ JSONException -> 0x003f }
                    r5.setFrameworkHandlesBack(r6)     // Catch:{ JSONException -> 0x003f }
                    r7.success(r2)     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x0181:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ NoSuchFieldException | JSONException -> 0x0197 }
                    org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ NoSuchFieldException | JSONException -> 0x0197 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemChromeStyle r6 = r1.decodeSystemChromeStyle(r6)     // Catch:{ NoSuchFieldException | JSONException -> 0x0197 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ NoSuchFieldException | JSONException -> 0x0197 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ NoSuchFieldException | JSONException -> 0x0197 }
                    r5.setSystemUiOverlayStyle(r6)     // Catch:{ NoSuchFieldException | JSONException -> 0x0197 }
                    r7.success(r2)     // Catch:{ NoSuchFieldException | JSONException -> 0x0197 }
                    goto L_0x028a
                L_0x0197:
                    r5 = move-exception
                    java.lang.String r5 = r5.getMessage()     // Catch:{ JSONException -> 0x003f }
                    r7.error(r0, r5, r2)     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x01a1:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x003f }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ JSONException -> 0x003f }
                    r5.restoreSystemUiOverlays()     // Catch:{ JSONException -> 0x003f }
                    r7.success(r2)     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x01af:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x003f }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ JSONException -> 0x003f }
                    r5.setSystemUiChangeListener()     // Catch:{ JSONException -> 0x003f }
                    r7.success(r2)     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x01bd:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ NoSuchFieldException | JSONException -> 0x01d3 }
                    java.lang.String r6 = (java.lang.String) r6     // Catch:{ NoSuchFieldException | JSONException -> 0x01d3 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiMode r6 = r1.decodeSystemUiMode(r6)     // Catch:{ NoSuchFieldException | JSONException -> 0x01d3 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ NoSuchFieldException | JSONException -> 0x01d3 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ NoSuchFieldException | JSONException -> 0x01d3 }
                    r5.showSystemUiMode(r6)     // Catch:{ NoSuchFieldException | JSONException -> 0x01d3 }
                    r7.success(r2)     // Catch:{ NoSuchFieldException | JSONException -> 0x01d3 }
                    goto L_0x028a
                L_0x01d3:
                    r5 = move-exception
                    java.lang.String r5 = r5.getMessage()     // Catch:{ JSONException -> 0x003f }
                    r7.error(r0, r5, r2)     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x01dd:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ NoSuchFieldException | JSONException -> 0x01f3 }
                    org.json.JSONArray r6 = (org.json.JSONArray) r6     // Catch:{ NoSuchFieldException | JSONException -> 0x01f3 }
                    java.util.List r6 = r1.decodeSystemUiOverlays(r6)     // Catch:{ NoSuchFieldException | JSONException -> 0x01f3 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ NoSuchFieldException | JSONException -> 0x01f3 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ NoSuchFieldException | JSONException -> 0x01f3 }
                    r5.showSystemOverlays(r6)     // Catch:{ NoSuchFieldException | JSONException -> 0x01f3 }
                    r7.success(r2)     // Catch:{ NoSuchFieldException | JSONException -> 0x01f3 }
                    goto L_0x028a
                L_0x01f3:
                    r5 = move-exception
                    java.lang.String r5 = r5.getMessage()     // Catch:{ JSONException -> 0x003f }
                    r7.error(r0, r5, r2)     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x01fd:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x0213 }
                    org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ JSONException -> 0x0213 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$AppSwitcherDescription r6 = r1.decodeAppSwitcherDescription(r6)     // Catch:{ JSONException -> 0x0213 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ JSONException -> 0x0213 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ JSONException -> 0x0213 }
                    r5.setApplicationSwitcherDescription(r6)     // Catch:{ JSONException -> 0x0213 }
                    r7.success(r2)     // Catch:{ JSONException -> 0x0213 }
                    goto L_0x028a
                L_0x0213:
                    r5 = move-exception
                    java.lang.String r5 = r5.getMessage()     // Catch:{ JSONException -> 0x003f }
                    r7.error(r0, r5, r2)     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x021c:
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ NoSuchFieldException | JSONException -> 0x0231 }
                    org.json.JSONArray r6 = (org.json.JSONArray) r6     // Catch:{ NoSuchFieldException | JSONException -> 0x0231 }
                    int r6 = r1.decodeOrientations(r6)     // Catch:{ NoSuchFieldException | JSONException -> 0x0231 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ NoSuchFieldException | JSONException -> 0x0231 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ NoSuchFieldException | JSONException -> 0x0231 }
                    r5.setPreferredOrientations(r6)     // Catch:{ NoSuchFieldException | JSONException -> 0x0231 }
                    r7.success(r2)     // Catch:{ NoSuchFieldException | JSONException -> 0x0231 }
                    goto L_0x028a
                L_0x0231:
                    r5 = move-exception
                    java.lang.String r5 = r5.getMessage()     // Catch:{ JSONException -> 0x003f }
                    r7.error(r0, r5, r2)     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x023a:
                    java.lang.String r6 = (java.lang.String) r6     // Catch:{ NoSuchFieldException -> 0x024d }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$HapticFeedbackType r6 = io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType.fromValue(r6)     // Catch:{ NoSuchFieldException -> 0x024d }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ NoSuchFieldException -> 0x024d }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ NoSuchFieldException -> 0x024d }
                    r5.vibrateHapticFeedback(r6)     // Catch:{ NoSuchFieldException -> 0x024d }
                    r7.success(r2)     // Catch:{ NoSuchFieldException -> 0x024d }
                    goto L_0x028a
                L_0x024d:
                    r5 = move-exception
                    java.lang.String r5 = r5.getMessage()     // Catch:{ JSONException -> 0x003f }
                    r7.error(r0, r5, r2)     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x0256:
                    java.lang.String r6 = (java.lang.String) r6     // Catch:{ NoSuchFieldException -> 0x0269 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$SoundType r6 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SoundType.fromValue(r6)     // Catch:{ NoSuchFieldException -> 0x0269 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel r5 = io.flutter.embedding.engine.systemchannels.PlatformChannel.this     // Catch:{ NoSuchFieldException -> 0x0269 }
                    io.flutter.embedding.engine.systemchannels.PlatformChannel$PlatformMessageHandler r5 = r5.platformMessageHandler     // Catch:{ NoSuchFieldException -> 0x0269 }
                    r5.playSystemSound(r6)     // Catch:{ NoSuchFieldException -> 0x0269 }
                    r7.success(r2)     // Catch:{ NoSuchFieldException -> 0x0269 }
                    goto L_0x028a
                L_0x0269:
                    r5 = move-exception
                    java.lang.String r5 = r5.getMessage()     // Catch:{ JSONException -> 0x003f }
                    r7.error(r0, r5, r2)     // Catch:{ JSONException -> 0x003f }
                    goto L_0x028a
                L_0x0272:
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    java.lang.String r1 = "JSON error: "
                    r6.append(r1)
                    java.lang.String r5 = r5.getMessage()
                    r6.append(r5)
                    java.lang.String r5 = r6.toString()
                    r7.error(r0, r5, r2)
                L_0x028a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.PlatformChannel.AnonymousClass1.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
            }
        };
        this.parsingMethodCallHandler = r0;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r0);
    }

    /* access modifiers changed from: private */
    @NonNull
    public AppSwitcherDescription decodeAppSwitcherDescription(@NonNull JSONObject jSONObject) throws JSONException {
        int i = jSONObject.getInt("primaryColor");
        if (i != 0) {
            i |= -16777216;
        }
        return new AppSwitcherDescription(i, jSONObject.getString("label"));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0057, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int decodeOrientations(@androidx.annotation.NonNull org.json.JSONArray r9) throws org.json.JSONException, java.lang.NoSuchFieldException {
        /*
            r8 = this;
            r8 = 0
            r0 = r8
            r1 = r0
            r2 = r1
        L_0x0004:
            int r3 = r9.length()
            r4 = 4
            r5 = 2
            r6 = 1
            if (r0 >= r3) goto L_0x0038
            java.lang.String r3 = r9.getString(r0)
            io.flutter.embedding.engine.systemchannels.PlatformChannel$DeviceOrientation r3 = io.flutter.embedding.engine.systemchannels.PlatformChannel.DeviceOrientation.fromValue(r3)
            int[] r7 = io.flutter.embedding.engine.systemchannels.PlatformChannel.AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation
            int r3 = r3.ordinal()
            r3 = r7[r3]
            if (r3 == r6) goto L_0x0030
            if (r3 == r5) goto L_0x002d
            r5 = 3
            if (r3 == r5) goto L_0x002a
            if (r3 == r4) goto L_0x0027
            goto L_0x0032
        L_0x0027:
            r1 = r1 | 8
            goto L_0x0032
        L_0x002a:
            r1 = r1 | 2
            goto L_0x0032
        L_0x002d:
            r1 = r1 | 4
            goto L_0x0032
        L_0x0030:
            r1 = r1 | 1
        L_0x0032:
            if (r2 != 0) goto L_0x0035
            r2 = r1
        L_0x0035:
            int r0 = r0 + 1
            goto L_0x0004
        L_0x0038:
            if (r1 == 0) goto L_0x0058
            r9 = 9
            r0 = 8
            switch(r1) {
                case 2: goto L_0x0057;
                case 3: goto L_0x004e;
                case 4: goto L_0x004d;
                case 5: goto L_0x004a;
                case 6: goto L_0x004e;
                case 7: goto L_0x004e;
                case 8: goto L_0x0049;
                case 9: goto L_0x004e;
                case 10: goto L_0x0046;
                case 11: goto L_0x0045;
                case 12: goto L_0x004e;
                case 13: goto L_0x004e;
                case 14: goto L_0x004e;
                case 15: goto L_0x0042;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x0054
        L_0x0042:
            r8 = 13
            return r8
        L_0x0045:
            return r5
        L_0x0046:
            r8 = 11
            return r8
        L_0x0049:
            return r0
        L_0x004a:
            r8 = 12
            return r8
        L_0x004d:
            return r9
        L_0x004e:
            if (r2 == r5) goto L_0x0057
            if (r2 == r4) goto L_0x0056
            if (r2 == r0) goto L_0x0055
        L_0x0054:
            return r6
        L_0x0055:
            return r0
        L_0x0056:
            return r9
        L_0x0057:
            return r8
        L_0x0058:
            r8 = -1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.PlatformChannel.decodeOrientations(org.json.JSONArray):int");
    }

    /* access modifiers changed from: private */
    @NonNull
    public SystemChromeStyle decodeSystemChromeStyle(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
        Boolean bool = null;
        Integer valueOf = !jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null;
        Brightness fromValue = !jSONObject.isNull("statusBarIconBrightness") ? Brightness.fromValue(jSONObject.getString("statusBarIconBrightness")) : null;
        Boolean valueOf2 = !jSONObject.isNull("systemStatusBarContrastEnforced") ? Boolean.valueOf(jSONObject.getBoolean("systemStatusBarContrastEnforced")) : null;
        Integer valueOf3 = !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null;
        Brightness fromValue2 = !jSONObject.isNull("systemNavigationBarIconBrightness") ? Brightness.fromValue(jSONObject.getString("systemNavigationBarIconBrightness")) : null;
        Integer valueOf4 = !jSONObject.isNull("systemNavigationBarDividerColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")) : null;
        if (!jSONObject.isNull("systemNavigationBarContrastEnforced")) {
            bool = Boolean.valueOf(jSONObject.getBoolean("systemNavigationBarContrastEnforced"));
        }
        return new SystemChromeStyle(valueOf, fromValue, valueOf2, valueOf3, fromValue2, valueOf4, bool);
    }

    /* access modifiers changed from: private */
    @NonNull
    public SystemUiMode decodeSystemUiMode(@NonNull String str) throws JSONException, NoSuchFieldException {
        int i = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode[SystemUiMode.fromValue(str).ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? SystemUiMode.EDGE_TO_EDGE : SystemUiMode.EDGE_TO_EDGE : SystemUiMode.IMMERSIVE_STICKY : SystemUiMode.IMMERSIVE : SystemUiMode.LEAN_BACK;
    }

    /* access modifiers changed from: private */
    @NonNull
    public List<SystemUiOverlay> decodeSystemUiOverlays(@NonNull JSONArray jSONArray) throws JSONException, NoSuchFieldException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            int i2 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[SystemUiOverlay.fromValue(jSONArray.getString(i)).ordinal()];
            if (i2 == 1) {
                arrayList.add(SystemUiOverlay.TOP_OVERLAYS);
            } else if (i2 == 2) {
                arrayList.add(SystemUiOverlay.BOTTOM_OVERLAYS);
            }
        }
        return arrayList;
    }

    public void setPlatformMessageHandler(@Nullable PlatformMessageHandler platformMessageHandler2) {
        this.platformMessageHandler = platformMessageHandler2;
    }

    public void systemChromeChanged(boolean z) {
        Log.v(TAG, "Sending 'systemUIChange' message.");
        this.channel.invokeMethod("SystemChrome.systemUIChange", Arrays.asList(new Boolean[]{Boolean.valueOf(z)}));
    }
}
