package com.ucar.protocol;

import java.nio.ByteBuffer;

public class UCarMessage {

    /* renamed from: a  reason: collision with root package name */
    public final MessageHeader f9638a;
    public ByteBuffer b;
    public int c;
    public final boolean d;
    public final int e;

    public UCarMessage(boolean z) {
        this.f9638a = MessageHeader.j();
        this.d = z;
        this.e = z ? k() : -1;
    }

    public static boolean p(UCarMessage uCarMessage) {
        return uCarMessage != null && uCarMessage.h() == MessageType.SEND_SYNC;
    }

    public static UCarMessageBuilder q() {
        return new UCarMessageBuilder();
    }

    public static UCarMessage r(boolean z) {
        return new UCarMessage(z);
    }

    public static UCarMessage s() {
        return UCarMessagePool.a().b();
    }

    public static UCarMessage t(int i) {
        UCarMessage s = s();
        s.g().k(20, DataFormat.RAW, MessageType.RES, CmdCategory.ACK, 0).v(i);
        s.x(MemUtil.b, 0);
        return s;
    }

    public UCarMessage A(int i) {
        this.f9638a.v(i);
        return this;
    }

    public String a() {
        StringBuilder sb = new StringBuilder(this.f9638a.toString());
        if (this.f9638a.e().b() == DataFormat.PB3) {
            sb.append("Protobuf Data(");
            sb.append(this.c);
            sb.append(")\n");
        } else if (this.f9638a.e().b() == DataFormat.RAW) {
            sb.append("RAW Data(");
            sb.append(this.c);
            sb.append(")\n");
        } else if (this.f9638a.e().b() == DataFormat.RAW_NO_ENCRYPTED) {
            sb.append("RAW_NO_ENCRYPTED Data(");
            sb.append(this.c);
            sb.append(")\n");
        }
        sb.append("--------------------------------\n");
        return sb.toString();
    }

    public ByteBuffer b() {
        return this.b;
    }

    public ByteBuffer c() {
        return this.b;
    }

    public byte[] d() {
        if (!n() && this.b.hasArray() && this.b.array().length == this.c) {
            return this.b.array();
        }
        byte[] bArr = new byte[this.c];
        this.b.mark();
        this.b.get(bArr, 0, this.c);
        this.b.reset();
        return bArr;
    }

    public int e() {
        return this.c;
    }

    public CmdCategory f() {
        return this.f9638a.e().a();
    }

    public MessageHeader g() {
        return this.f9638a;
    }

    public MessageType h() {
        return this.f9638a.e().c();
    }

    public int i() {
        return this.f9638a.e().d();
    }

    public int j() {
        return this.e;
    }

    public int k() {
        return this.f9638a.g();
    }

    public byte[] l() {
        if (this.b.hasArray()) {
            return this.b.array();
        }
        byte[] e2 = MemUtil.e(e());
        this.b.get(e2, 0, e());
        this.b.position(0);
        return e2;
    }

    public boolean m() {
        CmdDescription e2 = g().e();
        ParamValidation.b(e2, "header.cmdDescription");
        return e2.b() == DataFormat.PB3;
    }

    public boolean n() {
        return this.d;
    }

    public boolean o() {
        CmdDescription e2 = g().e();
        ParamValidation.b(e2, "header.cmdDescription");
        return e2.f();
    }

    public String toString() {
        return a();
    }

    public synchronized void u() {
        if (n()) {
            UCarMessagePool.a().c(this);
        }
    }

    public void v(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = MemUtil.b;
        }
        w(byteBuffer, byteBuffer.remaining());
    }

    public void w(ByteBuffer byteBuffer, int i) {
        if (byteBuffer == null && i != 0) {
            throw new ProtocolException("null body expect 0 body length, but get: " + i);
        } else if (byteBuffer == null || byteBuffer.remaining() == i) {
            this.c = i;
            if (byteBuffer == null || i == 0) {
                this.b = MemUtil.b;
                return;
            }
            ByteBuffer byteBuffer2 = this.b;
            if (byteBuffer2 != null && byteBuffer2.capacity() > 131072) {
                this.b = null;
            }
            ByteBuffer byteBuffer3 = this.b;
            if (byteBuffer3 == null || byteBuffer3.capacity() < i) {
                int y = y(i);
                if (y >= i) {
                    i = y;
                }
                this.b = ByteBuffer.allocate(i);
            } else {
                this.b.clear();
            }
            this.b.put(byteBuffer);
            this.b.flip();
        } else {
            throw new ProtocolException("invalid param, expect body length: " + byteBuffer.remaining() + ", but get:" + i);
        }
    }

    public void x(ByteBuffer byteBuffer, int i) {
        this.b = byteBuffer;
        this.c = i;
    }

    public final int y(int i) {
        int i2 = i - 1;
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        int i7 = i6 | (i6 >>> 16);
        if (i7 < 0) {
            return 1;
        }
        return 1 + i7;
    }

    public UCarMessage z(MessageType messageType) {
        this.f9638a.u(messageType);
        return this;
    }

    public UCarMessage(MessageHeader messageHeader, byte[] bArr) {
        this(messageHeader, bArr, bArr.length);
    }

    public UCarMessage(MessageHeader messageHeader, byte[] bArr, int i) {
        ParamValidation.c(messageHeader, "header");
        ParamValidation.c(bArr, "body");
        this.f9638a = messageHeader;
        this.d = false;
        this.c = i;
        this.b = ByteBuffer.wrap(bArr);
        this.e = -1;
    }

    public UCarMessage(MessageHeader messageHeader, ByteBuffer byteBuffer, int i) {
        if (byteBuffer.remaining() == i) {
            this.f9638a = messageHeader;
            this.d = false;
            this.b = byteBuffer;
            this.c = i;
            this.e = -1;
            return;
        }
        throw new ProtocolException("Create message from ByteBuffer error: body len invalid");
    }
}
