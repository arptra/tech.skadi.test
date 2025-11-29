package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

@SourceDebugExtension({"SMAP\nTagged.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Tagged.kt\nkotlinx/serialization/internal/TaggedDecoder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,335:1\n1#2:336\n*E\n"})
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0001\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\n\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0007\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\u00028\u0000*\u00020\f2\u0006\u0010\u000e\u001a\u00020\rH$¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020&2\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020)2\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020,2\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b-\u0010.J\u001f\u00100\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010/\u001a\u00020\fH\u0014¢\u0006\u0004\b0\u00101J\u001f\u00103\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u00102\u001a\u00020\fH\u0014¢\u0006\u0004\b3\u00104J-\u00108\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u001c2\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u0001052\b\u00107\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b8\u00109J\u0017\u0010;\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\fH\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0014H\u0016¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u0004\u0018\u00010?¢\u0006\u0004\b@\u0010AJ\r\u0010B\u001a\u00020\u0014¢\u0006\u0004\bB\u0010>J\r\u0010C\u001a\u00020\u0018¢\u0006\u0004\bC\u0010DJ\r\u0010E\u001a\u00020\u001b¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020\r¢\u0006\u0004\bG\u0010HJ\r\u0010I\u001a\u00020 ¢\u0006\u0004\bI\u0010JJ\r\u0010K\u001a\u00020#¢\u0006\u0004\bK\u0010LJ\r\u0010M\u001a\u00020&¢\u0006\u0004\bM\u0010NJ\r\u0010O\u001a\u00020)¢\u0006\u0004\bO\u0010PJ\r\u0010Q\u001a\u00020,¢\u0006\u0004\bQ\u0010RJ\u0015\u0010S\u001a\u00020\r2\u0006\u0010/\u001a\u00020\f¢\u0006\u0004\bS\u0010TJ\u0017\u0010U\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\fH\u0016¢\u0006\u0004\bU\u0010VJ\u0017\u0010X\u001a\u00020W2\u0006\u0010:\u001a\u00020\fH\u0016¢\u0006\u0004\bX\u0010YJ\u001d\u0010Z\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bZ\u0010[J\u001d\u0010\\\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\\\u0010]J\u001d\u0010\u0006\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0006\u0010^J\u001d\u0010_\u001a\u00020\r2\u0006\u0010:\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b_\u0010`J\u001d\u0010a\u001a\u00020 2\u0006\u0010:\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\ba\u0010bJ\u001d\u0010c\u001a\u00020#2\u0006\u0010:\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bc\u0010dJ\u001d\u0010e\u001a\u00020&2\u0006\u0010:\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\be\u0010fJ\u001d\u0010g\u001a\u00020)2\u0006\u0010:\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bg\u0010hJ\u001d\u0010i\u001a\u00020,2\u0006\u0010:\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bi\u0010jJ\u001d\u0010k\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bk\u0010lJ;\u0010m\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u001c2\u0006\u0010:\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u0001052\b\u00107\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\bm\u0010nJC\u0010o\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u0010\u001c*\u00020\u00112\u0006\u0010:\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u0001052\b\u00107\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\bo\u0010nJ\u0017\u0010q\u001a\u00020W2\u0006\u0010p\u001a\u00028\u0000H\u0004¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00028\u0000H\u0004¢\u0006\u0004\bs\u0010tR$\u0010y\u001a\u0012\u0012\u0004\u0012\u00028\u00000uj\b\u0012\u0004\u0012\u00028\u0000`v8\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010z\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010qR\u0014\u0010}\u001a\u00020{8VX\u0004¢\u0006\u0006\u001a\u0004\bw\u0010|R\u0016\u0010\u001a\u0004\u0018\u00018\u00008DX\u0004¢\u0006\u0006\u001a\u0004\b~\u0010t¨\u0006\u0001"}, d2 = {"Lkotlinx/serialization/internal/TaggedDecoder;", "Tag", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "<init>", "()V", "E", "tag", "Lkotlin/Function0;", "block", "a0", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "index", "X", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "", "V", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "S", "(Ljava/lang/Object;)Z", "J", "", "K", "(Ljava/lang/Object;)B", "", "T", "(Ljava/lang/Object;)S", "Q", "(Ljava/lang/Object;)I", "", "R", "(Ljava/lang/Object;)J", "", "O", "(Ljava/lang/Object;)F", "", "M", "(Ljava/lang/Object;)D", "", "L", "(Ljava/lang/Object;)C", "", "U", "(Ljava/lang/Object;)Ljava/lang/String;", "enumDescriptor", "N", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "inlineDescriptor", "P", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "previousValue", "I", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "descriptor", "x", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "D", "()Z", "", "g", "()Ljava/lang/Void;", "A", "H", "()B", "m", "()S", "u", "()I", "h", "()J", "y", "()F", "n", "()D", "o", "()C", "q", "()Ljava/lang/String;", "s", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "b", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;", "", "c", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "C", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "B", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)B", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)S", "f", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)I", "e", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)J", "z", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)F", "F", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)D", "r", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)C", "i", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/String;", "l", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Lkotlinx/serialization/encoding/Decoder;", "p", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "j", "name", "Z", "(Ljava/lang/Object;)V", "Y", "()Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "tagStack", "flag", "Lkotlinx/serialization/modules/SerializersModule;", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "W", "currentTagOrNull", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
@InternalSerializationApi
public abstract class TaggedDecoder<Tag> implements Decoder, CompositeDecoder {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f4061a = new ArrayList();
    public boolean b;

