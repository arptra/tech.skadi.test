package com.upuphone.starrynet.strategy.channel.spp.negotiate;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.core.ble.utils.UUIDUtils;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IMessageChannel;
import com.upuphone.starrynet.strategy.channel.StarryNetChannelManager;
import com.upuphone.starrynet.strategy.encrypt.StarryLinkProtocolDataParseHelper;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SPPNegotiateProtocolManager {
    private static final String TAG = "SPPNegotiateProtocolManager";
    private Map<byte[], Integer> mBtMacUUIDMap;
    private List<Integer> mConflictUUIDs;

    public static final class Holder {
        public static final SPPNegotiateProtocolManager sInstance = new SPPNegotiateProtocolManager();
    }

    public static SPPNegotiateProtocolManager getInstance() {
        return Holder.sInstance;
    }

    private int sendMessage(StDevice stDevice, byte[] bArr) {
        IMessageChannel messageChannel = StarryNetChannelManager.getInstance().getMessageChannel(stDevice, 1);
        if (messageChannel != null) {
            return messageChannel.sendMsg(stDevice, bArr, 10);
        }
        StLog.i(TAG, "setMsg channel is null");
        return -1;
    }

    public void addConflictServerUUID(int i) {
        if (!this.mConflictUUIDs.contains(Integer.valueOf(i))) {
            this.mConflictUUIDs.add(Integer.valueOf(i));
        }
    }

    public int generateAvailableUUID() {
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt(65535);
        while (this.mConflictUUIDs.contains(Integer.valueOf(nextInt))) {
            nextInt = secureRandom.nextInt(65535);
        }
        return nextInt;
    }

    public Optional<Integer> getReadyServerUUID(byte[] bArr) {
        return Optional.ofNullable(this.mBtMacUUIDMap.get(bArr));
    }

    public void handleServerRequestConnect(StConnectDevice stConnectDevice, StDevice stDevice, byte[] bArr) {
        StLog.d(TAG, "receive server connect request, start connect");
        stConnectDevice.setSppStateOpen(true);
        StarryNetChannelManager.getInstance().getConnectChannel(23).connect(stDevice);
    }

    public void handleServerRequestStateChange(StConnectDevice stConnectDevice, boolean z) {
        stConnectDevice.setSppStateOpen(z);
        String str = TAG;
        StLog.d(str, "handleServerRequestStateChange state: " + z);
    }

    public void handleServerUUIDSync(StDevice stDevice, byte[] bArr) {
        byte[] byteArray = StarryLinkProtocolDataParseHelper.parseLinkProtocolData(bArr).getData().toByteArray();
        if (byteArray == null || byteArray.length != 4) {
            StLog.i(TAG, "not protocol message, ignore...");
            return;
        }
        int i = ByteUtils.toInt(byteArray);
        String str = TAG;
        StLog.d(str, "handleServerUUIDSync cache uuid: " + Integer.toHexString(i));
        this.mBtMacUUIDMap.put(stDevice.getIdentifier(), Integer.valueOf(i));
    }

    public void removeReadyServerUUID(byte[] bArr) {
        this.mBtMacUUIDMap.remove(bArr);
    }

    public int startServerRequestConnect(StDevice stDevice) {
        String str = TAG;
        StLog.d(str, "startServerRequestConnect " + stDevice.getDeviceName());
        return sendMessage(stDevice, StarryNetEncryptHelper.generateSppServerRequestConnectMessage());
    }

    public void startServerUUIDSync(StDevice stDevice, UUID uuid) {
        String str = TAG;
        StLog.d(str, "startServerUUIDSync uuid:" + uuid);
        sendMessage(stDevice, StarryNetEncryptHelper.generateSppServerUUIDSyncMessage(ByteUtils.fromInt(UUIDUtils.getShortUUIDOfInt(uuid))));
    }

    private SPPNegotiateProtocolManager() {
        this.mConflictUUIDs = new ArrayList(3);
        this.mBtMacUUIDMap = new ConcurrentHashMap(3);
    }
}
