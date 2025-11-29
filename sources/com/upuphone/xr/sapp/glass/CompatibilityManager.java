package com.upuphone.xr.sapp.glass;

import android.content.Context;
import android.os.Build;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u00011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u001c\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010#\u001a\u00020\u0015H\u0002J\b\u0010$\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0015H\u0002J\u000e\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\u001eJ\u000e\u0010,\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0015J\u0010\u0010-\u001a\u00020(2\u0006\u0010#\u001a\u00020\u0015H\u0002J\u0010\u0010.\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0015H\u0002J\u000e\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020\u001eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0017X\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0017X\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0017X\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0017X\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u001c\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/upuphone/xr/sapp/glass/CompatibilityManager;", "", "()V", "DIALOG_ACTION", "", "DIALOG_CONTENT", "DIALOG_ID", "DIALOG_INTERACTION_PROMPT_TXT", "DIALOG_NOTIFICATION_ACTION", "DIALOG_SEND_PACKAGE", "DIALOG_TITLE", "NEED_FORCE_UPGRADE_VERSION", "", "NOTIFY_DATA", "TAG", "VERSION_DIALOG_ID", "application", "Lcom/upuphone/xr/sapp/MainApplication;", "getApplication", "()Lcom/upuphone/xr/sapp/MainApplication;", "checkResult", "Lcom/upuphone/xr/sapp/glass/CompatibilityManager$ConsultResult;", "compatibleVersion", "", "[Ljava/lang/Integer;", "compatibleVersionAir", "compatibleVersionAirIntl", "compatibleVersionStar", "currentVersion", "needForceUpgrade", "", "needRecheckOnResume", "consultWithGlass", "getTitleContent", "Lkotlin/Pair;", "data", "ignoreCheckUpdate", "isHardWareVendorMediaTek", "isHardWareVendorQcom", "sendIncompatibleMsg", "", "result", "showInCompatDialog", "isForcedUpgrade", "showIncompatibleDialog", "showIncompatibleDialogOnFirstEdition", "showIncompatibleDialogOnGlass", "showVersionDialogWhenResume", "isConnect", "ConsultResult", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCompatibilityManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompatibilityManager.kt\ncom/upuphone/xr/sapp/glass/CompatibilityManager\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,347:1\n37#2,2:348\n37#2,2:350\n37#2,2:352\n37#2,2:354\n*S KotlinDebug\n*F\n+ 1 CompatibilityManager.kt\ncom/upuphone/xr/sapp/glass/CompatibilityManager\n*L\n32#1:348,2\n34#1:350,2\n36#1:352,2\n38#1:354,2\n*E\n"})
public final class CompatibilityManager {
    @NotNull
    private static final String DIALOG_ACTION = "action";
    @NotNull
    private static final String DIALOG_CONTENT = "content";
    @NotNull
    private static final String DIALOG_ID = "id";
    @NotNull
    private static final String DIALOG_INTERACTION_PROMPT_TXT = "interactionPromptTxt";
    @NotNull
    private static final String DIALOG_NOTIFICATION_ACTION = "notificationAction";
    @NotNull
    private static final String DIALOG_SEND_PACKAGE = "sendPackage";
    @NotNull
    private static final String DIALOG_TITLE = "title";
    @NotNull
    public static final CompatibilityManager INSTANCE = new CompatibilityManager();
    private static final int NEED_FORCE_UPGRADE_VERSION = 4;
    @NotNull
    private static final String NOTIFY_DATA = "data";
    @NotNull
    private static final String TAG = "GlassCompatHelper";
    @NotNull
    private static final String VERSION_DIALOG_ID = "COMPATIBILITY_CHECK";
    @Nullable
    private static ConsultResult checkResult;
    @NotNull
    private static Integer[] compatibleVersion = ((Integer[]) CollectionsKt.toList(new IntRange(0, 0)).toArray(new Integer[0]));
    @NotNull
    private static final Integer[] compatibleVersionAir = ((Integer[]) CollectionsKt.toList(new IntRange(0, 6)).toArray(new Integer[0]));
    @NotNull
    private static final Integer[] compatibleVersionAirIntl = ((Integer[]) CollectionsKt.toList(new IntRange(0, 6)).toArray(new Integer[0]));
    @NotNull
    private static final Integer[] compatibleVersionStar = ((Integer[]) CollectionsKt.toList(new IntRange(0, 2)).toArray(new Integer[0]));
    /* access modifiers changed from: private */
    public static int currentVersion = -1;
    private static boolean needForceUpgrade;
    private static boolean needRecheckOnResume;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\b\u0010\u001b\u001a\u00020\u0007H\u0016R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/upuphone/xr/sapp/glass/CompatibilityManager$ConsultResult;", "", "isForcedUpgrade", "", "updateType", "", "versionCode", "", "title", "content", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "()Z", "getTitle", "getUpdateType", "()I", "getVersionCode", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ConsultResult {
        @NotNull
        private final String content;
        private final boolean isForcedUpgrade;
        @NotNull
        private final String title;
        private final int updateType;
        @NotNull
        private final String versionCode;

