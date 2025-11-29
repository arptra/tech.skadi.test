package com.upuphone.starrynet.strategy.message.payload.handler;

import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.payload.MessageUtil;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;

public class RingDataUtil {
    private static final int[] CRC32_TAB = {0, 1996959894, -301047508, -1727442502, 124634137, 1886057615, -379345611, -1637575261, 249268274, 2044508324, -522852066, -1747789432, 162941995, 2125561021, -407360249, -1866523247, 498536548, 1789927666, -205950648, -2067906082, 450548861, 1843258603, -187386543, -2083289657, 325883990, 1684777152, -43845254, -1973040660, 335633487, 1661365465, -99664541, -1928851979, 997073096, 1281953886, -715111964, -1570279054, 1006888145, 1258607687, -770865667, -1526024853, 901097722, 1119000684, -608450090, -1396901568, 853044451, 1172266101, -589951537, -1412350631, 651767980, 1373503546, -925412992, -1076862698, 565507253, 1454621731, -809855591, -1195530993, 671266974, 1594198024, -972236366, -1324619484, 795835527, 1483230225, -1050600021, -1234817731, 1994146192, 31158534, -1731059524, -271249366, 1907459465, 112637215, -1614814043, -390540237, 2013776290, 251722036, -1777751922, -519137256, 2137656763, 141376813, -1855689577, -429695999, 1802195444, 476864866, -2056965928, -228458418, 1812370925, 453092731, -2113342271, -183516073, 1706088902, 314042704, -1950435094, -54949764, 1658658271, 366619977, -1932296973, -69972891, 1303535960, 984961486, -1547960204, -725929758, 1256170817, 1037604311, -1529756563, -740887301, 1131014506, 879679996, -1385723834, -631195440, 1141124467, 855842277, -1442165665, -586318647, 1342533948, 654459306, -1106571248, -921952122, 1466479909, 544179635, -1184443383, -832445281, 1591671054, 702138776, -1328506846, -942167884, 1504918807, 783551873, -1212326853, -1061524307, -306674912, -1698712650, 62317068, 1957810842, -355121351, -1647151185, 81470997, 1943803523, -480048366, -1805370492, 225274430, 2053790376, -468791541, -1828061283, 167816743, 2097651377, -267414716, -2029476910, 503444072, 1762050814, -144550051, -2140837941, 426522225, 1852507879, -19653770, -1982649376, 282753626, 1742555852, -105259153, -1900089351, 397917763, 1622183637, -690576408, -1580100738, 953729732, 1340076626, -776247311, -1497606297, 1068828381, 1219638859, -670225446, -1358292148, 906185462, 1090812512, -547295293, -1469587627, 829329135, 1181335161, -882789492, -1134132454, 628085408, 1382605366, -871598187, -1156888829, 570562233, 1426400815, -977650754, -1296233688, 733239954, 1555261956, -1026031705, -1244606671, 752459403, 1541320221, -1687895376, -328994266, 1969922972, 40735498, -1677130071, -351390145, 1913087877, 83908371, -1782625662, -491226604, 2075208622, 213261112, -1831694693, -438977011, 2094854071, 198958881, -2032938284, -237706686, 1759359992, 534414190, -2118248755, -155638181, 1873836001, 414664567, -2012718362, -15766928, 1711684554, 285281116, -1889165569, -127750551, 1634467795, 376229701, -1609899400, -686959890, 1308918612, 956543938, -1486412191, -799009033, 1231636301, 1047427035, -1362007478, -640263460, 1088359270, 936918000, -1447252397, -558129467, 1202900863, 817233897, -1111625188, -893730166, 1404277552, 615818150, -1160759803, -841546093, 1423857449, 601450431, -1285129682, -1000256840, 1567103746, 711928724, -1274298825, -1022587231, 1510334235, 755167117};
    public static final byte OPCODE_CONFIG_PAIR = 38;
    public static final byte OPCODE_CONTROL_WORK_MODE = 39;
    public static final byte OPCODE_DISCONNECT_ACL = 13;
    public static final byte OPCODE_ENABLE_DFU = 7;
    public static final byte OPCODE_IMU_SWITCHER = 11;
    public static final byte OPCODE_OTA_FRAME_DATA = 2;
    public static final byte OPCODE_QUERY_ALGO_STATE = 41;
    public static final byte OPCODE_QUERY_FW_VERSION = 37;
    public static final byte OPCODE_QUERY_IMU_STATE = 10;
    public static final byte OPCODE_RESET_OTA = 1;
    public static final byte OPCODE_SET_GET_RING_NAME = 40;
    public static final byte OPCODE_SYNC_TS = 0;
    public static final byte OPCODE_SYS_CONFIG = 3;

