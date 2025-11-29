package com.upuphone.runasone.share.lib;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.share.api.IHubUupShare;
import com.upuphone.runasone.share.api.IHubUupShareStatusCallback;
import com.upuphone.runasone.share.lib.bean.Constants;
import com.upuphone.runasone.share.lib.bean.StarryNetFiles;
import com.upuphone.runasone.share.lib.listener.IShareMessageListener;
import com.upuphone.runasone.share.lib.utils.LogUtil;
import com.upuphone.runasone.share.lib.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

public class UupShareService implements IHubUupShare {
    private static final int MSG_ACCEPT_DELAY_TIMEOUT = 1;
    private static final int MSG_BLE_CONNECT_TIMEOUT = 2;
    public static final int MSG_WEBSOCKET_CONNECT_TIMEOUT = 3;
    private static final String TAG = "UupShareService";
    public static final int TYPE_MUTUAL_TRANSFER = 1;
    public static final int TYPE_OTA = 2;
    private static Context mApp;
    private String dirPath;
    private final Object lock = new Object();
    IHubUupShareStatusCallback mCallback;
    private String mGoIpAddress;
    private int mGoPort;
    private boolean mIsGo = false;
    private Map<String, IHubUupShareStatusCallback> mReceiverCallbackmaps;
    private Map<String, IHubUupShareStatusCallback> mSenderCallbackmaps;
    private IShareMessageListener mShareMsgListener;
    private StarryNetFiles mStarryNetFiles;
    HashMap<String, String> mTaskIdPackageNameMap = new HashMap<>();
    private final AtomicBoolean mUserCancel = new AtomicBoolean(false);
    private int sendType = -1;

    public UupShareService(Context context, IShareMessageListener iShareMessageListener) {
        LogUtil.d(TAG, MzContactsContract.START_PARAM_KEY);
        mApp = context;
        this.mShareMsgListener = iShareMessageListener;
    }

    public static Context getContext() {
        return mApp;
    }

    public void bleDisconnect() {
        if (this.sendType != -1) {
            BleTransferSendDelegate.getInstance().disConnected();
        } else {
            BleTransferReceiverDelegate.getInstance().disConnected();
        }
    }

    public void cancel(String str, String str2) {
        synchronized (this.lock) {
            OtaTransferSendDelegate.getIntense().cancel(str2);
            BleTransferSendDelegate.getInstance().sendTransferCancelMessage(str2);
        }
    }

    public void cancelReceive(String str, String str2, String str3) {
        OtaTransferReceiverDelegate.getInstance().cancel(str2);
        BleTransferReceiverDelegate.getInstance().sendReceiverCancelMessage(str2);
    }

    public void confirmReceive(String str, String str2) {
        this.mShareMsgListener.startSendFile(str2);
        BleTransferReceiverDelegate.getInstance().confirmReceiver(str2);
    }

    public void disconnect(String str) {
        disconnect();
        try {
            if (this.mTaskIdPackageNameMap.get(str) != null) {
                this.mTaskIdPackageNameMap.remove(str);
            }
        } catch (Exception e) {
            LogUtil.d(TAG, "disconnect, e:" + e);
        }
    }

    public IHubUupShareStatusCallback getCallbackByTaskId(String str, @TransferMode int i) {
        LogUtil.d(TAG, "getCallbackByTaskId" + str);
        return (i == 2 ? this.mSenderCallbackmaps : this.mReceiverCallbackmaps).get(this.mTaskIdPackageNameMap.get(str));
    }

    public String getDirPath() {
        return this.dirPath;
    }

    public boolean isTransferring(String str) {
        if (this.mSenderCallbackmaps != null) {
            return OtaTransferSendDelegate.getIntense().isInSendMap(str);
        }
        if (this.mReceiverCallbackmaps != null) {
            return OtaTransferReceiverDelegate.getInstance().isTransferring(str);
        }
        return false;
    }

    public String pull(String str, Uri[] uriArr) {
        if (uriArr == null || uriArr.length == 0) {
            return null;
        }
        String randomString = Utils.getInstance().getRandomString();
        String[] strArr = new String[uriArr.length];
        int i = 0;
        for (Uri path : uriArr) {
            strArr[i] = path.getPath();
            i++;
        }
        String str2 = TextUtils.isEmpty(this.dirPath) ? Constants.FILE_SAVE_LOCATION : this.dirPath;
        Bundle bundle = new Bundle();
        bundle.putString("taskId", randomString);
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        bundle.putString("dirPath", str2);
        bundle.putStringArray("paths", strArr);
        putTaskIdPackageName(randomString, str);
        if (this.mShareMsgListener.sendMessageToShare(bundle)) {
            return randomString;
        }
        this.mCallback.onFailure(randomString, false, 7);
        return null;
    }

