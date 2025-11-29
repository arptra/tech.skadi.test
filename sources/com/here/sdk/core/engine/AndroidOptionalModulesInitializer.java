package com.here.sdk.core.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import com.here.sdk.consent.ConsentInternal;
import com.meizu.common.widget.MzContactsContract;

final class AndroidOptionalModulesInitializer implements OptionalModulesInitializer {
    private static final String TAG = "AndroidOptionalModulesInitializer";

    private void tryInitModule(@NonNull SDKNativeEngine sDKNativeEngine, String str, String str2) throws Exception {
        try {
            Class.forName(str).getMethod("initialize", new Class[]{SDKNativeEngine.class}).invoke((Object) null, new Object[]{sDKNativeEngine});
            String str3 = TAG;
            Log.d(str3, "Module \"" + str2 + "\" is initialized.");
        } catch (ClassNotFoundException unused) {
            String str4 = TAG;
            Log.d(str4, "Module \"" + str2 + "\" is not included.");
        }
    }

    private static void tryStartConsent(@NonNull SDKNativeEngine sDKNativeEngine) throws Exception {
        Class<ConsentInternal> cls = ConsentInternal.class;
        try {
            int i = ConsentInternal.$r8$clinit;
            cls.getMethod(MzContactsContract.START_PARAM_KEY, (Class[]) null).invoke(cls.getMethod("fromSdkNativeEngine", new Class[]{SDKNativeEngine.class}).invoke((Object) null, new Object[]{sDKNativeEngine}), (Object[]) null);
        } catch (ClassNotFoundException unused) {
            Log.d(TAG, "Consent module is not included.");
        }
    }

    public boolean initOptionalModules(@NonNull SDKNativeEngine sDKNativeEngine) {
        try {
            tryInitModule(sDKNativeEngine, "com.here.sdk.consent.ConsentInitializer", "consent");
            tryInitModule(sDKNativeEngine, "com.here.sdk.location.LocationInitializer", "location");
            tryStartConsent(sDKNativeEngine);
            return true;
        } catch (Exception e) {
            Log.e(TAG, "SDK is failed due to initialisation issue with one of components, check in log for more information", e);
            return false;
        }
    }
}
