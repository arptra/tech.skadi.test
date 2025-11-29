package kotlinx.serialization;

import com.honey.account.constant.AccountConstantKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Typography;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "T", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PolymorphicSerializer$descriptor$2 extends Lambda implements Function0<SerialDescriptor> {
    final /* synthetic */ PolymorphicSerializer<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PolymorphicSerializer$descriptor$2(PolymorphicSerializer<T> polymorphicSerializer) {
        super(0);
        this.this$0 = polymorphicSerializer;
    }

    @NotNull
    public final SerialDescriptor invoke() {
        final PolymorphicSerializer<T> polymorphicSerializer = this.this$0;
        return ContextAwareKt.c(SerialDescriptorsKt.c("kotlinx.serialization.Polymorphic", PolymorphicKind.OPEN.f3990a, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ClassSerialDescriptorBuilder) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder2 = classSerialDescriptorBuilder;
                Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder2, "$this$buildSerialDescriptor");
                ClassSerialDescriptorBuilder.b(classSerialDescriptorBuilder, "type", BuiltinSerializersKt.H(StringCompanionObject.INSTANCE).getDescriptor(), (List) null, false, 12, (Object) null);
                ClassSerialDescriptorBuilder.b(classSerialDescriptorBuilder, AccountConstantKt.RESPONSE_VALUE, SerialDescriptorsKt.d("kotlinx.serialization.Polymorphic<" + polymorphicSerializer.i().getSimpleName() + Typography.greater, SerialKind.CONTEXTUAL.f4006a, new SerialDescriptor[0], (Function1) null, 8, (Object) null), (List) null, false, 12, (Object) null);
                classSerialDescriptorBuilder2.h(polymorphicSerializer.b);
            }
        }), this.this$0.i());
    }
}
