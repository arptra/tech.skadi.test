package org.apache.tika.mime;

import com.honey.account.constant.AccountConstantKt;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.tika.exception.TikaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MimeTypesReader extends DefaultHandler implements MimeTypesReaderMetKeys {
    public static final ReentrantReadWriteLock f = new ReentrantReadWriteLock();
    public static int g = 10;
    public static ArrayBlockingQueue h = new ArrayBlockingQueue(g);
    public static Logger i = LoggerFactory.k(MimeTypesReader.class);

    /* renamed from: a  reason: collision with root package name */
    public final MimeTypes f9152a;
    public MimeType b = null;
    public int c;
    public StringBuilder d = null;
    public ClauseRecord e = new ClauseRecord((Clause) null);

    public class ClauseRecord {

        /* renamed from: a  reason: collision with root package name */
        public final ClauseRecord f9153a;
        public Clause b;
        public List c = null;

        public ClauseRecord(Clause clause) {
            this.f9153a = MimeTypesReader.this.e;
            this.b = clause;
        }

        public List a() {
            return this.c;
        }

        public void b() {
            Clause clause = this.b;
            if (clause instanceof MinShouldMatchVal) {
                this.b = new MinShouldMatchClause(((MinShouldMatchVal) clause).getVal(), this.c);
            } else {
                List list = this.c;
                if (list != null) {
                    this.b = new AndClause(this.b, list.size() == 1 ? (Clause) this.c.get(0) : new OrClause(this.c));
                }
            }
            ClauseRecord clauseRecord = this.f9153a;
            List list2 = clauseRecord.c;
            if (list2 == null) {
                clauseRecord.c = Collections.singletonList(this.b);
            } else {
                if (list2.size() == 1) {
                    this.f9153a.c = new ArrayList(this.f9153a.c);
                }
                this.f9153a.c.add(this.b);
            }
            MimeTypesReader mimeTypesReader = MimeTypesReader.this;
            ClauseRecord unused = mimeTypesReader.e = mimeTypesReader.e.f9153a;
        }
    }

    public static class MinShouldMatchVal implements Clause {
        private final int val;

        public MinShouldMatchVal(int i) {
            this.val = i;
        }

        public boolean eval(byte[] bArr) {
            throw new IllegalStateException("This should never be used on this placeholder class");
        }

        public int getVal() {
            return this.val;
        }

        public int size() {
            return 0;
        }
    }

    static {
        try {
            i(g);
        } catch (TikaException e2) {
            throw new RuntimeException("problem initializing SAXParser pool", e2);
        }
    }

    public MimeTypesReader(MimeTypes mimeTypes) {
        this.f9152a = mimeTypes;
    }

    public static SAXParser c() {
        SAXParser sAXParser;
        do {
            try {
                ReentrantReadWriteLock reentrantReadWriteLock = f;
                reentrantReadWriteLock.readLock().lock();
                sAXParser = (SAXParser) h.poll(10, TimeUnit.MILLISECONDS);
                reentrantReadWriteLock.readLock().unlock();
            } catch (InterruptedException e2) {
                throw new TikaException("interrupted while waiting for SAXParser", e2);
            } catch (Throwable th) {
                f.readLock().unlock();
                throw th;
            }
        } while (sAXParser == null);
        return sAXParser;
    }

    public static SAXParser f() {
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        newInstance.setNamespaceAware(false);
        try {
            newInstance.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
        } catch (ParserConfigurationException | SAXException unused) {
            Logger logger = i;
            logger.warn("can't set secure processing feature on: " + newInstance.getClass() + ". User assumes responsibility for consequences.");
        }
        try {
            return newInstance.newSAXParser();
        } catch (ParserConfigurationException | SAXException e2) {
            throw new TikaException("Can't create new sax parser", e2);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void h(javax.xml.parsers.SAXParser r2) {
        /*
            r2.reset()     // Catch:{ UnsupportedOperationException -> 0x0003 }
        L_0x0003:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f     // Catch:{ all -> 0x0019 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()     // Catch:{ all -> 0x0019 }
            r1.lock()     // Catch:{ all -> 0x0019 }
            java.util.concurrent.ArrayBlockingQueue r1 = h     // Catch:{ all -> 0x0019 }
            r1.offer(r2)     // Catch:{ all -> 0x0019 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r0.readLock()
            r2.unlock()
            return
        L_0x0019:
            r2 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.mime.MimeTypesReader.h(javax.xml.parsers.SAXParser):void");
    }

    public static void i(int i2) {
        try {
            f.writeLock().lock();
            h = new ArrayBlockingQueue(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                h.offer(f());
            }
            g = i2;
            f.writeLock().unlock();
        } catch (Throwable th) {
            f.writeLock().unlock();
            throw th;
        }
    }

    public void characters(char[] cArr, int i2, int i3) {
        StringBuilder sb = this.d;
        if (sb != null) {
            sb.append(cArr, i2, i3);
        }
    }

    public void d(MimeType mimeType, String str, MimeTypeException mimeTypeException, String str2, Attributes attributes) {
        throw new SAXException(mimeTypeException);
    }

    public void e(String str, MimeTypeException mimeTypeException, String str2, Attributes attributes) {
        throw new SAXException(mimeTypeException);
    }

    public void endElement(String str, String str2, String str3) {
        if (this.b == null) {
            return;
        }
        if ("mime-type".equals(str3)) {
            this.b = null;
        } else if ("_comment".equals(str3)) {
            this.b.setDescription(this.d.toString().trim());
            this.d = null;
        } else if ("acronym".equals(str3)) {
            this.b.setAcronym(this.d.toString().trim());
            this.d = null;
        } else if ("tika:uti".equals(str3)) {
            this.b.setUniformTypeIdentifier(this.d.toString().trim());
            this.d = null;
        } else if ("tika:link".equals(str3)) {
            try {
                this.b.addLink(new URI(this.d.toString().trim()));
                this.d = null;
            } catch (URISyntaxException e2) {
                throw new IllegalArgumentException("unable to parse link: " + this.d, e2);
            }
        } else if ("match".equals(str3)) {
            this.e.b();
        } else if ("magic".equals(str3)) {
            for (Clause magic : this.e.a()) {
                MimeType mimeType = this.b;
                mimeType.addMagic(new Magic(mimeType, this.c, magic));
            }
            this.e = null;
        }
    }

    public void g(InputStream inputStream) {
        SAXParser sAXParser = null;
        try {
            sAXParser = c();
            sAXParser.parse(inputStream, this);
            h(sAXParser);
        } catch (TikaException e2) {
            throw new MimeTypeException("Unable to create an XML parser", e2);
        } catch (SAXException e3) {
            throw new MimeTypeException("Invalid type configuration", e3);
        } catch (Throwable th) {
            if (sAXParser != null) {
                h(sAXParser);
            }
            throw th;
        }
    }

    public InputSource resolveEntity(String str, String str2) {
        return new InputSource(new UnsynchronizedByteArrayInputStream(new byte[0]));
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (this.b == null) {
            if ("mime-type".equals(str3)) {
                String value = attributes.getValue("type");
                boolean equals = BooleanUtils.TRUE.equals(attributes.getValue("interpreted"));
                try {
                    MimeType forName = this.f9152a.forName(value);
                    this.b = forName;
                    forName.setInterpreted(equals);
                } catch (MimeTypeException e2) {
                    e(value, e2, str3, attributes);
                }
            }
        } else if ("alias".equals(str3)) {
            this.f9152a.addAlias(this.b, MediaType.parse(attributes.getValue("type")));
        } else if ("sub-class-of".equals(str3)) {
            this.f9152a.setSuperType(this.b, MediaType.parse(attributes.getValue("type")));
        } else if ("acronym".equals(str3) || "_comment".equals(str3) || "tika:link".equals(str3) || "tika:uti".equals(str3)) {
            this.d = new StringBuilder();
        } else if ("glob".equals(str3)) {
            String value2 = attributes.getValue("pattern");
            String value3 = attributes.getValue("isregex");
            if (value2 != null) {
                try {
                    this.f9152a.addPattern(this.b, value2, Boolean.parseBoolean(value3));
                } catch (MimeTypeException e3) {
                    d(this.b, value2, e3, str3, attributes);
                }
            }
        } else if ("root-XML".equals(str3)) {
            this.b.addRootXML(attributes.getValue("namespaceURI"), attributes.getValue("localName"));
        } else if ("match".equals(str3)) {
            if (attributes.getValue("minShouldMatch") != null) {
                this.e = new ClauseRecord(new MinShouldMatchVal(Integer.parseInt(attributes.getValue("minShouldMatch"))));
                return;
            }
            String value4 = attributes.getValue("type");
            String value5 = attributes.getValue("offset");
            String value6 = attributes.getValue(AccountConstantKt.RESPONSE_VALUE);
            String value7 = attributes.getValue("mask");
            if (value4 == null) {
                value4 = "string";
            }
            this.e = new ClauseRecord(new MagicMatch(this.b.getType(), value4, value5, value6, value7));
        } else if ("magic".equals(str3)) {
            String value8 = attributes.getValue("priority");
            if (value8 == null || value8.length() <= 0) {
                this.c = 50;
            } else {
                this.c = Integer.parseInt(value8);
            }
            this.e = new ClauseRecord((Clause) null);
        }
    }
}
