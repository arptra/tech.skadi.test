package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.ElementMarker;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r8\u0000@BX\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u0019"}, d2 = {"Lkotlinx/serialization/json/internal/JsonElementMarker;", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "index", "", "c", "(I)V", "d", "()I", "", "e", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", "Lkotlinx/serialization/internal/ElementMarker;", "a", "Lkotlinx/serialization/internal/ElementMarker;", "origin", "<set-?>", "b", "Z", "()Z", "isUnmarkedNull", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
public final class JsonElementMarker {

    /* renamed from: a  reason: collision with root package name */
    public final ElementMarker f4106a;
    public boolean b;

    public JsonElementMarker(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        this.f4106a = new ElementMarker(serialDescriptor, new JsonElementMarker$origin$1(this));
    }

    public final boolean b() {
        return this.b;
    }

    public final void c(int i) {
        this.f4106a.a(i);
    }

    public final int d() {
        return this.f4106a.d();
    }

    public final boolean e(SerialDescriptor serialDescriptor, int i) {
        boolean z = !serialDescriptor.i(i) && serialDescriptor.d(i).b();
        this.b = z;
        return z;
    }
}
