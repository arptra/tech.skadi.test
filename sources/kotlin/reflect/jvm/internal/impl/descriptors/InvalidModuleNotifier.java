package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

public interface InvalidModuleNotifier {
    void notifyModuleInvalidated(@NotNull ModuleDescriptor moduleDescriptor);
}
