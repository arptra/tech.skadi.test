package com.ucar.protocol;

import com.ucar.databus.proto.UCarProto;
import java.util.HashMap;

public class UCarCertProtocol extends UCarProtocol {
    public static UCarMessage j(UCarProto.CarCertificate carCertificate) {
        return l().e(1).a(carCertificate);
    }

    public static void k() {
        UCarProtocol.h(CmdCategory.CERT, new HashMap<Integer, String>() {
            {
                put(1, "certificate");
            }
        });
    }

    public static UCarMessageBuilder l() {
        return UCarMessage.q().f(ProtocolConfig.e()).b(CmdCategory.CERT);
    }
}
