package com.upuphone.runasone;

import com.google.protobuf.AnyProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import io.netty.handler.codec.rtsp.RtspHeaders;

public final class RunAsOneProto {
    /* access modifiers changed from: private */
    public static Descriptors.FileDescriptor descriptor;
    static final Descriptors.Descriptor internal_static_StreamReq_descriptor;
    static final GeneratedMessageV3.FieldAccessorTable internal_static_StreamReq_fieldAccessorTable;

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012runasone_api.proto\u001a\u0019google/protobuf/any.proto\"\u0003\n\tStreamReq\u0012\u0019\n\u0004type\u0018\u0001 \u0001(\u000e2\u000b.StreamType\u0012\u0010\n\bcategory\u0018\u0002 \u0001(\t\u0012\u0010\n\bdeviceId\u0018\u0003 \u0001(\t\u0012\u000f\n\u0007reqInfo\u0018\u0004 \u0001(\t\u0012(\n\nabilityMsg\u0018\u0005 \u0001(\u000b2\u0014.google.protobuf.Any\u0012\u000e\n\u0006bypass\u0018\u0006 \u0001(\f\u0012\u0017\n\u000fprotocolVersion\u0018\u0007 \u0001(\t\u0012\r\n\u0005reqId\u0018\b \u0001(\u0004\u0012\u0011\n\ttimeStamp\u0018\t \u0001(\t\u0012\u0019\n\u0011retransmissionLen\u0018\n \u0001(\u0004\u0012\u0018\n\u0010isRetransmission\u0018\u000b \u0001(\b\u0012\u0014\n\fdeltaSysTime\u0018\f \u0001(\u0004\u0012\u0016\n\u0003qos\u0018\r \u0001(\u000e2\t.QosLevel\u0012\u000f\n\u0007session\u0018\u000e \u0001(\t\u0012\r\n\u0005dstId\u0018\u000f \u0001(\t\u0012\r\n\u0005srcId\u0018\u0010 \u0001(\t\u0012\u0011\n\tipAddress\u0018\u0011 \u0001(\t\u0012\u000f\n\u0007tcpPort\u0018\u0012 \u0001(\r\u0012\u000f\n\u0007udpPort\u0018\u0013 \u0001(\r*à\u0001\n\nStreamType\u0012\b\n\u0004AUTH\u0010\u0000\u0012\t\n\u0005CLOSE\u0010\u0001\u0012\u0007\n\u0003CMD\u0010\u0003\u0012\n\n\u0006BYPASS\u0010\u0004\u0012\r\n\tHEARTBEAT\u0010\u0005\u0012\t\n\u0005DEBUG\u0010\u0006\u0012\u0007\n\u0003ACK\u0010\u0007\u0012\f\n\bTEARDOWN\u0010\b\u0012\u0010\n\fTEARDOWN_ACK\u0010\t\u0012\u0012\n\u000eRETRANSMISSION\u0010\n\u0012\u0016\n\u0012RETRANSMISSION_ACK\u0010\u000b\u0012\u0010\n\fAUTH_SUCCESS\u0010\f\u0012\u000f\n\u000bAUTH_REJECT\u0010\r\u0012\n\n\u0006ACTION\u0010\u000e\u0012\n\n\u0006BRIDGE\u0010\u000f*6\n\bQosLevel\u0012\t\n\u0005QOS_0\u0010\u0000\u0012\t\n\u0005QOS_1\u0010\u0001\u0012\t\n\u0005QOS_2\u0010\u0002\u0012\t\n\u0005QOS_3\u0010\u0003B.\n\u0015com.upuphone.runasoneB\rRunAsOneProtoP\u0001¢\u0002\u0003RAOb\u0006proto3"}, new Descriptors.FileDescriptor[]{AnyProto.getDescriptor()}, new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = RunAsOneProto.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_StreamReq_descriptor = descriptor2;
        internal_static_StreamReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Type", "Category", "DeviceId", "ReqInfo", "AbilityMsg", "Bypass", "ProtocolVersion", "ReqId", "TimeStamp", "RetransmissionLen", "IsRetransmission", "DeltaSysTime", "Qos", RtspHeaders.Names.SESSION, "DstId", "SrcId", "IpAddress", "TcpPort", "UdpPort"});
        AnyProto.getDescriptor();
    }

    private RunAsOneProto() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }
}
