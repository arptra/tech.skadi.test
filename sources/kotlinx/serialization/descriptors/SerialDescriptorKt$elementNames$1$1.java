package kotlinx.serialization.descriptors;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\t¨\u0006\u000b"}, d2 = {"kotlinx/serialization/descriptors/SerialDescriptorKt$elementNames$1$1", "", "", "", "hasNext", "()Z", "a", "()Ljava/lang/String;", "", "I", "elementsLeft", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
public final class SerialDescriptorKt$elementNames$1$1 implements Iterator<String>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    public int f4005a;
    public final /* synthetic */ SerialDescriptor b;

    public SerialDescriptorKt$elementNames$1$1(SerialDescriptor serialDescriptor) {
        this.b = serialDescriptor;
        this.f4005a = serialDescriptor.e();
    }

    /* renamed from: a */
    public String next() {
        SerialDescriptor serialDescriptor = this.b;
        int e = serialDescriptor.e();
        int i = this.f4005a;
        this.f4005a = i - 1;
        return serialDescriptor.f(e - i);
    }

    public boolean hasNext() {
        return this.f4005a > 0;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
