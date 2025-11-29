package com.upuphone.star.core.log;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/upuphone/star/core/log/FormatPrinter;", "Lcom/upuphone/star/core/log/Printer;", "printer", "<init>", "(Lcom/upuphone/star/core/log/Printer;)V", "", "priority", "", "tag", "message", "", "j", "(ILjava/lang/String;Ljava/lang/String;)V", "", "i", "(Ljava/lang/String;I)Z", "q", "(Ljava/lang/String;)Ljava/lang/String;", "c", "Lcom/upuphone/star/core/log/Printer;", "logger_release"}, k = 1, mv = {1, 7, 1})
public final class FormatPrinter extends Printer {
    public final Printer c;

    public FormatPrinter(Printer printer) {
        Intrinsics.checkNotNullParameter(printer, "printer");
        this.c = printer;
    }

    public boolean i(String str, int i) {
        return this.c.i(str, i);
    }

    public void j(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "message");
        this.c.j(i, str, q(str2));
    }

    public final String q(String str) {
        Regex regex = new Regex("(13[0-9]|14[5|7]|15[0-9]|18[0-9])\\d{4}(\\d{4})$");
        return new Regex("[A-Fa-f\\d]{2}:[A-Fa-f\\d]{2}:[A-Fa-f\\d]{2}:[A-Fa-f\\d]{2}:([A-Fa-f\\d]{2}:[A-Fa-f\\d])").replace((CharSequence) new Regex("((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)").replace((CharSequence) regex.replace((CharSequence) str, "*$2"), "*$2.$3"), "*$1");
    }
}
