package io.netty.util;

public final class Signal extends Error implements Constant<Signal> {
    private static final ConstantPool<Signal> pool = new ConstantPool<Signal>() {
        public Signal newConstant(int i, String str) {
            return new Signal(i, str);
        }
    };
    private static final long serialVersionUID = -221145131122459977L;
    private final SignalConstant constant;

    public static final class SignalConstant extends AbstractConstant<SignalConstant> {
        public SignalConstant(int i, String str) {
            super(i, str);
        }
    }

    public static Signal valueOf(String str) {
        return pool.valueOf(str);
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public void expect(Signal signal) {
        if (this != signal) {
            throw new IllegalStateException("unexpected signal: " + signal);
        }
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    public int id() {
        return this.constant.id();
    }

    public Throwable initCause(Throwable th) {
        return this;
    }

    public String name() {
        return this.constant.name();
    }

    public String toString() {
        return name();
    }

    private Signal(int i, String str) {
        this.constant = new SignalConstant(i, str);
    }

    public static Signal valueOf(Class<?> cls, String str) {
        return pool.valueOf(cls, str);
    }

    public int compareTo(Signal signal) {
        if (this == signal) {
            return 0;
        }
        return this.constant.compareTo(signal.constant);
    }
}
