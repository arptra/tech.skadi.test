package androidx.datastore.preferences.protobuf;

class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    /* renamed from: A */
    public UnknownFieldSetLite g(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    /* renamed from: B */
    public int h(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.f();
    }

    /* renamed from: C */
    public int i(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.g();
    }

    /* renamed from: D */
    public UnknownFieldSetLite k(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        return unknownFieldSetLite2.equals(UnknownFieldSetLite.e()) ? unknownFieldSetLite : UnknownFieldSetLite.k(unknownFieldSetLite, unknownFieldSetLite2);
    }

    /* renamed from: E */
    public UnknownFieldSetLite n() {
        return UnknownFieldSetLite.l();
    }

    /* renamed from: F */
    public void o(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        p(obj, unknownFieldSetLite);
    }

    /* renamed from: G */
    public void p(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        ((GeneratedMessageLite) obj).unknownFields = unknownFieldSetLite;
    }

    /* renamed from: H */
    public UnknownFieldSetLite r(UnknownFieldSetLite unknownFieldSetLite) {
        unknownFieldSetLite.j();
        return unknownFieldSetLite;
    }

    /* renamed from: I */
    public void s(UnknownFieldSetLite unknownFieldSetLite, Writer writer) {
        unknownFieldSetLite.o(writer);
    }

    /* renamed from: J */
    public void t(UnknownFieldSetLite unknownFieldSetLite, Writer writer) {
        unknownFieldSetLite.q(writer);
    }

    public void j(Object obj) {
        g(obj).j();
    }

    public boolean q(Reader reader) {
        return false;
    }

    /* renamed from: u */
    public void a(UnknownFieldSetLite unknownFieldSetLite, int i, int i2) {
        unknownFieldSetLite.n(WireFormat.c(i, 5), Integer.valueOf(i2));
    }

    /* renamed from: v */
    public void b(UnknownFieldSetLite unknownFieldSetLite, int i, long j) {
        unknownFieldSetLite.n(WireFormat.c(i, 1), Long.valueOf(j));
    }

    /* renamed from: w */
    public void c(UnknownFieldSetLite unknownFieldSetLite, int i, UnknownFieldSetLite unknownFieldSetLite2) {
        unknownFieldSetLite.n(WireFormat.c(i, 3), unknownFieldSetLite2);
    }

    /* renamed from: x */
    public void d(UnknownFieldSetLite unknownFieldSetLite, int i, ByteString byteString) {
        unknownFieldSetLite.n(WireFormat.c(i, 2), byteString);
    }

    /* renamed from: y */
    public void e(UnknownFieldSetLite unknownFieldSetLite, int i, long j) {
        unknownFieldSetLite.n(WireFormat.c(i, 0), Long.valueOf(j));
    }

    /* renamed from: z */
    public UnknownFieldSetLite f(Object obj) {
        UnknownFieldSetLite A = g(obj);
        if (A != UnknownFieldSetLite.e()) {
            return A;
        }
        UnknownFieldSetLite l = UnknownFieldSetLite.l();
        p(obj, l);
        return l;
    }
}
