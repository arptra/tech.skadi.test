package com.upuphone.ar.translation.phone.bean;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.utils.GsonUtils;
import com.upuphone.ar.translation.utils.JsonUtils;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002\u001a\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002\u001a\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002\u001a\n\u0010\u000e\u001a\u00020\u0004*\u00020\u000f\u001a\f\u0010\u0010\u001a\u00020\u0004*\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"DIALOG_TRANS_MAX_LEN", "", "OTHER_TRANS_MAX_LEN", "TAG", "", "getDialogueNoteBeanContent", "srcContent", "dstContent", "getNoteBeanContent", "getUpdatedNoteBeanContent", "text", "list", "", "Lcom/upuphone/ar/translation/phone/bean/TransRecordIndex;", "assembleContent", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "removeWhitespace", "ar-translator_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNoteBeanExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoteBeanExt.kt\ncom/upuphone/ar/translation/phone/bean/NoteBeanExtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,226:1\n1#2:227\n*E\n"})
public final class NoteBeanExtKt {
    private static final int DIALOG_TRANS_MAX_LEN = 80;
    private static final int OTHER_TRANS_MAX_LEN = 150;
    @NotNull
    private static final String TAG = "NoteBeanExt";

    @NotNull
    public static final String assembleContent(@NotNull NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(noteBean, "<this>");
        if (StringsKt.isBlank(noteBean.getSrcContent()) || StringsKt.isBlank(noteBean.getDstContent()) || !JsonUtils.b(noteBean.getDstContent())) {
            return "";
        }
        if (noteBean.getTransType() == 3) {
            return getDialogueNoteBeanContent(noteBean.getSrcContent(), noteBean.getDstContent());
        }
        String noteBeanContent = getNoteBeanContent(noteBean.getSrcContent(), noteBean.getDstContent());
        if (noteBeanContent.length() <= OTHER_TRANS_MAX_LEN) {
            return noteBeanContent;
        }
        String substring = noteBeanContent.substring(0, OTHER_TRANS_MAX_LEN);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0092 A[Catch:{ Exception -> 0x0053 }, LOOP:0: B:8:0x0025->B:26:0x0092, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0091 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.String getDialogueNoteBeanContent(java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.String r0 = ""
            java.lang.Class<com.upuphone.ar.translation.phone.bean.TransRecord> r1 = com.upuphone.ar.translation.phone.bean.TransRecord.class
            java.util.List r10 = com.upuphone.ar.translation.utils.GsonUtils.b(r10, r1)     // Catch:{ Exception -> 0x0053 }
            java.util.List r11 = com.upuphone.ar.translation.utils.GsonUtils.b(r11, r1)     // Catch:{ Exception -> 0x0053 }
            boolean r1 = r10.isEmpty()     // Catch:{ Exception -> 0x0053 }
            if (r1 != 0) goto L_0x0115
            boolean r1 = r11.isEmpty()     // Catch:{ Exception -> 0x0053 }
            if (r1 == 0) goto L_0x001a
            goto L_0x0115
        L_0x001a:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0053 }
            r1.<init>()     // Catch:{ Exception -> 0x0053 }
            int r2 = r10.size()     // Catch:{ Exception -> 0x0053 }
            r3 = 0
            r4 = r3
        L_0x0025:
            r5 = 1
            if (r4 >= r2) goto L_0x0095
            java.lang.Object r6 = r10.get(r4)     // Catch:{ Exception -> 0x0053 }
            com.upuphone.ar.translation.phone.bean.TransRecord r6 = (com.upuphone.ar.translation.phone.bean.TransRecord) r6     // Catch:{ Exception -> 0x0053 }
            java.lang.Object r7 = r11.get(r4)     // Catch:{ Exception -> 0x0053 }
            com.upuphone.ar.translation.phone.bean.TransRecord r7 = (com.upuphone.ar.translation.phone.bean.TransRecord) r7     // Catch:{ Exception -> 0x0053 }
            java.lang.String r8 = r6.getRContent()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r8 = com.upuphone.ar.translation.ext.StringExtKt.a(r8)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r9 = r7.getRContent()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r9 = com.upuphone.ar.translation.ext.StringExtKt.a(r9)     // Catch:{ Exception -> 0x0053 }
            boolean r8 = kotlin.text.StringsKt.isBlank(r8)     // Catch:{ Exception -> 0x0053 }
            r8 = r8 ^ r5
            if (r8 != 0) goto L_0x0056
            boolean r8 = kotlin.text.StringsKt.isBlank(r9)     // Catch:{ Exception -> 0x0053 }
            r8 = r8 ^ r5
            if (r8 == 0) goto L_0x0061
            goto L_0x0056
        L_0x0053:
            r10 = move-exception
            goto L_0x0116
        L_0x0056:
            com.upuphone.ar.translation.phone.bean.NoteDetailBean r8 = new com.upuphone.ar.translation.phone.bean.NoteDetailBean     // Catch:{ Exception -> 0x0053 }
            r8.<init>()     // Catch:{ Exception -> 0x0053 }
            r8.setDst(r9)     // Catch:{ Exception -> 0x0053 }
            r1.add(r8)     // Catch:{ Exception -> 0x0053 }
        L_0x0061:
            java.lang.String r6 = r6.getPContent()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r6 = com.upuphone.ar.translation.ext.StringExtKt.a(r6)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r7 = r7.getPContent()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r7 = com.upuphone.ar.translation.ext.StringExtKt.a(r7)     // Catch:{ Exception -> 0x0053 }
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)     // Catch:{ Exception -> 0x0053 }
            r6 = r6 ^ r5
            if (r6 != 0) goto L_0x007f
            boolean r6 = kotlin.text.StringsKt.isBlank(r7)     // Catch:{ Exception -> 0x0053 }
            r6 = r6 ^ r5
            if (r6 == 0) goto L_0x008a
        L_0x007f:
            com.upuphone.ar.translation.phone.bean.NoteDetailBean r6 = new com.upuphone.ar.translation.phone.bean.NoteDetailBean     // Catch:{ Exception -> 0x0053 }
            r6.<init>()     // Catch:{ Exception -> 0x0053 }
            r6.setDst(r7)     // Catch:{ Exception -> 0x0053 }
            r1.add(r6)     // Catch:{ Exception -> 0x0053 }
        L_0x008a:
            int r6 = r1.size()     // Catch:{ Exception -> 0x0053 }
            r7 = 2
            if (r6 < r7) goto L_0x0092
            goto L_0x0095
        L_0x0092:
            int r4 = r4 + 1
            goto L_0x0025
        L_0x0095:
            int r10 = r1.size()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r11 = "substring(...)"
            r2 = 80
            if (r10 <= r5) goto L_0x00f4
            java.lang.Object r10 = r1.get(r3)     // Catch:{ Exception -> 0x0053 }
            com.upuphone.ar.translation.phone.bean.NoteDetailBean r10 = (com.upuphone.ar.translation.phone.bean.NoteDetailBean) r10     // Catch:{ Exception -> 0x0053 }
            java.lang.String r4 = r10.getDst()     // Catch:{ Exception -> 0x0053 }
            int r4 = r4.length()     // Catch:{ Exception -> 0x0053 }
            if (r4 <= r2) goto L_0x00bb
            java.lang.String r10 = r10.getDst()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r10 = r10.substring(r3, r2)     // Catch:{ Exception -> 0x0053 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)     // Catch:{ Exception -> 0x0053 }
            goto L_0x00bf
        L_0x00bb:
            java.lang.String r10 = r10.getDst()     // Catch:{ Exception -> 0x0053 }
        L_0x00bf:
            java.lang.Object r1 = r1.get(r5)     // Catch:{ Exception -> 0x0053 }
            com.upuphone.ar.translation.phone.bean.NoteDetailBean r1 = (com.upuphone.ar.translation.phone.bean.NoteDetailBean) r1     // Catch:{ Exception -> 0x0053 }
            java.lang.String r4 = r1.getDst()     // Catch:{ Exception -> 0x0053 }
            int r4 = r4.length()     // Catch:{ Exception -> 0x0053 }
            if (r4 <= r2) goto L_0x00db
            java.lang.String r1 = r1.getDst()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r1 = r1.substring(r3, r2)     // Catch:{ Exception -> 0x0053 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r11)     // Catch:{ Exception -> 0x0053 }
            goto L_0x00df
        L_0x00db:
            java.lang.String r1 = r1.getDst()     // Catch:{ Exception -> 0x0053 }
        L_0x00df:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0053 }
            r11.<init>()     // Catch:{ Exception -> 0x0053 }
            r11.append(r10)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r10 = "&##&"
            r11.append(r10)     // Catch:{ Exception -> 0x0053 }
            r11.append(r1)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r10 = r11.toString()     // Catch:{ Exception -> 0x0053 }
            goto L_0x0114
        L_0x00f4:
            java.lang.Object r10 = r1.get(r3)     // Catch:{ Exception -> 0x0053 }
            com.upuphone.ar.translation.phone.bean.NoteDetailBean r10 = (com.upuphone.ar.translation.phone.bean.NoteDetailBean) r10     // Catch:{ Exception -> 0x0053 }
            java.lang.String r1 = r10.getDst()     // Catch:{ Exception -> 0x0053 }
            int r1 = r1.length()     // Catch:{ Exception -> 0x0053 }
            if (r1 <= r2) goto L_0x0110
            java.lang.String r10 = r10.getDst()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r10 = r10.substring(r3, r2)     // Catch:{ Exception -> 0x0053 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0114
        L_0x0110:
            java.lang.String r10 = r10.getDst()     // Catch:{ Exception -> 0x0053 }
        L_0x0114:
            return r10
        L_0x0115:
            return r0
        L_0x0116:
            java.lang.String r10 = kotlin.ExceptionsKt.stackTraceToString(r10)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "getTitle error="
            r11.append(r1)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            java.lang.String r11 = "NoteBeanExt"
            com.upuphone.ar.translation.ext.LogExt.g(r10, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.bean.NoteBeanExtKt.getDialogueNoteBeanContent(java.lang.String, java.lang.String):java.lang.String");
    }

