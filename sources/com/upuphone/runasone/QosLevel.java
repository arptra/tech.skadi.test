package com.upuphone.runasone;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

public enum QosLevel implements ProtocolMessageEnum {
    QOS_0(0),
    QOS_1(1),
    QOS_2(2),
    QOS_3(3),
    UNRECOGNIZED(-1);
    
    public static final int QOS_0_VALUE = 0;
    public static final int QOS_1_VALUE = 1;
    public static final int QOS_2_VALUE = 2;
    public static final int QOS_3_VALUE = 3;
    private static final QosLevel[] VALUES = null;
    private static final Internal.EnumLiteMap<QosLevel> internalValueMap = null;
    private final int value;

    static {
        internalValueMap = new Internal.EnumLiteMap<QosLevel>() {
            public QosLevel findValueByNumber(int i) {
                return QosLevel.forNumber(i);
            }
        };
        VALUES = values();
    }

    private QosLevel(int i) {
        this.value = i;
    }

    public static QosLevel forNumber(int i) {
        if (i == 0) {
            return QOS_0;
        }
        if (i == 1) {
            return QOS_1;
        }
        if (i == 2) {
            return QOS_2;
        }
        if (i != 3) {
            return null;
        }
        return QOS_3;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return RunAsOneProto.getDescriptor().getEnumTypes().get(1);
    }

    public static Internal.EnumLiteMap<QosLevel> internalGetValueMap() {
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
    public static QosLevel valueOf(int i) {
        return forNumber(i);
    }

    public static QosLevel valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        } else if (enumValueDescriptor.getIndex() == -1) {
            return UNRECOGNIZED;
        } else {
            return VALUES[enumValueDescriptor.getIndex()];
        }
    }
}
