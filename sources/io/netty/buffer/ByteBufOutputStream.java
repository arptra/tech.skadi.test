package io.netty.buffer;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteBufOutputStream extends OutputStream implements DataOutput {
    private final ByteBuf buffer;
    private boolean closed;
    private final int startIndex;
    private DataOutputStream utf8out;

    public ByteBufOutputStream(ByteBuf byteBuf) {
        this.buffer = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "buffer");
        this.startIndex = byteBuf.writerIndex();
    }

    public ByteBuf buffer() {
        return this.buffer;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            try {
                super.close();
                DataOutputStream dataOutputStream = this.utf8out;
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
            } catch (Throwable th) {
                if (this.utf8out != null) {
                    this.utf8out.close();
                }
                throw th;
            }
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 != 0) {
            this.buffer.writeBytes(bArr, i, i2);
        }
    }

    public void writeBoolean(boolean z) throws IOException {
        this.buffer.writeBoolean(z);
    }

    public void writeByte(int i) throws IOException {
        this.buffer.writeByte(i);
    }

    public void writeBytes(String str) throws IOException {
        this.buffer.writeCharSequence(str, CharsetUtil.US_ASCII);
    }

    public void writeChar(int i) throws IOException {
        this.buffer.writeChar(i);
    }

    public void writeChars(String str) throws IOException {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            this.buffer.writeChar(str.charAt(i));
        }
    }

    public void writeDouble(double d) throws IOException {
        this.buffer.writeDouble(d);
    }

    public void writeFloat(float f) throws IOException {
        this.buffer.writeFloat(f);
    }

    public void writeInt(int i) throws IOException {
        this.buffer.writeInt(i);
    }

    public void writeLong(long j) throws IOException {
        this.buffer.writeLong(j);
    }

    public void writeShort(int i) throws IOException {
        this.buffer.writeShort((short) i);
    }

    public void writeUTF(String str) throws IOException {
        DataOutputStream dataOutputStream = this.utf8out;
        if (dataOutputStream == null) {
            if (!this.closed) {
                dataOutputStream = new DataOutputStream(this);
                this.utf8out = dataOutputStream;
            } else {
                throw new IOException("The stream is closed");
            }
        }
        dataOutputStream.writeUTF(str);
    }

    public int writtenBytes() {
        return this.buffer.writerIndex() - this.startIndex;
    }

    public void write(byte[] bArr) throws IOException {
        this.buffer.writeBytes(bArr);
    }

    public void write(int i) throws IOException {
        this.buffer.writeByte(i);
    }
}
