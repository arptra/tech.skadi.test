package io.netty.handler.ssl.util;

import com.honey.account.constant.AccountConstantKt;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class FingerprintTrustManagerFactory extends SimpleTrustManagerFactory {
    private static final Pattern FINGERPRINT_PATTERN = Pattern.compile("^[0-9a-fA-F:]+$");
    private static final Pattern FINGERPRINT_STRIP_PATTERN = Pattern.compile(AccountConstantKt.CODE_SEPARTOR);
    /* access modifiers changed from: private */
    public final byte[][] fingerprints;
    /* access modifiers changed from: private */
    public final FastThreadLocal<MessageDigest> tlmd;
    private final TrustManager tm;

    @Deprecated
    public FingerprintTrustManagerFactory(Iterable<String> iterable) {
        this("SHA1", toFingerprintArray(iterable));
    }

    public static FingerprintTrustManagerFactoryBuilder builder(String str) {
        return new FingerprintTrustManagerFactoryBuilder(str);
    }

    public static byte[][] toFingerprintArray(Iterable<String> iterable) {
        String next;
        ObjectUtil.checkNotNull(iterable, "fingerprints");
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (FINGERPRINT_PATTERN.matcher(next).matches()) {
                arrayList.add(StringUtil.decodeHexDump(FINGERPRINT_STRIP_PATTERN.matcher(next).replaceAll("")));
            } else {
                throw new IllegalArgumentException("malformed fingerprint: " + next);
            }
        }
        return (byte[][]) arrayList.toArray(new byte[0][]);
    }

    public TrustManager[] engineGetTrustManagers() {
        return new TrustManager[]{this.tm};
    }

    public void engineInit(KeyStore keyStore) throws Exception {
    }

    @Deprecated
    public FingerprintTrustManagerFactory(String... strArr) {
        this("SHA1", toFingerprintArray(Arrays.asList(strArr)));
    }

    public void engineInit(ManagerFactoryParameters managerFactoryParameters) throws Exception {
    }

    @Deprecated
    public FingerprintTrustManagerFactory(byte[]... bArr) {
        this("SHA1", bArr);
    }

    public FingerprintTrustManagerFactory(final String str, byte[][] bArr) {
        this.tm = new X509TrustManager() {
            private void checkTrusted(String str, X509Certificate[] x509CertificateArr) throws CertificateException {
                int i = 0;
                X509Certificate x509Certificate = x509CertificateArr[0];
                byte[] fingerprint = fingerprint(x509Certificate);
                byte[][] access$000 = FingerprintTrustManagerFactory.this.fingerprints;
                int length = access$000.length;
                while (i < length) {
                    if (!Arrays.equals(fingerprint, access$000[i])) {
                        i++;
                    } else {
                        return;
                    }
                }
                throw new CertificateException(str + " certificate with unknown fingerprint: " + x509Certificate.getSubjectDN());
            }

            private byte[] fingerprint(X509Certificate x509Certificate) throws CertificateEncodingException {
                MessageDigest messageDigest = (MessageDigest) FingerprintTrustManagerFactory.this.tlmd.get();
                messageDigest.reset();
                return messageDigest.digest(x509Certificate.getEncoded());
            }

            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                checkTrusted("client", x509CertificateArr);
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                checkTrusted("server", x509CertificateArr);
            }

            public X509Certificate[] getAcceptedIssuers() {
                return EmptyArrays.EMPTY_X509_CERTIFICATES;
            }
        };
        ObjectUtil.checkNotNull(str, "algorithm");
        ObjectUtil.checkNotNull(bArr, "fingerprints");
        if (bArr.length != 0) {
            try {
                int digestLength = MessageDigest.getInstance(str).getDigestLength();
                ArrayList arrayList = new ArrayList(bArr.length);
                int length = bArr.length;
                int i = 0;
                while (i < length) {
                    byte[] bArr2 = bArr[i];
                    if (bArr2 == null) {
                        break;
                    } else if (bArr2.length == digestLength) {
                        arrayList.add(bArr2.clone());
                        i++;
                    } else {
                        throw new IllegalArgumentException(String.format("malformed fingerprint (length is %d but expected %d): %s", new Object[]{Integer.valueOf(bArr2.length), Integer.valueOf(digestLength), ByteBufUtil.hexDump(Unpooled.wrappedBuffer(bArr2))}));
                    }
                }
                this.tlmd = new FastThreadLocal<MessageDigest>() {
                    public MessageDigest initialValue() {
                        try {
                            return MessageDigest.getInstance(str);
                        } catch (NoSuchAlgorithmException e) {
                            throw new IllegalArgumentException(String.format("Unsupported hash algorithm: %s", new Object[]{str}), e);
                        }
                    }
                };
                this.fingerprints = (byte[][]) arrayList.toArray(new byte[0][]);
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalArgumentException(String.format("Unsupported hash algorithm: %s", new Object[]{str}), e);
            }
        } else {
            throw new IllegalArgumentException("No fingerprints provided");
        }
    }
}
