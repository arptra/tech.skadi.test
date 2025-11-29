package com.here.sdk.consent;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.here.sdk.R;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.honey.account.y1.a;
import com.honey.account.y1.b;
import com.honey.account.y1.c;
import com.honey.account.y1.d;
import com.meizu.common.util.LunarCalendar;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ConsentActivity extends Activity {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final String LOG_TAG = "ConsentActivity";
    private Handler mHander;

    public static class LanguageUtil {
        private static final String TAG = "LanguageUtil";
        private static final Map<String, String> sFallbackMapping;
        private static final Map<String, String> sMapping;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("ar", "eg-ar");
            hashMap.put("bg", "bg-bg");
            hashMap.put("hr", "hr-hr");
            hashMap.put("cs", "cz-cs");
            hashMap.put("da", "dk-da");
            hashMap.put("nl", "nl-nl");
            hashMap.put("et", "ee-et");
            hashMap.put("fi", "fi-fi");
            hashMap.put("de", "de-de");
            hashMap.put("el", "gr-el");
            hashMap.put("iw", "il-he");
            hashMap.put("hi", "in-hi");
            hashMap.put("hu", "hu-hu");
            hashMap.put("id", "id-id");
            hashMap.put("it", "it-it");
            hashMap.put("ja", "jp-ja");
            hashMap.put("kk", "kz-ru");
            hashMap.put("ko", "kr-ko");
            hashMap.put("lv", "lv-lv");
            hashMap.put("lt", "lt-lt");
            hashMap.put("nb", "nb-no");
            hashMap.put("pl", "pl-pl");
            hashMap.put("ro", "ro-ro");
            hashMap.put("ru", "ru-ru");
            hashMap.put("sr", "rs-sr");
            hashMap.put("sk", "sk-sk");
            hashMap.put("sl", "si-sl");
            hashMap.put("sv", "se-sv");
            hashMap.put("th", "th-th");
            hashMap.put("tr", "tr-tr");
            hashMap.put("uk", "ua-uk");
            hashMap.put("vi", "vn-vi");
            hashMap.put("zh-HK", "hk-zh");
            hashMap.put("zh-CN", "cn-zh");
            hashMap.put("zh-TW", "tw-zh");
            hashMap.put("en-GB", "en-gb");
            hashMap.put("en-US", "us-en");
            hashMap.put("fr-CA", "ca-fr");
            hashMap.put("fr-FR", "fr-fr");
            hashMap.put("pt-BR", "br-pt");
            hashMap.put("pt-PT", "pt-pt");
            hashMap.put("es-MX", "mx-es");
            hashMap.put(AsrConstants.SrcLangType.ES, "es-es");
            sMapping = Collections.unmodifiableMap(hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("zh", "cn-zh");
            hashMap2.put("en", "en-gb");
            hashMap2.put("fr", "fr-fr");
            hashMap2.put("pt", "pt-pt");
            hashMap2.put("es", "es-es");
            sFallbackMapping = Collections.unmodifiableMap(hashMap2);
        }

        public static String getLanguageCode() {
            return getLanguageCode(Locale.getDefault());
        }

        public static String getLanguageCode(@NonNull Locale locale) {
            Log.v(TAG, "lang: " + locale.getLanguage() + ", country: " + locale.getCountry());
            Map<String, String> map = sMapping;
            if (map.containsKey(locale.getLanguage())) {
                return map.get(locale.getLanguage());
            }
            String str = locale.getLanguage() + LunarCalendar.DATE_SEPARATOR + locale.getCountry();
            if (map.containsKey(str)) {
                return map.get(str);
            }
            Map<String, String> map2 = sFallbackMapping;
            if (map2.containsKey(locale.getLanguage())) {
                return map2.get(locale.getLanguage());
            }
            return map.get("en-GB");
        }
    }

    private void callAfterRippleAnimation(Runnable runnable) {
        this.mHander.postDelayed(runnable, (long) getResources().getInteger(17694720));
    }

    private int getUiModeTheme() {
        return (getResources().getConfiguration().uiMode & 48) != 32 ? 16974391 : 16974372;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setUpBindings$0(View view) {
        callAfterRippleAnimation(new c(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setUpBindings$1(View view) {
        callAfterRippleAnimation(new d(this));
    }

    /* access modifiers changed from: private */
    public void onConsentDenied() {
        Log.i(LOG_TAG, "onConsentDenied");
        onConsentResult(false);
    }

    /* access modifiers changed from: private */
    public void onConsentGranted() {
        Log.i(LOG_TAG, "onConsentGranted");
        onConsentResult(true);
    }

    private void onConsentResult(boolean z) {
        String str = LOG_TAG;
        Log.i(str, "onConsentResult: " + z);
        SDKNativeEngine sharedInstance = SDKNativeEngine.getSharedInstance();
        if (sharedInstance != null) {
            try {
                ConsentInternal.fromSdkNativeEngine(sharedInstance).setConsentState(z ? ConsentState.GRANTED : ConsentState.NOT_GRANTED);
            } catch (InstantiationErrorException e) {
                Log.e(LOG_TAG, "onConsentResult: failed to get consent internal instance", e);
            }
        } else {
            Log.e(str, "onConsentResult: failed to get shared SDKNativeEngine. Please set shared instance.");
        }
        finish();
    }

    private void setFullscreenMode() {
        getWindow().getDecorView().setSystemUiVisibility(5380);
    }

    private void setUpBindings() {
        ((Button) findViewById(R.id.button_grant)).setOnClickListener(new a(this));
        ((Button) findViewById(R.id.button_deny)).setOnClickListener(new b(this));
        ((TextView) findViewById(R.id.textview_consent_message)).setText(getString(R.string.poscon_consent_msg_concatenate, new Object[]{getString(R.string.poscon_consent_v3_screen_2), getString(R.string.poscon_consent_v3_screen_3)}));
        TextView textView = (TextView) findViewById(R.id.textview_consent_learn_more);
        String string = getString(R.string.poscon_consent_learn_more, new Object[]{LanguageUtil.getLanguageCode(), getString(R.string.poscon_consent_v3_screen_learn_more)});
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(Html.fromHtml(string));
    }

    public void onBackPressed() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.mHander = new Handler();
        setTheme(getUiModeTheme());
        setContentView(R.layout.activity_consent);
        setUpBindings();
        setFullscreenMode();
    }

    public void onResume() {
        super.onResume();
        setFullscreenMode();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        setFullscreenMode();
    }
}
