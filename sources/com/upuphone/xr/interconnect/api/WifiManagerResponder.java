package com.upuphone.xr.interconnect.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.SupplicantState;
import android.os.Build;
import android.text.TextUtils;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.entity.Function;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.entity.StarryNetWifiInfo;
import com.upuphone.xr.interconnect.main.StarryNetMessageFactory;
import com.upuphone.xr.interconnect.main.handler.MessageHandler;
import com.upuphone.xr.interconnect.util.WifiUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import org.json.JSONObject;

class WifiManagerResponder extends BroadcastReceiver {
    public static final String TAG = "WifiManagerResponder";
    final MessageHandler connectWifiRequestHandler = new MessageHandler() {
        public int getHandleType() {
            return 9;
        }

        public void handle(StarryNetMessage starryNetMessage, Function function) {
            ULog.i(WifiManagerResponder.TAG, "request connect wifi");
            try {
                JSONObject jSONObject = new JSONObject((String) function.parseData(String.class));
                String optString = jSONObject.optString("SSID");
                String optString2 = jSONObject.optString("PASSWORD");
                WifiManagerResponder.this.connectingSSID = optString;
                WifiManagerResponder.this.isTryConnecting = false;
                WifiManagerResponder.this.isConnectFinished = false;
                if (!WifiUtil.connectWifi(optString, optString2, jSONObject.optInt("SECURITY_TYPE"))) {
                    WifiManagerResponder.this.sendConnectResult(4);
                } else {
                    WifiManagerResponder.this.registerWifiStateReceiver();
                }
            } catch (Exception e) {
                ILog.w(WifiManagerResponder.TAG, "Connect handling threw: " + e.getLocalizedMessage() + "!");
                WifiManagerResponder.this.sendConnectResult(4);
            }
        }
    };
    /* access modifiers changed from: private */
    public String connectingSSID;
    /* access modifiers changed from: private */
    public boolean isConnectFinished;
    /* access modifiers changed from: private */
    public boolean isTryConnecting;
    final MessageHandler requestWifiInfoHandler = new MessageHandler() {
        public int getHandleType() {
            return 7;
        }

        public void handle(StarryNetMessage starryNetMessage, Function function) {
            ULog.i(WifiManagerResponder.TAG, "request wifi info");
            WifiManagerResponder.this.sendWifiInfoResult(WifiManagerResponder.this.createWifiInfo());
        }
    };

    private void connectEnd(int i) {
        ULog.i(TAG, "connectEnd: " + i);
        this.isTryConnecting = false;
        this.isConnectFinished = true;
        this.connectingSSID = null;
        unregisterWifiStateReceiver();
        sendConnectResult(i);
    }

    /* access modifiers changed from: private */
    public StarryNetWifiInfo createWifiInfo() {
        StarryNetWifiInfo starryNetWifiInfo = new StarryNetWifiInfo();
        starryNetWifiInfo.setSsid(WifiUtil.getConnectedSSID());
        return starryNetWifiInfo;
    }

    /* access modifiers changed from: private */
    public void registerWifiStateReceiver() {
        ULog.i(TAG, "registerWifiStateReceiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        Context context = InterconnectManager.getInstance().getContext();
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(this, intentFilter, 4);
        } else {
            context.registerReceiver(this, intentFilter);
        }
    }

    /* access modifiers changed from: private */
    public void sendConnectResult(int i) {
        StarryNetMessage createInnerMessage = StarryNetMessageFactory.createInnerMessage();
        createInnerMessage.setMessage(new Function(10, toWifiConnectResultStr(i)).toString());
        InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(createInnerMessage, (IMessageSendListener) null);
    }

    /* access modifiers changed from: private */
    public void sendWifiInfoResult(StarryNetWifiInfo starryNetWifiInfo) {
        StarryNetMessage createInnerMessage = StarryNetMessageFactory.createInnerMessage();
        createInnerMessage.setMessage(new Function(8, starryNetWifiInfo).toString());
        InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(createInnerMessage, (IMessageSendListener) null);
    }

    private String toWifiConnectResultStr(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("RESULT_CODE", i);
        } catch (Exception e) {
            ILog.w(TAG, "Result json construction threw: " + e.getLocalizedMessage() + "!");
        }
        return jSONObject.toString();
    }

    private void unregisterWifiStateReceiver() {
        InterconnectManager.getInstance().getContext().unregisterReceiver(this);
    }

    public void onReceive(Context context, Intent intent) {
        String str;
        String action = intent.getAction();
        ULog.i(TAG, "Wifi state receiver onReceive action: " + intent.getAction());
        if ("android.net.wifi.supplicant.STATE_CHANGE".equals(action)) {
            SupplicantState supplicantState = (SupplicantState) intent.getParcelableExtra("newState");
            String connectedSSID = WifiUtil.getConnectedSSID();
            int intExtra = intent.getIntExtra("supplicantError", -1);
            ULog.i(TAG, "onReceive: connecting ssid: " + connectedSSID);
            ULog.i(TAG, "onReceive: supplicant state: " + supplicantState + ", error: " + intExtra);
            if (supplicantState == SupplicantState.ASSOCIATED) {
                String str2 = this.connectingSSID;
                if (str2 != null && TextUtils.equals(connectedSSID, str2)) {
                    this.isTryConnecting = true;
                }
            } else if (supplicantState == SupplicantState.DISCONNECTED) {
                if (!this.isTryConnecting) {
                    return;
                }
                if (intExtra == 1) {
                    connectEnd(3);
                } else {
                    connectEnd(4);
                }
            } else if (supplicantState == SupplicantState.COMPLETED && !this.isConnectFinished && (str = this.connectingSSID) != null && str.equals(connectedSSID)) {
                connectEnd(0);
            }
        }
    }
}
