package com.upuphone.runasone;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

public enum StreamType implements ProtocolMessageEnum {
    AUTH(0),
    CLOSE(1),
    CMD(3),
    BYPASS(4),
    HEARTBEAT(5),
    DEBUG(6),
    ACK(7),
    TEARDOWN(8),
    TEARDOWN_ACK(9),
    RETRANSMISSION(10),
    RETRANSMISSION_ACK(11),
    AUTH_SUCCESS(12),
    AUTH_REJECT(13),
    ACTION(14),
    BRIDGE(15),
    UNRECOGNIZED(-1);
    
    public static final int ACK_VALUE = 7;
    public static final int ACTION_VALUE = 14;
    public static final int AUTH_REJECT_VALUE = 13;
    public static final int AUTH_SUCCESS_VALUE = 12;
    public static final int AUTH_VALUE = 0;
    public static final int BRIDGE_VALUE = 15;
    public static final int BYPASS_VALUE = 4;
    public static final int CLOSE_VALUE = 1;
    public static final int CMD_VALUE = 3;
    public static final int DEBUG_VALUE = 6;
    public static final int HEARTBEAT_VALUE = 5;
    public static final int RETRANSMISSION_ACK_VALUE = 11;
    public static final int RETRANSMISSION_VALUE = 10;
    public static final int TEARDOWN_ACK_VALUE = 9;
    public static final int TEARDOWN_VALUE = 8;
    private static final StreamType[] VALUES = null;
    private static final Internal.EnumLiteMap<StreamType> internalValueMap = null;
    private final int value;

    static {
        internalValueMap = new Internal.EnumLiteMap<StreamType>() {
            public StreamType findValueByNumber(int i) {
                return StreamType.forNumber(i);
            }
        };
        VALUES = values();
    }

    private StreamType(int i) {
        this.value = i;
    }

    public static StreamType forNumber(int i) {
        switch (i) {
            case 0:
                return AUTH;
            case 1:
                return CLOSE;
            case 3:
                return CMD;
            case 4:
                return BYPASS;
            case 5:
                return HEARTBEAT;
            case 6:
                return DEBUG;
            case 7:
                return ACK;
            case 8:
                return TEARDOWN;
            case 9:
                return TEARDOWN_ACK;
            case 10:
                return RETRANSMISSION;
            case 11:
                return RETRANSMISSION_ACK;
            case 12:
                return AUTH_SUCCESS;
            case 13:
                return AUTH_REJECT;
            case 14:
                return ACTION;
            case 15:
                return BRIDGE;
            default:
                return null;
        }
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return RunAsOneProto.getDescriptor().getEnumTypes().get(0);
    }

    public static Internal.EnumLiteMap<StreamType> internalGetValueMap() {
        return internalValueMap;
    }

    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(ordinal());
    }

    @Deprecated
    public static StreamType valueOf(int i) {
        return forNumber(i);
    }

    public static StreamType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        } else if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        } else {
            return VALUES[enumValueDescriptor.getIndex()];
        }
    }
}
