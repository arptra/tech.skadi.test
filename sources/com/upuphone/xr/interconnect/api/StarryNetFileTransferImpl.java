package com.upuphone.xr.interconnect.api;

import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.honey.account.s7.m;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynetsdk.ability.share.ShareAbility;
import com.upuphone.starrynetsdk.ability.share.ShareListener;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IFileSendListener;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.StarryNetFile;
import com.upuphone.xr.interconnect.entity.StarryNetFileInfo;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.P2pAcquireCallback;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import com.upuphone.xr.interconnect.main.StarryNetMessageFactory;
import com.upuphone.xr.interconnect.main.handler.MessageHandler;
import com.upuphone.xr.interconnect.util.ExceptionLogUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class StarryNetFileTransferImpl implements StarryNetFileTransfer, ShareListener {
    private static final String TAG = "StarryNetFileTransferImpl";
    private final FileTransportMessageHandler mFileTransportMessageHandler = new FileTransportMessageHandler();
    private final List<SendFileTask> mSendFileTaskList = new CopyOnWriteArrayList();
    private ShareAbility mShareAbilityCache;
    /* access modifiers changed from: private */
    public final Map<String, StarryNetFile> mStringStarryNetFileMap = new HashMap();

    public final class FileTransportMessageHandler implements MessageHandler {
        public int getHandleType() {
            return 0;
        }

        public void handle(StarryNetMessage starryNetMessage, Function function) {
            StarryNetFile starryNetFile = (StarryNetFile) function.parseData(StarryNetFile.class);
            String id = starryNetFile.getId();
            if (StarryNetFileTransferImpl.this.mStringStarryNetFileMap.containsKey(id)) {
                ILog.d(StarryNetFileTransferImpl.TAG, "已收到文件传输的start回调，自动确认接收文件");
                StarryNetFileTransferImpl.this.autoConfirmReceive(starryNetFile);
            }
            StarryNetFileTransferImpl.this.mStringStarryNetFileMap.put(id, starryNetFile);
        }

        private FileTransportMessageHandler() {
        }
    }

    public final class SendFileTask extends P2pAcquireCallback implements ShareListener {
        private StarryNetFile mFile;
        private IFileSendListener mFileSendListener;
        private String mSendFileTaskId;

        private void unregister() {
            ShareAbility d = StarryNetFileTransferImpl.this.getShareAbility();
            if (d != null) {
                int unregisterSendListener = d.unregisterSendListener(this);
                ILog.d(StarryNetFileTransferImpl.TAG, "解注册发送文件监听" + this + "返回code--" + unregisterSendListener);
            }
        }

        public void onError(String str, int i) {
            String str2 = this.mSendFileTaskId;
            if (str2 != null && str2.equals(str)) {
                ILog.d(StarryNetFileTransferImpl.TAG, this + "收到发送文件onError回调taskId--" + str);
                try {
                    this.mFileSendListener.onFail(str, i);
                } catch (RemoteException e) {
                    ExceptionLogUtil.print(StarryNetFileTransferImpl.TAG, e, "IFileSendListener", "onFail");
                }
                unregister();
            }
        }

        public void onFail(int i) throws RemoteException {
            StarryNetFileTransferImpl.this.sendFileFail(this.mFileSendListener, (String) null, -4);
            StarryNetFileTransferImpl.this.removeTask(this);
        }

        public void onFinish(String str) {
            String str2 = this.mSendFileTaskId;
            if (str2 != null && str2.equals(str)) {
                ILog.d(StarryNetFileTransferImpl.TAG, this + "收到发送文件onFinish回调taskId--" + str);
                StarryNetFileTransferImpl.this.removeTask(this);
                unregister();
            }
        }

        public void onProgress(String str, Uri uri, int i) {
            String str2 = this.mSendFileTaskId;
            if (str2 != null && str2.equals(str)) {
                ILog.d(StarryNetFileTransferImpl.TAG, this + "收到发送文件onProgress回调taskId--" + str + "，进度--" + i);
                try {
                    this.mFileSendListener.onProgressChanged(str, i);
                } catch (RemoteException e) {
                    ExceptionLogUtil.print(StarryNetFileTransferImpl.TAG, e, "IFileSendListener", "onProgressChanged");
                }
            }
        }

        public void onStart(String str) {
            String str2 = this.mSendFileTaskId;
            if (str2 != null && str2.equals(str)) {
                ILog.d(StarryNetFileTransferImpl.TAG, this + "收到发送文件onStart回调taskId--" + str);
                try {
                    this.mFileSendListener.onStart(str);
                } catch (RemoteException e) {
                    ExceptionLogUtil.print(StarryNetFileTransferImpl.TAG, e, "IFileSendListener", "onStart");
                }
            }
        }

        public void onSuccess() throws RemoteException {
            ShareAbility d = StarryNetFileTransferImpl.this.getShareAbility();
            if (d == null) {
                StarryNetFileTransferImpl.this.sendFileFail(this.mFileSendListener, (String) null, -5);
                StarryNetFileTransferImpl.this.removeTask(this);
                return;
            }
            ILog.d(StarryNetFileTransferImpl.TAG, "执行发送文件操作");
            ArrayList arrayList = new ArrayList();
            for (StarryNetFileInfo fileUri : this.mFile.getLstFiles()) {
                arrayList.add(fileUri.getFileUri());
            }
            Uri[] uriArr = new Uri[arrayList.size()];
            arrayList.toArray(uriArr);
            String savePath = this.mFile.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                savePath = "";
            }
            StarryDevice connectedDevice = InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDevice();
            int registerSendListener = d.registerSendListener(this);
            ILog.d(StarryNetFileTransferImpl.TAG, "注册发送文件监听" + this + "返回code--" + registerSendListener);
            String send = d.send(connectedDevice.getId(), uriArr, savePath);
            StringBuilder sb = new StringBuilder();
            sb.append("调用ShareAbility发送文件返回code--");
            sb.append(send);
            ILog.d(StarryNetFileTransferImpl.TAG, sb.toString());
            if (send == null) {
                StarryNetFileTransferImpl.this.sendFileFail(this.mFileSendListener, (String) null, -6);
                StarryNetFileTransferImpl.this.removeTask(this);
                return;
            }
            this.mSendFileTaskId = send;
            StarryNetFile starryNetFile = new StarryNetFile();
            starryNetFile.setId(this.mSendFileTaskId);
            starryNetFile.setSenderPkg(this.mFile.getSenderPkg());
            starryNetFile.setReceiverPkg(this.mFile.getReceiverPkg());
            starryNetFile.setLstFiles(this.mFile.getLstFiles());
            InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(StarryNetMessageFactory.createFunctionMessage(new Function(0, starryNetFile)), (IMessageSendListener) null);
        }

        public void onTimeout() throws RemoteException {
            StarryNetFileTransferImpl.this.sendFileFail(this.mFileSendListener, (String) null, -3);
            StarryNetFileTransferImpl.this.removeTask(this);
        }

        private SendFileTask(StarryNetFile starryNetFile, IFileSendListener iFileSendListener) {
            this.mSendFileTaskId = null;
            this.mFile = starryNetFile;
            this.mFileSendListener = iFileSendListener;
        }

        public void onSuccess(String str, Uri uri, Uri uri2) {
            String str2 = this.mSendFileTaskId;
            if (str2 != null && str2.equals(str)) {
                ILog.d(StarryNetFileTransferImpl.TAG, this + "收到发送文件onSuccess回调taskId--" + str);
                try {
                    this.mFileSendListener.onProgressChanged(str, 100);
                    this.mFileSendListener.onFinish(str, uri2.toString());
                } catch (RemoteException e) {
                    ExceptionLogUtil.print(StarryNetFileTransferImpl.TAG, e, "IFileSendListener", "onFinish");
                }
            }
        }
    }

    public StarryNetFileTransferImpl() {
        StarryNetAbilityManager.getInstance().registerOnStarryAbilityStateListener(new m(this));
    }

    /* access modifiers changed from: private */
    public void autoConfirmReceive(StarryNetFile starryNetFile) {
        try {
            ShareAbility shareAbility = getShareAbility();
            if (shareAbility != null) {
                int confirm = shareAbility.confirm(starryNetFile.getId());
                ILog.d(TAG, "ShareAbility confirm返回code--" + confirm);
                if (confirm == 0) {
                    InterconnectManager.getInstance().getMainDispatcher().dispatchStartEvent(starryNetFile.getReceiverPkg(), starryNetFile.getId(), starryNetFile);
                }
            }
        } catch (Exception e) {
            ILog.e(TAG, "自动确认接收文件出错", e);
        }
    }

    /* access modifiers changed from: private */
    public ShareAbility getShareAbility() {
        return StarryNetAbilityManager.getInstance().getShareAbility();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(boolean z) {
        if (z) {
            ShareAbility shareAbility = getShareAbility();
            int registerReceiveListener = shareAbility.registerReceiveListener(this);
            ILog.d(TAG, "注册互联文件流转监听，返回code--" + registerReceiveListener);
            this.mShareAbilityCache = shareAbility;
            return;
        }
        ShareAbility shareAbility2 = this.mShareAbilityCache;
        if (shareAbility2 != null) {
            int unregisterReceiveListener = shareAbility2.unregisterReceiveListener(this);
            ILog.d(TAG, "解注册互联文件流转监听，返回code--" + unregisterReceiveListener);
            this.mShareAbilityCache = null;
        }
    }

    /* access modifiers changed from: private */
    public void removeTask(SendFileTask sendFileTask) {
        this.mSendFileTaskList.remove(sendFileTask);
        if (this.mSendFileTaskList.isEmpty()) {
            InterconnectManager.getInstance().getStarryNetDeviceManager().tryReleaseP2p(TAG);
        }
    }

    /* access modifiers changed from: private */
    public void sendFileFail(IFileSendListener iFileSendListener, String str, int i) {
        if (iFileSendListener != null) {
            if (str == null) {
                try {
                    str = UUID.randomUUID().toString();
                    iFileSendListener.onStart(str);
                } catch (RemoteException e) {
                    ExceptionLogUtil.print(TAG, e, "IFileSendListener", "onStart|onFail");
                    return;
                }
            }
            iFileSendListener.onFail(str, i);
        }
    }

    public void cancel(String str) {
        ShareAbility shareAbility;
        if (InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDevice() != null && (shareAbility = getShareAbility()) != null) {
            shareAbility.cancel(str, 1);
        }
    }

    public FileTransportMessageHandler getFileTransportMessageHandler() {
        return this.mFileTransportMessageHandler;
    }

    public void onError(String str, int i) {
        StarryNetFile remove = this.mStringStarryNetFileMap.remove(str);
        if (remove != null) {
            ILog.d(TAG, "收到文件传输onError回调，taskId--" + str + "，code--" + i);
            InterconnectManager.getInstance().getMainDispatcher().dispatchFailEvent(remove.getReceiverPkg(), str, i);
        }
    }

    public void onFinish(String str) {
        if (this.mStringStarryNetFileMap.get(str) != null) {
            ILog.d(TAG, "收到文件传输onFinish回调，taskId--" + str);
        }
    }

    public void onProgress(String str, Uri uri, int i) {
        StarryNetFile starryNetFile = this.mStringStarryNetFileMap.get(str);
        if (starryNetFile != null) {
            ILog.d(TAG, "收到文件传输onProgress回调，taskId--" + str + "，uri--" + uri + "，progress--" + i);
            InterconnectManager.getInstance().getMainDispatcher().dispatchProgressChangedEvent(starryNetFile.getReceiverPkg(), str, i);
        }
    }

    public void onStart(String str) {
        ILog.d(TAG, "收到文件传输onStart回调，taskId--" + str);
        StarryNetFile starryNetFile = this.mStringStarryNetFileMap.get(str);
        if (starryNetFile != null) {
            ILog.d(TAG, "已收到远端文件传输的开始消息，自动确认接收文件");
            autoConfirmReceive(starryNetFile);
            return;
        }
        this.mStringStarryNetFileMap.put(str, (Object) null);
    }

    public void onSuccess(String str, Uri uri, Uri uri2) {
        StarryNetFile remove = this.mStringStarryNetFileMap.remove(str);
        if (remove != null) {
            ILog.d(TAG, "收到文件传输onSuccess回调，taskId--" + str + "，sendUri--" + uri + "，receiveUri--" + uri2);
            InterconnectManager.getInstance().getMainDispatcher().dispatchProgressChangedEvent(remove.getReceiverPkg(), str, 100);
            InterconnectManager.getInstance().getMainDispatcher().dispatchSuccessEvent(remove.getReceiverPkg(), str, uri2.toString());
        }
    }

    public void sendFile(StarryNetFile starryNetFile, IFileSendListener iFileSendListener) {
        List<StarryNetFileInfo> lstFiles = starryNetFile.getLstFiles();
        if (lstFiles == null || lstFiles.isEmpty()) {
            sendFileFail(iFileSendListener, (String) null, -2);
        } else if (InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDevice() == null) {
            sendFileFail(iFileSendListener, (String) null, -1);
        } else {
            SendFileTask sendFileTask = new SendFileTask(starryNetFile, iFileSendListener);
            this.mSendFileTaskList.add(sendFileTask);
            InterconnectManager.getInstance().getStarryNetDeviceManager().tryAcquireP2p(TAG, sendFileTask);
        }
    }
}
