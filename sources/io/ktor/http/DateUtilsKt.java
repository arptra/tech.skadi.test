package io.ktor.http;

import io.ktor.util.date.GMTDate;
import io.ktor.util.date.GMTDateParser;
import io.ktor.util.date.InvalidDateStringException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\"\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0006¨\u0006\b"}, d2 = {"", "Lio/ktor/util/date/GMTDate;", "b", "(Ljava/lang/String;)Lio/ktor/util/date/GMTDate;", "a", "", "Ljava/util/List;", "HTTP_DATE_FORMATS", "ktor-http"}, k = 2, mv = {1, 8, 0})
public final class DateUtilsKt {

    /* renamed from: a  reason: collision with root package name */
    public static final List f8956a = CollectionsKt.listOf("***, dd MMM YYYY hh:mm:ss zzz", "****, dd-MMM-YYYY hh:mm:ss zzz", "*** MMM d hh:mm:ss YYYY", "***, dd-MMM-YYYY hh:mm:ss zzz", "***, dd-MMM-YYYY hh-mm-ss zzz", "***, dd MMM YYYY hh:mm:ss zzz", "*** dd-MMM-YYYY hh:mm:ss zzz", "*** dd MMM YYYY hh:mm:ss zzz", "*** dd-MMM-YYYY hh-mm-ss zzz", "***,dd-MMM-YYYY hh:mm:ss zzz", "*** MMM d YYYY hh:mm:ss zzz");

    public static final GMTDate a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String obj = StringsKt.trim((CharSequence) str).toString();
        try {
            return new CookieDateParser().c(obj);
        } catch (InvalidCookieDateException unused) {
            return b(obj);
        }
    }

    public static final GMTDate b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String obj = StringsKt.trim((CharSequence) str).toString();
        for (String gMTDateParser : f8956a) {
            try {
                return new GMTDateParser(gMTDateParser).b(str);
            } catch (InvalidDateStringException unused) {
            }
        }
        throw new IllegalStateException(("Failed to parse date: " + obj).toString());
    }
}
