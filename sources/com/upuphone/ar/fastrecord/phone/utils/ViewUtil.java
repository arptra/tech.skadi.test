package com.upuphone.ar.fastrecord.phone.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.bean.FastRecordLanguageBean;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.lang.Character;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0006J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0013J\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0016\u0010&\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0013J\u001e\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\nJ\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020\u000eJ(\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u0002032\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u000105R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/ViewUtil;", "", "()V", "DELAY_CHECK_MEMORY", "", "TAG", "", "checkMemoryJob", "Lkotlinx/coroutines/Job;", "calculateLength", "", "charSequence", "", "cancelCheckMemoryJob", "", "dip2px", "context", "Landroid/content/Context;", "dpValue", "", "getByteArray", "", "contentValue", "getByteSize", "getIntlLangList", "", "Lcom/upuphone/ar/fastrecord/phone/bean/FastRecordLanguageBean;", "getLineLength", "str", "textSize", "getNavigationBarHeight", "hideSoftInput", "view", "Landroid/view/ViewGroup;", "isChinese", "", "char", "", "px2dip", "pxValue", "setInputByLimit", "inputValueEdt", "Landroid/widget/EditText;", "limit", "shrinkBitmapHeight", "Landroid/graphics/Bitmap;", "bitmap", "startCheckLowMemoryJob", "startFastRecordIngDetailActivity", "recordId", "activity", "Landroid/app/Activity;", "callback", "Lkotlin/Function0;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ViewUtil {
    private static final long DELAY_CHECK_MEMORY = 10000;
    @NotNull
    public static final ViewUtil INSTANCE = new ViewUtil();
    @NotNull
    private static final String TAG = "ViewUtil";
    /* access modifiers changed from: private */
    @Nullable
    public static Job checkMemoryJob;

    private ViewUtil() {
    }

    private final int calculateLength(CharSequence charSequence) {
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            i += isChinese(charSequence.charAt(i2)) ? 2 : 1;
        }
        return i;
    }

    private final boolean isChinese(char c) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c);
        return Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) || Intrinsics.areEqual((Object) of, (Object) Character.UnicodeBlock.GENERAL_PUNCTUATION);
    }

    public static /* synthetic */ void startFastRecordIngDetailActivity$default(ViewUtil viewUtil, long j, Activity activity, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        viewUtil.startFastRecordIngDetailActivity(j, activity, function0);
    }

    public final void cancelCheckMemoryJob() {
        Job job = checkMemoryJob;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final int dip2px(@NotNull Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @NotNull
    public final byte[] getByteArray(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "contentValue");
        try {
            Charset forName = Charset.forName("GB2312");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
            byte[] bytes = str.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes;
        } catch (Exception e) {
            String message = e.getMessage();
            LogExt.logE("getByteArray error = " + message, TAG);
            Charset defaultCharset = Charset.defaultCharset();
            Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset(...)");
            byte[] bytes2 = str.getBytes(defaultCharset);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            return bytes2;
        }
    }

    public final int getByteSize(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "contentValue");
        try {
            Charset forName = Charset.forName("GB2312");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
            byte[] bytes = str.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes.length;
        } catch (Exception e) {
            String message = e.getMessage();
            LogExt.logE("getByteSize error = " + message, TAG);
            Charset defaultCharset = Charset.defaultCharset();
            Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset(...)");
            byte[] bytes2 = str.getBytes(defaultCharset);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            return bytes2.length;
        }
    }

    @NotNull
    public final List<FastRecordLanguageBean> getIntlLangList(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        String string = context.getString(R.string.fr_simultaneous_cn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string, "cmn-Hans-CN"));
        String string2 = context.getString(R.string.fr_simultaneous_en);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string2, "en-GB"));
        String string3 = context.getString(R.string.fr_simultaneous_fr);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string3, "fr-FR"));
        String string4 = context.getString(R.string.fr_simultaneous_de);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string4, "de-DE"));
        String string5 = context.getString(R.string.fr_simultaneous_ms);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string5, "ms-MY"));
        String string6 = context.getString(R.string.fr_simultaneous_id);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string6, "id-ID"));
        String string7 = context.getString(R.string.fr_simultaneous_th);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string7, "th-TH"));
        String string8 = context.getString(R.string.fr_simultaneous_ja);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string8, "ja-JP"));
        String string9 = context.getString(R.string.fr_simultaneous_ko);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string9, "ko-KR"));
        String string10 = context.getString(R.string.fr_simultaneous_ar);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string10, "ar-SA"));
        return arrayList;
    }

    public final int getLineLength(@NotNull String str, float f) {
        Intrinsics.checkNotNullParameter(str, "str");
        Paint paint = new Paint();
        paint.setTextSize(f);
        return (int) paint.measureText(str);
    }

    public final int getNavigationBarHeight(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final void hideSoftInput(@NotNull Context context, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(viewGroup.getWindowToken(), 0);
    }

    public final int px2dip(@NotNull Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void setInputByLimit(@NotNull EditText editText, @NotNull String str, int i) {
        String str2;
        Intrinsics.checkNotNullParameter(editText, "inputValueEdt");
        Intrinsics.checkNotNullParameter(str, "contentValue");
        int calculateLength = calculateLength(str);
        LogExt.logD("setInputByLimit content=" + str + ", limit=" + i + ",sizeInput = " + calculateLength, TAG);
        if (calculateLength > i) {
            int length = str.length();
            while (true) {
                length--;
                if (-1 >= length) {
                    str2 = str;
                    break;
                }
                CharSequence subSequence = str.subSequence(0, length);
                Intrinsics.checkNotNull(subSequence, "null cannot be cast to non-null type kotlin.String");
                str2 = (String) subSequence;
                if (getByteArray(str2).length <= i) {
                    break;
                }
            }
            Charset defaultCharset = Charset.defaultCharset();
            Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset(...)");
            byte[] bytes = str2.getBytes(defaultCharset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            LogExt.logD("setInputByLimit before=" + str + ", after=" + str2 + "，len=" + bytes.length, TAG);
            editText.setText(str2);
        }
    }

    @NotNull
    public final Bitmap shrinkBitmapHeight(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Bitmap.Config config = bitmap.getConfig();
        Intrinsics.checkNotNullExpressionValue(config, "getConfig(...)");
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight() / 2, config);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, 0.5f);
        canvas.drawBitmap(bitmap, matrix, (Paint) null);
        return createBitmap;
    }

    public final void startCheckLowMemoryJob() {
        Job job = checkMemoryJob;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        LogExt.logW("startCheckLocationJob check", TAG);
        checkMemoryJob = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new ViewUtil$startCheckLowMemoryJob$1((Continuation<? super ViewUtil$startCheckLowMemoryJob$1>) null), 3, (Object) null);
    }

    public final void startFastRecordIngDetailActivity(long j, @NotNull Activity activity, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new ViewUtil$startFastRecordIngDetailActivity$1(j, function0, activity, (Continuation<? super ViewUtil$startFastRecordIngDetailActivity$1>) null), 3, (Object) null);
    }
}
