package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010&\u001a\u00020\u000f8\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\u001fR\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u00078\u0016X\u0005¢\u0006\u0006\u001a\u0004\b*\u0010\u001dR\u0014\u0010,\u001a\u00020\u00158VX\u0005¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00158VX\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010-R\u0014\u00102\u001a\u00020/8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Lkotlinx/serialization/descriptors/ContextDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "original", "Lkotlin/reflect/KClass;", "kClass", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/reflect/KClass;)V", "", "index", "", "", "g", "(I)Ljava/util/List;", "d", "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "name", "c", "(Ljava/lang/String;)I", "f", "(I)Ljava/lang/String;", "", "i", "(I)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "a", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "b", "Lkotlin/reflect/KClass;", "Ljava/lang/String;", "h", "serialName", "getAnnotations", "()Ljava/util/List;", "annotations", "e", "elementsCount", "isInline", "()Z", "isNullable", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
final class ContextDescriptor implements SerialDescriptor {

    /* renamed from: a  reason: collision with root package name */
    public final SerialDescriptor f3989a;
    public final KClass b;
    public final String c;

    public ContextDescriptor(SerialDescriptor serialDescriptor, KClass kClass) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "original");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        this.f3989a = serialDescriptor;
        this.b = kClass;
        this.c = serialDescriptor.h() + Typography.less + kClass.getSimpleName() + Typography.greater;
    }

    public boolean b() {
        return this.f3989a.b();
    }

    public int c(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this.f3989a.c(str);
    }

    public SerialDescriptor d(int i) {
        return this.f3989a.d(i);
    }

    public int e() {
        return this.f3989a.e();
    }

    public boolean equals(Object obj) {
        ContextDescriptor contextDescriptor = obj instanceof ContextDescriptor ? (ContextDescriptor) obj : null;
        return contextDescriptor != null && Intrinsics.areEqual((Object) this.f3989a, (Object) contextDescriptor.f3989a) && Intrinsics.areEqual((Object) contextDescriptor.b, (Object) this.b);
    }

    public String f(int i) {
        return this.f3989a.f(i);
    }

    public List g(int i) {
        return this.f3989a.g(i);
    }

    public List getAnnotations() {
        return this.f3989a.getAnnotations();
    }

    public SerialKind getKind() {
        return this.f3989a.getKind();
    }

    public String h() {
        return this.c;
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + h().hashCode();
    }

    public boolean i(int i) {
        return this.f3989a.i(i);
    }

    public boolean isInline() {
        return this.f3989a.isInline();
    }

    public String toString() {
        return "ContextDescriptor(kClass: " + this.b + ", original: " + this.f3989a + ')';
    }
}
