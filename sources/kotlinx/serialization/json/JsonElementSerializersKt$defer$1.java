package kotlinx.serialization.json;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"kotlinx/serialization/json/JsonElementSerializersKt$defer$1", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "index", "", "f", "(I)Ljava/lang/String;", "name", "c", "(Ljava/lang/String;)I", "", "", "g", "(I)Ljava/util/List;", "d", "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "i", "(I)Z", "a", "Lkotlin/Lazy;", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "original", "h", "()Ljava/lang/String;", "serialName", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "e", "()I", "elementsCount", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0})
public final class JsonElementSerializersKt$defer$1 implements SerialDescriptor {

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f4082a;

    public JsonElementSerializersKt$defer$1(Function0 function0) {
        this.f4082a = LazyKt.lazy(function0);
    }

    public final SerialDescriptor a() {
        return (SerialDescriptor) this.f4082a.getValue();
    }

    public boolean b() {
        return SerialDescriptor.DefaultImpls.c(this);
    }

    public int c(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return a().c(str);
    }

    public SerialDescriptor d(int i) {
        return a().d(i);
    }

    public int e() {
        return a().e();
    }

    public String f(int i) {
        return a().f(i);
    }

    public List g(int i) {
        return a().g(i);
    }

    public List getAnnotations() {
        return SerialDescriptor.DefaultImpls.a(this);
    }

    public SerialKind getKind() {
        return a().getKind();
    }

    public String h() {
        return a().h();
    }

    public boolean i(int i) {
        return a().i(i);
    }

    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.b(this);
    }
}
