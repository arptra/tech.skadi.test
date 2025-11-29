package io.netty.handler.ssl;

import java.net.Socket;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.security.auth.x500.X500Principal;

final class OpenSslKeyMaterialManager {
    private static final Map<String, String> KEY_TYPES;
    static final String KEY_TYPE_DH_RSA = "DH_RSA";
    static final String KEY_TYPE_EC = "EC";
    static final String KEY_TYPE_EC_EC = "EC_EC";
    static final String KEY_TYPE_EC_RSA = "EC_RSA";
    static final String KEY_TYPE_RSA = "RSA";
    private final OpenSslKeyMaterialProvider provider;

    static {
        HashMap hashMap = new HashMap();
        KEY_TYPES = hashMap;
        hashMap.put(KEY_TYPE_RSA, KEY_TYPE_RSA);
        hashMap.put("DHE_RSA", KEY_TYPE_RSA);
        hashMap.put("ECDHE_RSA", KEY_TYPE_RSA);
        hashMap.put("ECDHE_ECDSA", "EC");
        hashMap.put("ECDH_RSA", KEY_TYPE_EC_RSA);
        hashMap.put("ECDH_ECDSA", KEY_TYPE_EC_EC);
        hashMap.put(KEY_TYPE_DH_RSA, KEY_TYPE_DH_RSA);
    }

    public OpenSslKeyMaterialManager(OpenSslKeyMaterialProvider openSslKeyMaterialProvider) {
        this.provider = openSslKeyMaterialProvider;
    }

    private String chooseClientAlias(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String[] strArr, X500Principal[] x500PrincipalArr) {
        X509KeyManager keyManager = this.provider.keyManager();
        return keyManager instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager) keyManager).chooseEngineClientAlias(strArr, x500PrincipalArr, referenceCountedOpenSslEngine) : keyManager.chooseClientAlias(strArr, x500PrincipalArr, (Socket) null);
    }

    private String chooseServerAlias(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String str) {
        X509KeyManager keyManager = this.provider.keyManager();
        return keyManager instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager) keyManager).chooseEngineServerAlias(str, (Principal[]) null, referenceCountedOpenSslEngine) : keyManager.chooseServerAlias(str, (Principal[]) null, (Socket) null);
    }

    private void setKeyMaterial(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String str) throws SSLException {
        OpenSslKeyMaterial openSslKeyMaterial = null;
        try {
            openSslKeyMaterial = this.provider.chooseKeyMaterial(referenceCountedOpenSslEngine.alloc, str);
            if (openSslKeyMaterial != null) {
                referenceCountedOpenSslEngine.setKeyMaterial(openSslKeyMaterial);
                openSslKeyMaterial.release();
            } else if (openSslKeyMaterial != null) {
                openSslKeyMaterial.release();
            }
        } catch (SSLException e) {
            throw e;
        } catch (Exception e2) {
            throw new SSLException(e2);
        } catch (Throwable th) {
            if (openSslKeyMaterial != null) {
                openSslKeyMaterial.release();
            }
            throw th;
        }
    }

    public void setKeyMaterialClientSide(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String[] strArr, X500Principal[] x500PrincipalArr) throws SSLException {
        String chooseClientAlias = chooseClientAlias(referenceCountedOpenSslEngine, strArr, x500PrincipalArr);
        if (chooseClientAlias != null) {
            setKeyMaterial(referenceCountedOpenSslEngine, chooseClientAlias);
        }
    }

    public void setKeyMaterialServerSide(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine) throws SSLException {
        String chooseServerAlias;
        String[] authMethods = referenceCountedOpenSslEngine.authMethods();
        if (authMethods.length != 0) {
            HashSet hashSet = new HashSet(KEY_TYPES.size());
            int length = authMethods.length;
            int i = 0;
            while (i < length) {
                String str = KEY_TYPES.get(authMethods[i]);
                if (str == null || !hashSet.add(str) || (chooseServerAlias = chooseServerAlias(referenceCountedOpenSslEngine, str)) == null) {
                    i++;
                } else {
                    setKeyMaterial(referenceCountedOpenSslEngine, chooseServerAlias);
                    return;
                }
            }
            throw new SSLHandshakeException("Unable to find key material for auth method(s): " + Arrays.toString(authMethods));
        }
        throw new SSLHandshakeException("Unable to find key material");
    }
}
