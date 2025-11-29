package kotlinx.serialization.json.internal;

import com.honey.account.constant.AccountConstantKt;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\bJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0011H\u0016¢\u0006\u0004\b*\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0000X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R*\u00101\u001a\u00020&2\u0006\u0010-\u001a\u00020&8\u0006@DX\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010.\u001a\u0004\b+\u0010/\"\u0004\b0\u0010(¨\u00062"}, d2 = {"Lkotlinx/serialization/json/internal/Composer;", "", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "writer", "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;)V", "", "b", "()V", "q", "c", "d", "p", "", "v", "f", "(C)V", "", "k", "(Ljava/lang/String;)V", "", "h", "(F)V", "", "g", "(D)V", "", "e", "(B)V", "", "l", "(S)V", "", "i", "(I)V", "", "j", "(J)V", "", "m", "(Z)V", "value", "n", "a", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "<set-?>", "Z", "()Z", "o", "writingFirst", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
public class Composer {

    /* renamed from: a  reason: collision with root package name */
    public final InternalJsonWriter f4102a;
    public boolean b = true;

    public Composer(InternalJsonWriter internalJsonWriter) {
        Intrinsics.checkNotNullParameter(internalJsonWriter, "writer");
        this.f4102a = internalJsonWriter;
    }

    public final boolean a() {
        return this.b;
    }

    public void b() {
        this.b = true;
    }

    public void c() {
        this.b = false;
    }

    public void d() {
        this.b = false;
    }

    public void e(byte b2) {
        this.f4102a.writeLong((long) b2);
    }

    public final void f(char c) {
        this.f4102a.a(c);
    }

    public void g(double d) {
        this.f4102a.write(String.valueOf(d));
    }

    public void h(float f) {
        this.f4102a.write(String.valueOf(f));
    }

    public void i(int i) {
        this.f4102a.writeLong((long) i);
    }

    public void j(long j) {
        this.f4102a.writeLong(j);
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
        this.f4102a.write(str);
    }

    public void l(short s) {
        this.f4102a.writeLong((long) s);
    }

    public void m(boolean z) {
        this.f4102a.write(String.valueOf(z));
    }

    public void n(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        this.f4102a.b(str);
    }

    public final void o(boolean z) {
        this.b = z;
    }

    public void p() {
    }

    public void q() {
    }
}
