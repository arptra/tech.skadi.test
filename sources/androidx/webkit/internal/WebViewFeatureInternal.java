package androidx.webkit.internal;

import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.StartupApiFeature;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

public class WebViewFeatureInternal {
    public static final ApiFeature.M A = new ApiFeature.M("WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_POST_MESSAGE");
    public static final ApiFeature.M B = new ApiFeature.M("WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_CLOSE");
    public static final ApiFeature.NoFramework C = new ApiFeature.NoFramework("WEB_MESSAGE_ARRAY_BUFFER", "WEB_MESSAGE_ARRAY_BUFFER");
    public static final ApiFeature.M D = new ApiFeature.M("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");
    public static final ApiFeature.M E = new ApiFeature.M("CREATE_WEB_MESSAGE_CHANNEL", "CREATE_WEB_MESSAGE_CHANNEL");
    public static final ApiFeature.M F = new ApiFeature.M("POST_WEB_MESSAGE", "POST_WEB_MESSAGE");
    public static final ApiFeature.M G = new ApiFeature.M("WEB_MESSAGE_CALLBACK_ON_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE");
    public static final ApiFeature.O H = new ApiFeature.O("GET_WEB_VIEW_CLIENT", "GET_WEB_VIEW_CLIENT");
    public static final ApiFeature.O I = new ApiFeature.O("GET_WEB_CHROME_CLIENT", "GET_WEB_CHROME_CLIENT");
    public static final ApiFeature.Q J = new ApiFeature.Q("GET_WEB_VIEW_RENDERER", "GET_WEB_VIEW_RENDERER");
    public static final ApiFeature.Q K = new ApiFeature.Q("WEB_VIEW_RENDERER_TERMINATE", "WEB_VIEW_RENDERER_TERMINATE");
    public static final ApiFeature.P L = new ApiFeature.P("TRACING_CONTROLLER_BASIC_USAGE", "TRACING_CONTROLLER_BASIC_USAGE");
    public static final StartupApiFeature.P M = new StartupApiFeature.P("STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX", "STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX");
    public static final StartupApiFeature.NoFramework N = new StartupApiFeature.NoFramework("STARTUP_FEATURE_SET_DIRECTORY_BASE_PATHS", "STARTUP_FEATURE_SET_DIRECTORY_BASE_PATH");
    public static final ApiFeature.Q O = new ApiFeature.Q("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE");
    public static final ApiFeature.T P = new ApiFeature.T("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING") {
        public final Pattern d = Pattern.compile("\\A\\d+");

        public boolean c() {
            return super.c();
        }
    };
    public static final ApiFeature.NoFramework Q = new ApiFeature.NoFramework("PROXY_OVERRIDE", "PROXY_OVERRIDE:3");
    public static final ApiFeature.NoFramework R = new ApiFeature.NoFramework("MULTI_PROCESS", "MULTI_PROCESS_QUERY");
    public static final ApiFeature.Q S = new ApiFeature.Q("FORCE_DARK", "FORCE_DARK");
    public static final ApiFeature.NoFramework T = new ApiFeature.NoFramework("FORCE_DARK_STRATEGY", "FORCE_DARK_BEHAVIOR");
    public static final ApiFeature.NoFramework U = new ApiFeature.NoFramework("WEB_MESSAGE_LISTENER", "WEB_MESSAGE_LISTENER");
    public static final ApiFeature.NoFramework V = new ApiFeature.NoFramework("DOCUMENT_START_SCRIPT", "DOCUMENT_START_SCRIPT:1");
    public static final ApiFeature.NoFramework W = new ApiFeature.NoFramework("PROXY_OVERRIDE_REVERSE_BYPASS", "PROXY_OVERRIDE_REVERSE_BYPASS");
    public static final ApiFeature.NoFramework X = new ApiFeature.NoFramework("GET_VARIATIONS_HEADER", "GET_VARIATIONS_HEADER");
    public static final ApiFeature.NoFramework Y = new ApiFeature.NoFramework("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY", "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY");
    public static final ApiFeature.NoFramework Z = new ApiFeature.NoFramework("GET_COOKIE_INFO", "GET_COOKIE_INFO");

