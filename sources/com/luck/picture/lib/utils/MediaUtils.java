package com.luck.picture.lib.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.luck.picture.lib.basic.PictureContentResolver;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.MediaExtraInfo;
import com.luck.picture.lib.interfaces.OnCallbackListener;
import com.luck.picture.lib.thread.PictureThreadUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

public class MediaUtils {

    /* renamed from: com.luck.picture.lib.utils.MediaUtils$3  reason: invalid class name */
    class AnonymousClass3 extends PictureThreadUtils.SimpleTask<MediaExtraInfo> {
        public final /* synthetic */ Context h;
        public final /* synthetic */ String i;
        public final /* synthetic */ OnCallbackListener j;

        /* renamed from: o */
        public MediaExtraInfo f() {
            return MediaUtils.o(this.h, this.i);
        }

        /* renamed from: p */
        public void l(MediaExtraInfo mediaExtraInfo) {
            PictureThreadUtils.d(this);
            OnCallbackListener onCallbackListener = this.j;
            if (onCallbackListener != null) {
                onCallbackListener.a(mediaExtraInfo);
            }
        }
    }

    public static Bundle a(String str, String[] strArr, int i, int i2, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("android:query-arg-sql-selection", str);
        bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
        bundle.putString("android:query-arg-sql-sort-order", str2);
        if (SdkVersionUtils.g()) {
            bundle.putString("android:query-arg-sql-limit", i + " offset " + i2);
        }
        return bundle;
    }

