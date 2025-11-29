package kotlinx.serialization.internal;

import com.honey.account.constant.AccountConstantKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00050\u0004B1\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ1\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0018R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u001a\u0010#\u001a\u00020\u001e8\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lkotlinx/serialization/internal/TripleSerializer;", "A", "B", "C", "Lkotlinx/serialization/KSerializer;", "Lkotlin/Triple;", "aSerializer", "bSerializer", "cSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "k", "(Lkotlinx/serialization/encoding/Encoder;Lkotlin/Triple;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "j", "(Lkotlinx/serialization/encoding/Decoder;)Lkotlin/Triple;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "composite", "h", "(Lkotlinx/serialization/encoding/CompositeDecoder;)Lkotlin/Triple;", "i", "a", "Lkotlinx/serialization/KSerializer;", "b", "c", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "d", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
@PublishedApi
public final class TripleSerializer<A, B, C> implements KSerializer<Triple<? extends A, ? extends B, ? extends C>> {

    /* renamed from: a  reason: collision with root package name */
    public final KSerializer f4063a;
    public final KSerializer b;
    public final KSerializer c;
    public final SerialDescriptor d = SerialDescriptorsKt.b("kotlin.Triple", new SerialDescriptor[0], new TripleSerializer$descriptor$1(this));

    public TripleSerializer(KSerializer kSerializer, KSerializer kSerializer2, KSerializer kSerializer3) {
        Intrinsics.checkNotNullParameter(kSerializer, "aSerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "bSerializer");
        Intrinsics.checkNotNullParameter(kSerializer3, "cSerializer");
        this.f4063a = kSerializer;
        this.b = kSerializer2;
        this.c = kSerializer3;
    }

    public SerialDescriptor getDescriptor() {
        return this.d;
    }

    public final Triple h(CompositeDecoder compositeDecoder) {
        Object c2 = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 0, this.f4063a, (Object) null, 8, (Object) null);
        Object c3 = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 1, this.b, (Object) null, 8, (Object) null);
        Object c4 = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 2, this.c, (Object) null, 8, (Object) null);
        compositeDecoder.c(getDescriptor());
        return new Triple(c2, c3, c4);
    }

    public final Triple i(CompositeDecoder compositeDecoder) {
        Object a2 = TuplesKt.f4064a;
        Object a3 = TuplesKt.f4064a;
        Object a4 = TuplesKt.f4064a;
        while (true) {
            int w = compositeDecoder.w(getDescriptor());
            if (w == -1) {
                compositeDecoder.c(getDescriptor());
                if (a2 == TuplesKt.f4064a) {
                    throw new SerializationException("Element 'first' is missing");
                } else if (a3 == TuplesKt.f4064a) {
                    throw new SerializationException("Element 'second' is missing");
                } else if (a4 != TuplesKt.f4064a) {
                    return new Triple(a2, a3, a4);
                } else {
                    throw new SerializationException("Element 'third' is missing");
                }
            } else if (w == 0) {
                a2 = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 0, this.f4063a, (Object) null, 8, (Object) null);
            } else if (w == 1) {
                a3 = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 1, this.b, (Object) null, 8, (Object) null);
            } else if (w == 2) {
                a4 = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 2, this.c, (Object) null, 8, (Object) null);
            } else {
                throw new SerializationException("Unexpected index " + w);
            }
        }
    }

    /* renamed from: j */
    public Triple c(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        CompositeDecoder b2 = decoder.b(getDescriptor());
        return b2.k() ? h(b2) : i(b2);
    }

    /* renamed from: k */
    public void a(Encoder encoder, Triple triple) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(triple, AccountConstantKt.RESPONSE_VALUE);
        CompositeEncoder b2 = encoder.b(getDescriptor());
        b2.F(getDescriptor(), 0, this.f4063a, triple.getFirst());
        b2.F(getDescriptor(), 1, this.b, triple.getSecond());
        b2.F(getDescriptor(), 2, this.c, triple.getThird());
        b2.c(getDescriptor());
    }
}
