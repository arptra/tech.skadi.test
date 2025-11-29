package org.joor;

import javax.tools.ForwardingJavaFileManager;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;

class Compile {

    public static final class CharSequenceJavaFileObject extends SimpleJavaFileObject {
    }

    public static final class ClassFileManager extends ForwardingJavaFileManager<StandardJavaFileManager> {
    }

    public static final class JavaFileObject extends SimpleJavaFileObject {
    }

    @FunctionalInterface
    public interface ThrowingBiFunction<T, U, R> {
    }
}
