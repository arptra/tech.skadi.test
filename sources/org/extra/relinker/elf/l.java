package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class l extends f {
    public l(i iVar, d dVar, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(dVar.f3355a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f3357a = iVar.o(allocate, dVar.d + ((long) (i * dVar.g)) + 28);
    }
}
