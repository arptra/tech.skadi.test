package com.jstyle.nordic_otas.nordic_otas_plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.meizu.common.widget.MzContactsContract;
import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import no.nordicsemi.android.dfu.DfuProgressListener;
import no.nordicsemi.android.dfu.DfuServiceController;
import no.nordicsemi.android.dfu.DfuServiceInitiator;
import no.nordicsemi.android.dfu.DfuServiceListenerHelper;

public class NordicOtasPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    /* access modifiers changed from: private */
    public MethodChannel channel;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public String deviceName;
    /* access modifiers changed from: private */
    public DfuProgressListener dfuProgressListener = new DfuProgressListener() {
        public void onDeviceConnected(@NonNull String str) {
            Log.e("test", "dfuProgressListener-onDeviceConnected: " + str);
        }

        public void onDeviceConnecting(@NonNull String str) {
            Log.e("test", "dfuProgressListener-onDeviceConnecting: " + str);
        }

        public void onDeviceDisconnected(@NonNull String str) {
            Log.e("test", "dfuProgressListener-onDeviceDisconnected: " + str);
        }

        public void onDeviceDisconnecting(String str) {
            Log.e("test", "dfuProgressListener-onDeviceDisconnecting: " + str);
        }

        public void onDfuAborted(@NonNull String str) {
            Log.e("test", "dfuProgressListener-onDfuAborted: " + str);
            NordicOtasPlugin.this.sendMessage("4@0");
        }

        public void onDfuCompleted(@NonNull String str) {
            Log.e("test", "dfuProgressListener-onDfuCompleted: " + str);
        }

        public void onDfuProcessStarted(@NonNull String str) {
            Log.e("test", "dfuProgressListener-onDfuProcessStarted: " + str);
            NordicOtasPlugin.this.sendMessage("2@0");
        }

        public void onDfuProcessStarting(@NonNull String str) {
            Log.e("test", "dfuProgressListener-onDfuProcessStarting: " + str);
            NordicOtasPlugin.this.sendMessage("1@0");
        }

        public void onEnablingDfuMode(@NonNull String str) {
            Log.e("test", "dfuProgressListener-onEnablingDfuMode: " + str);
        }

        public void onError(@NonNull String str, int i, int i2, String str2) {
            Log.e("test", "dfuProgressListener-onError: s:" + str + "--s1:" + str2 + " error:" + i + " errorType:" + i2);
            NordicOtasPlugin.this.sendMessage("4@0");
        }

        public void onFirmwareValidating(@NonNull String str) {
            Log.e("test", "dfuProgressListener-onFirmwareValidating: " + str);
        }

        public void onProgressChanged(@NonNull String str, int i, float f, float f2, int i2, int i3) {
            Log.e("test", "dfuProgressListener-onProgressChanged: " + i);
            NordicOtasPlugin nordicOtasPlugin = NordicOtasPlugin.this;
            nordicOtasPlugin.sendMessage("3@" + i);
            if (100 == i && !NordicOtasPlugin.this.sendonSuccess) {
                boolean unused = NordicOtasPlugin.this.sendonSuccess = true;
                NordicOtasPlugin.this.sendMessage("5@0");
                DfuServiceListenerHelper.unregisterProgressListener(NordicOtasPlugin.this.context, NordicOtasPlugin.this.dfuProgressListener);
            }
        }
    };
    private String filePath;
    /* access modifiers changed from: private */
    public String firwmarePath;
    private Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i = message.what;
        }
    };
    /* access modifiers changed from: private */
    public String macAddress;
    /* access modifiers changed from: private */
    public boolean sendonSuccess = false;
    private DfuServiceController serviceController;

    private boolean notice() {
        if (NoticeUtils.isEnabledNotification(this.context)) {
            return true;
        }
        NoticeUtils.setting(this.context);
        return false;
    }

    /* access modifiers changed from: private */
    public void sendMessage(final String str) {
        this.handler.post(new Runnable() {
            public void run() {
                NordicOtasPlugin.this.channel.invokeMethod("sendMessage", str);
            }
        });
    }

    private void setFilePath(String str) {
        Log.e("test", "setFilePath: " + str);
        try {
            if (TextUtils.isEmpty(str)) {
                sendMessage("7@0");
                return;
            }
            ZipUtils.upZipFile(str, ZipUtils.getFromPath(this.context) + "ota/");
            File file = new File(ZipUtils.getFromPath(this.context) + "ota/");
            if (!file.exists()) {
                sendMessage("7@0");
                return;
            }
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].getName().contains("zip")) {
                    this.firwmarePath = listFiles[i].getAbsolutePath();
                }
            }
        } catch (Exception unused) {
            sendMessage("7@0");
        }
    }

    /* access modifiers changed from: private */
    public void startOta(String str, String str2, String str3) {
        Log.e("test", "startOta step1: address" + str2 + "--path" + str3);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            this.sendonSuccess = false;
            DfuServiceController dfuServiceController = this.serviceController;
            Class<DfuService> cls = DfuService.class;
            if (dfuServiceController != null) {
                dfuServiceController.abort();
                this.serviceController = null;
                this.context.stopService(new Intent(this.context, cls));
            }
            DfuServiceListenerHelper.unregisterProgressListener(this.context, this.dfuProgressListener);
            DfuServiceListenerHelper.registerProgressListener(this.context, this.dfuProgressListener);
            Uri parse = Uri.parse("file:" + str3);
            DfuServiceInitiator unsafeExperimentalButtonlessServiceInSecureDfuEnabled = new DfuServiceInitiator(str2).setDeviceName(str).setKeepBond(false).setForceDfu(false).setDisableNotification(true).disableResume().setPacketsReceiptNotificationsEnabled(false).setPacketsReceiptNotificationsValue(12).setUnsafeExperimentalButtonlessServiceInSecureDfuEnabled(true);
            if (str3.endsWith("zip")) {
                unsafeExperimentalButtonlessServiceInSecureDfuEnabled.setZip(parse, str3);
            } else {
                unsafeExperimentalButtonlessServiceInSecureDfuEnabled.setBinOrHex(4, parse, str3);
            }
            this.serviceController = unsafeExperimentalButtonlessServiceInSecureDfuEnabled.start(this.context, cls);
            Log.e("test", "startOta: address" + str2);
        }
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "nordic_otas_plugin");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.context = flutterPluginBinding.getApplicationContext();
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.handler.removeCallbacksAndMessages((Object) null);
        DfuServiceListenerHelper.unregisterProgressListener(this.context, this.dfuProgressListener);
    }

    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        Log.e("test", "onMethodCall-method: " + methodCall.method);
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (methodCall.method.equals("setFilePath")) {
            if (methodCall.hasArgument("path")) {
                this.filePath = (String) methodCall.argument("path");
            }
            setFilePath(this.filePath);
        } else if (methodCall.method.equals("startAndroidOta")) {
            if (methodCall.hasArgument(MzContactsContract.MzContactColumns.ADDRESS)) {
                this.macAddress = (String) methodCall.argument(MzContactsContract.MzContactColumns.ADDRESS);
            }
            if (methodCall.hasArgument("name")) {
                this.deviceName = (String) methodCall.argument("name");
            }
            this.handler.post(new Runnable() {
                public void run() {
                    NordicOtasPlugin nordicOtasPlugin = NordicOtasPlugin.this;
                    nordicOtasPlugin.startOta(nordicOtasPlugin.deviceName, NordicOtasPlugin.this.macAddress, NordicOtasPlugin.this.firwmarePath);
                }
            });
        } else if (methodCall.method.equals("notice")) {
            result.success(Boolean.valueOf(notice()));
        } else {
            result.notImplemented();
        }
    }
}
