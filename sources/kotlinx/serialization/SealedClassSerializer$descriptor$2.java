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
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "T", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class SealedClassSerializer$descriptor$2 extends Lambda implements Function0<SerialDescriptor> {
    final /* synthetic */ String $serialName;
    final /* synthetic */ SealedClassSerializer<Object> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SealedClassSerializer$descriptor$2(String str, SealedClassSerializer<Object> sealedClassSerializer) {
        super(0);
        this.$serialName = str;
        this.this$0 = sealedClassSerializer;
    }

    @NotNull
    public final SerialDescriptor invoke() {
        final SealedClassSerializer<Object> sealedClassSerializer = this.this$0;
        return SerialDescriptorsKt.c(this.$serialName, PolymorphicKind.SEALED.f3991a, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ClassSerialDescriptorBuilder) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
                ClassSerialDescriptorBuilder.b(classSerialDescriptorBuilder, "type", BuiltinSerializersKt.H(StringCompanionObject.INSTANCE).getDescriptor(), (List) null, false, 12, (Object) null);
                ClassSerialDescriptorBuilder.b(classSerialDescriptorBuilder, AccountConstantKt.RESPONSE_VALUE, SerialDescriptorsKt.c("kotlinx.serialization.Sealed<" + sealedClassSerializer.i().getSimpleName() + Typography.greater, SerialKind.CONTEXTUAL.f4006a, new SerialDescriptor[0], new SealedClassSerializer$descriptor$2$1$elementDescriptor$1(sealedClassSerializer)), (List) null, false, 12, (Object) null);
                classSerialDescriptorBuilder.h(sealedClassSerializer.b);
            }
        });
    }
}
