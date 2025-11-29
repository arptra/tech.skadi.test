package com.benjaminabel.vibration;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;

class VibrationMethodChannelHandler implements MethodChannel.MethodCallHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Vibration f2413a;

    public VibrationMethodChannelHandler(Vibration vibration) {
        this.f2413a = vibration;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1367724422:
                if (str.equals("cancel")) {
                    c = 0;
                    break;
                }
                break;
            case 86129172:
                if (str.equals("hasAmplitudeControl")) {
                    c = 1;
                    break;
                }
                break;
            case 451310959:
                if (str.equals("vibrate")) {
                    c = 2;
                    break;
                }
                break;
            case 890723587:
                if (str.equals("hasCustomVibrationsSupport")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f2413a.a().cancel();
                result.success((Object) null);
                return;
            case 1:
                result.success(Boolean.valueOf(this.f2413a.a().hasAmplitudeControl()));
                return;
            case 2:
                int intValue = ((Integer) methodCall.argument("duration")).intValue();
                List list = (List) methodCall.argument("pattern");
                int intValue2 = ((Integer) methodCall.argument("repeat")).intValue();
                List list2 = (List) methodCall.argument("intensities");
                int intValue3 = ((Integer) methodCall.argument("amplitude")).intValue();
                if (list.size() > 0 && list2.size() > 0) {
                    this.f2413a.d(list, intValue2, list2);
                } else if (list.size() > 0) {
                    this.f2413a.c(list, intValue2);
                } else {
                    this.f2413a.b((long) intValue, intValue3);
                }
                result.success((Object) null);
                return;
            case 3:
                result.success(Boolean.TRUE);
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
