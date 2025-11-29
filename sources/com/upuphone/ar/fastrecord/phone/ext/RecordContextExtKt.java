package com.upuphone.ar.fastrecord.phone.ext;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils;
import com.upuphone.ar.fastrecord.phone.utils.RecordZipUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\u0012\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\b\u001a\f\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\b\u001a\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0001\u001a\n\u0010\u0013\u001a\u00020\u0014*\u00020\b\u001a\u001a\u0010\u0015\u001a\u00020\u0010*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019\u001a\u001c\u0010\u001a\u001a\u00020\u0010*\u00020\b2\u0006\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u0001\u001a\u001c\u0010\u001a\u001a\u00020\u0010*\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0001\u001a\u001c\u0010\u001c\u001a\u00020\u0010*\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u0001\u001a\n\u0010\u001e\u001a\u00020\n*\u00020\u000b\u001a\u001e\u0010\u001f\u001a\u00020\u000e*\u00020\b2\u0006\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n\u001a\u001e\u0010\u001f\u001a\u00020\u000e*\u00020\b2\u0006\u0010 \u001a\u00020\"2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"INTL_LANG_SPLIT_MARK", "", "TAG", "srcToDstHint", "srcLang", "dstLang", "appLayoutInflater", "Landroid/view/LayoutInflater;", "Landroid/content/Context;", "backViewToBitmap", "Landroid/graphics/Bitmap;", "Landroid/view/View;", "context", "fastRecordAudioGzipToUri", "Landroid/net/Uri;", "fastRecordShareGzip", "", "uri", "title", "isDarkMode", "", "postDelay", "runnable", "Ljava/lang/Runnable;", "delay", "", "shareImage", "bitmap", "shareText", "content", "viewToBitmap", "viewToUri", "view", "markBitmap", "Landroidx/recyclerview/widget/RecyclerView;", "ar-fastrecord_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RecordContextExtKt {
    @NotNull
    private static final String INTL_LANG_SPLIT_MARK = "&&";
    @NotNull
    private static final String TAG = "ShortHandContextExt";

    @NotNull
    public static final LayoutInflater appLayoutInflater(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        LayoutInflater from = LayoutInflater.from(context.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        return from;
    }

    @NotNull
    public static final Bitmap backViewToBitmap(@NotNull View view, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        view.layout(0, 0, i, i2);
        LogExt.logE("backViewToBitmap screenWidth=" + i + ", screenHeight=" + i2, TAG);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        int width = view.getWidth();
        int height = view.getHeight();
        LogExt.logE("backViewToBitmap viewWidth=" + width + ", viewHeight=" + height, TAG);
        return viewToBitmap(view);
    }

    @Nullable
    public static final Uri fastRecordAudioGzipToUri(@NotNull Context context) throws Exception {
        Intrinsics.checkNotNullParameter(context, "<this>");
        File file = new File(context.getFilesDir(), "transDebugAudio.zip");
        if (file.exists()) {
            RecordFileUtils.INSTANCE.delete(file);
        }
        RecordZipUtils.zipFile(new File(context.getFilesDir(), "audio"), file);
        return FileProvider.getUriForFile(context, "com.upuphone.ar.shorthand.phone.fileprovider", file);
    }

    public static final void fastRecordShareGzip(@NotNull Context context, @NotNull Uri uri, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(str, "title");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setType("application/zip");
        intent.addFlags(1);
        context.startActivity(Intent.createChooser(intent, str));
    }

    public static /* synthetic */ void fastRecordShareGzip$default(Context context, Uri uri, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        fastRecordShareGzip(context, uri, str);
    }

    public static final boolean isDarkMode(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static final void postDelay(@NotNull Context context, @NotNull Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        new Handler(context.getMainLooper()).postDelayed(runnable, j);
    }

    public static final void shareImage(@NotNull Context context, @NotNull Bitmap bitmap, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(str, "title");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, "图片标题", "图片表述")));
        intent.setType("image/*");
        context.startActivity(Intent.createChooser(intent, str));
    }

    public static /* synthetic */ void shareImage$default(Context context, Bitmap bitmap, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        shareImage(context, bitmap, str);
    }

    public static final void shareText(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/plain");
        context.startActivity(Intent.createChooser(intent, str2));
    }

    public static /* synthetic */ void shareText$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        shareText(context, str, str2);
    }

    private static final String srcToDstHint(String str, String str2) {
        return str + INTL_LANG_SPLIT_MARK + str2;
    }

    @NotNull
    public static final Bitmap viewToBitmap(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int width = view.getWidth();
        int height = view.getHeight();
        LogExt.logE("viewToBitmap width=" + width + ", height=" + height, TAG);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ff  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.net.Uri viewToUri(@org.jetbrains.annotations.NotNull android.content.Context r7, @org.jetbrains.annotations.NotNull android.view.View r8, @org.jetbrains.annotations.Nullable android.graphics.Bitmap r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            int r0 = r8.getWidth()
            int r1 = r8.getHeight()
            if (r9 == 0) goto L_0x001a
            int r2 = r9.getHeight()
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            android.content.res.Resources r3 = r7.getResources()
            int r4 = com.upuphone.ar.fastrecord.R.dimen.record_share_image_top
            int r3 = r3.getDimensionPixelSize(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "viewToUri width="
            r4.append(r5)
            r4.append(r0)
            java.lang.String r5 = ", height="
            r4.append(r5)
            r4.append(r1)
            java.lang.String r5 = ", markHeight="
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = ", top="
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "ShortHandContextExt"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r4, r5)
            int r1 = r1 + r3
            int r2 = r2 + r1
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r2, r4)
            java.lang.String r2 = "createBitmap(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            android.graphics.Canvas r2 = new android.graphics.Canvas
            r2.<init>(r0)
            int r4 = com.upuphone.ar.fastrecord.R.color.fast_record_color_page_uniform_bg
            int r4 = r7.getColor(r4)
            r2.drawColor(r4)
            r4 = 0
            r6 = 0
            if (r9 == 0) goto L_0x0077
            float r1 = (float) r1
            r2.drawBitmap(r9, r6, r1, r4)
        L_0x0077:
            float r9 = (float) r3
            r2.translate(r6, r9)
            r8.draw(r2)
            java.io.File r8 = new java.io.File
            java.io.File r9 = r7.getCacheDir()
            java.lang.String r1 = "translatorShare"
            r8.<init>(r9, r1)
            boolean r9 = r8.exists()
            if (r9 == 0) goto L_0x0095
            com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils r9 = com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils.INSTANCE
            r9.delete((java.io.File) r8)
        L_0x0095:
            r8.mkdirs()
            java.io.File r9 = new java.io.File
            long r1 = android.os.SystemClock.elapsedRealtime()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "myvu_translator_share_"
            r3.append(r6)
            r3.append(r1)
            java.lang.String r1 = ".png"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r9.<init>(r8, r1)
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00d2 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00d2 }
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x00cd, all -> 0x00ca }
            r2 = 100
            r0.compress(r1, r2, r8)     // Catch:{ Exception -> 0x00cd, all -> 0x00ca }
            r8.flush()     // Catch:{ Exception -> 0x00cd, all -> 0x00ca }
            r8.close()
            goto L_0x00f1
        L_0x00ca:
            r7 = move-exception
            r4 = r8
            goto L_0x00fd
        L_0x00cd:
            r0 = move-exception
            r4 = r8
            goto L_0x00d3
        L_0x00d0:
            r7 = move-exception
            goto L_0x00fd
        L_0x00d2:
            r0 = move-exception
        L_0x00d3:
            java.lang.String r8 = kotlin.ExceptionsKt.stackTraceToString(r0)     // Catch:{ all -> 0x00d0 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
            r0.<init>()     // Catch:{ all -> 0x00d0 }
            java.lang.String r1 = "viewToUri error="
            r0.append(r1)     // Catch:{ all -> 0x00d0 }
            r0.append(r8)     // Catch:{ all -> 0x00d0 }
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x00d0 }
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r8, r5)     // Catch:{ all -> 0x00d0 }
            if (r4 == 0) goto L_0x00f1
            r4.close()
        L_0x00f1:
            java.lang.String r8 = "com.upuphone.ar.shorthand.phone.fileprovider"
            android.net.Uri r7 = androidx.core.content.FileProvider.getUriForFile(r7, r8, r9)
            java.lang.String r8 = "getUriForFile(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            return r7
        L_0x00fd:
            if (r4 == 0) goto L_0x0102
            r4.close()
        L_0x0102:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ext.RecordContextExtKt.viewToUri(android.content.Context, android.view.View, android.graphics.Bitmap):android.net.Uri");
    }

    public static /* synthetic */ Uri viewToUri$default(Context context, View view, Bitmap bitmap, int i, Object obj) {
        if ((i & 2) != 0) {
            bitmap = null;
        }
        return viewToUri(context, view, bitmap);
    }

    public static /* synthetic */ void shareImage$default(Context context, Uri uri, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        shareImage(context, uri, str);
    }

    public static /* synthetic */ Uri viewToUri$default(Context context, RecyclerView recyclerView, Bitmap bitmap, int i, Object obj) {
        if ((i & 2) != 0) {
            bitmap = null;
        }
        return viewToUri(context, recyclerView, bitmap);
    }

    public static final void shareImage(@NotNull Context context, @NotNull Uri uri, @NotNull String str) {
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

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00fe  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.net.Uri viewToUri(@org.jetbrains.annotations.NotNull android.content.Context r7, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView r8, @org.jetbrains.annotations.Nullable android.graphics.Bitmap r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            int r0 = r8.getWidth()
            int r1 = r8.computeVerticalScrollRange()
            if (r9 == 0) goto L_0x001a
            int r2 = r9.getHeight()
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            android.content.res.Resources r3 = r7.getResources()
            int r4 = com.upuphone.ar.fastrecord.R.dimen.record_share_image_top
            int r3 = r3.getDimensionPixelSize(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "viewToUri width="
            r4.append(r5)
            r4.append(r0)
            java.lang.String r5 = ", height="
            r4.append(r5)
            r4.append(r1)
            java.lang.String r5 = ", markHeight="
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = ", top="
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "ShortHandContextExt"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r4, r5)
            int r1 = r1 + r3
            int r2 = r2 + r1
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r2, r4)
            java.lang.String r2 = "createBitmap(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            android.graphics.Canvas r2 = new android.graphics.Canvas
            r2.<init>(r0)
            int r4 = com.upuphone.ar.fastrecord.R.color.fast_record_color_page_uniform_bg
            int r4 = r7.getColor(r4)
            r2.drawColor(r4)
            r4 = 0
            r6 = 0
            if (r9 == 0) goto L_0x0077
            float r1 = (float) r1
            r2.drawBitmap(r9, r6, r1, r4)
        L_0x0077:
            float r9 = (float) r3
            r2.translate(r6, r9)
            r8.draw(r2)
            java.io.File r8 = new java.io.File
            java.io.File r9 = r7.getCacheDir()
            java.lang.String r1 = "shortHandShare"
            r8.<init>(r9, r1)
            boolean r9 = r8.exists()
            if (r9 == 0) goto L_0x0094
            com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils r9 = com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils.INSTANCE
            r9.delete((java.io.File) r8)
        L_0x0094:
            r8.mkdirs()
            java.io.File r9 = new java.io.File
            long r1 = android.os.SystemClock.elapsedRealtime()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "myvu_shortHand_share_"
            r3.append(r6)
            r3.append(r1)
            java.lang.String r1 = ".png"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r9.<init>(r8, r1)
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00d1 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00d1 }
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x00cc, all -> 0x00c9 }
            r2 = 100
            r0.compress(r1, r2, r8)     // Catch:{ Exception -> 0x00cc, all -> 0x00c9 }
            r8.flush()     // Catch:{ Exception -> 0x00cc, all -> 0x00c9 }
            r8.close()
            goto L_0x00f0
        L_0x00c9:
            r7 = move-exception
            r4 = r8
            goto L_0x00fc
        L_0x00cc:
            r0 = move-exception
            r4 = r8
            goto L_0x00d2
        L_0x00cf:
            r7 = move-exception
            goto L_0x00fc
        L_0x00d1:
            r0 = move-exception
        L_0x00d2:
            java.lang.String r8 = kotlin.ExceptionsKt.stackTraceToString(r0)     // Catch:{ all -> 0x00cf }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r0.<init>()     // Catch:{ all -> 0x00cf }
            java.lang.String r1 = "viewToUri error="
            r0.append(r1)     // Catch:{ all -> 0x00cf }
            r0.append(r8)     // Catch:{ all -> 0x00cf }
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x00cf }
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r8, r5)     // Catch:{ all -> 0x00cf }
            if (r4 == 0) goto L_0x00f0
            r4.close()
        L_0x00f0:
            java.lang.String r8 = "com.upuphone.ar.shorthand.phone.fileprovider"
            android.net.Uri r7 = androidx.core.content.FileProvider.getUriForFile(r7, r8, r9)
            java.lang.String r8 = "getUriForFile(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            return r7
        L_0x00fc:
            if (r4 == 0) goto L_0x0101
            r4.close()
        L_0x0101:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ext.RecordContextExtKt.viewToUri(android.content.Context, androidx.recyclerview.widget.RecyclerView, android.graphics.Bitmap):android.net.Uri");
    }
}
