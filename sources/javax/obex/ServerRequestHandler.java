package javax.obex;

public class ServerRequestHandler {

    /* renamed from: a  reason: collision with root package name */
    public long f3696a;

    public long a() {
        return this.f3696a;
    }

    public int b(HeaderSet headerSet, HeaderSet headerSet2) {
        return 209;
    }

    public void c(byte[] bArr) {
    }

    public void d() {
    }

    public int e(HeaderSet headerSet, HeaderSet headerSet2) {
        return 160;
    }

    public int f(HeaderSet headerSet, HeaderSet headerSet2) {
        return 209;
    }

    public void g(HeaderSet headerSet, HeaderSet headerSet2) {
    }

    public int h(Operation operation) {
        return 209;
    }

    public int i(Operation operation) {
        return 209;
    }

    public int j(HeaderSet headerSet, HeaderSet headerSet2, boolean z, boolean z2) {
        return 209;
    }

    public void k(long j) {
        if (j < -1 || j > 4294967295L) {
            throw new IllegalArgumentException("Illegal Connection ID");
        }
        this.f3696a = j;
    }
}
