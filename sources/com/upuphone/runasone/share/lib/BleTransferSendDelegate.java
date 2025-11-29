package com.upuphone.runasone.share.lib;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.protobuf.ByteString;
import com.honey.account.m6.a;
import com.honey.account.m6.b;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.IAbilitySlot;
import com.upuphone.runasone.share.api.IHubUupShareStatusCallback;
import com.upuphone.runasone.share.lib.ShareApi;
import com.upuphone.runasone.share.lib.bean.BleFileInfo;
import com.upuphone.runasone.share.lib.listener.BleTransfer;
import com.upuphone.runasone.share.lib.utils.LogUtil;
import com.upuphone.runasone.share.lib.utils.Utils;
import com.upuphone.starryshare.bean.FileInfo;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

public final class BleTransferSendDelegate extends BleTransfer {
    public static final String TAG = "BleTransferSendDelegate";
    private final Object mLock;
    private Map<String, String> taskToDeviceId;

    public static final class SingleTon {
        public static final BleTransferSendDelegate BLE_DELEGATE = new BleTransferSendDelegate();

        private SingleTon() {
        }
    }

    private void buildChunkDataMessage(byte[] bArr, String str, long j, int i) {
        ShareApi.Message build = ShareApi.Message.newBuilder().setType(ShareApi.StreamType.SENDER_DATA).setChunkData(ByteString.copyFrom(bArr)).setChunkStart(j).setOrder(i).setTaskId(str).build();
        String str2 = this.taskToDeviceId.get(str);
        if (!TextUtils.isEmpty(str2)) {
            UupShare.getInstance().outputMessage(this.deviceMap.get(str2), build);
            LogUtil.d(TAG, "send chunkData message");
        }
    }

    public static BleTransferSendDelegate getInstance() {
        return SingleTon.BLE_DELEGATE;
    }