    public static class FwVersion {
        public String firmwareVersion;
        public int hardVersion;
        public String sn;
        public int softVersion;

        public FwVersion(byte[] bArr) {
            this.softVersion = bArr[3] & 255;
            this.hardVersion = bArr[4] & 255;
            this.firmwareVersion = String.valueOf(bArr[8] & 255) + "." + String.valueOf(bArr[7] & 255) + "." + String.valueOf(bArr[6] & 255) + "." + String.valueOf(bArr[5] & 255);
            if (bArr.length == 73) {
                byte[] access$000 = RingDataUtil.filterEndTag(ByteUtils.getBytes(bArr, 9, 72));
                if (access$000 != null) {
                    this.sn = new String(access$000);
                } else {
                    this.sn = "";
                }
            }
        }

        public String toString() {
            return "FwVersion{softVersion=" + this.softVersion + ", hardVersion=" + this.hardVersion + ", firmwareVersion='" + this.firmwareVersion + '\'' + ", sn =" + this.sn + '}';
        }
    }

    public static class IMUState {
        public int magChipState;
        public boolean magIsWorking;
        public int sixAxisChipState;
        public boolean sixAxisIsWorking;

        public IMUState(byte[] bArr) {
            byte b = bArr[3];
            this.magChipState = b & 1;
            boolean z = true;
            this.sixAxisChipState = (b >> 1) & 1;
            this.magIsWorking = ((b >> 2) & 1) == 1;
            this.sixAxisIsWorking = ((b >> 3) & 1) != 1 ? false : z;
        }

        public String toString() {
            return "IMUState{magChipState=" + this.magChipState + ", sixAxisChipState=" + this.sixAxisChipState + ", magIsWorking=" + this.magIsWorking + ", sixAxisIsWorking=" + this.sixAxisIsWorking + '}';
        }
    }

    public static class RingSystemState {
        public int batteryLevel;
        public int bleMtu;
        public int hardwareVerNum;
        public boolean isOTA;
        public int otaBinCrc32;
        public int otaBinOffset;
        public int softwareVerNum;
        public int timestampSec;

        public boolean isChanged(RingSystemState ringSystemState) {
            return (ringSystemState != null && this.hardwareVerNum == ringSystemState.hardwareVerNum && this.batteryLevel == ringSystemState.batteryLevel && this.softwareVerNum == ringSystemState.softwareVerNum && this.otaBinOffset == ringSystemState.otaBinOffset) ? false : true;
        }

        public String toString() {
            return "RingSystemState{bleMtu=" + this.bleMtu + ", softwareVerNum=" + this.softwareVerNum + ", hardwareVerNum=" + this.hardwareVerNum + ", batteryLevel=" + this.batteryLevel + ", timestampSec=" + this.timestampSec + ", otaBinCrc32=" + this.otaBinCrc32 + ", otaBinOffset=" + this.otaBinOffset + ", isOTA=" + this.isOTA + '}';
        }
    }

    public static class SysConfig {
        public byte[] mac;
        private String strMac;
        public int workMode;

        public SysConfig(int i, byte[] bArr) {
            this.mac = bArr;
            this.workMode = i;
            this.strMac = Utils.getAddressStringFromByte(bArr);
        }

        public byte[] toJsonBytes() {
            int i;
            int i2 = this.workMode;
            if (i2 == 1) {
                i = 1;
            } else {
                i = 2;
                if (i2 == 2) {
                    i = 3;
                }
            }
            return MessageUtil.buildProtocolMessage2Bytes(1, 6, PayloadConstant.PARAMS_KEY_BL_REMOTE_MOUSE_STATUS, Boolean.valueOf(i2 == 1), PayloadConstant.PARAMS_KEY_WORK_MODE, Integer.valueOf(i));
        }

