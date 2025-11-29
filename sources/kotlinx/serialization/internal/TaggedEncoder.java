package kotlinx.serialization.internal;

import com.honey.account.constant.AccountConstantKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

@SourceDebugExtension({"SMAP\nTagged.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Tagged.kt\nkotlinx/serialization/internal/TaggedEncoder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,335:1\n1#2:336\n*E\n"})
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00028\u0000*\u00020\u00062\u0006\u0010\t\u001a\u00020\bH$¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0017\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u001dH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020 H\u0014¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020#H\u0014¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020&H\u0014¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\nH\u0014¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020+H\u0014¢\u0006\u0004\b,\u0010-J\u001f\u0010/\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020.H\u0014¢\u0006\u0004\b/\u00100J'\u00103\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\bH\u0014¢\u0006\u0004\b3\u00104J\u001f\u00106\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u00105\u001a\u00020\u0006H\u0014¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0006H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0012H\u0016¢\u0006\u0004\b;\u0010\u0005J\u000f\u0010<\u001a\u00020\u0012H\u0016¢\u0006\u0004\b<\u0010\u0005J\u0015\u0010=\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u001a¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u001d¢\u0006\u0004\bA\u0010BJ\u0015\u0010C\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\bC\u0010DJ\u0015\u0010E\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020 ¢\u0006\u0004\bE\u0010FJ\u0015\u0010G\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020#¢\u0006\u0004\bG\u0010HJ\u0015\u0010I\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020&¢\u0006\u0004\bI\u0010JJ\u0015\u0010K\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020+¢\u0006\u0004\bK\u0010LJ\u0015\u0010M\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020.¢\u0006\u0004\bM\u0010NJ\u001d\u0010O\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0006H\u0016¢\u0006\u0004\bQ\u0010RJ\u0015\u0010S\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u0006¢\u0006\u0004\bS\u0010TJ\u0017\u0010U\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u0006H\u0014¢\u0006\u0004\bU\u0010TJ%\u0010V\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\bV\u0010WJ%\u0010X\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u001a¢\u0006\u0004\bX\u0010YJ%\u0010Z\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u001d¢\u0006\u0004\bZ\u0010[J%\u0010\\\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\\\u0010]J%\u0010^\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020 ¢\u0006\u0004\b^\u0010_J%\u0010`\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020#¢\u0006\u0004\b`\u0010aJ%\u0010b\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020&¢\u0006\u0004\bb\u0010cJ%\u0010d\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020+¢\u0006\u0004\bd\u0010eJ%\u0010f\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020.¢\u0006\u0004\bf\u0010gJ\u001d\u0010h\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\bh\u0010iJ;\u0010l\u001a\u00020\u0012\"\u0004\b\u0001\u0010\u00172\u0006\u00108\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010k\u001a\b\u0012\u0004\u0012\u00028\u00010j2\u0006\u0010\u0011\u001a\u00028\u0001H\u0016¢\u0006\u0004\bl\u0010mJA\u0010n\u001a\u00020\u0012\"\b\b\u0001\u0010\u0017*\u00020\u00102\u0006\u00108\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010k\u001a\b\u0012\u0004\u0012\u00028\u00010j2\b\u0010\u0011\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0004\bn\u0010mJ\u0017\u0010p\u001a\u00020\u00122\u0006\u0010o\u001a\u00028\u0000H\u0004¢\u0006\u0004\bp\u0010\u0016J\u000f\u0010q\u001a\u00028\u0000H\u0004¢\u0006\u0004\bq\u0010rR$\u0010w\u001a\u0012\u0012\u0004\u0012\u00028\u00000sj\b\u0012\u0004\u0012\u00028\u0000`t8\u0002X\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0014\u0010z\u001a\u00020x8VX\u0004¢\u0006\u0006\u001a\u0004\bu\u0010yR\u0014\u0010|\u001a\u00028\u00008DX\u0004¢\u0006\u0006\u001a\u0004\b{\u0010rR\u0016\u0010~\u001a\u0004\u0018\u00018\u00008DX\u0004¢\u0006\u0006\u001a\u0004\b}\u0010r¨\u0006"}, d2 = {"Lkotlinx/serialization/internal/TaggedEncoder;", "Tag", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "<init>", "()V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "desc", "", "index", "", "H", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "a0", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "tag", "", "value", "", "W", "(Ljava/lang/Object;Ljava/lang/Object;)V", "S", "(Ljava/lang/Object;)V", "T", "Q", "(Ljava/lang/Object;I)V", "", "K", "(Ljava/lang/Object;B)V", "", "U", "(Ljava/lang/Object;S)V", "", "R", "(Ljava/lang/Object;J)V", "", "O", "(Ljava/lang/Object;F)V", "", "M", "(Ljava/lang/Object;D)V", "J", "(Ljava/lang/Object;Z)V", "", "L", "(Ljava/lang/Object;C)V", "", "V", "(Ljava/lang/Object;Ljava/lang/String;)V", "enumDescriptor", "ordinal", "N", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "inlineDescriptor", "P", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "descriptor", "h", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "E", "B", "l", "(Z)V", "f", "(B)V", "k", "(S)V", "s", "(I)V", "A", "(J)V", "m", "(F)V", "x", "(D)V", "D", "(C)V", "v", "(Ljava/lang/String;)V", "g", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "b", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeEncoder;", "c", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "X", "o", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IZ)V", "j", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IB)V", "t", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IS)V", "n", "(Lkotlinx/serialization/descriptors/SerialDescriptor;II)V", "u", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IJ)V", "C", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IF)V", "G", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ID)V", "i", "(Lkotlinx/serialization/descriptors/SerialDescriptor;IC)V", "p", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILjava/lang/String;)V", "w", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "F", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "y", "name", "c0", "b0", "()Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "tagStack", "Lkotlinx/serialization/modules/SerializersModule;", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "Y", "currentTag", "Z", "currentTagOrNull", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
@InternalSerializationApi
public abstract class TaggedEncoder<Tag> implements Encoder, CompositeEncoder {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f4062a = new ArrayList();

