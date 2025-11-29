package com.upuphone.runasone.share.lib;

import android.net.Uri;
import android.text.TextUtils;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.share.api.IHubUupShareStatusCallback;
import com.upuphone.runasone.share.lib.ShareApi;
import com.upuphone.runasone.share.lib.bean.BleFileInfo;
import com.upuphone.runasone.share.lib.listener.BleTransfer;
import com.upuphone.runasone.share.lib.utils.LogUtil;
import com.upuphone.runasone.share.lib.utils.Utils;
import com.upuphone.starryshare.FileTransferDelegate;
import com.upuphone.starryshare.bean.FileInfo;
import java.io.File;

public final class BleTransferReceiverDelegate extends BleTransfer {
    public static final int SIZE_CHUNK_FILE = 4096;
    public static final String TAG = "BleTransferReceiverDelegate";

    public static final class SingleTon {
        public static final BleTransferReceiverDelegate BLE_DELEGATE = new BleTransferReceiverDelegate();

        private SingleTon() {
        }
    }

    private boolean checkFileIllegal(String str, String str2) {
        return Utils.getMD5Three(Uri.fromFile(new File(str))).equals(str2);
    }

    public static BleTransferReceiverDelegate getInstance() {
        return SingleTon.BLE_DELEGATE;
    }

    private String getPathByTaskId(String str) {
        BleFileInfo bleFileInfo = this.mSource.get(str);
        if (bleFileInfo == null) {
            return "";
        }
        String storage = bleFileInfo.getStorage();
        String name = bleFileInfo.getInfo().getName();
        return storage + File.separator + name;
    }

