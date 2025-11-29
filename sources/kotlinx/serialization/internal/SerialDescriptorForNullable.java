package kotlinx.serialization.internal;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u00018\u0000X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010&\u001a\u00020\u000e8\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u001cR \u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0'8\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b\u001f\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0005¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020\u00068\u0016X\u0005¢\u0006\u0006\u001a\u0004\b.\u0010\u001eR\u0014\u00100\u001a\u00020\u00148VX\u0005¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00105\u001a\u0002028\u0016X\u0005¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00106\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b#\u00101¨\u00067"}, d2 = {"Lkotlinx/serialization/internal/SerialDescriptorForNullable;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "original", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "index", "", "", "g", "(I)Ljava/util/List;", "d", "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "name", "c", "(Ljava/lang/String;)I", "f", "(I)Ljava/lang/String;", "", "i", "(I)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "a", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "j", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "b", "Ljava/lang/String;", "h", "serialName", "", "Ljava/util/Set;", "()Ljava/util/Set;", "serialNames", "getAnnotations", "()Ljava/util/List;", "annotations", "e", "elementsCount", "isInline", "()Z", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "isNullable", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
public final class SerialDescriptorForNullable implements SerialDescriptor, CachedNames {

    /* renamed from: a  reason: collision with root package name */
    public final SerialDescriptor f4057a;
    public final String b;
    public final Set c;

    public SerialDescriptorForNullable(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "original");
        this.f4057a = serialDescriptor;
        this.b = serialDescriptor.h() + '?';
        this.c = Platform_commonKt.a(serialDescriptor);
    }

    public Set a() {
        return this.c;
    }

    public boolean b() {
        return true;
    }

    public int c(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this.f4057a.c(str);
    }

    public SerialDescriptor d(int i) {
        return this.f4057a.d(i);
    }

    public int e() {
        return this.f4057a.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SerialDescriptorForNullable) && Intrinsics.areEqual((Object) this.f4057a, (Object) ((SerialDescriptorForNullable) obj).f4057a);
    }

    public String f(int i) {
        return this.f4057a.f(i);
    }

    public List g(int i) {
        return this.f4057a.g(i);
    }

    public List getAnnotations() {
        return this.f4057a.getAnnotations();
    }

    public SerialKind getKind() {
        return this.f4057a.getKind();
    }

    public String h() {
        return this.b;
    }

    public int hashCode() {
        return this.f4057a.hashCode() * 31;
    }

    public boolean i(int i) {
        return this.f4057a.i(i);
    }

    public boolean isInline() {
        return this.f4057a.isInline();
    }

    public final SerialDescriptor j() {
        return this.f4057a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4057a);
        sb.append('?');
        return sb.toString();
    }
}
