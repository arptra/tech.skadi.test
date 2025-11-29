package io.netty.handler.codec.serialization;

class ClassLoaderClassResolver implements ClassResolver {
    private final ClassLoader classLoader;

    public ClassLoaderClassResolver(ClassLoader classLoader2) {
        this.classLoader = classLoader2;
    }

    public Class<?> resolve(String str) throws ClassNotFoundException {
        try {
            return this.classLoader.loadClass(str);
        } catch (ClassNotFoundException unused) {
            return Class.forName(str, false, this.classLoader);
        }
    }
}
