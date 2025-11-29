package com.upuphone.starryiccoaproto;

import com.honey.account.r6.a;
import java.util.Calendar;
import kotlin.UShort;

public class MessageHeader {
    public static final ThreadLocal g = ThreadLocal.withInitial(new a());

    /* renamed from: a  reason: collision with root package name */
    public final CmdDescription f6515a;
    public int b;
    public int c;
    public int d;
    public short e;
    public short f;

    public MessageHeader(int i, int i2, int i3, CmdDescription cmdDescription, short s, short s2) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.f6515a = cmdDescription;
        this.f = s;
        this.e = s2;
    }

    public static MessageHeader b(byte[] bArr) {
        if (bArr.length >= 20) {
            int a2 = ByteUtil.a(bArr, 0);
            int a3 = ByteUtil.a(bArr, 4);
            int a4 = ByteUtil.a(bArr, 8);
            CmdDescription e2 = e(bArr, new CmdDescription());
            short b2 = ByteUtil.b(bArr, 16);
            short b3 = ByteUtil.b(bArr, 18);
            short a5 = Crc16.a(bArr, 0, 18);
            if (b3 == a5) {
                return new MessageHeader(a2, a3, a4, e2, b2, b3);
            }
            throw new IllegalArgumentException("Invalid header, checksum expect: " + Integer.toHexString(a5) + ", actual: " + Integer.toHexString(b3));
        }
        throw new IllegalArgumentException("Protocol header bytes size[" + bArr.length + "] < " + 20);
    }

    public static /* synthetic */ byte[] d() {
        return new byte[20];
    }

    public static CmdDescription e(byte[] bArr, CmdDescription cmdDescription) {
        byte b2 = bArr[12] & 1;
        SourceDevice sourceDevice = SourceDevice.PHONE;
        if (b2 != sourceDevice.getValue()) {
            sourceDevice = SourceDevice.CAR;
        }
        SourceDevice sourceDevice2 = sourceDevice;
        int i = (bArr[12] & 6) >>> 1;
        DataFormat dataFormat = DataFormat.PB3;
        cmdDescription.f(sourceDevice2, i == dataFormat.getValue() ? dataFormat : DataFormat.RAW, h(bArr[12]), g(bArr[13]), (bArr[14] << 8) + bArr[15]);
        return cmdDescription;
    }

    public static byte[] f() {
        return (byte[]) g.get();
    }

    public static CmdCategory g(int i) {
        CmdCategory cmdCategory = CmdCategory.NONE;
        CmdCategory[] values = CmdCategory.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            CmdCategory cmdCategory2 = values[i2];
            if (i == cmdCategory2.getValue()) {
                cmdCategory = cmdCategory2;
                break;
            }
            i2++;
        }
        if (cmdCategory != CmdCategory.NONE) {
            return cmdCategory;
        }
        throw new IllegalArgumentException("Unknown CmdCategory: " + i);
    }

    public static MessageType h(byte b2) {
        int i = (b2 & 24) >>> 3;
        MessageType messageType = MessageType.REQ;
        if (i == messageType.getValue()) {
            return messageType;
        }
        MessageType messageType2 = MessageType.RES;
        if (i == messageType2.getValue()) {
            return messageType2;
        }
        MessageType messageType3 = MessageType.SEND_SYNC;
        return i == messageType3.getValue() ? messageType3 : MessageType.SEND;
    }

    public final String c() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(((long) this.d) * 1000);
        return "--------------------------------\n" + "length: " + this.b + ", seqId: " + this.c + ", checksum: " + Integer.toHexString(this.e & UShort.MAX_VALUE) + 10 + "timestamp(s): " + this.d + " (" + instance.getTime() + ")\ncmd: " + this.f6515a + 10 + "--------------------------------\n";
    }

    public final byte[] i() {
        byte[] bArr = (byte[]) g.get();
        m(bArr);
        return bArr;
    }

    public final void j(int i) {
        if (i >= 0) {
            this.b = i + 20;
            k();
            return;
        }
        throw new IllegalArgumentException("Message body length must not less than 0");
    }

    public final void k() {
        m(f());
    }

    public final void l(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("seq id must greater than 0");
        } else if (this.f6515a.c() == MessageType.RES) {
            this.c = i;
            k();
        } else {
            throw new IllegalArgumentException(this.f6515a.c() + " can not update seq id");
        }
    }

    public final void m(byte[] bArr) {
        if (bArr.length >= 20) {
            ByteUtil.c(bArr, 0, this.b);
            ByteUtil.c(bArr, 4, this.c);
            ByteUtil.c(bArr, 8, this.d);
            n(bArr);
            ByteUtil.d(bArr, 16, this.f);
            short a2 = Crc16.a(bArr, 0, 18);
            this.e = a2;
            ByteUtil.d(bArr, 18, a2);
            return;
        }
        throw new IllegalArgumentException("Can not write bytes to headerBytes");
    }

    public final void n(byte[] bArr) {
        SourceDevice e2 = this.f6515a.e();
        DataFormat b2 = this.f6515a.b();
        CmdCategory a2 = this.f6515a.a();
        MessageType c2 = this.f6515a.c();
        byte value = (byte) e2.getValue();
        bArr[12] = value;
        byte value2 = (byte) (value + ((byte) (b2.getValue() << 1)));
        bArr[12] = value2;
        bArr[12] = (byte) (value2 + ((byte) (c2.getValue() << 3)));
        bArr[13] = (byte) a2.getValue();
        bArr[14] = (byte) ((this.f6515a.d() >>> 8) & 255);
        bArr[15] = (byte) (this.f6515a.d() & 255);
    }

    public String toString() {
        return c();
    }

    public MessageHeader(int i, CmdDescription cmdDescription) {
        this.b = i;
        if (i >= 20) {
            this.c = SequenceGenerator.a();
            this.d = (int) (System.currentTimeMillis() / 1000);
            this.f6515a = cmdDescription;
            this.f = 0;
            k();
            return;
        }
        throw new IllegalArgumentException("Illegal message size: " + i);
    }
}
