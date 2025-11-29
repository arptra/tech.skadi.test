package com.bumptech.glide.load.engine.executor;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

final class RuntimeCompat {

    /* renamed from: com.bumptech.glide.load.engine.executor.RuntimeCompat$1  reason: invalid class name */
    class AnonymousClass1 implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Pattern f2540a;

        public boolean accept(File file, String str) {
            return this.f2540a.matcher(str).matches();
        }
    }

    public static int a() {
        return Runtime.getRuntime().availableProcessors();
    }
}
