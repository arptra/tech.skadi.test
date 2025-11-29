package com.upuphone.ar.fastrecord.phone.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00020\u0003\"\u00020\u0001\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006\u001a\u0016\u0010\u0007\u001a\u00020\u0005*\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005\u001a1\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\u0007\u001a\u00020\f*\u0004\u0018\u00010\f2\b\b\u0002\u0010\b\u001a\u00020\f¢\u0006\u0002\u0010\r\u001a\u001b\u0010\u0007\u001a\u00020\u000e*\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\b\u001a\u00020\u000e¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\b\b\u0002\u0010\b\u001a\u00020\u0001¢\u0006\u0002\u0010\u0010\u001a\u001b\u0010\u0007\u001a\u00020\u0011*\u0004\u0018\u00010\u00112\b\b\u0002\u0010\b\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0007\u001a\u00020\u0013*\u0004\u0018\u00010\u00132\b\b\u0002\u0010\b\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014\u001a\u0016\u0010\u0007\u001a\u00020\u0015*\u0004\u0018\u00010\u00152\b\b\u0002\u0010\b\u001a\u00020\u0015\u001a.\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\n0\u0016\"\u0004\b\u0000\u0010\n*\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u00162\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0016\u001aF\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190\u0017\"\u0004\b\u0000\u0010\u0018\"\u0004\b\u0001\u0010\u0019*\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u0019\u0018\u00010\u00172\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190\u0017\u001a\n\u0010\u001a\u001a\u00020\u001b*\u00020\u0006\u001a\n\u0010\u001c\u001a\u00020\u0011*\u00020\u001d\u001a\n\u0010\u001e\u001a\u00020\u0011*\u00020\u0006\u001a\n\u0010\u001f\u001a\u00020\u0011*\u00020\u0006\u001a\n\u0010 \u001a\u00020\f*\u00020\u001d\u001a\n\u0010!\u001a\u00020\f*\u00020\"\u001a0\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0$\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\f0&\u001a\u0014\u0010'\u001a\u00020(*\u00020\"2\b\b\u0001\u0010)\u001a\u00020\u0011\u001a$\u0010*\u001a\u00020(*\u00020\u00062\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00152\b\b\u0002\u0010-\u001a\u00020\u0015\u001a4\u0010.\u001a\u00020(*\u00020\u00062\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u000500j\b\u0012\u0004\u0012\u00020\u0005`12\u0006\u0010,\u001a\u00020\u00152\b\b\u0002\u0010-\u001a\u00020\u0015\u001a\n\u00102\u001a\u000203*\u000204¨\u00065"}, d2 = {"average", "", "array", "", "audioGzipToUri", "Landroid/net/Uri;", "Landroid/content/Context;", "default", "value", "", "T", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "", "(Ljava/lang/Boolean;Z)Z", "", "(Ljava/lang/Double;D)D", "(Ljava/lang/Float;F)F", "", "(Ljava/lang/Integer;I)I", "", "(Ljava/lang/Long;J)J", "", "", "", "K", "V", "fastRecordTabLayoutInflater", "Landroid/view/LayoutInflater;", "getNavigationBarHeight", "Landroid/app/Activity;", "getScreenHeight", "getScreenWidth", "hasNavigationBar", "isSingleLineEllipsized", "Landroid/widget/TextView;", "removeIf", "", "predicate", "Lkotlin/Function1;", "setTextColorRes", "", "res", "shareFile", "uri", "fileType", "title", "shareMoreFile", "uriList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "toBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "ar-fastrecord_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecordExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordExt.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordExtKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,201:1\n13344#2,2:202\n*S KotlinDebug\n*F\n+ 1 RecordExt.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordExtKt\n*L\n81#1:202,2\n*E\n"})
public final class RecordExtKt {
    @Nullable
    public static final Uri audioGzipToUri(@NotNull Context context) throws Exception {
        Intrinsics.checkNotNullParameter(context, "<this>");
        File file = new File(context.getFilesDir(), "Fast_Record_Audio.zip");
        if (file.exists()) {
            RecordFileUtils.INSTANCE.delete(file);
        }
        RecordZipUtils.zipFile(new File(context.getFilesDir(), "audio"), file);
        return FileProvider.getUriForFile(context, "com.upup.start.launcher.soundrecorder.fileprovider", file);
    }

    public static final float average(@NotNull float... fArr) {
        Intrinsics.checkNotNullParameter(fArr, "array");
        float f = 0.0f;
        if (fArr.length == 0) {
            return 0.0f;
        }
        for (float f2 : fArr) {
            f += f2;
        }
        return f / ((float) fArr.length);
    }

    @NotNull
    /* renamed from: default  reason: not valid java name */
    public static final Uri m1670default(@Nullable Uri uri, @NotNull Uri uri2) {
        Intrinsics.checkNotNullParameter(uri2, AccountConstantKt.RESPONSE_VALUE);
        return uri == null ? uri2 : uri;
    }

    public static /* synthetic */ int default$default(Integer num, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return m1668default(num, i);
    }

    @NotNull
    public static final LayoutInflater fastRecordTabLayoutInflater(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Configuration configuration = context.getResources().getConfiguration();
        configuration.fontScale = 1.0f;
        LayoutInflater from = LayoutInflater.from(context.createConfigurationContext(configuration));
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        return from;
    }

