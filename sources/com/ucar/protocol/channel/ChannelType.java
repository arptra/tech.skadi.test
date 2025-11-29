package com.ucar.protocol.channel;

public enum ChannelType {
    CUSTOM(0),
    UIBC(4321),
    RTSP(7236),
    RTP(15550),
    AUTH(57209),
    CONTROL(57219),
    MEDIA(57229),
    SENSOR(57239),
    CERT(57249),
    VIDEO(57259);
    
    private static ChannelType[] mValues;
    private final int mPort;

    static {
        mValues = null;
    }

    private ChannelType(int i) {
        this.mPort = i;
    }

    public static ChannelType fromPort(int i) {
        if (mValues == null) {
            mValues = values();
        }
        int i2 = 0;
        while (true) {
            ChannelType[] channelTypeArr = mValues;
            if (i2 >= channelTypeArr.length) {
                return CUSTOM;
            }
            ChannelType channelType = channelTypeArr[i2];
            if (channelType.mPort == i) {
                return channelType;
            }
            i2++;
        }
    }

    public int getPort() {
        return this.mPort;
    }
}
