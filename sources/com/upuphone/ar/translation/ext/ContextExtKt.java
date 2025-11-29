package com.upuphone.ar.translation.ext;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.content.FileProvider;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.utils.FileUtils;
import com.upuphone.ar.translation.utils.LanguageUtils;
import com.upuphone.ar.translation.utils.ZipUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0019\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a#\u0010\f\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u000e\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\r\u001a\u001f\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000f*\u00020\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001f\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0013\u0010\u0016\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0013\u0010\u0018\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\u0018\u0010\u0017\u001a\u0013\u0010\u0019\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\u0019\u0010\u0017\u001a\u0013\u0010\u001a\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\u001a\u0010\u0017\u001a\u0013\u0010\u001b\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\u001b\u0010\u0017\u001a\u0013\u0010\u001c\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\u001c\u0010\u0017\u001a\u0013\u0010\u001d\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\u001d\u0010\u0017\u001a\u0013\u0010\u001e\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\u001e\u0010\u0017\u001a\u0013\u0010\u001f\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\u001f\u0010\u0017\u001a\u0013\u0010 \u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b \u0010\u0017\u001a\u0013\u0010!\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b!\u0010\u0017\u001a\u0013\u0010\"\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\"\u0010\u0017\u001a\u0013\u0010#\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b#\u0010\u0017\u001a\u0013\u0010$\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b$\u0010\u0017\u001a\u0013\u0010%\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b%\u0010\u0017\u001a#\u0010&\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b&\u0010\r\u001a\u001b\u0010'\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b'\u0010(\u001a\u001f\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000f*\u00020\u0000H\u0002¢\u0006\u0004\b)\u0010\u0011\u001a\u001b\u0010*\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b*\u0010(\u001a\u001f\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000f*\u00020\u0000H\u0002¢\u0006\u0004\b+\u0010\u0011\u001a\u0011\u0010,\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0004\b,\u0010\u0017\u001a\u001f\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000f*\u00020\u0000H\u0002¢\u0006\u0004\b-\u0010\u0011\u001a#\u00101\u001a\u000200*\u00020\u00002\u0006\u0010.\u001a\u00020\u00072\b\b\u0002\u0010/\u001a\u00020\u0007¢\u0006\u0004\b1\u00102\u001a\u0011\u00105\u001a\u000204*\u000203¢\u0006\u0004\b5\u00106\u001a\u0019\u00108\u001a\u000204*\u0002032\u0006\u00107\u001a\u00020\u0000¢\u0006\u0004\b8\u00109\u001a#\u0010<\u001a\u000200*\u00020\u00002\u0006\u0010;\u001a\u00020:2\b\b\u0002\u0010/\u001a\u00020\u0007¢\u0006\u0004\b<\u0010=\u001a%\u0010@\u001a\u00020:*\u00020\u00002\u0006\u0010>\u001a\u0002032\n\b\u0002\u0010?\u001a\u0004\u0018\u000104¢\u0006\u0004\b@\u0010A\u001a%\u0010C\u001a\u00020:*\u00020\u00002\u0006\u0010>\u001a\u00020B2\n\b\u0002\u0010?\u001a\u0004\u0018\u000104¢\u0006\u0004\bC\u0010D\u001a#\u0010E\u001a\u000200*\u00020\u00002\u0006\u0010;\u001a\u00020:2\b\b\u0002\u0010/\u001a\u00020\u0007¢\u0006\u0004\bE\u0010=\u001a\u0013\u0010F\u001a\u0004\u0018\u00010:*\u00020\u0000¢\u0006\u0004\bF\u0010G\u001a#\u0010H\u001a\u000200*\u00020\u00002\u0006\u0010;\u001a\u00020:2\b\b\u0002\u0010/\u001a\u00020\u0007¢\u0006\u0004\bH\u0010=\u001a!\u0010J\u001a\u00020:*\u00020\u00002\u0006\u0010.\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0007¢\u0006\u0004\bJ\u0010K¨\u0006L"}, d2 = {"Landroid/content/Context;", "", "e", "(Landroid/content/Context;)Z", "f", "", "type", "", "L", "(Landroid/content/Context;I)Ljava/lang/String;", "src", "dst", "M", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "c", "", "d", "(Landroid/content/Context;)Ljava/util/Map;", "srcLang", "dstLang", "H", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "h", "(Landroid/content/Context;)Ljava/lang/String;", "j", "o", "p", "r", "l", "k", "u", "q", "s", "m", "n", "i", "g", "t", "y", "z", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "w", "x", "v", "J", "K", "content", "title", "", "E", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/view/View;", "Landroid/graphics/Bitmap;", "N", "(Landroid/view/View;)Landroid/graphics/Bitmap;", "context", "b", "(Landroid/view/View;Landroid/content/Context;)Landroid/graphics/Bitmap;", "Landroid/net/Uri;", "uri", "C", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;)V", "view", "markBitmap", "O", "(Landroid/content/Context;Landroid/view/View;Landroid/graphics/Bitmap;)Landroid/net/Uri;", "Landroidx/recyclerview/widget/RecyclerView;", "P", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;Landroid/graphics/Bitmap;)Landroid/net/Uri;", "A", "a", "(Landroid/content/Context;)Landroid/net/Uri;", "F", "fileName", "I", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;", "ar-translator_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class ContextExtKt {
    public static final void A(Context context, Uri uri, String str) {
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

    public static /* synthetic */ void B(Context context, Uri uri, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        A(context, uri, str);
    }

    public static final void C(Context context, Uri uri, String str) {
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

    public static /* synthetic */ void D(Context context, Uri uri, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        C(context, uri, str);
    }

    public static final void E(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/plain");
        context.startActivity(Intent.createChooser(intent, str2));
    }

    public static final void F(Context context, Uri uri, String str) {
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

    public static /* synthetic */ void G(Context context, Uri uri, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        F(context, uri, str);
    }

    public static final String H(String str, String str2) {
        return str + "&&" + str2;
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
    public static final android.net.Uri I(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "fileName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.io.File r0 = new java.io.File
            java.io.File r1 = r3.getCacheDir()
            java.lang.String r2 = "translatorShare"
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x0026
            com.upuphone.ar.translation.utils.FileUtils r1 = com.upuphone.ar.translation.utils.FileUtils.f6363a
            r1.a(r0)
        L_0x0026:
            r0.mkdirs()
            java.io.File r1 = new java.io.File
            r1.<init>(r0, r5)
            int r5 = com.upuphone.ar.translation.phone.R.string.tl_intel_extn_content_reminder
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
            java.lang.String r4 = "com.upuphone.ar.translation.phone.fileprovider"
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
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.ext.ContextExtKt.I(android.content.Context, java.lang.String, java.lang.String):android.net.Uri");
    }

    public static final String J(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        LanguageUtils.StoredLanguage g = LanguageUtils.g();
        Map K = K(context);
        if (K.isEmpty()) {
            String string = context.getString(R.string.tl_func_language_not_support);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        for (Map.Entry entry : K.entrySet()) {
            String str = (String) entry.getValue();
            if (Intrinsics.areEqual((Object) g.e(), (Object) (String) entry.getKey())) {
                return str;
            }
        }
        String string2 = context.getString(R.string.tl_func_language_not_support);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    public static final Map K(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("cn", context.getString(R.string.tl_func_transcribe_cn));
        hashMap.put("en", context.getString(R.string.tl_func_transcribe_en));
        hashMap.put("ja", context.getString(R.string.tl_func_transcribe_ja));
        hashMap.put("fr", context.getString(R.string.tl_func_transcribe_fr));
        hashMap.put("ko", context.getString(R.string.tl_func_transcribe_ko));
        hashMap.put("ru", context.getString(R.string.tl_func_transcribe_ru));
        hashMap.put("es", context.getString(R.string.tl_func_transcribe_es));
        hashMap.put("vi", context.getString(R.string.tl_func_transcribe_vi));
        hashMap.put("ms", context.getString(R.string.tl_func_transcribe_ms));
        hashMap.put("th", context.getString(R.string.tl_func_transcribe_th));
        hashMap.put("id", context.getString(R.string.tl_func_transcribe_id));
        hashMap.put("it", context.getString(R.string.tl_func_transcribe_it));
        hashMap.put("de", context.getString(R.string.tl_func_transcribe_de));
        hashMap.put("tr", context.getString(R.string.tl_func_transcribe_tr));
        return hashMap;
    }

    public static final String L(Context context, int i) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(context, "<this>");
        LanguageUtils.StoredLanguage g = LanguageUtils.g();
        if (i == 2) {
            str = g.d();
            str2 = g.c();
        } else if (i != 3) {
            str = "";
            str2 = str;
        } else {
            str = g.b();
            str2 = g.a();
        }
        if (str.length() != 0 && str2.length() != 0) {
            return M(context, str, str2);
        }
        String string = context.getString(R.string.tl_func_language_not_support);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String M(Context context, String str, String str2) {
        return TranslatorConstants.isIntlVersion() ? c(context, str, str2) : TranslatorConstants.isAirPro() ? c(context, str, str2) : y(context, str, str2);
    }

    public static final Bitmap N(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int width = view.getWidth();
        int height = view.getHeight();
        LogExt.j("viewToBitmap width=" + width + ", height=" + height, "ContextExt");
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.net.Uri O(android.content.Context r7, android.view.View r8, android.graphics.Bitmap r9) {
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
            int r4 = com.upuphone.ar.translation.phone.R.dimen.record_share_image_top
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
            java.lang.String r5 = "ContextExt"
            com.upuphone.ar.translation.ext.LogExt.j(r4, r5)
            int r1 = r1 + r3
            int r2 = r2 + r1
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r2, r4)
            java.lang.String r2 = "createBitmap(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            android.graphics.Canvas r2 = new android.graphics.Canvas
            r2.<init>(r0)
            int r4 = com.upuphone.ar.translation.phone.R.color.color_page_bg_record_detail
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
            com.upuphone.ar.translation.utils.FileUtils r9 = com.upuphone.ar.translation.utils.FileUtils.f6363a
            r9.a(r8)
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
            com.upuphone.ar.translation.ext.LogExt.j(r8, r5)     // Catch:{ all -> 0x00d0 }
            if (r4 == 0) goto L_0x00f1
            r4.close()
        L_0x00f1:
            java.lang.String r8 = "com.upuphone.ar.translation.phone.fileprovider"
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
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.ext.ContextExtKt.O(android.content.Context, android.view.View, android.graphics.Bitmap):android.net.Uri");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.net.Uri P(android.content.Context r7, androidx.recyclerview.widget.RecyclerView r8, android.graphics.Bitmap r9) {
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
            int r4 = com.upuphone.ar.translation.phone.R.dimen.record_share_image_top
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
            java.lang.String r5 = "ContextExt"
            com.upuphone.ar.translation.ext.LogExt.j(r4, r5)
            int r1 = r1 + r3
            int r2 = r2 + r1
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r2, r4)
            java.lang.String r2 = "createBitmap(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            android.graphics.Canvas r2 = new android.graphics.Canvas
            r2.<init>(r0)
            int r4 = com.upuphone.ar.translation.phone.R.color.color_page_bg_record_detail
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
            com.upuphone.ar.translation.utils.FileUtils r9 = com.upuphone.ar.translation.utils.FileUtils.f6363a
            r9.a(r8)
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
            com.upuphone.ar.translation.ext.LogExt.j(r8, r5)     // Catch:{ all -> 0x00d0 }
            if (r4 == 0) goto L_0x00f1
            r4.close()
        L_0x00f1:
            java.lang.String r8 = "com.upuphone.ar.translation.phone.fileprovider"
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
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.ext.ContextExtKt.P(android.content.Context, androidx.recyclerview.widget.RecyclerView, android.graphics.Bitmap):android.net.Uri");
    }

    public static final Uri a(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        File file = new File(context.getFilesDir(), "transDebugAudio.zip");
        if (file.exists()) {
            FileUtils.f6363a.a(file);
        }
        ZipUtils.b(new File(context.getFilesDir(), "audio"), file);
        return FileProvider.getUriForFile(context, "com.upuphone.ar.translation.phone.fileprovider", file);
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
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
        LogExt.j("backViewToBitmap screenWidth=" + i + ", screenHeight=" + i2, "ContextExt");
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        int width = view.getWidth();
        int height = view.getHeight();
        LogExt.j("backViewToBitmap viewWidth=" + width + ", viewHeight=" + height, "ContextExt");
        return N(view);
    }

    public static final String c(Context context, String str, String str2) {
        String string = context.getString(R.string.tl_func_language_not_support);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Map d = d(context);
        if (!Intrinsics.areEqual((Object) str, (Object) str2) && !d.isEmpty() && d.containsKey(str) && d.containsKey(str2)) {
            String str3 = (String) d.get(str);
            String str4 = (String) d.get(str2);
            if (!(str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0)) {
                string = H(str3, str4);
            }
            LogExt.j("intlTranslationHint result=" + string, "ContextExt");
        }
        return string;
    }

    public static final Map d(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("cn", h(context));
        hashMap.put("cnen", j(context));
        hashMap.put("ja", o(context));
        hashMap.put("ko", p(context));
        hashMap.put("fr", l(context));
        hashMap.put("ru", r(context));
        hashMap.put("es", k(context));
        hashMap.put("vi", u(context));
        hashMap.put("ms", q(context));
        hashMap.put("th", s(context));
        hashMap.put("id", m(context));
        hashMap.put("it", n(context));
        hashMap.put("de", i(context));
        hashMap.put("ar", g(context));
        hashMap.put("tr", t(context));
        return hashMap;
    }

    public static final boolean e(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static final boolean f(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    public static final String g(Context context) {
        String string = context.getString(R.string.tl_simultaneous_ar);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String h(Context context) {
        String string = context.getString(R.string.tl_simultaneous_cn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String i(Context context) {
        String string = context.getString(R.string.tl_simultaneous_de);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String j(Context context) {
        String string = context.getString(R.string.tl_simultaneous_en);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String k(Context context) {
        String string = context.getString(R.string.tl_simultaneous_es);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String l(Context context) {
        String string = context.getString(R.string.tl_simultaneous_fr);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String m(Context context) {
        String string = context.getString(R.string.tl_simultaneous_id);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String n(Context context) {
        String string = context.getString(R.string.tl_simultaneous_it);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String o(Context context) {
        String string = context.getString(R.string.tl_simultaneous_ja);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String p(Context context) {
        String string = context.getString(R.string.tl_simultaneous_ko);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String q(Context context) {
        String string = context.getString(R.string.tl_simultaneous_ms);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String r(Context context) {
        String string = context.getString(R.string.tl_simultaneous_ru);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String s(Context context) {
        String string = context.getString(R.string.tl_simultaneous_th);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String t(Context context) {
        String string = context.getString(R.string.tl_simultaneous_tr);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String u(Context context) {
        String string = context.getString(R.string.tl_simultaneous_vi);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final Map v(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("cnen", context.getString(R.string.tl_func_trans_cn_en));
        hashMap.put("ja", context.getString(R.string.tl_func_trans_ja_cn));
        hashMap.put("fr", context.getString(R.string.tl_func_trans_fr_cn));
        hashMap.put("ko", context.getString(R.string.tl_func_trans_ko_cn));
        hashMap.put("ru", context.getString(R.string.tl_func_trans_ru_cn));
        hashMap.put("es", context.getString(R.string.tl_func_trans_es_cn));
        hashMap.put("vi", context.getString(R.string.tl_func_trans_vi_cn));
        return hashMap;
    }

    public static final Map w(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("cnen", context.getString(R.string.tl_func_trans_cn_en));
        hashMap.put("ja", context.getString(R.string.tl_func_trans_cn_ja));
        hashMap.put("fr", context.getString(R.string.tl_func_trans_cn_fr));
        hashMap.put("ko", context.getString(R.string.tl_func_trans_cn_ko));
        hashMap.put("ru", context.getString(R.string.tl_func_trans_cn_ru));
        hashMap.put("es", context.getString(R.string.tl_func_trans_cn_es));
        hashMap.put("vi", context.getString(R.string.tl_func_trans_cn_vi));
        return hashMap;
    }

    public static final String x(Context context, String str) {
        Map v = v(context);
        if (v.isEmpty()) {
            String string = context.getString(R.string.tl_func_language_not_support);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        for (Map.Entry entry : v.entrySet()) {
            String str2 = (String) entry.getValue();
            if (Intrinsics.areEqual((Object) (String) entry.getKey(), (Object) str)) {
                return str2;
            }
        }
        String string2 = context.getString(R.string.tl_func_language_not_support);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    public static final String y(Context context, String str, String str2) {
        if (Intrinsics.areEqual((Object) str, (Object) "cn")) {
            return z(context, str2);
        }
        if (Intrinsics.areEqual((Object) str2, (Object) "cn")) {
            return x(context, str);
        }
        String string = context.getString(R.string.tl_func_language_not_support);
        Intrinsics.checkNotNull(string);
        return string;
    }

    public static final String z(Context context, String str) {
        Map w = w(context);
        if (w.isEmpty()) {
            String string = context.getString(R.string.tl_func_language_not_support);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        for (Map.Entry entry : w.entrySet()) {
            String str2 = (String) entry.getValue();
            if (Intrinsics.areEqual((Object) (String) entry.getKey(), (Object) str)) {
                return str2;
            }
        }
        String string2 = context.getString(R.string.tl_func_language_not_support);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }
}
