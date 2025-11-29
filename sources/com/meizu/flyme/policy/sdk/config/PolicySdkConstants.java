package com.meizu.flyme.policy.sdk.config;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/meizu/flyme/policy/sdk/config/PolicySdkConstants;", "", "()V", "BUNDLE_KEY_CATEGORY", "", "BUNDLE_KEY_LANGUAGE", "BUNDLE_KEY_VERSION", "HIDE_SETTING_BUTTON", "", "ONLINE_POLICY_WEB_VIEW", "ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY", "ONLINE_POLICY_WEB_VIEW_DEFAULT", "", "POLICY_AUTO_RECORD", "POLICY_NEWEST_VERSION_DEFAULT", "", "POLICY_NOT_AUTO_RECORD", "POLICY_OPEN_BY_BROWSER", "POLICY_OPEN_BY_WEBVIEW", "SHOW_SETTING_BUTTON", "VERSION_NAME", "grant_need", "grant_no_need", "policyFileDir", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolicySdkConstants {
    @NotNull
    public static final String BUNDLE_KEY_CATEGORY = "bundle_key_category";
    @NotNull
    public static final String BUNDLE_KEY_LANGUAGE = "bundle_key_language";
    @NotNull
    public static final String BUNDLE_KEY_VERSION = "bundle_key_version";
    public static final boolean HIDE_SETTING_BUTTON = false;
    @NotNull
    public static final PolicySdkConstants INSTANCE = new PolicySdkConstants();
    @NotNull
    public static final String ONLINE_POLICY_WEB_VIEW = "online_policy_web_view";
    @NotNull
    public static final String ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY = "bundle_key_errorCode";
    public static final int ONLINE_POLICY_WEB_VIEW_DEFAULT = 0;
    public static final boolean POLICY_AUTO_RECORD = true;
    public static final long POLICY_NEWEST_VERSION_DEFAULT = 0;
    public static final boolean POLICY_NOT_AUTO_RECORD = false;
    public static final boolean POLICY_OPEN_BY_BROWSER = false;
    public static final boolean POLICY_OPEN_BY_WEBVIEW = true;
    public static final boolean SHOW_SETTING_BUTTON = true;
    @NotNull
    public static final String VERSION_NAME = "1.0.84";
    public static final int grant_need = 1;
    public static final int grant_no_need = 0;
    @NotNull
    public static final String policyFileDir = "policy";

    private PolicySdkConstants() {
    }
}
