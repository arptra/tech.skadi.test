package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class a extends c {
    public a(i iVar, d dVar, long j, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(dVar.f3355a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + ((long) (i * 8));
        this.f3354a = iVar.o(allocate, j2);
        this.b = iVar.o(allocate, j2 + 4);
    }
}
