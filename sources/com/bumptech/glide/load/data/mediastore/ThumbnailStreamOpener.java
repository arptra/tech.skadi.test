package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class ThumbnailStreamOpener {
    public static final FileService f = new FileService();

    /* renamed from: a  reason: collision with root package name */
    public final FileService f2467a;
    public final ThumbnailQuery b;
    public final ArrayPool c;
    public final ContentResolver d;
    public final List e;

    public ThumbnailStreamOpener(List list, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this(list, f, thumbnailQuery, arrayPool, contentResolver);
    }

    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            InputStream openInputStream = this.d.openInputStream(uri);
            int b2 = ImageHeaderParserUtils.b(this.e, openInputStream, this.c);
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException unused) {
                }
            }
            return b2;
        } catch (IOException | NullPointerException e2) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e2);
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused2) {
                return -1;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0030 A[Catch:{ all -> 0x001a }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(android.net.Uri r6) {
        /*
            r5 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = 0
            com.bumptech.glide.load.data.mediastore.ThumbnailQuery r5 = r5.b     // Catch:{ SecurityException -> 0x0027, all -> 0x0025 }
            android.database.Cursor r5 = r5.a(r6)     // Catch:{ SecurityException -> 0x0027, all -> 0x0025 }
            if (r5 == 0) goto L_0x001f
            boolean r2 = r5.moveToFirst()     // Catch:{ SecurityException -> 0x001d }
            if (r2 == 0) goto L_0x001f
            r2 = 0
            java.lang.String r6 = r5.getString(r2)     // Catch:{ SecurityException -> 0x001d }
            r5.close()
            return r6
        L_0x001a:
            r6 = move-exception
            r1 = r5
            goto L_0x004a
        L_0x001d:
            r2 = move-exception
            goto L_0x0029
        L_0x001f:
            if (r5 == 0) goto L_0x0024
            r5.close()
        L_0x0024:
            return r1
        L_0x0025:
            r6 = move-exception
            goto L_0x004a
        L_0x0027:
            r2 = move-exception
            r5 = r1
        L_0x0029:
            r3 = 3
            boolean r3 = android.util.Log.isLoggable(r0, r3)     // Catch:{ all -> 0x001a }
            if (r3 == 0) goto L_0x0044
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x001a }
            r3.<init>()     // Catch:{ all -> 0x001a }
            java.lang.String r4 = "Failed to query for thumbnail for Uri: "
            r3.append(r4)     // Catch:{ all -> 0x001a }
            r3.append(r6)     // Catch:{ all -> 0x001a }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x001a }
            android.util.Log.d(r0, r6, r2)     // Catch:{ all -> 0x001a }
        L_0x0044:
            if (r5 == 0) goto L_0x0049
            r5.close()
        L_0x0049:
            return r1
        L_0x004a:
            if (r1 == 0) goto L_0x004f
            r1.close()
        L_0x004f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener.b(android.net.Uri):java.lang.String");
    }

    public final boolean c(File file) {
        return this.f2467a.a(file) && 0 < this.f2467a.c(file);
    }

    public InputStream d(Uri uri) {
        String b2 = b(uri);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        File b3 = this.f2467a.b(b2);
        if (!c(b3)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(b3);
        try {
            return this.d.openInputStream(fromFile);
        } catch (NullPointerException e2) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e2));
        }
    }

    public ThumbnailStreamOpener(List list, FileService fileService, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this.f2467a = fileService;
        this.b = thumbnailQuery;
        this.c = arrayPool;
        this.d = contentResolver;
        this.e = list;
    }
}
