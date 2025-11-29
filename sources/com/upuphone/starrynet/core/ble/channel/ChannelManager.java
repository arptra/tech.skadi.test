package com.upuphone.starrynet.core.ble.channel;

import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class ChannelManager {
    public static final int ATT_HEADER = 3;
    public static final int DEFAULT_MTU_SIZE = 23;
    protected static final int DMTU_OFFSET = 5;
    public static final int MAX_MTU_SIZE = 512;
    public static final int MAX_PACKAGE_NUM = 6;
    IBleChannelReader mBleReader = new IBleChannelReader() {
        public void onRead(ChannelTag channelTag, byte[] bArr, int i) {
            ChannelManager.this.receiveData(channelTag, bArr, i);
        }
    };
    protected ConcurrentMap<ChannelTag, SendChannel> mChannels = new ConcurrentHashMap();
    private Map<ChannelTag, IBleChannelWriter> writerMap = new ConcurrentHashMap();

    public synchronized SendChannel getChannel(ChannelTag channelTag) {
        return this.mChannels.get(channelTag);
    }

    public abstract int getDMTU(String str);

    public IBleChannelWriter getWriterByMac(ChannelTag channelTag) {
        if (channelTag == null) {
            log("getWriter,but tag is empty,then return", new Object[0]);
            return null;
        }
        IBleChannelWriter iBleChannelWriter = this.writerMap.get(channelTag);
        if (iBleChannelWriter != null) {
            return iBleChannelWriter;
        }
        IBleChannelWriter registerChannelReader = registerChannelReader(channelTag, (IBleChannelReader) null);
        this.writerMap.put(channelTag, registerChannelReader);
        return registerChannelReader;
    }

    public abstract boolean isClient();

    public void log(String str, Object... objArr) {
        BluetoothLog.log(getClass().getSimpleName(), str, objArr);
    }

    public void onBleConnected(String str) {
        log("onBleConnected ,mac=%s", str);
        if (isClient()) {
            registerChannelReader(new ChannelTag(str, BluetoothConstants.STARRY_NET_AIR_INTERNAL_MESSAGE_UUID), this.mBleReader);
            registerChannelReader(new ChannelTag(str, BluetoothConstants.STARRY_NET_AIR_EXTERNAL_MESSAGE_UUID), this.mBleReader);
        }
    }

    public void onBleDisconnected(String str) {
        log("channel manager receive device mac=%s, disconnected", str);
        if (!this.writerMap.isEmpty()) {
            Iterator<Map.Entry<ChannelTag, IBleChannelWriter>> it = this.writerMap.entrySet().iterator();
            while (it.hasNext()) {
                if (((ChannelTag) it.next().getKey()).getBleMac().equals(str)) {
                    it.remove();
                }
            }
        }
        resetChannelState(str);
    }

    public abstract void receiveData(ChannelTag channelTag, byte[] bArr, int i);

    public synchronized IBleChannelWriter registerChannelReader(ChannelTag channelTag, IBleChannelReader iBleChannelReader) {
        SendChannel sendChannel;
        try {
            log("registerChannelReader mac =%s ", channelTag);
            sendChannel = this.mChannels.get(channelTag);
            if (sendChannel == null) {
                sendChannel = new SendChannel(channelTag, this, useCrc32Verify());
                this.mChannels.put(channelTag, sendChannel);
            }
            if (iBleChannelReader != null) {
                sendChannel.addReader(iBleChannelReader);
            }
        } catch (Throwable th) {
            throw th;
        }
        return sendChannel.writer;
    }

    public synchronized SendChannel removeChannel(ChannelTag channelTag) {
        return this.mChannels.remove(channelTag);
    }

    public void resetChannelState(String str) {
        if (!this.mChannels.isEmpty()) {
            Iterator<Map.Entry<ChannelTag, SendChannel>> it = this.mChannels.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (((ChannelTag) next.getKey()).getBleMac().equals(str)) {
                    SendChannel sendChannel = (SendChannel) next.getValue();
                    if (sendChannel != null) {
                        sendChannel.reset(1);
                        sendChannel.destroy();
                    }
                    it.remove();
                }
            }
        }
    }

    public synchronized void unregisterChannelReader(ChannelTag channelTag, IBleChannelReader iBleChannelReader) {
        SendChannel sendChannel = this.mChannels.get(channelTag);
        if (sendChannel != null) {
            sendChannel.removeReader(iBleChannelReader);
        }
    }

    public abstract boolean useCrc32Verify();

    public abstract void writeBatchBleData(ChannelTag channelTag, List<byte[]> list, ChannelCallback channelCallback);

    public abstract void writeBle(ChannelTag channelTag, byte[] bArr, ChannelCallback channelCallback, boolean z);
}
