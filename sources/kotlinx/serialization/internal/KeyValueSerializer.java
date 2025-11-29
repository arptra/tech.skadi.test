package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@SourceDebugExtension({"SMAP\nTuples.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Tuples.kt\nkotlinx/serialization/internal/KeyValueSerializer\n+ 2 Decoding.kt\nkotlinx/serialization/encoding/DecodingKt\n*L\n1#1,168:1\n570#2,4:169\n*S KotlinDebug\n*F\n+ 1 Tuples.kt\nkotlinx/serialization/internal/KeyValueSerializer\n*L\n35#1:169,4\n*E\n"})
@PublishedApi
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B%\b\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00028\u00022\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0001H$¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00028\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0004X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\t\u001a\u00028\u0000*\u00028\u00028$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\n\u001a\u00028\u0001*\u00028\u00028$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001c\u0001\u0002\u001e\u001f¨\u0006 "}, d2 = {"Lkotlinx/serialization/internal/KeyValueSerializer;", "K", "V", "R", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "key", "value", "i", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "", "a", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "c", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lkotlinx/serialization/KSerializer;", "f", "()Lkotlinx/serialization/KSerializer;", "b", "h", "e", "(Ljava/lang/Object;)Ljava/lang/Object;", "g", "Lkotlinx/serialization/internal/MapEntrySerializer;", "Lkotlinx/serialization/internal/PairSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
public abstract class KeyValueSerializer<K, V, R> implements KSerializer<R> {

    /* renamed from: a  reason: collision with root package name */
    public final KSerializer f4039a;
    public final KSerializer b;

    public /* synthetic */ KeyValueSerializer(KSerializer kSerializer, KSerializer kSerializer2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer, kSerializer2);
    }

    public void a(Encoder encoder, Object obj) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        CompositeEncoder b2 = encoder.b(getDescriptor());
        b2.F(getDescriptor(), 0, this.f4039a, e(obj));
        b2.F(getDescriptor(), 1, this.b, g(obj));
        b2.c(getDescriptor());
    }

    public Object c(Decoder decoder) {
        Object obj;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder b2 = decoder.b(descriptor);
        if (b2.k()) {
            CompositeDecoder compositeDecoder = b2;
            obj = i(CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 0, f(), (Object) null, 8, (Object) null), CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 1, h(), (Object) null, 8, (Object) null));
        } else {
            Object a2 = TuplesKt.f4064a;
            Object a3 = TuplesKt.f4064a;
            while (true) {
                int w = b2.w(getDescriptor());
                if (w != -1) {
                    if (w == 0) {
                        a2 = CompositeDecoder.DefaultImpls.c(b2, getDescriptor(), 0, f(), (Object) null, 8, (Object) null);
                    } else if (w == 1) {
                        a3 = CompositeDecoder.DefaultImpls.c(b2, getDescriptor(), 1, h(), (Object) null, 8, (Object) null);
                    } else {
                        throw new SerializationException("Invalid index: " + w);
                    }
                } else if (a2 == TuplesKt.f4064a) {
                    throw new SerializationException("Element 'key' is missing");
                } else if (a3 != TuplesKt.f4064a) {
                    obj = i(a2, a3);
                } else {
                    throw new SerializationException("Element 'value' is missing");
                }
            }
        }
        b2.c(descriptor);
        return obj;
    }

    public abstract Object e(Object obj);

    public final KSerializer f() {
        return this.f4039a;
    }

    public abstract Object g(Object obj);

    public final KSerializer h() {
        return this.b;
    }

    public abstract Object i(Object obj, Object obj2);

    public KeyValueSerializer(KSerializer kSerializer, KSerializer kSerializer2) {
        this.f4039a = kSerializer;
        this.b = kSerializer2;
    }
}
