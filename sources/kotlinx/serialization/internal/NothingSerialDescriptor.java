package kotlinx.serialization.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\u00020 8\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010(\u001a\u00020\u00068\u0016XD¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010\u0016R\u0014\u0010*\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001c¨\u0006+"}, d2 = {"Lkotlinx/serialization/internal/NothingSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "<init>", "()V", "", "index", "", "f", "(I)Ljava/lang/String;", "name", "c", "(Ljava/lang/String;)I", "", "i", "(I)Z", "d", "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "", "g", "(I)Ljava/util/List;", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "a", "()Ljava/lang/Void;", "Lkotlinx/serialization/descriptors/SerialKind;", "b", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "Ljava/lang/String;", "h", "serialName", "e", "elementsCount", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
public final class NothingSerialDescriptor implements SerialDescriptor {

    /* renamed from: a  reason: collision with root package name */
    public static final NothingSerialDescriptor f4047a = new NothingSerialDescriptor();
    public static final SerialKind b = StructureKind.OBJECT.f4011a;
    public static final String c = "kotlin.Nothing";

    public final Void a() {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    public boolean b() {
        return SerialDescriptor.DefaultImpls.c(this);
    }

    public int c(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        a();
        throw new KotlinNothingValueException();
    }

    public SerialDescriptor d(int i) {
        a();
        throw new KotlinNothingValueException();
    }

    public int e() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public String f(int i) {
        a();
        throw new KotlinNothingValueException();
    }

    public List g(int i) {
        a();
        throw new KotlinNothingValueException();
    }

    public List getAnnotations() {
        return SerialDescriptor.DefaultImpls.a(this);
    }

    public SerialKind getKind() {
        return b;
    }

    public String h() {
        return c;
    }

    public int hashCode() {
        return h().hashCode() + (getKind().hashCode() * 31);
    }

    public boolean i(int i) {
        a();
        throw new KotlinNothingValueException();
    }

    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.b(this);
    }

    public String toString() {
        return "NothingSerialDescriptor";
    }
}