    private void getSlicesDataByNumber(InputStream inputStream, long j, int i, String str, boolean z, BleFileInfo bleFileInfo, long j2) {
        long j3 = j;
        int i2 = i;
        String str2 = str;
        byte[] bArr = new byte[i2];
        try {
            LogUtil.d(TAG, "slice filestart:" + j + " , size:" + i2 + ",totalSize" + bleFileInfo.getInfo().getSize() + ", available " + inputStream.available());
            if (z) {
                inputStream.skip(j);
                LogUtil.d(TAG, "skip");
            }
            long currentTimeMillis = System.currentTimeMillis();
            InputStream inputStream2 = inputStream;
            if (inputStream.read(bArr) == -1) {
                LogUtil.d(TAG, "read failed");
                onFailure(str2, 1);
                sendTransferFailMessage(str2);
                return;
            }
            LogUtil.d(TAG, "read " + (System.currentTimeMillis() - currentTimeMillis));
            buildChunkDataMessage(bArr, str, j, (int) (j3 / j2));
            try {
                getmCallback(str2, 2).onProgressChanged(str2, (int) (((j3 + ((long) i2)) * 100) / bleFileInfo.getInfo().getSize()), bleFileInfo.getInfo().getUri());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onFailure$0(Object obj) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$processReceiveFinishMessage$1(Object obj) {
    }

    private void sendTransferCompleteMessage(String str) {
        ShareApi.Message build = ShareApi.Message.newBuilder().setType(ShareApi.StreamType.SENDER_FINISH).setTaskId(str).build();
        if (this.mSource.get(str) != null) {
            String str2 = this.taskToDeviceId.get(str);
            if (!TextUtils.isEmpty(str2)) {
                UupShare.getInstance().outputMessage(this.deviceMap.get(str2), build);
            }
            LogUtil.d(TAG, "send complete");
            TransferHandler transferHandler = this.handler;
            transferHandler.sendMessageDelayed(transferHandler.obtainMessage(4, str), 30000);
        }
    }

    public void attachObserver(StarryDevice starryDevice) {
        if (starryDevice != null) {
            this.deviceMap.put(starryDevice.getId(), starryDevice);
        }
    }

    public void detachObserver(StarryDevice starryDevice) {
        if (starryDevice != null) {
            this.deviceMap.remove(starryDevice.getId());
            Set<String> findKeysByValue = findKeysByValue(this.taskToDeviceId, starryDevice.getId());
            if (findKeysByValue != null && !findKeysByValue.isEmpty()) {
                for (String next : findKeysByValue) {
                    sendTransferCancelMessage(next);
                    onFailure(next, 1);
                }
            }
        }
    }

    public void disConnected() {
        LogUtil.d(TAG, "ble  disConnected");
        for (String next : this.mSource.keySet()) {
            sendTransferCancelMessage(next);
            onFailure(next, 1);
        }
    }

    public Set<String> findKeysByValue(Map<String, String> map, String str) {
        HashSet hashSet = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry next : map.entrySet()) {
            if (str.equals(next.getValue())) {
                if (hashSet == null) {
                    hashSet = new HashSet();
                }
                hashSet.add((String) next.getKey());
            }
        }
        return hashSet;
    }

    public void onFailure(String str, int i) {
        try {
            getmCallback(str, 2).onFailure(str, false, i);
            UupShare.getInstance().mService.removeTaskIdInPackageMaps(str);
            Bundle bundle = new Bundle();
            bundle.putInt(RtspHeaders.Values.MODE, 0);
            String str2 = this.taskToDeviceId.get(str);
            if (!TextUtils.isEmpty(str2)) {
                IAbilitySlot.SlotObserver slotObserver = UupShare.getInstance().getmSlotObserver(str2);
                if (slotObserver != null) {
                    slotObserver.commonFun(1, bundle, new a());
                }
                this.taskToDeviceId.remove(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processAckMessage(ShareApi.Message message) {
        LogUtil.d(TAG, "sender receive ack message");
        sendChunkData(message.getTaskId(), message.getBeginStart(), message.getChunkSize());
        if (this.handler.hasMessages(5)) {
            this.handler.removeMessages(5);
        }
    }

    public void processReceiveFinishMessage(ShareApi.Message message) {
        String taskId = message.getTaskId();
        BleFileInfo bleFileInfo = this.mSource.get(taskId);
        if (bleFileInfo != null) {
            if (this.handler.hasMessages(4)) {
                this.handler.removeMessages(4);
            }
            LogUtil.d(TAG, "processReceiveFinishMessage" + taskId);
            String str = bleFileInfo.getStorage() + File.separator + bleFileInfo.getInfo().getName();
            this.mSource.remove(taskId);
            this.mCanceledMap.remove(taskId);
            try {
                IHubUupShareStatusCallback iHubUupShareStatusCallback = getmCallback(taskId, 2);
                if (iHubUupShareStatusCallback != null) {
                    LogUtil.d(TAG, "onSuccess" + taskId);
                    iHubUupShareStatusCallback.onFinish(taskId, bleFileInfo.getInfo().getUri(), Uri.parse(str));
                    iHubUupShareStatusCallback.onSuccess(taskId);
                }
                UupShare.getInstance().mService.removeTaskIdInPackageMaps(taskId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Bundle bundle = new Bundle();
            bundle.putInt(RtspHeaders.Values.MODE, 0);
            String str2 = this.taskToDeviceId.get(taskId);
            if (!TextUtils.isEmpty(str2)) {
                IAbilitySlot.SlotObserver slotObserver = UupShare.getInstance().getmSlotObserver(str2);
                if (slotObserver != null) {
                    slotObserver.commonFun(1, bundle, new b());
                }
                this.taskToDeviceId.remove(taskId);
            }
        }
    }

    public void processReceiverCancelMessage(ShareApi.Message message) {
        String taskId = message.getTaskId();
        if (this.mSource.get(taskId) != null) {
            LogUtil.d(TAG, "ble  processSendCancelMessage");
            this.mSource.remove(taskId);
            this.mCanceledMap.remove(taskId);
            onFailure(taskId, 2);
        }
    }

    public void processReceiverFailMessage(ShareApi.Message message) {
        String taskId = message.getTaskId();
        if (this.mSource.get(taskId) != null) {
            LogUtil.d(TAG, "ble  processSendCancelMessage");
            this.mSource.remove(taskId);
            this.mCanceledMap.remove(taskId);
            onFailure(taskId, 0);
        }
    }

    public void sendChunkData(String str, long j, long j2) {
        String str2 = str;
        long j3 = j2;
        BleFileInfo bleFileInfo = this.mSource.get(str);
        if (bleFileInfo != null) {
            LogUtil.d(TAG, "send file chunk data");
            bleFileInfo.setChunkSize(j3);
            try {
                long size = bleFileInfo.getInfo().getSize();
                InputStream openInputStream = UupShareService.getContext().getContentResolver().openInputStream(bleFileInfo.getInfo().getUri());
                BufferedInputStream bufferedInputStream = new BufferedInputStream(openInputStream);
                if (!Boolean.TRUE.equals(this.mCanceledMap.getOrDefault(str, Boolean.FALSE))) {
                    getSlicesDataByNumber(bufferedInputStream, j, size < j3 ? (int) size : (int) j3, str, true, bleFileInfo, j2);
                    openInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendNextChunkData(String str, long j) {
        LogUtil.d(TAG, "send file next chunk data" + j);
        BleFileInfo bleFileInfo = this.mSource.get(str);
        if (bleFileInfo != null) {
            try {
                long chunkSize = bleFileInfo.getChunkSize();
                InputStream openInputStream = UupShareService.getContext().getContentResolver().openInputStream(bleFileInfo.getInfo().getUri());
                BufferedInputStream bufferedInputStream = new BufferedInputStream(openInputStream);
                long size = bleFileInfo.getInfo().getSize();
                if (!Boolean.TRUE.equals(this.mCanceledMap.getOrDefault(str, Boolean.FALSE))) {
                    if (j == size) {
                        sendTransferCompleteMessage(str);
                        return;
                    }
                    if (j + chunkSize < size) {
                        getSlicesDataByNumber(bufferedInputStream, j, (int) chunkSize, str, true, bleFileInfo, chunkSize);
                    } else {
                        getSlicesDataByNumber(bufferedInputStream, j, (int) (size - j), str, true, bleFileInfo, chunkSize);
                    }
                    openInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean sendSynMessage(String str, String str2) {
        BleFileInfo bleFileInfo = this.mSource.get(str);
        if (bleFileInfo == null) {
            return false;
        }
        this.taskToDeviceId.put(str, str2);
        LogUtil.d(TAG, "send syn message");
        ShareApi.Message build = ShareApi.Message.newBuilder().setType(ShareApi.StreamType.SENDER_SYN).setTotalSize(bleFileInfo.getInfo().getSize()).setMd5(bleFileInfo.getInfo().getMd5()).setFileName(bleFileInfo.getInfo().getName()).setDirPath(bleFileInfo.getStorage()).setPackageName(bleFileInfo.getPackageName()).setTaskId(str).build();
        try {
            getmCallback(str, 2).onStart(str, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        StarryDevice starryDevice = this.deviceMap.get(str2);
        if (starryDevice == null) {
            LogUtil.d(TAG, "the starryDevice is null ,must be something wrong");
            return false;
        }
        TransferHandler transferHandler = this.handler;
        transferHandler.sendMessageDelayed(transferHandler.obtainMessage(5, str), 30000);
        UupShare.getInstance().outputMessage(starryDevice, build);
        return true;
    }

    public void sendTransferCancelMessage(String str) {
        if (this.mSource.containsKey(str)) {
            synchronized (this.mLock) {
                this.mCanceledMap.put(str, Boolean.TRUE);
            }
            LogUtil.d(TAG, "cancel send file");
            ShareApi.Message build = ShareApi.Message.newBuilder().setType(ShareApi.StreamType.SENDER_CANCEL).setTaskId(str).build();
            String str2 = this.taskToDeviceId.get(str);
            if (!TextUtils.isEmpty(str2)) {
                UupShare.getInstance().outputMessage(this.deviceMap.get(str2), build);
            }
            this.taskToDeviceId.remove(str);
            this.mSource.remove(str);
        }
    }

    public void sendTransferFailMessage(String str) {
        ShareApi.Message build = ShareApi.Message.newBuilder().setType(ShareApi.StreamType.SENDER_FAIL).setTaskId(str).build();
        String str2 = this.taskToDeviceId.get(str);
        if (!TextUtils.isEmpty(str2)) {
            UupShare.getInstance().outputMessage(this.deviceMap.get(str2), build);
        }
    }

    public void setFiles(Bundle bundle) {
        LogUtil.d(TAG, "setFiles");
        String string = bundle.getString("taskId");
        Uri uri = (Uri) bundle.getParcelable("uri");
        String string2 = bundle.getString("dirPath");
        String string3 = bundle.getString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        FileInfo fileInfo = new FileInfo(string, uri, UupShareService.getContext());
        String mD5Three = Utils.getMD5Three(uri);
        BleFileInfo bleFileInfo = new BleFileInfo();
        bleFileInfo.setInfo(fileInfo);
        fileInfo.setMd5(mD5Three);
        bleFileInfo.setPackageName(string3);
        bleFileInfo.setStorage(string2);
        this.mSource.put(string, bleFileInfo);
    }

    private BleTransferSendDelegate() {
        this.mLock = new Object();
        this.taskToDeviceId = new HashMap();
    }
}
