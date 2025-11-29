package com.luck.picture.lib.utils;

import android.content.Context;
import com.luck.picture.lib.interfaces.OnCallbackListener;
import com.luck.picture.lib.thread.PictureThreadUtils;

public class DownloadFileUtils {
    public static void a(final Context context, final String str, final String str2, final OnCallbackListener onCallbackListener) {
        PictureThreadUtils.h(new PictureThreadUtils.SimpleTask<String>() {
            /* JADX WARNING: Removed duplicated region for block: B:19:0x0060 A[Catch:{ Exception -> 0x0052 }] */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0069 A[Catch:{ Exception -> 0x0052 }] */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x00f0 A[Catch:{ Exception -> 0x0052 }] */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x00f9 A[Catch:{ Exception -> 0x0052 }] */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x0176 A[Catch:{ Exception -> 0x0052 }] */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x017f A[Catch:{ Exception -> 0x0052 }] */
            /* renamed from: o */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.String f() {
                /*
                    r14 = this;
                    java.lang.String r0 = "IMG_"
                    java.lang.String r1 = "VID_"
                    java.lang.String r2 = "AUD_"
                    android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x0052 }
                    r3.<init>()     // Catch:{ Exception -> 0x0052 }
                    long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0052 }
                    java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r4 = com.luck.picture.lib.utils.ValueOf.g(r4)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r5 = r3     // Catch:{ Exception -> 0x0052 }
                    boolean r5 = com.luck.picture.lib.config.PictureMimeType.d(r5)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r6 = "image"
                    java.lang.String r7 = "video"
                    java.lang.String r8 = "_data"
                    java.lang.String r9 = "mounted"
                    java.lang.String r10 = "relative_path"
                    java.lang.String r11 = "datetaken"
                    java.lang.String r12 = "mime_type"
                    java.lang.String r13 = "_display_name"
                    if (r5 == 0) goto L_0x00b8
                    java.lang.String r0 = com.luck.picture.lib.utils.DateUtils.c(r2)     // Catch:{ Exception -> 0x0052 }
                    r3.put(r13, r0)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x0052 }
                    boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0052 }
                    if (r0 != 0) goto L_0x0055
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x0052 }
                    boolean r0 = r0.startsWith(r7)     // Catch:{ Exception -> 0x0052 }
                    if (r0 != 0) goto L_0x0055
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x0052 }
                    boolean r0 = r0.startsWith(r6)     // Catch:{ Exception -> 0x0052 }
                    if (r0 == 0) goto L_0x004f
                    goto L_0x0055
                L_0x004f:
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x0052 }
                    goto L_0x0057
                L_0x0052:
                    r14 = move-exception
                    goto L_0x0221
                L_0x0055:
                    java.lang.String r0 = "audio/mpeg"
                L_0x0057:
                    r3.put(r12, r0)     // Catch:{ Exception -> 0x0052 }
                    boolean r0 = com.luck.picture.lib.utils.SdkVersionUtils.f()     // Catch:{ Exception -> 0x0052 }
                    if (r0 == 0) goto L_0x0069
                    r3.put(r11, r4)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = android.os.Environment.DIRECTORY_MUSIC     // Catch:{ Exception -> 0x0052 }
                    r3.put(r10, r0)     // Catch:{ Exception -> 0x0052 }
                    goto L_0x00aa
                L_0x0069:
                    java.lang.String r0 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x0052 }
                    boolean r0 = android.text.TextUtils.equals(r0, r9)     // Catch:{ Exception -> 0x0052 }
                    if (r0 == 0) goto L_0x007a
                    java.lang.String r0 = android.os.Environment.DIRECTORY_MUSIC     // Catch:{ Exception -> 0x0052 }
                    java.io.File r0 = android.os.Environment.getExternalStoragePublicDirectory(r0)     // Catch:{ Exception -> 0x0052 }
                    goto L_0x0086
                L_0x007a:
                    java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0052 }
                    android.content.Context r1 = r1     // Catch:{ Exception -> 0x0052 }
                    r4 = 3
                    java.lang.String r1 = com.luck.picture.lib.utils.FileDirMap.b(r1, r4)     // Catch:{ Exception -> 0x0052 }
                    r0.<init>(r1)     // Catch:{ Exception -> 0x0052 }
                L_0x0086:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0052 }
                    r1.<init>()     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x0052 }
                    r1.append(r0)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = java.io.File.separator     // Catch:{ Exception -> 0x0052 }
                    r1.append(r0)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = com.luck.picture.lib.utils.DateUtils.c(r2)     // Catch:{ Exception -> 0x0052 }
                    r1.append(r0)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = ".amr"
                    r1.append(r0)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0052 }
                    r3.put(r8, r0)     // Catch:{ Exception -> 0x0052 }
                L_0x00aa:
                    android.content.Context r0 = r1     // Catch:{ Exception -> 0x0052 }
                    android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x0052 }
                    android.net.Uri r1 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x0052 }
                    android.net.Uri r0 = r0.insert(r1, r3)     // Catch:{ Exception -> 0x0052 }
                    goto L_0x01dc
                L_0x00b8:
                    java.lang.String r2 = r3     // Catch:{ Exception -> 0x0052 }
                    boolean r2 = com.luck.picture.lib.config.PictureMimeType.i(r2)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r5 = "audio"
                    if (r2 == 0) goto L_0x0148
                    java.lang.String r0 = com.luck.picture.lib.utils.DateUtils.c(r1)     // Catch:{ Exception -> 0x0052 }
                    r3.put(r13, r0)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x0052 }
                    boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0052 }
                    if (r0 != 0) goto L_0x00e5
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x0052 }
                    boolean r0 = r0.startsWith(r5)     // Catch:{ Exception -> 0x0052 }
                    if (r0 != 0) goto L_0x00e5
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x0052 }
                    boolean r0 = r0.startsWith(r6)     // Catch:{ Exception -> 0x0052 }
                    if (r0 == 0) goto L_0x00e2
                    goto L_0x00e5
                L_0x00e2:
                    java.lang.String r0 = r3     // Catch:{ Exception -> 0x0052 }
                    goto L_0x00e7
                L_0x00e5:
                    java.lang.String r0 = "video/mp4"
                L_0x00e7:
                    r3.put(r12, r0)     // Catch:{ Exception -> 0x0052 }
                    boolean r0 = com.luck.picture.lib.utils.SdkVersionUtils.f()     // Catch:{ Exception -> 0x0052 }
                    if (r0 == 0) goto L_0x00f9
                    r3.put(r11, r4)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = android.os.Environment.DIRECTORY_MOVIES     // Catch:{ Exception -> 0x0052 }
                    r3.put(r10, r0)     // Catch:{ Exception -> 0x0052 }
                    goto L_0x013a
                L_0x00f9:
                    java.lang.String r0 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x0052 }
                    boolean r0 = android.text.TextUtils.equals(r0, r9)     // Catch:{ Exception -> 0x0052 }
                    if (r0 == 0) goto L_0x010a
                    java.lang.String r0 = android.os.Environment.DIRECTORY_MOVIES     // Catch:{ Exception -> 0x0052 }
                    java.io.File r0 = android.os.Environment.getExternalStoragePublicDirectory(r0)     // Catch:{ Exception -> 0x0052 }
                    goto L_0x0116
                L_0x010a:
                    java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0052 }
                    android.content.Context r2 = r1     // Catch:{ Exception -> 0x0052 }
                    r4 = 2
                    java.lang.String r2 = com.luck.picture.lib.utils.FileDirMap.b(r2, r4)     // Catch:{ Exception -> 0x0052 }
                    r0.<init>(r2)     // Catch:{ Exception -> 0x0052 }
                L_0x0116:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0052 }
                    r2.<init>()     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x0052 }
                    r2.append(r0)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = java.io.File.separator     // Catch:{ Exception -> 0x0052 }
                    r2.append(r0)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = com.luck.picture.lib.utils.DateUtils.c(r1)     // Catch:{ Exception -> 0x0052 }
                    r2.append(r0)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = ".mp4"
                    r2.append(r0)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0052 }
                    r3.put(r8, r0)     // Catch:{ Exception -> 0x0052 }
                L_0x013a:
                    android.content.Context r0 = r1     // Catch:{ Exception -> 0x0052 }
                    android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x0052 }
                    android.net.Uri r1 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x0052 }
                    android.net.Uri r0 = r0.insert(r1, r3)     // Catch:{ Exception -> 0x0052 }
                    goto L_0x01dc
                L_0x0148:
                    java.lang.String r1 = com.luck.picture.lib.utils.DateUtils.c(r0)     // Catch:{ Exception -> 0x0052 }
                    r3.put(r13, r1)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r1 = r3     // Catch:{ Exception -> 0x0052 }
                    boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0052 }
                    if (r1 != 0) goto L_0x016b
                    java.lang.String r1 = r3     // Catch:{ Exception -> 0x0052 }
                    boolean r1 = r1.startsWith(r5)     // Catch:{ Exception -> 0x0052 }
                    if (r1 != 0) goto L_0x016b
                    java.lang.String r1 = r3     // Catch:{ Exception -> 0x0052 }
                    boolean r1 = r1.startsWith(r7)     // Catch:{ Exception -> 0x0052 }
                    if (r1 == 0) goto L_0x0168
                    goto L_0x016b
                L_0x0168:
                    java.lang.String r1 = r3     // Catch:{ Exception -> 0x0052 }
                    goto L_0x016d
                L_0x016b:
                    java.lang.String r1 = "image/jpeg"
                L_0x016d:
                    r3.put(r12, r1)     // Catch:{ Exception -> 0x0052 }
                    boolean r1 = com.luck.picture.lib.utils.SdkVersionUtils.f()     // Catch:{ Exception -> 0x0052 }
                    if (r1 == 0) goto L_0x017f
                    r3.put(r11, r4)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = "DCIM/Camera"
                    r3.put(r10, r0)     // Catch:{ Exception -> 0x0052 }
                    goto L_0x01d0
                L_0x017f:
                    java.lang.String r1 = r3     // Catch:{ Exception -> 0x0052 }
                    boolean r1 = com.luck.picture.lib.config.PictureMimeType.f(r1)     // Catch:{ Exception -> 0x0052 }
                    if (r1 != 0) goto L_0x018f
                    java.lang.String r1 = r2     // Catch:{ Exception -> 0x0052 }
                    boolean r1 = com.luck.picture.lib.config.PictureMimeType.m(r1)     // Catch:{ Exception -> 0x0052 }
                    if (r1 == 0) goto L_0x01d0
                L_0x018f:
                    java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x0052 }
                    boolean r1 = android.text.TextUtils.equals(r1, r9)     // Catch:{ Exception -> 0x0052 }
                    if (r1 == 0) goto L_0x01a0
                    java.lang.String r1 = android.os.Environment.DIRECTORY_PICTURES     // Catch:{ Exception -> 0x0052 }
                    java.io.File r1 = android.os.Environment.getExternalStoragePublicDirectory(r1)     // Catch:{ Exception -> 0x0052 }
                    goto L_0x01ac
                L_0x01a0:
                    java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0052 }
                    android.content.Context r2 = r1     // Catch:{ Exception -> 0x0052 }
                    r4 = 1
                    java.lang.String r2 = com.luck.picture.lib.utils.FileDirMap.b(r2, r4)     // Catch:{ Exception -> 0x0052 }
                    r1.<init>(r2)     // Catch:{ Exception -> 0x0052 }
                L_0x01ac:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0052 }
                    r2.<init>()     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x0052 }
                    r2.append(r1)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r1 = java.io.File.separator     // Catch:{ Exception -> 0x0052 }
                    r2.append(r1)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = com.luck.picture.lib.utils.DateUtils.c(r0)     // Catch:{ Exception -> 0x0052 }
                    r2.append(r0)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = ".gif"
                    r2.append(r0)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0052 }
                    r3.put(r8, r0)     // Catch:{ Exception -> 0x0052 }
                L_0x01d0:
                    android.content.Context r0 = r1     // Catch:{ Exception -> 0x0052 }
                    android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x0052 }
                    android.net.Uri r1 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x0052 }
                    android.net.Uri r0 = r0.insert(r1, r3)     // Catch:{ Exception -> 0x0052 }
                L_0x01dc:
                    if (r0 == 0) goto L_0x0224
                    java.lang.String r1 = r2     // Catch:{ Exception -> 0x0052 }
                    boolean r1 = com.luck.picture.lib.config.PictureMimeType.g(r1)     // Catch:{ Exception -> 0x0052 }
                    if (r1 == 0) goto L_0x01f2
                    java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r2 = r2     // Catch:{ Exception -> 0x0052 }
                    r1.<init>(r2)     // Catch:{ Exception -> 0x0052 }
                    java.io.InputStream r1 = r1.openStream()     // Catch:{ Exception -> 0x0052 }
                    goto L_0x020e
                L_0x01f2:
                    java.lang.String r1 = r2     // Catch:{ Exception -> 0x0052 }
                    boolean r1 = com.luck.picture.lib.config.PictureMimeType.c(r1)     // Catch:{ Exception -> 0x0052 }
                    if (r1 == 0) goto L_0x0207
                    android.content.Context r1 = r1     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r2 = r2     // Catch:{ Exception -> 0x0052 }
                    android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x0052 }
                    java.io.InputStream r1 = com.luck.picture.lib.basic.PictureContentResolver.a(r1, r2)     // Catch:{ Exception -> 0x0052 }
                    goto L_0x020e
                L_0x0207:
                    java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r2 = r2     // Catch:{ Exception -> 0x0052 }
                    r1.<init>(r2)     // Catch:{ Exception -> 0x0052 }
                L_0x020e:
                    android.content.Context r2 = r1     // Catch:{ Exception -> 0x0052 }
                    java.io.OutputStream r2 = com.luck.picture.lib.basic.PictureContentResolver.b(r2, r0)     // Catch:{ Exception -> 0x0052 }
                    boolean r1 = com.luck.picture.lib.utils.PictureFileUtils.r(r1, r2)     // Catch:{ Exception -> 0x0052 }
                    if (r1 == 0) goto L_0x0224
                    android.content.Context r14 = r1     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r14 = com.luck.picture.lib.utils.PictureFileUtils.h(r14, r0)     // Catch:{ Exception -> 0x0052 }
                    return r14
                L_0x0221:
                    r14.printStackTrace()
                L_0x0224:
                    r14 = 0
                    return r14
                */
                throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.utils.DownloadFileUtils.AnonymousClass1.f():java.lang.String");
            }

            /* renamed from: p */
            public void l(String str) {
                PictureThreadUtils.d(this);
                OnCallbackListener onCallbackListener = onCallbackListener;
                if (onCallbackListener != null) {
                    onCallbackListener.a(str);
                }
            }
        });
    }
}
