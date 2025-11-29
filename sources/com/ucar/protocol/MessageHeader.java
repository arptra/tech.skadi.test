package com.ucar.protocol;

import com.honey.account.f3.c;
import java.util.Calendar;
import kotlin.UShort;

public class MessageHeader {
    public static final ThreadLocal g = ThreadLocal.withInitial(new c());

    /* renamed from: a  reason: collision with root package name */
    public final CmdDescription f9634a;
    public int b;
    public int c;
    public int d;
    public short e;
    public short f;

    public MessageHeader(int i, CmdDescription cmdDescription) {
        ParamValidation.c(cmdDescription, "cmdDescription");
        this.b = i;
        if (i >= 20) {
            this.c = SequenceGenerator.a();
            this.d = (int) (System.currentTimeMillis() / 1000);
            this.f9634a = cmdDescription;
            this.f = 0;
            s();
            return;
        }
        throw new ProtocolException("Illegal message size: " + i);
    }

    public static /* synthetic */ byte[] i() {
        return new byte[20];
    }

    public static MessageHeader j() {
        return new MessageHeader(20, new CmdDescription(UCarProtocol.f(), DataFormat.RAW, MessageType.SEND, CmdCategory.CONTROL, 0));
    }

    public static CmdDescription m(byte[] bArr, CmdDescription cmdDescription) {
        byte b2 = bArr[12] & 1;
        SourceDevice sourceDevice = SourceDevice.PHONE;
        if (b2 != sourceDevice.getValue()) {
            sourceDevice = SourceDevice.CAR;
        }
        cmdDescription.g(sourceDevice, DataFormat.ofValue((bArr[12] & 6) >>> 1), p(bArr[12]), o(bArr[13]), (bArr[14] << 8) + bArr[15]);
        return cmdDescription;
    }

    public static byte[] n() {
        return (byte[]) g.get();
    }

    public static CmdCategory o(int i) {
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
        throw new ProtocolException("Unknown CmdCategory: " + i);
    }

    public static MessageType p(byte b2) {
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

    public MessageHeader b(MessageHeader messageHeader) {
        this.b = messageHeader.b;
        this.c = messageHeader.c;
        this.d = messageHeader.d;
        CmdDescription e2 = messageHeader.e();
        this.f9634a.g(e2.e(), e2.b(), e2.c(), e2.a(), e2.d());
        this.f = messageHeader.f;
        return this;
    }

    public void c(byte[] bArr) {
        ParamValidation.c(bArr, "rawBytes");
        if (bArr.length >= 20) {
            int a2 = ByteUtil.a(bArr, 0);
            int a3 = ByteUtil.a(bArr, 4);
            int a4 = ByteUtil.a(bArr, 8);
            short b2 = ByteUtil.b(bArr, 16);
            short b3 = ByteUtil.b(bArr, 18);
            short a5 = Crc16.a(bArr, 0, 18);
            if (b3 == a5) {
                m(bArr, e());
                this.b = a2;
                this.c = a3;
                this.d = a4;
                this.f = b2;
                return;
            }
            throw new ProtocolException("Invalid header, checksum expect: " + Integer.toHexString(a5) + ", actual: " + Integer.toHexString(b3));
        }
        throw new ProtocolException("Protocol header bytes size[" + bArr.length + "] < " + 20);
    }

    public final String d() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(((long) this.d) * 1000);
        return "--------------------------------\n" + "length: " + this.b + ", seqId: " + this.c + ", checksum: " + Integer.toHexString(this.e & UShort.MAX_VALUE) + 10 + "timestamp(s): " + this.d + " (" + instance.getTime() + ")\ncmd: " + this.f9634a + 10 + "--------------------------------\n";
    }

    public final CmdDescription e() {
        return this.f9634a;
    }

    public final int f() {
        return this.b;
    }

    public final int g() {
        return this.c;
    }

    public boolean h() {
        CmdDescription e2 = e();
        return e2 != null && e2.b() == DataFormat.RAW_NO_ENCRYPTED;
    }

    public MessageHeader k(int i, DataFormat dataFormat, MessageType messageType, CmdCategory cmdCategory, int i2) {
        return l(i, 0, ProtocolConfig.e(), dataFormat, messageType, cmdCategory, i2);
    }

    public MessageHeader l(int i, short s, SourceDevice sourceDevice, DataFormat dataFormat, MessageType messageType, CmdCategory cmdCategory, int i2) {
        this.b = i;
        this.c = SequenceGenerator.a();
        this.d = (int) (System.currentTimeMillis() / 1000);
        this.f9634a.g(sourceDevice, dataFormat, messageType, cmdCategory, i2);
        this.f = s;
        s();
        return this;
    }

    public final byte[] q() {
        byte[] bArr = (byte[]) g.get();
        w(bArr);
        return bArr;
    }

    public final void r(int i) {
        if (i >= 0) {
            this.b = i + 20;
            s();
            return;
        }
        throw new ProtocolException("Message body length must not less than 0");
    }

    public final void s() {
        w(n());
    }

    public final void t(int i) {
        if (i >= 20) {
            this.b = i;
            s();
            return;
        }
        throw new ProtocolException("Update message length error: " + i);
    }

    public String toString() {
        return d();
    }

    public void u(MessageType messageType) {
        e().h(messageType);
        s();
    }

    public final void v(int i) {
        if (i < 0) {
            throw new ProtocolException("seq id must greater than 0");
        } else if (this.f9634a.c() == MessageType.RES) {
            this.c = i;
            s();
        } else {
            throw new ProtocolException(this.f9634a.c() + " can not update seq id");
        }
    }

    public final void w(byte[] bArr) {
        ParamValidation.c(bArr, "headerBytes");
        if (bArr.length >= 20) {
            ByteUtil.c(bArr, 0, this.b);
            ByteUtil.c(bArr, 4, this.c);
            ByteUtil.c(bArr, 8, this.d);
            x(bArr);
            ByteUtil.d(bArr, 16, this.f);
            short a2 = Crc16.a(bArr, 0, 18);
            this.e = a2;
            ByteUtil.d(bArr, 18, a2);
            return;
        }
        throw new ProtocolException("Can not write bytes to headerBytes");
    }

    public final void x(byte[] bArr) {
        SourceDevice e2 = this.f9634a.e();
        DataFormat b2 = this.f9634a.b();
        CmdCategory a2 = this.f9634a.a();
        MessageType c2 = this.f9634a.c();
        ParamValidation.b(e2, "sourceDevice");
        ParamValidation.b(b2, "dataFormat");
        ParamValidation.b(b2, "dataFormat");
        ParamValidation.b(a2, "messageType");
        byte value = (byte) e2.getValue();
        bArr[12] = value;
        byte value2 = (byte) (value + ((byte) (b2.getValue() << 1)));
        bArr[12] = value2;
        bArr[12] = (byte) (value2 + ((byte) (c2.getValue() << 3)));
        bArr[13] = (byte) a2.getValue();
        bArr[14] = (byte) ((this.f9634a.d() >>> 8) & 255);
        bArr[15] = (byte) (this.f9634a.d() & 255);
    }
}
