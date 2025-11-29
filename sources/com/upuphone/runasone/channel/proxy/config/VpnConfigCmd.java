package com.upuphone.runasone.channel.proxy.config;

class VpnConfigCmd {
    public static final int TYPE_CMD_REQUEST = 1;
    public static final int TYPE_CMD_RESPONSE = 2;
    public static final int TYPE_CMD_STATE_CHANGED = 3;
    public String ackNumber;
    public int cmdType;
    public VpnConfig config;
    public String seqNumber;
}
