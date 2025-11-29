package androidx.datastore.preferences.protobuf;

abstract class UnknownFieldSchema<T, B> {
    public abstract void a(Object obj, int i, int i2);

    public abstract void b(Object obj, int i, long j);

    public abstract void c(Object obj, int i, Object obj2);

    public abstract void d(Object obj, int i, ByteString byteString);

    public abstract void e(Object obj, int i, long j);

    public abstract Object f(Object obj);

    public abstract Object g(Object obj);

    public abstract int h(Object obj);

    public abstract int i(Object obj);

    public abstract void j(Object obj);

    public abstract Object k(Object obj, Object obj2);

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000d, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(java.lang.Object r3, androidx.datastore.preferences.protobuf.Reader r4) {
        /*
            r2 = this;
        L_0x0000:
            int r0 = r4.getFieldNumber()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x000f
            boolean r0 = r2.m(r3, r4)
            if (r0 != 0) goto L_0x0000
        L_0x000f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.UnknownFieldSchema.l(java.lang.Object, androidx.datastore.preferences.protobuf.Reader):void");
    }

    public final boolean m(Object obj, Reader reader) {
        int tag = reader.getTag();
        int a2 = WireFormat.a(tag);
        int b = WireFormat.b(tag);
        if (b == 0) {
            e(obj, a2, reader.readInt64());
            return true;
        } else if (b == 1) {
            b(obj, a2, reader.readFixed64());
            return true;
        } else if (b == 2) {
            d(obj, a2, reader.readBytes());
            return true;
        } else if (b == 3) {
            Object n = n();
            int c = WireFormat.c(a2, 4);
            l(n, reader);
            if (c == reader.getTag()) {
                c(obj, a2, r(n));
                return true;
            }
            throw InvalidProtocolBufferException.invalidEndTag();
        } else if (b == 4) {
            return false;
        } else {
            if (b == 5) {
                a(obj, a2, reader.readFixed32());
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    public abstract Object n();

    public abstract void o(Object obj, Object obj2);

    public abstract void p(Object obj, Object obj2);

    public abstract boolean q(Reader reader);

    public abstract Object r(Object obj);

    public abstract void s(Object obj, Writer writer);

    public abstract void t(Object obj, Writer writer);
}
