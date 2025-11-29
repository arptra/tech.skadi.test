package com.upuphone.runasone.channel.bean.stream;

import android.text.TextUtils;
import com.google.protobuf.ByteString;
import com.upuphone.runasone.StreamReq;
import com.upuphone.runasone.StreamType;
import com.upuphone.runasone.channel.proxy.ProxyManager;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.message.ChannelMessage;
import com.upuphone.runasone.utils.LogUtil;
import com.upuphone.runasone.utils.Utils;
import com.upuphone.starrynet.strategy.StarryNetData;

public class StreamBuilder {
    public static StreamReq genAck(long j, String str, String str2) {
        return StreamReq.newBuilder().setReqId(j).setDeviceId(str).setType(StreamType.ACK).setTimeStamp(Utils.getTimestamp()).setSession(str2).build();
    }

    public static StreamReq genAuth(String str, String str2) {
        StreamReq.Builder timeStamp = StreamReq.newBuilder().setDeviceId(str).setType(StreamType.AUTH).setProtocolVersion(Constants.PROTOCOL_VERSION).setReqInfo(str2).setTimeStamp(Utils.getTimestamp());
        if (Utils.isPhone()) {
            String localIpAddress = StarryNetData.getInstance().getOwnDevice().getLocalIpAddress();
            LogUtil.d("localIpAddress: " + localIpAddress);
            if (!TextUtils.isEmpty(localIpAddress)) {
                ProxyManager.getInstance().startServer(0);
                int tcpPort = ProxyManager.getInstance().getTcpPort();
                int udpPort = ProxyManager.getInstance().getUdpPort();
                StarryNetData.getInstance().getOwnDevice().setLocalVpnTcpPort(tcpPort);
                StarryNetData.getInstance().getOwnDevice().setLocalVpnUdpPort(udpPort);
                timeStamp.setIpAddress(localIpAddress);
                timeStamp.setTcpPort(tcpPort);
                timeStamp.setUdpPort(udpPort);
            }
        }
        return timeStamp.build();
    }

    public static StreamReq genAuthSuccess(String str, String str2, long j) {
        return StreamReq.newBuilder().setDeviceId(str).setType(StreamType.AUTH_SUCCESS).setProtocolVersion(Constants.PROTOCOL_VERSION).setReqInfo(str2).setTimeStamp(Utils.getTimestamp()).setDeltaSysTime(j).build();
    }

    public static StreamReq genByPass(ChannelMessage channelMessage) {
        return StreamReq.newBuilder().setDeviceId(channelMessage.getId()).setCategory(channelMessage.getCategory()).setType(channelMessage.getMessageType()).setReqId(channelMessage.getRequestId()).setIsRetransmission(channelMessage.isRetransmission()).setBypass(ByteString.copyFrom(channelMessage.getAbilityMessage().getBypass())).setSession(channelMessage.getSession()).setQos(channelMessage.getQos()).setDstId(channelMessage.getDstId()).setSrcId(channelMessage.getSrcId() == null ? "" : channelMessage.getSrcId()).build();
    }

    public static StreamReq genHeartBeat(String str, String str2, String str3) {
        return StreamReq.newBuilder().setDeviceId(str).setReqInfo(str2).setType(StreamType.HEARTBEAT).setTimeStamp(Utils.getTimestamp()).setSession(str3).build();
    }

    public static StreamReq genRetransmission(String str, long j, long j2, String str2) {
        return StreamReq.newBuilder().setDeviceId(str).setType(StreamType.RETRANSMISSION).setReqId(j).setRetransmissionLen(j2).setTimeStamp(Utils.getTimestamp()).setSession(str2).build();
    }

    public static StreamReq genTearDown(String str, String str2) {
        return StreamReq.newBuilder().setDeviceId(str).setType(StreamType.TEARDOWN).setTimeStamp(Utils.getTimestamp()).setSession(str2).build();
    }

    public static StreamReq genTearDownAck(String str, String str2) {
        return StreamReq.newBuilder().setDeviceId(str).setType(StreamType.TEARDOWN_ACK).setTimeStamp(Utils.getTimestamp()).setSession(str2).build();
    }
}
