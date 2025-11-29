package org.apache.tika.detect;

import java.io.CharConversionException;
import java.io.InputStream;
import java.util.Arrays;
import javax.xml.namespace.QName;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.utils.XMLReaderUtils;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlRootExtractor {

    /* renamed from: a  reason: collision with root package name */
    public static final ParseContext f10059a = new ParseContext();

    public static class ExtractorHandler extends DefaultHandler {

        /* renamed from: a  reason: collision with root package name */
        public QName f10060a;

        public ExtractorHandler() {
            this.f10060a = null;
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            this.f10060a = new QName(str, str2);
            throw new SAXException("Aborting: root element received");
        }
    }

    public static class MalformedCharException extends RuntimeException {
        public MalformedCharException(Exception exc) {
            super(exc);
        }
    }

    public final QName a(InputStream inputStream, boolean z) {
        ExtractorHandler extractorHandler = new ExtractorHandler();
        try {
            XMLReaderUtils.parseSAX((InputStream) new CloseShieldInputStream(inputStream), (ContentHandler) extractorHandler, f10059a);
        } catch (SecurityException e) {
            throw e;
        } catch (Exception e2) {
            if (z && ((e2 instanceof CharConversionException) || (e2.getCause() instanceof CharConversionException))) {
                throw new MalformedCharException(e2);
            }
        }
        return extractorHandler.f10060a;
    }

    public QName b(byte[] bArr) {
        while (true) {
            try {
                return a(new UnsynchronizedByteArrayInputStream(bArr), true);
            } catch (MalformedCharException unused) {
                int length = bArr.length / 2;
                if (length % 2 == 1) {
                    length--;
                }
                if (length <= 0) {
                    return null;
                }
                bArr = Arrays.copyOf(bArr, length);
            }
        }
    }
}
