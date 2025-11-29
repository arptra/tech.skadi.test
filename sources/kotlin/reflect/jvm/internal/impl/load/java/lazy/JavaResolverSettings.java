package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import org.jetbrains.annotations.NotNull;

public interface JavaResolverSettings {
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    public static final class Default implements JavaResolverSettings {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        public boolean getCorrectNullabilityForNotNullTypeParameter() {
            return false;
        }

        public boolean getEnhancePrimitiveArrays() {
            return false;
        }

        public boolean getIgnoreNullabilityForErasedValueParameters() {
            return false;
        }

        public boolean getTypeEnhancementImprovementsInStrictMode() {
            return false;
        }
    }

    boolean getCorrectNullabilityForNotNullTypeParameter();

    boolean getEnhancePrimitiveArrays();

    boolean getIgnoreNullabilityForErasedValueParameters();

    boolean getTypeEnhancementImprovementsInStrictMode();
}
