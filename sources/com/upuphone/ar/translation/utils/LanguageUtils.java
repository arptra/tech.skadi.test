package com.upuphone.ar.translation.utils;

import android.content.Context;
import com.upuphone.ar.translation.constants.GlassVersionHelper;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.phone.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0010*\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0002¢\u0006\u0004\b\u0014\u0010\u000fJ\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0002¢\u0006\u0004\b\u0015\u0010\u000fJ\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/translation/utils/LanguageUtils;", "", "<init>", "()V", "Lcom/upuphone/ar/translation/utils/LanguageUtils$StoredLanguage;", "g", "()Lcom/upuphone/ar/translation/utils/LanguageUtils$StoredLanguage;", "Landroid/content/Context;", "context", "", "languageType", "e", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "", "d", "()Ljava/util/List;", "", "h", "(Landroid/content/Context;)Ljava/util/Map;", "a", "b", "f", "", "c", "StoredLanguage", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LanguageUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final LanguageUtils f6366a = new LanguageUtils();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0017\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/translation/utils/LanguageUtils$StoredLanguage;", "", "", "simulTransSrc", "simulTransDst", "dialogTransSrc", "dialogTransDst", "transcribeSrc", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "d", "b", "c", "e", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class StoredLanguage {

        /* renamed from: a  reason: collision with root package name */
        public final String f6367a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;

        public StoredLanguage(String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "simulTransSrc");
            Intrinsics.checkNotNullParameter(str2, "simulTransDst");
            Intrinsics.checkNotNullParameter(str3, "dialogTransSrc");
            Intrinsics.checkNotNullParameter(str4, "dialogTransDst");
            Intrinsics.checkNotNullParameter(str5, "transcribeSrc");
            this.f6367a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
        }

        public final String a() {
            return this.d;
        }

        public final String b() {
            return this.c;
        }

        public final String c() {
            return this.b;
        }

        public final String d() {
            return this.f6367a;
        }

        public final String e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StoredLanguage)) {
                return false;
            }
            StoredLanguage storedLanguage = (StoredLanguage) obj;
            return Intrinsics.areEqual((Object) this.f6367a, (Object) storedLanguage.f6367a) && Intrinsics.areEqual((Object) this.b, (Object) storedLanguage.b) && Intrinsics.areEqual((Object) this.c, (Object) storedLanguage.c) && Intrinsics.areEqual((Object) this.d, (Object) storedLanguage.d) && Intrinsics.areEqual((Object) this.e, (Object) storedLanguage.e);
        }

        public int hashCode() {
            return (((((((this.f6367a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            String str = this.f6367a;
            String str2 = this.b;
            String str3 = this.c;
            String str4 = this.d;
            String str5 = this.e;
            return "StoredLanguage(simulTransSrc=" + str + ", simulTransDst=" + str2 + ", dialogTransSrc=" + str3 + ", dialogTransDst=" + str4 + ", transcribeSrc=" + str5 + ")";
        }
    }

    public static final String e(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "languageType");
        Map h = f6366a.h(context);
        if (h.isEmpty()) {
            String string = context.getString(R.string.tl_simultaneous_cn);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        for (Map.Entry entry : h.entrySet()) {
            String str2 = (String) entry.getValue();
            if (Intrinsics.areEqual((Object) str, (Object) (String) entry.getKey())) {
                return str2;
            }
        }
        String string2 = context.getString(R.string.tl_simultaneous_cn);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1) != false) goto L_0x0015;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.upuphone.ar.translation.utils.LanguageUtils.StoredLanguage g() {
        /*
            java.lang.String r0 = com.upuphone.ar.translation.constants.TranslatorConstants.getDefaultLanguage()
            boolean r1 = com.upuphone.ar.translation.constants.TranslatorConstants.isIntlVersion()
            java.lang.String r2 = "cnen"
            if (r1 == 0) goto L_0x0017
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0015
            java.lang.String r1 = "fr"
            goto L_0x0020
        L_0x0015:
            r1 = r2
            goto L_0x0020
        L_0x0017:
            java.lang.String r1 = "cn"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r3 == 0) goto L_0x0020
            goto L_0x0015
        L_0x0020:
            com.upuphone.ar.translation.utils.LanguageUtils r3 = f6366a
            java.util.List r3 = r3.d()
            java.lang.String r4 = com.upuphone.ar.translation.utils.PreferencesUtils.d()
            java.lang.String r5 = "&&"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            java.util.List r4 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r4, (java.lang.String[]) r5, (boolean) r6, (int) r7, (int) r8, (java.lang.Object) r9)
            r5 = 0
            java.lang.Object r5 = r4.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            r6 = 1
            java.lang.Object r6 = r4.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            r7 = 2
            java.lang.Object r7 = r4.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            r8 = 3
            java.lang.Object r8 = r4.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            r9 = 4
            java.lang.Object r4 = r4.get(r9)
            java.lang.String r4 = (java.lang.String) r4
            boolean r9 = r3.contains(r5)
            if (r9 == 0) goto L_0x006b
            boolean r9 = r3.contains(r6)
            if (r9 != 0) goto L_0x0068
            goto L_0x006b
        L_0x0068:
            r11 = r5
            r12 = r6
            goto L_0x006d
        L_0x006b:
            r12 = r0
            r11 = r1
        L_0x006d:
            boolean r5 = r3.contains(r11)
            if (r5 == 0) goto L_0x007d
            boolean r5 = r3.contains(r12)
            if (r5 != 0) goto L_0x007a
            goto L_0x007d
        L_0x007a:
            r13 = r7
            r14 = r8
            goto L_0x007f
        L_0x007d:
            r14 = r0
            r13 = r1
        L_0x007f:
            boolean r1 = r3.contains(r4)
            if (r1 != 0) goto L_0x008f
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x008d
            java.lang.String r0 = "en"
        L_0x008d:
            r15 = r0
            goto L_0x0090
        L_0x008f:
            r15 = r4
        L_0x0090:
            com.upuphone.ar.translation.utils.LanguageUtils$StoredLanguage r0 = new com.upuphone.ar.translation.utils.LanguageUtils$StoredLanguage
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.utils.LanguageUtils.g():com.upuphone.ar.translation.utils.LanguageUtils$StoredLanguage");
    }

    public final List a() {
        if (!TranslatorConstants.isIntlVersion()) {
            return c();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("cn");
        arrayList.add("cnen");
        arrayList.add("en");
        arrayList.add("ms");
        GlassVersionHelper glassVersionHelper = GlassVersionHelper.INSTANCE;
        if (glassVersionHelper.isIntlOta1ForAir()) {
            arrayList.add("ja");
            arrayList.add("ru");
            arrayList.add("fr");
            arrayList.add("es");
            arrayList.add("vi");
            arrayList.add("th");
            arrayList.add("id");
        }
        if (glassVersionHelper.isIntlOta3ForAir()) {
            arrayList.add("it");
            arrayList.add("de");
            arrayList.add("tr");
        }
        return arrayList;
    }

    public final List b() {
        List c = c();
        c.add("ms");
        c.add("th");
        c.add("id");
        c.add("ko");
        c.add("it");
        c.add("de");
        c.add("ar");
        return c;
    }

    public final List c() {
        return CollectionsKt.arrayListOf("cn", "cnen", "en", "ja", "fr", "ru", "es", "vi");
    }

    public final List d() {
        return TranslatorConstants.isAir() ? a() : TranslatorConstants.isAirPro() ? b() : f();
    }

    public final List f() {
        List c = c();
        c.add("ko");
        return c;
    }

    public final Map h(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("cn", context.getString(R.string.tl_simultaneous_cn));
        hashMap.put("cnen", context.getString(R.string.tl_simultaneous_en));
        hashMap.put("en", context.getString(R.string.tl_simultaneous_en));
        hashMap.put("ja", context.getString(R.string.tl_simultaneous_ja));
        hashMap.put("ko", context.getString(R.string.tl_simultaneous_ko));
        hashMap.put("ru", context.getString(R.string.tl_simultaneous_ru));
        hashMap.put("fr", context.getString(R.string.tl_simultaneous_fr));
        hashMap.put("es", context.getString(R.string.tl_simultaneous_es));
        hashMap.put("vi", context.getString(R.string.tl_simultaneous_vi));
        hashMap.put("ms", context.getString(R.string.tl_simultaneous_ms));
        hashMap.put("th", context.getString(R.string.tl_simultaneous_th));
        hashMap.put("id", context.getString(R.string.tl_simultaneous_id));
        hashMap.put("it", context.getString(R.string.tl_simultaneous_it));
        hashMap.put("de", context.getString(R.string.tl_simultaneous_de));
        hashMap.put("ar", context.getString(R.string.tl_simultaneous_ar));
        hashMap.put("tr", context.getString(R.string.tl_simultaneous_tr));
        return hashMap;
    }
}
