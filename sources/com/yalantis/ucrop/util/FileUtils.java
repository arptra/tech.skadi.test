package com.yalantis.ucrop.util;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.honey.account.constant.AccountConstantKt;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import org.eclipse.jetty.util.URIUtil;

public class FileUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f8752a = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r10, java.lang.String r11) {
        /*
            boolean r0 = r10.equalsIgnoreCase(r11)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x003d }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x003d }
            r2.<init>(r10)     // Catch:{ all -> 0x003d }
            r1.<init>(r2)     // Catch:{ all -> 0x003d }
            java.nio.channels.FileChannel r10 = r1.getChannel()     // Catch:{ all -> 0x003d }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0038 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0038 }
            r2.<init>(r11)     // Catch:{ all -> 0x0038 }
            r1.<init>(r2)     // Catch:{ all -> 0x0038 }
            java.nio.channels.FileChannel r0 = r1.getChannel()     // Catch:{ all -> 0x0038 }
            long r6 = r10.size()     // Catch:{ all -> 0x0038 }
            r4 = 0
            r3 = r10
            r8 = r0
            r3.transferTo(r4, r6, r8)     // Catch:{ all -> 0x0038 }
            r10.close()
            if (r0 == 0) goto L_0x0037
            r0.close()
        L_0x0037:
            return
        L_0x0038:
            r11 = move-exception
            r9 = r0
            r0 = r10
            r10 = r9
            goto L_0x003f
        L_0x003d:
            r11 = move-exception
            r10 = r0
        L_0x003f:
            if (r0 == 0) goto L_0x0044
            r0.close()
        L_0x0044:
            if (r10 == 0) goto L_0x0049
            r10.close()
        L_0x0049:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.FileUtils.a(java.lang.String, java.lang.String):void");
    }

    public static String b() {
        return f8752a.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static String c(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        return str + f8752a.format(Long.valueOf(currentTimeMillis));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        if (r8 != null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        if (r8 != null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ IllegalArgumentException -> 0x0034, all -> 0x0032 }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x0034, all -> 0x0032 }
            if (r8 == 0) goto L_0x002c
            boolean r9 = r8.moveToFirst()     // Catch:{ IllegalArgumentException -> 0x002a }
            if (r9 == 0) goto L_0x002c
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ IllegalArgumentException -> 0x002a }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ IllegalArgumentException -> 0x002a }
            r8.close()
            return r9
        L_0x0027:
            r9 = move-exception
            r7 = r8
            goto L_0x0051
        L_0x002a:
            r9 = move-exception
            goto L_0x0036
        L_0x002c:
            if (r8 == 0) goto L_0x0050
        L_0x002e:
            r8.close()
            goto L_0x0050
        L_0x0032:
            r9 = move-exception
            goto L_0x0051
        L_0x0034:
            r9 = move-exception
            r8 = r7
        L_0x0036:
            java.lang.String r10 = "FileUtils"
            java.util.Locale r11 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0027 }
            java.lang.String r0 = "getDataColumn: _data - [%s]"
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0027 }
            java.lang.Object[] r9 = new java.lang.Object[]{r9}     // Catch:{ all -> 0x0027 }
            java.lang.String r9 = java.lang.String.format(r11, r0, r9)     // Catch:{ all -> 0x0027 }
            android.util.Log.i(r10, r9)     // Catch:{ all -> 0x0027 }
            if (r8 == 0) goto L_0x0050
            goto L_0x002e
        L_0x0050:
            return r7
        L_0x0051:
            if (r7 == 0) goto L_0x0056
            r7.close()
        L_0x0056:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.FileUtils.d(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static String e(Uri uri) {
        return (j(uri.toString()) || p(uri.toString())) ? uri.toString() : uri.getPath();
    }

    public static String f(Context context, Uri uri) {
        if (uri.getScheme().equals("content")) {
            return context.getContentResolver().getType(uri);
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase());
    }

    public static String g(Context context, Uri uri) {
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (l(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(AccountConstantKt.CODE_SEPARTOR);
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (k(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (!TextUtils.isEmpty(documentId)) {
                    try {
                        return d(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), (String) null, (String[]) null);
                    } catch (NumberFormatException e) {
                        Log.i("FileUtils", e.getMessage());
                        return null;
                    }
                }
            } else if (r(uri)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(AccountConstantKt.CODE_SEPARTOR);
                String str = split2[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return d(context, uri2, "_id=?", new String[]{split2[1]});
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return n(uri) ? uri.getLastPathSegment() : d(context, uri, (String) null, (String[]) null);
        } else {
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static String h(Context context, boolean z, Uri uri) {
        if (z) {
            String f = f(context, uri);
            if (m(f)) {
                return ".gif";
            }
            if (t(f)) {
                return ".webp";
            }
        }
        return "";
    }

    public static String i(Context context, boolean z, Uri uri) {
        if (z) {
            String f = f(context, uri);
            if (m(f)) {
                return ".gif";
            }
            if (t(f)) {
                return ".webp";
            }
        }
        return ".jpeg";
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("content://");
    }

    public static boolean k(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean l(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean m(String str) {
        return str != null && (str.equals("image/gif") || str.equals("image/GIF"));
    }

    public static boolean n(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean o(String str) {
        return str != null && str.startsWith("audio");
    }

    public static boolean p(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(URIUtil.HTTP) || str.startsWith(URIUtil.HTTPS) || str.startsWith("/http") || str.startsWith("/https");
    }

    public static boolean q(String str) {
        return str != null && str.startsWith("video");
    }

    public static boolean r(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean s(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().endsWith(".mp4");
    }

    public static boolean t(String str) {
        return str != null && (str.equals("image/webp") || str.equals("image/WEBP"));
    }

    public static Uri u(Context context, boolean z, Uri uri, Uri uri2) {
        try {
            String h = h(context, z, uri);
            if (TextUtils.isEmpty(h)) {
                return uri2;
            }
            String uri3 = j(uri2.toString()) ? uri2.toString() : uri2.getPath();
            String replace = uri3.replace(uri3.substring(uri3.lastIndexOf(".")), h);
            return j(replace) ? Uri.parse(replace) : Uri.fromFile(new File(replace));
        } catch (Exception e) {
            e.printStackTrace();
            return uri2;
        }
    }

    public static boolean v(InputStream inputStream, OutputStream outputStream) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                bufferedOutputStream = new BufferedOutputStream(outputStream);
            } catch (Exception e) {
                e = e;
                bufferedOutputStream = null;
                bufferedInputStream = bufferedInputStream2;
                try {
                    e.printStackTrace();
                    BitmapLoadUtils.c(bufferedInputStream);
                    BitmapLoadUtils.c(bufferedOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    BitmapLoadUtils.c(bufferedInputStream);
                    BitmapLoadUtils.c(bufferedOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                bufferedInputStream = bufferedInputStream2;
                BitmapLoadUtils.c(bufferedInputStream);
                BitmapLoadUtils.c(bufferedOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        BitmapLoadUtils.c(bufferedInputStream2);
                        BitmapLoadUtils.c(bufferedOutputStream);
                        return true;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                bufferedInputStream = bufferedInputStream2;
                e.printStackTrace();
                BitmapLoadUtils.c(bufferedInputStream);
                BitmapLoadUtils.c(bufferedOutputStream);
                return false;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                BitmapLoadUtils.c(bufferedInputStream);
                BitmapLoadUtils.c(bufferedOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedOutputStream = null;
            e.printStackTrace();
            BitmapLoadUtils.c(bufferedInputStream);
            BitmapLoadUtils.c(bufferedOutputStream);
            return false;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
            BitmapLoadUtils.c(bufferedInputStream);
            BitmapLoadUtils.c(bufferedOutputStream);
            throw th;
        }
    }
}
