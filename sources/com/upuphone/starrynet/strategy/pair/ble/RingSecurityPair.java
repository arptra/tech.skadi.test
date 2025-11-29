package com.upuphone.starrynet.strategy.pair.ble;

import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptData;
import com.upuphone.starrynet.strategy.encrypt.bean.KeyPair;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import com.upuphone.starrynet.strategy.message.payload.handler.RingDataUtil;
import com.upuphone.starrynet.strategy.pair.IMYVURingStatusCallback;
import com.upuphone.starrynet.strategy.pair.IPairMsgCallback;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheResponse;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Random;
import javax.crypto.KeyAgreement;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.json.JSONException;

public class RingSecurityPair implements IPairMsgCallback {
    public static final byte GATT_HEADER_SIZE = 3;
    public static final String KEY_ALGORITHM = "EC";
    public static final String KEY_ASYMMETRIC = "ECDH";
    public static final String KEY_DEVICEINFO = "DeviceInfo";
    public static final String KEY_ENCSWITCHINFO = "EncSwitchInfo";
    public static final String KEY_HASH = "Hash";
    public static final String KEY_IV = "IV";
    public static final String KEY_MACADDR = "MacAddr";
    public static final String KEY_MODELID = "ModelId";
    public static final String KEY_PUBKEY = "PubKey";
    public static final String KEY_RANDOM = "Random";
    public static final byte OPCODE_PHONE_START_REMOVE_BOND = -123;
    public static final byte OPCODE_RING_ENCRYPTED_DATA = -54;
    public static final byte OPCODE_RING_ENCRYPTION_MODE = 3;
    public static final byte OPCODE_RING_GET_FW_VER = 39;
    public static final byte OPCODE_RING_GET_SN = 7;
    public static final byte OPCODE_RING_PAIR = 112;
    public static final byte OPCODE_RING_PAIR_SWITCH_INFO = 2;
    public static final byte OPCODE_RING_PAIR_SWITCH_KEY = 1;
    public static final byte RING_MSG_HEADER_SIZE = 3;
    private static final byte SN_TLV_TAG_DEV_INFO = 13;
    private static final byte SN_TLV_TAG_ENC_SWITCH_INFO = 16;
    private static final byte SN_TLV_TAG_HASH = 15;
    private static final byte SN_TLV_TAG_IV = 14;
    private static final byte SN_TLV_TAG_MACADDR = 11;
    private static final byte SN_TLV_TAG_MODELID = 12;
    private static final byte SN_TLV_TAG_PUB_KEY = 10;
    private static final byte SN_TLV_TAG_RANDOM = 17;
    private static final String TAG = "RingSecurityPair";
    private static byte[] gRandom;
    private static final byte[] padding = {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16};
    private static byte[] staticKey = {46, -6, OPCODE_RING_ENCRYPTED_DATA, -120, -67, 89, HttpConstants.COLON, 118, -16, -60, 113, -114, -29, 10, 76, 117, -78, -37, -40, 50, RingDataUtil.OPCODE_SET_GET_RING_NAME, 117, -119, 50, 28, -45, -95, 33, -13, -113, 11, 95};
    private byte[] mBytesRecv;
    private IMYVURingStatusCallback mPairStatusCallback;

    public static final class Holder {
        static final RingSecurityPair INSTANCE = new RingSecurityPair();

        private Holder() {
        }
    }

    public class SwitchKeyParse {
        private byte[] devInfo;
        private byte[] ivParam;
        private byte[] publicKeyB;

        public SwitchKeyParse(byte[] bArr) {
            parse(bArr);
        }

        private void parse(byte[] bArr) {
            TLV tlv = new TLV();
            try {
                byte[] unpack = tlv.unpack(bArr);
                PrintStream printStream = System.out;
                printStream.println("Unpacked TLV:");
                printStream.println("Type: " + tlv.getType());
                printStream.println("Length: " + tlv.getLength());
                printStream.println("Value: " + new String(tlv.getValue()));
                if (tlv.getType() == 13) {
                    this.devInfo = tlv.getValue();
                }
                StLog.d(RingSecurityPair.TAG, "unParse: " + RingSecurityPair.printByteArray(unpack));
                byte[] unpack2 = tlv.unpack(unpack);
                printStream.println("Type: " + tlv.getType());
                printStream.println("Length: " + tlv.getLength());
                printStream.println("Value: " + RingSecurityPair.printByteArray(tlv.getValue()));
                if (tlv.getType() == 10) {
                    this.publicKeyB = tlv.getValue();
                }
                StLog.d(RingSecurityPair.TAG, "unParse: " + RingSecurityPair.printByteArray(unpack2));
                tlv.unpack(unpack2);
                printStream.println("Type: " + tlv.getType());
                printStream.println("Length: " + tlv.getLength());
                printStream.println("Value: " + RingSecurityPair.printByteArray(tlv.getValue()));
                if (tlv.getType() == 14) {
                    this.ivParam = tlv.getValue();
                }
            } catch (IllegalArgumentException e) {
                PrintStream printStream2 = System.err;
                printStream2.println("Failed to unpack data: " + e.getMessage());
            }
        }

