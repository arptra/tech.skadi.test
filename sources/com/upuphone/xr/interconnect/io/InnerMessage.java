package com.upuphone.xr.interconnect.io;

import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;

public class InnerMessage {
    private IMessageSendListener mMessageSendListener;
    private StarryNetMessage mStarryNetMessage;
    private byte[] mTargetDeviceIdentifier;

    public InnerMessage(byte[] bArr, StarryNetMessage starryNetMessage, IMessageSendListener iMessageSendListener) {
        this.mTargetDeviceIdentifier = bArr;
        this.mStarryNetMessage = starryNetMessage;
        this.mMessageSendListener = iMessageSendListener;
    }

    public IMessageSendListener getMessageSendListener() {
        return this.mMessageSendListener;
    }

    public StarryNetMessage getStarryNetMessage() {
        return this.mStarryNetMessage;
    }

    public byte[] getTargetDeviceIdentifier() {
        return this.mTargetDeviceIdentifier;
    }
}
