package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.util.ByteBufferUtils;
import org.java_websocket.util.Charsetfunctions;

public class CloseFrame extends ControlFrame {
    public int h;
    public String i;

    public CloseFrame() {
        super(Opcode.CLOSING);
        r("");
        q(1000);
    }

    public ByteBuffer a() {
        return this.h == 1005 ? ByteBufferUtils.a() : super.a();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        CloseFrame closeFrame = (CloseFrame) obj;
        if (this.h != closeFrame.h) {
            return false;
        }
        String str = this.i;
        return str != null ? str.equals(closeFrame.i) : closeFrame.i == null;
    }

    public void h() {
        super.h();
        if (this.h == 1007 && this.i.isEmpty()) {
            throw new InvalidDataException(1007, "Received text is no valid utf8 string!");
        } else if (this.h != 1005 || this.i.length() <= 0) {
            int i2 = this.h;
            if (i2 > 1015 && i2 < 3000) {
                throw new InvalidDataException(1002, "Trying to send an illegal close code!");
            } else if (i2 == 1006 || i2 == 1015 || i2 == 1005 || i2 > 4999 || i2 < 1000 || i2 == 1004) {
                throw new InvalidFrameException("closecode must not be sent over the wire: " + this.h);
            }
        } else {
            throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
        }
    }

    public int hashCode() {
        int hashCode = ((super.hashCode() * 31) + this.h) * 31;
        String str = this.i;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public void j(ByteBuffer byteBuffer) {
        this.h = 1005;
        this.i = "";
        byteBuffer.mark();
        if (byteBuffer.remaining() == 0) {
            this.h = 1000;
        } else if (byteBuffer.remaining() == 1) {
            this.h = 1002;
        } else {
            if (byteBuffer.remaining() >= 2) {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.position(2);
                allocate.putShort(byteBuffer.getShort());
                allocate.position(0);
                this.h = allocate.getInt();
            }
            byteBuffer.reset();
            try {
                t(byteBuffer, byteBuffer.position());
            } catch (InvalidDataException unused) {
                this.h = 1007;
                this.i = null;
            }
        }
    }

    public int o() {
        return this.h;
    }

    public String p() {
        return this.i;
    }

    public void q(int i2) {
        this.h = i2;
        if (i2 == 1015) {
            this.h = 1005;
            this.i = "";
        }
        s();
    }

    public void r(String str) {
        if (str == null) {
            str = "";
        }
        this.i = str;
        s();
    }

    public final void s() {
        byte[] f = Charsetfunctions.f(this.i);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(this.h);
        allocate.position(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(f.length + 2);
        allocate2.put(allocate);
        allocate2.put(f);
        allocate2.rewind();
        super.j(allocate2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        throw new org.java_websocket.exceptions.InvalidDataException(1007);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        r2.position(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(java.nio.ByteBuffer r2, int r3) {
        /*
            r1 = this;
            int r0 = r2.position()     // Catch:{ IllegalArgumentException -> 0x0015 }
            int r0 = r0 + 2
            r2.position(r0)     // Catch:{ IllegalArgumentException -> 0x0015 }
            java.lang.String r0 = org.java_websocket.util.Charsetfunctions.e(r2)     // Catch:{ IllegalArgumentException -> 0x0015 }
            r1.i = r0     // Catch:{ IllegalArgumentException -> 0x0015 }
            r2.position(r3)
            return
        L_0x0013:
            r1 = move-exception
            goto L_0x001d
        L_0x0015:
            org.java_websocket.exceptions.InvalidDataException r1 = new org.java_websocket.exceptions.InvalidDataException     // Catch:{ all -> 0x0013 }
            r0 = 1007(0x3ef, float:1.411E-42)
            r1.<init>(r0)     // Catch:{ all -> 0x0013 }
            throw r1     // Catch:{ all -> 0x0013 }
        L_0x001d:
            r2.position(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.java_websocket.framing.CloseFrame.t(java.nio.ByteBuffer, int):void");
    }

    public String toString() {
        return super.toString() + "code: " + this.h;
    }
}
