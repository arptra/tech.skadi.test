package com.upuphone.runasone.share.lib;

import android.net.Uri;
import android.text.TextUtils;
import com.honey.account.m6.c;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.share.api.IHubUupShareStatusCallback;
import com.upuphone.runasone.share.lib.ShareApi;
import com.upuphone.runasone.share.lib.bean.Constants;
import com.upuphone.runasone.share.lib.utils.LogUtil;
import com.upuphone.starryshare.ReceiverService;
import com.upuphone.starryshare.listener.IOtaShareListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class OtaTransferReceiverDelegate {
    public static final int RECEIVER_TO_SEND = 3;
    public static final String TAG = "OtaTransferReceiverDelegate";
    /* access modifiers changed from: private */
    public final Map<String, StarryDevice> deviceMap;
    /* access modifiers changed from: private */
    public Map<String, String> fileResumeInfoMap;
    /* access modifiers changed from: private */
    public final TransferHandler handler;
    /* access modifiers changed from: private */
    public Map<String, Boolean> isTransferringMaps;
    private ReceiverService receiverService;

    public static final class SingleTon {
        /* access modifiers changed from: private */
        public static final OtaTransferReceiverDelegate OTA_DELEGATE = new OtaTransferReceiverDelegate();

        private SingleTon() {
        }
    }

    public static OtaTransferReceiverDelegate getInstance() {
        return SingleTon.OTA_DELEGATE;
    }

    /* access modifiers changed from: private */
    public IHubUupShareStatusCallback getmCallback(String str) {
        return UupShare.getInstance().mService.getCallbackByTaskId(str, 1);
    }

    private String parseFilesInfo(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONArray(str);
            int length = jSONArray2.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                String string = optJSONObject.getString("md5");
                long j = optJSONObject.getLong("size");
                String string2 = optJSONObject.has("storage") ? optJSONObject.getString("storage") : str2;
                File file = new File(string2);
                if (!file.isDirectory() && !file.mkdir()) {
                    string2 = Constants.FILE_SAVE_LOCATION;
                    LogUtil.d(TAG, "Can't create base directory " + file.getPath());
                }
                File file2 = new File(string2 + File.separator + string);
                JSONObject jSONObject = new JSONObject();
                if (file2.exists()) {
                    if (file2.length() < j) {
                        jSONObject.put("beginStart", file2.length());
                        jSONObject.put("md5", string);
                        jSONArray.put(jSONObject);
                    }
                }
                jSONObject.put("beginStart", 0);
                jSONObject.put("md5", string);
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONArray.toString();
    }

    public void callBackStart(ShareApi.Message message, StarryDevice starryDevice) {
        String fileInfos = message.getFileInfos();
        String taskId = message.getTaskId();
        String extra = message.getExtra();
        String dirPath = message.getDirPath();
        this.deviceMap.put(taskId, starryDevice);
        startServer(taskId, dirPath);
        LogUtil.i(TAG, "receiver onstart" + taskId + "target:" + starryDevice.getId());
        UupShare.getInstance().mService.putTaskIdPackageName(taskId, message.getPackageName());
        this.fileResumeInfoMap.put(taskId, parseFilesInfo(fileInfos, dirPath));
        this.receiverService.m(taskId, new c(taskId));
        try {
            getmCallback(taskId).onStart(taskId, extra);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.isTransferringMaps.put(taskId, Boolean.FALSE);
        if (this.handler.hasMessages(2)) {
            this.handler.removeMessages(2);
        }
        TransferHandler transferHandler = this.handler;
        transferHandler.sendMessageDelayed(transferHandler.obtainMessage(3, taskId), 30000);
    }

    public void cancel(String str) {
        if (this.isTransferringMaps.containsKey(str)) {
            this.isTransferringMaps.put(str, Boolean.FALSE);
        }
        ReceiverService receiverService2 = this.receiverService;
        if (receiverService2 != null) {
            receiverService2.g(str);
        }
    }

    public void close() {
        if (this.receiverService != null) {
            LogUtil.i(TAG, "receiver server close");
            this.receiverService.h();
            this.receiverService = null;
        }
    }

    public void confirmReceive(String str) {
        this.isTransferringMaps.put(str, Boolean.TRUE);
        LogUtil.i(TAG, "receiver confirmReceive" + str);
        if (this.handler.hasMessages(3)) {
            this.handler.removeMessages(3);
        }
    }

    public void disConnect() {
        LogUtil.i(TAG, "receiver disconnect");
        if (this.handler.hasMessages(3)) {
            this.handler.removeMessages(3);
        }
        for (String cancel : this.isTransferringMaps.keySet()) {
            cancel(cancel);
        }
        close();
    }

    public StarryDevice getDeviceByTaskId(String str) {
        return this.deviceMap.get(str);
    }

    public String getFileResumeInfoById(String str) {
        return this.fileResumeInfoMap.get(str);
    }

    public int getServerPort() {
        ReceiverService receiverService2 = this.receiverService;
        if (receiverService2 != null) {
            return receiverService2.i();
        }
        LogUtil.e(TAG, "receiver server is not ready");
        return -1;
    }

    public boolean isTransferring(String str) {
        Boolean orDefault = this.isTransferringMaps.getOrDefault(str, Boolean.FALSE);
        return orDefault != null && orDefault.booleanValue();
    }

    public void notifyCancel(String str) {
        LogUtil.i(TAG, "receiver notifyCancel" + str);
        try {
            getmCallback(str).onFailure(str, true, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void notifyReceiverTimeOut(String str) {
        try {
            getmCallback(str).onFailure(str, false, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startServer(String str, String str2) {
        LogUtil.i(TAG, "receiver startServer");
        ReceiverService receiverService2 = this.receiverService;
        if (receiverService2 != null) {
            receiverService2.l(str, str2);
            return;
        }
        ReceiverService receiverService3 = new ReceiverService(0);
        this.receiverService = receiverService3;
        receiverService3.l(str, str2);
        this.receiverService.n(new IOtaShareListener() {
            public void onFailure(String str, boolean z, int i) {
                try {
                    LogUtil.i(OtaTransferReceiverDelegate.TAG, "receiver onFailuretaskId" + str + "error code" + i);
                    OtaTransferReceiverDelegate.this.isTransferringMaps.remove(str);
                    OtaTransferReceiverDelegate.this.fileResumeInfoMap.remove(str);
                    OtaTransferReceiverDelegate.this.deviceMap.remove(str);
                    OtaTransferReceiverDelegate.this.handler.removeMessages(8);
                    OtaTransferReceiverDelegate.this.getmCallback(str).onFailure(str, z, i);
                    UupShare.getInstance().mService.removeTaskIdInPackageMaps(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onFinish(String str, Uri uri, Uri uri2) {
                try {
                    LogUtil.i(OtaTransferReceiverDelegate.TAG, "receiver onFinish taskId" + str + ",newUri" + uri2.getPath());
                    OtaTransferReceiverDelegate.this.getmCallback(str).onFinish(str, uri, uri2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onProgressChanged(String str, int i, Uri uri) {
                try {
                    LogUtil.i(OtaTransferReceiverDelegate.TAG, "receiver onProgressChanged " + i + ",taskId:" + str);
                    OtaTransferReceiverDelegate.this.getmCallback(str).onProgressChanged(str, i, uri);
                    OtaTransferReceiverDelegate.this.handler.removeMessages(8);
                    OtaTransferReceiverDelegate.this.handler.sendEmptyMessageDelayed(8, 10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onStart(String str, String str2) {
                try {
                    OtaTransferReceiverDelegate.this.getmCallback(str).onStart(str, str2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onSuccess(String str) {
                try {
                    LogUtil.i(OtaTransferReceiverDelegate.TAG, "receiver onSuccess" + str);
                    OtaTransferReceiverDelegate.this.isTransferringMaps.remove(str);
                    OtaTransferReceiverDelegate.this.fileResumeInfoMap.remove(str);
                    OtaTransferReceiverDelegate.this.getmCallback(str).onSuccess(str);
                    UupShare.getInstance().mService.removeTaskIdInPackageMaps(str);
                    UupShare.getInstance().sendReceiverFinishMessage(str);
                    OtaTransferReceiverDelegate.this.deviceMap.remove(str);
                    OtaTransferReceiverDelegate.this.handler.removeMessages(8);
                    if (OtaTransferReceiverDelegate.this.isTransferringMaps.isEmpty()) {
                        OtaTransferReceiverDelegate.this.handler.sendEmptyMessageDelayed(2, 30000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.receiverService.o();
    }

    private OtaTransferReceiverDelegate() {
        this.isTransferringMaps = new HashMap();
        this.fileResumeInfoMap = new HashMap();
        this.handler = new TransferHandler();
        this.deviceMap = new HashMap();
    }
}
