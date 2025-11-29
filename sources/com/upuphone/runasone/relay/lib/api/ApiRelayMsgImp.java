package com.upuphone.runasone.relay.lib.api;

import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.relay.StarryParam;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.runasone.relay.api.ApiRelayMsg;
import com.upuphone.runasone.relay.api.RelayCallback;
import com.upuphone.runasone.relay.api.SendRelayMessageCallBack;
import com.upuphone.runasone.relay.error.RelayErrorCode;
import com.upuphone.runasone.relay.lib.RelayPort;
import com.upuphone.runasone.relay.lib.air.AirPort;
import com.upuphone.runasone.relay.lib.air.AirPortDeviceManager;
import com.upuphone.runasone.relay.lib.air.AirPortMessageManager;
import com.upuphone.runasone.relay.lib.device.MessageManager;
import com.upuphone.runasone.relay.lib.device.RelayDeviceManager;
import com.upuphone.runasone.relay.lib.utils.LogUtil;
import com.upuphone.runasone.relay.lib.utils.UtilUse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApiRelayMsgImp implements ApiRelayMsg {
    public List<StarryDevice> getRelayDeviceList(String str) {
        Map<String, StarryDevice> abilityDeviceMap = RelayDeviceManager.getInstance().getAbilityDeviceMap(str);
        abilityDeviceMap.putAll(AirPortDeviceManager.Companion.getSIntance().getDeviceMap(str));
        return new ArrayList(abilityDeviceMap.values());
    }

    public void removeRelayListener(String str, String str2) {
        RelayPort.getInstance().removeRelayListener(str, str2);
        AirPort.Companion.getSIntance().removeRelayListener(str);
    }

    public void sendMessageQos(StarryTag starryTag, ArrayData arrayData, int i, StarryParam starryParam, SendRelayMessageCallBack sendRelayMessageCallBack) {
        if (!UtilUse.isStarryTagNull(starryTag)) {
            if (i != 3 || arrayData.getData().length <= 200) {
                LogUtil.iPrimary("", AirPort.getDeviceSet().contains(starryTag.getDeviceId()) + "");
                if (AirPort.getDeviceSet().contains(starryTag.getDeviceId())) {
                    AirPortMessageManager.Companion.getSIntance().sendMessage(starryTag, arrayData.getData(), i, starryParam, sendRelayMessageCallBack);
                    return;
                }
                MessageManager.getInstance().sendMessage(starryTag, arrayData.getData(), i, starryParam, sendRelayMessageCallBack);
                return;
            }
            if (sendRelayMessageCallBack != null) {
                sendRelayMessageCallBack.onError(RelayErrorCode.EMERGENCY_TOO_LONG, RelayErrorCode.EMERGENCY_TOO_LONG_TEXT);
            }
            LogUtil.ePrimary("", "The emergency message is too long, exceeding 200B");
        }
    }

    public void setRelayListener(String str, String str2, RelayCallback relayCallback) {
        RelayPort.getInstance().setRelayListener(str, str2, relayCallback);
        AirPort.Companion.getSIntance().setRelayListener(str, relayCallback);
    }

    public void startRemote(StarryTag starryTag, String str, ArrayData arrayData, int i, StarryParam starryParam) {
        if (!UtilUse.isStarryTagNull(starryTag)) {
            if (AirPort.getDeviceSet().contains(starryTag.getDeviceId())) {
                AirPortMessageManager.Companion.getSIntance().startRemote(starryTag, str, arrayData.getData(), i, starryParam);
                return;
            }
            MessageManager.getInstance().startRemote(starryTag, str, arrayData.getData(), i, starryParam);
        }
    }

    public void stopRemote(StarryTag starryTag, StarryParam starryParam) {
        if (!UtilUse.isStarryTagNull(starryTag)) {
            if (AirPort.getDeviceSet().contains(starryTag.getDeviceId())) {
                AirPortMessageManager.Companion.getSIntance().stopRemote(starryTag, starryParam);
            } else {
                MessageManager.getInstance().stopRemote(starryTag, starryParam);
            }
        }
    }
}