    public void putTaskIdPackageName(String str, String str2) {
        LogUtil.d(TAG, "putTaskIdPackageName" + str + ConstantKt.FACTOR_PARAMS_PACKAGE_NAME + str2);
        this.mTaskIdPackageNameMap.put(str, str2);
    }

    public boolean reTry(String str, Uri[] uriArr, String str2, String str3, String str4) {
        this.sendType = 2;
        OtaTransferSendDelegate.getIntense().setFiles(uriArr, str2);
        Bundle bundle = new Bundle();
        bundle.putString("taskId", str2);
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        bundle.putString("dirPath", TextUtils.isEmpty(this.dirPath) ? Constants.FILE_SAVE_LOCATION : this.dirPath);
        bundle.putString("extra", str4);
        putTaskIdPackageName(str2, str);
        if (this.mShareMsgListener.startShare(bundle)) {
            return true;
        }
        this.mCallback.onFailure(str2, false, 7);
        return false;
    }

    public void registerReceiveCallBack(String str, IHubUupShareStatusCallback iHubUupShareStatusCallback) {
        if (this.mReceiverCallbackmaps == null) {
            this.mReceiverCallbackmaps = new HashMap();
        }
        this.mReceiverCallbackmaps.put(str, iHubUupShareStatusCallback);
        LogUtil.d(TAG, "registerReceiveCallBack");
    }

    public void registerSendCallBack(String str, IHubUupShareStatusCallback iHubUupShareStatusCallback) {
        if (this.mSenderCallbackmaps == null) {
            this.mSenderCallbackmaps = new HashMap();
        }
        this.mSenderCallbackmaps.put(str, iHubUupShareStatusCallback);
        this.mCallback = iHubUupShareStatusCallback;
        LogUtil.d(TAG, "registerSendCallBack");
    }

    public void removeTaskIdInPackageMaps(String str) {
        LogUtil.d(TAG, "removeTaskIdInPackageMaps" + str);
        this.mTaskIdPackageNameMap.remove(str);
    }

    public String sendFile(String str, Uri[] uriArr, String str2, String str3) {
        LogUtil.d(TAG, "sendFile");
        String randomString = Utils.getInstance().getRandomString();
        LogUtil.d(TAG, "ip address:" + this.mGoIpAddress);
        if (TextUtils.isEmpty(this.mGoIpAddress)) {
            this.mGoIpAddress = "unkonw";
        }
        putTaskIdPackageName(randomString, str);
        this.sendType = 2;
        OtaTransferSendDelegate.getIntense().setFiles(uriArr, randomString);
        Bundle bundle = new Bundle();
        bundle.putString("taskId", randomString);
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        bundle.putString("dirPath", TextUtils.isEmpty(this.dirPath) ? Constants.FILE_SAVE_LOCATION : this.dirPath);
        bundle.putString("extra", str3);
        if (this.mShareMsgListener.startShare(bundle)) {
            return randomString;
        }
        this.mCallback.onFailure(randomString, false, 7);
        return null;
    }

    public String sendFileByBle(String str, Uri uri, String str2, String str3) {
        String randomString = Utils.getInstance().getRandomString();
        this.sendType = 2;
        Bundle bundle = new Bundle();
        bundle.putString("taskId", randomString);
        bundle.putString(ConstantKt.FACTOR_PARAMS_PACKAGE_NAME, str);
        bundle.putString("dirPath", TextUtils.isEmpty(this.dirPath) ? Constants.FILE_SAVE_LOCATION : this.dirPath);
        bundle.putParcelable("uri", uri);
        BleTransferSendDelegate.getInstance().setFiles(bundle);
        putTaskIdPackageName(randomString, str);
        if (!BleTransferSendDelegate.getInstance().sendSynMessage(randomString, str2)) {
            this.mCallback.onFailure(randomString, false, 7);
            return null;
        }
        UupShare.getInstance().changeDeviceBleMode(1, str2);
        return randomString;
    }

    public void setPath(String str, String str2) {
        LogUtil.d(TAG, "setPath");
        this.dirPath = str2;
    }

    public void unRegisterReceiveCallBack(String str) {
        Map<String, IHubUupShareStatusCallback> map = this.mReceiverCallbackmaps;
        if (map != null) {
            map.remove(str);
        }
        LogUtil.d(TAG, "unRegisterReceiveCallBack");
    }

    public void unRegisterSendCallBack(String str) {
        Map<String, IHubUupShareStatusCallback> map = this.mSenderCallbackmaps;
        if (map != null) {
            map.remove(str);
        }
        LogUtil.d(TAG, "unRegisterSendCallBack");
        this.mCallback = null;
    }

    public void disconnect() {
        if (this.sendType != -1) {
            OtaTransferSendDelegate.getIntense().disconnect();
        } else {
            OtaTransferReceiverDelegate.getInstance().disConnect();
        }
    }
}
