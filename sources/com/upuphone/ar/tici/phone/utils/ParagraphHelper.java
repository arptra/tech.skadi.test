package com.upuphone.ar.tici.phone.utils;

import android.text.Layout;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.widget.ScrollView;
import android.widget.TextView;
import com.honey.account.s4.c;
import com.honey.account.s4.d;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.phone.data.HighlightInfo;
import com.upuphone.ar.tici.phone.starrynet.msg.ParagraphItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/ParagraphHelper;", "", "a", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class ParagraphHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f5995a = new Companion((DefaultConstructorMarker) null);

    @SourceDebugExtension({"SMAP\nParagraphHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ParagraphHelper.kt\ncom/upuphone/ar/tici/phone/utils/ParagraphHelper$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,176:1\n288#2,2:177\n1#3:179\n*S KotlinDebug\n*F\n+ 1 ParagraphHelper.kt\ncom/upuphone/ar/tici/phone/utils/ParagraphHelper$Companion\n*L\n31#1:177,2\n*E\n"})
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\f\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\rJ=\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0005H@¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/ParagraphHelper$Companion;", "", "<init>", "()V", "", "", "start", "end", "", "Lcom/upuphone/ar/tici/phone/starrynet/msg/ParagraphItem;", "textLines", "Lcom/upuphone/ar/tici/phone/data/HighlightInfo;", "f", "(Ljava/lang/String;IILjava/util/List;)Lcom/upuphone/ar/tici/phone/data/HighlightInfo;", "Landroid/widget/TextView;", "textView", "sourceText", "e", "(Landroid/widget/TextView;Ljava/lang/String;IILjava/util/List;)Ljava/lang/Integer;", "Landroid/widget/ScrollView;", "scrollView", "", "g", "(Landroid/widget/ScrollView;Landroid/widget/TextView;I)V", "d", "(Landroid/widget/TextView;)Ljava/util/List;", "wordCountOfParagraph", "c", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void h(ScrollView scrollView, TextView textView, int i) {
            Intrinsics.checkNotNullParameter(scrollView, "$scrollView");
            Intrinsics.checkNotNullParameter(textView, "$textView");
            ParagraphHelper.f5995a.g(scrollView, textView, i);
        }

        public static final void i(ScrollView scrollView, int i, int i2) {
            Intrinsics.checkNotNullParameter(scrollView, "$scrollView");
            scrollView.scrollTo(0, i);
            CommonExtKt.e("scrollToText, line: " + i2 + ", scrollY: " + i, "ParagraphHelper");
        }

        public final Object c(String str, int i, Continuation continuation) {
            return BuildersKt.g(Dispatchers.a(), new ParagraphHelper$Companion$computeParagraph$2(str, i, (Continuation<? super ParagraphHelper$Companion$computeParagraph$2>) null), continuation);
        }

        public final List d(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "textView");
            Layout layout = textView.getLayout();
            if (layout == null) {
                return CollectionsKt.emptyList();
            }
            int lineCount = layout.getLineCount();
            CommonExtKt.b("getTextLineParagraph, totalLines: " + lineCount, "ParagraphHelper");
            ArrayList arrayList = new ArrayList(lineCount);
            for (int i = 0; i < lineCount; i++) {
                arrayList.add(new ParagraphItem(layout.getLineStart(i), layout.getLineEnd(i)));
            }
            return arrayList;
        }

        public final Integer e(TextView textView, String str, int i, int i2, List list) {
            TextView textView2 = textView;
            String str2 = str;
            int i3 = i;
            int i4 = i2;
            List list2 = list;
            Intrinsics.checkNotNullParameter(textView2, "textView");
            Intrinsics.checkNotNullParameter(str2, "sourceText");
            Intrinsics.checkNotNullParameter(list2, "textLines");
            try {
                CommonExtKt.e("highlight, sourceText.length: " + str.length() + ", from: " + i3 + ", to: " + i4, "ParagraphHelper");
                HighlightInfo f = f(str2, i3, i4, list2);
                String text = f.getText();
                SpannableString spannableString = new SpannableString(text);
                int start = f.getStart();
                int end = f.getEnd();
                String substring = text.substring(start, end);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                CommonExtKt.e("highlight, subText.length: " + text.length() + ", from: " + start + ", to: " + end, "ParagraphHelper");
                StringBuilder sb = new StringBuilder();
                sb.append("highlight, highlightText: '");
                sb.append(substring);
                sb.append("'");
                CommonExtKt.e(sb.toString(), "ParagraphHelper");
                String obj = StringsKt.trimStart((CharSequence) StringExtKt.c(substring)).toString();
                if (!Intrinsics.areEqual((Object) obj, (Object) substring)) {
                    CommonExtKt.e("formattedHighlightText: '" + obj + "'", "ParagraphHelper");
                    Integer valueOf = Integer.valueOf(StringsKt.indexOf$default((CharSequence) substring, obj, 0, false, 6, (Object) null));
                    if (valueOf.intValue() < 0) {
                        valueOf = null;
                    }
                    int intValue = (valueOf != null ? valueOf.intValue() : 0) + start;
                    CommonExtKt.d("highlight, highlightIndex: " + start + ", change to: " + intValue, "ParagraphHelper", (Throwable) null, 2, (Object) null);
                    start = intValue;
                }
                spannableString.setSpan(new TextAppearanceSpan(textView.getContext(), R.style.TiciHighlightText), start, end, 18);
                textView2.setText(spannableString);
                return Integer.valueOf(start);
            } catch (Exception e) {
                CommonExtKt.d("highlight, error: " + e, "ParagraphHelper", (Throwable) null, 2, (Object) null);
                return null;
            }
        }

        public final HighlightInfo f(String str, int i, int i2, List list) {
            Object obj;
            int i3;
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(list, "textLines");
            int i4 = i2 - i;
            try {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    ParagraphItem paragraphItem = (ParagraphItem) obj;
                    if (i >= paragraphItem.getStart() && i < paragraphItem.getEnd()) {
                        break;
                    }
                }
                ParagraphItem paragraphItem2 = (ParagraphItem) obj;
                if (paragraphItem2 != null) {
                    CommonExtKt.b("highlightSubText, start: " + i + ", change to: " + paragraphItem2, "ParagraphHelper");
                    i3 = paragraphItem2.getStart();
                } else {
                    CommonExtKt.d("highlightSubText, can`t find line for index: " + i, "ParagraphHelper", (Throwable) null, 2, (Object) null);
                    i3 = i;
                }
                int i5 = i - i3;
                String substring = str.substring(i3, Math.min(i2 + 1400, str.length()));
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                return new HighlightInfo(substring, i5, i4 + i5);
            } catch (Exception e) {
                CommonExtKt.d("highlightSubText, error: " + e, "ParagraphHelper", (Throwable) null, 2, (Object) null);
                return new HighlightInfo(str, i, i2);
            }
        }

        public final void g(ScrollView scrollView, TextView textView, int i) {
            Intrinsics.checkNotNullParameter(scrollView, "scrollView");
            Intrinsics.checkNotNullParameter(textView, "textView");
            Layout layout = textView.getLayout();
            if (layout == null) {
                CommonExtKt.d("scrollToText, textView.layout is null, retry later", "ParagraphHelper", (Throwable) null, 2, (Object) null);
                textView.post(new c(scrollView, textView, i));
                return;
            }
            try {
                int lineForOffset = layout.getLineForOffset(i);
                if (lineForOffset == -1) {
                    CommonExtKt.d("scrollToText, 没有找到对应内容，无法滚动", "ParagraphHelper", (Throwable) null, 2, (Object) null);
                } else {
                    scrollView.post(new d(scrollView, layout.getLineTop(lineForOffset), lineForOffset));
                }
            } catch (Exception e) {
                CommonExtKt.d("scrollToText, error: " + e, "ParagraphHelper", (Throwable) null, 2, (Object) null);
            }
        }

        public Companion() {
        }
    }
}