    public final boolean A() {
        return J(Y());
    }

    public final byte B(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return K(X(serialDescriptor, i));
    }

    public final boolean C(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return J(X(serialDescriptor, i));
    }

    public boolean D() {
        Object W = W();
        if (W == null) {
            return false;
        }
        return S(W);
    }

    public final short E(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return T(X(serialDescriptor, i));
    }

    public final double F(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return M(X(serialDescriptor, i));
    }

    public Object G(DeserializationStrategy deserializationStrategy) {
        return Decoder.DefaultImpls.a(this, deserializationStrategy);
    }

    public final byte H() {
        return K(Y());
    }

    public Object I(DeserializationStrategy deserializationStrategy, Object obj) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return G(deserializationStrategy);
    }

    public boolean J(Object obj) {
        Object V = V(obj);
        Intrinsics.checkNotNull(V, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) V).booleanValue();
    }

    public byte K(Object obj) {
        Object V = V(obj);
        Intrinsics.checkNotNull(V, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) V).byteValue();
    }

    public char L(Object obj) {
        Object V = V(obj);
        Intrinsics.checkNotNull(V, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) V).charValue();
    }

    public double M(Object obj) {
        Object V = V(obj);
        Intrinsics.checkNotNull(V, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) V).doubleValue();
    }

    public int N(Object obj, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        Object V = V(obj);
        Intrinsics.checkNotNull(V, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) V).intValue();
    }

    public float O(Object obj) {
        Object V = V(obj);
        Intrinsics.checkNotNull(V, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) V).floatValue();
    }

    public Decoder P(Object obj, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        Z(obj);
        return this;
    }

    public int Q(Object obj) {
        Object V = V(obj);
        Intrinsics.checkNotNull(V, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) V).intValue();
    }

    public long R(Object obj) {
        Object V = V(obj);
        Intrinsics.checkNotNull(V, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) V).longValue();
    }

    public boolean S(Object obj) {
        return true;
    }

    public short T(Object obj) {
        Object V = V(obj);
        Intrinsics.checkNotNull(V, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) V).shortValue();
    }

    public String U(Object obj) {
        Object V = V(obj);
        Intrinsics.checkNotNull(V, "null cannot be cast to non-null type kotlin.String");
        return (String) V;
    }

    public Object V(Object obj) {
        throw new SerializationException(Reflection.getOrCreateKotlinClass(getClass()) + " can't retrieve untyped values");
    }

    public final Object W() {
        return CollectionsKt.lastOrNull(this.f4061a);
    }

    public abstract Object X(SerialDescriptor serialDescriptor, int i);

    public final Object Y() {
        ArrayList arrayList = this.f4061a;
        Object remove = arrayList.remove(CollectionsKt.getLastIndex(arrayList));
        this.b = true;
        return remove;
    }

    public final void Z(Object obj) {
        this.f4061a.add(obj);
    }

    public SerializersModule a() {
        return SerializersModuleBuildersKt.a();
    }

    public final Object a0(Object obj, Function0 function0) {
        Z(obj);
        Object invoke = function0.invoke();
        if (!this.b) {
            Y();
        }
        this.b = false;
        return invoke;
    }

    public CompositeDecoder b(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return this;
    }

    public void c(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
    }

    public final long e(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return R(X(serialDescriptor, i));
    }

    public final int f(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return Q(X(serialDescriptor, i));
    }

    public final Void g() {
        return null;
    }

    public final long h() {
        return R(Y());
    }

    public final String i(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return U(X(serialDescriptor, i));
    }

    public final Object j(SerialDescriptor serialDescriptor, int i, DeserializationStrategy deserializationStrategy, Object obj) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return a0(X(serialDescriptor, i), new TaggedDecoder$decodeNullableSerializableElement$1(this, deserializationStrategy, obj));
    }

    public boolean k() {
        return CompositeDecoder.DefaultImpls.b(this);
    }

    public final Decoder l(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return P(X(serialDescriptor, i), serialDescriptor.d(i));
    }

    public final short m() {
        return T(Y());
    }

    public final double n() {
        return M(Y());
    }

    public final char o() {
        return L(Y());
    }

    public final Object p(SerialDescriptor serialDescriptor, int i, DeserializationStrategy deserializationStrategy, Object obj) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return a0(X(serialDescriptor, i), new TaggedDecoder$decodeSerializableElement$1(this, deserializationStrategy, obj));
    }

    public final String q() {
        return U(Y());
    }

    public final char r(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return L(X(serialDescriptor, i));
    }

    public final int s(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        return N(Y(), serialDescriptor);
    }

    public final int u() {
        return Q(Y());
    }

    public int v(SerialDescriptor serialDescriptor) {
        return CompositeDecoder.DefaultImpls.a(this, serialDescriptor);
    }

    public Decoder x(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return P(Y(), serialDescriptor);
    }

    public final float y() {
        return O(Y());
    }

    public final float z(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return O(X(serialDescriptor, i));
    }
}
