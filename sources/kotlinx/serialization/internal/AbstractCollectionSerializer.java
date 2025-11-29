package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004B\t\b\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\u00020\u0007*\u00028\u0001H$¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n*\u00028\u0001H$¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00028\u0002H$¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u0007*\u00028\u0002H$¢\u0006\u0004\b\u000f\u0010\tJ\u0013\u0010\u0010\u001a\u00028\u0001*\u00028\u0002H$¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00028\u0002*\u00028\u0001H$¢\u0006\u0004\b\u0012\u0010\u0011J\u001b\u0010\u0015\u001a\u00020\u0014*\u00028\u00022\u0006\u0010\u0013\u001a\u00020\u0007H$¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00018\u0001H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ1\u0010#\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00028\u00022\b\b\u0002\u0010\"\u001a\u00020!H$¢\u0006\u0004\b#\u0010$J/\u0010&\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010 \u001a\u00028\u00022\u0006\u0010%\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H$¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010 \u001a\u00028\u0002H\u0002¢\u0006\u0004\b(\u0010)\u0001\u0002*+¨\u0006,"}, d2 = {"Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/KSerializer;", "<init>", "()V", "", "i", "(Ljava/lang/Object;)I", "", "h", "(Ljava/lang/Object;)Ljava/util/Iterator;", "e", "()Ljava/lang/Object;", "f", "p", "(Ljava/lang/Object;)Ljava/lang/Object;", "o", "size", "", "g", "(Ljava/lang/Object;I)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "previous", "j", "(Lkotlinx/serialization/encoding/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "c", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "index", "builder", "", "checkIndex", "l", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/lang/Object;Z)V", "startIndex", "k", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;II)V", "n", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;)I", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "Lkotlinx/serialization/internal/MapLikeSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
@InternalSerializationApi
public abstract class AbstractCollectionSerializer<Element, Collection, Builder> implements KSerializer<Collection> {
    public /* synthetic */ AbstractCollectionSerializer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void m(AbstractCollectionSerializer abstractCollectionSerializer, CompositeDecoder compositeDecoder, int i, Object obj, boolean z, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 8) != 0) {
                z = true;
            }
            abstractCollectionSerializer.l(compositeDecoder, i, obj, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
    }

    public Object c(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return j(decoder, (Object) null);
    }

    public abstract Object e();

    public abstract int f(Object obj);

    public abstract void g(Object obj, int i);

    public abstract Iterator h(Object obj);

    public abstract int i(Object obj);

    public final Object j(Decoder decoder, Object obj) {
        Object obj2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (obj == null || (obj2 = o(obj)) == null) {
            obj2 = e();
        }
        int f = f(obj2);
        CompositeDecoder b = decoder.b(getDescriptor());
        if (!b.k()) {
            while (true) {
                int w = b.w(getDescriptor());
                if (w == -1) {
                    break;
                }
                m(this, b, f + w, obj2, false, 8, (Object) null);
            }
        } else {
            k(b, obj2, f, n(b, obj2));
        }
        b.c(getDescriptor());
        return p(obj2);
    }

    public abstract void k(CompositeDecoder compositeDecoder, Object obj, int i, int i2);

    public abstract void l(CompositeDecoder compositeDecoder, int i, Object obj, boolean z);

    public final int n(CompositeDecoder compositeDecoder, Object obj) {
        int v = compositeDecoder.v(getDescriptor());
        g(obj, v);
        return v;
    }

    public abstract Object o(Object obj);

    public abstract Object p(Object obj);

    public AbstractCollectionSerializer() {
    }
}
