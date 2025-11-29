package com.upuphone.ar.transcribe.utils;

import android.content.Context;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0010*\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/transcribe/utils/LanguageUtils;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "isAir", "isIntlVersion", "Lcom/upuphone/ar/transcribe/utils/LanguageUtils$StoredLanguage;", "b", "(Landroid/content/Context;ZZ)Lcom/upuphone/ar/transcribe/utils/LanguageUtils$StoredLanguage;", "", "languageType", "a", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "", "d", "(Landroid/content/Context;)Ljava/util/Map;", "StoredLanguage", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LanguageUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final LanguageUtils f6187a = new LanguageUtils();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/transcribe/utils/LanguageUtils$StoredLanguage;", "", "", "transcribeSrc", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class StoredLanguage {

        /* renamed from: a  reason: collision with root package name */
        public final String f6188a;

        public StoredLanguage(String str) {
            Intrinsics.checkNotNullParameter(str, "transcribeSrc");
            this.f6188a = str;
        }

        public final String a() {
            return this.f6188a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StoredLanguage) && Intrinsics.areEqual((Object) this.f6188a, (Object) ((StoredLanguage) obj).f6188a);
        }

        public int hashCode() {
            return this.f6188a.hashCode();
        }

        public String toString() {
            String str = this.f6188a;
            return "StoredLanguage(transcribeSrc=" + str + ")";
        }
    }

    public static final String a(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "languageType");
        Map d = f6187a.d(context);
        if (d.isEmpty()) {
            String string = context.getString(R.string.trsb_simultaneous_cn);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        for (Map.Entry entry : d.entrySet()) {
            String str2 = (String) entry.getValue();
            if (Intrinsics.areEqual((Object) str, (Object) (String) entry.getKey())) {
                return str2;
            }
        }
        String string2 = context.getString(R.string.trsb_simultaneous_cn);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    public static final StoredLanguage b(Context context, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new StoredLanguage(PreferencesUtils.c(context, z, z2));
    }

    public static /* synthetic */ StoredLanguage c(Context context, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = TranscribeConstants.g();
        }
        if ((i & 4) != 0) {
            z2 = TranscribeConstants.f6027a.m();
        }
        return b(context, z, z2);
    }

    public final Map d(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("cn", context.getString(R.string.trsb_simultaneous_cn));
        hashMap.put("cnen", context.getString(R.string.trsb_simultaneous_en));
        hashMap.put("en", context.getString(R.string.trsb_simultaneous_en));
        hashMap.put("ja", context.getString(R.string.trsb_simultaneous_ja));
        hashMap.put("ko", context.getString(R.string.trsb_simultaneous_ko));
        hashMap.put("ru", context.getString(R.string.trsb_simultaneous_ru));
        hashMap.put("fr", context.getString(R.string.trsb_simultaneous_fr));
        hashMap.put("es", context.getString(R.string.trsb_simultaneous_es));
        hashMap.put("vi", context.getString(R.string.trsb_simultaneous_vi));
        hashMap.put("ms", context.getString(R.string.trsb_simultaneous_ms));
        hashMap.put("th", context.getString(R.string.trsb_simultaneous_th));
        hashMap.put("id", context.getString(R.string.trsb_simultaneous_id));
        hashMap.put("de", context.getString(R.string.tl_simultaneous_de));
        hashMap.put("tr", context.getString(R.string.tl_simultaneous_tr));
        hashMap.put("ar", context.getString(R.string.tl_simultaneous_ar));
        return hashMap;
    }
}
