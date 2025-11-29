package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
@RestrictTo
public class FingerprintManagerCompat {

    /* renamed from: androidx.core.hardware.fingerprint.FingerprintManagerCompat$1  reason: invalid class name */
    class AnonymousClass1 extends FingerprintManager.AuthenticationCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AuthenticationCallback f730a;

        public void onAuthenticationError(int i, CharSequence charSequence) {
            this.f730a.a(i, charSequence);
        }

        public void onAuthenticationFailed() {
            this.f730a.b();
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
            this.f730a.c(i, charSequence);
        }

        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            this.f730a.d(new AuthenticationResult(FingerprintManagerCompat.a(Api23Impl.b(authenticationResult))));
        }
    }

    @RequiresApi
    public static class Api23Impl {
        @RequiresPermission
        @DoNotInline
        public static void a(Object obj, Object obj2, CancellationSignal cancellationSignal, int i, Object obj3, Handler handler) {
            ((FingerprintManager) obj).authenticate((FingerprintManager.CryptoObject) obj2, cancellationSignal, i, (FingerprintManager.AuthenticationCallback) obj3, handler);
        }

        @DoNotInline
        public static FingerprintManager.CryptoObject b(Object obj) {
            return ((FingerprintManager.AuthenticationResult) obj).getCryptoObject();
        }

        @DoNotInline
        public static FingerprintManager c(Context context) {
            if (context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
                return (FingerprintManager) context.getSystemService(FingerprintManager.class);
            }
            return null;
        }

        @RequiresPermission
        @DoNotInline
        public static boolean d(Object obj) {
            return ((FingerprintManager) obj).hasEnrolledFingerprints();
        }

        @RequiresPermission
        @DoNotInline
        public static boolean e(Object obj) {
            return ((FingerprintManager) obj).isHardwareDetected();
        }

        @DoNotInline
        public static CryptoObject f(Object obj) {
            FingerprintManager.CryptoObject cryptoObject = (FingerprintManager.CryptoObject) obj;
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new CryptoObject(cryptoObject.getMac());
            }
            return null;
        }

        @DoNotInline
        public static FingerprintManager.CryptoObject g(CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.a() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.a());
            }
            if (cryptoObject.c() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.c());
            }
            if (cryptoObject.b() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.b());
            }
            return null;
        }
    }

    public static abstract class AuthenticationCallback {
        public void a(int i, CharSequence charSequence) {
        }

        public void b() {
        }

        public void c(int i, CharSequence charSequence) {
        }

        public void d(AuthenticationResult authenticationResult) {
        }
    }

    public static final class AuthenticationResult {

        /* renamed from: a  reason: collision with root package name */
        public final CryptoObject f731a;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.f731a = cryptoObject;
        }
    }

    public static CryptoObject a(FingerprintManager.CryptoObject cryptoObject) {
        return Api23Impl.f(cryptoObject);
    }

    public static class CryptoObject {

        /* renamed from: a  reason: collision with root package name */
        public final Signature f732a;
        public final Cipher b;
        public final Mac c;

        public CryptoObject(Signature signature) {
            this.f732a = signature;
            this.b = null;
            this.c = null;
        }

        public Cipher a() {
            return this.b;
        }

        public Mac b() {
            return this.c;
        }

        public Signature c() {
            return this.f732a;
        }

        public CryptoObject(Cipher cipher) {
            this.b = cipher;
            this.f732a = null;
            this.c = null;
        }

        public CryptoObject(Mac mac) {
            this.c = mac;
            this.b = null;
            this.f732a = null;
        }
    }
}
