package com.ucar.vehiclesdk;

import android.util.Range;
import android.util.Size;
import com.ucar.databus.proto.UCarProto;
import com.ucar.protocol.UCarWorkMode;
import com.ucar.vehiclesdk.player.MediaSessionProvider;
import java.util.ArrayList;

public class UCarCommon {

    public static class AccelerationInfo {

        /* renamed from: a  reason: collision with root package name */
        public double f5368a;
        public double b;
        public double c;
        public long d;

        public AccelerationInfo(double d2, double d3, double d4, long j) {
            this.f5368a = d2;
            this.b = d3;
            this.c = d4;
            this.d = j;
        }

        public double a() {
            return this.f5368a;
        }

        public double b() {
            return this.b;
        }

        public double c() {
            return this.c;
        }

        public long d() {
            return this.d;
        }
    }

    public enum AppCategory {
        MAP,
        MEDIA,
        VIDEO,
        IM,
        NEWS,
        GAME,
        SHOPPING,
        TRAVEL,
        FINANCIAL,
        MEETING,
        TOOL,
        OFFICE,
        EDUCATION,
        HEALTHY,
        SYSTEM,
        LIFE,
        SMART_SERVICE,
        OTHER
    }

    public static class AppDetailInfo {

        /* renamed from: a  reason: collision with root package name */
        public AppGeneralInfo f5369a;
        public String b;
        public byte[] c;
        public boolean d;
        public boolean e;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("generaIInfo: ");
            sb.append(this.f5369a);
            sb.append(", packageName: ");
            sb.append(this.b);
            sb.append(", iconLength: ");
            byte[] bArr = this.c;
            sb.append(bArr == null ? 0 : bArr.length);
            sb.append(", isSupportLandscape: ");
            sb.append(this.d);
            sb.append(", isSupportPortrait: ");
            sb.append(this.e);
            return sb.toString();
        }
    }

    public static class AppGeneralInfo {

        /* renamed from: a  reason: collision with root package name */
        public int f5370a;
        public String b;
        public AppCategory c;

        public String toString() {
            return "appId: " + this.f5370a + ", label: " + this.b + ", category: " + this.c;
        }
    }

    public enum AppListState {
        INSTALLED,
        REMOVED,
        UPDATED,
        REORDERED
    }

    public enum AppState {
        STARTED,
        STOPPED,
        PAUSED,
        RESUMED,
        DESTROYED
    }

    public static class AudioAttributes {

        /* renamed from: a  reason: collision with root package name */
        public final android.media.AudioAttributes f5371a;
        public final android.media.AudioAttributes b;
        public final int c;
        public final int d;
        public final boolean e;
        public final int f;
        public final boolean g;
        public final int h;

        public AudioAttributes(android.media.AudioAttributes audioAttributes, int i, int i2) {
            this.f5371a = audioAttributes;
            this.b = audioAttributes;
            this.c = i;
            this.d = i2;
            boolean z = true;
            boolean z2 = audioAttributes.getUsage() == 2;
            this.e = z2;
            if (z2) {
                this.f = MediaSessionProvider.d();
            } else {
                this.f = 0;
            }
            if (!(audioAttributes.getUsage() == 11 || audioAttributes.getUsage() == 16)) {
                z = false;
            }
            this.g = z;
            if (z) {
                this.h = MediaSessionProvider.c();
            } else {
                this.h = 0;
            }
        }

        public int a() {
            return this.h;
        }

        public android.media.AudioAttributes b() {
            return this.f5371a;
        }

        public android.media.AudioAttributes c() {
            return this.b;
        }

        public int d() {
            return this.f;
        }

        public int e() {
            return this.c;
        }

        public boolean f() {
            return this.g;
        }

        public boolean g() {
            return this.e;
        }

        public String toString() {
            return "audioAttributes: " + this.f5371a + ", focusAudioAttributes: " + this.b + ", focusGain: " + this.c + ", streamType: " + this.d + ", isCallUsage: " + this.e + ", callSessionId: " + this.f + ", isAiUsage: " + this.g + ", aiSessionId: " + this.h;
        }
    }

    public static class AudioFormat {

        /* renamed from: a  reason: collision with root package name */
        public String f5372a;
        public int b;
        public int c;
        public int d;

        public AudioFormat(String str, int i, int i2, int i3) {
            this.f5372a = str;
            this.b = i2;
            this.c = i3;
            this.d = i;
        }

        public int a() {
            return this.c;
        }

        public int b() {
            return this.d;
        }

        public String c() {
            return this.f5372a;
        }

        public int d() {
            return this.b;
        }

        public String toString() {
            return "mimeType: " + this.f5372a + ", sampleRate: " + this.b + ", channelConfig: " + this.c + ", encodingFormat: " + this.d;
        }
    }

    public enum AudioType {
        STREAM_UNDEFINED(0),
        STREAM_IP_CALL(1),
        STREAM_MODEM_CALL(2),
        STREAM_AI_ASSISTANT(3),
        STREAM_RING(4),
        STREAM_NOTIFICATION(5),
        STREAM_TTS(6),
        STREAM_SYSTEM(7),
        STREAM_CAST_MUSIC(16);
        
        private static AudioType[] values;
        private final int value;

        static {
            values = null;
        }

        private AudioType(int i) {
            this.value = i;
        }

        public static AudioType fromInt(int i) {
            if (values == null) {
                values = values();
            }
            int i2 = 0;
            while (true) {
                AudioType[] audioTypeArr = values;
                if (i2 >= audioTypeArr.length) {
                    return STREAM_UNDEFINED;
                }
                AudioType audioType = audioTypeArr[i2];
                if (audioType.value == i) {
                    return audioType;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class BatteryInfo {

        /* renamed from: a  reason: collision with root package name */
        public int f5373a;
        public int b;
        public boolean c;

        public int a() {
            return this.b;
        }

        public int b() {
            return this.f5373a;
        }

        public boolean c() {
            return this.c;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r1 = r1.b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean d() {
            /*
                r1 = this;
                int r0 = r1.f5373a
                if (r0 < 0) goto L_0x000c
                int r1 = r1.b
                if (r1 < 0) goto L_0x000c
                if (r0 < r1) goto L_0x000c
                r1 = 1
                goto L_0x000d
            L_0x000c:
                r1 = 0
            L_0x000d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.UCarCommon.BatteryInfo.d():boolean");
        }

        public String toString() {
            return "BatteryInfo{maxPower=" + this.f5373a + ", currentPower=" + this.b + ", isLowPower=" + this.c + '}';
        }
    }

    public static class BluetoothMacInfo {

        /* renamed from: a  reason: collision with root package name */
        public OPType f5374a;
        public String b;

        public BluetoothMacInfo(OPType oPType, String str) {
            this.f5374a = oPType;
            this.b = str;
        }

        public String a() {
            return this.b;
        }

        public OPType b() {
            return this.f5374a;
        }
    }

    public static class CallInfo {

        /* renamed from: a  reason: collision with root package name */
        public CallState f5375a;
        public String b;
        public String c;
        public boolean d;
        public int e;
        public boolean f;
        public int g;

        public CallInfo(CallState callState, String str, String str2, boolean z, int i, boolean z2, int i2) {
            this.f5375a = callState;
            this.b = str;
            this.c = str2;
            this.d = z;
            this.e = i;
            this.f = z2;
            this.g = i2;
        }

        public String toString() {
            return "callState: " + this.f5375a + ", number: " + this.b + ", name: " + this.c + ", isIPCall: " + this.d + ", connectedTime: " + this.e + ", isNeedShowFloatingWindow: " + this.f + ", inCallAppId: " + this.g;
        }
    }

    public enum CallState {
        UNKNOWN_STATE(0),
        IDLE(1),
        INCOMING(2),
        DIALING(3),
        ALERTING(4),
        ACTIVE(5),
        HOLDING(6);
        
        private static CallState[] values;
        private final int value;

        static {
            values = null;
        }

        private CallState(int i) {
            this.value = i;
        }

        public static CallState fromInt(int i) {
            if (values == null) {
                values = values();
            }
            int i2 = 0;
            while (true) {
                CallState[] callStateArr = values;
                if (i2 >= callStateArr.length) {
                    return UNKNOWN_STATE;
                }
                CallState callState = callStateArr[i2];
                if (callState.value == i) {
                    return callState;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum CameraAction {
        CAMERA_OPEN(0),
        CAMERA_CAPTURE(1),
        CAMERA_CLOSE(2),
        CAMERA_UNDEFINE(3);
        
        private int value;

        private CameraAction(int i) {
            this.value = i;
        }

        public static CameraAction fromInt(int i) {
            return i != 0 ? i != 1 ? i != 2 ? CAMERA_UNDEFINE : CAMERA_CLOSE : CAMERA_CAPTURE : CAMERA_OPEN;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class CameraActionArgs {

        /* renamed from: a  reason: collision with root package name */
        public String f5376a;
        public Range b;
        public Size c;

        public CameraActionArgs(String str, Range range, Size size) {
            this.f5376a = str;
            this.b = range;
            this.c = size;
        }

        public String a() {
            return this.f5376a;
        }

        public Range b() {
            return this.b;
        }

        public Size c() {
            return this.c;
        }
    }

    public static class CameraInfo {

        /* renamed from: a  reason: collision with root package name */
        public String f5377a;
        public String b;
        public LensFacing c;
        public Orientation d;
        public Size[] e;
        public Range[] f;

        public CameraInfo(String str, String str2, LensFacing lensFacing, Orientation orientation, Size[] sizeArr, Range[] rangeArr) {
            this.f5377a = str;
            this.b = str2;
            this.c = lensFacing;
            this.d = orientation;
            this.e = sizeArr;
            this.f = rangeArr;
        }

        public Range[] a() {
            return this.f;
        }

        public String b() {
            return this.f5377a;
        }

        public LensFacing c() {
            return this.c;
        }

        public String d() {
            return this.b;
        }

        public Size[] e() {
            return this.e;
        }
    }

    public enum CameraState {
        CAMERA_STATE_OPENED(0),
        CAMERA_STATE_CLOSED(1),
        CAMERA_STATE_ERROR(2),
        CAMERA_STATE_PREEMPTED(3),
        CAMERA_STATE_NO_PERMISSION(4),
        CAMERA_STATE_BUSY(5),
        CAMERA_STATE_UNDEFINE(6);
        
        private int mValue;

        private CameraState(int i) {
            this.mValue = i;
        }

        public static CameraState fromInt(int i) {
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? CAMERA_STATE_UNDEFINE : CAMERA_STATE_BUSY : CAMERA_STATE_NO_PERMISSION : CAMERA_STATE_PREEMPTED : CAMERA_STATE_ERROR : CAMERA_STATE_CLOSED : CAMERA_STATE_OPENED;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public enum CoordinateType {
        WGS84(0),
        GCJ02(1),
        BD09(2);
        
        private static CoordinateType[] values;
        private final int mValue;

        static {
            values = null;
        }

        private CoordinateType(int i) {
            this.mValue = i;
        }

        public static CoordinateType fromType(int i) {
            if (values == null) {
                values = values();
            }
            int i2 = 0;
            while (true) {
                CoordinateType[] coordinateTypeArr = values;
                if (i2 >= coordinateTypeArr.length) {
                    return null;
                }
                CoordinateType coordinateType = coordinateTypeArr[i2];
                if (coordinateType.mValue == i) {
                    return coordinateType;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public enum DayNightMode {
        UNKNOWN_MODE(0),
        DAY_MODE(1),
        NIGHT_MODE(2);
        
        private static DayNightMode[] values;
        private final int value;

        static {
            values = null;
        }

        private DayNightMode(int i) {
            this.value = i;
        }

        public static DayNightMode fromInt(int i) {
            if (values == null) {
                values = values();
            }
            int i2 = 0;
            while (true) {
                DayNightMode[] dayNightModeArr = values;
                if (i2 >= dayNightModeArr.length) {
                    return UNKNOWN_MODE;
                }
                DayNightMode dayNightMode = dayNightModeArr[i2];
                if (dayNightMode.value == i) {
                    return dayNightMode;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum DisplayMode {
        PORTRAIT_WINDOW(0),
        LANDSCAPE_WINDOW(1),
        PORTRAIT_FULLSCREEN(2),
        LANDSCAPE_FULLSCREEN(3);
        
        private static DisplayMode[] values;
        private final int mode;

        static {
            values = null;
        }

        private DisplayMode(int i) {
            this.mode = i;
        }

        public static DisplayMode from(int i) {
            if (values == null) {
                values = values();
            }
            for (DisplayMode displayMode : values) {
                if (displayMode.mode == i) {
                    return displayMode;
                }
            }
            return null;
        }

        public int getMode() {
            return this.mode;
        }

        public boolean isFullScreen() {
            int i = this.mode;
            return i == PORTRAIT_FULLSCREEN.mode || i == LANDSCAPE_FULLSCREEN.mode;
        }

        public boolean isWindow() {
            int i = this.mode;
            return i == PORTRAIT_WINDOW.mode || i == LANDSCAPE_WINDOW.mode;
        }
    }

    public static class GPSInfo {

        /* renamed from: a  reason: collision with root package name */
        public double f5378a;
        public double b;
        public double c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public long j;

        public GPSInfo(double d2, double d3, double d4, int i2, int i3, int i4, int i5, int i6, int i7, long j2) {
            this.f5378a = d2;
            this.b = d3;
            this.c = d4;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
            this.i = i7;
            this.j = j2;
        }

        public double a() {
            return this.f5378a;
        }

        public int b() {
            return this.d;
        }

        public int c() {
            return this.g;
        }

        public double d() {
            return this.b;
        }

        public double e() {
            return this.c;
        }

        public int f() {
            return this.h;
        }

        public int g() {
            return this.i;
        }

        public int h() {
            return this.f;
        }

        public long i() {
            return this.j;
        }

        public int j() {
            return this.e;
        }
    }

    public enum GearState {
        GEAR_UNKNOWN(0),
        GEAR_PARK(1),
        GEAR_DRIVE(2),
        GEAR_REVERSE(3),
        GEAR_NEUTRAL(4);
        
        private static GearState[] values;
        private final int value;

        static {
            values = null;
        }

        private GearState(int i) {
            this.value = i;
        }

        public static GearState fromInt(int i) {
            if (values == null) {
                values = values();
            }
            int i2 = 0;
            while (true) {
                GearState[] gearStateArr = values;
                if (i2 >= gearStateArr.length) {
                    return GEAR_UNKNOWN;
                }
                GearState gearState = gearStateArr[i2];
                if (gearState.value == i) {
                    return gearState;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class GearStateInfo {

        /* renamed from: a  reason: collision with root package name */
        public GearState f5379a;
        public int b;

        public GearStateInfo(GearState gearState, int i) {
            this.f5379a = gearState;
            this.b = i;
        }

        public int a() {
            return this.b;
        }

        public GearState b() {
            GearState gearState = this.f5379a;
            return gearState != null ? gearState : GearState.GEAR_UNKNOWN;
        }
    }

    public static class GyroscopeInfo {

        /* renamed from: a  reason: collision with root package name */
        public int f5380a;
        public double b;
        public double c;
        public double d;
        public long e;

        public GyroscopeInfo(int i, double d2, double d3, double d4, long j) {
            this.f5380a = i;
            this.b = d2;
            this.c = d3;
            this.d = d4;
            this.e = j;
        }

        public int a() {
            return this.f5380a;
        }

        public double b() {
            return this.b;
        }

        public double c() {
            return this.c;
        }

        public double d() {
            return this.d;
        }

        public long e() {
            return this.e;
        }
    }

    public enum KeyCodeType {
        KEY_CODE_UNDEFINED(0),
        KEY_CODE_BACK(4),
        KEY_CODE_CALL(5),
        KEY_CODE_ENDCALL(6),
        KEY_CODE_NUM_0(7),
        KEY_CODE_NUM_1(8),
        KEY_CODE_NUM_2(9),
        KEY_CODE_NUM_3(10),
        KEY_CODE_NUM_4(11),
        KEY_CODE_NUM_5(12),
        KEY_CODE_NUM_6(13),
        KEY_CODE_NUM_7(14),
        KEY_CODE_NUM_8(15),
        KEY_CODE_NUM_9(16),
        KEY_CODE_DPAD_UP(19),
        KEY_CODE_DPAD_DOWN(20),
        KEY_CODE_DPAD_LEFT(21),
        KEY_CODE_DPAD_RIGHT(22),
        KEY_CODE_DPAD_CENTER(23),
        KEY_CODE_ENTER(66),
        KEY_CODE_MEDIA_NEXT(87),
        KEY_CODE_MEDIA_PREVIOUS(88),
        KEY_CODE_MIC_MUTE(91),
        KEY_CODE_PAGE_UP(92),
        KEY_CODE_PAGE_DOWN(93),
        KEY_CODE_MEDIA_PLAY(126),
        KEY_CODE_MEDIA_PAUSE(127),
        KEY_CODE_VOLUME_MUTE(164),
        KEY_CODE_ANDROID_DIVIDE_MARK(7936),
        KEY_CODE_MAIN(UCarProto.CustomKeyEvent.KeyCode.KEY_CODE_MAIN_VALUE),
        KEY_CODE_TEL(UCarProto.CustomKeyEvent.KeyCode.KEY_CODE_TEL_VALUE),
        KEY_CODE_NAVI(UCarProto.CustomKeyEvent.KeyCode.KEY_CODE_NAVI_VALUE),
        KEY_CODE_MEDIA(UCarProto.CustomKeyEvent.KeyCode.KEY_CODE_MEDIA_VALUE),
        KEY_CODE_VR_START(UCarProto.CustomKeyEvent.KeyCode.KEY_CODE_VR_START_VALUE),
        KEY_CODE_VR_STOP(UCarProto.CustomKeyEvent.KeyCode.KEY_CODE_VR_STOP_VALUE),
        KEY_CODE_NAVI_QUIT(UCarProto.CustomKeyEvent.KeyCode.KEY_CODE_NAVI_QUIT_VALUE),
        KEY_CODE_NEXT_FOCUS(UCarProto.CustomKeyEvent.KeyCode.KEY_CODE_NEXT_FOCUS_VALUE),
        KEY_CODE_PRE_FOCUS(UCarProto.CustomKeyEvent.KeyCode.KEY_CODE_PRE_FOCUS_VALUE),
        KEY_CODE_IN_FOCUS(UCarProto.CustomKeyEvent.KeyCode.KEY_CODE_IN_FOCUS_VALUE),
        KEY_CODE_OUT_FOCUS(UCarProto.CustomKeyEvent.KeyCode.KEY_CODE_OUT_FOCUS_VALUE),
        KEY_CODE_MEDIA_FAVOR(UCarProto.CustomKeyEvent.KeyCode.KEY_CODE_MEDIA_FAVOR_VALUE);
        
        private static KeyCodeType[] values;
        private final int value;

        static {
            values = null;
        }

        private KeyCodeType(int i) {
            this.value = i;
        }

        public static KeyCodeType fromInt(int i) {
            if (values == null) {
                values = values();
            }
            int i2 = 0;
            while (true) {
                KeyCodeType[] keyCodeTypeArr = values;
                if (i2 >= keyCodeTypeArr.length) {
                    return KEY_CODE_UNDEFINED;
                }
                KeyCodeType keyCodeType = keyCodeTypeArr[i2];
                if (keyCodeType.value == i) {
                    return keyCodeType;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum KeyEventActionType {
        KEY_EVENT_ACTION_UNDEFINED(-1),
        KEY_EVENT_ACTION_DOWN(0),
        KEY_EVENT_ACTION_UP(1),
        KEY_EVENT_ACTION_PRESS(2);
        
        private static KeyEventActionType[] values;
        private final int value;

        static {
            values = null;
        }

        private KeyEventActionType(int i) {
            this.value = i;
        }

        public static KeyEventActionType fromInt(int i) {
            if (values == null) {
                values = values();
            }
            int i2 = 0;
            while (true) {
                KeyEventActionType[] keyEventActionTypeArr = values;
                if (i2 >= keyEventActionTypeArr.length) {
                    return KEY_EVENT_ACTION_UNDEFINED;
                }
                KeyEventActionType keyEventActionType = keyEventActionTypeArr[i2];
                if (keyEventActionType.value == i) {
                    return keyEventActionType;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum LensFacing {
        LENS_FACING_FRONT(0),
        LENS_FACING_BACK(1),
        LENS_FACING_EXTERNAL(2);
        
        private static LensFacing[] values;
        private final int value;

        static {
            values = null;
        }

        private LensFacing(int i) {
            this.value = i;
        }

        public static LensFacing fromInt(int i) {
            if (values == null) {
                values = values();
            }
            int i2 = 0;
            while (true) {
                LensFacing[] lensFacingArr = values;
                if (i2 >= lensFacingArr.length) {
                    return LENS_FACING_FRONT;
                }
                LensFacing lensFacing = lensFacingArr[i2];
                if (lensFacing.value == i) {
                    return lensFacing;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class LightSensorInfo {

        /* renamed from: a  reason: collision with root package name */
        public double f5381a;
        public double b;
        public double c;

        public LightSensorInfo(double d, double d2, double d3) {
            this.f5381a = d;
            this.b = d2;
            this.c = d3;
        }

        public double a() {
            return this.c;
        }

        public double b() {
            return this.f5381a;
        }

        public double c() {
            return this.b;
        }
    }

    public static class LightsInfo {

        /* renamed from: a  reason: collision with root package name */
        public boolean f5382a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;

        public LightsInfo(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
            this.f5382a = z;
            this.b = z2;
            this.c = z3;
            this.d = z4;
            this.e = z5;
        }

        public boolean a() {
            return this.d;
        }

        public boolean b() {
            return this.c;
        }

        public boolean c() {
            return this.b;
        }

        public boolean d() {
            return this.f5382a;
        }

        public boolean e() {
            return this.e;
        }
    }

    public static class MobileDevice {

        /* renamed from: a  reason: collision with root package name */
        public final String f5383a;
        public final String b;
        public final String c;
        public final byte[] d;
        public final String e;
        public final int f;

        public MobileDevice(String str, String str2, String str3, byte[] bArr, String str4, int i) {
            this.f5383a = str;
            this.b = str2;
            this.c = str3;
            this.d = bArr;
            this.e = str4;
            this.f = i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("id: ");
            sb.append(this.f5383a);
            sb.append(", productName: ");
            sb.append(this.b);
            sb.append(", productIconName: ");
            sb.append(this.c);
            sb.append(", productIconLength: ");
            byte[] bArr = this.d;
            sb.append(bArr == null ? 0 : bArr.length);
            sb.append(", model: ");
            sb.append(this.e);
            sb.append(", connectType: ");
            sb.append(this.f);
            return sb.toString();
        }
    }

    public static class MusicInfo {

        /* renamed from: a  reason: collision with root package name */
        public String f5384a;
        public String b;
        public String c;
        public String d;
        public long e;
        public String f;
        public String g;
        public String h;
        public String i;
        public int j;
        public boolean k;
        public boolean l;
        public byte[] m;
        public boolean n;
        public int o;

        public MusicInfo(String str, String str2, String str3, String str4, long j2, String str5, String str6, String str7, String str8, int i2, boolean z, boolean z2) {
            this.f5384a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = j2;
            this.f = str5;
            this.g = str6;
            this.h = str7;
            this.i = str8;
            this.j = i2;
            this.k = z;
            this.l = z2;
        }

        public void a(int i2) {
            this.o = i2;
        }

        public void b(byte[] bArr) {
            this.m = bArr;
        }

        public void c(boolean z) {
            this.n = z;
        }

        public boolean d(boolean z) {
            this.k = z;
            return z;
        }

        public void e(String str) {
            this.d = str;
        }

        public void f(boolean z) {
            this.l = z;
        }

        public void g(int i2) {
            this.j = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("artist: ");
            sb.append(this.f5384a);
            sb.append(", album: ");
            sb.append(this.b);
            sb.append(", coverArt: ");
            sb.append(this.c);
            sb.append(", coverLength: ");
            byte[] bArr = this.m;
            sb.append(bArr == null ? 0 : bArr.length);
            sb.append(", lyrics: ");
            sb.append(this.d);
            sb.append(", totalTimeMs: ");
            sb.append(this.e);
            sb.append(", tile: ");
            sb.append(this.f);
            sb.append(", author: ");
            sb.append(this.g);
            sb.append(", writer: ");
            sb.append(this.h);
            sb.append(", composer: ");
            sb.append(this.i);
            sb.append(", currentTimeMs: ");
            sb.append(this.j);
            sb.append(", isFavorite: ");
            sb.append(this.k);
            sb.append(", isPlaying: ");
            sb.append(this.l);
            sb.append(", isDestroyed: ");
            sb.append(this.n);
            sb.append(", id: ");
            sb.append(this.o);
            return sb.toString();
        }
    }

    public static class NavigationInfo {

        /* renamed from: a  reason: collision with root package name */
        public boolean f5385a;
        public byte[] b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public int i;

        public NavigationInfo(boolean z, byte[] bArr, String str, String str2, String str3, String str4, String str5, String str6, int i2) {
            this.f5385a = z;
            this.b = bArr;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = str6;
            this.i = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("isNavigating: ");
            sb.append(this.f5385a);
            sb.append(", directionIconLength: ");
            byte[] bArr = this.b;
            sb.append(bArr == null ? 0 : bArr.length);
            sb.append(", distance: ");
            sb.append(this.c);
            sb.append(", distanceUnit: ");
            sb.append(this.d);
            sb.append(", operation: ");
            sb.append(this.e);
            sb.append(", where: ");
            sb.append(this.f);
            sb.append(", title1: ");
            sb.append(this.g);
            sb.append(", title2: ");
            sb.append(this.h);
            sb.append(", appId: ");
            sb.append(this.i);
            return sb.toString();
        }
    }

    public enum OPType {
        OP_ADD(0),
        OP_DELETE(1);
        
        private static OPType[] values;
        private final int mValue;

        static {
            values = null;
        }

        private OPType(int i) {
            this.mValue = i;
        }

        public static OPType fromType(int i) {
            if (values == null) {
                values = values();
            }
            int i2 = 0;
            while (true) {
                OPType[] oPTypeArr = values;
                if (i2 >= oPTypeArr.length) {
                    return OP_ADD;
                }
                OPType oPType = oPTypeArr[i2];
                if (oPType.mValue == i) {
                    return oPType;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public static class OilInfo {

        /* renamed from: a  reason: collision with root package name */
        public int f5386a;
        public int b;
        public boolean c;

        public OilInfo(int i, int i2, boolean z) {
            this.f5386a = i;
            this.b = i2;
            this.c = z;
        }

        public int a() {
            return this.b;
        }

        public int b() {
            return this.f5386a;
        }

        public boolean c() {
            return this.c;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r1 = r1.b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean d() {
            /*
                r1 = this;
                int r0 = r1.f5386a
                if (r0 < 0) goto L_0x000c
                int r1 = r1.b
                if (r1 < 0) goto L_0x000c
                if (r0 < r1) goto L_0x000c
                r1 = 1
                goto L_0x000d
            L_0x000c:
                r1 = 0
            L_0x000d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ucar.vehiclesdk.UCarCommon.OilInfo.d():boolean");
        }

        public String toString() {
            return "OilInfo{maxFuel=" + this.f5386a + ", currentFuel=" + this.b + ", isLowFuel=" + this.c + '}';
        }
    }

    public enum Orientation {
        ORIENTATION_UNKNOWN(-1),
        ORIENTATION_0(0),
        ORIENTATION_90(90),
        ORIENTATION_180(180),
        ORIENTATION_270(UCarProto.Orientation.ORIENTATION_270_VALUE);
        
        private static Orientation[] values;
        private final int value;

        static {
            values = null;
        }

        private Orientation(int i) {
            this.value = i;
        }

        public static Orientation fromInt(int i) {
            if (values == null) {
                values = values();
            }
            int i2 = 0;
            while (true) {
                Orientation[] orientationArr = values;
                if (i2 >= orientationArr.length) {
                    return ORIENTATION_UNKNOWN;
                }
                Orientation orientation = orientationArr[i2];
                if (orientation.value == i) {
                    return orientation;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class POIAddress {

        /* renamed from: a  reason: collision with root package name */
        public String f5387a = null;
        public String b;
        public POIDetailInfo c = null;

        public POIAddress(String str) {
            this.b = str;
        }

        public void a(String str) {
            this.f5387a = str;
        }

        public void b(POIDetailInfo pOIDetailInfo) {
            this.c = pOIDetailInfo;
        }

        public String toString() {
            return "address: " + this.f5387a + ", name: " + this.b + ", detailInfo: " + this.c;
        }
    }

    public static class POIDetailInfo {

        /* renamed from: a  reason: collision with root package name */
        public CoordinateType f5388a;
        public double b;
        public double c;
        public double d = 0.0d;

        public POIDetailInfo(CoordinateType coordinateType, double d2, double d3) {
            this.f5388a = coordinateType;
            this.b = d2;
            this.c = d3;
        }

        public void a(double d2) {
            this.d = d2;
        }

        public String toString() {
            return "type: " + this.f5388a + ", latitude: " + this.b + ", longitude: " + this.c + ", altitude: " + this.d;
        }
    }

    public static class PhoneStateInfo {

        /* renamed from: a  reason: collision with root package name */
        public CallState f5389a = CallState.IDLE;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;

        public CallState a() {
            return this.f5389a;
        }

        public boolean b() {
            return this.e;
        }

        public boolean c() {
            return this.c;
        }

        public void d(boolean z) {
            this.f = z;
        }

        public void e(CallState callState) {
            this.f5389a = callState;
        }

        public void f(boolean z) {
            this.g = z;
        }

        public void g(boolean z) {
            this.b = z;
        }

        public void h(boolean z) {
            this.d = z;
        }

        public void i(boolean z) {
            this.e = z;
        }

        public void j(boolean z) {
            this.c = z;
        }

        public String toString() {
            return "callState: " + this.f5389a + ", isScreenLocked: " + this.b + ", isVoipCall: " + this.c + ", isUseMicrophone: " + this.d + ", isVoiceAssistantActive: " + this.e + ", isLowPower: " + this.f + ", isOverheat: " + this.g;
        }
    }

    public enum VRCmdType {
        VR_CMD_UNDEFINED(0),
        VR_CMD_MUSIC_PRE(1),
        VR_CMD_MUSIC_NEXT(2),
        VR_CMD_MUSIC_PAUSE(3),
        VR_CMD_MUSIC_PLAY(4),
        VR_CMD_CALL(5),
        VR_CMD_ENDCALL(6),
        VR_CMD_TEL(7),
        VR_CMD_MAP(8),
        VR_CMD_MUSIC(9),
        VR_CMD_VR_START(10),
        VR_CMD_VR_STOP(11),
        VR_CMD_NAVI_QUIT(12),
        VR_CMD_NAVI_HOME(13),
        VR_CMD_NAVI_COMPANY(14),
        VR_CMD_BACK_HOMEPAGE(15);
        
        private static VRCmdType[] values;
        private final int value;

        static {
            values = null;
        }

        private VRCmdType(int i) {
            this.value = i;
        }

        public static VRCmdType fromInt(int i) {
            if (values == null) {
                values = values();
            }
            int i2 = 0;
            while (true) {
                VRCmdType[] vRCmdTypeArr = values;
                if (i2 >= vRCmdTypeArr.length) {
                    return VR_CMD_UNDEFINED;
                }
                VRCmdType vRCmdType = vRCmdTypeArr[i2];
                if (vRCmdType.value == i) {
                    return vRCmdType;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum VideoType {
        STREAM_UNDEFINED(0),
        STREAM_CAST_VIDEO(1),
        STREAM_COMMUNICATION(2),
        STREAM_CAMERA_PREVIEW(3),
        STREAM_CAMERA_PICTURE(4);
        
        private static VideoType[] values;
        private final int value;

        static {
            values = null;
        }

        private VideoType(int i) {
            this.value = i;
        }

        public static VideoType fromInt(int i) {
            if (values == null) {
                values = values();
            }
            int i2 = 0;
            while (true) {
                VideoType[] videoTypeArr = values;
                if (i2 >= videoTypeArr.length) {
                    return STREAM_UNDEFINED;
                }
                VideoType videoType = videoTypeArr[i2];
                if (videoType.value == i) {
                    return videoType;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class VisibleRegion {

        /* renamed from: a  reason: collision with root package name */
        public int f5390a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public DisplayMode g;

        public VisibleRegion(int i, int i2, int i3, int i4, int i5, int i6, DisplayMode displayMode) {
            this.f5390a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = displayMode;
        }

        public int a() {
            return this.f - this.d;
        }

        public VisibleRegion b() {
            return new VisibleRegion(this.f5390a, this.b, this.c, this.d, this.e, this.f, this.g);
        }

        public int c() {
            return this.d - this.b;
        }

        public boolean d() {
            return h() > 0 && c() > 0 && this.e > 0 && this.f > 0;
        }

        public int e() {
            return this.f5390a;
        }

        public int f() {
            return this.e - this.c;
        }

        public int g() {
            return this.b;
        }

        public int h() {
            return this.c - this.f5390a;
        }

        public String toString() {
            return "left: " + this.f5390a + ", top: " + this.b + ", right: " + this.c + ", bottom: " + this.d + ", originWidth: " + this.e + ", originHeight: " + this.f + ", mode: " + this.g;
        }
    }

    public static class WorkMode {
        public static final WorkMode b;
        public static final WorkMode c;
        public static final WorkMode d;
        public static final WorkMode e;
        public static final WorkMode f;
        public static final WorkMode g;
        public static final WorkMode h;
        public static final WorkMode i;
        public static final WorkMode j;
        public static final WorkMode[] k;

        /* renamed from: a  reason: collision with root package name */
        public final UCarWorkMode f5391a;

        public static class Builder {
        }

        static {
            WorkMode workMode = new WorkMode(0);
            b = workMode;
            WorkMode workMode2 = new WorkMode(1);
            c = workMode2;
            WorkMode workMode3 = new WorkMode(2);
            d = workMode3;
            WorkMode workMode4 = new WorkMode(4);
            e = workMode4;
            WorkMode workMode5 = new WorkMode(8);
            f = workMode5;
            WorkMode workMode6 = new WorkMode(16);
            g = workMode6;
            WorkMode workMode7 = new WorkMode(32);
            h = workMode7;
            WorkMode workMode8 = new WorkMode(64);
            i = workMode8;
            WorkMode workMode9 = new WorkMode(128);
            j = workMode9;
            k = new WorkMode[]{workMode, workMode2, workMode3, workMode4, workMode5, workMode6, workMode7, workMode8, workMode9};
        }

        public WorkMode(int i2) {
            this.f5391a = UCarWorkMode.a(i2);
        }

        public static WorkMode a(int i2) {
            for (WorkMode workMode : k) {
                if (workMode.k() == i2) {
                    return workMode;
                }
            }
            return new WorkMode(i2);
        }

        public static boolean j(WorkMode workMode) {
            for (WorkMode k2 : k) {
                if (k2.k() == workMode.k()) {
                    return true;
                }
            }
            return false;
        }

        public boolean b() {
            return this.f5391a.b();
        }

        public boolean c() {
            return this.f5391a.c();
        }

        public boolean d() {
            return this.f5391a.d();
        }

        public boolean e() {
            return this.f5391a.e();
        }

        public boolean f() {
            return this.f5391a.f();
        }

        public boolean g() {
            return this.f5391a.g();
        }

        public boolean h() {
            return this.f5391a.h();
        }

        public boolean i() {
            return this.f5391a.i();
        }

        public int k() {
            return this.f5391a.k();
        }

        public String toString() {
            if (this.f5391a == null) {
                return "null";
            }
            ArrayList arrayList = new ArrayList();
            if (i()) {
                arrayList.add("NORMAL_CAST");
            }
            if (e()) {
                arrayList.add("DATA_TRANSFER");
            }
            if (b()) {
                arrayList.add("APP_FULLSCREEN_CAST");
            }
            if (c()) {
                arrayList.add("APP_WINDOW_CAST");
            }
            if (d()) {
                arrayList.add("CARD_CAST");
            }
            if (f()) {
                arrayList.add("FILE_TRANSFER");
            }
            if (h()) {
                arrayList.add("MULTI_SCREEN_CAST");
            }
            if (g()) {
                arrayList.add("MULTI_DEVICE_CONNECT");
            }
            String join = String.join(", ", arrayList);
            return "workMode(" + k() + "){ " + join + " }";
        }
    }
}
