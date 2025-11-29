package com.upuphone.ar.transcribe.ext;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import com.ucar.databus.proto.UCarProto;
import com.upuphone.ar.transcribe.utils.GsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\u000f\u001a\u00020\u000e*\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0019\u0010\u0012\u001a\u00020\u000e*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a#\u0010\u0016\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a1\u0010\u001b\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u001b\u0010\u001c\u001a1\u0010\u001e\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u001d2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u001e\u0010\u001f\u001a!\u0010!\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007¢\u0006\u0004\b!\u0010\"\u001a#\u0010#\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b#\u0010\u0017\u001a%\u0010'\u001a\u00028\u0000\"\u0004\b\u0000\u0010$*\u00028\u00002\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"Landroid/content/Context;", "", "d", "(Landroid/content/Context;)Z", "Landroid/view/LayoutInflater;", "a", "(Landroid/content/Context;)Landroid/view/LayoutInflater;", "", "content", "title", "", "h", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/view/View;", "Landroid/graphics/Bitmap;", "m", "(Landroid/view/View;)Landroid/graphics/Bitmap;", "context", "b", "(Landroid/view/View;Landroid/content/Context;)Landroid/graphics/Bitmap;", "Landroid/net/Uri;", "uri", "f", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;)V", "view", "header", "markBitmap", "n", "(Landroid/content/Context;Landroid/view/View;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/net/Uri;", "Landroidx/recyclerview/widget/RecyclerView;", "e", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/net/Uri;", "fileName", "l", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;", "j", "T", "Ljava/lang/Class;", "clazz", "c", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "ar-transcribe_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class ContextExtKt {
    public static final LayoutInflater a(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Configuration configuration = context.getResources().getConfiguration();
        configuration.fontScale = 1.0f;
        LayoutInflater from = LayoutInflater.from(context.createConfigurationContext(configuration));
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        return from;
    }

    public static final Bitmap b(View view, Context context) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        view.layout(0, 0, i, i2);
        LogExt.g("backViewToBitmap screenWidth=" + i + ", screenHeight=" + i2, "ContextExt");
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        int width = view.getWidth();
        int height = view.getHeight();
        LogExt.g("backViewToBitmap viewWidth=" + width + ", viewHeight=" + height, "ContextExt");
        return m(view);
    }

    public static final Object c(Object obj, Class cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return GsonUtils.a(GsonUtils.d(obj), cls);
    }

    public static final boolean d(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.net.Uri e(android.content.Context r10, androidx.recyclerview.widget.RecyclerView r11, android.graphics.Bitmap r12, android.graphics.Bitmap r13) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            int r0 = r11.getWidth()
            int r1 = r11.computeVerticalScrollRange()
            r2 = 0
            if (r13 == 0) goto L_0x001b
            int r3 = r13.getHeight()
            goto L_0x001c
        L_0x001b:
            r3 = r2
        L_0x001c:
            if (r12 == 0) goto L_0x0022
            int r2 = r12.getHeight()
        L_0x0022:
            android.content.res.Resources r4 = r10.getResources()
            int r5 = com.upuphone.ar.transcribe.R.dimen.record_share_image_top
            int r4 = r4.getDimensionPixelSize(r5)
            android.content.res.Resources r5 = r10.getResources()
            int r6 = com.upuphone.ar.transcribe.R.dimen.share_mark_divide
            int r5 = r5.getDimensionPixelSize(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "longViewToUri width="
            r6.append(r7)
            r6.append(r0)
            java.lang.String r7 = ", height="
            r6.append(r7)
            r6.append(r1)
            java.lang.String r7 = ", markHeight="
            r6.append(r7)
            r6.append(r3)
            java.lang.String r7 = ", top="
            r6.append(r7)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "ContextExt"
            com.upuphone.ar.transcribe.ext.LogExt.g(r6, r7)
            int r6 = r2 + r4
            int r6 = r6 + r1
            int r1 = r5 * 2
            int r6 = r6 + r1
            int r3 = r3 + r6
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r3, r1)
            java.lang.String r1 = "createBitmap(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.graphics.Canvas r1 = new android.graphics.Canvas
            r1.<init>(r0)
            int r3 = com.upuphone.ar.transcribe.R.color.color_page_bg_record_detail
            int r3 = r10.getColor(r3)
            r1.drawColor(r3)
            r3 = 0
            r8 = 0
            if (r12 == 0) goto L_0x008c
            float r9 = (float) r5
            r1.drawBitmap(r12, r8, r9, r3)
        L_0x008c:
            if (r13 == 0) goto L_0x0092
            float r12 = (float) r6
            r1.drawBitmap(r13, r8, r12, r3)
        L_0x0092:
            float r12 = (float) r4
            float r13 = (float) r2
            float r12 = r12 + r13
            float r13 = (float) r5
            float r12 = r12 + r13
            r1.translate(r8, r12)
            r11.draw(r1)
            java.io.File r11 = new java.io.File
            java.io.File r12 = r10.getCacheDir()
            java.lang.String r13 = "transcribeShare"
            r11.<init>(r12, r13)
            boolean r12 = r11.exists()
            if (r12 == 0) goto L_0x00b4
            com.upuphone.ar.transcribe.utils.FileUtils r12 = com.upuphone.ar.transcribe.utils.FileUtils.f6184a
            r12.a(r11)
        L_0x00b4:
            r11.mkdirs()
            java.io.File r12 = new java.io.File
            long r1 = android.os.SystemClock.elapsedRealtime()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r4 = "myvu_transcribe_share_"
            r13.append(r4)
            r13.append(r1)
            java.lang.String r1 = ".jpeg"
            r13.append(r1)
            java.lang.String r13 = r13.toString()
            r12.<init>(r11, r13)
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00f1 }
            r11.<init>(r12)     // Catch:{ Exception -> 0x00f1 }
            android.graphics.Bitmap$CompressFormat r13 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00ec, all -> 0x00e9 }
            r1 = 60
            r0.compress(r13, r1, r11)     // Catch:{ Exception -> 0x00ec, all -> 0x00e9 }
            r11.flush()     // Catch:{ Exception -> 0x00ec, all -> 0x00e9 }
            r11.close()
            goto L_0x010f
        L_0x00e9:
            r10 = move-exception
            r3 = r11
            goto L_0x011b
        L_0x00ec:
            r13 = move-exception
            r3 = r11
            goto L_0x00f2
        L_0x00ef:
            r10 = move-exception
            goto L_0x011b
        L_0x00f1:
            r13 = move-exception
        L_0x00f2:
            java.lang.String r11 = kotlin.ExceptionsKt.stackTraceToString(r13)     // Catch:{ all -> 0x00ef }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ef }
            r13.<init>()     // Catch:{ all -> 0x00ef }
            java.lang.String r0 = "longViewToUri error="
            r13.append(r0)     // Catch:{ all -> 0x00ef }
            r13.append(r11)     // Catch:{ all -> 0x00ef }
            java.lang.String r11 = r13.toString()     // Catch:{ all -> 0x00ef }
            com.upuphone.ar.transcribe.ext.LogExt.g(r11, r7)     // Catch:{ all -> 0x00ef }
            if (r3 == 0) goto L_0x010f
            r3.close()
        L_0x010f:
            java.lang.String r11 = "com.upuphone.ar.transcribe.fileprovider"
            android.net.Uri r10 = androidx.core.content.FileProvider.getUriForFile(r10, r11, r12)
            java.lang.String r11 = "getUriForFile(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            return r10
        L_0x011b:
            if (r3 == 0) goto L_0x0120
            r3.close()
        L_0x0120:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.ext.ContextExtKt.e(android.content.Context, androidx.recyclerview.widget.RecyclerView, android.graphics.Bitmap, android.graphics.Bitmap):android.net.Uri");
    }

    public static final void f(Context context, Uri uri, String str) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(str, "title");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setType("image/*");
        intent.addFlags(1);
        context.startActivity(Intent.createChooser(intent, str));
    }

    public static /* synthetic */ void g(Context context, Uri uri, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        f(context, uri, str);
    }

    public static final void h(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "title");
        if (str.length() > 8000) {
            str = str.substring(0, UCarProto.SampleRate.SAMPLE_RATE_8000_VALUE);
            Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/plain");
        context.startActivity(Intent.createChooser(intent, str2));
    }

    public static /* synthetic */ void i(Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        h(context, str, str2);
    }

    public static final void j(Context context, Uri uri, String str) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(str, "title");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setType("text/plain");
        intent.addFlags(1);
        context.startActivity(Intent.createChooser(intent, str));
    }

    public static /* synthetic */ void k(Context context, Uri uri, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        j(context, uri, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0077, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0078, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007b, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.net.Uri l(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "fileName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.io.File r0 = new java.io.File
            java.io.File r1 = r3.getCacheDir()
            java.lang.String r2 = "transcribeShare"
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x0026
            com.upuphone.ar.transcribe.utils.FileUtils r1 = com.upuphone.ar.transcribe.utils.FileUtils.f6184a
            r1.a(r0)
        L_0x0026:
            r0.mkdirs()
            java.io.File r1 = new java.io.File
            r1.<init>(r0, r5)
            int r5 = com.upuphone.ar.transcribe.R.string.tl_intel_extn_content_reminder
            java.lang.String r5 = r3.getString(r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "/*"
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = "*/\n"
            r0.append(r5)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.io.FileOutputStream r5 = new java.io.FileOutputStream
            r5.<init>(r1)
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x0075 }
            byte[] r4 = r4.getBytes(r0)     // Catch:{ all -> 0x0075 }
            java.lang.String r0 = "getBytes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)     // Catch:{ all -> 0x0075 }
            r5.write(r4)     // Catch:{ all -> 0x0075 }
            r5.flush()     // Catch:{ all -> 0x0075 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0075 }
            r4 = 0
            kotlin.io.CloseableKt.closeFinally(r5, r4)
            java.lang.String r4 = "com.upuphone.ar.transcribe.fileprovider"
            android.net.Uri r3 = androidx.core.content.FileProvider.getUriForFile(r3, r4, r1)
            java.lang.String r4 = "getUriForFile(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            return r3
        L_0x0075:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0077 }
        L_0x0077:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.ext.ContextExtKt.l(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }

    public static final Bitmap m(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int width = view.getWidth();
        int height = view.getHeight();
        LogExt.g("viewToBitmap width=" + width + ", height=" + height, "ContextExt");
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.net.Uri n(android.content.Context r10, android.view.View r11, android.graphics.Bitmap r12, android.graphics.Bitmap r13) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            int r0 = r11.getWidth()
            int r1 = r11.getHeight()
            r2 = 0
            if (r13 == 0) goto L_0x001b
            int r3 = r13.getHeight()
            goto L_0x001c
        L_0x001b:
            r3 = r2
        L_0x001c:
            if (r12 == 0) goto L_0x0022
            int r2 = r12.getHeight()
        L_0x0022:
            android.content.res.Resources r4 = r10.getResources()
            int r5 = com.upuphone.ar.transcribe.R.dimen.record_share_image_top
            int r4 = r4.getDimensionPixelSize(r5)
            android.content.res.Resources r5 = r10.getResources()
            int r6 = com.upuphone.ar.transcribe.R.dimen.share_mark_divide
            int r5 = r5.getDimensionPixelSize(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "viewToUri width="
            r6.append(r7)
            r6.append(r0)
            java.lang.String r7 = ", height="
            r6.append(r7)
            r6.append(r1)
            java.lang.String r7 = ", markHeight="
            r6.append(r7)
            r6.append(r3)
            java.lang.String r7 = ", top="
            r6.append(r7)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "ContextExt"
            com.upuphone.ar.transcribe.ext.LogExt.g(r6, r7)
            int r6 = r2 + r4
            int r6 = r6 + r1
            int r1 = r5 * 2
            int r6 = r6 + r1
            int r3 = r3 + r6
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r3, r1)
            java.lang.String r1 = "createBitmap(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.graphics.Canvas r1 = new android.graphics.Canvas
            r1.<init>(r0)
            int r3 = com.upuphone.ar.transcribe.R.color.color_page_bg_record_detail
            int r3 = r10.getColor(r3)
            r1.drawColor(r3)
            r3 = 0
            r8 = 0
            if (r12 == 0) goto L_0x008d
            float r9 = (float) r5
            r1.drawBitmap(r12, r8, r9, r3)
        L_0x008d:
            if (r13 == 0) goto L_0x0093
            float r12 = (float) r6
            r1.drawBitmap(r13, r8, r12, r3)
        L_0x0093:
            float r12 = (float) r4
            float r13 = (float) r2
            float r12 = r12 + r13
            float r13 = (float) r5
            float r12 = r12 + r13
            r1.translate(r8, r12)
            r11.draw(r1)
            java.io.File r11 = new java.io.File
            java.io.File r12 = r10.getCacheDir()
            java.lang.String r13 = "transcribeShare"
            r11.<init>(r12, r13)
            boolean r12 = r11.exists()
            if (r12 == 0) goto L_0x00b5
            com.upuphone.ar.transcribe.utils.FileUtils r12 = com.upuphone.ar.transcribe.utils.FileUtils.f6184a
            r12.a(r11)
        L_0x00b5:
            r11.mkdirs()
            java.io.File r12 = new java.io.File
            long r1 = android.os.SystemClock.elapsedRealtime()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r4 = "myvu_translator_share_"
            r13.append(r4)
            r13.append(r1)
            java.lang.String r1 = ".png"
            r13.append(r1)
            java.lang.String r13 = r13.toString()
            r12.<init>(r11, r13)
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00f2 }
            r11.<init>(r12)     // Catch:{ Exception -> 0x00f2 }
            android.graphics.Bitmap$CompressFormat r13 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x00ed, all -> 0x00ea }
            r1 = 60
            r0.compress(r13, r1, r11)     // Catch:{ Exception -> 0x00ed, all -> 0x00ea }
            r11.flush()     // Catch:{ Exception -> 0x00ed, all -> 0x00ea }
            r11.close()
            goto L_0x0111
        L_0x00ea:
            r10 = move-exception
            r3 = r11
            goto L_0x011d
        L_0x00ed:
            r13 = move-exception
            r3 = r11
            goto L_0x00f3
        L_0x00f0:
            r10 = move-exception
            goto L_0x011d
        L_0x00f2:
            r13 = move-exception
        L_0x00f3:
            java.lang.String r11 = kotlin.ExceptionsKt.stackTraceToString(r13)     // Catch:{ all -> 0x00f0 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f0 }
            r13.<init>()     // Catch:{ all -> 0x00f0 }
            java.lang.String r0 = "viewToUri error="
            r13.append(r0)     // Catch:{ all -> 0x00f0 }
            r13.append(r11)     // Catch:{ all -> 0x00f0 }
            java.lang.String r11 = r13.toString()     // Catch:{ all -> 0x00f0 }
            com.upuphone.ar.transcribe.ext.LogExt.g(r11, r7)     // Catch:{ all -> 0x00f0 }
            if (r3 == 0) goto L_0x0111
            r3.close()
        L_0x0111:
            java.lang.String r11 = "com.upuphone.ar.transcribe.fileprovider"
            android.net.Uri r10 = androidx.core.content.FileProvider.getUriForFile(r10, r11, r12)
            java.lang.String r11 = "getUriForFile(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            return r10
        L_0x011d:
            if (r3 == 0) goto L_0x0122
            r3.close()
        L_0x0122:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.ext.ContextExtKt.n(android.content.Context, android.view.View, android.graphics.Bitmap, android.graphics.Bitmap):android.net.Uri");
    }
}