    public static void b(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && PictureMimeType.c(str)) {
                context.getContentResolver().delete(Uri.parse(str), (String) null, (String[]) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String c(String str) {
        File file = new File(str);
        return file.getParentFile() != null ? file.getParentFile().getName() : "Camera";
    }

    public static MediaExtraInfo d(Context context, String str) {
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        if (PictureMimeType.g(str)) {
            return mediaExtraInfo;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (PictureMimeType.c(str)) {
                mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
            } else {
                mediaMetadataRetriever.setDataSource(str);
            }
            mediaExtraInfo.d(ValueOf.e(mediaMetadataRetriever.extractMetadata(9)));
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            mediaMetadataRetriever.release();
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            throw th;
        }
        return mediaExtraInfo;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.os.CancellationSignal, java.lang.String[], android.database.Cursor] */
    public static int e(Context context, String str) {
        Cursor query;
        int i = -1;
        ? r2 = 0;
        try {
            String[] strArr = {"%" + str + "%"};
            if (SdkVersionUtils.g()) {
                query = context.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r2, a("_data like ?", strArr, 1, 0, "_id DESC"), r2);
            } else {
                query = context.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (String[]) null, "_data like ?", strArr, "_id DESC limit 1 offset 0");
            }
            Cursor cursor = query;
            if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
            int i2 = cursor.getInt(cursor.getColumnIndex("_id"));
            if (DateUtils.a(cursor.getLong(cursor.getColumnIndex("date_added"))) <= 1) {
                i = i2;
            }
            cursor.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            if (r2 != 0) {
                r2.close();
            }
            return -1;
        } catch (Throwable th) {
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
    }

    public static MediaExtraInfo f(Context context, String str) {
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        if (PictureMimeType.g(str)) {
            return mediaExtraInfo;
        }
        InputStream inputStream = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            InputStream a2 = PictureMimeType.c(str) ? PictureContentResolver.a(context, Uri.parse(str)) : new FileInputStream(str);
            try {
                BitmapFactory.decodeStream(a2, (Rect) null, options);
                mediaExtraInfo.h(options.outWidth);
                mediaExtraInfo.e(options.outHeight);
                PictureFileUtils.a(a2);
            } catch (Exception e) {
                inputStream = a2;
                e = e;
                try {
                    e.printStackTrace();
                    PictureFileUtils.a(inputStream);
                    return mediaExtraInfo;
                } catch (Throwable th) {
                    th = th;
                    PictureFileUtils.a(inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                inputStream = a2;
                th = th2;
                PictureFileUtils.a(inputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            PictureFileUtils.a(inputStream);
            return mediaExtraInfo;
        }
        return mediaExtraInfo;
    }

    public static void g(final Context context, final String str, final OnCallbackListener onCallbackListener) {
        PictureThreadUtils.h(new PictureThreadUtils.SimpleTask<MediaExtraInfo>() {
            /* renamed from: o */
            public MediaExtraInfo f() {
                return MediaUtils.f(context, str);
            }

            /* renamed from: p */
            public void l(MediaExtraInfo mediaExtraInfo) {
                PictureThreadUtils.d(this);
                OnCallbackListener onCallbackListener = onCallbackListener;
                if (onCallbackListener != null) {
                    onCallbackListener.a(mediaExtraInfo);
                }
            }
        });
    }

    public static String h(File file) {
        return URLConnection.getFileNameMap().getContentTypeFor(file.getName());
    }

    public static String i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.toLowerCase().endsWith(".jpg") || str.toLowerCase().endsWith(".jpeg")) {
            return "image/jpeg";
        }
        if (str.toLowerCase().endsWith(".png")) {
            return "image/png";
        }
        if (str.toLowerCase().endsWith(".gif")) {
            return "image/gif";
        }
        if (str.toLowerCase().endsWith(".webp")) {
            return "image/webp";
        }
        if (str.toLowerCase().endsWith(".bmp")) {
            return "image/bmp";
        }
        if (str.toLowerCase().endsWith(".mp4")) {
            return "video/mp4";
        }
        if (str.toLowerCase().endsWith(".avi")) {
            return "video/avi";
        }
        if (str.toLowerCase().endsWith(".mp3")) {
            return "audio/mpeg";
        }
        if (str.toLowerCase().endsWith(".amr")) {
            return "audio/amr";
        }
        if (str.toLowerCase().endsWith(".m4a")) {
            return "audio/mpeg";
        }
        return null;
    }

    public static String j(String str) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str).toLowerCase());
        if (TextUtils.isEmpty(mimeTypeFromExtension)) {
            mimeTypeFromExtension = h(new File(str));
        }
        return TextUtils.isEmpty(mimeTypeFromExtension) ? "image/jpeg" : mimeTypeFromExtension;
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [android.os.CancellationSignal, java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0088, code lost:
        if (r2 != 0) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008a, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0091, code lost:
        if (r2 == 0) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0094, code lost:
        return r1;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Long[] k(android.content.Context r11, java.lang.String r12) {
        /*
            java.lang.String r0 = "%"
            r1 = 2
            java.lang.Long[] r1 = new java.lang.Long[r1]
            r2 = 0
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r3 = 0
            r1[r3] = r2
            r4 = 1
            r1[r4] = r2
            r2 = 0
            java.lang.String r8 = "_data like ?"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0048 }
            r5.<init>()     // Catch:{ Exception -> 0x0048 }
            r5.append(r0)     // Catch:{ Exception -> 0x0048 }
            r5.append(r12)     // Catch:{ Exception -> 0x0048 }
            r5.append(r0)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r12 = r5.toString()     // Catch:{ Exception -> 0x0048 }
            java.lang.String[] r9 = new java.lang.String[]{r12}     // Catch:{ Exception -> 0x0048 }
            boolean r12 = com.luck.picture.lib.utils.SdkVersionUtils.g()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r0 = "external"
            if (r12 == 0) goto L_0x004a
            java.lang.String r12 = "_id DESC"
            android.os.Bundle r12 = a(r8, r9, r4, r3, r12)     // Catch:{ Exception -> 0x0048 }
            android.content.ContentResolver r11 = r11.getContentResolver()     // Catch:{ Exception -> 0x0048 }
            android.net.Uri r0 = android.provider.MediaStore.Files.getContentUri(r0)     // Catch:{ Exception -> 0x0048 }
            android.database.Cursor r11 = r11.query(r0, r2, r12, r2)     // Catch:{ Exception -> 0x0048 }
        L_0x0044:
            r2 = r11
            goto L_0x005a
        L_0x0046:
            r11 = move-exception
            goto L_0x0095
        L_0x0048:
            r11 = move-exception
            goto L_0x008e
        L_0x004a:
            java.lang.String r10 = "_id DESC limit 1 offset 0"
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch:{ Exception -> 0x0048 }
            android.net.Uri r6 = android.provider.MediaStore.Files.getContentUri(r0)     // Catch:{ Exception -> 0x0048 }
            r7 = 0
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0044
        L_0x005a:
            if (r2 == 0) goto L_0x0088
            int r11 = r2.getCount()     // Catch:{ Exception -> 0x0048 }
            if (r11 <= 0) goto L_0x0088
            boolean r11 = r2.moveToFirst()     // Catch:{ Exception -> 0x0048 }
            if (r11 == 0) goto L_0x0088
            java.lang.String r11 = "_id"
            int r11 = r2.getColumnIndex(r11)     // Catch:{ Exception -> 0x0048 }
            long r11 = r2.getLong(r11)     // Catch:{ Exception -> 0x0048 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ Exception -> 0x0048 }
            r1[r3] = r11     // Catch:{ Exception -> 0x0048 }
            java.lang.String r11 = "bucket_id"
            int r11 = r2.getColumnIndex(r11)     // Catch:{ Exception -> 0x0048 }
            long r11 = r2.getLong(r11)     // Catch:{ Exception -> 0x0048 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ Exception -> 0x0048 }
            r1[r4] = r11     // Catch:{ Exception -> 0x0048 }
        L_0x0088:
            if (r2 == 0) goto L_0x0094
        L_0x008a:
            r2.close()
            goto L_0x0094
        L_0x008e:
            r11.printStackTrace()     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x0094
            goto L_0x008a
        L_0x0094:
            return r1
        L_0x0095:
            if (r2 == 0) goto L_0x009a
            r2.close()
        L_0x009a:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.utils.MediaUtils.k(android.content.Context, java.lang.String):java.lang.Long[]");
    }

    public static String l(long j, String str) {
        return ContentUris.withAppendedId(PictureMimeType.h(str) ? MediaStore.Images.Media.EXTERNAL_CONTENT_URI : PictureMimeType.i(str) ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : PictureMimeType.d(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : MediaStore.Files.getContentUri("external"), j).toString();
    }

    public static MediaExtraInfo m(Context context, String str) {
        int i;
        int i2;
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        if (PictureMimeType.g(str)) {
            return mediaExtraInfo;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (PictureMimeType.c(str)) {
                mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
            } else {
                mediaMetadataRetriever.setDataSource(str);
            }
            String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
            if (!TextUtils.equals("90", extractMetadata)) {
                if (!TextUtils.equals("270", extractMetadata)) {
                    i = ValueOf.c(mediaMetadataRetriever.extractMetadata(18));
                    i2 = ValueOf.c(mediaMetadataRetriever.extractMetadata(19));
                    mediaExtraInfo.h(i);
                    mediaExtraInfo.e(i2);
                    mediaExtraInfo.f(extractMetadata);
                    mediaExtraInfo.d(ValueOf.e(mediaMetadataRetriever.extractMetadata(9)));
                    mediaMetadataRetriever.release();
                    return mediaExtraInfo;
                }
            }
            int c = ValueOf.c(mediaMetadataRetriever.extractMetadata(18));
            i2 = c;
            i = ValueOf.c(mediaMetadataRetriever.extractMetadata(19));
            mediaExtraInfo.h(i);
            mediaExtraInfo.e(i2);
            mediaExtraInfo.f(extractMetadata);
            mediaExtraInfo.d(ValueOf.e(mediaMetadataRetriever.extractMetadata(9)));
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            mediaMetadataRetriever.release();
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            throw th;
        }
        return mediaExtraInfo;
    }

    public static void n(final Context context, final String str, final OnCallbackListener onCallbackListener) {
        PictureThreadUtils.h(new PictureThreadUtils.SimpleTask<MediaExtraInfo>() {
            /* renamed from: o */
            public MediaExtraInfo f() {
                return MediaUtils.m(context, str);
            }

            /* renamed from: p */
            public void l(MediaExtraInfo mediaExtraInfo) {
                PictureThreadUtils.d(this);
                OnCallbackListener onCallbackListener = onCallbackListener;
                if (onCallbackListener != null) {
                    onCallbackListener.a(mediaExtraInfo);
                }
            }
        });
    }

    public static MediaExtraInfo o(Context context, String str) {
        FileOutputStream fileOutputStream;
        Bitmap bitmap;
        FileOutputStream fileOutputStream2;
        File file;
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            if (PictureMimeType.c(str)) {
                mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
            } else {
                mediaMetadataRetriever.setDataSource(str);
            }
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
            if (frameAtTime != null) {
                try {
                    if (!frameAtTime.isRecycled()) {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            frameAtTime.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream2);
                            file = new File(PictureFileUtils.j(context), DateUtils.c("vid_") + "_thumb.jpg");
                            fileOutputStream2 = new FileOutputStream(file);
                        } catch (IOException e) {
                            e = e;
                            ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream2;
                            bitmap = frameAtTime;
                            fileOutputStream = null;
                            byteArrayOutputStream = byteArrayOutputStream3;
                            try {
                                e.printStackTrace();
                                PictureFileUtils.a(byteArrayOutputStream);
                                PictureFileUtils.a(fileOutputStream);
                                if (bitmap != null && !bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                                return mediaExtraInfo;
                            } catch (Throwable th) {
                                th = th;
                                PictureFileUtils.a(byteArrayOutputStream);
                                PictureFileUtils.a(fileOutputStream);
                                bitmap.recycle();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
                            bitmap = frameAtTime;
                            fileOutputStream = null;
                            byteArrayOutputStream = byteArrayOutputStream4;
                            PictureFileUtils.a(byteArrayOutputStream);
                            PictureFileUtils.a(fileOutputStream);
                            if (bitmap != null && !bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            throw th;
                        }
                        try {
                            fileOutputStream2.write(byteArrayOutputStream2.toByteArray());
                            fileOutputStream2.flush();
                            mediaExtraInfo.g(file.getAbsolutePath());
                            mediaExtraInfo.h(frameAtTime.getWidth());
                            mediaExtraInfo.e(frameAtTime.getHeight());
                            byteArrayOutputStream = byteArrayOutputStream2;
                            PictureFileUtils.a(byteArrayOutputStream);
                            PictureFileUtils.a(fileOutputStream2);
                            if (frameAtTime != null && !frameAtTime.isRecycled()) {
                                frameAtTime.recycle();
                            }
                        } catch (IOException e2) {
                            Bitmap bitmap2 = frameAtTime;
                            fileOutputStream = fileOutputStream2;
                            e = e2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            bitmap = bitmap2;
                            e.printStackTrace();
                            PictureFileUtils.a(byteArrayOutputStream);
                            PictureFileUtils.a(fileOutputStream);
                            bitmap.recycle();
                            return mediaExtraInfo;
                        } catch (Throwable th3) {
                            byteArrayOutputStream = byteArrayOutputStream2;
                            bitmap = frameAtTime;
                            fileOutputStream = fileOutputStream2;
                            th = th3;
                            PictureFileUtils.a(byteArrayOutputStream);
                            PictureFileUtils.a(fileOutputStream);
                            bitmap.recycle();
                            throw th;
                        }
                        return mediaExtraInfo;
                    }
                } catch (IOException e3) {
                    e = e3;
                    bitmap = frameAtTime;
                    fileOutputStream = null;
                    e.printStackTrace();
                    PictureFileUtils.a(byteArrayOutputStream);
                    PictureFileUtils.a(fileOutputStream);
                    bitmap.recycle();
                    return mediaExtraInfo;
                } catch (Throwable th4) {
                    th = th4;
                    bitmap = frameAtTime;
                    fileOutputStream = null;
                    PictureFileUtils.a(byteArrayOutputStream);
                    PictureFileUtils.a(fileOutputStream);
                    bitmap.recycle();
                    throw th;
                }
            }
            fileOutputStream2 = null;
            PictureFileUtils.a(byteArrayOutputStream);
            PictureFileUtils.a(fileOutputStream2);
            frameAtTime.recycle();
        } catch (IOException e4) {
            e = e4;
            fileOutputStream = null;
            bitmap = null;
            e.printStackTrace();
            PictureFileUtils.a(byteArrayOutputStream);
            PictureFileUtils.a(fileOutputStream);
            bitmap.recycle();
            return mediaExtraInfo;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            bitmap = null;
            PictureFileUtils.a(byteArrayOutputStream);
            PictureFileUtils.a(fileOutputStream);
            bitmap.recycle();
            throw th;
        }
        return mediaExtraInfo;
    }

    public static boolean p(int i, int i2) {
        return i > 0 && i2 > 0 && i2 > i * 3;
    }

    public static void q(Context context, int i) {
        try {
            context.getApplicationContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{Long.toString((long) i)});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
