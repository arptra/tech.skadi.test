package com.upuphone.ar.transcribe.phone.bean;

import android.text.SpannableStringBuilder;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.ext.StringExtKt;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.utils.GsonUtils;
import com.upuphone.ar.transcribe.utils.JsonUtils;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"TAG", "", "getAirRecordContent", "src", "assembleTitle", "", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "ar-transcribe_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTranscribeStoreExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeStoreExt.kt\ncom/upuphone/ar/transcribe/phone/bean/TranscribeStoreExtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,54:1\n1#2:55\n*E\n"})
public final class TranscribeStoreExtKt {
    @NotNull
    private static final String TAG = "NoteBeanExt";

    public static final void assembleTitle(@NotNull TranscribeBean transcribeBean) {
        Intrinsics.checkNotNullParameter(transcribeBean, "<this>");
        String transResult = transcribeBean.getTransResult();
        if (transResult != null && !StringsKt.isBlank(transResult)) {
            String transResult2 = transcribeBean.getTransResult();
            Intrinsics.checkNotNull(transResult2);
            if (JsonUtils.a(transResult2)) {
                try {
                    String transResult3 = transcribeBean.getTransResult();
                    Intrinsics.checkNotNull(transResult3);
                    List b = GsonUtils.b(transResult3, TransRecord.class);
                    if (!b.isEmpty()) {
                        if (transcribeBean.getType() == 1) {
                            String pContent = ((TransRecord) b.get(0)).getPContent();
                            if (pContent.length() == 0) {
                                pContent = ((TransRecord) b.get(0)).getRContent();
                            }
                            transcribeBean.setTitle(pContent);
                            return;
                        }
                        String rContent = ((TransRecord) b.get(0)).getRContent();
                        if (StringsKt.isBlank(rContent)) {
                            rContent = ((TransRecord) b.get(0)).getPContent();
                        }
                        transcribeBean.setTitle(rContent);
                        if (b.size() > 1) {
                            String rContent2 = ((TransRecord) b.get(1)).getRContent();
                            if (StringsKt.isBlank(rContent2)) {
                                rContent2 = ((TransRecord) b.get(1)).getRContent();
                            }
                            transcribeBean.setTitle2(rContent2);
                        }
                    }
                } catch (Exception e) {
                    String stackTraceToString = ExceptionsKt.stackTraceToString(e);
                    LogExt.d("getTitle error=" + stackTraceToString, TAG);
                }
            }
        }
    }

    @NotNull
    public static final String getAirRecordContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "src");
        List b = GsonUtils.b(str, TransRecord.class);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            TransRecord transRecord = (TransRecord) b.get(i);
            if (i != CollectionsKt.getLastIndex(b)) {
                spannableStringBuilder.append(StringExtKt.a(transRecord.getRContent())).append(StringUtils.LF);
            } else {
                spannableStringBuilder.append(StringExtKt.a(transRecord.getRContent()));
            }
        }
        String spannableStringBuilder2 = spannableStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "toString(...)");
        return spannableStringBuilder2;
    }
}
