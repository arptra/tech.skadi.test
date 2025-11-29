package com.upuphone.runasone.share.lib;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.upuphone.runasone.share.lib.ShareApi;
import com.upuphone.runasone.share.lib.utils.LogUtil;

public class TransferHandler extends Handler {
    public static final String TAG = "TransferHandler";
    public static final int TIMEOUT = 30000;

    public TransferHandler() {
        super(Looper.getMainLooper());
    }

    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                LogUtil.d(TAG, "send time out");
                OtaTransferSendDelegate.getIntense().notifyTimeOut((String) message.obj);
                return;
            case 2:
                LogUtil.d(TAG, "time out close receiver server");
                OtaTransferReceiverDelegate.getInstance().close();
                return;
            case 3:
                LogUtil.d(TAG, "receiver time out close receiver server");
                OtaTransferReceiverDelegate.getInstance().notifyReceiverTimeOut((String) message.obj);
                return;
            case 4:
            case 5:
                LogUtil.d(TAG, "ble start send time out");
                BleTransferSendDelegate.getInstance().onFailure((String) message.obj, 3);
                return;
            case 6:
                LogUtil.i(TAG, "ble receiver ack time out");
                BleTransferReceiverDelegate.getInstance().processSendFailMessage(ShareApi.Message.newBuilder().setTaskId((String) message.obj).build());
                return;
            case 7:
                LogUtil.i(TAG, "send success time out");
                OtaTransferSendDelegate.getIntense().processSendSuccessTimeOut((String) message.obj);
                return;
            case 8:
                LogUtil.i(TAG, "receiver time out ;disconnect");
                OtaTransferReceiverDelegate.getInstance().disConnect();
                return;
            default:
                return;
        }
    }
}
