package kotlinx.serialization.json.internal;

import io.netty.util.internal.StringUtil;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.internal.StreamingJsonDecoder;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0010\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u0019"}, d2 = {"Lkotlinx/serialization/json/internal/JsonIteratorArrayWrapped;", "T", "", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "Lkotlinx/serialization/json/Json;", "a", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/internal/ReaderJsonLexer;", "b", "Lkotlinx/serialization/json/internal/ReaderJsonLexer;", "lexer", "Lkotlinx/serialization/DeserializationStrategy;", "c", "Lkotlinx/serialization/DeserializationStrategy;", "deserializer", "d", "Z", "first", "e", "finished", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
final class JsonIteratorArrayWrapped<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    public final Json f4107a;
    public final ReaderJsonLexer b;
    public final DeserializationStrategy c;
    public boolean d;
    public boolean e;

    public boolean hasNext() {
        if (this.e) {
            return false;
        }
        if (this.b.H() == 9) {
            this.e = true;
            this.b.k((byte) 9);
            if (this.b.E()) {
                if (this.b.H() != 8) {
                    this.b.v();
                } else {
                    AbstractJsonLexer.x(this.b, "There is a start of the new array after the one parsed to sequence. ARRAY_WRAPPED mode doesn't merge consecutive arrays.\nIf you need to parse a stream of arrays, please use WHITESPACE_SEPARATED mode instead.", 0, (String) null, 6, (Object) null);
                    throw new KotlinNothingValueException();
                }
            }
            return false;
        } else if (this.b.E() || this.e) {
            return true;
        } else {
            AbstractJsonLexer.z(this.b, (byte) 9, false, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public Object next() {
        if (this.d) {
            this.d = false;
        } else {
            this.b.l(StringUtil.COMMA);
        }
        return new StreamingJsonDecoder(this.f4107a, WriteMode.OBJ, this.b, this.c.getDescriptor(), (StreamingJsonDecoder.DiscriminatorHolder) null).G(this.c);
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
