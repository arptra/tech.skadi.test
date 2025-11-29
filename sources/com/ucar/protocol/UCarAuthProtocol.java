package com.ucar.protocol;

import com.google.protobuf.InvalidProtocolBufferException;
import com.ucar.databus.proto.UCarProto;
import java.util.HashMap;

public class UCarAuthProtocol extends UCarProtocol {
    public static void j(int i, UCarMessage uCarMessage, MessageType messageType) {
        UCarProtocol.c(DataFormat.PB3, CmdCategory.AUTH, i, uCarMessage, messageType);
    }

    public static UCarMessage k(UCarProto.AuthResponse authResponse, int i) {
        return o().d(MessageType.RES).e(2).a(authResponse).A(i);
    }

    public static void l() {
        UCarProtocol.h(CmdCategory.AUTH, new HashMap<Integer, String>() {
            {
                put(1, "auth_request");
                put(2, "auth_response");
                put(3, "auth_confirm");
            }
        });
    }

    public static boolean m(UCarMessage uCarMessage) {
        return uCarMessage != null && uCarMessage.f() == CmdCategory.AUTH && uCarMessage.m() && uCarMessage.i() == 3;
    }

    public static boolean n(UCarMessage uCarMessage) {
        return uCarMessage != null && uCarMessage.f() == CmdCategory.AUTH && uCarMessage.m() && uCarMessage.i() == 1;
    }

    public static UCarMessageBuilder o() {
        return UCarMessage.q().f(ProtocolConfig.e()).b(CmdCategory.AUTH);
    }

    public static UCarProto.AuthConfirm p(UCarMessage uCarMessage) {
        j(3, uCarMessage, MessageType.SEND);
        try {
            return UCarProto.AuthConfirm.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseAuthConfirmMessage error: " + e.getMessage(), e);
        }
    }

    public static UCarProto.AuthRequest q(UCarMessage uCarMessage) {
        j(1, uCarMessage, MessageType.REQ);
        try {
            return UCarProto.AuthRequest.parseFrom(uCarMessage.b());
        } catch (InvalidProtocolBufferException e) {
            throw new ProtocolException("parseAuthRequestMessage error: " + e.getMessage(), e);
        }
    }
}
