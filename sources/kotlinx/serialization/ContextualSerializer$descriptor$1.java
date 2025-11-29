package kotlinx.serialization;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ContextualSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {
    final /* synthetic */ ContextualSerializer<Object> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextualSerializer$descriptor$1(ContextualSerializer<Object> contextualSerializer) {
        super(1);
        this.this$0 = contextualSerializer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ClassSerialDescriptorBuilder) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = r1.getDescriptor();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder r2) {
        /*
            r1 = this;
            java.lang.String r0 = "$this$buildSerialDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlinx.serialization.ContextualSerializer<java.lang.Object> r1 = r1.this$0
            kotlinx.serialization.KSerializer r1 = r1.b
            if (r1 == 0) goto L_0x0018
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r1.getDescriptor()
            if (r1 == 0) goto L_0x0018
            java.util.List r1 = r1.getAnnotations()
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            if (r1 != 0) goto L_0x001f
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x001f:
            r2.h(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.ContextualSerializer$descriptor$1.invoke(kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder):void");
    }
}
