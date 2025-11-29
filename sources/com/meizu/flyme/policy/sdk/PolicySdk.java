package com.meizu.flyme.policy.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.meizu.flyme.policy.sdk.activity.PolicyWebViewActivity;
import com.meizu.flyme.policy.sdk.bean.PolicySdkResultBean;
import com.meizu.flyme.policy.sdk.config.PolicySdkConstants;
import com.meizu.flyme.policy.sdk.config.PolicySdkErrorCode;
import com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils;
import com.meizu.flyme.policy.sdk.util.PolicySdkNetworkUtil;
import com.meizu.flyme.policy.sdk.util.PolicySdkToolsUtils;
import flyme.support.v7.app.AlertDialog;
import flyme.support.v7.app.PermissionDialogBuilder;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class PolicySdk {
    public static int CONTENT_TYPE_ALL = 3;
    public static int CONTENT_TYPE_MARKETING_PURPOSES = 1;
    public static int CONTENT_TYPE_NONE = 0;
    public static int CONTENT_TYPE_THIRD_DATA_SHARE = 2;

    public interface PolicyDefaultDialogOnClick {
        void setLeftOnClickListener();

        void setRightOnClickListener();
    }

    public interface PolicySdkCallback {
        void getResult(PolicySdkResultBean policySdkResultBean);
    }

    public class a implements PolicySdkCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Boolean f3187a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Bundle e;
        public final /* synthetic */ String f;
        public final /* synthetic */ PolicySdkCallback g;

        public a(Boolean bool, Context context, String str, String str2, Bundle bundle, String str3, PolicySdkCallback policySdkCallback) {
            this.f3187a = bool;
            this.b = context;
            this.c = str;
            this.d = str2;
            this.e = bundle;
            this.f = str3;
            this.g = policySdkCallback;
        }

        public void getResult(PolicySdkResultBean policySdkResultBean) {
            if (policySdkResultBean.getCode() == 0) {
                PolicySdkLogUtils.Companion.d("getOnlinePolicyMethod", policySdkResultBean.getPolicyUrl());
                if (this.f3187a.booleanValue()) {
                    PolicyWebViewActivity.Companion.a(this.b, policySdkResultBean.getPolicyUrl(), this.c);
                } else {
                    PolicySdkToolsUtils.Companion.startBrowser(this.b, Uri.parse(policySdkResultBean.getPolicyUrl()));
                }
            } else {
                PolicySdkLogUtils.Companion.d("getOnlinePolicyMethod", "getlocal getPolicyNewestPath");
                policySdkResultBean = PolicySdk.getPolicyNewestPath(this.b, this.d);
                if (policySdkResultBean.getCode() == 0) {
                    PolicySdk.openPolicyByMethod(this.b, this.f3187a, this.c, this.d);
                } else if (policySdkResultBean.getCode() == -10004 && this.f3187a.booleanValue()) {
                    this.e.putString(PolicySdkConstants.BUNDLE_KEY_LANGUAGE, this.f);
                    this.e.putString(PolicySdkConstants.BUNDLE_KEY_CATEGORY, this.d);
                    this.e.putLong(PolicySdkConstants.BUNDLE_KEY_VERSION, 0);
                    this.e.putInt(PolicySdkConstants.ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY, PolicySdkErrorCode.NETWORK_ERROR);
                    PolicyWebViewActivity.Companion.a(this.b, PolicySdkConstants.ONLINE_POLICY_WEB_VIEW, this.c);
                }
            }
            PolicySdkCallback policySdkCallback = this.g;
            if (policySdkCallback != null) {
                policySdkCallback.getResult(policySdkResultBean);
            }
        }
    }

    public class b implements PolicySdkCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3188a;
        public final /* synthetic */ PolicySdkCallback b;

        public b(Context context, PolicySdkCallback policySdkCallback) {
            this.f3188a = context;
            this.b = policySdkCallback;
        }

        public void getResult(PolicySdkResultBean policySdkResultBean) {
            if (policySdkResultBean.getCode() == 0) {
                PolicySdkLogUtils.Companion.d("getOnlinePolicyMethod", policySdkResultBean.getPolicyUrl());
                PolicySdkToolsUtils.Companion.startBrowser(this.f3188a, Uri.parse(policySdkResultBean.getPolicyUrl()));
            }
            PolicySdkCallback policySdkCallback = this.b;
            if (policySdkCallback != null) {
                policySdkCallback.getResult(policySdkResultBean);
            }
        }
    }

    public static void autoUploadRecord(Context context, String[] strArr, String str, String str2, PolicySdkCallback policySdkCallback) {
        PolicySdkResultBean policySdkResultBean;
        int i;
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            policySdkResultBean = new PolicySdkResultBean();
            i = PolicySdkErrorCode.NOT_NETWORK;
        } else {
            PolicyManager policyManager = PolicyManager.INSTANCE;
            if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
                policySdkResultBean = new PolicySdkResultBean();
                i = PolicySdkErrorCode.PARAMETER_ERROR;
            } else {
                PolicyManager.autoUploadRecord(context, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str, str2);
                policySdkResultBean = new PolicySdkResultBean();
                i = 0;
            }
        }
        policySdkResultBean.setCode(i);
        policySdkCallback.getResult(policySdkResultBean);
    }

    public static void checkNewestOverSeasPolicy(Context context, boolean z, String str, PolicySdkCallback policySdkCallback) {
        PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.Companion;
        String languageByArea = companion.getLanguageByArea(companion.getCurrentCountryCode(context));
        PolicySdkLogUtils.Companion companion2 = PolicySdkLogUtils.Companion;
        companion2.d("getCurrentCountryCode", "language =" + languageByArea);
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty() || languageByArea.isEmpty() || str.isEmpty()) {
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        PolicyManager.checkNewestPolicy(context, z, policyManager.getMAppId(), policyManager.getMAppSecret(), languageByArea, str, policyManager.getMAppVersionName(), new n(policySdkCallback));
    }

    public static void checkNewestPolicy(Context context, boolean z, String str, String str2, PolicySdkCallback policySdkCallback) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty() || str.isEmpty() || str2.isEmpty()) {
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        PolicyManager.checkNewestPolicy(context, z, policyManager.getMAppId(), policyManager.getMAppSecret(), str, str2, policyManager.getMAppVersionName(), new l(policySdkCallback));
    }

    public static String copyPolicyFile(Context context, String str, String str2) {
        return PolicyManager.copyPolicyFile(context, str, str2);
    }

    public static String[] getContentPermissionKey(Context context, int i) {
        String[] strArr = new String[0];
        if (i == 1) {
            return new String[]{context.getString(R.string.marketing_purposes_title)};
        } else if (i == 2) {
            return new String[]{context.getString(R.string.partners_title)};
        } else if (i != 3) {
            return strArr;
        } else {
            return new String[]{context.getString(R.string.marketing_purposes_title), context.getString(R.string.partners_title)};
        }
    }

    public static String[] getContentPermissionSummary(Context context, int i) {
        String[] strArr = new String[0];
        if (i == 1) {
            return new String[]{context.getString(R.string.marketing_purposes_message)};
        } else if (i == 2) {
            return new String[]{context.getString(R.string.partners_message)};
        } else if (i != 3) {
            return strArr;
        } else {
            return new String[]{context.getString(R.string.marketing_purposes_message), context.getString(R.string.partners_message)};
        }
    }

    public static void getOnlinePolicyMethod(Context context, String str, String str2, String str3, Boolean bool, PolicySdkCallback policySdkCallback) {
        Context context2 = context;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        PolicySdkCallback policySdkCallback2 = policySdkCallback;
        Bundle bundle = new Bundle();
        if (!PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            PolicySdkResultBean policyNewestPath = getPolicyNewestPath(context2, str5);
            if (policyNewestPath.getCode() == 0) {
                openPolicyByMethod(context2, bool, str6, str5);
            } else {
                Boolean bool2 = bool;
                if (bool.booleanValue()) {
                    bundle.putString(PolicySdkConstants.BUNDLE_KEY_LANGUAGE, str4);
                    bundle.putString(PolicySdkConstants.BUNDLE_KEY_CATEGORY, str5);
                    bundle.putLong(PolicySdkConstants.BUNDLE_KEY_VERSION, 0);
                    bundle.putInt(PolicySdkConstants.ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY, PolicySdkErrorCode.NOT_NETWORK);
                    PolicyWebViewActivity.Companion.a(context2, PolicySdkConstants.ONLINE_POLICY_WEB_VIEW, str6, bundle);
                }
            }
            if (policySdkCallback2 != null) {
                policySdkCallback2.getResult(policyNewestPath);
            }
        } else if (bool.booleanValue()) {
            bundle.putInt(PolicySdkConstants.ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY, 0);
            bundle.putString(PolicySdkConstants.BUNDLE_KEY_LANGUAGE, str4);
            bundle.putString(PolicySdkConstants.BUNDLE_KEY_CATEGORY, str5);
            bundle.putLong(PolicySdkConstants.BUNDLE_KEY_VERSION, 0);
            PolicyWebViewActivity.Companion.a(context2, PolicySdkConstants.ONLINE_POLICY_WEB_VIEW, str6, bundle);
        } else {
            getPolicy(str4, str5, 0L, new a(bool, context, str3, str2, bundle, str, policySdkCallback));
        }
    }

    public static void getOnlinePolicyUrl(String str, String str2, PolicySdkCallback policySdkCallback) {
        getPolicy(str, str2, 0L, policySdkCallback);
    }

    public static void getOnlinePolicyWebViewSetCustomFun(Context context, String str, String str2, String str3, Boolean bool, Function1<Context, Unit> function1) {
        PolicyWebViewActivity.Companion.getClass();
        PolicyWebViewActivity.webViewSettingBtnCallback = function1;
        getOnlinePolicyMethod(context, str, str2, str3, bool, (PolicySdkCallback) null);
    }

    public static void getPolicy(String str, String str2, Long l, PolicySdkCallback policySdkCallback) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("getPolicy", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        PolicyManager.getPolicyData(policyManager.getMAppId(), policyManager.getMAppSecret(), str, str2, l, policyManager.getMAppVersionName(), new m(policySdkCallback));
    }

    public static void getPolicyByVersion(String str, Long l, PolicySdkCallback policySdkCallback) throws Exception {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("getPolicyByVersion", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        PolicyManager.getPolicyByVersion(policyManager.getMAppId(), policyManager.getMAppSecret(), str, l, policyManager.getMAppVersionName(), new k(policySdkCallback));
    }

    public static void getPolicyHistoryList(String str, Long l, String str2, PolicySdkCallback policySdkCallback) throws Exception {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("getPolicyHistoryList", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
            policySdkResultBean.setCode(PolicySdkErrorCode.PARAMETER_ERROR);
            policySdkCallback.getResult(policySdkResultBean);
            return;
        }
        String str3 = str;
        String str4 = str2;
        PolicyManager.getPolicyHistoryList(policyManager.getMAppId(), policyManager.getMAppSecret(), str3, str4, l.longValue(), policyManager.getMAppVersionName(), new j(policySdkCallback));
    }

    public static String getPolicyHistoryUrl(String str, Long l, String str2) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (!policyManager.getMAppId().isEmpty() && !str.isEmpty() && !str2.isEmpty()) {
            return PolicyManager.getPolicyHistoryUrl(policyManager.getMAppId(), str, l.longValue(), str2);
        }
        PolicySdkLogUtils.Companion.d("getPolicyHistoryUrl", "-10001");
        return "";
    }

    public static PolicySdkResultBean getPolicyNewestPath(Context context, String str) {
        return PolicyManager.getPolicyNewestPath(context, "", str);
    }

    public static String getPolicySdkVersion() {
        return PolicySdkConstants.VERSION_NAME;
    }

    public static int getRegrantContentTypes(String str) {
        return (!str.contains("MARKETING_PURPOSES") || !str.contains("THIRD_DATA_SHARE")) ? str.contains("MARKETING_PURPOSES") ? CONTENT_TYPE_MARKETING_PURPOSES : str.contains("THIRD_DATA_SHARE") ? CONTENT_TYPE_THIRD_DATA_SHARE : CONTENT_TYPE_NONE : CONTENT_TYPE_ALL;
    }

    public static void initSDK(Context context, String str, String str2, String str3, HashMap<String, String> hashMap) {
        PolicyManager.initSDK(context, str, str2, str3, hashMap);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$getPolicy$5(PolicySdkCallback policySdkCallback, PolicySdkResultBean policySdkResultBean) {
        Log.d("PolicySdk", "getPolicy: =" + policySdkResultBean.getCode());
        policySdkCallback.getResult(policySdkResultBean);
        return null;
    }

    public static void openOnlinePolicyByBrowserWithoutLocal(Context context, String str, String str2, PolicySdkCallback policySdkCallback) {
        if (PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            getPolicy(str, str2, 0L, new b(context, policySdkCallback));
            return;
        }
        PolicySdkResultBean policySdkResultBean = new PolicySdkResultBean();
        policySdkResultBean.setCode(PolicySdkErrorCode.NOT_NETWORK);
        if (policySdkCallback != null) {
            policySdkCallback.getResult(policySdkResultBean);
        }
    }

    public static PolicySdkResultBean openPolicyByMethod(Context context, Boolean bool, String str, String str2) {
        return PolicyManager.openPolicyMethod(context, bool.booleanValue(), str, str2);
    }

    public static AlertDialog showBasicDialog(Context context, String str, CharSequence charSequence, String str2, String str3, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        return PolicyManager.showDialogByCustomView(context, str, charSequence, str2, str3, onPermissionClickListener);
    }

    public static AlertDialog showBasicDialogRecord(Context context, String str, CharSequence charSequence, String str2, String str3, String[] strArr, String str4, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("showReGrantTwoPolicyDialogRecord", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            return null;
        }
        return PolicyManager.showDialogByCustomViewAndUploadRecord(context, str, charSequence, str2, str3, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str4, "1", onPermissionClickListener);
    }

    public static AlertDialog showCustomPolicyDialog(Context context, Boolean bool, String[] strArr, String[] strArr2, String str, String str2, CharSequence charSequence, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        String[] strArr3 = strArr;
        return PolicyManager.showCustomPolicyDialog(context, bool.booleanValue(), PolicySdkToolsUtils.Companion.getCustomPermissionKey(context, strArr), strArr2, str, str2, charSequence, onPermissionClickListener);
    }

    public static AlertDialog showCustomPolicyDialogOverSeasRecord(Context context, String str, CharSequence charSequence, String[] strArr, String str2, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("showCustomPolicyDialogOverSeasRecord", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数");
            return null;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        String string = context.getString(R.string.btn_confirm);
        policyManager.setOnlinePolicyVersion(context, strArr);
        return PolicyManager.showOverSeasCustomPolicyDialogAndUploadRecord(context, mAppId, mAppSecret, str2, mAppVersionName, str, charSequence, strArr, string, onPermissionClickListener);
    }

    public static AlertDialog showCustomPolicyDialogRecord(Context context, Boolean bool, String[] strArr, String[] strArr2, String str, String str2, CharSequence charSequence, String[] strArr3, String str3, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("showCustomPolicyDialogRecord", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数");
            return null;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        Context context2 = context;
        return PolicyManager.showCustomPolicyDialogAndUploadRecord(context, bool.booleanValue(), PolicySdkToolsUtils.Companion.getCustomPermissionKey(context, strArr), strArr2, str, str2, charSequence, mAppId, mAppSecret, mAppVersionName, strArr3, str3, onPermissionClickListener);
    }

    public static PermissionDialogBuilder showDialogByCustomThemeViewBuilder(Context context, int i, String str, CharSequence charSequence, String str2, String str3, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        return PolicyManager.showDialogByCustomThemeViewBuilder(context, i, str, charSequence, str2, str3, onPermissionClickListener);
    }

    public static PermissionDialogBuilder showDialogByCustomViewBuilder(Context context, String str, CharSequence charSequence, String str2, String str3, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        return PolicyManager.showDialogByCustomViewBuilder(context, str, charSequence, str2, str3, onPermissionClickListener);
    }

    public static AlertDialog showMarketingPurposesDialog(Context context, String str, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        return PolicyManager.showOverSeasWithdrawConsentDialog(context, context.getString(R.string.marketing_purposes_dialog_title), context.getString(R.string.marketing_purposes_dialog_message), context.getString(R.string.btn_cancel), context.getString(R.string.btn_confirm), onPermissionClickListener);
    }

    public static AlertDialog showNewestDialog(Context context, String str, String str2, String[] strArr, boolean z, CharSequence charSequence, String str3, String str4, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("getPolicyByVersion", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            return null;
        }
        return PolicyManager.showNewestDialogAndUploadRecord(context, str2, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str, z, charSequence, str3, str4, onPermissionClickListener);
    }

    public static AlertDialog showPermissionPolicyDialogOverSeasRecord(Context context, String str, CharSequence charSequence, String[] strArr, String str2, int i, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        Context context2 = context;
        int i2 = i;
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("showCustomPolicyDialogOverSeasRecord", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数");
            return null;
        }
        String mAppId = policyManager.getMAppId();
        String mAppSecret = policyManager.getMAppSecret();
        String mAppVersionName = policyManager.getMAppVersionName();
        String string = context.getString(R.string.btn_confirm);
        String[] contentPermissionKey = getContentPermissionKey(context, i2);
        String[] contentPermissionSummary = getContentPermissionSummary(context, i2);
        policyManager.setOnlinePolicyVersion(context, strArr);
        return PolicyManager.showOverSeasPermissionPolicyDialogAndUploadRecord(context, mAppId, mAppSecret, str2, mAppVersionName, str, charSequence, strArr, contentPermissionKey, contentPermissionSummary, string, onPermissionClickListener);
    }

    public static AlertDialog showReGrantDialog(Context context, boolean z, String str, Boolean bool, Boolean bool2, String str2, String str3, String str4, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        if (z) {
            PolicyManager policyManager = PolicyManager.INSTANCE;
            if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty() || str4.isEmpty()) {
                PolicySdkLogUtils.Companion.e("getPolicyByVersion", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
                return null;
            }
            return PolicyManager.showReGrantDialogAndUploadRecord(context, bool.booleanValue(), bool2.booleanValue(), str2, str3, str4, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), new String[]{str4}, str, onPermissionClickListener);
        }
        return PolicyManager.showReGrantDialog(context, bool.booleanValue(), bool2.booleanValue(), str2, str3, str4, onPermissionClickListener);
    }

    public static AlertDialog showReGrantTwoPolicyDialog(Context context, boolean z, String str, Boolean bool, Boolean bool2, String str2, String str3, String str4, String str5, String str6, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        if (z) {
            PolicyManager policyManager = PolicyManager.INSTANCE;
            if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty() || str6.isEmpty() || str4.isEmpty()) {
                PolicySdkLogUtils.Companion.e("getPolicyByVersion", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
                return null;
            }
            String str7 = str4;
            String str8 = str6;
            return PolicyManager.showReGrantTwoPolicyDialogAndUploadRecord(context, bool.booleanValue(), bool2.booleanValue(), str2, str3, str7, str5, str8, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), new String[]{str8, str7}, str, onPermissionClickListener);
        }
        String str9 = str4;
        String str10 = str6;
        return PolicyManager.showReGrantTwoPolicyDialog(context, bool.booleanValue(), bool2.booleanValue(), str2, str3, str4, str5, str6, onPermissionClickListener);
    }

    public static AlertDialog showSharingWithPartnersDialog(Context context, String str, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        return PolicyManager.showOverSeasWithdrawConsentDialog(context, context.getString(R.string.partners_dialog_title), context.getString(R.string.partners_dialog_message), context.getString(R.string.btn_cancel), context.getString(R.string.btn_confirm), onPermissionClickListener);
    }

    public static AlertDialog showWithdrawalDialog(Context context, String str, CharSequence charSequence, String str2, String str3, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        return showDialogByCustomViewBuilder(context, str, charSequence, str2, str3, onPermissionClickListener).setCancelable(true).create();
    }

    public static AlertDialog showWithdrawalDialogRecord(Context context, String str, CharSequence charSequence, String str2, String str3, String[] strArr, String str4, PermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        PolicyManager policyManager = PolicyManager.INSTANCE;
        if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
            PolicySdkLogUtils.Companion.e("showReGrantTwoPolicyDialogRecord", "-10001参数错误，请使用PolicySdk.initSDK 初始化appid 和 appSecret 等参数 和检查category 和userCategory 参数");
            return null;
        }
        return PolicyManager.showDialogUploadRecordBuilder(context, str, charSequence, str2, str3, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), strArr, str4, "3", onPermissionClickListener).setCancelable(true).create();
    }

    public static void uploadPolicyOperateRecord(Context context, String[] strArr, String str, String str2, PolicySdkCallback policySdkCallback) {
        PolicySdkResultBean policySdkResultBean;
        int i;
        if (context == null || !PolicySdkNetworkUtil.isNetworkAvailable(context)) {
            policySdkResultBean = new PolicySdkResultBean();
            i = PolicySdkErrorCode.NOT_NETWORK;
        } else {
            PolicyManager policyManager = PolicyManager.INSTANCE;
            if (policyManager.getMAppId().isEmpty() || policyManager.getMAppSecret().isEmpty() || policyManager.getMAppVersionName().isEmpty()) {
                policySdkResultBean = new PolicySdkResultBean();
                i = PolicySdkErrorCode.PARAMETER_ERROR;
            } else {
                PolicyManager.uploadPolicyOperateRecord(context, policyManager.getMAppId(), policyManager.getMAppSecret(), policyManager.getMAppVersionName(), PolicyManager.createRecordRequest(context, strArr, str, str2), new i(policySdkCallback));
                return;
            }
        }
        policySdkResultBean.setCode(i);
        policySdkCallback.getResult(policySdkResultBean);
    }
}
