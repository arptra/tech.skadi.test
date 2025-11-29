package com.example.imagegallerysaver;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\tJ'\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJM\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010#0\"j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010#`$2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b%\u0010&JC\u0010(\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010#0\"j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010#`$2\b\u0010'\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0015\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010-¨\u0006/"}, d2 = {"Lcom/example/imagegallerysaver/ImageGallerySaverPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "<init>", "()V", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "binding", "", "onAttachedToEngine", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;)V", "Lio/flutter/plugin/common/MethodCall;", "call", "Lio/flutter/plugin/common/MethodChannel$Result;", "result", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "onDetachedFromEngine", "", "extension", "name", "Landroid/net/Uri;", "a", "(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;", "b", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", "context", "fileUri", "e", "(Landroid/content/Context;Landroid/net/Uri;)V", "Landroid/graphics/Bitmap;", "bmp", "", "quality", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "d", "(Landroid/graphics/Bitmap;Ljava/lang/Integer;Ljava/lang/String;)Ljava/util/HashMap;", "filePath", "c", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/HashMap;", "Lio/flutter/plugin/common/MethodChannel;", "Lio/flutter/plugin/common/MethodChannel;", "methodChannel", "Landroid/content/Context;", "applicationContext", "image_gallery_saver_release"}, k = 1, mv = {1, 7, 1})
public final class ImageGallerySaverPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a  reason: collision with root package name */
    public MethodChannel f2826a;
    public Context b;

    public final Uri a(String str, String str2) {
        ContentResolver contentResolver;
        if (str2 == null) {
            str2 = String.valueOf(System.currentTimeMillis());
        }
        String b2 = b(str);
        boolean z = false;
        if (b2 != null && StringsKt.startsWith$default(b2, "video", false, 2, (Object) null)) {
            z = true;
        }
        Uri uri = z ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str2);
        contentValues.put("relative_path", z ? Environment.DIRECTORY_MOVIES : Environment.DIRECTORY_PICTURES);
        if (!TextUtils.isEmpty(b2)) {
            contentValues.put("mime_type", b2);
        }
        Context context = this.b;
        if (context == null || (contentResolver = context.getContentResolver()) == null) {
            return null;
        }
        return contentResolver.insert(uri, contentValues);
    }

    public final String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return singleton.getMimeTypeFromExtension(lowerCase);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0067, code lost:
        r4 = null;
        r5 = null;
        r7 = r10;
        r10 = r9;
        r9 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b7, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00bc, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00ef, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00f4, code lost:
        r5.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047 A[Catch:{ IOException -> 0x004b, all -> 0x0047 }, ExcHandler: all (th java.lang.Throwable), Splitter:B:9:0x0021] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.HashMap c(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            if (r9 != 0) goto L_0x0010
            com.example.imagegallerysaver.SaveResultModel r8 = new com.example.imagegallerysaver.SaveResultModel
            java.lang.String r9 = "parameters error"
            r8.<init>(r0, r1, r9)
            java.util.HashMap r8 = r8.a()
            return r8
        L_0x0010:
            android.content.Context r2 = r8.b
            if (r2 != 0) goto L_0x0020
            com.example.imagegallerysaver.SaveResultModel r8 = new com.example.imagegallerysaver.SaveResultModel
            java.lang.String r9 = "applicationContext null"
            r8.<init>(r0, r1, r9)
            java.util.HashMap r8 = r8.a()
            return r8
        L_0x0020:
            r3 = 1
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            r4.<init>(r9)     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            boolean r5 = r4.exists()     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            if (r5 != 0) goto L_0x0051
            com.example.imagegallerysaver.SaveResultModel r10 = new com.example.imagegallerysaver.SaveResultModel     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            r4.<init>()     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            r4.append(r9)     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            java.lang.String r9 = " does not exist"
            r4.append(r9)     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            java.lang.String r9 = r4.toString()     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            r10.<init>(r0, r1, r9)     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            java.util.HashMap r8 = r10.a()     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            return r8
        L_0x0047:
            r8 = move-exception
            r5 = r1
            goto L_0x00ed
        L_0x004b:
            r9 = move-exception
            r10 = r1
            r4 = r10
            r5 = r4
            goto L_0x00a9
        L_0x0051:
            java.lang.String r9 = kotlin.io.FilesKt.getExtension(r4)     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            android.net.Uri r9 = r8.a(r9, r10)     // Catch:{ IOException -> 0x004b, all -> 0x0047 }
            if (r9 == 0) goto L_0x009b
            android.content.ContentResolver r10 = r2.getContentResolver()     // Catch:{ IOException -> 0x0066, all -> 0x0047 }
            if (r10 == 0) goto L_0x006d
            java.io.OutputStream r10 = r10.openOutputStream(r9)     // Catch:{ IOException -> 0x0066, all -> 0x0047 }
            goto L_0x006e
        L_0x0066:
            r10 = move-exception
            r4 = r1
            r5 = r4
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x00a9
        L_0x006d:
            r10 = r1
        L_0x006e:
            if (r10 == 0) goto L_0x0098
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0095, all -> 0x0092 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0095, all -> 0x0092 }
            r4 = 10240(0x2800, float:1.4349E-41)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0087, all -> 0x0083 }
        L_0x0079:
            int r6 = r5.read(r4)     // Catch:{ IOException -> 0x0087, all -> 0x0083 }
            if (r6 <= 0) goto L_0x008d
            r10.write(r4, r0, r6)     // Catch:{ IOException -> 0x0087, all -> 0x0083 }
            goto L_0x0079
        L_0x0083:
            r8 = move-exception
        L_0x0084:
            r1 = r10
            goto L_0x00ed
        L_0x0087:
            r4 = move-exception
        L_0x0088:
            r7 = r10
            r10 = r9
            r9 = r4
            r4 = r7
            goto L_0x00a9
        L_0x008d:
            r10.flush()     // Catch:{ IOException -> 0x0087, all -> 0x0083 }
            r4 = r3
            goto L_0x009e
        L_0x0092:
            r8 = move-exception
            r5 = r1
            goto L_0x0084
        L_0x0095:
            r4 = move-exception
            r5 = r1
            goto L_0x0088
        L_0x0098:
            r4 = r0
            r5 = r1
            goto L_0x009e
        L_0x009b:
            r4 = r0
            r10 = r1
            r5 = r10
        L_0x009e:
            if (r10 == 0) goto L_0x00a3
            r10.close()
        L_0x00a3:
            if (r5 == 0) goto L_0x00c1
            r5.close()
            goto L_0x00c1
        L_0x00a9:
            com.example.imagegallerysaver.SaveResultModel r6 = new com.example.imagegallerysaver.SaveResultModel     // Catch:{ all -> 0x00eb }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00eb }
            r6.<init>(r0, r1, r9)     // Catch:{ all -> 0x00eb }
            r6.a()     // Catch:{ all -> 0x00eb }
            if (r4 == 0) goto L_0x00ba
            r4.close()
        L_0x00ba:
            if (r5 == 0) goto L_0x00bf
            r5.close()
        L_0x00bf:
            r9 = r10
            r4 = r0
        L_0x00c1:
            if (r4 == 0) goto L_0x00df
            r8.e(r2, r9)
            com.example.imagegallerysaver.SaveResultModel r8 = new com.example.imagegallerysaver.SaveResultModel
            java.lang.String r10 = java.lang.String.valueOf(r9)
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x00d3
            r0 = r3
        L_0x00d3:
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r8.<init>(r0, r9, r1)
            java.util.HashMap r8 = r8.a()
            goto L_0x00ea
        L_0x00df:
            com.example.imagegallerysaver.SaveResultModel r8 = new com.example.imagegallerysaver.SaveResultModel
            java.lang.String r9 = "saveFileToGallery fail"
            r8.<init>(r0, r1, r9)
            java.util.HashMap r8 = r8.a()
        L_0x00ea:
            return r8
        L_0x00eb:
            r8 = move-exception
            r1 = r4
        L_0x00ed:
            if (r1 == 0) goto L_0x00f2
            r1.close()
        L_0x00f2:
            if (r5 == 0) goto L_0x00f7
            r5.close()
        L_0x00f7:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.imagegallerysaver.ImageGallerySaverPlugin.c(java.lang.String, java.lang.String):java.util.HashMap");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0077, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00aa, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0056 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.HashMap d(android.graphics.Bitmap r8, java.lang.Integer r9, java.lang.String r10) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            if (r8 == 0) goto L_0x00b1
            if (r9 != 0) goto L_0x0008
            goto L_0x00b1
        L_0x0008:
            android.content.Context r2 = r7.b
            if (r2 != 0) goto L_0x0018
            com.example.imagegallerysaver.SaveResultModel r7 = new com.example.imagegallerysaver.SaveResultModel
            java.lang.String r8 = "applicationContext null"
            r7.<init>(r0, r1, r8)
            java.util.HashMap r7 = r7.a()
            return r7
        L_0x0018:
            r3 = 1
            java.lang.String r4 = "jpg"
            android.net.Uri r10 = r7.a(r4, r10)     // Catch:{ IOException -> 0x0066, all -> 0x0056 }
            if (r10 == 0) goto L_0x005b
            android.content.ContentResolver r4 = r2.getContentResolver()     // Catch:{ IOException -> 0x0058, all -> 0x0056 }
            java.io.OutputStream r4 = r4.openOutputStream(r10)     // Catch:{ IOException -> 0x0058, all -> 0x0056 }
            if (r4 == 0) goto L_0x0054
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0052 }
            r5.<init>()     // Catch:{ IOException -> 0x0052 }
            java.lang.String r6 = "ImageGallerySaverPlugin "
            r5.append(r6)     // Catch:{ IOException -> 0x0052 }
            r5.append(r9)     // Catch:{ IOException -> 0x0052 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0052 }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ IOException -> 0x0052 }
            r6.println(r5)     // Catch:{ IOException -> 0x0052 }
            android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x0052 }
            int r9 = r9.intValue()     // Catch:{ IOException -> 0x0052 }
            r8.compress(r5, r9, r4)     // Catch:{ IOException -> 0x0052 }
            r4.flush()     // Catch:{ IOException -> 0x0052 }
            r9 = r3
            goto L_0x005d
        L_0x004f:
            r7 = move-exception
            r1 = r4
            goto L_0x00a8
        L_0x0052:
            r9 = move-exception
            goto L_0x0069
        L_0x0054:
            r9 = r0
            goto L_0x005d
        L_0x0056:
            r7 = move-exception
            goto L_0x00a8
        L_0x0058:
            r9 = move-exception
            r4 = r1
            goto L_0x0069
        L_0x005b:
            r9 = r0
            r4 = r1
        L_0x005d:
            if (r4 == 0) goto L_0x0062
            r4.close()
        L_0x0062:
            r8.recycle()
            goto L_0x007e
        L_0x0066:
            r9 = move-exception
            r10 = r1
            r4 = r10
        L_0x0069:
            com.example.imagegallerysaver.SaveResultModel r5 = new com.example.imagegallerysaver.SaveResultModel     // Catch:{ all -> 0x004f }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x004f }
            r5.<init>(r0, r1, r9)     // Catch:{ all -> 0x004f }
            r5.a()     // Catch:{ all -> 0x004f }
            if (r4 == 0) goto L_0x007a
            r4.close()
        L_0x007a:
            r8.recycle()
            r9 = r0
        L_0x007e:
            if (r9 == 0) goto L_0x009c
            r7.e(r2, r10)
            com.example.imagegallerysaver.SaveResultModel r7 = new com.example.imagegallerysaver.SaveResultModel
            java.lang.String r8 = java.lang.String.valueOf(r10)
            int r8 = r8.length()
            if (r8 <= 0) goto L_0x0090
            r0 = r3
        L_0x0090:
            java.lang.String r8 = java.lang.String.valueOf(r10)
            r7.<init>(r0, r8, r1)
            java.util.HashMap r7 = r7.a()
            goto L_0x00a7
        L_0x009c:
            com.example.imagegallerysaver.SaveResultModel r7 = new com.example.imagegallerysaver.SaveResultModel
            java.lang.String r8 = "saveImageToGallery fail"
            r7.<init>(r0, r1, r8)
            java.util.HashMap r7 = r7.a()
        L_0x00a7:
            return r7
        L_0x00a8:
            if (r1 == 0) goto L_0x00ad
            r1.close()
        L_0x00ad:
            r8.recycle()
            throw r7
        L_0x00b1:
            com.example.imagegallerysaver.SaveResultModel r7 = new com.example.imagegallerysaver.SaveResultModel
            java.lang.String r8 = "parameters error"
            r7.<init>(r0, r1, r8)
            java.util.HashMap r7 = r7.a()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.imagegallerysaver.ImageGallerySaverPlugin.d(android.graphics.Bitmap, java.lang.Integer, java.lang.String):java.util.HashMap");
    }

    public final void e(Context context, Uri uri) {
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        this.b = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "image_gallery_saver");
        this.f2826a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        this.b = null;
        MethodChannel methodChannel = this.f2826a;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("methodChannel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (Intrinsics.areEqual((Object) str, (Object) "saveImageToGallery")) {
            byte[] bArr = (byte[]) methodCall.argument("imageBytes");
            result.success(d(BitmapFactory.decodeByteArray(bArr == null ? new byte[0] : bArr, 0, bArr != null ? bArr.length : 0), (Integer) methodCall.argument("quality"), (String) methodCall.argument("name")));
        } else if (Intrinsics.areEqual((Object) str, (Object) "saveFileToGallery")) {
            result.success(c((String) methodCall.argument("file"), (String) methodCall.argument("name")));
        } else {
            result.notImplemented();
        }
    }
}
