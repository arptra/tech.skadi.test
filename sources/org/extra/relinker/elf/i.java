package org.extra.relinker.elf;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.UShort;
import okhttp3.internal.ws.WebSocketProtocol;

public class i implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final int f3358a = 1179403647;
    public final FileChannel b;

    public i(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.b = new FileInputStream(file).getChannel();
    }

    public final long a(d dVar, long j, long j2) {
        for (long j3 = 0; j3 < j; j3++) {
            e b2 = dVar.b(j3);
            if (b2.f3356a == 1) {
                long j4 = b2.c;
                if (j4 <= j2 && j2 <= b2.d + j4) {
                    return (j2 - j4) + b2.b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public d b() {
        this.b.position(0);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (o(allocate, 0) == 1179403647) {
            short c = c(allocate, 4);
            boolean z = c(allocate, 5) == 2;
            if (c == 1) {
                return new g(z, this);
            }
            if (c == 2) {
                return new h(z, this);
            }
            throw new IllegalStateException("Invalid class type!");
        }
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    public short c(ByteBuffer byteBuffer, long j) {
        d(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
    }

    public void close() {
        this.b.close();
    }

    public void d(ByteBuffer byteBuffer, long j, int i) {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < ((long) i)) {
            int read = this.b.read(byteBuffer, j + j2);
            if (read != -1) {
                j2 += (long) read;
            } else {
                throw new EOFException();
            }
        }
        byteBuffer.position(0);
    }

    public int g(ByteBuffer byteBuffer, long j) {
        d(byteBuffer, j, 2);
        return byteBuffer.getShort() & UShort.MAX_VALUE;
    }

    public List i() {
        long j;
        this.b.position(0);
        ArrayList arrayList = new ArrayList();
        d b2 = b();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(b2.f3355a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = (long) b2.f;
        int i = 0;
        if (j2 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j2 = b2.c(0).f3357a;
        }
        long j3 = 0;
        while (true) {
            if (j3 >= j2) {
                j = 0;
                break;
            }
            e b3 = b2.b(j3);
            if (b3.f3356a == 2) {
                j = b3.b;
                break;
            }
            j3++;
        }
        if (j == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList<Long> arrayList2 = new ArrayList<>();
        long j4 = 0;
        while (true) {
            c a2 = b2.a(j, i);
            long j5 = a2.f3354a;
            if (j5 == 1) {
                arrayList2.add(Long.valueOf(a2.b));
            } else if (j5 == 5) {
                j4 = a2.b;
            }
            i++;
            if (a2.f3354a == 0) {
                break;
            }
        }
        if (j4 != 0) {
            long a3 = a(b2, j2, j4);
            for (Long longValue : arrayList2) {
                arrayList.add(n(allocate, longValue.longValue() + a3));
            }
            return arrayList;
        }
        throw new IllegalStateException("String table offset not found!");
    }

    public long j(ByteBuffer byteBuffer, long j) {
        d(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    public String n(ByteBuffer byteBuffer, long j) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short c = c(byteBuffer, j);
            if (c == 0) {
                return sb.toString();
            }
            sb.append((char) c);
            j = j2;
        }
    }

    public long o(ByteBuffer byteBuffer, long j) {
        d(byteBuffer, j, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }
}
