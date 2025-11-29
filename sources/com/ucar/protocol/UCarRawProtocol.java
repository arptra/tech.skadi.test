package com.ucar.protocol;

import com.ucar.databus.proto.UCarProto;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class UCarRawProtocol extends UCarProtocol {
    public static void j() {
        UCarProtocol.h(CmdCategory.AUDIO, new HashMap<Integer, String>() {
            {
                put(1, "ip_call");
                put(2, "modem_call");
                put(3, "ai_assistant");
                put(4, "ring");
                put(5, "notification");
                put(6, "tts");
                put(7, "system");
                put(10, "num");
                put(9, "microphone");
                put(0, "undefined");
            }
        });
        UCarProtocol.h(CmdCategory.VIDEO, new HashMap<Integer, String>() {
            {
                put(3, "camera_preview");
                put(4, "camera_picture");
            }
        });
    }

    public static boolean k(UCarMessage uCarMessage) {
        return uCarMessage.o() && uCarMessage.f() == CmdCategory.AUDIO;
    }

    public static UCarMessage l(ByteBuffer byteBuffer, UCarProto.AudioType audioType) {
        UCarMessage s = UCarMessage.s();
        s.g().k(byteBuffer.remaining() + 20, DataFormat.RAW, MessageType.SEND, CmdCategory.AUDIO, audioType.getNumber());
        s.v(byteBuffer);
        return s;
    }

    public static byte[] m(UCarMessage uCarMessage) {
        UCarProtocol.b(uCarMessage.g().e().b() == DataFormat.RAW_NO_ENCRYPTED ? null : DataFormat.RAW, CmdCategory.AUDIO, -1, uCarMessage);
        return uCarMessage.d();
    }

    public static UCarProto.AudioType n(UCarMessage uCarMessage) {
        UCarProtocol.b(uCarMessage.g().e().b() == DataFormat.RAW_NO_ENCRYPTED ? null : DataFormat.RAW, CmdCategory.AUDIO, -1, uCarMessage);
        return UCarProto.AudioType.forNumber(uCarMessage.i());
    }
}