    private void notifyFailed(String str, int i) {
        try {
            IHubUupShareStatusCallback iHubUupShareStatusCallback = getmCallback(str, 1);
            if (iHubUupShareStatusCallback != null) {
                iHubUupShareStatusCallback.onFailure(str, false, i);
            }
            this.deviceMap.remove(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendReceiverCompleteMessage(String str) {
        LogUtil.d(TAG, "ble  sendReceiverCompleteMessage");
        ShareApi.Message build = ShareApi.Message.newBuilder().setType(ShareApi.StreamType.RECEIVER_FINISH).setTaskId(str).build();
        UupShare.getInstance().outputMessage(getDeviceByTaskId(str), build);
    }

    public void confirmReceiver(String str) {
        BleFileInfo bleFileInfo = this.mSource.get(str);
        if (bleFileInfo != null) {
            LogUtil.d(TAG, "ble receiver confirm");
            sendReceiverAckMessage(bleFileInfo.getStorage() + File.separator + bleFileInfo.getInfo().getMd5(), str);
        }
    }

    public void deleteFailFile() {
        LogUtil.d(TAG, "deleteFailFile");
        for (BleFileInfo next : this.mSource.values()) {
            String storage = TextUtils.isEmpty(next.getStorage()) ? FileTransferDelegate.f6549a : next.getStorage();
            File file = new File(storage + File.separator + next.getInfo().getMd5());
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public void disConnected() {
        for (String sendReceiverCancelMessage : this.mSource.keySet()) {
            sendReceiverCancelMessage(sendReceiverCancelMessage);
        }
    }

    public StarryDevice getDeviceByTaskId(String str) {
        return this.deviceMap.get(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0147 A[SYNTHETIC, Splitter:B:46:0x0147] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x014d A[SYNTHETIC, Splitter:B:49:0x014d] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processChunkData(com.upuphone.runasone.share.lib.ShareApi.Message r15) {
        /*
            r14 = this;
            com.upuphone.runasone.share.lib.TransferHandler r0 = r14.handler
            r1 = 6
            boolean r0 = r0.hasMessages(r1)
            if (r0 == 0) goto L_0x000e
            com.upuphone.runasone.share.lib.TransferHandler r0 = r14.handler
            r0.removeMessages(r1)
        L_0x000e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ble  processChunkData,start:"
            r0.append(r1)
            long r1 = r15.getChunkStart()
            r0.append(r1)
            java.lang.String r1 = "end:"
            r0.append(r1)
            long r1 = r15.getChunkEnd()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "BleTransferReceiverDelegate"
            com.upuphone.runasone.share.lib.utils.LogUtil.d(r1, r0)
            java.lang.String r0 = r15.getTaskId()
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            java.util.Map<java.lang.String, java.lang.Boolean> r3 = r14.mCanceledMap
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            java.lang.Object r3 = r3.getOrDefault(r0, r4)
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004e
            java.lang.String r14 = "receiver is canceled"
            com.upuphone.runasone.share.lib.utils.LogUtil.d(r1, r14)
            return
        L_0x004e:
            java.util.Map<java.lang.String, com.upuphone.runasone.share.lib.bean.BleFileInfo> r2 = r14.mSource
            java.lang.Object r2 = r2.get(r0)
            com.upuphone.runasone.share.lib.bean.BleFileInfo r2 = (com.upuphone.runasone.share.lib.bean.BleFileInfo) r2
            if (r2 != 0) goto L_0x0059
            return
        L_0x0059:
            com.upuphone.starryshare.bean.FileInfo r3 = r2.getInfo()
            long r3 = r3.getSize()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r2.getStorage()
            r5.append(r6)
            java.lang.String r6 = java.io.File.separator
            r5.append(r6)
            com.upuphone.starryshare.bean.FileInfo r2 = r2.getInfo()
            java.lang.String r2 = r2.getMd5()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.io.File r5 = new java.io.File
            r5.<init>(r2)
            long r6 = r15.getChunkStart()
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 != 0) goto L_0x0099
            boolean r6 = r5.exists()
            if (r6 == 0) goto L_0x0099
            r5.delete()
        L_0x0099:
            boolean r6 = r5.exists()
            if (r6 != 0) goto L_0x00a7
            r5.createNewFile()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00a7
        L_0x00a3:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00a7:
            r5 = 1
            r6 = 0
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0121 }
            java.lang.String r10 = "rw"
            r7.<init>(r2, r10)     // Catch:{ Exception -> 0x0121 }
            long r10 = r7.length()     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            long r12 = r15.getChunkStart()     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            int r6 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r6 != 0) goto L_0x00c7
            r7.seek(r8)     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            goto L_0x00ca
        L_0x00c0:
            r14 = move-exception
            r6 = r7
            goto L_0x014b
        L_0x00c4:
            r15 = move-exception
            r6 = r7
            goto L_0x0122
        L_0x00c7:
            r7.seek(r10)     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
        L_0x00ca:
            com.google.protobuf.ByteString r6 = r15.getChunkData()     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            byte[] r6 = r6.toByteArray()     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            r7.write(r6)     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            r10.<init>()     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            java.lang.String r11 = "write "
            r10.append(r11)     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            long r11 = r11 - r8
            r10.append(r11)     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            java.lang.String r8 = r10.toString()     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            com.upuphone.runasone.share.lib.utils.LogUtil.d(r1, r8)     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            long r8 = r7.length()     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            r10 = 100
            long r8 = r8 * r10
            long r8 = r8 / r3
            int r1 = (int) r8     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            com.upuphone.runasone.share.api.IHubUupShareStatusCallback r3 = r14.getmCallback(r0, r5)     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            if (r3 == 0) goto L_0x0109
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            r3.onProgressChanged(r0, r1, r2)     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
        L_0x0109:
            r7.close()     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            long r1 = r15.getChunkStart()     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            int r15 = r6.length     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            long r3 = (long) r15     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            long r1 = r1 + r3
            r14.sendReceiverDataAckMessage(r0, r1)     // Catch:{ Exception -> 0x00c4, all -> 0x00c0 }
            r7.close()     // Catch:{ IOException -> 0x011a }
            goto L_0x014a
        L_0x011a:
            r14 = move-exception
            r14.printStackTrace()
            goto L_0x014a
        L_0x011f:
            r14 = move-exception
            goto L_0x014b
        L_0x0121:
            r15 = move-exception
        L_0x0122:
            r15.printStackTrace()     // Catch:{ all -> 0x011f }
            com.upuphone.runasone.share.lib.ShareApi$Message$Builder r15 = com.upuphone.runasone.share.lib.ShareApi.Message.newBuilder()     // Catch:{ all -> 0x011f }
            com.upuphone.runasone.share.lib.ShareApi$StreamType r1 = com.upuphone.runasone.share.lib.ShareApi.StreamType.RECEIVER_FAIL     // Catch:{ all -> 0x011f }
            com.upuphone.runasone.share.lib.ShareApi$Message$Builder r15 = r15.setType(r1)     // Catch:{ all -> 0x011f }
            com.upuphone.runasone.share.lib.ShareApi$Message$Builder r15 = r15.setTaskId(r0)     // Catch:{ all -> 0x011f }
            com.upuphone.runasone.share.lib.ShareApi$Message r15 = r15.build()     // Catch:{ all -> 0x011f }
            com.upuphone.runasone.device.StarryDevice r1 = r14.getDeviceByTaskId(r0)     // Catch:{ all -> 0x011f }
            com.upuphone.runasone.share.lib.UupShare r2 = com.upuphone.runasone.share.lib.UupShare.getInstance()     // Catch:{ all -> 0x011f }
            r2.outputMessage(r1, r15)     // Catch:{ all -> 0x011f }
            r14.notifyFailed(r0, r5)     // Catch:{ all -> 0x011f }
            if (r6 == 0) goto L_0x014a
            r6.close()     // Catch:{ IOException -> 0x011a }
        L_0x014a:
            return
        L_0x014b:
            if (r6 == 0) goto L_0x0155
            r6.close()     // Catch:{ IOException -> 0x0151 }
            goto L_0x0155
        L_0x0151:
            r15 = move-exception
            r15.printStackTrace()
        L_0x0155:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.runasone.share.lib.BleTransferReceiverDelegate.processChunkData(com.upuphone.runasone.share.lib.ShareApi$Message):void");
    }

    public void processCompleteMessage(ShareApi.Message message) {
        String taskId = message.getTaskId();
        BleFileInfo bleFileInfo = this.mSource.get(taskId);
        if (bleFileInfo != null) {
            String storage = bleFileInfo.getStorage();
            String name = bleFileInfo.getInfo().getName();
            StringBuilder sb = new StringBuilder();
            sb.append(storage);
            String str = File.separator;
            sb.append(str);
            sb.append(name);
            String sb2 = sb.toString();
            new File(bleFileInfo.getStorage() + str + bleFileInfo.getInfo().getMd5()).renameTo(new File(sb2));
            this.mSource.remove(taskId);
            this.mCanceledMap.remove(taskId);
            if (!checkFileIllegal(sb2, bleFileInfo.getInfo().getMd5())) {
                ShareApi.Message build = ShareApi.Message.newBuilder().setType(ShareApi.StreamType.RECEIVER_FAIL).setTaskId(taskId).build();
                UupShare.getInstance().outputMessage(getDeviceByTaskId(taskId), build);
                notifyFailed(taskId, 0);
                deleteFailFile();
                return;
            }
            try {
                sendReceiverCompleteMessage(taskId);
                IHubUupShareStatusCallback iHubUupShareStatusCallback = getmCallback(taskId, 1);
                if (iHubUupShareStatusCallback != null) {
                    iHubUupShareStatusCallback.onFinish(taskId, (Uri) null, Uri.parse(sb2));
                    iHubUupShareStatusCallback.onSuccess(taskId);
                }
                this.mSource.remove(taskId);
                this.mCanceledMap.remove(taskId);
                this.deviceMap.remove(taskId);
                UupShare.getInstance().mService.removeTaskIdInPackageMaps(taskId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void processSendCancelMessage(ShareApi.Message message) {
        String taskId = message.getTaskId();
        if (this.mSource.get(taskId) != null) {
            LogUtil.d(TAG, "ble  processSendCancelMessage");
            this.mSource.remove(taskId);
            this.mCanceledMap.remove(taskId);
            UupShare.getInstance().mService.removeTaskIdInPackageMaps(taskId);
            notifyFailed(taskId, 2);
            deleteFailFile();
        }
    }

    public void processSendFailMessage(ShareApi.Message message) {
        String taskId = message.getTaskId();
        if (this.mSource.get(taskId) != null) {
            this.mSource.remove(taskId);
            this.mCanceledMap.remove(taskId);
            UupShare.getInstance().mService.removeTaskIdInPackageMaps(taskId);
            notifyFailed(taskId, 0);
        }
    }

    public void processSynMessage(ShareApi.Message message, StarryDevice starryDevice) {
        LogUtil.d(TAG, "receiver process syn message");
        String md5 = message.getMd5();
        long totalSize = message.getTotalSize();
        message.getChunkSize();
        String taskId = message.getTaskId();
        String dirPath = message.getDirPath();
        String fileName = message.getFileName();
        String packageName = message.getPackageName();
        BleFileInfo bleFileInfo = new BleFileInfo();
        FileInfo fileInfo = new FileInfo();
        fileInfo.setSize(totalSize);
        fileInfo.setMd5(md5);
        fileInfo.setName(fileName);
        fileInfo.setTaskId(taskId);
        bleFileInfo.setInfo(fileInfo);
        bleFileInfo.setPackageName(packageName);
        bleFileInfo.setStorage(dirPath);
        this.mSource.put(taskId, bleFileInfo);
        try {
            UupShare.getInstance().mService.putTaskIdPackageName(taskId, packageName);
            IHubUupShareStatusCallback iHubUupShareStatusCallback = getmCallback(taskId, 1);
            if (iHubUupShareStatusCallback != null) {
                iHubUupShareStatusCallback.onStart(taskId, "");
                this.deviceMap.put(taskId, starryDevice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendReceiverAckMessage(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            new File(str);
            ShareApi.Message build = ShareApi.Message.newBuilder().setType(ShareApi.StreamType.RECEIVER_ACK).setChunkSize(4096).setBeginStart(0).setTaskId(str2).build();
            UupShare.getInstance().outputMessage(getDeviceByTaskId(str2), build);
            TransferHandler transferHandler = this.handler;
            transferHandler.sendMessageDelayed(transferHandler.obtainMessage(6, str2), 30000);
        }
    }

    public void sendReceiverCancelMessage(String str) {
        if (this.mSource.containsKey(str)) {
            this.mCanceledMap.put(str, Boolean.TRUE);
            LogUtil.d(TAG, "ble  receiver cancel");
            ShareApi.Message build = ShareApi.Message.newBuilder().setType(ShareApi.StreamType.RECEIVER_CANCEL).setTaskId(str).build();
            UupShare.getInstance().outputMessage(getDeviceByTaskId(str), build);
            deleteFailFile();
        }
    }

    public void sendReceiverDataAckMessage(String str, long j) {
        LogUtil.d(TAG, "ble  sendReceiverDataAckMessage");
        ShareApi.Message build = ShareApi.Message.newBuilder().setType(ShareApi.StreamType.RECEIVER_DATA_ACK).setTaskId(str).setChunkEnd(j).build();
        UupShare.getInstance().outputMessage(getDeviceByTaskId(str), build);
    }

    private BleTransferReceiverDelegate() {
    }
}
