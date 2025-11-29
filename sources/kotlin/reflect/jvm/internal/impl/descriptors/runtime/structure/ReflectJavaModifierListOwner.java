package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner;

public interface ReflectJavaModifierListOwner extends JavaModifierListOwner {
    int getModifiers();
}
