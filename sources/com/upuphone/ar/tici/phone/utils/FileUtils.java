package com.upuphone.ar.tici.phone.utils;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H@¢\u0006\u0004\b\t\u0010\nJ(\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH@¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H@¢\u0006\u0004\b\u0013\u0010\nJ\"\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H@¢\u0006\u0004\b\u0014\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/FileUtils;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "Ljava/io/File;", "a", "(Landroid/content/Context;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/InputStream;", "inputStream", "", "directoryPath", "fileName", "d", "(Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "c", "b", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class FileUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final FileUtils f5991a = new FileUtils();

    public final Object a(Context context, Uri uri, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new FileUtils$copyTiciTxtFile$2(context, uri, (Continuation<? super FileUtils$copyTiciTxtFile$2>) null), continuation);
    }

    public final Object b(Context context, Uri uri, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new FileUtils$getFileNameFromUri$2(context, uri, (Continuation<? super FileUtils$getFileNameFromUri$2>) null), continuation);
    }

    public final Object c(Context context, Uri uri, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new FileUtils$getFileSize$2(uri, context, (Continuation<? super FileUtils$getFileSize$2>) null), continuation);
    }

    public final Object d(InputStream inputStream, String str, String str2, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new FileUtils$saveInputStreamToFile$2(str, str2, inputStream, (Continuation<? super FileUtils$saveInputStreamToFile$2>) null), continuation);
    }
}
