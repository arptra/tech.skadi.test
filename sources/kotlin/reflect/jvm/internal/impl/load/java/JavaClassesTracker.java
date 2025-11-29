package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import org.jetbrains.annotations.NotNull;

public interface JavaClassesTracker {

    public static final class Default implements JavaClassesTracker {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        public void reportClass(@NotNull JavaClassDescriptor javaClassDescriptor) {
            Intrinsics.checkNotNullParameter(javaClassDescriptor, "classDescriptor");
        }
    }

    void reportClass(@NotNull JavaClassDescriptor javaClassDescriptor);
}
