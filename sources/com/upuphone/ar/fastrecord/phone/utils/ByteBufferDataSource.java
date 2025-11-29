package com.upuphone.ar.fastrecord.phone.utils;

import android.media.MediaDataSource;
import java.io.IOException;
import java.nio.ByteBuffer;

class ByteBufferDataSource extends MediaDataSource {
    private ByteBuffer mBuffer;

    public ByteBufferDataSource(ByteBuffer byteBuffer) {
        this.mBuffer = byteBuffer;
    }

    public void close() throws IOException {
    }

    public long getSize() throws IOException {
        return (long) this.mBuffer.capacity();
    }

    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        int min = Math.min(i2, (int) (((long) this.mBuffer.capacity()) - j));
        this.mBuffer.position((int) j).limit((int) (j + ((long) min)));
        this.mBuffer.get(bArr, i, min);
        return min;
    }
}