        public String toString() {
            return "SysConfig{mac=" + Arrays.toString(this.mac) + ", workMode=" + this.workMode + ", strMac='" + this.strMac + '\'' + '}';
        }
    }

    public static byte[] controlWorkMode(int i) {
        byte[] bArr = new byte[4];
        if (i == 0) {
            bArr[3] = 1;
        } else if (i == 1) {
            bArr[3] = 3;
        } else if (i == 2) {
            bArr[3] = 5;
        }
        int crc16 = crc16(bArr);
        bArr[0] = 39;
        bArr[1] = (byte) (crc16 & 255);
        bArr[2] = (byte) ((crc16 >> 8) & 255);
        return bArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int crc16(byte[] r7) {
        /*
            int r0 = r7.length
            r1 = 65535(0xffff, float:9.1834E-41)
            r2 = 3
            r3 = r1
        L_0x0006:
            if (r2 >= r0) goto L_0x0027
            r3 = r3 & r1
            byte r4 = r7[r2]
            r4 = r4 & 255(0xff, float:3.57E-43)
            r3 = r3 ^ r4
            r4 = 0
        L_0x000f:
            r5 = 8
            if (r4 >= r5) goto L_0x0024
            r5 = r3 & 1
            r6 = 1
            if (r5 != r6) goto L_0x001f
            int r3 = r3 >> 1
            r5 = 40961(0xa001, float:5.7399E-41)
            r3 = r3 ^ r5
            goto L_0x0021
        L_0x001f:
            int r3 = r3 >> 1
        L_0x0021:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x0024:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x0027:
            r7 = r3 & r1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.message.payload.handler.RingDataUtil.crc16(byte[]):int");
    }

    public static int crc32(byte[] bArr) {
        byte b = -857948727;
        for (byte b2 : bArr) {
            b = ((b >> 8) & 16777215) ^ CRC32_TAB[(b2 ^ b) & 255];
        }
        return ~b;
    }

    public static SysConfig dataConvert2SysConfig(byte[] bArr) {
        byte[] bArr2 = new byte[6];
        for (int i = 4; i < 10; i++) {
            bArr2[i - 4] = bArr[i];
        }
        bArr2[0] = bArr[9];
        bArr2[1] = bArr[8];
        bArr2[2] = bArr[7];
        bArr2[3] = bArr[6];
        bArr2[4] = bArr[5];
        bArr2[5] = bArr[4];
        return new SysConfig(bArr[16] & 255, bArr2);
    }

    public static RingSystemState dataConvert2SystemState(byte[] bArr) {
        RingSystemState ringSystemState = new RingSystemState();
        ringSystemState.bleMtu = ((bArr[4] & 255) << 8) | (bArr[3] & 255);
        ringSystemState.softwareVerNum = bArr[5] & 255;
        ringSystemState.hardwareVerNum = bArr[6] & 255;
        ringSystemState.batteryLevel = bArr[15] & 255;
        ringSystemState.timestampSec = ((bArr[20] & 255) << 24) | ((bArr[19] & 255) << 16) | ((bArr[18] & 255) << 8) | (bArr[17] & 255);
        ringSystemState.otaBinCrc32 = ((bArr[10] & 255) << 24) | ((bArr[9] & 255) << 16) | ((bArr[8] & 255) << 8) | (bArr[7] & 255);
        ringSystemState.otaBinOffset = ((bArr[14] & 255) << 24) | ((bArr[13] & 255) << 16) | ((bArr[12] & 255) << 8) | (bArr[11] & 255);
        boolean z = true;
        if (bArr[16] != 1) {
            z = false;
        }
        ringSystemState.isOTA = z;
        return ringSystemState;
    }

    public static byte[] disconnect() {
        byte[] bArr = new byte[3];
        int crc16 = crc16(bArr);
        bArr[0] = 13;
        bArr[1] = (byte) (crc16 & 255);
        bArr[2] = (byte) ((crc16 >> 8) & 255);
        return bArr;
    }

    public static byte[] enableDfu() {
        byte[] bArr = new byte[3];
        int crc16 = crc16(bArr);
        bArr[0] = 7;
        bArr[1] = (byte) (crc16 & 255);
        bArr[2] = (byte) ((crc16 >> 8) & 255);
        return bArr;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        r1 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] filterEndTag(byte[] r3) {
        /*
            r0 = 0
            r1 = r0
        L_0x0002:
            int r2 = r3.length
            if (r1 >= r2) goto L_0x0011
            byte r2 = r3[r1]
            if (r2 != 0) goto L_0x000e
            if (r1 <= 0) goto L_0x0011
            int r1 = r1 + -1
            goto L_0x0012
        L_0x000e:
            int r1 = r1 + 1
            goto L_0x0002
        L_0x0011:
            r1 = -1
        L_0x0012:
            if (r1 <= 0) goto L_0x001b
            int r1 = r1 + 1
            byte[] r3 = com.upuphone.starrynet.common.utils.ByteUtils.subArray(r3, r0, r1)
            return r3
        L_0x001b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "filterEndTag, data not match , data ="
            r0.append(r1)
            java.lang.String r3 = com.upuphone.starrynet.common.utils.ByteUtils.byteToString(r3)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            java.lang.String r0 = "RingDataUtil"
            com.upuphone.starrynet.common.StLog.w(r0, r3)
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.message.payload.handler.RingDataUtil.filterEndTag(byte[]):byte[]");
    }

    public static byte[] getBytesByFile(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                    return byteArray;
                }
            }
        } catch (Exception e) {
            StLog.w("RingDataUtil", "getBytesByFile happen exception ,detail:\n", (Throwable) e);
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static byte[] getBytesByFileDescriptor(FileDescriptor fileDescriptor) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(fileDescriptor);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                    return byteArray;
                }
            }
        } catch (Exception e) {
            StLog.w("RingDataUtil", "getBytesByFile happen exception ,detail:\n", (Throwable) e);
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static byte[] notifyReadyRemoveBond(byte[] bArr) {
        byte[] bArr2 = new byte[11];
        bArr2[3] = 1;
        bArr2[4] = 0;
        bArr2[5] = bArr[5];
        bArr2[6] = bArr[4];
        bArr2[7] = bArr[3];
        bArr2[8] = bArr[2];
        bArr2[9] = bArr[1];
        bArr2[10] = bArr[0];
        int crc16 = crc16(bArr2);
        bArr2[0] = 38;
        bArr2[1] = (byte) (crc16 & 255);
        bArr2[2] = (byte) ((crc16 >> 8) & 255);
        return bArr2;
    }

    public static byte[] openOrCloseImu(boolean z) {
        byte[] bArr = new byte[4];
        if (z) {
            bArr[3] = 2;
        } else {
            bArr[3] = 0;
        }
        int crc16 = crc16(bArr);
        bArr[0] = 11;
        bArr[1] = (byte) (crc16 & 255);
        bArr[2] = (byte) ((crc16 >> 8) & 255);
        return bArr;
    }

    public static byte[] otaFrame(byte[] bArr, int i) {
        int length = bArr.length;
        byte[] bArr2 = new byte[(bArr.length + 7)];
        bArr2[3] = (byte) (length & 255);
        bArr2[4] = (byte) (((i & 63) << 2) | (3 & (length >> 8)));
        bArr2[5] = (byte) ((i >> 6) & 255);
        bArr2[6] = (byte) ((i >> 14) & 255);
        for (int i2 = 0; i2 < length; i2++) {
            bArr2[i2 + 7] = bArr[i2];
        }
        int crc16 = crc16(bArr2);
        bArr2[0] = 2;
        bArr2[1] = (byte) (crc16 & 255);
        bArr2[2] = (byte) ((crc16 >> 8) & 255);
        return bArr2;
    }

    public static byte[] otaReset(int i, int i2) {
        byte[] bArr = new byte[13];
        bArr[3] = 1;
        bArr[4] = 1;
        bArr[5] = (byte) (i & 255);
        bArr[6] = (byte) ((i >> 8) & 255);
        bArr[7] = (byte) ((i >> 16) & 255);
        bArr[8] = (byte) ((i >> 24) & 255);
        bArr[9] = (byte) (i2 & 255);
        bArr[10] = (byte) ((i2 >> 8) & 255);
        bArr[11] = (byte) ((i2 >> 16) & 255);
        bArr[12] = (byte) ((i2 >> 24) & 255);
        int crc16 = crc16(bArr);
        bArr[0] = 1;
        bArr[1] = (byte) (crc16 & 255);
        bArr[2] = (byte) ((crc16 >> 8) & 255);
        return bArr;
    }

    public static byte[] queryAlgoState() {
        byte[] bArr = new byte[5];
        bArr[3] = 0;
        bArr[4] = 0;
        int crc16 = crc16(bArr);
        bArr[0] = OPCODE_QUERY_ALGO_STATE;
        bArr[1] = (byte) (crc16 & 255);
        bArr[2] = (byte) ((crc16 >> 8) & 255);
        return bArr;
    }

    public static byte[] queryFwVersion() {
        byte[] bArr = new byte[3];
        int crc16 = crc16(bArr);
        bArr[0] = 37;
        bArr[1] = (byte) (crc16 & 255);
        bArr[2] = (byte) ((crc16 >> 8) & 255);
        return bArr;
    }

    public static byte[] queryImuState() {
        byte[] bArr = new byte[3];
        int crc16 = crc16(bArr);
        bArr[0] = 10;
        bArr[1] = (byte) (crc16 & 255);
        bArr[2] = (byte) ((crc16 >> 8) & 255);
        return bArr;
    }

    public static byte[] queryOtaState() {
        byte[] bArr = new byte[4];
        bArr[3] = 0;
        int crc16 = crc16(bArr);
        bArr[0] = 0;
        bArr[1] = (byte) (crc16 & 255);
        bArr[2] = (byte) ((crc16 >> 8) & 255);
        return bArr;
    }

    public static byte[] querySysConfig() {
        byte[] bArr = new byte[4];
        int crc16 = crc16(bArr);
        bArr[0] = 3;
        bArr[1] = (byte) (crc16 & 255);
        bArr[2] = (byte) ((crc16 >> 8) & 255);
        return bArr;
    }

    public static byte[] requestRingName() {
        byte[] bArr = new byte[35];
        bArr[3] = 0;
        int crc16 = crc16(bArr);
        bArr[0] = OPCODE_SET_GET_RING_NAME;
        bArr[1] = (byte) (crc16 & 255);
        bArr[2] = (byte) ((crc16 >> 8) & 255);
        return bArr;
    }

    public static String responseRingName(byte[] bArr) {
        int i = bArr[4] & 255;
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 5, bArr2, 0, i);
        return new String(bArr2);
    }

    public static byte[] setRingName(String str) {
        byte[] bArr = new byte[35];
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        bArr[3] = 1;
        bArr[4] = (byte) bytes.length;
        System.arraycopy(bytes, 0, bArr, 5, bytes.length);
        int crc16 = crc16(bArr);
        bArr[0] = OPCODE_SET_GET_RING_NAME;
        bArr[1] = (byte) (crc16 & 255);
        bArr[2] = (byte) ((crc16 >> 8) & 255);
        return bArr;
    }

    public static byte[] syncTimeStamp() {
        byte[] bArr = new byte[21];
        long time = (Calendar.getInstance().getTime().getTime() + ((long) TimeZone.getDefault().getRawOffset())) / 1000;
        bArr[3] = 0;
        bArr[17] = (byte) ((int) (time & 255));
        bArr[18] = (byte) ((int) ((time >> 8) & 255));
        bArr[19] = (byte) ((int) ((time >> 16) & 255));
        bArr[20] = (byte) ((int) ((time >> 24) & 255));
        int crc16 = crc16(bArr);
        bArr[0] = 0;
        bArr[1] = (byte) (crc16 & 255);
        bArr[2] = (byte) ((crc16 >> 8) & 255);
        return bArr;
    }
}