        public ConsultResult() {
            this(false, 0, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ConsultResult copy$default(ConsultResult consultResult, boolean z, int i, String str, String str2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = consultResult.isForcedUpgrade;
            }
            if ((i2 & 2) != 0) {
                i = consultResult.updateType;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                str = consultResult.versionCode;
            }
            String str4 = str;
            if ((i2 & 8) != 0) {
                str2 = consultResult.title;
            }
            String str5 = str2;
            if ((i2 & 16) != 0) {
                str3 = consultResult.content;
            }
            return consultResult.copy(z, i3, str4, str5, str3);
        }

        public final boolean component1() {
            return this.isForcedUpgrade;
        }

        public final int component2() {
            return this.updateType;
        }

        @NotNull
        public final String component3() {
            return this.versionCode;
        }

        @NotNull
        public final String component4() {
            return this.title;
        }

        @NotNull
        public final String component5() {
            return this.content;
        }

        @NotNull
        public final ConsultResult copy(boolean z, int i, @NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "versionCode");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, CompatibilityManager.DIALOG_CONTENT);
            return new ConsultResult(z, i, str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ConsultResult)) {
                return false;
            }
            ConsultResult consultResult = (ConsultResult) obj;
            return this.isForcedUpgrade == consultResult.isForcedUpgrade && this.updateType == consultResult.updateType && Intrinsics.areEqual((Object) this.versionCode, (Object) consultResult.versionCode) && Intrinsics.areEqual((Object) this.title, (Object) consultResult.title) && Intrinsics.areEqual((Object) this.content, (Object) consultResult.content);
        }

        @NotNull
        public final String getContent() {
            return this.content;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public final int getUpdateType() {
            return this.updateType;
        }

        @NotNull
        public final String getVersionCode() {
            return this.versionCode;
        }

        public int hashCode() {
            return (((((((Boolean.hashCode(this.isForcedUpgrade) * 31) + Integer.hashCode(this.updateType)) * 31) + this.versionCode.hashCode()) * 31) + this.title.hashCode()) * 31) + this.content.hashCode();
        }

        public final boolean isForcedUpgrade() {
            return this.isForcedUpgrade;
        }

        @NotNull
        public String toString() {
            boolean z = this.isForcedUpgrade;
            int i = this.updateType;
            String str = this.versionCode;
            return "ConsultResult(forceUpgrade=" + z + ", deviceType=" + i + ", versionCode='" + str + "')";
        }

        public ConsultResult(boolean z, int i, @NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "versionCode");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, CompatibilityManager.DIALOG_CONTENT);
            this.isForcedUpgrade = z;
            this.updateType = i;
            this.versionCode = str;
            this.title = str2;
            this.content = str3;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ ConsultResult(boolean r4, int r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
            /*
                r3 = this;
                r10 = r9 & 1
                if (r10 == 0) goto L_0x0005
                r4 = 0
            L_0x0005:
                r10 = r9 & 2
                if (r10 == 0) goto L_0x000a
                r5 = 1
            L_0x000a:
                r10 = r5
                r5 = r9 & 4
                java.lang.String r0 = ""
                if (r5 == 0) goto L_0x0013
                r1 = r0
                goto L_0x0014
            L_0x0013:
                r1 = r6
            L_0x0014:
                r5 = r9 & 8
                if (r5 == 0) goto L_0x001a
                r2 = r0
                goto L_0x001b
            L_0x001a:
                r2 = r7
            L_0x001b:
                r5 = r9 & 16
                if (r5 == 0) goto L_0x0020
                goto L_0x0021
            L_0x0020:
                r0 = r8
            L_0x0021:
                r5 = r3
                r6 = r4
                r7 = r10
                r8 = r1
                r9 = r2
                r10 = r0
                r5.<init>(r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.CompatibilityManager.ConsultResult.<init>(boolean, int, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    static {
        StarryMessageHelper.f7799a.d(AnonymousClass1.INSTANCE);
    }

    private CompatibilityManager() {
    }

    private final boolean consultWithGlass() {
        Integer[] numArr;
        DynamicAdapterUtils dynamicAdapterUtils = DynamicAdapterUtils.f7879a;
        if (ModelIdExtKt.a(dynamicAdapterUtils.a())) {
            Boolean bool = BuildConfig.f6575a;
            Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
            numArr = bool.booleanValue() ? compatibleVersionAirIntl : compatibleVersionAir;
        } else {
            numArr = compatibleVersionStar;
        }
        compatibleVersion = numArr;
        ULog.Delegate delegate = ULog.f6446a;
        int i = currentVersion;
        String arrays = Arrays.toString(compatibleVersion);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
        String a2 = dynamicAdapterUtils.a();
        delegate.g(TAG, "consultWithGlass  " + i + " " + arrays + " and model is " + a2);
        needForceUpgrade = currentVersion == 4 && isHardWareVendorMediaTek();
        if (currentVersion >= ((Number) ArraysKt.maxOrThrow((T[]) (Comparable[]) compatibleVersion)).intValue() || ignoreCheckUpdate()) {
            return true;
        }
        ConsultResult consultResult = new ConsultResult(needForceUpgrade, 2, (String) null, (String) null, (String) null, 28, (DefaultConstructorMarker) null);
        showIncompatibleDialog(consultResult);
        showIncompatibleDialogOnGlass(consultResult);
        return false;
    }

    private final MainApplication getApplication() {
        return MainApplication.k.f();
    }

    private final Pair<String, String> getTitleContent(ConsultResult consultResult) {
        String str;
        String str2;
        String L;
        String L2;
        int updateType = consultResult.getUpdateType();
        if (updateType == 1) {
            L = NaviUtil.L(getApplication().getApplicationContext(), R.string.app_upgrade);
            Intrinsics.checkNotNullExpressionValue(L, "getLocale(...)");
            Context applicationContext = getApplication().getApplicationContext();
            Boolean bool = BuildConfig.f6575a;
            Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
            L2 = NaviUtil.L(applicationContext, bool.booleanValue() ? R.string.app_upgrade_content_oversea : R.string.app_upgrade_content);
            Intrinsics.checkNotNullExpressionValue(L2, "getLocale(...)");
        } else if (updateType != 2) {
            str2 = "";
            str = str2;
            return new Pair<>(str2, str);
        } else {
            L = NaviUtil.L(getApplication().getApplicationContext(), R.string.glass_upgrade);
            Intrinsics.checkNotNullExpressionValue(L, "getLocale(...)");
            L2 = NaviUtil.L(getApplication().getApplicationContext(), R.string.glass_upgrade_content);
            Intrinsics.checkNotNullExpressionValue(L2, "getLocale(...)");
        }
        String str3 = L;
        str = L2;
        str2 = str3;
        return new Pair<>(str2, str);
    }

    private final boolean ignoreCheckUpdate() {
        int i;
        int i2;
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            return false;
        }
        Boolean bool2 = BuildConfig.b;
        if (bool2.booleanValue() || !((i2 = currentVersion) == 4 || i2 == 5 || i2 == 6)) {
            Intrinsics.checkNotNullExpressionValue(bool2, "THIRD_PLATFOM");
            if (!bool2.booleanValue() || !isHardWareVendorQcom() || ((i = currentVersion) != 4 && i != 5)) {
                return false;
            }
            ULog.f6446a.a(TAG, "qcom and glass version OTA3,4 no need update");
            return true;
        }
        ULog.f6446a.a(TAG, "flyme and glass version OTA3,4,5 no need update");
        return true;
    }

    private final boolean isHardWareVendorMediaTek() {
        String str = Build.HARDWARE;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "hardware is: " + str);
        Intrinsics.checkNotNull(str);
        if (!new Regex("mt[0-9]*").matches(str) && !PhoneTypeUtils.f7912a.k()) {
            return false;
        }
        delegate.a(TAG, "MediaTek platform");
        return true;
    }

    private final boolean isHardWareVendorQcom() {
        String str = Build.HARDWARE;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "hardware is: " + str);
        Intrinsics.checkNotNull(str);
        if (!new Regex("qcom").matches(str)) {
            return false;
        }
        delegate.a(TAG, "Qcom platform");
        return true;
    }

    private final void sendIncompatibleMsg(ConsultResult consultResult) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g(TAG, "sendIncompatibleMsg");
        Pair<String, String> titleContent = getTitleContent(consultResult);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("action", "show_version_no_match");
        jSONObject.put("updateType", consultResult.getUpdateType());
        jSONObject.put("isForcedUpgrade", consultResult.isForcedUpgrade());
        jSONObject.put("title", titleContent.component1());
        jSONObject.put(DIALOG_CONTENT, titleContent.component2());
        jSONObject2.put(AccountConstantKt.RESPONSE_VALUE, jSONObject);
        delegate.g(TAG, "sendIncompatibleMsg: " + jSONObject2);
        StarryMessageHelper starryMessageHelper = StarryMessageHelper.f7799a;
        String jSONObject3 = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "toString(...)");
        starryMessageHelper.k(jSONObject3, new CompatibilityManager$sendIncompatibleMsg$1());
    }

    private final void showIncompatibleDialogOnFirstEdition(ConsultResult consultResult) {
        ULog.f6446a.g(TAG, "showIncompatibleDialogOnFirstEdition");
        String L = NaviUtil.L(getApplication().getApplicationContext(), R.string.double_click_close);
        Pair<String, String> titleContent = getTitleContent(consultResult);
        String component1 = titleContent.component1();
        String component2 = titleContent.component2();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("title", component1);
            jSONObject3.put(DIALOG_CONTENT, component2);
            jSONObject3.put(DIALOG_SEND_PACKAGE, getApplication().getPackageName());
            jSONObject3.put("id", VERSION_DIALOG_ID);
            jSONObject3.put(DIALOG_INTERACTION_PROMPT_TXT, L);
            jSONObject2.put("data", jSONObject3);
            jSONObject2.put(DIALOG_NOTIFICATION_ACTION, "SHOW_DIALOG");
            jSONObject.put("data", jSONObject2);
            jSONObject.put("action", "notification");
            StarryMessageHelper starryMessageHelper = StarryMessageHelper.f7799a;
            String jSONObject4 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject4, "toString(...)");
            StarryMessageHelper.o(starryMessageHelper, jSONObject4, (SendMessageListener) null, 2, (Object) null);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c(TAG, "createDialogMessage error: " + e);
        }
    }

    private final void showIncompatibleDialogOnGlass(ConsultResult consultResult) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g(TAG, "showIncompatibleDialogOnGlass, result: " + consultResult);
        if (currentVersion < 3) {
            showIncompatibleDialogOnFirstEdition(consultResult);
        } else {
            sendIncompatibleMsg(consultResult);
        }
    }

    public final void showInCompatDialog(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "showInCompatDialog, isForcedUpgrade: " + z);
        ConsultResult consultResult = new ConsultResult(z, 2, (String) null, (String) null, (String) null, 28, (DefaultConstructorMarker) null);
        showIncompatibleDialog(consultResult);
        showIncompatibleDialogOnGlass(consultResult);
    }

    public final void showIncompatibleDialog(@NotNull ConsultResult consultResult) {
        int i;
        Intrinsics.checkNotNullParameter(consultResult, "result");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g(TAG, "showIncompatibleDialog, result: " + consultResult);
        if (getApplication().q().size() > 0) {
            int updateType = consultResult.getUpdateType();
            if (updateType == 1) {
                i = 180;
            } else if (updateType != 2) {
                delegate.c(TAG, "showIncompatibleDialog, update type error");
                return;
            } else {
                i = 179;
            }
            StaticMethodUtilsKt.P(getApplication(), i, consultResult, !consultResult.isForcedUpgrade(), false);
            needRecheckOnResume = false;
            return;
        }
        needRecheckOnResume = true;
        checkResult = consultResult;
    }

    public final void showVersionDialogWhenResume(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z2 = needRecheckOnResume;
        delegate.g(TAG, "needRecheck compatibility OnResume needRecheckOnResume = " + z2 + ", isConnect = " + z);
        GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
        boolean B0 = glassUpdateHelper.B0();
        delegate.g(TAG, "showVersionDialogWhenResume, glassRomReady: " + B0);
        if (!glassUpdateHelper.B0() || !needRecheckOnResume) {
            return;
        }
        if (!z) {
            checkResult = null;
            needRecheckOnResume = false;
        } else if (glassUpdateHelper.b1()) {
            StaticMethodUtilsKt.Q(getApplication(), 125, (Object) null, false, false, 2, (Object) null);
        } else {
            ConsultResult consultResult = checkResult;
            if (consultResult != null) {
                INSTANCE.showIncompatibleDialog(consultResult);
            }
        }
    }
}
