package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class b extends c {
    public b(i iVar, d dVar, long j, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(dVar.f3355a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + ((long) (i * 16));
        this.f3354a = iVar.j(allocate, j2);
        this.b = iVar.j(allocate, j2 + 8);
    }
}
