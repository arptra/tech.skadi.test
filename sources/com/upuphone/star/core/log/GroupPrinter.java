package com.upuphone.star.core.log;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/upuphone/star/core/log/GroupPrinter;", "Lcom/upuphone/star/core/log/Printer;", "<init>", "()V", "", "priority", "", "tag", "message", "", "j", "(ILjava/lang/String;Ljava/lang/String;)V", "printer", "q", "(Lcom/upuphone/star/core/log/Printer;)V", "r", "Ljava/util/concurrent/CopyOnWriteArraySet;", "c", "Ljava/util/concurrent/CopyOnWriteArraySet;", "printers", "logger_release"}, k = 1, mv = {1, 7, 1})
public final class GroupPrinter extends Printer {
    public final CopyOnWriteArraySet c = new CopyOnWriteArraySet();

    public void j(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "message");
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((Printer) it.next()).j(i, str, str2);
        }
    }

    public final void q(Printer printer) {
        Intrinsics.checkNotNullParameter(printer, "printer");
        this.c.add(printer);
    }

    public final void r(Printer printer) {
        Intrinsics.checkNotNullParameter(printer, "printer");
        this.c.remove(printer);
    }
}
