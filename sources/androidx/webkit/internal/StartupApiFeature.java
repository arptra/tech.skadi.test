package androidx.webkit.internal;

import java.util.HashSet;
import java.util.Set;

public abstract class StartupApiFeature {
    public static final Set c = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public final String f1975a;
    public final String b;

    public static class NoFramework extends StartupApiFeature {
        public NoFramework(String str, String str2) {
            super(str, str2);
        }
    }

    public static class P extends StartupApiFeature {
        public P(String str, String str2) {
            super(str, str2);
        }
    }

    public StartupApiFeature(String str, String str2) {
        this.f1975a = str;
        this.b = str2;
        c.add(this);
    }
}
