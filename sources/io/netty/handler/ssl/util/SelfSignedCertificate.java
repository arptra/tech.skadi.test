package io.netty.handler.ssl.util;

import com.geetest.sdk.x;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

public final class SelfSignedCertificate {
    private static final int DEFAULT_KEY_LENGTH_BITS = SystemPropertyUtil.getInt("io.netty.handler.ssl.util.selfSignedKeyStrength", 2048);
    private static final Date DEFAULT_NOT_AFTER = new Date(SystemPropertyUtil.getLong("io.netty.selfSignedCertificate.defaultNotAfter", 253402300799000L));
    private static final Date DEFAULT_NOT_BEFORE = new Date(SystemPropertyUtil.getLong("io.netty.selfSignedCertificate.defaultNotBefore", System.currentTimeMillis() - 31536000000L));
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SelfSignedCertificate.class);
    private final X509Certificate cert;
    private final File certificate;
    private final PrivateKey key;
    private final File privateKey;

    public SelfSignedCertificate() throws CertificateException {
        this(DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, "RSA", DEFAULT_KEY_LENGTH_BITS);
    }

    /* JADX INFO: finally extract failed */
    public static String[] newSelfSignedCertificate(String str, PrivateKey privateKey2, X509Certificate x509Certificate) throws IOException, CertificateEncodingException {
        ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(privateKey2.getEncoded());
        try {
            wrappedBuffer = Base64.encode(wrappedBuffer, true);
            StringBuilder sb = new StringBuilder();
            sb.append("-----BEGIN PRIVATE KEY-----\n");
            Charset charset = CharsetUtil.US_ASCII;
            sb.append(wrappedBuffer.toString(charset));
            sb.append("\n-----END PRIVATE KEY-----\n");
            String sb2 = sb.toString();
            wrappedBuffer.release();
            String replaceAll = str.replaceAll("[^\\w.-]", x.f);
            File createTempFile = PlatformDependent.createTempFile("keyutil_" + replaceAll + '_', ".key", (File) null);
            createTempFile.deleteOnExit();
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            try {
                fileOutputStream.write(sb2.getBytes(charset));
                fileOutputStream.close();
                ByteBuf wrappedBuffer2 = Unpooled.wrappedBuffer(x509Certificate.getEncoded());
                try {
                    wrappedBuffer2 = Base64.encode(wrappedBuffer2, true);
                    String str2 = "-----BEGIN CERTIFICATE-----\n" + wrappedBuffer2.toString(charset) + "\n-----END CERTIFICATE-----\n";
                    wrappedBuffer2.release();
                    File createTempFile2 = PlatformDependent.createTempFile("keyutil_" + replaceAll + '_', ".crt", (File) null);
                    createTempFile2.deleteOnExit();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(createTempFile2);
                    try {
                        fileOutputStream2.write(str2.getBytes(charset));
                        fileOutputStream2.close();
                        return new String[]{createTempFile2.getPath(), createTempFile.getPath()};
                    } catch (Throwable th) {
                        safeClose(createTempFile2, fileOutputStream2);
                        safeDelete(createTempFile2);
                        safeDelete(createTempFile);
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                } finally {
                    wrappedBuffer2.release();
                }
            } catch (Throwable th3) {
                safeClose(createTempFile, fileOutputStream);
                safeDelete(createTempFile);
                throw th3;
            }
        } catch (Throwable th4) {
            throw th4;
        } finally {
            wrappedBuffer.release();
        }
    }

    private static void safeClose(File file, OutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException e) {
            if (logger.isWarnEnabled()) {
                InternalLogger internalLogger = logger;
                internalLogger.warn("Failed to close a file: " + file, (Throwable) e);
            }
        }
    }

    private static void safeDelete(File file) {
        if (!file.delete()) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isWarnEnabled()) {
                internalLogger.warn("Failed to delete a file: " + file);
            }
        }
    }

    public X509Certificate cert() {
        return this.cert;
    }

    public File certificate() {
        return this.certificate;
    }

    public void delete() {
        safeDelete(this.certificate);
        safeDelete(this.privateKey);
    }

    public PrivateKey key() {
        return this.key;
    }

    public File privateKey() {
        return this.privateKey;
    }

    public SelfSignedCertificate(Date date, Date date2) throws CertificateException {
        this("localhost", date, date2, "RSA", DEFAULT_KEY_LENGTH_BITS);
    }

    public SelfSignedCertificate(Date date, Date date2, String str, int i) throws CertificateException {
        this("localhost", date, date2, str, i);
    }

    public SelfSignedCertificate(String str) throws CertificateException {
        this(str, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, "RSA", DEFAULT_KEY_LENGTH_BITS);
    }

    public SelfSignedCertificate(String str, String str2, int i) throws CertificateException {
        this(str, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, str2, i);
    }

    public SelfSignedCertificate(String str, Date date, Date date2) throws CertificateException {
        this(str, ThreadLocalInsecureRandom.current(), DEFAULT_KEY_LENGTH_BITS, date, date2, "RSA");
    }

    public SelfSignedCertificate(String str, Date date, Date date2, String str2, int i) throws CertificateException {
        this(str, ThreadLocalInsecureRandom.current(), i, date, date2, str2);
    }

    public SelfSignedCertificate(String str, SecureRandom secureRandom, int i) throws CertificateException {
        this(str, secureRandom, i, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, "RSA");
    }

    public SelfSignedCertificate(String str, SecureRandom secureRandom, String str2, int i) throws CertificateException {
        this(str, secureRandom, i, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, str2);
    }

    public SelfSignedCertificate(String str, SecureRandom secureRandom, int i, Date date, Date date2) throws CertificateException {
        this(str, secureRandom, i, date, date2, "RSA");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ba A[SYNTHETIC, Splitter:B:37:0x00ba] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SelfSignedCertificate(java.lang.String r9, java.security.SecureRandom r10, int r11, java.util.Date r12, java.util.Date r13, java.lang.String r14) throws java.security.cert.CertificateException {
        /*
            r8 = this;
            java.lang.String r0 = "Failed to close a file: "
            r8.<init>()
            java.lang.String r1 = "EC"
            boolean r1 = r1.equalsIgnoreCase(r14)
            if (r1 != 0) goto L_0x002d
            java.lang.String r1 = "RSA"
            boolean r1 = r1.equalsIgnoreCase(r14)
            if (r1 == 0) goto L_0x0016
            goto L_0x002d
        L_0x0016:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Algorithm not valid: "
            r9.append(r10)
            r9.append(r14)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x002d:
            java.security.KeyPairGenerator r1 = java.security.KeyPairGenerator.getInstance(r14)     // Catch:{ NoSuchAlgorithmException -> 0x00f1 }
            r1.initialize(r11, r10)     // Catch:{ NoSuchAlgorithmException -> 0x00f1 }
            java.security.KeyPair r11 = r1.generateKeyPair()     // Catch:{ NoSuchAlgorithmException -> 0x00f1 }
            r2 = r9
            r3 = r11
            r4 = r10
            r5 = r12
            r6 = r13
            r7 = r14
            java.lang.String[] r9 = io.netty.handler.ssl.util.BouncyCastleSelfSignedCertGenerator.generate(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0043 }
            goto L_0x0055
        L_0x0043:
            r1 = move-exception
            io.netty.util.internal.logging.InternalLogger r2 = logger
            java.lang.String r3 = "Failed to generate a self-signed X.509 certificate using Bouncy Castle:"
            r2.debug((java.lang.String) r3, (java.lang.Throwable) r1)
            r2 = r9
            r3 = r11
            r4 = r10
            r5 = r12
            r6 = r13
            r7 = r14
            java.lang.String[] r9 = io.netty.handler.ssl.util.OpenJdkSelfSignedCertGenerator.generate(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00de }
        L_0x0055:
            java.io.File r10 = new java.io.File
            r12 = 0
            r12 = r9[r12]
            r10.<init>(r12)
            r8.certificate = r10
            java.io.File r12 = new java.io.File
            r13 = 1
            r9 = r9[r13]
            r12.<init>(r9)
            r8.privateKey = r12
            java.security.PrivateKey r9 = r11.getPrivate()
            r8.key = r9
            r9 = 0
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            r11.<init>(r10)     // Catch:{ Exception -> 0x00af, all -> 0x00ab }
            java.lang.String r9 = "X509"
            java.security.cert.CertificateFactory r9 = java.security.cert.CertificateFactory.getInstance(r9)     // Catch:{ Exception -> 0x00a9 }
            java.security.cert.Certificate r9 = r9.generateCertificate(r11)     // Catch:{ Exception -> 0x00a9 }
            java.security.cert.X509Certificate r9 = (java.security.cert.X509Certificate) r9     // Catch:{ Exception -> 0x00a9 }
            r8.cert = r9     // Catch:{ Exception -> 0x00a9 }
            r11.close()     // Catch:{ IOException -> 0x0087 }
            goto L_0x00a6
        L_0x0087:
            r9 = move-exception
            io.netty.util.internal.logging.InternalLogger r10 = logger
            boolean r10 = r10.isWarnEnabled()
            if (r10 == 0) goto L_0x00a6
            io.netty.util.internal.logging.InternalLogger r10 = logger
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r0)
            java.io.File r8 = r8.certificate
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            r10.warn((java.lang.String) r8, (java.lang.Throwable) r9)
        L_0x00a6:
            return
        L_0x00a7:
            r9 = move-exception
            goto L_0x00b8
        L_0x00a9:
            r9 = move-exception
            goto L_0x00b2
        L_0x00ab:
            r10 = move-exception
            r11 = r9
            r9 = r10
            goto L_0x00b8
        L_0x00af:
            r10 = move-exception
            r11 = r9
            r9 = r10
        L_0x00b2:
            java.security.cert.CertificateEncodingException r10 = new java.security.cert.CertificateEncodingException     // Catch:{ all -> 0x00a7 }
            r10.<init>(r9)     // Catch:{ all -> 0x00a7 }
            throw r10     // Catch:{ all -> 0x00a7 }
        L_0x00b8:
            if (r11 == 0) goto L_0x00dd
            r11.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00dd
        L_0x00be:
            r10 = move-exception
            io.netty.util.internal.logging.InternalLogger r11 = logger
            boolean r11 = r11.isWarnEnabled()
            if (r11 == 0) goto L_0x00dd
            io.netty.util.internal.logging.InternalLogger r11 = logger
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r0)
            java.io.File r8 = r8.certificate
            r12.append(r8)
            java.lang.String r8 = r12.toString()
            r11.warn((java.lang.String) r8, (java.lang.Throwable) r10)
        L_0x00dd:
            throw r9
        L_0x00de:
            r8 = move-exception
            io.netty.util.internal.logging.InternalLogger r9 = logger
            java.lang.String r10 = "Failed to generate a self-signed X.509 certificate using sun.security.x509:"
            r9.debug((java.lang.String) r10, (java.lang.Throwable) r8)
            java.security.cert.CertificateException r9 = new java.security.cert.CertificateException
            java.lang.String r10 = "No provider succeeded to generate a self-signed certificate. See debug log for the root cause."
            r9.<init>(r10, r8)
            io.netty.util.internal.ThrowableUtil.addSuppressed((java.lang.Throwable) r9, (java.lang.Throwable) r1)
            throw r9
        L_0x00f1:
            r8 = move-exception
            java.lang.Error r9 = new java.lang.Error
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.util.SelfSignedCertificate.<init>(java.lang.String, java.security.SecureRandom, int, java.util.Date, java.util.Date, java.lang.String):void");
    }
}
