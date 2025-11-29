package io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.WindowInsetsControllerCompat;
import com.meizu.common.widget.CircleProgressBar;
import com.upuphone.runasone.uupcast.CastErrorCode;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import java.util.List;

public class PlatformPlugin {
    public static final int DEFAULT_SYSTEM_UI = 1280;
    private static final String TAG = "PlatformPlugin";
    private final Activity activity;
    private PlatformChannel.SystemChromeStyle currentTheme;
    private int mEnabledOverlays;
    @VisibleForTesting
    final PlatformChannel.PlatformMessageHandler mPlatformMessageHandler;
    /* access modifiers changed from: private */
    public final PlatformChannel platformChannel;
    @Nullable
    private final PlatformPluginDelegate platformPluginDelegate;

    /* renamed from: io.flutter.plugin.platform.PlatformPlugin$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType;
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|18|19|20|21|22|(3:23|24|26)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0069 */
        static {
            /*
                io.flutter.embedding.engine.systemchannels.PlatformChannel$Brightness[] r0 = io.flutter.embedding.engine.systemchannels.PlatformChannel.Brightness.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness = r0
                r1 = 1
                io.flutter.embedding.engine.systemchannels.PlatformChannel$Brightness r2 = io.flutter.embedding.engine.systemchannels.PlatformChannel.Brightness.DARK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$Brightness r3 = io.flutter.embedding.engine.systemchannels.PlatformChannel.Brightness.LIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiOverlay[] r2 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay = r2
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiOverlay r3 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay.TOP_OVERLAYS     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay     // Catch:{ NoSuchFieldError -> 0x0038 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiOverlay r3 = io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay.BOTTOM_OVERLAYS     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                io.flutter.embedding.engine.systemchannels.PlatformChannel$HapticFeedbackType[] r2 = io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType = r2
                io.flutter.embedding.engine.systemchannels.PlatformChannel$HapticFeedbackType r3 = io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType.STANDARD     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r1 = $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType     // Catch:{ NoSuchFieldError -> 0x0053 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$HapticFeedbackType r2 = io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType.LIGHT_IMPACT     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r0 = $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType     // Catch:{ NoSuchFieldError -> 0x005e }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$HapticFeedbackType r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType.MEDIUM_IMPACT     // Catch:{ NoSuchFieldError -> 0x005e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r0 = $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType     // Catch:{ NoSuchFieldError -> 0x0069 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$HapticFeedbackType r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType.HEAVY_IMPACT     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                int[] r0 = $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType     // Catch:{ NoSuchFieldError -> 0x0074 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$HapticFeedbackType r1 = io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType.SELECTION_CLICK     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.platform.PlatformPlugin.AnonymousClass3.<clinit>():void");
        }
    }

    public interface PlatformPluginDelegate {
        boolean popSystemNavigator();

        void setFrameworkHandlesBack(boolean z) {
        }
    }

    public PlatformPlugin(@NonNull Activity activity2, @NonNull PlatformChannel platformChannel2) {
        this(activity2, platformChannel2, (PlatformPluginDelegate) null);
    }

    /* access modifiers changed from: private */
    public boolean clipboardHasStrings() {
        ClipDescription primaryClipDescription;
        ClipboardManager clipboardManager = (ClipboardManager) this.activity.getSystemService("clipboard");
        if (clipboardManager.hasPrimaryClip() && (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) != null) {
            return primaryClipDescription.hasMimeType("text/*");
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0086, code lost:
        io.flutter.Log.w(TAG, "Clipboard text was unable to be received from content URI.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008c, code lost:
        io.flutter.Log.w(TAG, "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0091, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025 A[Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x0023 }, ExcHandler: SecurityException (r6v3 'e' java.lang.SecurityException A[CUSTOM_DECLARE, Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x0023 }]), Splitter:B:3:0x0014] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[ExcHandler: FileNotFoundException (unused java.io.FileNotFoundException), SYNTHETIC, Splitter:B:3:0x0014] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.CharSequence getClipboardData(io.flutter.embedding.engine.systemchannels.PlatformChannel.ClipboardContentFormat r7) {
        /*
            r6 = this;
            java.lang.String r0 = "PlatformPlugin"
            android.app.Activity r1 = r6.activity
            java.lang.String r2 = "clipboard"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.content.ClipboardManager r1 = (android.content.ClipboardManager) r1
            boolean r2 = r1.hasPrimaryClip()
            r3 = 0
            if (r2 != 0) goto L_0x0014
            return r3
        L_0x0014:
            android.content.ClipData r1 = r1.getPrimaryClip()     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x0023 }
            if (r1 != 0) goto L_0x001b
            return r3
        L_0x001b:
            if (r7 == 0) goto L_0x0027
            io.flutter.embedding.engine.systemchannels.PlatformChannel$ClipboardContentFormat r2 = io.flutter.embedding.engine.systemchannels.PlatformChannel.ClipboardContentFormat.PLAIN_TEXT     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x0023 }
            if (r7 != r2) goto L_0x0022
            goto L_0x0027
        L_0x0022:
            return r3
        L_0x0023:
            r6 = move-exception
            goto L_0x0080
        L_0x0025:
            r6 = move-exception
            goto L_0x008c
        L_0x0027:
            r7 = 0
            android.content.ClipData$Item r7 = r1.getItemAt(r7)     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x0023 }
            java.lang.CharSequence r1 = r7.getText()     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x0023 }
            if (r1 != 0) goto L_0x007f
            android.net.Uri r2 = r7.getUri()     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
            if (r2 != 0) goto L_0x0041
            java.lang.String r6 = "Clipboard item contained no textual content nor a URI to retrieve it from."
            io.flutter.Log.w(r0, r6)     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
            return r3
        L_0x003e:
            r6 = move-exception
            r3 = r1
            goto L_0x0080
        L_0x0041:
            java.lang.String r4 = r2.getScheme()     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
            java.lang.String r5 = "content"
            boolean r5 = r4.equals(r5)     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
            if (r5 != 0) goto L_0x0067
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
            r6.<init>()     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
            java.lang.String r7 = "Clipboard item contains a Uri with scheme '"
            r6.append(r7)     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
            r6.append(r4)     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
            java.lang.String r7 = "'that is unhandled."
            r6.append(r7)     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
            java.lang.String r6 = r6.toString()     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
            io.flutter.Log.w(r0, r6)     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
            return r3
        L_0x0067:
            android.app.Activity r4 = r6.activity     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
            java.lang.String r5 = "text/*"
            android.content.res.AssetFileDescriptor r2 = r4.openTypedAssetFileDescriptor(r2, r5, r3)     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
            android.app.Activity r6 = r6.activity     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
            java.lang.CharSequence r1 = r7.coerceToText(r6)     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
            if (r2 == 0) goto L_0x007f
            r2.close()     // Catch:{ SecurityException -> 0x0025, FileNotFoundException -> 0x0086, IOException -> 0x003e }
        L_0x007f:
            return r1
        L_0x0080:
            java.lang.String r7 = "Failed to close AssetFileDescriptor while trying to read text from URI."
            io.flutter.Log.w(r0, r7, r6)
            return r3
        L_0x0086:
            java.lang.String r6 = "Clipboard text was unable to be received from content URI."
            io.flutter.Log.w(r0, r6)
            return r3
        L_0x008c:
            java.lang.String r7 = "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview"
            io.flutter.Log.w(r0, r7, r6)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.platform.PlatformPlugin.getClipboardData(io.flutter.embedding.engine.systemchannels.PlatformChannel$ClipboardContentFormat):java.lang.CharSequence");
    }

    /* access modifiers changed from: private */
    public void playSystemSound(@NonNull PlatformChannel.SoundType soundType) {
        if (soundType == PlatformChannel.SoundType.CLICK) {
            this.activity.getWindow().getDecorView().playSoundEffect(0);
        }
    }

    /* access modifiers changed from: private */
    public void popSystemNavigator() {
        PlatformPluginDelegate platformPluginDelegate2 = this.platformPluginDelegate;
        if (platformPluginDelegate2 == null || !platformPluginDelegate2.popSystemNavigator()) {
            Activity activity2 = this.activity;
            if (activity2 instanceof OnBackPressedDispatcherOwner) {
                ((OnBackPressedDispatcherOwner) activity2).getOnBackPressedDispatcher().l();
            } else {
                activity2.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public void restoreSystemChromeSystemUIOverlays() {
        updateSystemUiOverlays();
    }

    /* access modifiers changed from: private */
    public void setClipboardData(String str) {
        ((ClipboardManager) this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", str));
    }

    /* access modifiers changed from: private */
    public void setFrameworkHandlesBack(boolean z) {
        PlatformPluginDelegate platformPluginDelegate2 = this.platformPluginDelegate;
        if (platformPluginDelegate2 != null) {
            platformPluginDelegate2.setFrameworkHandlesBack(z);
        }
    }

    /* access modifiers changed from: private */
    public void setSystemChromeApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription appSwitcherDescription) {
        this.activity.setTaskDescription(new ActivityManager.TaskDescription(appSwitcherDescription.label, 0, appSwitcherDescription.color));
    }

    /* access modifiers changed from: private */
    public void setSystemChromeChangeListener() {
        final View decorView = this.activity.getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$onSystemUiVisibilityChange$0(int i) {
                if ((i & 4) == 0) {
                    PlatformPlugin.this.platformChannel.systemChromeChanged(true);
                } else {
                    PlatformPlugin.this.platformChannel.systemChromeChanged(false);
                }
            }

            public void onSystemUiVisibilityChange(int i) {
                decorView.post(new a(this, i));
            }
        });
    }

    /* access modifiers changed from: private */
    public void setSystemChromeEnabledSystemUIMode(PlatformChannel.SystemUiMode systemUiMode) {
        int i;
        if (systemUiMode == PlatformChannel.SystemUiMode.LEAN_BACK) {
            i = 1798;
        } else if (systemUiMode == PlatformChannel.SystemUiMode.IMMERSIVE) {
            i = 3846;
        } else if (systemUiMode == PlatformChannel.SystemUiMode.IMMERSIVE_STICKY) {
            i = 5894;
        } else if (systemUiMode == PlatformChannel.SystemUiMode.EDGE_TO_EDGE) {
            i = 1792;
        } else {
            return;
        }
        this.mEnabledOverlays = i;
        updateSystemUiOverlays();
    }

    /* access modifiers changed from: private */
    public void setSystemChromeEnabledSystemUIOverlays(List<PlatformChannel.SystemUiOverlay> list) {
        int i = list.size() == 0 ? 5894 : 1798;
        for (int i2 = 0; i2 < list.size(); i2++) {
            int i3 = AnonymousClass3.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[list.get(i2).ordinal()];
            if (i3 == 1) {
                i &= -5;
            } else if (i3 == 2) {
                i &= CastErrorCode.SINK_NOT_SUPPORT_FEATURE;
            }
        }
        this.mEnabledOverlays = i;
        updateSystemUiOverlays();
    }

    /* access modifiers changed from: private */
    public void setSystemChromePreferredOrientations(int i) {
        this.activity.setRequestedOrientation(i);
    }

    /* access modifiers changed from: private */
    public void setSystemChromeSystemUIOverlayStyle(PlatformChannel.SystemChromeStyle systemChromeStyle) {
        Window window = this.activity.getWindow();
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
        if (Build.VERSION.SDK_INT < 30) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(CircleProgressBar.RIM_COLOR_DEF);
        }
        PlatformChannel.Brightness brightness = systemChromeStyle.statusBarIconBrightness;
        if (brightness != null) {
            int i = AnonymousClass3.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[brightness.ordinal()];
            if (i == 1) {
                windowInsetsControllerCompat.d(true);
            } else if (i == 2) {
                windowInsetsControllerCompat.d(false);
            }
        }
        Integer num = systemChromeStyle.statusBarColor;
        if (num != null) {
            window.setStatusBarColor(num.intValue());
        }
        Boolean bool = systemChromeStyle.systemStatusBarContrastEnforced;
        if (bool != null) {
            window.setStatusBarContrastEnforced(bool.booleanValue());
        }
        PlatformChannel.Brightness brightness2 = systemChromeStyle.systemNavigationBarIconBrightness;
        if (brightness2 != null) {
            int i2 = AnonymousClass3.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[brightness2.ordinal()];
            if (i2 == 1) {
                windowInsetsControllerCompat.c(true);
            } else if (i2 == 2) {
                windowInsetsControllerCompat.c(false);
            }
        }
        Integer num2 = systemChromeStyle.systemNavigationBarColor;
        if (num2 != null) {
            window.setNavigationBarColor(num2.intValue());
        }
        Integer num3 = systemChromeStyle.systemNavigationBarDividerColor;
        if (num3 != null) {
            window.setNavigationBarDividerColor(num3.intValue());
        }
        Boolean bool2 = systemChromeStyle.systemNavigationBarContrastEnforced;
        if (bool2 != null) {
            window.setNavigationBarContrastEnforced(bool2.booleanValue());
        }
        this.currentTheme = systemChromeStyle;
    }

    /* access modifiers changed from: private */
    public void share(@NonNull String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        this.activity.startActivity(Intent.createChooser(intent, (CharSequence) null));
    }

    public void destroy() {
        this.platformChannel.setPlatformMessageHandler((PlatformChannel.PlatformMessageHandler) null);
    }

    public void updateSystemUiOverlays() {
        this.activity.getWindow().getDecorView().setSystemUiVisibility(this.mEnabledOverlays);
        PlatformChannel.SystemChromeStyle systemChromeStyle = this.currentTheme;
        if (systemChromeStyle != null) {
            setSystemChromeSystemUIOverlayStyle(systemChromeStyle);
        }
    }

    @VisibleForTesting
    public void vibrateHapticFeedback(@NonNull PlatformChannel.HapticFeedbackType hapticFeedbackType) {
        View decorView = this.activity.getWindow().getDecorView();
        int i = AnonymousClass3.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[hapticFeedbackType.ordinal()];
        if (i == 1) {
            decorView.performHapticFeedback(0);
        } else if (i == 2) {
            decorView.performHapticFeedback(1);
        } else if (i == 3) {
            decorView.performHapticFeedback(3);
        } else if (i == 4) {
            decorView.performHapticFeedback(6);
        } else if (i == 5) {
            decorView.performHapticFeedback(4);
        }
    }

    public PlatformPlugin(@NonNull Activity activity2, @NonNull PlatformChannel platformChannel2, @Nullable PlatformPluginDelegate platformPluginDelegate2) {
        AnonymousClass1 r0 = new PlatformChannel.PlatformMessageHandler() {
            public boolean clipboardHasStrings() {
                return PlatformPlugin.this.clipboardHasStrings();
            }

            public CharSequence getClipboardData(@Nullable PlatformChannel.ClipboardContentFormat clipboardContentFormat) {
                return PlatformPlugin.this.getClipboardData(clipboardContentFormat);
            }

            public void playSystemSound(@NonNull PlatformChannel.SoundType soundType) {
                PlatformPlugin.this.playSystemSound(soundType);
            }

            public void popSystemNavigator() {
                PlatformPlugin.this.popSystemNavigator();
            }

            public void restoreSystemUiOverlays() {
                PlatformPlugin.this.restoreSystemChromeSystemUIOverlays();
            }

            public void setApplicationSwitcherDescription(@NonNull PlatformChannel.AppSwitcherDescription appSwitcherDescription) {
                PlatformPlugin.this.setSystemChromeApplicationSwitcherDescription(appSwitcherDescription);
            }

            public void setClipboardData(@NonNull String str) {
                PlatformPlugin.this.setClipboardData(str);
            }

            public void setFrameworkHandlesBack(boolean z) {
                PlatformPlugin.this.setFrameworkHandlesBack(z);
            }

            public void setPreferredOrientations(int i) {
                PlatformPlugin.this.setSystemChromePreferredOrientations(i);
            }

            public void setSystemUiChangeListener() {
                PlatformPlugin.this.setSystemChromeChangeListener();
            }

            public void setSystemUiOverlayStyle(@NonNull PlatformChannel.SystemChromeStyle systemChromeStyle) {
                PlatformPlugin.this.setSystemChromeSystemUIOverlayStyle(systemChromeStyle);
            }

            public void share(@NonNull String str) {
                PlatformPlugin.this.share(str);
            }

            public void showSystemOverlays(@NonNull List<PlatformChannel.SystemUiOverlay> list) {
                PlatformPlugin.this.setSystemChromeEnabledSystemUIOverlays(list);
            }

            public void showSystemUiMode(@NonNull PlatformChannel.SystemUiMode systemUiMode) {
                PlatformPlugin.this.setSystemChromeEnabledSystemUIMode(systemUiMode);
            }

            public void vibrateHapticFeedback(@NonNull PlatformChannel.HapticFeedbackType hapticFeedbackType) {
                PlatformPlugin.this.vibrateHapticFeedback(hapticFeedbackType);
            }
        };
        this.mPlatformMessageHandler = r0;
        this.activity = activity2;
        this.platformChannel = platformChannel2;
        platformChannel2.setPlatformMessageHandler(r0);
        this.platformPluginDelegate = platformPluginDelegate2;
        this.mEnabledOverlays = DEFAULT_SYSTEM_UI;
    }
}
