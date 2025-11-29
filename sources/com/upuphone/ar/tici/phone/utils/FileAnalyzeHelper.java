package com.upuphone.ar.tici.phone.utils;

import java.io.File;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/FileAnalyzeHelper;", "", "a", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class FileAnalyzeHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f5989a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\t\u0010\bJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u000b\u0010\bJ(\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH@¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0011\u0010\bJ\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0012\u0010\bJ\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0014\u0010\bJ\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0015\u0010\bR\u0014\u0010\u0016\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/FileAnalyzeHelper$Companion;", "", "<init>", "()V", "Ljava/io/File;", "file", "Ljava/nio/charset/Charset;", "a", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "", "c", "charset", "", "maxLength", "h", "(Ljava/io/File;Ljava/nio/charset/Charset;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "g", "Lkotlin/sequences/Sequence;", "d", "f", "TAG", "Ljava/lang/String;", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Object a(File file, Continuation continuation) {
            return BuildersKt.g(Dispatchers.b(), new FileAnalyzeHelper$Companion$detectCharset$2(file, (Continuation<? super FileAnalyzeHelper$Companion$detectCharset$2>) null), continuation);
        }

        public final Object b(File file, Continuation continuation) {
            return BuildersKt.g(Dispatchers.b(), new FileAnalyzeHelper$Companion$detectEncodingCharset$2(file, (Continuation<? super FileAnalyzeHelper$Companion$detectEncodingCharset$2>) null), continuation);
        }

        public final Object c(File file, Continuation continuation) {
            return BuildersKt.g(Dispatchers.b(), new FileAnalyzeHelper$Companion$detectMime$2(file, (Continuation<? super FileAnalyzeHelper$Companion$detectMime$2>) null), continuation);
        }

        public final Object d(File file, Continuation continuation) {
            return SequencesKt.sequenceOf("");
        }

        public final Object e(File file, Continuation continuation) {
            return "";
        }

        public final Object f(File file, Continuation continuation) {
            return SequencesKt.sequenceOf("");
        }

        public final Object g(File file, Continuation continuation) {
            return "";
        }

        public final Object h(File file, Charset charset, int i, Continuation continuation) {
            return BuildersKt.g(Dispatchers.b(), new FileAnalyzeHelper$Companion$readTxtFileContent$2(file, charset, i, (Continuation<? super FileAnalyzeHelper$Companion$readTxtFileContent$2>) null), continuation);
        }

        public Companion() {
        }
    }
}
