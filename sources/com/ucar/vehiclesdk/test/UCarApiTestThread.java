package com.ucar.vehiclesdk.test;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import com.honey.account.l3.a;
import com.honey.account.l3.b;
import com.ucar.vehiclesdk.UCarAdapter;
import com.ucar.vehiclesdk.UCarCommon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UCarApiTestThread extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final String f5481a = UCarApiTestThread.class.getSimpleName();
    public final Context b;
    public ServerSocket c;
    public AudioManager d;
    public boolean e;
    public volatile boolean f;
    public boolean g;

    public UCarApiTestThread(Context context) {
        this.b = context;
    }

    public static /* synthetic */ boolean d(String str) {
        return !str.equals("");
    }

    public void c() {
        try {
            Log.d(this.f5481a, "close");
            this.f = false;
            this.c.close();
        } catch (IOException e2) {
            Log.d(this.f5481a, e2.getMessage(), e2);
        }
    }

    public final void f(String str) {
        List list = (List) Arrays.stream(str.split(" ")).filter(new a()).collect(Collectors.toList());
        String str2 = (String) list.get(0);
        str2.hashCode();
        char c2 = 65535;
        switch (str2.hashCode()) {
            case -1875240789:
                if (str2.equals("sendGyroscopeInfo")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1721692936:
                if (str2.equals("sendOilInfo")) {
                    c2 = 1;
                    break;
                }
                break;
            case -970604592:
                if (str2.equals("sendGPSInfo")) {
                    c2 = 2;
                    break;
                }
                break;
            case -742323277:
                if (str2.equals("sendBatteryInfo")) {
                    c2 = 3;
                    break;
                }
                break;
            case -247303947:
                if (str2.equals("deletePhoneById")) {
                    c2 = 4;
                    break;
                }
                break;
            case 17356374:
                if (str2.equals("sendVRCMD")) {
                    c2 = 5;
                    break;
                }
                break;
            case 317077362:
                if (str2.equals("notifyIsCallHungUp")) {
                    c2 = 6;
                    break;
                }
                break;
            case 523235574:
                if (str2.equals("sendAccelerationInfo")) {
                    c2 = 7;
                    break;
                }
                break;
            case 530405532:
                if (str2.equals("disconnect")) {
                    c2 = 8;
                    break;
                }
                break;
            case 773108378:
                if (str2.equals("sendMicRecordData")) {
                    c2 = 9;
                    break;
                }
                break;
            case 899494691:
                if (str2.equals("sendKeyEvent")) {
                    c2 = 10;
                    break;
                }
                break;
            case 1620374646:
                if (str2.equals("notifySwitchDayOrNight")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1625622965:
                if (str2.equals("awakenVoiceAssistant")) {
                    c2 = 12;
                    break;
                }
                break;
            case 1767202969:
                if (str2.equals("sendGotoBackground")) {
                    c2 = 13;
                    break;
                }
                break;
            case 1873273192:
                if (str2.equals("sendGearStateInfo")) {
                    c2 = 14;
                    break;
                }
                break;
            case 1936183827:
                if (str2.equals("sendLightsInfo")) {
                    c2 = 15;
                    break;
                }
                break;
            case 1937757334:
                if (str2.equals("sendLightSensorInfo")) {
                    c2 = 16;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                UCarAdapter.R0().h2(new UCarCommon.GyroscopeInfo(Integer.parseInt((String) list.get(1)), Double.parseDouble((String) list.get(2)), Double.parseDouble((String) list.get(3)), Double.parseDouble((String) list.get(4)), System.currentTimeMillis()));
                break;
            case 1:
                UCarAdapter.R0().m2(new UCarCommon.OilInfo(Integer.parseInt((String) list.get(1)), Integer.parseInt((String) list.get(2)), Boolean.parseBoolean((String) list.get(3))));
                break;
            case 2:
                UCarAdapter.R0().f2(new UCarCommon.GPSInfo(Double.parseDouble((String) list.get(1)), Double.parseDouble((String) list.get(2)), Double.parseDouble((String) list.get(3)), Integer.parseInt((String) list.get(4)), Integer.parseInt((String) list.get(5)), Integer.parseInt((String) list.get(6)), Integer.parseInt((String) list.get(7)), Integer.parseInt((String) list.get(8)), Integer.parseInt((String) list.get(9)), System.currentTimeMillis()));
                break;
            case 3:
                UCarAdapter.R0().d2((UCarCommon.BatteryInfo) null);
                break;
            case 4:
                UCarAdapter.N0(this.b, (String) list.get(1));
                break;
            case 5:
                UCarAdapter.R0().o2(UCarCommon.VRCmdType.fromInt(Integer.parseInt((String) list.get(1))), (String) list.get(2));
                break;
            case 6:
                UCarAdapter.R0().K1();
                break;
            case 7:
                UCarAdapter.R0().c2(new UCarCommon.AccelerationInfo(Double.parseDouble((String) list.get(1)), Double.parseDouble((String) list.get(2)), Double.parseDouble((String) list.get(3)), System.currentTimeMillis()));
                break;
            case 8:
                UCarAdapter.R0().O0();
                break;
            case 9:
                List list2 = (List) list.subList(2, list.size()).stream().map(new b()).collect(Collectors.toList());
                short[] sArr = new short[list2.size()];
                for (int i = 0; i < list2.size(); i++) {
                    sArr[i] = ((Short) list2.get(i)).shortValue();
                }
                h();
                UCarAdapter.R0().l2(Integer.parseInt((String) list.get(1)), sArr, System.currentTimeMillis());
                g();
                break;
            case 10:
                UCarAdapter.R0().i2(UCarCommon.KeyEventActionType.fromInt(Integer.parseInt((String) list.get(1))), UCarCommon.KeyCodeType.fromInt(Integer.parseInt((String) list.get(2))), 0);
                break;
            case 11:
                UCarAdapter.R0().Q1(UCarCommon.DayNightMode.fromInt(Integer.parseInt((String) list.get(1))));
                break;
            case 12:
                UCarAdapter.R0().K0(((String) list.get(5)).getBytes(StandardCharsets.UTF_8), new UCarCommon.AudioFormat(String.valueOf(list.get(1)), Integer.parseInt((String) list.get(2)), Integer.parseInt((String) list.get(3)), Integer.parseInt((String) list.get(4))), (String) list.get(6));
                break;
            case 13:
                UCarAdapter.R0().Y1();
                break;
            case 14:
                UCarAdapter.R0().g2(new UCarCommon.GearStateInfo(UCarCommon.GearState.fromInt(Integer.parseInt((String) list.get(1))), Integer.parseInt((String) list.get(2))));
                break;
            case 15:
                UCarAdapter.R0().k2(new UCarCommon.LightsInfo(Boolean.parseBoolean((String) list.get(1)), Boolean.parseBoolean((String) list.get(2)), Boolean.parseBoolean((String) list.get(3)), Boolean.parseBoolean((String) list.get(4)), Boolean.parseBoolean((String) list.get(5))));
                break;
            case 16:
                UCarAdapter.R0().j2(new UCarCommon.LightSensorInfo(Double.parseDouble((String) list.get(1)), Double.parseDouble((String) list.get(2)), Double.parseDouble((String) list.get(3))));
                break;
            default:
                Log.d(this.f5481a, "parse API failed, please check sender, api:" + str2);
                Log.d(this.f5481a, str2 + " execute failed");
                return;
        }
        Log.d(this.f5481a, str2 + " executed");
    }

    public final void g() {
        if (!this.g) {
            this.d.setMicrophoneMute(false);
        }
    }

    public final void h() {
        AudioManager audioManager = (AudioManager) this.b.getSystemService("audio");
        this.d = audioManager;
        this.g = audioManager.isMicrophoneMute();
        this.d.setMicrophoneMute(true);
    }

    public final void i() {
        Socket accept;
        InputStream inputStream;
        String str;
        String message;
        BufferedReader bufferedReader;
        try {
            this.c = new ServerSocket(54321);
            this.f = true;
            while (this.f) {
                accept = this.c.accept();
                inputStream = accept.getInputStream();
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        Log.d(this.f5481a, "waiting for in socket");
                        String str2 = "";
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            String str3 = this.f5481a;
                            Log.d(str3, "received: " + readLine);
                            str2 = readLine;
                        }
                        bufferedReader.close();
                        inputStreamReader.close();
                        inputStream.close();
                        accept.close();
                        f(str2);
                        bufferedReader.close();
                        inputStreamReader.close();
                        try {
                            inputStream.close();
                            accept.close();
                        } catch (IOException e2) {
                            e = e2;
                            str = this.f5481a;
                            message = e.getMessage();
                            Log.e(str, message, e);
                        }
                    } catch (Throwable th) {
                        inputStreamReader.close();
                        throw th;
                    }
                } catch (Exception e3) {
                    Log.e(this.f5481a, e3.getMessage(), e3);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e = e4;
                            str = this.f5481a;
                            message = e.getMessage();
                            Log.e(str, message, e);
                        }
                    }
                    accept.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            Log.d(this.f5481a, "service stoped");
            return;
            throw th;
        } catch (Exception e5) {
            Log.e(this.f5481a, e5.getMessage(), e5);
        } catch (Throwable th3) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    Log.e(this.f5481a, e6.getMessage(), e6);
                    throw th3;
                }
            }
            accept.close();
            throw th3;
        }
    }

    public void run() {
        if (!this.e) {
            this.e = true;
            i();
            return;
        }
        Log.d(this.f5481a, "is Running, ignore");
    }
}
