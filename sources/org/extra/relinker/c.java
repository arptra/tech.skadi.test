package org.extra.relinker;

import android.content.Context;
import java.io.File;

public abstract class c {

    public interface a {
        void a(Context context, String[] strArr, String str, File file, d dVar);
    }

    public interface b {
        void a(String str);

        String[] a();

        String b(String str);

        void c(String str);

        String d(String str);
    }

    /* renamed from: org.extra.relinker.c$c  reason: collision with other inner class name */
    public interface C0023c {
        void a(Throwable th);
    }

    public static void a(Context context, String str) {
        b(context, str, (String) null, (C0023c) null);
    }

    public static void b(Context context, String str, String str2, C0023c cVar) {
        new d().d(context, str, str2, cVar);
    }
}
