package com.upuphone.starryiccoaproto;

import com.ucar.databus.proto.UCarProto;
import java.util.Arrays;

public class UCarCommon {

    public static class AccelerationInfo {
    }

    public enum AppCategory {
        MAP,
        MUSIC,
        MEDIA,
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
    }

    public static class AppGeneralInfo {
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
    }

    public static class AudioFormat {

        /* renamed from: a  reason: collision with root package name */
        public String f6517a;
        public int b;
        public int c;
        public int d;

        public String toString() {
            return "AudioFormat{mimeType='" + this.f6517a + '\'' + ", sampleRate=" + this.b + ", channelConfig=" + this.c + ", encodingFormat=" + this.d + '}';
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
        private final int mValue;

        static {
            values = null;
        }

        private AudioType(int i) {
            this.mValue = i;
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
                if (audioType.mValue == i) {
                    return audioType;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public static class BatteryInfo {
    }

    public static class BluetoothMacInfo {
    }

    public static class CallInfo {
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
        
        private int mValue;

        private CameraAction(int i) {
            this.mValue = i;
        }

        public static CameraAction fromInt(int i) {
            return i != 0 ? i != 1 ? i != 2 ? CAMERA_UNDEFINE : CAMERA_CLOSE : CAMERA_CAPTURE : CAMERA_OPEN;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public static class CameraActionArgs {
    }

    public static class CameraInfo {
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
        WGS84,
        GCJ02,
        BD09
    }

    public enum DayNightMode {
        UNKNOWN_MODE(0),
        DAY_MODE(1),
        NIGHT_MODE(2);
        
        private static DayNightMode[] values;
        private final int mValue;

        static {
            values = null;
        }

        private DayNightMode(int i) {
            this.mValue = i;
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
                if (dayNightMode.mValue == i) {
                    return dayNightMode;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public static class GPSInfo {
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
    }

    public static class GyroscopeInfo {
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
        KEY_CODE_OUT_FOCUS(UCarProto.CustomKeyEvent.KeyCode.KEY_CODE_OUT_FOCUS_VALUE);
        
        private static KeyCodeType[] values;
        private final int mValue;

        static {
            values = null;
        }

        private KeyCodeType(int i) {
            this.mValue = i;
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
                if (keyCodeType.mValue == i) {
                    return keyCodeType;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public enum KeyEventActionType {
        KEY_EVENT_ACTION_UNDEFINED(-1),
        KEY_EVENT_ACTION_DOWN(0),
        KEY_EVENT_ACTION_UP(1),
        KEY_EVENT_ACTION_PRESS(2);
        
        private static KeyEventActionType[] values;
        private final int mValue;

        static {
            values = null;
        }

        private KeyEventActionType(int i) {
            this.mValue = i;
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
                if (keyEventActionType.mValue == i) {
                    return keyEventActionType;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public enum LensFacing {
        LENS_FACING_FRONT(0),
        LENS_FACING_BACK(1),
        LENS_FACING_EXTERNAL(2);
        
        private static LensFacing[] values;
        private final int mValue;

        static {
            values = null;
        }

        private LensFacing(int i) {
            this.mValue = i;
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
                if (lensFacing.mValue == i) {
                    return lensFacing;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public static class LightSensorInfo {
    }

    public static class LightsInfo {
    }

    public static class MobileDevice {

        /* renamed from: a  reason: collision with root package name */
        public final String f6518a;
        public final String b;
        public final String c;
        public final int d;

        public String toString() {
            return "MobileDevice{mId='" + this.f6518a + '\'' + ", mProductName='" + this.b + '\'' + ", mModel='" + this.c + '\'' + ", mConnectType=" + this.d + '}';
        }
    }

    public static class MusicInfo {

        /* renamed from: a  reason: collision with root package name */
        public String f6519a;
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

        public String toString() {
            return "Artist: " + this.f6519a + ", Album: " + this.b + ", Cover: " + this.c + ", Lyrics: " + this.d + ", TotalTimeMs: " + this.e + ", Tile: " + this.f + ", Author: " + this.g + ", Writer: " + this.h + ", Composer: " + this.i + ", CurrentTimeMs: " + this.j + ", isFavorite: " + this.k + ", isPlaying: " + this.l + ", cover: " + Arrays.toString(this.m);
        }
    }

    public static class NavigationInfo {

        /* renamed from: a  reason: collision with root package name */
        public boolean f6520a;
        public byte[] b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;

        public String toString() {
            return "NavigationInfo{isNavigating: " + this.f6520a + ", directionIcon: " + Arrays.toString(this.b) + ", distance: " + this.c + ", distanceUnit: " + this.d + ", operation: " + this.e + ", where: " + this.f + ", title1: " + this.g + ", title2: " + this.h + '}';
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
    }

    public enum Orientation {
        ORIENTATION_UNKNOWN(-1),
        ORIENTATION_0(0),
        ORIENTATION_90(90),
        ORIENTATION_180(180),
        ORIENTATION_270(UCarProto.Orientation.ORIENTATION_270_VALUE);
        
        private static Orientation[] values;
        private final int mValue;

        static {
            values = null;
        }

        private Orientation(int i) {
            this.mValue = i;
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
                if (orientation.mValue == i) {
                    return orientation;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public static class POIAddress {
    }

    public static class POIDetailInfo {
    }

    public static class PhoneStateInfo {

        /* renamed from: a  reason: collision with root package name */
        public CallState f6521a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;

        public String toString() {
            return "call state: " + this.f6521a + ", isScreenLocked: " + this.b + ", isWechatQq: " + this.c + ", isUseMicrophone: " + this.d + ", isVoiceAssistantActive: " + this.e + ", isLowPower: " + this.f + ", isOverheat: " + this.g;
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
        private final int mValue;

        static {
            values = null;
        }

        private VRCmdType(int i) {
            this.mValue = i;
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
                if (vRCmdType.mValue == i) {
                    return vRCmdType;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public enum VideoType {
        STREAM_UNDEFINED(0),
        STREAM_CAST_VIDEO(1),
        STREAM_COMMUNICATION(2),
        STREAM_CAMERA_PREVIEW(3),
        STREAM_CAMERA_PICTURE(4);
        
        private static VideoType[] values;
        private final int mValue;

        static {
            values = null;
        }

        private VideoType(int i) {
            this.mValue = i;
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
                if (videoType.mValue == i) {
                    return videoType;
                }
                i2++;
            }
        }

        public int getValue() {
            return this.mValue;
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
        public final UCarWorkMode f6522a;

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
            this.f6522a = UCarWorkMode.a(i2);
        }
    }
}
