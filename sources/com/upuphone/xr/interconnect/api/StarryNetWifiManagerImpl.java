package com.upuphone.xr.interconnect.api;

import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.common.IWifiConnectCallback;
import com.upuphone.xr.interconnect.common.IWifiInfoCallback;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.entity.StarryNetWifiInfo;
import com.upuphone.xr.interconnect.main.StarryNetMessageFactory;
import com.upuphone.xr.interconnect.main.handler.MessageHandler;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class StarryNetWifiManagerImpl implements StarryNetWifiManager {
    private static final int MSG_TIMEOUT_CONNECT_WIFI = 101;
    private static final int MSG_TIMEOUT_GET_WIFI_INFO = 100;
    private static final String TAG = "StarryNetWifiManagerImpl";
    private static final long TIMEOUT_DURATION = 10000;
    private final MessageHandler mConnectWifiResponseHandler = new MessageHandler() {
        public int getHandleType() {
            return 10;
        }

        public void handle(StarryNetMessage starryNetMessage, Function function) {
            StarryNetWifiManagerImpl.this.onReceiveConnectResult(StarryNetWifiManagerImpl.this.getWifiConnectResultCode((String) function.parseData(String.class)));
        }
    };
    /* access modifiers changed from: private */
    public boolean mIsConnectingWifi;
    /* access modifiers changed from: private */
    public boolean mIsGetWifiInfo;
    private final List<IWifiInfoCallback> mPendingCallbacks = new ArrayList();
    private final WifiManagerResponder mResponder = new WifiManagerResponder();
    private final Handler mTimeoutHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i == 100) {
                if (StarryNetWifiManagerImpl.this.mIsGetWifiInfo) {
                    StarryNetWifiManagerImpl.this.onReceiveWifiInfo((StarryNetWifiInfo) null);
                }
            } else if (i == 101 && StarryNetWifiManagerImpl.this.mIsConnectingWifi) {
                StarryNetWifiManagerImpl.this.onReceiveConnectResult(2);
            }
        }
    };
    private IWifiConnectCallback mWifiConnectCallback;
    private final MessageHandler mWifiInfoResponseHandler = new MessageHandler() {
        public int getHandleType() {
            return 8;
        }

        public void handle(StarryNetMessage starryNetMessage, Function function) {
            ULog.i(StarryNetWifiManagerImpl.TAG, "receive wifi info");
            StarryNetWifiManagerImpl.this.mIsGetWifiInfo = false;
            StarryNetWifiManagerImpl.this.onReceiveWifiInfo((StarryNetWifiInfo) function.parseData(StarryNetWifiInfo.class));
        }
    };

    private void cleanConnectWifiTimeout() {
        this.mTimeoutHandler.removeMessages(101);
    }

    private void cleanGetWifiInfoTimeout() {
        this.mTimeoutHandler.removeMessages(100);
    }

    /* access modifiers changed from: private */
    public int getWifiConnectResultCode(String str) {
        try {
            return new JSONObject(str).getInt("RESULT_CODE");
        } catch (Exception e) {
            ILog.w(TAG, "Connect result json construction threw: " + e.getLocalizedMessage() + "!");
            return 4;
        }
    }

    /* access modifiers changed from: private */
    public void onReceiveConnectResult(int i) {
        this.mIsConnectingWifi = false;
        cleanConnectWifiTimeout();
        IWifiConnectCallback iWifiConnectCallback = this.mWifiConnectCallback;
        if (iWifiConnectCallback != null) {
            try {
                iWifiConnectCallback.onResult(i);
            } catch (Exception e) {
                ILog.w(TAG, "Remote code result call threw: " + e.getLocalizedMessage() + "!");
            }
        }
        this.mWifiConnectCallback = null;
    }

    /* access modifiers changed from: private */
    public void onReceiveWifiInfo(StarryNetWifiInfo starryNetWifiInfo) {
        this.mIsGetWifiInfo = false;
        cleanGetWifiInfoTimeout();
        for (IWifiInfoCallback onResult : this.mPendingCallbacks) {
            try {
                onResult.onResult(starryNetWifiInfo);
            } catch (Exception e) {
                ILog.w(TAG, "Remote info result call threw: " + e.getLocalizedMessage() + "!");
            }
        }
        this.mPendingCallbacks.clear();
    }

    private void requestWifiInfo() {
        StarryNetMessage createInnerMessage = StarryNetMessageFactory.createInnerMessage();
        createInnerMessage.setMessage(new Function(7, "").toString());
        InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(createInnerMessage, new IMessageSendListener() {
            public IBinder asBinder() {
                return null;
            }

            public void onFail(String str, int i) throws RemoteException {
                StarryNetWifiManagerImpl.this.mIsGetWifiInfo = false;
                StarryNetWifiManagerImpl.this.onReceiveWifiInfo((StarryNetWifiInfo) null);
            }

            public void onSuccess(String str) throws RemoteException {
            }
        });
    }

    private void resetConnectWifiTimeout() {
        cleanConnectWifiTimeout();
        this.mTimeoutHandler.sendEmptyMessageDelayed(101, TIMEOUT_DURATION);
    }

    private void resetGetWifiInfoTimeout() {
        cleanGetWifiInfoTimeout();
        this.mTimeoutHandler.sendEmptyMessageDelayed(100, TIMEOUT_DURATION);
    }

    private String toWifiParamStr(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("SSID", str);
            jSONObject.put("PASSWORD", str2);
            jSONObject.put("SECURITY_TYPE", i);
        } catch (Exception e) {
            ILog.w(TAG, "Param json construction threw: " + e.getLocalizedMessage() + "!");
        }
        return jSONObject.toString();
    }

    public void connectWifi(String str, String str2, int i, IWifiConnectCallback iWifiConnectCallback) {
        if (this.mIsConnectingWifi) {
            try {
                iWifiConnectCallback.onResult(1);
            } catch (Exception e) {
                ILog.w(TAG, "Remote onResult call threw: " + e.getLocalizedMessage() + "!");
            }
        } else {
            resetConnectWifiTimeout();
            this.mWifiConnectCallback = iWifiConnectCallback;
            StarryNetMessage createInnerMessage = StarryNetMessageFactory.createInnerMessage();
            createInnerMessage.setMessage(new Function(9, toWifiParamStr(str, str2, i)).toString());
            InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(createInnerMessage, new IMessageSendListener() {
                public IBinder asBinder() {
                    return null;
                }

                public void onFail(String str, int i) throws RemoteException {
                    StarryNetWifiManagerImpl.this.onReceiveConnectResult(4);
                }

                public void onSuccess(String str) throws RemoteException {
                }
            });
        }
    }

    public MessageHandler getConnectWifiRequestHandler() {
        return this.mResponder.connectWifiRequestHandler;
    }

    public MessageHandler getConnectWifiResponseHandler() {
        return this.mConnectWifiResponseHandler;
    }

    public void getConnectedWifiInfo(IWifiInfoCallback iWifiInfoCallback) {
        if (this.mIsGetWifiInfo) {
            this.mPendingCallbacks.add(iWifiInfoCallback);
            return;
        }
        this.mIsGetWifiInfo = true;
        this.mPendingCallbacks.add(iWifiInfoCallback);
        requestWifiInfo();
        resetGetWifiInfoTimeout();
    }

    public MessageHandler getRequestWifiInfoHandler() {
        return this.mResponder.requestWifiInfoHandler;
    }

    public MessageHandler getWifiInfoResponseHandler() {
        return this.mWifiInfoResponseHandler;
    }
}
