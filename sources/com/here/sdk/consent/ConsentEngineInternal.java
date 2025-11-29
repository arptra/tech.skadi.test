package com.here.sdk.consent;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import com.here.posclient.PositionEstimate;
import com.here.sdk.consent.Consent;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.upuphone.runasone.uupcast.CaptureType;

class ConsentEngineInternal implements Consent {
    private static final String CONSENT_ACTIVITY_NAME = "com.here.sdk.consent.ConsentActivity";
    private static final String LOG_TAG = "ConsentEngineInternal";
    private final ConsentInternal mConsentInternal;

    /* renamed from: com.here.sdk.consent.ConsentEngineInternal$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$here$sdk$consent$ConsentState;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.here.sdk.consent.ConsentState[] r0 = com.here.sdk.consent.ConsentState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$here$sdk$consent$ConsentState = r0
                com.here.sdk.consent.ConsentState r1 = com.here.sdk.consent.ConsentState.GRANTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$here$sdk$consent$ConsentState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.here.sdk.consent.ConsentState r1 = com.here.sdk.consent.ConsentState.PENDING_GRANTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$here$sdk$consent$ConsentState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.here.sdk.consent.ConsentState r1 = com.here.sdk.consent.ConsentState.REQUESTING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$here$sdk$consent$ConsentState     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.here.sdk.consent.ConsentState r1 = com.here.sdk.consent.ConsentState.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.sdk.consent.ConsentEngineInternal.AnonymousClass1.<clinit>():void");
        }
    }

    public ConsentEngineInternal(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException {
        this.mConsentInternal = ConsentInternal.fromSdkNativeEngine(sDKNativeEngine);
    }

    private Context context() {
        return this.mConsentInternal.getAndroidContext();
    }

    @NonNull
    public ConsentStatus denyUserConsent() {
        return this.mConsentInternal.denyUserConsent();
    }

    @NonNull
    public Consent.UserReply getUserConsentState() {
        int i = AnonymousClass1.$SwitchMap$com$here$sdk$consent$ConsentState[this.mConsentInternal.getConsentState().ordinal()];
        return (i == 1 || i == 2) ? Consent.UserReply.GRANTED : i != 3 ? i != 4 ? Consent.UserReply.DENIED : Consent.UserReply.NOT_HANDLED : Consent.UserReply.REQUESTING;
    }

    @NonNull
    public ConsentStatus grantUserConsent() {
        return this.mConsentInternal.grantUserConsent();
    }

    @NonNull
    public ConsentStatus requestUserConsent() {
        ConsentState consentState = this.mConsentInternal.getConsentState();
        ConsentState consentState2 = ConsentState.REQUESTING;
        if (consentState == consentState2) {
            return ConsentStatus.OK;
        }
        try {
            this.mConsentInternal.setConsentState(consentState2);
            int i = ConsentActivity.$r8$clinit;
            Intent intent = new Intent(context(), ConsentActivity.class);
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            intent.addFlags(65536);
            intent.addFlags(PositionEstimate.Value.ACTIVITY);
            context().startActivity(intent);
        } catch (ClassNotFoundException e) {
            Log.e(LOG_TAG, "requestUserConsent: error", e);
            this.mConsentInternal.setConsentState(ConsentState.UNKNOWN);
        }
        return ConsentStatus.OK;
    }

    public ConsentEngineInternal() throws InstantiationErrorException {
        this.mConsentInternal = ConsentInternal.fromSharedSdkNativeEngine();
    }
}
