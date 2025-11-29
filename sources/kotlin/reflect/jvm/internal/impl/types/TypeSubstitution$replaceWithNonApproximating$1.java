package kotlin.reflect.jvm.internal.impl.types;

import com.upuphone.runasone.relay.api.IntentKey;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeSubstitution$replaceWithNonApproximating$1 extends TypeSubstitution {
    final /* synthetic */ TypeSubstitution this$0;

    public TypeSubstitution$replaceWithNonApproximating$1(TypeSubstitution typeSubstitution) {
        this.this$0 = typeSubstitution;
    }

    public boolean approximateCapturedTypes() {
        return false;
    }

    public boolean approximateContravariantCapturedTypes() {
        return false;
    }

    @NotNull
    public Annotations filterAnnotations(@NotNull Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        return this.this$0.filterAnnotations(annotations);
    }

    @Nullable
    public TypeProjection get(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, IntentKey.ACTIVITY.ACTION_KEY);
        return this.this$0.get(kotlinType);
    }

    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @NotNull
    public KotlinType prepareTopLevelType(@NotNull KotlinType kotlinType, @NotNull Variance variance) {
        Intrinsics.checkNotNullParameter(kotlinType, "topLevelType");
        Intrinsics.checkNotNullParameter(variance, "position");
        return this.this$0.prepareTopLevelType(kotlinType, variance);
    }
}