        public byte[] getDevInfo() {
            return this.devInfo;
        }

        public byte[] getIvParam() {
            return this.ivParam;
        }

        public byte[] getPublicKey() {
            return this.publicKeyB;
        }
    }

    public class TLV {
        public static final byte TLV_HEADER_SIZE = 3;
        private short length;
        private byte type;
        private byte[] value;

        public TLV() {
        }

        public short getLength() {
            return this.length;
        }

        public byte getType() {
            return this.type;
        }

        public byte[] getValue() {
            return this.value;
        }

        public byte[] pack() {
            short s = this.length;
            byte[] bArr = new byte[(s + 3)];
            bArr[0] = this.type;
            bArr[1] = (byte) (s >> 8);
            bArr[2] = (byte) (s & 255);
            System.arraycopy(this.value, 0, bArr, 3, s);
            return bArr;
        }

        /* JADX WARNING: type inference failed for: r3v4, types: [short, int] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public byte[] unpack(byte[] r7) throws java.lang.IllegalArgumentException {
            /*
                r6 = this;
                int r0 = r7.length
                r1 = 3
                if (r0 < r1) goto L_0x0037
                r0 = 0
                byte r2 = r7[r0]
                r3 = 1
                byte r3 = r7[r3]
                int r3 = r3 << 8
                r4 = 2
                byte r4 = r7[r4]
                r4 = r4 & 255(0xff, float:3.57E-43)
                r3 = r3 | r4
                short r3 = (short) r3
                int r4 = r7.length
                int r5 = r3 + 3
                if (r4 < r5) goto L_0x002f
                byte[] r4 = new byte[r3]
                java.lang.System.arraycopy(r7, r1, r4, r0, r3)
                r6.type = r2
                r6.value = r4
                r6.length = r3
                int r6 = r7.length
                int r6 = r6 - r1
                int r6 = r6 - r3
                byte[] r6 = new byte[r6]
                int r2 = r7.length
                int r2 = r2 - r1
                int r2 = r2 - r3
                java.lang.System.arraycopy(r7, r5, r6, r0, r2)
                return r6
            L_0x002f:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r7 = "Data length does not match the specified length."
                r6.<init>(r7)
                throw r6
            L_0x0037:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r7 = "Data is too short to be a valid TLV."
                r6.<init>(r7)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair.TLV.unpack(byte[]):byte[]");
        }

        public TLV(byte b, byte[] bArr) {
            this.type = b;
            this.length = (short) bArr.length;
            this.value = bArr;
        }
    }

    private static byte[] concatenate(byte[] bArr, byte[] bArr2) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + bArr2.length);
        allocate.put(bArr);
        allocate.put(bArr2);
        return allocate.array();
    }

    private static void crcValue(byte[] bArr) {
        byte b = 0;
        for (int i = 0; i < bArr.length - 1; i++) {
            b = (byte) (b + bArr[i]);
        }
        bArr[bArr.length - 1] = (byte) (b & 255);
    }

    public static String debugByteArray(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            StLog.w(TAG, "empty payload");
            return null;
        }
        String str = "";
        String str2 = str;
        for (byte b : bArr) {
            String str3 = str + Integer.toHexString(b & 255);
            if (str2.equals("")) {
                str2 = ", ";
            }
            str = str3 + str2;
        }
        return str;
    }

    public static RingSecurityPair getInstance() {
        return Holder.INSTANCE;
    }

    private static byte[] getSecretKey(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr2 == null)) {
            try {
                KeyFactory instance = KeyFactory.getInstance("EC");
                PublicKey generatePublic = instance.generatePublic(new X509EncodedKeySpec(bArr));
                PrivateKey generatePrivate = instance.generatePrivate(new PKCS8EncodedKeySpec(bArr2));
                KeyAgreement instance2 = KeyAgreement.getInstance("ECDH");
                instance2.init(generatePrivate);
                instance2.doPhase(generatePublic, true);
                MessageDigest instance3 = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
                instance3.update(instance2.generateSecret());
                instance3.update(staticKey);
                return instance3.digest();
            } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException e) {
                StLog.e(TAG, "getSecretKey error", e);
            }
        }
        return null;
    }

    private void handleServerKeyMsg(StDevice stDevice, byte[] bArr) throws JSONException {
        StLog.d(TAG, "handleServerKeyMsg len:" + bArr.length);
        StLog.d(TAG, "switchKeyData:" + printByteArray(bArr));
        SwitchKeyParse switchKeyParse = new SwitchKeyParse(bArr);
        byte[] devInfo = switchKeyParse.getDevInfo();
        byte[] ivParam = switchKeyParse.getIvParam();
        byte[] publicKey = switchKeyParse.getPublicKey();
        StLog.d(TAG, "publicKey " + printByteArray(publicKey));
        StLog.d(TAG, "publicKey len: " + publicKey.length);
        byte[] secretKey = getSecretKey(publicKey, StarryNetEncryptData.getInstance().getKeyPair(stDevice.getBleMac()).getPrivateKey());
        byte[] decrypt = EncryptionUtil.decrypt(devInfo, secretKey, ivParam, 1);
        StLog.d(TAG, "deviceInfo: " + printByteArray(decrypt));
        StLog.d(TAG, "SessionKey: " + printByteArray(secretKey));
        sendRemoteSwitchInfo(stDevice, secretKey, ivParam);
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null) {
            StLog.d(TAG, "Client BondInfo is null");
            this.mPairStatusCallback.onPairStatusChange(stDevice, 0, -1);
            return;
        }
        connectDevice.setCipher(secretKey, ivParam);
        connectDevice.setIdentifier(stDevice.getIdentifier());
        StarryDeviceManager.getInstance().updateBondInfo(connectDevice);
        StConnectDevice connectDevice2 = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        StLog.d(TAG, "getBleBondStatus:" + connectDevice2.getBleBondStatus());
    }

    private void handleServerSwitchInfoMsg(StDevice stDevice, byte[] bArr) throws JSONException {
        StDevice stDevice2 = stDevice;
        StLog.d(TAG, "handleServerInfoMsg");
        TLV tlv = new TLV();
        byte[] bArr2 = new byte[32];
        byte[] bArr3 = new byte[1];
        StLog.d(TAG, "infoData: " + printByteArray(bArr));
        try {
            byte[] unpack = tlv.unpack(bArr);
            PrintStream printStream = System.out;
            printStream.println("Unpacked TLV:");
            printStream.println("Type: " + tlv.getType());
            printStream.println("Length: " + tlv.getLength());
            printStream.println("Value: " + printByteArray(tlv.getValue()));
            StLog.d(TAG, "unParse: " + printByteArray(unpack));
            if (tlv.getType() == 15) {
                bArr2 = tlv.getValue();
            }
            byte[] unpack2 = tlv.unpack(unpack);
            printStream.println("Type: " + tlv.getType());
            printStream.println("Length: " + tlv.getLength());
            printStream.println("Value: " + printByteArray(tlv.getValue()));
            StLog.d(TAG, "unParse: " + printByteArray(unpack2));
            if (tlv.getType() == 16) {
                bArr3 = tlv.getValue();
            }
            StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
            byte[] decrypt = EncryptionUtil.decrypt(bArr3, connectDevice.getSecret(), connectDevice.getParam(), 1);
            byte[] bArr4 = new byte[4];
            byte[] bArr5 = new byte[1];
            try {
                byte[] unpack3 = tlv.unpack(decrypt);
                printStream.println("Unpacked TLV:");
                printStream.println("Type: " + tlv.getType());
                printStream.println("Length: " + tlv.getLength());
                printStream.println("Value: " + printByteArray(tlv.getValue()));
                if (tlv.getType() == 17) {
                    bArr4 = tlv.getValue();
                }
                tlv.unpack(unpack3);
                printStream.println("Type: " + tlv.getType());
                printStream.println("Length: " + tlv.getLength());
                printStream.println("Value: " + printByteArray(tlv.getValue()));
                if (tlv.getType() == 13) {
                    bArr5 = tlv.getValue();
                }
                if (!Arrays.equals(gRandom, bArr4)) {
                    StLog.w(TAG, "Random error!");
                }
                try {
                    MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
                    instance.update(bArr4);
                    instance.update(connectDevice.getSecret());
                    instance.update(bArr5);
                    byte[] digest = instance.digest();
                    StLog.d(TAG, "calcuHash: " + printByteArray(digest));
                    StLog.d(TAG, "peerHash: " + printByteArray(bArr2));
                    if (!Arrays.equals(digest, bArr2)) {
                        StLog.w(TAG, "Auth fail!");
                        this.mPairStatusCallback.onPairStatusChange(stDevice2, 0, -1);
                        return;
                    }
                    StLog.w(TAG, "Auth Success!");
                    this.mPairStatusCallback.onPairStatusChange(stDevice2, 0, 1);
                } catch (NoSuchAlgorithmException e) {
                    StLog.e(TAG, "hash error", (Throwable) e);
                }
            } catch (IllegalArgumentException e2) {
                PrintStream printStream2 = System.err;
                printStream2.println("Failed to unpack data: " + e2.getMessage());
            }
        } catch (IllegalArgumentException e3) {
            PrintStream printStream3 = System.err;
            printStream3.println("Failed to unpack data: " + e3.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public static String printByteArray(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            StLog.w(TAG, "empty byteArray");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02x ", new Object[]{Integer.valueOf(b & 255)}));
        }
        return sb.toString();
    }

    private void recombineFragment(int i, int i2, byte[] bArr) {
        StLog.d(TAG, "fragmentSize:" + i + "  currIndex:" + i2);
        if (i == 1) {
            byte[] bArr2 = new byte[(bArr.length - 3)];
            System.arraycopy(bArr, 3, bArr2, 0, bArr.length - 3);
            this.mBytesRecv = bArr2;
            return;
        }
        if (i2 == 1) {
            this.mBytesRecv = new byte[0];
        }
        byte[] bArr3 = new byte[(bArr.length - 3)];
        System.arraycopy(bArr, 3, bArr3, 0, bArr.length - 3);
        this.mBytesRecv = concatenate(this.mBytesRecv, bArr3);
    }

    private void sendRemoteSwitchInfo(StDevice stDevice, byte[] bArr, byte[] bArr2) throws JSONException {
        byte[] bArr3;
        StLog.d(TAG, "sendRemoteSwitchInfo");
        byte[] concatenate = concatenate(new TLV((byte) 11, stDevice.getBleMac().getBytes()).pack(), new TLV((byte) 12, stDevice.getModelID().getBytes()).pack());
        byte[] array = ByteBuffer.allocate(4).putInt(new Random().nextInt()).array();
        gRandom = array;
        StLog.d(TAG, "Random: " + printByteArray(gRandom));
        byte[] encrypt = EncryptionUtil.encrypt(concatenate(new TLV((byte) 17, array).pack(), new TLV((byte) 13, concatenate).pack()), bArr, bArr2, 1);
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            instance.update(array);
            instance.update(bArr);
            instance.update(concatenate);
            bArr3 = instance.digest();
            StLog.d(TAG, "outHash: " + printByteArray(bArr3));
        } catch (NoSuchAlgorithmException e) {
            StLog.e(TAG, "hash error", (Throwable) e);
            bArr3 = new byte[32];
        }
        byte[] concatenate2 = concatenate(new TLV((byte) 15, bArr3).pack(), new TLV((byte) 16, encrypt).pack());
        StarryNetData.getInstance().getIdentifier();
        StLog.d(TAG, "Random: " + printByteArray(gRandom));
        StLog.i(TAG, "outData:" + printByteArray(concatenate2));
        sendRingPairMsg(stDevice, (byte) 2, concatenate2);
    }

    private void sendRingPairMsg(StDevice stDevice, byte b, byte[] bArr) {
        int length = (bArr.length + 1) / 197;
        int i = length + 1;
        byte[] concatenate = concatenate(new byte[]{b}, bArr);
        StLog.d(TAG, "data len:" + bArr.length + " msgBody len:" + concatenate.length + " fragmentSize:" + i);
        int i2 = 0;
        while (i2 < i) {
            int length2 = i2 == length ? ((bArr.length + 1) % 197) + 3 : 200;
            byte[] bArr2 = new byte[length2];
            bArr2[0] = OPCODE_RING_PAIR;
            bArr2[1] = (byte) i;
            int i3 = i2 + 1;
            bArr2[2] = (byte) i3;
            System.arraycopy(concatenate, i2 * 197, bArr2, 3, length2 - 3);
            this.mPairStatusCallback.securityMessageSender(stDevice, bArr2);
            i2 = i3;
        }
    }

    public byte[] ClientDataDecrypt(byte[] bArr, StConnectDevice stConnectDevice) {
        return EncryptionUtil.decrypt(bArr, stConnectDevice.getSecret(), stConnectDevice.getParam(), 1);
    }

    public byte[] ClientDataEncrypt(byte[] bArr, String str) {
        StConnectDevice connectDevice = this.mPairStatusCallback.getConnectDevice(str);
        if (connectDevice != null) {
            return EncryptionUtil.encrypt(bArr, connectDevice.getSecret(), connectDevice.getParam(), 1);
        }
        StLog.e(TAG, "cannot get connected device info");
        return null;
    }

    public void clientCreateBond(StDevice stDevice) {
        StLog.d(TAG, "clientCreateBond:" + new String(stDevice.getIdentifier()));
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null || connectDevice.getBleBondStatus() != 4) {
            KeyPair generatorECKeyPair = EncryptionUtil.generatorECKeyPair();
            if (generatorECKeyPair == null) {
                StLog.d(TAG, "getMasterKeyViaWrite key is null");
                return;
            }
            StarryNetEncryptData.getInstance().saveKeyPair(stDevice.getBleMac(), generatorECKeyPair);
            sendRingPairMsg(stDevice, (byte) 1, new TLV((byte) 10, generatorECKeyPair.getPublicKey()).pack());
            return;
        }
        StLog.d(TAG, "device bonded, start auth.");
        try {
            sendRemoteSwitchInfo(connectDevice.getDevice(), connectDevice.getSecret(), connectDevice.getParam());
        } catch (JSONException e) {
            StLog.d(TAG, "JSONException:" + e.toString());
        }
    }

    public void getFwVer(StConnectDevice stConnectDevice) {
        byte[] bArr = new byte[16];
        bArr[0] = 39;
        crcValue(bArr);
        this.mPairStatusCallback.securityMessageSender(stConnectDevice.getDevice(), bArr);
    }

    public void getSN(StConnectDevice stConnectDevice) {
        byte[] bArr = new byte[67];
        bArr[0] = 7;
        bArr[1] = 2;
        crcValue(bArr);
        this.mPairStatusCallback.securityMessageSender(stConnectDevice.getDevice(), bArr);
    }

    public void handleRingInternalMessage(StDevice stDevice, byte[] bArr) {
        StLog.d(TAG, "handleRingPairMsg");
        if (bArr[0] == 112) {
            byte b = bArr[1];
            byte b2 = bArr[2];
            recombineFragment(b, b2, bArr);
            if (b2 == b) {
                try {
                    byte[] bArr2 = this.mBytesRecv;
                    byte[] bArr3 = new byte[(bArr2.length - 1)];
                    System.arraycopy(bArr2, 1, bArr3, 0, bArr2.length - 1);
                    byte b3 = this.mBytesRecv[0];
                    if (1 == b3) {
                        handleServerKeyMsg(stDevice, bArr3);
                    } else if (2 == b3) {
                        handleServerSwitchInfoMsg(stDevice, bArr3);
                    }
                } catch (JSONException e) {
                    StLog.d(TAG, "an except:" + e.toString());
                }
            }
        }
    }

    public void onResponse(StDevice stDevice, byte[] bArr, int i) {
    }

    public void registerPairStatusCallback(IMYVURingStatusCallback iMYVURingStatusCallback) {
        this.mPairStatusCallback = iMYVURingStatusCallback;
    }

    public void sendRemoveBondCmd(StConnectDevice stConnectDevice) {
        byte[] bArr = new byte[16];
        bArr[0] = OPCODE_PHONE_START_REMOVE_BOND;
        crcValue(bArr);
        this.mPairStatusCallback.securityMessageSender(stConnectDevice.getDevice(), bArr);
    }

    public void setEncryptionMode(StConnectDevice stConnectDevice, boolean z) {
        byte[] bArr = new byte[16];
        bArr[0] = 3;
        if (z) {
            bArr[10] = DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE;
        } else {
            bArr[10] = Byte.MIN_VALUE;
        }
        crcValue(bArr);
        this.mPairStatusCallback.securityMessageSender(stConnectDevice.getDevice(), bArr);
    }

    private RingSecurityPair() {
    }
}