    private static final String getNoteBeanContent(String str, String str2) {
        Class<TransRecord> cls = TransRecord.class;
        try {
            List b = GsonUtils.b(str, cls);
            List b2 = GsonUtils.b(str2, cls);
            if (!b.isEmpty()) {
                if (!b2.isEmpty()) {
                    String pContent = ((TransRecord) b.get(0)).getPContent();
                    if (!StringsKt.isBlank(pContent)) {
                        return pContent;
                    }
                    TransRecord transRecord = (TransRecord) b2.get(0);
                    String rContentIndex = transRecord.getRContentIndex();
                    String rContent = transRecord.getRContent();
                    return (!(StringsKt.isBlank(rContentIndex) ^ true) || !JsonUtils.b(rContentIndex)) ? rContent : getUpdatedNoteBeanContent(rContent, GsonUtils.b(rContentIndex, TransRecordIndex.class));
                }
            }
            return "";
        } catch (Exception e) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            LogExt.g("getTitle error=" + stackTraceToString, TAG);
            return "";
        }
    }

    private static final String getUpdatedNoteBeanContent(String str, List<TransRecordIndex> list) {
        int i;
        int i2;
        int length = str.length();
        String str2 = "";
        int i3 = 0;
        String str3 = str2;
        for (TransRecordIndex next : list) {
            int i4 = i3 + 1;
            if (i3 != CollectionsKt.getLastIndex(list)) {
                i2 = next.getStartIndex();
                i = list.get(i4).getStartIndex();
            } else {
                i2 = next.getStartIndex();
                i = length;
            }
            if (i2 + 1 <= i && i <= length) {
                String substring = str.substring(i2, i);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                if (next.getRecordType() != 0) {
                    str3 = substring;
                } else if (StringsKt.isBlank(str2)) {
                    str2 = substring;
                }
            }
            if (!StringsKt.isBlank(str3)) {
                break;
            }
            i3 = i4;
        }
        String removeWhitespace = removeWhitespace(str3);
        return StringsKt.isBlank(removeWhitespace) ? removeWhitespace(str2) : removeWhitespace;
    }

    private static final String removeWhitespace(String str) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.trim((CharSequence) str).toString(), StringUtils.LF, "", false, 4, (Object) null), StringUtils.CR, "", false, 4, (Object) null);
    }
}
