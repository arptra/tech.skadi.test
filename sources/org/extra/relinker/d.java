package org.extra.relinker;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.extra.relinker.c;
import org.extra.relinker.elf.i;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final Set f3351a;
    public final c.b b;
    public final c.a c;
    public boolean d;
    public boolean e;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3352a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(Context context, String str, String str2, c.C0023c cVar) {
            this.f3352a = context;
            this.b = str;
            this.c = str2;
        }

        public void run() {
            try {
                d.this.i(this.f3352a, this.b, this.c);
                throw null;
            } catch (UnsatisfiedLinkError unused) {
                throw null;
            } catch (b unused2) {
                throw null;
            }
        }
    }

    public class b implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3353a;

        public b(String str) {
            this.f3353a = str;
        }

        public boolean accept(File file, String str) {
            return str.startsWith(this.f3353a);
        }
    }

    public d() {
        this(new e(), new a());
    }

    public File a(Context context) {
        return context.getDir("lib", 0);
    }

    public void b(Context context, String str) {
        d(context, str, (String) null, (c.C0023c) null);
    }

    public void c(Context context, String str, String str2) {
        File a2 = a(context);
        File h = h(context, str, str2);
        File[] listFiles = a2.listFiles(new b(this.b.b(str)));
        if (listFiles != null) {
            for (File file : listFiles) {
                if (this.d || !file.getAbsolutePath().equals(h.getAbsolutePath())) {
                    try {
                        file.delete();
                    } catch (SecurityException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public void d(Context context, String str, String str2, c.C0023c cVar) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (!f.a(str)) {
            f("Beginning load of %s...", str);
            if (cVar == null) {
                i(context, str, str2);
                return;
            }
            try {
                new Thread(new a(context, str, str2, cVar)).start();
            } catch (Error | Exception e2) {
                cVar.a(e2);
            }
        } else {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
    }

    public void e(String str) {
    }

    public void f(String str, Object... objArr) {
        e(String.format(Locale.US, str, objArr));
    }

    public File h(Context context, String str, String str2) {
        String b2 = this.b.b(str);
        if (f.a(str2)) {
            return new File(a(context), b2);
        }
        File a2 = a(context);
        return new File(a2, b2 + "." + str2);
    }

    public final void i(Context context, String str, String str2) {
        i iVar;
        i iVar2;
        if (!this.f3351a.contains(str) || this.d) {
            try {
                this.b.a(str);
                this.f3351a.add(str);
                f("%s (%s) was loaded normally!", str, str2);
            } catch (UnsatisfiedLinkError e2) {
                f("Loading the library normally failed: %s", Log.getStackTraceString(e2));
                f("%s (%s) was not loaded normally, re-linking...", str, str2);
                File h = h(context, str, str2);
                if (!h.exists() || this.d) {
                    if (this.d) {
                        f("Forcing a re-link of %s (%s)...", str, str2);
                    }
                    c(context, str, str2);
                    this.c.a(context, this.b.a(), this.b.b(str), h, this);
                }
                try {
                    if (this.e) {
                        iVar = null;
                        iVar2 = new i(h);
                        List<String> i = iVar2.i();
                        iVar2.close();
                        for (String d2 : i) {
                            b(context, this.b.d(d2));
                        }
                    }
                } catch (IOException unused) {
                }
                this.b.c(h.getAbsolutePath());
                this.f3351a.add(str);
                f("%s (%s) was re-linked!", str, str2);
            } catch (Throwable th) {
                th = th;
                iVar = iVar2;
                iVar.close();
                throw th;
            }
        } else {
            f("%s already loaded previously!", str);
        }
    }

    public d(c.b bVar, c.a aVar) {
        this.f3351a = new HashSet();
        if (bVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        } else if (aVar != null) {
            this.b = bVar;
            this.c = aVar;
        } else {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
    }
}
