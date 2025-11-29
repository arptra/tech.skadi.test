package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;

public final class SubstitutingScope$substitutor$2 extends Lambda implements Function0<TypeSubstitutor> {
    final /* synthetic */ TypeSubstitutor $givenSubstitutor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubstitutingScope$substitutor$2(TypeSubstitutor typeSubstitutor) {
        super(0);
        this.$givenSubstitutor = typeSubstitutor;
    }

    @NotNull
    public final TypeSubstitutor invoke() {
        return this.$givenSubstitutor.getSubstitution().buildSubstitutor();
    }
}
