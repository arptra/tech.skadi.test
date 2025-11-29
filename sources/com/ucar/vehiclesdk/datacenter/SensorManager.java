package com.ucar.vehiclesdk.datacenter;

import com.easy.logger.EasyLog;
import com.share.connect.channel.ConnectChannel;
import com.ucar.databus.proto.UCarProto;
import com.ucar.protocol.UCarSensorProtocol;
import com.ucar.protocol.channel.SendFutureCallback;
import com.ucar.vehiclesdk.UCarCommon;
import java.io.IOException;

public class SensorManager {

    /* renamed from: a  reason: collision with root package name */
    public ConnectChannel f5444a;

    public final boolean a() {
        ConnectChannel connectChannel = this.f5444a;
        return connectChannel != null && connectChannel.p0();
    }

    public boolean b(UCarCommon.AccelerationInfo accelerationInfo) {
        if (accelerationInfo == null) {
            EasyLog.c("SensorManager", " sendAccelerationData() error");
            return false;
        } else if (!a()) {
            EasyLog.c("SensorManager", " sendAccelerationData() channel not ready, please check!");
            return false;
        } else {
            this.f5444a.O0(UCarSensorProtocol.j(UCarProto.Acceleration.newBuilder().setAccX(accelerationInfo.a()).setAccY(accelerationInfo.b()).setAccZ(accelerationInfo.c()).setTimestamp(accelerationInfo.d()).build()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("SensorManager", "sendAccelerationData failed.", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.a("SensorManager", "sendAccelerationData succeeded");
                }
            });
            return true;
        }
    }

    public boolean c(UCarCommon.BatteryInfo batteryInfo) {
        if (batteryInfo == null || !batteryInfo.d()) {
            EasyLog.c("SensorManager", "sendBatteryData() args error: " + batteryInfo);
            return false;
        } else if (!a()) {
            EasyLog.c("SensorManager", " sendBatteryData() channel not ready, please check!");
            return false;
        } else {
            this.f5444a.O0(UCarSensorProtocol.k(UCarProto.Battery.newBuilder().setMaxPower(batteryInfo.b()).setCurrentPower(batteryInfo.a()).setIsLowPower(batteryInfo.c()).build()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("SensorManager", "sendBatteryData failed.", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.a("SensorManager", "sendBatteryData succeeded");
                }
            });
            return true;
        }
    }

    public boolean d(UCarCommon.GearStateInfo gearStateInfo) {
        if (gearStateInfo == null || gearStateInfo.b() == null) {
            EasyLog.c("SensorManager", "sendGearData() args error");
            return false;
        } else if (!a()) {
            EasyLog.c("SensorManager", " sendGearData() channel not ready, please check!");
            return false;
        } else {
            this.f5444a.O0(UCarSensorProtocol.l(UCarProto.GearInfo.newBuilder().setSpeed(gearStateInfo.a()).setGear(UCarProto.GearInfo.GearState.forNumber(gearStateInfo.b().getValue())).build()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("SensorManager", "sendGearData failed.", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.a("SensorManager", "sendGearData succeeded");
                }
            });
            return true;
        }
    }

    public boolean e(UCarCommon.GPSInfo gPSInfo) {
        if (gPSInfo == null || gPSInfo.d() < -90.0d || gPSInfo.d() > 90.0d || gPSInfo.e() < -180.0d || gPSInfo.e() > 180.0d || gPSInfo.h() < 0) {
            EasyLog.c("SensorManager", " sendGpsData() args error");
            return false;
        } else if (!a()) {
            EasyLog.c("SensorManager", " sendGpsData() channel not ready, please check!");
            return false;
        } else {
            this.f5444a.O0(UCarSensorProtocol.m(UCarProto.Gps.newBuilder().setAltitude(gPSInfo.a()).setLatitude(gPSInfo.d()).setLongitude(gPSInfo.e()).setAntennaState(gPSInfo.b()).setPdop(gPSInfo.j()).setSpeed(gPSInfo.h()).setHeading(gPSInfo.c()).setSatsUsed(gPSInfo.f()).setSatsVisible(gPSInfo.g()).setTimestamp(gPSInfo.i()).build()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("SensorManager", "sendGpsData failed: ", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.a("SensorManager", "sendGpsDatao succeeded");
                }
            });
            return true;
        }
    }

