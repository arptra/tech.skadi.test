package kotlin.reflect.jvm.internal.impl.types;

import com.upuphone.runasone.relay.api.IntentKey;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeSubstitution$Companion$EMPTY$1 extends TypeSubstitution {
    @Nullable
    public Void get(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, IntentKey.ACTIVITY.ACTION_KEY);
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    @NotNull
    public String toString() {
        return "Empty TypeSubstitution";
    }
}
