package com.honey.account.f3;

import com.ucar.protocol.MemUtil;
import java.nio.ByteBuffer;
import java.util.function.Supplier;

public final /* synthetic */ class b implements Supplier {
    public final Object get() {
        return ByteBuffer.wrap(MemUtil.e(131072));
    }
}
