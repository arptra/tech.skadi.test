package com.upuphone.ar.tici.phone.utils;

import java.io.Closeable;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\t\u001a\u00020\u0005*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\u000f\u001a\u00020\u000e*\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0014\u0010\u0017\u001a\u00020\u0016*\u00020\u0015H@¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Ljava/io/File;", "Ljava/nio/charset/Charset;", "charset", "", "maxLength", "", "d", "(Ljava/io/File;Ljava/nio/charset/Charset;I)Ljava/lang/String;", "Ljava/io/Reader;", "e", "(Ljava/io/Reader;I)Ljava/lang/String;", "Ljava/io/Writer;", "out", "bufferSize", "", "b", "(Ljava/io/Reader;Ljava/io/Writer;II)J", "pageLimit", "Lkotlin/sequences/Sequence;", "f", "(Ljava/io/Reader;II)Lkotlin/sequences/Sequence;", "Ljava/io/Closeable;", "", "a", "(Ljava/io/Closeable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nFileExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileExt.kt\ncom/upuphone/ar/tici/phone/utils/FileExtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,104:1\n1#2:105\n*E\n"})
public final class FileExtKt {
    public static final Object a(Closeable closeable, Continuation continuation) {
        Object g = BuildersKt.g(Dispatchers.b(), new FileExtKt$closeSafely$2(closeable, (Continuation<? super FileExtKt$closeSafely$2>) null), continuation);
        return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
    }

    public static final long b(Reader reader, Writer writer, int i, int i2) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        Intrinsics.checkNotNullParameter(writer, "out");
        char[] cArr = new char[i2];
        int read = reader.read(cArr);
        long j = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j += (long) read;
            if (j >= ((long) i)) {
                break;
            }
            read = reader.read(cArr);
        }
        return j;
    }

    public static /* synthetic */ long c(Reader reader, Writer writer, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 8192;
        }
        return b(reader, writer, i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String d(java.io.File r2, java.nio.charset.Charset r3, int r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r2)
            r0.<init>(r1, r3)
            java.lang.String r2 = e(r0, r4)     // Catch:{ all -> 0x001d }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            return r2
        L_0x001d:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001f }
        L_0x001f:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.utils.FileExtKt.d(java.io.File, java.nio.charset.Charset, int):java.lang.String");
    }

    public static final String e(Reader reader, int i) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        c(reader, stringWriter, i, 0, 4, (Object) null);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "toString(...)");
        return StringExtKt.j(stringWriter2, i);
    }

    public static final Sequence f(Reader reader, int i, int i2) {
        Intrinsics.checkNotNullParameter(reader, "<this>");
        return SequencesKt.sequence(new FileExtKt$readTextSequence$1(i2, reader, i, (Continuation<? super FileExtKt$readTextSequence$1>) null));
    }
}
