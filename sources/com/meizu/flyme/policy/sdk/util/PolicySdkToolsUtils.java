package com.meizu.flyme.policy.sdk.util;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.flyme.xjfms.ums.sign.jdk.dto.SignDTO;
import com.flyme.xjfms.ums.sign.jdk.service.SignServiceImpl;
import com.meizu.common.util.LunarCalendar;
import com.meizu.net.pedometerprovider.util.Constants;
import flyme.support.v7.permission.Permission;
import flyme.support.v7.permission.PermissionGroup;
import flyme.support.v7.permission.PermissionManager;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/meizu/flyme/policy/sdk/util/PolicySdkToolsUtils;", "", "()V", "Companion", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolicySdkToolsUtils {
    @NotNull
    private static final String AREA_AE = "AE";
    @NotNull
    private static final String AREA_HK = "HK";
    @NotNull
    private static final String AREA_MY = "MY";
    @NotNull
    private static final String AREA_SA = "SA";
    @NotNull
    private static final String AREA_TH = "TH";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String KEY_COUNTRY_SETTING = "mz_region";
    @NotNull
    private static final String LANGUAGE_HK = "zh_HK";
    @NotNull
    private static final String LANGUAGE_MY = "ms_MY";
    @NotNull
    private static final String LANGUAGE_SA = "ar_EG";
    @NotNull
    private static final String LANGUAGE_TH = "th_TH";
    @NotNull
    private static final String PREMISSION_INTERNET = "android.permission.INTERNET";
    @NotNull
    private static final String PREMISSION_INTERNET_ACCESS = "android.permission.ACCESS_NETWORK_STATE";
    @NotNull
    private static final String PREMISSION_INTERNET_CHANGE = "android.permission.CHANGE_NETWORK_STATE";
    @NotNull
    private static final String PREMISSION_INTERNET_GROUP = "meizu.permission-group.NETWORK";
    @NotNull
    private static final String PROPERTY_PRODUCT_REGION = "ro.product.locale.region";

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004J\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eJ'\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040 2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040 ¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\u0004J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010)\u001a\u00020\u0004J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0004H\u0002J\u0016\u0010+\u001a\u00020,2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.J\u0010\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/meizu/flyme/policy/sdk/util/PolicySdkToolsUtils$Companion;", "", "()V", "AREA_AE", "", "AREA_HK", "AREA_MY", "AREA_SA", "AREA_TH", "KEY_COUNTRY_SETTING", "LANGUAGE_HK", "LANGUAGE_MY", "LANGUAGE_SA", "LANGUAGE_TH", "PREMISSION_INTERNET", "PREMISSION_INTERNET_ACCESS", "PREMISSION_INTERNET_CHANGE", "PREMISSION_INTERNET_GROUP", "PROPERTY_PRODUCT_REGION", "checkPolicyCategoryIsSame", "", "path", "policyCategory", "getAppSign", "appId", "appSecret", "reqTime", "", "getCurrentCountryCode", "context", "Landroid/content/Context;", "getCustomPermissionKey", "", "permissionKey", "(Landroid/content/Context;[Ljava/lang/String;)[Ljava/lang/String;", "getDefaultCode", "getDeviceBrand", "getLanguage", "getLanguageByArea", "area", "getSystemModel", "getSystemVersion", "isNetWorkPermission", "startBrowser", "", "uri", "Landroid/net/Uri;", "toUpperCaseFirstOne", "str", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        private final String getDefaultCode(Context context) {
            String str = SysProp.get("ro.product.locale", "zh-CN");
            Intrinsics.checkNotNullExpressionValue(str, "get(\"ro.product.locale\", \"zh-CN\")");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String upperCase = str.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            Object[] array = StringsKt.split$default((CharSequence) upperCase, new String[]{LunarCalendar.DATE_SEPARATOR}, false, 0, 6, (Object) null).toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            return (strArr == null || strArr.length <= 1) ? Constants.CHINA_COUNTRY : strArr[1];
        }

        private final boolean isNetWorkPermission(String str) {
            return Intrinsics.areEqual((Object) "meizu.permission-group.NETWORK", (Object) str) || Intrinsics.areEqual((Object) PolicySdkToolsUtils.PREMISSION_INTERNET, (Object) str) || Intrinsics.areEqual((Object) PolicySdkToolsUtils.PREMISSION_INTERNET_CHANGE, (Object) str) || Intrinsics.areEqual((Object) PolicySdkToolsUtils.PREMISSION_INTERNET_ACCESS, (Object) str);
        }

        private final String toUpperCaseFirstOne(String str) {
            if (Character.isUpperCase(str.charAt(0))) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(Character.toUpperCase(str.charAt(0)));
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "{\n                String….toString()\n            }");
            return sb2;
        }

        public final boolean checkPolicyCategoryIsSame(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "path");
            Intrinsics.checkNotNullParameter(str2, "policyCategory");
            return StringsKt.contains$default((CharSequence) str, (CharSequence) str2, false, 2, (Object) null);
        }

        @NotNull
        public final String getAppSign(@NotNull String str, @NotNull String str2, long j) {
            Intrinsics.checkNotNullParameter(str, "appId");
            Intrinsics.checkNotNullParameter(str2, "appSecret");
            String a2 = new SignServiceImpl().a(new SignDTO(str, str2, Long.valueOf(j)));
            Intrinsics.checkNotNullExpressionValue(a2, "md5");
            return a2;
        }

        @NotNull
        public final String getCurrentCountryCode(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = Settings.System.getString(context.getContentResolver(), PolicySdkToolsUtils.KEY_COUNTRY_SETTING);
            if (TextUtils.isEmpty(string)) {
                string = getDefaultCode(context);
            }
            if (Intrinsics.areEqual((Object) string, (Object) PolicySdkToolsUtils.AREA_AE)) {
                string = "SA";
            }
            Intrinsics.checkNotNullExpressionValue(string, "area");
            return string;
        }

        @NotNull
        public final String[] getCustomPermissionKey(@NotNull Context context, @NotNull String[] strArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(strArr, "permissionKey");
            try {
                PolicySdkLogUtils.Companion.d("getCustomPermissionKey", Intrinsics.stringPlus("language = ", Locale.getDefault().getLanguage()));
                String language = Locale.getDefault().getLanguage();
                Intrinsics.checkNotNullExpressionValue(language, "getDefault().language");
                int i = 0;
                if (StringsKt.contains$default((CharSequence) language, (CharSequence) "en", false, 2, (Object) null)) {
                    List<PermissionGroup> allPermissions = PermissionManager.getInstance(context).getAllPermissions();
                    int length = strArr.length;
                    while (i < length) {
                        int i2 = i + 1;
                        for (PermissionGroup next : allPermissions) {
                            if (!Intrinsics.areEqual((Object) strArr[i], (Object) next.getIdentifier())) {
                                for (Permission next2 : next.getSubPermission()) {
                                    if (Intrinsics.areEqual((Object) strArr[i], (Object) next2.getIdentifier()) && !isNetWorkPermission(strArr[i])) {
                                        String displayName = next2.getDisplayName(context);
                                        Intrinsics.checkNotNullExpressionValue(displayName, "getSubPermission.getDisp…                        )");
                                        strArr[i] = toUpperCaseFirstOne(displayName);
                                    }
                                }
                            } else if (!isNetWorkPermission(strArr[i])) {
                                String displayName2 = next.getDisplayName(context);
                                Intrinsics.checkNotNullExpressionValue(displayName2, "getPermissionGroup.getDi…                        )");
                                strArr[i] = toUpperCaseFirstOne(displayName2);
                            }
                        }
                        i = i2;
                    }
                }
                return strArr;
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable unused) {
            }
            return strArr;
        }

        @NotNull
        public final String getDeviceBrand() {
            String str = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(str, "BRAND");
            return str;
        }

        @NotNull
        public final String getLanguage() {
            StringBuilder sb = new StringBuilder();
            String language = Locale.getDefault().getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "getDefault().language");
            String lowerCase = language.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            sb.append(lowerCase);
            sb.append('_');
            String country = Locale.getDefault().getCountry();
            Intrinsics.checkNotNullExpressionValue(country, "getDefault().country");
            String upperCase = country.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
            sb.append(upperCase);
            return sb.toString();
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x004b A[ORIG_RETURN, RETURN, SYNTHETIC] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String getLanguageByArea(@org.jetbrains.annotations.NotNull java.lang.String r2) {
            /*
                r1 = this;
                java.lang.String r1 = "area"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
                int r1 = r2.hashCode()
                r0 = 2084(0x824, float:2.92E-42)
                if (r1 == r0) goto L_0x0048
                r0 = 2307(0x903, float:3.233E-42)
                if (r1 == r0) goto L_0x003c
                r0 = 2476(0x9ac, float:3.47E-42)
                if (r1 == r0) goto L_0x0030
                r0 = 2638(0xa4e, float:3.697E-42)
                if (r1 == r0) goto L_0x002a
                r0 = 2676(0xa74, float:3.75E-42)
                if (r1 == r0) goto L_0x001e
                goto L_0x004b
            L_0x001e:
                java.lang.String r1 = "TH"
                boolean r1 = r2.equals(r1)
                if (r1 != 0) goto L_0x0027
                goto L_0x004b
            L_0x0027:
                java.lang.String r1 = "th_TH"
                goto L_0x004d
            L_0x002a:
                java.lang.String r1 = "SA"
            L_0x002c:
                r2.equals(r1)
                goto L_0x004b
            L_0x0030:
                java.lang.String r1 = "MY"
                boolean r1 = r2.equals(r1)
                if (r1 != 0) goto L_0x0039
                goto L_0x004b
            L_0x0039:
                java.lang.String r1 = "ms_MY"
                goto L_0x004d
            L_0x003c:
                java.lang.String r1 = "HK"
                boolean r1 = r2.equals(r1)
                if (r1 != 0) goto L_0x0045
                goto L_0x004b
            L_0x0045:
                java.lang.String r1 = "zh_HK"
                goto L_0x004d
            L_0x0048:
                java.lang.String r1 = "AE"
                goto L_0x002c
            L_0x004b:
                java.lang.String r1 = "ar_EG"
            L_0x004d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.policy.sdk.util.PolicySdkToolsUtils.Companion.getLanguageByArea(java.lang.String):java.lang.String");
        }

        @NotNull
        public final String getSystemModel() {
            String str = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(str, "MODEL");
            return str;
        }

        @NotNull
        public final String getSystemVersion() {
            String str = Build.VERSION.RELEASE;
            Intrinsics.checkNotNullExpressionValue(str, "RELEASE");
            return str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x002e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void startBrowser(@org.jetbrains.annotations.NotNull android.content.Context r6, @org.jetbrains.annotations.NotNull android.net.Uri r7) {
            /*
                r5 = this;
                java.lang.String r5 = "android.intent.action.VIEW"
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "uri"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                java.lang.String r0 = "url = "
                java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r7)
                java.lang.String r1 = "startBrowser"
                android.util.Log.d(r1, r0)
                r0 = 1
                r2 = 268435456(0x10000000, float:2.5243549E-29)
                android.content.Intent r3 = new android.content.Intent     // Catch:{ Exception -> 0x002e }
                r3.<init>(r5, r7)     // Catch:{ Exception -> 0x002e }
                r3.addFlags(r2)     // Catch:{ Exception -> 0x002e }
                r3.addFlags(r0)     // Catch:{ Exception -> 0x002e }
                java.lang.String r4 = "com.android.browser"
                r3.setPackage(r4)     // Catch:{ Exception -> 0x002e }
                r6.startActivity(r3)     // Catch:{ Exception -> 0x002e }
                goto L_0x004b
            L_0x002e:
                android.content.Intent r3 = new android.content.Intent     // Catch:{ Exception -> 0x003d }
                r3.<init>(r5, r7)     // Catch:{ Exception -> 0x003d }
                r3.addFlags(r2)     // Catch:{ Exception -> 0x003d }
                r3.addFlags(r0)     // Catch:{ Exception -> 0x003d }
                r6.startActivity(r3)     // Catch:{ Exception -> 0x003d }
                goto L_0x004b
            L_0x003d:
                r5 = move-exception
                java.lang.String r5 = r5.getMessage()
                java.lang.String r6 = "startBrowser: Exception"
                java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r5)
                android.util.Log.e(r1, r5)
            L_0x004b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.policy.sdk.util.PolicySdkToolsUtils.Companion.startBrowser(android.content.Context, android.net.Uri):void");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
