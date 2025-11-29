package com.upuphone.xr.sapp.utils;

import android.text.SpannableString;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/utils/ClickSpanHelper;", "", "<init>", "()V", "", "text", "", "target", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "click", "", "clickCall", "Landroid/text/SpannableString;", "a", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableString;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nClickSpanHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClickSpanHelper.kt\ncom/upuphone/xr/sapp/utils/ClickSpanHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,66:1\n766#2:67\n857#2,2:68\n*S KotlinDebug\n*F\n+ 1 ClickSpanHelper.kt\ncom/upuphone/xr/sapp/utils/ClickSpanHelper\n*L\n46#1:67\n46#1:68,2\n*E\n"})
public final class ClickSpanHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final ClickSpanHelper f7853a = new ClickSpanHelper();

    public final SpannableString a(String str, List list, Function1 function1) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(list, "target");
        Intrinsics.checkNotNullParameter(function1, "clickCall");
        boolean areEqual = Intrinsics.areEqual((Object) GlobalExtKt.f().getResources().getConfiguration().locale.getLanguage(), (Object) "ja");
        int[] iArr = {GlobalExtKt.f().getResources().getColor(R.color.color_gradient_star), GlobalExtKt.f().getResources().getColor(R.color.color_gradient_end)};
        SpannableString spannableString = new SpannableString(str);
        Pattern compile = Pattern.compile(areEqual ? "「[^」]+」|「」" : "《[^》]+》|《》|<[^>]+>|<>|«[^»]+»|«»|\".*?\"");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        Matcher matcher = compile.matcher(str);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("ClickSpanHelper", "命中->" + matcher + "，group->" + group);
            ArrayList arrayList = new ArrayList();
            for (Object next : list) {
                Intrinsics.checkNotNull(group);
                if (StringsKt.contains$default((CharSequence) group, (CharSequence) (String) next, false, 2, (Object) null)) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                spannableString.setSpan(new ClickSpanHelper$buildAgreementClickSpan$1(arrayList, function1, iArr), start, end, 33);
            }
        }
        return spannableString;
    }
}