    public static final int getNavigationBarHeight(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        WindowInsetsCompat H = ViewCompat.H(activity.getWindow().getDecorView());
        if (H == null) {
            LogExt.logE("getNavigationBarHeight windowInsets is null", "RecordExt");
            return 0;
        }
        Insets f = H.f(WindowInsetsCompat.Type.d());
        Intrinsics.checkNotNullExpressionValue(f, "getInsets(...)");
        int abs = Math.abs(f.d - f.b);
        LogExt.logE("getNavigationBarHeight naviHeight=" + abs, "RecordExt");
        return abs;
    }

    public static final int getScreenHeight(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static final int getScreenWidth(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static final boolean hasNavigationBar(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        WindowInsetsCompat H = ViewCompat.H(activity.getWindow().getDecorView());
        if (H == null) {
            LogExt.logE("hasNavigationBars windowInsets is null", "RecordExt");
            return false;
        }
        boolean q = H.q(WindowInsetsCompat.Type.d());
        int navigationBarHeight = getNavigationBarHeight(activity);
        LogExt.logE("hasNavigationBars naviVisible=" + q + ", naviHeight=" + navigationBarHeight, "RecordExt");
        return q && navigationBarHeight > 0;
    }

    public static final boolean isSingleLineEllipsized(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Layout layout = textView.getLayout();
        return layout != null && layout.getLineCount() > 0 && layout.getEllipsisCount(0) > 0;
    }

    @NotNull
    public static final <T> List<T> removeIf(@NotNull List<T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (T next : list) {
            if (function1.invoke(next).booleanValue()) {
                list.remove(next);
            }
        }
        return list;
    }

    public static final void setTextColorRes(@NotNull TextView textView, @ColorRes int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), i));
    }

    public static final void shareFile(@NotNull Context context, @NotNull Uri uri, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(str, "fileType");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setType(str);
        intent.addFlags(1);
        context.startActivity(Intent.createChooser(intent, str2));
    }

    public static /* synthetic */ void shareFile$default(Context context, Uri uri, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        shareFile(context, uri, str, str2);
    }

    public static final void shareMoreFile(@NotNull Context context, @NotNull ArrayList<Uri> arrayList, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(arrayList, "uriList");
        Intrinsics.checkNotNullParameter(str, "fileType");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND_MULTIPLE");
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        intent.setType(str);
        intent.addFlags(1);
        context.startActivity(Intent.createChooser(intent, str2), (Bundle) null);
    }

    public static /* synthetic */ void shareMoreFile$default(Context context, ArrayList arrayList, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        shareMoreFile(context, arrayList, str, str2);
    }

    @NotNull
    public static final Bitmap toBitmap(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    @NotNull
    /* renamed from: default  reason: not valid java name */
    public static final String m1671default(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.RESPONSE_VALUE);
        return str == null ? str2 : str;
    }

    public static /* synthetic */ double default$default(Double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d2 = 0.0d;
        }
        return m1666default(d, d2);
    }

    @NotNull
    /* renamed from: default  reason: not valid java name */
    public static final <T> List<T> m1672default(@Nullable List<? extends T> list, @NotNull List<? extends T> list2) {
        Intrinsics.checkNotNullParameter(list2, AccountConstantKt.RESPONSE_VALUE);
        return list == null ? list2 : list;
    }

    public static /* synthetic */ float default$default(Float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = 0.0f;
        }
        return m1667default(f, f2);
    }

    @NotNull
    /* renamed from: default  reason: not valid java name */
    public static final <K, V> Map<K, V> m1673default(@Nullable Map<K, ? extends V> map, @NotNull Map<K, ? extends V> map2) {
        Intrinsics.checkNotNullParameter(map2, AccountConstantKt.RESPONSE_VALUE);
        return map == null ? map2 : map;
    }

    public static /* synthetic */ long default$default(Long l, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return m1669default(l, j);
    }

    @NotNull
    /* renamed from: default  reason: not valid java name */
    public static final <T> T[] m1675default(@Nullable T[] tArr, @NotNull T[] tArr2) {
        Intrinsics.checkNotNullParameter(tArr2, AccountConstantKt.RESPONSE_VALUE);
        return tArr == null ? tArr2 : tArr;
    }

    public static /* synthetic */ boolean default$default(Boolean bool, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return m1674default(bool, z);
    }

    /* renamed from: default  reason: not valid java name */
    public static final int m1668default(@Nullable Integer num, int i) {
        return num != null ? num.intValue() : i;
    }

    public static /* synthetic */ String default$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        return m1671default(str, str2);
    }

    /* renamed from: default  reason: not valid java name */
    public static final double m1666default(@Nullable Double d, double d2) {
        return d != null ? d.doubleValue() : d2;
    }

    public static /* synthetic */ Uri default$default(Uri uri, Uri uri2, int i, Object obj) {
        if ((i & 1) != 0) {
            uri2 = Uri.EMPTY;
            Intrinsics.checkNotNullExpressionValue(uri2, "EMPTY");
        }
        return m1670default(uri, uri2);
    }

    /* renamed from: default  reason: not valid java name */
    public static final float m1667default(@Nullable Float f, float f2) {
        return f != null ? f.floatValue() : f2;
    }

    public static /* synthetic */ List default$default(List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        return m1672default(list, list2);
    }

    /* renamed from: default  reason: not valid java name */
    public static final long m1669default(@Nullable Long l, long j) {
        return l != null ? l.longValue() : j;
    }

    public static /* synthetic */ Map default$default(Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            map2 = MapsKt.emptyMap();
        }
        return m1673default(map, map2);
    }

    /* renamed from: default  reason: not valid java name */
    public static final boolean m1674default(@Nullable Boolean bool, boolean z) {
        return bool != null ? bool.booleanValue() : z;
    }
}
