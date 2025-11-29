package com.upuphone.starrynet.core.ble.channel;

import java.util.List;

public class ReceiveChannel extends Channel {
    private ReceiveMessageListener mReceiveMsgListener;
    private Channel mSendChannel;

    public interface ReceiveMessageListener {
        void onReceive(byte[] bArr, int i);
    }

    public ReceiveChannel(Channel channel, ReceiveMessageListener receiveMessageListener) {
        this.mSendChannel = channel;
        this.mReceiveMsgListener = receiveMessageListener;
    }

    public int getDMTU() {
        return this.mSendChannel.getDMTU();
    }

    public int getMaxPackageNum() {
        return this.mSendChannel.getMaxPackageNum();
    }

    public void onRecv(byte[] bArr, int i) {
        ReceiveMessageListener receiveMessageListener = this.mReceiveMsgListener;
        if (receiveMessageListener != null) {
            receiveMessageListener.onReceive(bArr, i);
        }
    }

    public boolean useCrc32Verify() {
        return this.mSendChannel.useCrc32Verify();
    }

    public void write(byte[] bArr, ChannelCallback channelCallback, boolean z) {
        this.mSendChannel.write(bArr, channelCallback, z);
    }

    public void writeBatchData(List<byte[]> list, ChannelCallback channelCallback) {
        this.mSendChannel.writeBatchData(list, channelCallback);
    }
}
