package kotlin.reflect.jvm.internal.impl.types;

import com.upuphone.runasone.relay.api.IntentKey;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StarProjectionImplKt$buildStarProjectionTypeByTypeParameters$1 extends TypeConstructorSubstitution {
    final /* synthetic */ List<TypeConstructor> $typeParameters;

    public StarProjectionImplKt$buildStarProjectionTypeByTypeParameters$1(List<? extends TypeConstructor> list) {
        this.$typeParameters = list;
    }

    @Nullable
    public TypeProjection get(@NotNull TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, IntentKey.ACTIVITY.ACTION_KEY);
        if (!this.$typeParameters.contains(typeConstructor)) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        return TypeUtils.makeStarProjection((TypeParameterDescriptor) declarationDescriptor);
    }
}