    public boolean f(UCarCommon.GyroscopeInfo gyroscopeInfo) {
        if (gyroscopeInfo == null || gyroscopeInfo.b() < -180.0d || gyroscopeInfo.b() > 180.0d || gyroscopeInfo.c() < -90.0d || gyroscopeInfo.c() > 90.0d || gyroscopeInfo.d() < 0.0d || gyroscopeInfo.d() > 360.0d) {
            EasyLog.c("SensorManager", "sendGyroScopeData args error");
            return false;
        } else if (!a()) {
            EasyLog.c("SensorManager", " sendGyroScopeData() channel not ready, please check!");
            return false;
        } else {
            this.f5444a.O0(UCarSensorProtocol.n(UCarProto.GyroScope.newBuilder().setGyroType(gyroscopeInfo.a()).setLegyroX(gyroscopeInfo.b()).setLegyroY(gyroscopeInfo.c()).setLegyroZ(gyroscopeInfo.d()).setTimestamp(gyroscopeInfo.e()).build()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("SensorManager", "sendGyroScopeData failed", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.a("SensorManager", "sendGyroScopeData succeeded");
                }
            });
            return true;
        }
    }

    public boolean g(UCarCommon.LightSensorInfo lightSensorInfo) {
        if (lightSensorInfo == null || lightSensorInfo.c() < 0.0d || lightSensorInfo.b() < 0.0d || lightSensorInfo.a() < 0.0d || lightSensorInfo.a() < lightSensorInfo.c() || lightSensorInfo.a() > lightSensorInfo.b()) {
            EasyLog.c("SensorManager", "sendLightSensorInfoData() args error");
            return false;
        } else if (!a()) {
            EasyLog.c("SensorManager", " sendLightSensorInfoData() channel not ready, please check!");
            return false;
        } else {
            this.f5444a.O0(UCarSensorProtocol.o(UCarProto.LightSensorInfo.newBuilder().setMaxLux(lightSensorInfo.b()).setMinLux(lightSensorInfo.c()).setCurrentLux(lightSensorInfo.a()).build()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("SensorManager", "sendLightSensorInfoData failed.", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.a("SensorManager", "sendLightSensorInfoData succeeded");
                }
            });
            return true;
        }
    }

    public boolean h(UCarCommon.LightsInfo lightsInfo) {
        if (lightsInfo == null) {
            EasyLog.c("SensorManager", " sendLightsData() args error");
            return false;
        } else if (!a()) {
            EasyLog.c("SensorManager", " sendLightsData() channel not ready, please check!");
            return false;
        } else {
            this.f5444a.O0(UCarSensorProtocol.p(UCarProto.Lights.newBuilder().setBackupLampOn(lightsInfo.a()).setClearanceLampOn(lightsInfo.b()).setHighBeamOn(lightsInfo.c()).setLowBeamOn(lightsInfo.d()).setStopLampOn(lightsInfo.e()).build()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("SensorManager", "sendLightsData failed.", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.a("SensorManager", "sendLightsData succeeded");
                }
            });
            return true;
        }
    }

    public boolean i(UCarCommon.OilInfo oilInfo) {
        if (oilInfo == null || !oilInfo.d()) {
            EasyLog.c("SensorManager", "sendOilData() args error: " + oilInfo);
            return false;
        } else if (!a()) {
            EasyLog.c("SensorManager", " sendOilData() channel not ready, please check!");
            return false;
        } else {
            this.f5444a.O0(UCarSensorProtocol.q(UCarProto.Oil.newBuilder().setMaxFuel(oilInfo.b()).setCurrentFuel(oilInfo.a()).setIsLowFuel(oilInfo.c()).build()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("SensorManager", "sendOilData failed.", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    EasyLog.a("SensorManager", "sendOilData succeeded");
                }
            });
            return true;
        }
    }

    public void j(String str) {
        EasyLog.a("SensorManager", "SensorChannel start address:" + str);
        ConnectChannel connectChannel = this.f5444a;
        if (connectChannel == null) {
            EasyLog.c("SensorManager", "sensor channel is null");
        } else if (connectChannel.p0()) {
            EasyLog.a("SensorManager", "sensor channel server has opened");
        } else {
            try {
                this.f5444a.W0(0, str);
            } catch (IOException e) {
                EasyLog.b("SensorManager", "Start sensor channel error.", e);
            }
        }
    }

    public void k() {
        if (this.f5444a != null) {
            EasyLog.a("SensorManager", "close sensor channel");
            this.f5444a.c0();
        }
    }
}
