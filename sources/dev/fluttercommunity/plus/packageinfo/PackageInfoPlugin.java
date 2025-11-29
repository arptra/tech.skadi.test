package dev.fluttercommunity.plus.packageinfo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.upuphone.runasone.uupcast.CaptureType;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\tR\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010'¨\u0006*"}, d2 = {"Ldev/fluttercommunity/plus/packageinfo/PackageInfoPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "<init>", "()V", "", "bytes", "", "a", "([B)Ljava/lang/String;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "binding", "", "onAttachedToEngine", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;)V", "onDetachedFromEngine", "Lio/flutter/plugin/common/MethodCall;", "call", "Lio/flutter/plugin/common/MethodChannel$Result;", "result", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "c", "()Ljava/lang/String;", "Landroid/content/pm/PackageInfo;", "info", "", "d", "(Landroid/content/pm/PackageInfo;)J", "Landroid/content/pm/PackageManager;", "pm", "b", "(Landroid/content/pm/PackageManager;)Ljava/lang/String;", "sig", "e", "Landroid/content/Context;", "Landroid/content/Context;", "applicationContext", "Lio/flutter/plugin/common/MethodChannel;", "Lio/flutter/plugin/common/MethodChannel;", "methodChannel", "Companion", "package_info_plus_release"}, k = 1, mv = {1, 7, 1})
public final class PackageInfoPlugin implements MethodChannel.MethodCallHandler, FlutterPlugin {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public Context f8794a;
    public MethodChannel b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ldev/fluttercommunity/plus/packageinfo/PackageInfoPlugin$Companion;", "", "()V", "CHANNEL_NAME", "", "package_info_plus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    private final String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[(bArr.length * 2)];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            cArr2[i2] = cArr[(b2 & 255) >>> 4];
            cArr2[i2 + 1] = cArr[b2 & 15];
        }
        return new String(cArr2);
    }

    public final String b(PackageManager packageManager) {
        String e;
        try {
            Context context = this.f8794a;
            Intrinsics.checkNotNull(context);
            SigningInfo signingInfo = packageManager.getPackageInfo(context.getPackageName(), CaptureType.CAPTURE_VIRTUAL_DISPLAY_ENABLE_MAGIC_WINDOW).signingInfo;
            if (signingInfo == null) {
                return null;
            }
            if (signingInfo.hasMultipleSigners()) {
                Signature[] apkContentsSigners = signingInfo.getApkContentsSigners();
                Intrinsics.checkNotNullExpressionValue(apkContentsSigners, "signingInfo.apkContentsSigners");
                byte[] byteArray = ((Signature) ArraysKt.first((T[]) apkContentsSigners)).toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "signingInfo.apkContentsS…ers.first().toByteArray()");
                e = e(byteArray);
            } else {
                Signature[] signingCertificateHistory = signingInfo.getSigningCertificateHistory();
                Intrinsics.checkNotNullExpressionValue(signingCertificateHistory, "signingInfo.signingCertificateHistory");
                byte[] byteArray2 = ((Signature) ArraysKt.first((T[]) signingCertificateHistory)).toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray2, "signingInfo.signingCerti…ory.first().toByteArray()");
                e = e(byteArray2);
            }
            return e;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public final String c() {
        Context context = this.f8794a;
        Intrinsics.checkNotNull(context);
        PackageManager packageManager = context.getPackageManager();
        Context context2 = this.f8794a;
        Intrinsics.checkNotNull(context2);
        String packageName = context2.getPackageName();
        return Build.VERSION.SDK_INT >= 30 ? packageManager.getInstallSourceInfo(packageName).getInitiatingPackageName() : packageManager.getInstallerPackageName(packageName);
    }

    public final long d(PackageInfo packageInfo) {
        return packageInfo.getLongVersionCode();
    }

    public final String e(byte[] bArr) {
        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        instance.update(bArr);
        byte[] digest = instance.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "hashText");
        return a(digest);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        this.f8794a = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "dev.fluttercommunity.plus/package_info");
        this.b = methodChannel;
        Intrinsics.checkNotNull(methodChannel);
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        this.f8794a = null;
        MethodChannel methodChannel = this.b;
        Intrinsics.checkNotNull(methodChannel);
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.b = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d A[Catch:{ NameNotFoundException -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e A[Catch:{ NameNotFoundException -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008b A[Catch:{ NameNotFoundException -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0092 A[Catch:{ NameNotFoundException -> 0x0052 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r8, io.flutter.plugin.common.MethodChannel.Result r9) {
        /*
            r7 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r8 = r8.method     // Catch:{ NameNotFoundException -> 0x0052 }
            java.lang.String r0 = "getAll"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r0)     // Catch:{ NameNotFoundException -> 0x0052 }
            if (r8 == 0) goto L_0x009b
            android.content.Context r8 = r7.f8794a     // Catch:{ NameNotFoundException -> 0x0052 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)     // Catch:{ NameNotFoundException -> 0x0052 }
            android.content.pm.PackageManager r8 = r8.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0052 }
            android.content.Context r0 = r7.f8794a     // Catch:{ NameNotFoundException -> 0x0052 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ NameNotFoundException -> 0x0052 }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ NameNotFoundException -> 0x0052 }
            r1 = 0
            android.content.pm.PackageInfo r0 = r8.getPackageInfo(r0, r1)     // Catch:{ NameNotFoundException -> 0x0052 }
            java.lang.String r1 = "packageManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)     // Catch:{ NameNotFoundException -> 0x0052 }
            java.lang.String r1 = r7.b(r8)     // Catch:{ NameNotFoundException -> 0x0052 }
            java.lang.String r2 = r7.c()     // Catch:{ NameNotFoundException -> 0x0052 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ NameNotFoundException -> 0x0052 }
            r3.<init>()     // Catch:{ NameNotFoundException -> 0x0052 }
            java.lang.String r4 = "appName"
            android.content.pm.ApplicationInfo r5 = r0.applicationInfo     // Catch:{ NameNotFoundException -> 0x0052 }
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x0054
            java.lang.CharSequence r8 = r5.loadLabel(r8)     // Catch:{ NameNotFoundException -> 0x0052 }
            if (r8 == 0) goto L_0x0054
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0052 }
            if (r8 != 0) goto L_0x0055
            goto L_0x0054
        L_0x0052:
            r7 = move-exception
            goto L_0x009f
        L_0x0054:
            r8 = r6
        L_0x0055:
            r3.put(r4, r8)     // Catch:{ NameNotFoundException -> 0x0052 }
            java.lang.String r8 = "packageName"
            android.content.Context r4 = r7.f8794a     // Catch:{ NameNotFoundException -> 0x0052 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ NameNotFoundException -> 0x0052 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ NameNotFoundException -> 0x0052 }
            r3.put(r8, r4)     // Catch:{ NameNotFoundException -> 0x0052 }
            java.lang.String r8 = "version"
            java.lang.String r4 = r0.versionName     // Catch:{ NameNotFoundException -> 0x0052 }
            if (r4 != 0) goto L_0x006e
            goto L_0x0074
        L_0x006e:
            java.lang.String r5 = "info.versionName ?: \"\""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ NameNotFoundException -> 0x0052 }
            r6 = r4
        L_0x0074:
            r3.put(r8, r6)     // Catch:{ NameNotFoundException -> 0x0052 }
            java.lang.String r8 = "buildNumber"
            java.lang.String r4 = "info"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ NameNotFoundException -> 0x0052 }
            long r4 = r7.d(r0)     // Catch:{ NameNotFoundException -> 0x0052 }
            java.lang.String r7 = java.lang.String.valueOf(r4)     // Catch:{ NameNotFoundException -> 0x0052 }
            r3.put(r8, r7)     // Catch:{ NameNotFoundException -> 0x0052 }
            if (r1 == 0) goto L_0x0090
            java.lang.String r7 = "buildSignature"
            r3.put(r7, r1)     // Catch:{ NameNotFoundException -> 0x0052 }
        L_0x0090:
            if (r2 == 0) goto L_0x0097
            java.lang.String r7 = "installerStore"
            r3.put(r7, r2)     // Catch:{ NameNotFoundException -> 0x0052 }
        L_0x0097:
            r9.success(r3)     // Catch:{ NameNotFoundException -> 0x0052 }
            goto L_0x00a9
        L_0x009b:
            r9.notImplemented()     // Catch:{ NameNotFoundException -> 0x0052 }
            goto L_0x00a9
        L_0x009f:
            java.lang.String r7 = r7.getMessage()
            r8 = 0
            java.lang.String r0 = "Name not found"
            r9.error(r0, r7, r8)
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.fluttercommunity.plus.packageinfo.PackageInfoPlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
