package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class k extends e {
    public k(i iVar, d dVar, long j) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(dVar.f3355a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = dVar.c + (j * ((long) dVar.e));
        this.f3356a = iVar.o(allocate, j2);
        this.b = iVar.j(allocate, 8 + j2);
        this.c = iVar.j(allocate, 16 + j2);
        this.d = iVar.j(allocate, j2 + 40);
    }
}
