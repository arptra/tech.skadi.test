package dagger.internal;

import dagger.MembersInjector;

public final class MembersInjectors {

    public enum NoOpMembersInjector implements MembersInjector<Object> {
        INSTANCE;

        public void injectMembers(Object obj) {
            Preconditions.c(obj, "Cannot inject members into a null reference");
        }
    }
}