    /* renamed from: a  reason: collision with root package name */
    public static final ApiFeature.M f1985a = new ApiFeature.M("VISUAL_STATE_CALLBACK", "VISUAL_STATE_CALLBACK");
    public static final ApiFeature.NoFramework a0 = new ApiFeature.NoFramework("REQUESTED_WITH_HEADER_ALLOW_LIST", "REQUESTED_WITH_HEADER_ALLOW_LIST");
    public static final ApiFeature.M b = new ApiFeature.M("OFF_SCREEN_PRERASTER", "OFF_SCREEN_PRERASTER");
    public static final ApiFeature.NoFramework b0 = new ApiFeature.NoFramework("USER_AGENT_METADATA", "USER_AGENT_METADATA");
    public static final ApiFeature.O c = new ApiFeature.O("SAFE_BROWSING_ENABLE", "SAFE_BROWSING_ENABLE");
    public static final ApiFeature.NoFramework c0 = new ApiFeature.NoFramework("MULTI_PROFILE", "MULTI_PROFILE") {
        public boolean c() {
            if (super.c() && WebViewFeature.a("MULTI_PROCESS")) {
                return WebViewCompat.b();
            }
            return false;
        }
    };
    public static final ApiFeature.N d = new ApiFeature.N("DISABLED_ACTION_MODE_MENU_ITEMS", "DISABLED_ACTION_MODE_MENU_ITEMS");
    public static final ApiFeature.NoFramework d0 = new ApiFeature.NoFramework("ATTRIBUTION_REGISTRATION_BEHAVIOR", "ATTRIBUTION_BEHAVIOR");
    public static final ApiFeature.O_MR1 e = new ApiFeature.O_MR1("START_SAFE_BROWSING", "START_SAFE_BROWSING");
    public static final ApiFeature.NoFramework e0 = new ApiFeature.NoFramework("WEBVIEW_MEDIA_INTEGRITY_API_STATUS", "WEBVIEW_INTEGRITY_API_STATUS");
    public static final ApiFeature.O_MR1 f = new ApiFeature.O_MR1("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_WHITELIST");
    public static final ApiFeature.NoFramework f0 = new ApiFeature.NoFramework("MUTE_AUDIO", "MUTE_AUDIO");
    public static final ApiFeature.O_MR1 g = new ApiFeature.O_MR1("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_ALLOWLIST");
    public static final ApiFeature.O_MR1 h = new ApiFeature.O_MR1("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_WHITELIST");
    public static final ApiFeature.O_MR1 i = new ApiFeature.O_MR1("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_ALLOWLIST");
    public static final ApiFeature.O_MR1 j = new ApiFeature.O_MR1("SAFE_BROWSING_PRIVACY_POLICY_URL", "SAFE_BROWSING_PRIVACY_POLICY_URL");
    public static final ApiFeature.N k = new ApiFeature.N("SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_BASIC_USAGE");
    public static final ApiFeature.N l = new ApiFeature.N("SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CACHE_MODE");
    public static final ApiFeature.N m = new ApiFeature.N("SERVICE_WORKER_CONTENT_ACCESS", "SERVICE_WORKER_CONTENT_ACCESS");
    public static final ApiFeature.N n = new ApiFeature.N("SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_FILE_ACCESS");
    public static final ApiFeature.N o = new ApiFeature.N("SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS");
    public static final ApiFeature.N p = new ApiFeature.N("SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST");
    public static final ApiFeature.M q = new ApiFeature.M("RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_WEB_RESOURCE_ERROR");
    public static final ApiFeature.M r = new ApiFeature.M("RECEIVE_HTTP_ERROR", "RECEIVE_HTTP_ERROR");
    public static final ApiFeature.N s = new ApiFeature.N("SHOULD_OVERRIDE_WITH_REDIRECTS", "SHOULD_OVERRIDE_WITH_REDIRECTS");
    public static final ApiFeature.O_MR1 t = new ApiFeature.O_MR1("SAFE_BROWSING_HIT", "SAFE_BROWSING_HIT");
    public static final ApiFeature.N u = new ApiFeature.N("WEB_RESOURCE_REQUEST_IS_REDIRECT", "WEB_RESOURCE_REQUEST_IS_REDIRECT");
    public static final ApiFeature.M v = new ApiFeature.M("WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_DESCRIPTION");
    public static final ApiFeature.M w = new ApiFeature.M("WEB_RESOURCE_ERROR_GET_CODE", "WEB_RESOURCE_ERROR_GET_CODE");
    public static final ApiFeature.O_MR1 x = new ApiFeature.O_MR1("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY");
    public static final ApiFeature.O_MR1 y = new ApiFeature.O_MR1("SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_PROCEED");
    public static final ApiFeature.O_MR1 z = new ApiFeature.O_MR1("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");

    public static UnsupportedOperationException a() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }

    public static boolean b(String str) {
        return c(str, ApiFeature.d());
    }

    public static boolean c(String str, Collection collection) {
        HashSet<ConditionallySupportedFeature> hashSet = new HashSet<>();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            ConditionallySupportedFeature conditionallySupportedFeature = (ConditionallySupportedFeature) it.next();
            if (conditionallySupportedFeature.a().equals(str)) {
                hashSet.add(conditionallySupportedFeature);
            }
        }
        if (!hashSet.isEmpty()) {
            for (ConditionallySupportedFeature isSupported : hashSet) {
                if (isSupported.isSupported()) {
                    return true;
                }
            }
            return false;
        }
        throw new RuntimeException("Unknown feature " + str);
    }
}
