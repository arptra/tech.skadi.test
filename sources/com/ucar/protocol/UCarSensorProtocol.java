package com.ucar.protocol;

import com.ucar.databus.proto.UCarProto;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.HashMap;

public class UCarSensorProtocol extends UCarProtocol {
    public static UCarMessage j(UCarProto.Acceleration acceleration) {
        return UCarProtocol.d(s().f(SourceDevice.CAR).e(4).a(acceleration));
    }

    public static UCarMessage k(UCarProto.Battery battery) {
        return UCarProtocol.d(s().f(SourceDevice.CAR).e(8).a(battery));
    }

    public static UCarMessage l(UCarProto.GearInfo gearInfo) {
        return UCarProtocol.d(s().f(SourceDevice.CAR).e(6).a(gearInfo));
    }

    public static UCarMessage m(UCarProto.Gps gps) {
        return UCarProtocol.d(s().f(SourceDevice.CAR).e(1).a(gps));
    }

    public static UCarMessage n(UCarProto.GyroScope gyroScope) {
        return UCarProtocol.d(s().f(SourceDevice.CAR).e(3).a(gyroScope));
    }

    public static UCarMessage o(UCarProto.LightSensorInfo lightSensorInfo) {
        return UCarProtocol.d(s().f(SourceDevice.CAR).e(7).a(lightSensorInfo));
    }

    public static UCarMessage p(UCarProto.Lights lights) {
        return UCarProtocol.d(s().f(SourceDevice.CAR).e(2).a(lights));
    }

    public static UCarMessage q(UCarProto.Oil oil) {
        return UCarProtocol.d(s().f(SourceDevice.CAR).e(5).a(oil));
    }

    public static void r() {
        UCarProtocol.h(CmdCategory.SENSOR, new HashMap<Integer, String>() {
            {
                put(1, "gps");
                put(2, "lights");
                put(3, "gyro_scope");
                put(4, "acceleration");
                put(5, "oil");
                put(6, "gear_info");
                put(7, "light_sensor_info");
                put(8, PayloadConstant.PARAMS_KEY_INT_BATTERY);
            }
        });
    }

    public static UCarMessageBuilder s() {
        return UCarMessage.q().b(CmdCategory.SENSOR);
    }
}
