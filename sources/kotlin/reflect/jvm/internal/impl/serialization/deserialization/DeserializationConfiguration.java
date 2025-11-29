package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface DeserializationConfiguration {

    public static final class Default implements DeserializationConfiguration {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        public boolean getAllowUnstableDependencies() {
            return false;
        }

        @Nullable
        public BinaryVersion getBinaryVersion() {
            return null;
        }

        public boolean getPreserveDeclarationsOrdering() {
            return false;
        }

        public boolean getReportErrorsOnPreReleaseDependencies() {
            return false;
        }

        public boolean getSkipMetadataVersionCheck() {
            return false;
        }

        public boolean getSkipPrereleaseCheck() {
            return false;
        }

        public boolean getTypeAliasesAllowed() {
            return true;
        }
    }

    boolean getAllowUnstableDependencies();

    @Nullable
    BinaryVersion getBinaryVersion();

    boolean getPreserveDeclarationsOrdering();

    boolean getReportErrorsOnPreReleaseDependencies();

    boolean getSkipMetadataVersionCheck();

    boolean getSkipPrereleaseCheck();

    boolean getTypeAliasesAllowed();
}
