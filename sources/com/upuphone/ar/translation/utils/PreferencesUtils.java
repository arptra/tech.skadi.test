package com.upuphone.ar.translation.utils;

import com.upuphone.xr.sapp.context.DataStoreContext;
import com.upuphone.xr.sapp.context.SdkContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b!\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u000fJ\u000f\u0010\u0014\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001c\u0010\u0018J\u000f\u0010\u001d\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001d\u0010\u001aJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001f\u0010\u0018J\u000f\u0010 \u001a\u00020\u0015H\u0007¢\u0006\u0004\b \u0010\u001aJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0015H\u0007¢\u0006\u0004\b!\u0010\u0018J\u000f\u0010\"\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\"\u0010\u001aJ\u0017\u0010#\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0015H\u0007¢\u0006\u0004\b#\u0010\u0018J\u000f\u0010$\u001a\u00020\u0015H\u0007¢\u0006\u0004\b$\u0010\u001aJ\u0017\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0015H\u0007¢\u0006\u0004\b&\u0010\u0018J\u000f\u0010'\u001a\u00020\u0015H\u0007¢\u0006\u0004\b'\u0010\u001aJ\u0017\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0015H\u0007¢\u0006\u0004\b)\u0010\u0018J\u000f\u0010*\u001a\u00020\u0015H\u0007¢\u0006\u0004\b*\u0010\u001aJ\u0017\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0004H\u0007¢\u0006\u0004\b,\u0010\u000fJ\u000f\u0010-\u001a\u00020\u0004H\u0007¢\u0006\u0004\b-\u0010\u0011J\u0017\u0010/\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0004H\u0007¢\u0006\u0004\b/\u0010\u000fJ\u000f\u00100\u001a\u00020\u0004H\u0007¢\u0006\u0004\b0\u0010\u0011J\u0017\u00101\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0004H\u0007¢\u0006\u0004\b1\u0010\u000fJ\u000f\u00102\u001a\u00020\u0004H\u0007¢\u0006\u0004\b2\u0010\u0011J\u0015\u00104\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0015¢\u0006\u0004\b4\u0010\u0018J\r\u00105\u001a\u00020\u0015¢\u0006\u0004\b5\u0010\u001a¨\u00066"}, d2 = {"Lcom/upuphone/ar/translation/utils/PreferencesUtils;", "", "<init>", "()V", "", "transType", "", "src", "dst", "", "p", "(ILjava/lang/String;Ljava/lang/String;)V", "d", "()Ljava/lang/String;", "A", "(I)V", "m", "()I", "subtitleSetType", "B", "n", "", "isSync", "t", "(Z)V", "c", "()Z", "isOnlyOther", "s", "b", "isShow", "q", "e", "r", "f", "y", "k", "isShowLocation", "z", "l", "isShowTip", "x", "j", "audioContent", "w", "i", "audioType", "u", "g", "v", "h", "isSaved", "o", "a", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PreferencesUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final PreferencesUtils f6369a = new PreferencesUtils();

    public static final void A(int i) {
        SdkContext.f6675a.a().a("tl_trans_type", Integer.valueOf(i), true);
    }

    public static final void B(int i) {
        SdkContext.f6675a.a().a("tl_translate_model_type", Integer.valueOf(i), true);
    }

    public static final boolean b() {
        return ((Boolean) SdkContext.f6675a.a().b("tl_trans_show_only_other", Boolean.TRUE, true)).booleanValue();
    }

    public static final boolean c() {
        return ((Boolean) SdkContext.f6675a.a().b("tl_sync_to_phone_type", Boolean.TRUE, true)).booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2) != false) goto L_0x001b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String d() {
        /*
            com.upuphone.xr.sapp.context.SdkContext r0 = com.upuphone.xr.sapp.context.SdkContext.f6675a
            com.upuphone.xr.sapp.context.DataStoreContext r0 = r0.a()
            java.lang.String r1 = com.upuphone.ar.translation.constants.TranslatorConstants.getDefaultLanguage()
            boolean r2 = com.upuphone.ar.translation.constants.TranslatorConstants.isIntlVersion()
            java.lang.String r3 = "cnen"
            if (r2 == 0) goto L_0x001d
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x001b
            java.lang.String r2 = "fr"
            goto L_0x0026
        L_0x001b:
            r2 = r3
            goto L_0x0026
        L_0x001d:
            java.lang.String r2 = "cn"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r4 == 0) goto L_0x0026
            goto L_0x001b
        L_0x0026:
            java.lang.String r4 = "tl_simul_trans_src"
            r5 = 1
            java.lang.Object r4 = r0.b(r4, r2, r5)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r6 = "tl_simul_trans_dst"
            java.lang.Object r6 = r0.b(r6, r1, r5)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = "tl_dialog_trans_src"
            java.lang.Object r2 = r0.b(r7, r2, r5)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r7 = "tl_dialog_trans_dst"
            java.lang.Object r7 = r0.b(r7, r1, r5)
            java.lang.String r7 = (java.lang.String) r7
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0053
            java.lang.String r1 = "en"
        L_0x0053:
            java.lang.String r3 = "tl_transcribe_lang"
            java.lang.Object r0 = r0.b(r3, r1, r5)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r3 = "&&"
            r1.append(r3)
            r1.append(r6)
            r1.append(r3)
            r1.append(r2)
            r1.append(r3)
            r1.append(r7)
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.utils.PreferencesUtils.d():java.lang.String");
    }

    public static final boolean e() {
        return ((Boolean) SdkContext.f6675a.a().b("tl_trans_main_not_role_vprint", Boolean.TRUE, true)).booleanValue();
    }

    public static final boolean f() {
        return ((Boolean) SdkContext.f6675a.a().b("tl_trans_setting_not_role_vprint", Boolean.TRUE, true)).booleanValue();
    }

    public static final int g() {
        return ((Number) SdkContext.f6675a.a().b("tl_telephone_trans_broadcast_myself", 1, true)).intValue();
    }

    public static final int h() {
        return ((Number) SdkContext.f6675a.a().b("tl_telephone_trans_broadcast_other", 2, true)).intValue();
    }

    public static final int i() {
        return ((Number) SdkContext.f6675a.a().b("tl_telephone_trans_call_audio", 1, true)).intValue();
    }

    public static final boolean j() {
        return ((Boolean) SdkContext.f6675a.a().b("tl_telephone_trans_call_tip", Boolean.FALSE, true)).booleanValue();
    }

    public static final boolean k() {
        return ((Boolean) SdkContext.f6675a.a().b("tl_telephone_trans_user_tip", Boolean.TRUE, true)).booleanValue();
    }

    public static final boolean l() {
        return ((Boolean) SdkContext.f6675a.a().b("tl_trans_geo_location", Boolean.FALSE, true)).booleanValue();
    }

    public static final int m() {
        return ((Number) SdkContext.f6675a.a().b("tl_trans_type", 2, true)).intValue();
    }

    public static final int n() {
        return ((Number) SdkContext.f6675a.a().b("tl_translate_model_type", 4, true)).intValue();
    }

    public static final void p(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        DataStoreContext a2 = SdkContext.f6675a.a();
        if (i == 1) {
            a2.a("tl_transcribe_lang", str, true);
        } else if (i == 2) {
            a2.a("tl_simul_trans_src", str, true);
            a2.a("tl_simul_trans_dst", str2, true);
        } else if (i == 3) {
            a2.a("tl_dialog_trans_src", str, true);
            a2.a("tl_dialog_trans_dst", str2, true);
        }
    }

    public static final void q(boolean z) {
        SdkContext.f6675a.a().a("tl_trans_main_not_role_vprint", Boolean.valueOf(z), true);
    }

    public static final void r(boolean z) {
        SdkContext.f6675a.a().a("tl_trans_setting_not_role_vprint", Boolean.valueOf(z), true);
    }

    public static final void s(boolean z) {
        SdkContext.f6675a.a().a("tl_trans_show_only_other", Boolean.valueOf(z), true);
    }

    public static final void t(boolean z) {
        SdkContext.f6675a.a().a("tl_sync_to_phone_type", Boolean.valueOf(z), true);
    }

    public static final void u(int i) {
        SdkContext.f6675a.a().a("tl_telephone_trans_broadcast_myself", Integer.valueOf(i), true);
    }

    public static final void v(int i) {
        SdkContext.f6675a.a().a("tl_telephone_trans_broadcast_other", Integer.valueOf(i), true);
    }

    public static final void w(int i) {
        SdkContext.f6675a.a().a("tl_telephone_trans_call_audio", Integer.valueOf(i), true);
    }

    public static final void x(boolean z) {
        SdkContext.f6675a.a().a("tl_telephone_trans_call_tip", Boolean.valueOf(z), true);
    }

    public static final void y(boolean z) {
        SdkContext.f6675a.a().a("tl_telephone_trans_user_tip", Boolean.valueOf(z), true);
    }

    public static final void z(boolean z) {
        SdkContext.f6675a.a().a("tl_trans_geo_location", Boolean.valueOf(z), true);
    }

    public final boolean a() {
        return ((Boolean) SdkContext.f6675a.a().b("tl_first_save_record_to_translator", Boolean.FALSE, true)).booleanValue();
    }

    public final void o(boolean z) {
        SdkContext.f6675a.a().a("tl_first_save_record_to_translator", Boolean.valueOf(z), true);
    }
}
