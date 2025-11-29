package dagger.internal;

import javax.inject.Provider;

public final class Providers {
    public static Provider a(final Provider provider) {
        Preconditions.b(provider);
        return new Provider<Object>() {
            public Object get() {
                return Provider.this.get();
            }
        };
    }
}
