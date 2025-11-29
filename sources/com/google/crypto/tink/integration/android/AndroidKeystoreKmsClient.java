package com.google.crypto.tink.integration.android;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KmsClient;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;
import javax.crypto.KeyGenerator;

public final class AndroidKeystoreKmsClient implements KmsClient {
    public static final String PREFIX = "android-keystore://";
    private static final String TAG = "AndroidKeystoreKmsClient";
    private static final int WAIT_TIME_MILLISECONDS_BEFORE_RETRY = 20;
    @GuardedBy
    private KeyStore keyStore;
    private final String keyUri;

    public static final class Builder {
        KeyStore keyStore = null;
        String keyUri = null;

        public Builder() {
            if (AndroidKeystoreKmsClient.isAtLeastM()) {
                try {
                    KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                    this.keyStore = instance;
                    instance.load((KeyStore.LoadStoreParameter) null);
                } catch (IOException | GeneralSecurityException e) {
                    throw new IllegalStateException(e);
                }
            } else {
                throw new IllegalStateException("need Android Keystore on Android M or newer");
            }
        }

        public AndroidKeystoreKmsClient build() {
            return new AndroidKeystoreKmsClient(this);
        }

        public Builder setKeyStore(KeyStore keyStore2) {
            if (keyStore2 != null) {
                this.keyStore = keyStore2;
                return this;
            }
            throw new IllegalArgumentException("val cannot be null");
        }

        public Builder setKeyUri(String str) {
            if (str == null || !str.toLowerCase(Locale.US).startsWith(AndroidKeystoreKmsClient.PREFIX)) {
                throw new IllegalArgumentException("val must start with android-keystore://");
            }
            this.keyUri = str;
            return this;
        }
    }

    public static void generateNewAeadKey(String str) throws GeneralSecurityException {
        if (!new AndroidKeystoreKmsClient().hasKey(str)) {
            String validateKmsKeyUriAndRemovePrefix = Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str);
            KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            instance.init(new KeyGenParameterSpec.Builder(validateKmsKeyUriAndRemovePrefix, 3).setKeySize(256).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).build());
            instance.generateKey();
            return;
        }
        throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", new Object[]{str}));
    }

    public static Aead getOrGenerateNewAeadKey(String str) throws GeneralSecurityException, IOException {
        AndroidKeystoreKmsClient androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
        if (!androidKeystoreKmsClient.hasKey(str)) {
            Log.i(TAG, String.format("key URI %s doesn't exist, generating a new one", new Object[]{str}));
            generateNewAeadKey(str);
        }
        return androidKeystoreKmsClient.getAead(str);
    }

    /* access modifiers changed from: private */
    public static boolean isAtLeastM() {
        return true;
    }

    private static Aead validateAead(Aead aead) throws GeneralSecurityException {
        byte[] randBytes = Random.randBytes(10);
        byte[] bArr = new byte[0];
        if (Arrays.equals(randBytes, aead.decrypt(aead.encrypt(randBytes, bArr), bArr))) {
            return aead;
        }
        throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
    }

    public synchronized void deleteKey(String str) throws GeneralSecurityException {
        this.keyStore.deleteEntry(Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean doesSupport(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = r2.keyUri     // Catch:{ all -> 0x000e }
            r1 = 1
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.equals(r3)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0010
            monitor-exit(r2)
            return r1
        L_0x000e:
            r3 = move-exception
            goto L_0x0026
        L_0x0010:
            java.lang.String r0 = r2.keyUri     // Catch:{ all -> 0x000e }
            if (r0 != 0) goto L_0x0023
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ all -> 0x000e }
            java.lang.String r3 = r3.toLowerCase(r0)     // Catch:{ all -> 0x000e }
            java.lang.String r0 = "android-keystore://"
            boolean r3 = r3.startsWith(r0)     // Catch:{ all -> 0x000e }
            if (r3 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            monitor-exit(r2)
            return r1
        L_0x0026:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient.doesSupport(java.lang.String):boolean");
    }

    public synchronized Aead getAead(String str) throws GeneralSecurityException {
        try {
            String str2 = this.keyUri;
            if (str2 != null) {
                if (!str2.equals(str)) {
                    throw new GeneralSecurityException(String.format("this client is bound to %s, cannot load keys bound to %s", new Object[]{this.keyUri, str}));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return validateAead(new AndroidKeystoreAesGcm(Validators.validateKmsKeyUriAndRemovePrefix(PREFIX, str), this.keyStore));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        android.util.Log.w(TAG, "Keystore is temporarily unavailable, wait 20ms, reinitialize Keystore and try again.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        java.lang.Thread.sleep(20);
        r0 = java.security.KeyStore.getInstance("AndroidKeyStore");
        r2.keyStore = r0;
        r0.load((java.security.KeyStore.LoadStoreParameter) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        return r2.keyStore.containsAlias(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        throw new java.security.GeneralSecurityException(r3);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean hasKey(java.lang.String r3) throws java.security.GeneralSecurityException {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "android-keystore://"
            java.lang.String r3 = com.google.crypto.tink.subtle.Validators.validateKmsKeyUriAndRemovePrefix(r0, r3)     // Catch:{ all -> 0x000f }
            java.security.KeyStore r0 = r2.keyStore     // Catch:{ NullPointerException -> 0x0011 }
            boolean r3 = r0.containsAlias(r3)     // Catch:{ NullPointerException -> 0x0011 }
            monitor-exit(r2)
            return r3
        L_0x000f:
            r3 = move-exception
            goto L_0x003a
        L_0x0011:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x000f }
            java.lang.String r1 = "Keystore is temporarily unavailable, wait 20ms, reinitialize Keystore and try again."
            android.util.Log.w(r0, r1)     // Catch:{ all -> 0x000f }
            r0 = 20
            java.lang.Thread.sleep(r0)     // Catch:{ IOException -> 0x002a, InterruptedException -> 0x002c }
            java.lang.String r0 = "AndroidKeyStore"
            java.security.KeyStore r0 = java.security.KeyStore.getInstance(r0)     // Catch:{ IOException -> 0x002a, InterruptedException -> 0x002c }
            r2.keyStore = r0     // Catch:{ IOException -> 0x002a, InterruptedException -> 0x002c }
            r1 = 0
            r0.load(r1)     // Catch:{ IOException -> 0x002a, InterruptedException -> 0x002c }
            goto L_0x002c
        L_0x002a:
            r3 = move-exception
            goto L_0x0034
        L_0x002c:
            java.security.KeyStore r0 = r2.keyStore     // Catch:{ all -> 0x000f }
            boolean r3 = r0.containsAlias(r3)     // Catch:{ all -> 0x000f }
            monitor-exit(r2)
            return r3
        L_0x0034:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x000f }
            r0.<init>(r3)     // Catch:{ all -> 0x000f }
            throw r0     // Catch:{ all -> 0x000f }
        L_0x003a:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient.hasKey(java.lang.String):boolean");
    }

    public KmsClient withCredentials(String str) throws GeneralSecurityException {
        return new AndroidKeystoreKmsClient();
    }

    public KmsClient withDefaultCredentials() throws GeneralSecurityException {
        return new AndroidKeystoreKmsClient();
    }

    public AndroidKeystoreKmsClient() throws GeneralSecurityException {
        this(new Builder());
    }

    @Deprecated
    public AndroidKeystoreKmsClient(String str) {
        this(new Builder().setKeyUri(str));
    }

    private AndroidKeystoreKmsClient(Builder builder) {
        this.keyUri = builder.keyUri;
        this.keyStore = builder.keyStore;
    }
}
