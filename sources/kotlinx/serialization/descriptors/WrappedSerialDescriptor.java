package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\n8\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00028\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00108VX\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00108VX\u0005¢\u0006\u0006\u001a\u0004\b \u0010\u001fR\u0014\u0010%\u001a\u00020\"8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lkotlinx/serialization/descriptors/WrappedSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "index", "", "", "g", "(I)Ljava/util/List;", "d", "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "name", "c", "(Ljava/lang/String;)I", "f", "(I)Ljava/lang/String;", "", "i", "(I)Z", "a", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "serialName", "getAnnotations", "()Ljava/util/List;", "annotations", "e", "()I", "elementsCount", "isInline", "()Z", "b", "isNullable", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
public final class WrappedSerialDescriptor implements SerialDescriptor {

    /* renamed from: a  reason: collision with root package name */
    public final String f4012a;
    public final /* synthetic */ SerialDescriptor b;

    public boolean b() {
        return this.b.b();
    }

    public int c(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this.b.c(str);
    }

    public SerialDescriptor d(int i) {
        return this.b.d(i);
    }

    public int e() {
        return this.b.e();
    }

    public String f(int i) {
        return this.b.f(i);
    }

    public List g(int i) {
        return this.b.g(i);
    }

    public List getAnnotations() {
        return this.b.getAnnotations();
    }

    public SerialKind getKind() {
        return this.b.getKind();
    }

    public String h() {
        return this.f4012a;
    }

    public boolean i(int i) {
        return this.b.i(i);
    }

    public boolean isInline() {
        return this.b.isInline();
    }
}
