package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class PemReader {
    private static final Pattern BODY = Pattern.compile("[a-z0-9+/=][a-z0-9+/=\\r\\n]*", 2);
    private static final Pattern CERT_FOOTER = Pattern.compile("-+END\\s[^-\\r\\n]*CERTIFICATE[^-\\r\\n]*-+(?:\\s|\\r|\\n)*");
    private static final Pattern CERT_HEADER = Pattern.compile("-+BEGIN\\s[^-\\r\\n]*CERTIFICATE[^-\\r\\n]*-+(?:\\s|\\r|\\n)+");
    private static final Pattern KEY_FOOTER = Pattern.compile("-+END\\s[^-\\r\\n]*PRIVATE\\s+KEY[^-\\r\\n]*-+(?:\\s|\\r|\\n)*");
    private static final Pattern KEY_HEADER = Pattern.compile("-+BEGIN\\s[^-\\r\\n]*PRIVATE\\s+KEY[^-\\r\\n]*-+(?:\\s|\\r|\\n)+");
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PemReader.class);

    private PemReader() {
    }

    private static KeyException keyNotFoundException() {
        return new KeyException("could not find a PKCS #8 private key in input stream (see https://netty.io/wiki/sslcontextbuilder-and-private-key.html for more information)");
    }

    public static ByteBuf[] readCertificates(File file) throws CertificateException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            ByteBuf[] readCertificates = readCertificates((InputStream) fileInputStream);
            safeClose((InputStream) fileInputStream);
            return readCertificates;
        } catch (FileNotFoundException unused) {
            throw new CertificateException("could not find certificate file: " + file);
        } catch (Throwable th) {
            safeClose((InputStream) fileInputStream);
            throw th;
        }
    }

    private static String readContent(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    return byteArrayOutputStream.toString(CharsetUtil.US_ASCII.name());
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            safeClose((OutputStream) byteArrayOutputStream);
        }
    }

    public static ByteBuf readPrivateKey(File file) throws KeyException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            ByteBuf readPrivateKey = readPrivateKey((InputStream) fileInputStream);
            safeClose((InputStream) fileInputStream);
            return readPrivateKey;
        } catch (FileNotFoundException unused) {
            throw new KeyException("could not find key file: " + file);
        } catch (Throwable th) {
            safeClose((InputStream) fileInputStream);
            throw th;
        }
    }

    private static void safeClose(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e) {
            logger.warn("Failed to close a stream.", (Throwable) e);
        }
    }

    private static void safeClose(OutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException e) {
            logger.warn("Failed to close a stream.", (Throwable) e);
        }
    }

    public static ByteBuf[] readCertificates(InputStream inputStream) throws CertificateException {
        try {
            String readContent = readContent(inputStream);
            ArrayList arrayList = new ArrayList();
            Matcher matcher = CERT_HEADER.matcher(readContent);
            int i = 0;
            while (matcher.find(i)) {
                matcher.usePattern(BODY);
                if (!matcher.find()) {
                    break;
                }
                ByteBuf copiedBuffer = Unpooled.copiedBuffer((CharSequence) matcher.group(0), CharsetUtil.US_ASCII);
                matcher.usePattern(CERT_FOOTER);
                if (!matcher.find()) {
                    break;
                }
                ByteBuf decode = Base64.decode(copiedBuffer);
                copiedBuffer.release();
                arrayList.add(decode);
                i = matcher.end();
                matcher.usePattern(CERT_HEADER);
            }
            if (!arrayList.isEmpty()) {
                return (ByteBuf[]) arrayList.toArray(new ByteBuf[0]);
            }
            throw new CertificateException("found no certificates in input stream");
        } catch (IOException e) {
            throw new CertificateException("failed to read certificate input stream", e);
        }
    }

    public static ByteBuf readPrivateKey(InputStream inputStream) throws KeyException {
        try {
            Matcher matcher = KEY_HEADER.matcher(readContent(inputStream));
            if (matcher.find()) {
                matcher.usePattern(BODY);
                if (matcher.find()) {
                    ByteBuf copiedBuffer = Unpooled.copiedBuffer((CharSequence) matcher.group(0), CharsetUtil.US_ASCII);
                    matcher.usePattern(KEY_FOOTER);
                    if (matcher.find()) {
                        ByteBuf decode = Base64.decode(copiedBuffer);
                        copiedBuffer.release();
                        return decode;
                    }
                    throw keyNotFoundException();
                }
                throw keyNotFoundException();
            }
            throw keyNotFoundException();
        } catch (IOException e) {
            throw new KeyException("failed to read key input stream", e);
        }
    }
}
