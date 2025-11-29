package com.upuphone.star.core.log;

import com.upuphone.star.core.log.ULog;
import com.upuphone.star.core.log.file.FilePrinter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\b&\u0018\u0000 \u000f2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\f\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000e\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\tJ-\u0010\u000f\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0012\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\tJ-\u0010\u0013\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0013\u0010\rJ\u0019\u0010\u0014\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0011J#\u0010\u0015\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\tJ-\u0010\u0016\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0016\u0010\rJ#\u0010\u0017\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\tJ-\u0010\u0018\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0018\u0010\rJ!\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\u001e\u0010\u001fJ5\u0010 \u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010#R\"\u0010'\u001a\u0010\u0012\f\u0012\n %*\u0004\u0018\u00010\u00040\u00040$8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010&¨\u0006)"}, d2 = {"Lcom/upuphone/star/core/log/Printer;", "", "<init>", "()V", "", "tag", "message", "", "l", "(Ljava/lang/String;Ljava/lang/String;)V", "", "t", "m", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "a", "b", "f", "(Ljava/lang/String;)V", "g", "h", "n", "o", "p", "c", "d", "", "priority", "", "i", "(Ljava/lang/String;I)Z", "j", "(ILjava/lang/String;Ljava/lang/String;)V", "k", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "e", "(Ljava/lang/Throwable;)Ljava/lang/String;", "", "kotlin.jvm.PlatformType", "Ljava/util/List;", "fqcnIgnore", "Companion", "logger_release"}, k = 1, mv = {1, 7, 1})
public abstract class Printer {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final List f6445a = CollectionsKt.listOf(ULog.class.getName(), ULog.Delegate.class.getName(), Printer.class.getName(), DebugPrinter.class.getName(), FormatPrinter.class.getName(), FilePrinter.class.getName(), GroupPrinter.class.getName());

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/star/core/log/Printer$Companion;", "", "()V", "MAX_LOG_LENGTH", "", "MAX_TAG_LENGTH", "logger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void a(String str, String str2) {
        k(3, str, str2, (Throwable) null);
    }

    public void b(String str, String str2, Throwable th) {
        k(3, str, str2, th);
    }

    public void c(String str, String str2) {
        k(6, str, str2, (Throwable) null);
    }

    public void d(String str, String str2, Throwable th) {
        k(6, str, str2, th);
    }

    public final String e(Throwable th) {
        StringWriter stringWriter = new StringWriter(256);
        PrintWriter printWriter = new PrintWriter(stringWriter, false);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "sw.toString()");
        return stringWriter2;
    }

    public void f(String str) {
        k(4, (String) null, str, (Throwable) null);
    }

    public void g(String str, String str2) {
        k(4, str, str2, (Throwable) null);
    }

    public void h(String str, String str2, Throwable th) {
        k(4, str, str2, th);
    }

    public boolean i(String str, int i) {
        return true;
    }

    public abstract void j(int i, String str, String str2);

    public final void k(int i, String str, String str2, Throwable th) {
        if (i(str, i) && i(str, i)) {
            if (str2 == null || str2.length() == 0) {
                if (th != null) {
                    str2 = e(th);
                } else {
                    return;
                }
            } else if (th != null) {
                str2 = str2 + 10 + e(th);
            }
            if (str == null) {
                str = "";
            }
            j(i, str, str2);
        }
    }

    public void l(String str, String str2) {
        k(2, str, str2, (Throwable) null);
    }

    public void m(String str, String str2, Throwable th) {
        k(2, str, str2, th);
    }

    public void n(String str) {
        k(5, (String) null, str, (Throwable) null);
    }

    public void o(String str, String str2) {
        k(5, str, str2, (Throwable) null);
    }

    public void p(String str, String str2, Throwable th) {
        k(5, str, str2, th);
    }
}
