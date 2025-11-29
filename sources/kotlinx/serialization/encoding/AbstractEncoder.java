package kotlinx.serialization.encoding;

import com.honey.account.constant.AccountConstantKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.NoOpEncoder;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u001f\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b2\u00103J%\u00104\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b4\u00105J%\u00106\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0018¢\u0006\u0004\b6\u00107J%\u00108\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u001b¢\u0006\u0004\b8\u00109J%\u0010:\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b:\u0010;J%\u0010<\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020 ¢\u0006\u0004\b<\u0010=J%\u0010>\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020#¢\u0006\u0004\b>\u0010?J%\u0010@\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020&¢\u0006\u0004\b@\u0010AJ%\u0010B\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020)¢\u0006\u0004\bB\u0010CJ%\u0010D\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020,¢\u0006\u0004\bD\u0010EJ\u001d\u0010F\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\bF\u0010GJ;\u0010K\u001a\u00020\t\"\u0004\b\u0000\u0010H2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000I2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\bK\u0010LJA\u0010M\u001a\u00020\t\"\b\b\u0000\u0010H*\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000I2\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\bM\u0010L¨\u0006N"}, d2 = {"Lkotlinx/serialization/encoding/AbstractEncoder;", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "<init>", "()V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "b", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;", "", "c", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "index", "", "H", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "", "value", "J", "(Ljava/lang/Object;)V", "B", "l", "(Z)V", "", "f", "(B)V", "", "k", "(S)V", "s", "(I)V", "", "A", "(J)V", "", "m", "(F)V", "", "x", "(D)V", "", "D", "(C)V", "", "v", "(Ljava/lang/String;)V", "enumDescriptor", "g", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "h", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "o", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IZ)V", "j", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IB)V", "t", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IS)V", "n", "(Lkotlinx/serialization/descriptors/SerialDescriptor;II)V", "u", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IJ)V", "C", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IF)V", "G", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ID)V", "i", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IC)V", "p", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILjava/lang/String;)V", "w", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/Encoder;", "T", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "F", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "y", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
@ExperimentalSerializationApi
public abstract class AbstractEncoder implements Encoder, CompositeEncoder {
    public void A(long j) {
        J(Long.valueOf(j));
    }

    public void B() {
        throw new SerializationException("'null' is not supported by default");
    }

    public final void C(SerialDescriptor serialDescriptor, int i, float f) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i)) {
            m(f);
        }
    }

    public void D(char c) {
        J(Character.valueOf(c));
    }

    public void E() {
        Encoder.DefaultImpls.b(this);
    }

    public void F(SerialDescriptor serialDescriptor, int i, SerializationStrategy serializationStrategy, Object obj) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (H(serialDescriptor, i)) {
            e(serializationStrategy, obj);
        }
    }

    public final void G(SerialDescriptor serialDescriptor, int i, double d) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i)) {
            x(d);
        }
    }

    public boolean H(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return true;
    }

    public void I(SerializationStrategy serializationStrategy, Object obj) {
        Encoder.DefaultImpls.c(this, serializationStrategy, obj);
    }

    public void J(Object obj) {
        Intrinsics.checkNotNullParameter(obj, AccountConstantKt.RESPONSE_VALUE);
        throw new SerializationException("Non-serializable " + Reflection.getOrCreateKotlinClass(obj.getClass()) + " is not supported by " + Reflection.getOrCreateKotlinClass(getClass()) + " encoder");
    }

    public CompositeEncoder b(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return this;
    }

    public void c(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
    }

    public void e(SerializationStrategy serializationStrategy, Object obj) {
        Encoder.DefaultImpls.d(this, serializationStrategy, obj);
    }

    public void f(byte b) {
        J(Byte.valueOf(b));
    }

    public void g(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        J(Integer.valueOf(i));
    }

    public Encoder h(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return this;
    }

    public final void i(SerialDescriptor serialDescriptor, int i, char c) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i)) {
            D(c);
        }
    }

    public final void j(SerialDescriptor serialDescriptor, int i, byte b) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i)) {
            f(b);
        }
    }

    public void k(short s) {
        J(Short.valueOf(s));
    }

    public void l(boolean z) {
        J(Boolean.valueOf(z));
    }

    public void m(float f) {
        J(Float.valueOf(f));
    }

    public final void n(SerialDescriptor serialDescriptor, int i, int i2) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i)) {
            s(i2);
        }
    }

    public final void o(SerialDescriptor serialDescriptor, int i, boolean z) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i)) {
            l(z);
        }
    }

    public final void p(SerialDescriptor serialDescriptor, int i, String str) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        if (H(serialDescriptor, i)) {
            v(str);
        }
    }

    public boolean q(SerialDescriptor serialDescriptor, int i) {
        return CompositeEncoder.DefaultImpls.a(this, serialDescriptor, i);
    }

    public void s(int i) {
        J(Integer.valueOf(i));
    }

    public final void t(SerialDescriptor serialDescriptor, int i, short s) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i)) {
            k(s);
        }
    }

    public final void u(SerialDescriptor serialDescriptor, int i, long j) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (H(serialDescriptor, i)) {
            A(j);
        }
    }

    public void v(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        J(str);
    }

    public final Encoder w(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return H(serialDescriptor, i) ? h(serialDescriptor.d(i)) : NoOpEncoder.f4046a;
    }

    public void x(double d) {
        J(Double.valueOf(d));
    }

    public void y(SerialDescriptor serialDescriptor, int i, SerializationStrategy serializationStrategy, Object obj) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (H(serialDescriptor, i)) {
            I(serializationStrategy, obj);
        }
    }

    public CompositeEncoder z(SerialDescriptor serialDescriptor, int i) {
        return Encoder.DefaultImpls.a(this, serialDescriptor, i);
    }
}
