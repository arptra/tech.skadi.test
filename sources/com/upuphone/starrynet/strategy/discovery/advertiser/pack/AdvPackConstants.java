package com.upuphone.starrynet.strategy.discovery.advertiser.pack;

public class AdvPackConstants {
    public static final int ADV_MODE_ACTIVE_NO_WINDOW = 144;
    public static final int ADV_MODE_ACTIVE_WINDOW = 128;
    @Deprecated
    public static final int ADV_MODE_CONNECT_ACTIVE = 192;
    public static final int ADV_MODE_NOTIFY_STARRY = 0;
    public static final int ADV_MODE_NOTIFY_THIRD = 16;
    public static final int ADV_MODE_PASSIVE_STARRY = 160;
    public static final int ADV_MODE_PASSIVE_THIRD = 176;
    public static final int ADV_MODE_RECONNECT = 64;
    public static final int ADV_MODE_REQUEST_CONNECT = 208;
    public static final byte[] ADV_RSP_CAR = {0, 12};
    public static final byte[] ADV_RSP_CAR_DISPATCH = {0, 8};
    public static final byte[] ADV_RSP_PHONE = {0, 3};
    public static final byte[] ADV_RSP_PHONE_DISPATCH = {0, 2};
    public static final byte[] ADV_RSP_XR_DISPATCH = {0, 32};
    public static final int MAX_LENGTH_USER_ID = 7;
    public static final int TYPE_STARRY_ACTIVE_DISCONNECT_PAD = 1;
    public static final int TYPE_STARRY_NOTIFY_CMD_DISCONNECT = 1;
    public static final int TYPE_STARRY_UPGRADE = 1;
}
