package com.upuphone.star.core.log;

import android.content.Context;
import com.upuphone.star.core.log.file.FilePrinter;
import com.upuphone.star.core.log.file.clean.FileLastModifiedCleanStrategy;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/star/core/log/ULog;", "", "a", "Delegate", "logger_release"}, k = 1, mv = {1, 7, 1})
public final class ULog {

    /* renamed from: a  reason: collision with root package name */
    public static final Delegate f6446a = new Delegate((DefaultConstructorMarker) null);
    public static Printer b = new DebugPrinter();
    public static final GroupPrinter c;
    public static FilePrinter d;
    public static boolean e = true;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0017¢\u0006\u0004\b\b\u0010\tJ-\u0010\f\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000e\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0017¢\u0006\u0004\b\u000e\u0010\tJ-\u0010\u000f\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b\u000f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0017¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0012\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0017¢\u0006\u0004\b\u0012\u0010\tJ-\u0010\u0013\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b\u0013\u0010\rJ\u0019\u0010\u0014\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0017¢\u0006\u0004\b\u0014\u0010\u0011J#\u0010\u0015\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0017¢\u0006\u0004\b\u0015\u0010\tJ-\u0010\u0016\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b\u0016\u0010\rJ#\u0010\u0017\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0017¢\u0006\u0004\b\u0017\u0010\tJ-\u0010\u0018\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b\u0018\u0010\rJ!\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0001H\u0007¢\u0006\u0004\b \u0010!J+\u0010&\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\u001bH\u0007¢\u0006\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b\u000b\u0010+\"\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u001b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u00018\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/upuphone/star/core/log/ULog$Delegate;", "Lcom/upuphone/star/core/log/Printer;", "<init>", "()V", "", "tag", "message", "", "l", "(Ljava/lang/String;Ljava/lang/String;)V", "", "t", "m", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "a", "b", "f", "(Ljava/lang/String;)V", "g", "h", "n", "o", "p", "c", "d", "", "priority", "", "i", "(Ljava/lang/String;I)Z", "j", "(ILjava/lang/String;Ljava/lang/String;)V", "s", "()Lcom/upuphone/star/core/log/Printer;", "Landroid/content/Context;", "context", "enable", "saveToExternal", "q", "(Landroid/content/Context;ZZ)V", "Lcom/upuphone/star/core/log/file/FilePrinter;", "filePrinter", "Lcom/upuphone/star/core/log/file/FilePrinter;", "()Lcom/upuphone/star/core/log/file/FilePrinter;", "u", "(Lcom/upuphone/star/core/log/file/FilePrinter;)V", "enabled", "Z", "printer", "Lcom/upuphone/star/core/log/Printer;", "Lcom/upuphone/star/core/log/GroupPrinter;", "printers", "Lcom/upuphone/star/core/log/GroupPrinter;", "logger_release"}, k = 1, mv = {1, 7, 1})
    public static final class Delegate extends Printer {
        public /* synthetic */ Delegate(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void r(Delegate delegate, Context context, boolean z, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            delegate.q(context, z, z2);
        }

        public void a(String str, String str2) {
            super.a(str, str2);
        }

        public void b(String str, String str2, Throwable th) {
            super.b(str, str2, th);
        }

        public void c(String str, String str2) {
            super.c(str, str2);
        }

        public void d(String str, String str2, Throwable th) {
            super.d(str, str2, th);
        }

        public void f(String str) {
            super.f(str);
        }

        public void g(String str, String str2) {
            super.g(str, str2);
        }

        public void h(String str, String str2, Throwable th) {
            super.h(str, str2, th);
        }

        public boolean i(String str, int i) {
            return ULog.e;
        }

        public void j(int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(str2, "message");
            ULog.c.j(i, str, str2);
        }

        public void l(String str, String str2) {
            super.l(str, str2);
        }

        public void m(String str, String str2, Throwable th) {
            super.m(str, str2, th);
        }

        public void n(String str) {
            super.n(str);
        }

        public void o(String str, String str2) {
            super.o(str, str2);
        }

        public void p(String str, String str2, Throwable th) {
            super.p(str, str2, th);
        }

        public final void q(Context context, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (z && t() == null) {
                u(new FilePrinter.Builder(new File(z2 ? context.getExternalFilesDir("") : context.getFilesDir(), "ulog").getPath()).b(new FileLastModifiedCleanStrategy(432000000)).a());
                GroupPrinter b = ULog.c;
                FilePrinter t = t();
                Intrinsics.checkNotNull(t);
                b.q(t);
            } else if (!z && t() != null) {
                FilePrinter t2 = t();
                if (t2 != null) {
                    t2.r();
                }
                GroupPrinter b2 = ULog.c;
                FilePrinter t3 = t();
                Intrinsics.checkNotNull(t3);
                b2.r(t3);
                u((FilePrinter) null);
            }
        }

        public final Printer s() {
            return new FormatPrinter(this);
        }

        public final FilePrinter t() {
            return ULog.d;
        }

        public final void u(FilePrinter filePrinter) {
            ULog.d = filePrinter;
        }

        public Delegate() {
        }
    }

    static {
        GroupPrinter groupPrinter = new GroupPrinter();
        c = groupPrinter;
        groupPrinter.q(b);
    }

    public static void d(String str, String str2) {
        f6446a.a(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        f6446a.b(str, str2, th);
    }

    public static void f(String str, String str2) {
        f6446a.c(str, str2);
    }

    public static void g(String str, String str2, Throwable th) {
        f6446a.d(str, str2, th);
    }

    public static final void h(Context context, boolean z, boolean z2) {
        f6446a.q(context, z, z2);
    }

    public static void i(String str, String str2) {
        f6446a.g(str, str2);
    }

    public static void j(String str, String str2, Throwable th) {
        f6446a.h(str, str2, th);
    }

    public static void k(String str, String str2) {
        f6446a.l(str, str2);
    }

    public static void l(String str, String str2, Throwable th) {
        f6446a.m(str, str2, th);
    }

    public static void m(String str, String str2) {
        f6446a.o(str, str2);
    }

    public static void n(String str, String str2, Throwable th) {
        f6446a.p(str, str2, th);
    }
}