    private final boolean H(SerialDescriptor serialDescriptor, int i) {
        c0(a0(serialDescriptor, i));
        return true;
    }

    public final void A(long j) {
        R(b0(), j);
    }

    public void B() {
        T(b0());
    }

    public final void C(SerialDescriptor serialDescriptor, int i, float f) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        O(a0(serialDescriptor, i), f);
    }

    public final void D(char c) {
        L(b0(), c);
    }

    public void E() {
        S(Y());
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
        M(a0(serialDescriptor, i), d);
    }

    public void I(SerializationStrategy serializationStrategy, Object obj) {
        Encoder.DefaultImpls.c(this, serializationStrategy, obj);
    }

    public void J(Object obj, boolean z) {
        W(obj, Boolean.valueOf(z));
    }

    public void K(Object obj, byte b) {
        W(obj, Byte.valueOf(b));
    }

    public void L(Object obj, char c) {
        W(obj, Character.valueOf(c));
    }

    public void M(Object obj, double d) {
        W(obj, Double.valueOf(d));
    }

    public void N(Object obj, SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        W(obj, Integer.valueOf(i));
    }

    public void O(Object obj, float f) {
        W(obj, Float.valueOf(f));
    }

    public Encoder P(Object obj, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        c0(obj);
        return this;
    }

    public void Q(Object obj, int i) {
        W(obj, Integer.valueOf(i));
    }

    public void R(Object obj, long j) {
        W(obj, Long.valueOf(j));
    }

    public void S(Object obj) {
    }

    public void T(Object obj) {
        throw new SerializationException("null is not supported");
    }

    public void U(Object obj, short s) {
        W(obj, Short.valueOf(s));
    }

    public void V(Object obj, String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        W(obj, str);
    }

    public void W(Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(obj2, AccountConstantKt.RESPONSE_VALUE);
        throw new SerializationException("Non-serializable " + Reflection.getOrCreateKotlinClass(obj2.getClass()) + " is not supported by " + Reflection.getOrCreateKotlinClass(getClass()) + " encoder");
    }

    public void X(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
    }

    public final Object Y() {
        return CollectionsKt.last(this.f4062a);
    }

    public final Object Z() {
        return CollectionsKt.lastOrNull(this.f4062a);
    }

    public SerializersModule a() {
        return SerializersModuleBuildersKt.a();
    }

    public abstract Object a0(SerialDescriptor serialDescriptor, int i);

    public CompositeEncoder b(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return this;
    }

    public final Object b0() {
        if (!this.f4062a.isEmpty()) {
            ArrayList arrayList = this.f4062a;
            return arrayList.remove(CollectionsKt.getLastIndex(arrayList));
        }
        throw new SerializationException("No tag in stack for requested element");
    }

    public final void c(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (!this.f4062a.isEmpty()) {
            b0();
        }
        X(serialDescriptor);
    }

    public final void c0(Object obj) {
        this.f4062a.add(obj);
    }

    public void e(SerializationStrategy serializationStrategy, Object obj) {
        Encoder.DefaultImpls.d(this, serializationStrategy, obj);
    }

    public final void f(byte b) {
        K(b0(), b);
    }

    public final void g(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        N(b0(), serialDescriptor, i);
    }

    public Encoder h(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return P(b0(), serialDescriptor);
    }

    public final void i(SerialDescriptor serialDescriptor, int i, char c) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        L(a0(serialDescriptor, i), c);
    }

    public final void j(SerialDescriptor serialDescriptor, int i, byte b) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        K(a0(serialDescriptor, i), b);
    }

    public final void k(short s) {
        U(b0(), s);
    }

    public final void l(boolean z) {
        J(b0(), z);
    }

    public final void m(float f) {
        O(b0(), f);
    }

    public final void n(SerialDescriptor serialDescriptor, int i, int i2) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Q(a0(serialDescriptor, i), i2);
    }

    public final void o(SerialDescriptor serialDescriptor, int i, boolean z) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        J(a0(serialDescriptor, i), z);
    }

    public final void p(SerialDescriptor serialDescriptor, int i, String str) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        V(a0(serialDescriptor, i), str);
    }

    public boolean q(SerialDescriptor serialDescriptor, int i) {
        return CompositeEncoder.DefaultImpls.a(this, serialDescriptor, i);
    }

    public final void s(int i) {
        Q(b0(), i);
    }

    public final void t(SerialDescriptor serialDescriptor, int i, short s) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        U(a0(serialDescriptor, i), s);
    }

    public final void u(SerialDescriptor serialDescriptor, int i, long j) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        R(a0(serialDescriptor, i), j);
    }

    public final void v(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        V(b0(), str);
    }

    public final Encoder w(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return P(a0(serialDescriptor, i), serialDescriptor.d(i));
    }

    public final void x(double d) {
        M(b0(), d);
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
