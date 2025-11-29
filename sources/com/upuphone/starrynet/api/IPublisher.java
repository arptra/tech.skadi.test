package com.upuphone.starrynet.api;

public interface IPublisher {
    public static final int STATE_DEVICE_DOWN = 2;
    public static final int STATE_DEVICE_UP = 1;

    public interface IHandler {
        void onDeviceStateChanged(String str, int i);

        void onHandle(String str, byte[] bArr);
    }

    boolean isCanPublish(String str);

    boolean publish(String str, byte[] bArr);
}
