package kotlin.reflect.jvm.internal.impl.types;

import com.upuphone.runasone.relay.api.IntentKey;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeConstructorSubstitution$Companion$createByConstructorsMap$1 extends TypeConstructorSubstitution {
    final /* synthetic */ boolean $approximateCapturedTypes;
    final /* synthetic */ Map<TypeConstructor, TypeProjection> $map;

    public TypeConstructorSubstitution$Companion$createByConstructorsMap$1(Map<TypeConstructor, ? extends TypeProjection> map, boolean z) {
        this.$map = map;
        this.$approximateCapturedTypes = z;
    }

    public boolean approximateCapturedTypes() {
        return this.$approximateCapturedTypes;
    }

    @Nullable
    public TypeProjection get(@NotNull TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, IntentKey.ACTIVITY.ACTION_KEY);
        return this.$map.get(typeConstructor);
    }

    public boolean isEmpty() {
        return this.$map.isEmpty();
    }
}
