package com.upuphone.starrynetsdk.ability.share;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.share.api.IHubUupShareProxy;
import com.upuphone.starrynetsdk.api.Ability;
import com.upuphone.starrynetsdk.api.Camp;
import com.upuphone.starrynetsdk.api.ErrorCode;
import com.upuphone.starrynetsdk.api.SNSLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public final class ShareAbility extends Ability {
    private static final String TAG = "ShareAbility";
    public static final int TYPE_CANCEL_FETCH = 2;
    public static final int TYPE_CANCEL_RECEIVE = 3;
    public static final int TYPE_CANCEL_SEND = 1;
    private final IHubUupShareProxy api = new IHubUupShareProxy();
    private final ShareListenerManager listenerManager;
    private final String packageName;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CancelType {
    }

    public ShareAbility(Context context) {
        ShareListenerManager instance = ShareListenerManager.getInstance();
        this.listenerManager = instance;
        String appUnitPackageName = getAppUnitPackageName(context);
        this.packageName = appUnitPackageName;
        instance.init(appUnitPackageName);
        Camp.getInstance().addSentry(this);
    }

    private String getAppUnitPackageName(Context context) {
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("share_unit_code");
            return TextUtils.isEmpty(string) ? context.getPackageName() : string;
        } catch (Exception e) {
            e.printStackTrace();
            return context.getPackageName();
        }
    }

    public String bleSend(String str, Uri uri, String str2) {
        SNSLog.d(TAG, "bleSend file: " + uri.toString());
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , bleSend failed.");
            return null;
        }
        try {
            this.api.setPath(this.packageName, str2);
            return this.api.sendFileByBle(this.packageName, uri, str, "");
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "bleSend failed.", e);
            return null;
        }
    }

    public int cancel(String str, int i) {
        SNSLog.d(TAG, "cancel: " + str + " >>> " + i);
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , cancel failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } else if (i == 1) {
            try {
                this.api.cancel(this.packageName, str);
                return 0;
            } catch (HubRemoteException e) {
                SNSLog.e(TAG, "cancel task failed.", e);
                return ErrorCode.CODE_SERVICE_UNAVAILABLE;
            } catch (HubTargetException e2) {
                SNSLog.e(TAG, "cancel task failed.", e2);
                return ErrorCode.CODE_TARGET_UNAVAILABLE;
            }
        } else {
            this.api.cancelReceive(this.packageName, str, "");
            return 0;
        }
    }

    public int confirm(String str) {
        SNSLog.d(TAG, "confirm: " + str);
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , confirm failed.");
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        }
        try {
            this.api.confirmReceive(this.packageName, str);
            return 0;
        } catch (HubRemoteException e) {
            SNSLog.e(TAG, "confirm task failed.", e);
            return ErrorCode.CODE_SERVICE_UNAVAILABLE;
        } catch (HubTargetException e2) {
            SNSLog.e(TAG, "confirm task failed.", e2);
            return ErrorCode.CODE_TARGET_UNAVAILABLE;
        }
    }

    public String fetch(String str, Uri[] uriArr, String str2) {
        SNSLog.d(TAG, "fetch file: " + Arrays.toString(uriArr));
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , fetch failed.");
            return null;
        }
        try {
            this.api.setPath(this.packageName, str2);
            return this.api.pull(this.packageName, uriArr);
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "fetch failed.", e);
            return null;
        }
    }

    public boolean isTransferring(String str) {
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable ,failed.");
            return false;
        }
        boolean isTransferring = this.api.isTransferring(str);
        SNSLog.d(TAG, "isTransferring;taskId: " + str + "isTranslating:" + isTransferring);
        return isTransferring;
    }

    public void onInstalled(Hub hub) {
        super.onInstalled(hub);
        this.api.setHub(hub);
    }

    public int registerReceiveListener(ShareListener shareListener) {
        SNSLog.d(TAG, "registerReceiveListener");
        this.listenerManager.registerReceiveListener(shareListener);
        return 0;
    }

    public int registerSendListener(ShareListener shareListener) {
        SNSLog.d(TAG, "registerSendListener");
        this.listenerManager.registerSendListener(shareListener);
        return 0;
    }

    public boolean retry(String str, Uri[] uriArr, String str2) {
        SNSLog.d(TAG, "retry: " + str2);
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , retry failed.");
            return false;
        }
        try {
            return this.api.reTry(this.packageName, uriArr, str2, str, "");
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "retry task failed.", e);
            return false;
        }
    }

    public String send(String str, Uri[] uriArr, String str2) {
        SNSLog.d(TAG, "send file: " + Arrays.toString(uriArr));
        if (!isEnable()) {
            SNSLog.e(TAG, "Service unavailable , send failed.");
            return null;
        }
        try {
            this.api.setPath(this.packageName, str2);
            return this.api.sendFile(this.packageName, uriArr, str, "");
        } catch (HubRemoteException | HubTargetException e) {
            SNSLog.e(TAG, "send failed.", e);
            return null;
        }
    }

    public int unregisterReceiveListener(ShareListener shareListener) {
        SNSLog.d(TAG, "unregisterReceiveListener");
        this.listenerManager.unregisterReceiveListener(shareListener);
        return 0;
    }

    public int unregisterSendListener(ShareListener shareListener) {
        SNSLog.d(TAG, "unregisterSendListener");
        this.listenerManager.unregisterSendListener(shareListener);
        return 0;
    }
}
