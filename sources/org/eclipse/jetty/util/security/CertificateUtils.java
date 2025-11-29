package org.eclipse.jetty.util.security;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CRL;
import java.security.cert.CertificateFactory;
import java.util.Collection;
import org.eclipse.jetty.util.resource.Resource;

public class CertificateUtils {
    public static KeyStore getKeyStore(InputStream inputStream, String str, String str2, String str3, String str4) throws Exception {
        char[] cArr = null;
        if (inputStream == null && str == null) {
            return null;
        }
        if (inputStream == null) {
            try {
                inputStream = Resource.newResource(str).getInputStream();
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        }
        KeyStore instance = str3 != null ? KeyStore.getInstance(str2, str3) : KeyStore.getInstance(str2);
        if (str4 != null) {
            cArr = str4.toCharArray();
        }
        instance.load(inputStream, cArr);
        if (inputStream != null) {
            inputStream.close();
        }
        return instance;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.Collection<? extends java.security.cert.CRL>, java.io.InputStream] */
    public static Collection<? extends CRL> loadCRL(String str) throws Exception {
        InputStream inputStream = 0;
        if (str == null) {
            return inputStream;
        }
        try {
            inputStream = Resource.newResource(str).getInputStream();
            return CertificateFactory.getInstance("X.509").generateCRLs(inputStream);
        } finally {
            if (inputStream != 0) {
                inputStream.close();
            }
        }
    }
}
