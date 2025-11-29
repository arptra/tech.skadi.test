package rxhttp.wrapper.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\b\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/net/Uri;", "Landroid/content/Context;", "context", "", "b", "(Landroid/net/Uri;Landroid/content/Context;)J", "Landroid/content/ContentResolver;", "contentResolver", "a", "(Landroid/net/Uri;Landroid/content/ContentResolver;)J", "rxhttp"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nUri.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Uri.kt\nrxhttp/wrapper/utils/UriUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,69:1\n1#2:70\n*E\n"})
@JvmName(name = "UriUtil")
public final class UriUtil {
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long a(android.net.Uri r4, android.content.ContentResolver r5) {
        /*
            java.lang.String r0 = "contentResolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = -1
            if (r4 != 0) goto L_0x000a
            return r0
        L_0x000a:
            java.lang.String r2 = r4.getScheme()
            java.lang.String r3 = "file"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0024
            java.io.File r5 = new java.io.File
            java.lang.String r4 = r4.getPath()
            r5.<init>(r4)
            long r4 = r5.length()
            return r4
        L_0x0024:
            java.lang.String r2 = "r"
            android.os.ParcelFileDescriptor r4 = r5.openFileDescriptor(r4, r2)     // Catch:{ FileNotFoundException -> 0x003e }
            if (r4 == 0) goto L_0x0038
            long r2 = r4.getStatSize()     // Catch:{ all -> 0x0031 }
            goto L_0x0039
        L_0x0031:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r5)     // Catch:{ FileNotFoundException -> 0x003e }
            throw r2     // Catch:{ FileNotFoundException -> 0x003e }
        L_0x0038:
            r2 = r0
        L_0x0039:
            r5 = 0
            kotlin.io.CloseableKt.closeFinally(r4, r5)     // Catch:{ FileNotFoundException -> 0x003e }
            r0 = r2
        L_0x003e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rxhttp.wrapper.utils.UriUtil.a(android.net.Uri, android.content.ContentResolver):long");
    }

    public static final long b(Uri uri, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        return a(uri, contentResolver);
    }
}
