package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class j extends e {
    public j(i iVar, d dVar, long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(dVar.f3355a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = dVar.c + (j * ((long) dVar.e));
        this.f3356a = iVar.o(allocate, j2);
        this.b = iVar.o(allocate, 4 + j2);
        this.c = iVar.o(allocate, 8 + j2);
        this.d = iVar.o(allocate, j2 + 20);
    }
}
