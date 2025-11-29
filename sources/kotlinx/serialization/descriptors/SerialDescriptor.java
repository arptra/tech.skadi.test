package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H'¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001c\u001a\u00020\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\u00020\u00108VX\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001eR\u001a\u0010%\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0016\u001a\u0004\b\"\u0010#R \u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8VX\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "", "index", "", "f", "(I)Ljava/lang/String;", "name", "c", "(Ljava/lang/String;)I", "", "", "g", "(I)Ljava/util/List;", "d", "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "i", "(I)Z", "h", "()Ljava/lang/String;", "getSerialName$annotations", "()V", "serialName", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "getKind$annotations", "kind", "b", "()Z", "isNullable$annotations", "isNullable", "isInline", "e", "()I", "getElementsCount$annotations", "elementsCount", "getAnnotations", "()Ljava/util/List;", "getAnnotations$annotations", "annotations", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
public interface SerialDescriptor {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static List a(SerialDescriptor serialDescriptor) {
            return CollectionsKt.emptyList();
        }

        public static boolean b(SerialDescriptor serialDescriptor) {
            return false;
        }

        public static boolean c(SerialDescriptor serialDescriptor) {
            return false;
        }
    }

    boolean b();

    int c(String str);

    SerialDescriptor d(int i);

    int e();

    String f(int i);

    List g(int i);

    List getAnnotations();

    SerialKind getKind();

    String h();

    boolean i(int i);

    boolean isInline();
}
