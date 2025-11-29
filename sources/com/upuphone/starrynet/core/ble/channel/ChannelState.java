package com.upuphone.starrynet.core.ble.channel;

public enum ChannelState {
    IDLE,
    READY,
    WAIT_START_ACK,
    WRITING,
    SYNC,
    SYNC_ACK,
    SYNC_WAIT_PACKET,
    READING,
    WAIT_MNG_ACK,
    WAIT_SINGLE_ACK,
    WAIT_START_FAST_ACK,
    FAST_READING,
    MIX_READING
}
