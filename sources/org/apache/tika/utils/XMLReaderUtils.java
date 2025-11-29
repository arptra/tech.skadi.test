package org.apache.tika.utils;

import com.honey.account.oc.e;
import com.honey.account.oc.f;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.OfflineContentHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class XMLReaderUtils implements Serializable {
    public static final int DEFAULT_MAX_ENTITY_EXPANSIONS = 20;
    public static final int DEFAULT_POOL_SIZE = 10;
    private static ArrayBlockingQueue<PoolDOMBuilder> DOM_BUILDERS = new ArrayBlockingQueue<>(POOL_SIZE);
    private static final ReentrantReadWriteLock DOM_READ_WRITE_LOCK = new ReentrantReadWriteLock();
    private static final AtomicBoolean HAS_WARNED_STAX = new AtomicBoolean(false);
    private static final ContentHandler IGNORING_CONTENT_HANDLER = new DefaultHandler();
    private static final DTDHandler IGNORING_DTD_HANDLER = new DTDHandler() {
        public void notationDecl(String str, String str2, String str3) {
        }

        public void unparsedEntityDecl(String str, String str2, String str3, String str4) {
        }
    };
    private static final ErrorHandler IGNORING_ERROR_HANDLER = new ErrorHandler() {
        public void error(SAXParseException sAXParseException) {
        }

        public void fatalError(SAXParseException sAXParseException) {
        }

        public void warning(SAXParseException sAXParseException) {
        }
    };
    /* access modifiers changed from: private */
    public static final EntityResolver IGNORING_SAX_ENTITY_RESOLVER = new e();
    private static final XMLResolver IGNORING_STAX_ENTITY_RESOLVER = new f();
    private static final String JAXP_ENTITY_EXPANSION_LIMIT_KEY = "jdk.xml.entityExpansionLimit";
    private static long LAST_LOG = -1;
    /* access modifiers changed from: private */
    public static final Logger LOG = LoggerFactory.k(XMLReaderUtils.class);
    private static volatile int MAX_ENTITY_EXPANSIONS = determineMaxEntityExpansions();
    private static final AtomicInteger POOL_GENERATION = new AtomicInteger();
    private static int POOL_SIZE = 10;
    private static ArrayBlockingQueue<PoolSAXParser> SAX_PARSERS = new ArrayBlockingQueue<>(POOL_SIZE);
    private static final ReentrantReadWriteLock SAX_READ_WRITE_LOCK = new ReentrantReadWriteLock();
    private static final String XERCES_SECURITY_MANAGER = "org.apache.xerces.util.SecurityManager";
    private static final String XERCES_SECURITY_MANAGER_PROPERTY = "http://apache.org/xml/properties/security-manager";
    private static final long serialVersionUID = 6110455808615143122L;

    public static class BuiltInPoolSAXParser extends PoolSAXParser {
        public BuiltInPoolSAXParser(int i, SAXParser sAXParser) {
            super(i, sAXParser);
        }

        public void c() {
            this.b.reset();
            try {
                XMLReaderUtils.clearReader(this.b.getXMLReader());
            } catch (SAXException unused) {
            }
        }
    }

    public static class PoolDOMBuilder {

        /* renamed from: a  reason: collision with root package name */
        public final int f3347a;
        public final DocumentBuilder b;

        public PoolDOMBuilder(int i, DocumentBuilder documentBuilder) {
            this.f3347a = i;
            this.b = documentBuilder;
        }

        public DocumentBuilder a() {
            return this.b;
        }

        public int b() {
            return this.f3347a;
        }

        public void c() {
            this.b.reset();
            this.b.setEntityResolver(XMLReaderUtils.IGNORING_SAX_ENTITY_RESOLVER);
            this.b.setErrorHandler((ErrorHandler) null);
        }
    }

    public static abstract class PoolSAXParser {

        /* renamed from: a  reason: collision with root package name */
        public final int f3348a;
        public final SAXParser b;

        public PoolSAXParser(int i, SAXParser sAXParser) {
            this.f3348a = i;
            this.b = sAXParser;
        }

        public int a() {
            return this.f3348a;
        }

        public SAXParser b() {
            return this.b;
        }

        public abstract void c();
    }

    public static class UnrecognizedPoolSAXParser extends PoolSAXParser {
        public UnrecognizedPoolSAXParser(int i, SAXParser sAXParser) {
            super(i, sAXParser);
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0005 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c() {
            /*
                r1 = this;
                javax.xml.parsers.SAXParser r0 = r1.b     // Catch:{ UnsupportedOperationException -> 0x0005 }
                r0.reset()     // Catch:{ UnsupportedOperationException -> 0x0005 }
            L_0x0005:
                javax.xml.parsers.SAXParser r0 = r1.b     // Catch:{ SAXException -> 0x000e }
                org.xml.sax.XMLReader r0 = r0.getXMLReader()     // Catch:{ SAXException -> 0x000e }
                org.apache.tika.utils.XMLReaderUtils.clearReader(r0)     // Catch:{ SAXException -> 0x000e }
            L_0x000e:
                javax.xml.parsers.SAXParser r1 = r1.b
                org.apache.tika.utils.XMLReaderUtils.trySetXercesSecurityManager((javax.xml.parsers.SAXParser) r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.utils.XMLReaderUtils.UnrecognizedPoolSAXParser.c():void");
        }
    }

    public static class Xerces2PoolSAXParser extends PoolSAXParser {
        public Xerces2PoolSAXParser(int i, SAXParser sAXParser) {
            super(i, sAXParser);
        }

        public void c() {
            try {
                Object property = this.b.getProperty(XMLReaderUtils.XERCES_SECURITY_MANAGER_PROPERTY);
                this.b.reset();
                this.b.setProperty(XMLReaderUtils.XERCES_SECURITY_MANAGER_PROPERTY, property);
            } catch (SAXException e) {
                XMLReaderUtils.LOG.warn("problem resetting sax parser", (Throwable) e);
            }
            try {
                XMLReaderUtils.clearReader(this.b.getXMLReader());
            } catch (SAXException unused) {
            }
        }
    }

    public static class XercesPoolSAXParser extends PoolSAXParser {
        public XercesPoolSAXParser(int i, SAXParser sAXParser) {
            super(i, sAXParser);
        }

        public void c() {
            try {
                XMLReaderUtils.clearReader(this.b.getXMLReader());
            } catch (SAXException unused) {
            }
        }
    }

    static {
        try {
            setPoolSize(POOL_SIZE);
        } catch (TikaException e) {
            throw new RuntimeException("problem initializing SAXParser and DOMBuilder pools", e);
        }
    }

    private static PoolDOMBuilder acquireDOMBuilder() throws TikaException {
        int i = 0;
        long j = -1;
        do {
            ReentrantReadWriteLock reentrantReadWriteLock = DOM_READ_WRITE_LOCK;
            reentrantReadWriteLock.readLock().lock();
            try {
                PoolDOMBuilder poll = DOM_BUILDERS.poll(100, TimeUnit.MILLISECONDS);
                reentrantReadWriteLock.readLock().unlock();
                if (poll != null) {
                    return poll;
                }
                if (j < 0 || System.currentTimeMillis() - j > 1000) {
                    LOG.warn("Contention waiting for a DOMParser. Consider increasing the XMLReaderUtils.POOL_SIZE");
                    j = System.currentTimeMillis();
                }
                i++;
            } catch (InterruptedException e) {
                throw new TikaException("interrupted while waiting for DOMBuilder", e);
            } catch (Throwable th) {
                DOM_READ_WRITE_LOCK.readLock().unlock();
                throw th;
            }
        } while (i <= 3000);
        setPoolSize(POOL_SIZE);
        throw new TikaException("Waited more than 5 minutes for a DocumentBuilder; This could indicate that a parser has not correctly released its DocumentBuilder. Please report this to the Tika team: dev@tika.apache.org");
    }

    private static PoolSAXParser acquireSAXParser() throws TikaException {
        int i = 0;
        long j = -1;
        do {
            ReentrantReadWriteLock reentrantReadWriteLock = SAX_READ_WRITE_LOCK;
            reentrantReadWriteLock.readLock().lock();
            try {
                PoolSAXParser poll = SAX_PARSERS.poll(100, TimeUnit.MILLISECONDS);
                reentrantReadWriteLock.readLock().unlock();
                if (poll != null) {
                    return poll;
                }
                if (j < 0 || System.currentTimeMillis() - j > 1000) {
                    LOG.warn("Contention waiting for a SAXParser. Consider increasing the XMLReaderUtils.POOL_SIZE");
                    j = System.currentTimeMillis();
                }
                i++;
            } catch (InterruptedException e) {
                throw new TikaException("interrupted while waiting for SAXParser", e);
            } catch (Throwable th) {
                SAX_READ_WRITE_LOCK.readLock().unlock();
                throw th;
            }
        } while (i <= 3000);
        setPoolSize(POOL_SIZE);
        throw new TikaException("Waited more than 5 minutes for a SAXParser; This could indicate that a parser has not correctly released its SAXParser. Please report this to the Tika team: dev@tika.apache.org");
    }

    public static Document buildDOM(InputStream inputStream, ParseContext parseContext) throws TikaException, IOException, SAXException {
        PoolDOMBuilder poolDOMBuilder;
        DocumentBuilder documentBuilder = (DocumentBuilder) parseContext.get(DocumentBuilder.class);
        if (documentBuilder == null) {
            PoolDOMBuilder acquireDOMBuilder = acquireDOMBuilder();
            poolDOMBuilder = acquireDOMBuilder;
            documentBuilder = acquireDOMBuilder.a();
        } else {
            poolDOMBuilder = null;
        }
        try {
            return documentBuilder.parse(inputStream);
        } finally {
            if (poolDOMBuilder != null) {
                releaseDOMBuilder(poolDOMBuilder);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0094 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009e A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.apache.tika.utils.XMLReaderUtils.PoolSAXParser buildPoolParser(int r13, javax.xml.parsers.SAXParser r14) {
        /*
            java.lang.String r0 = "SAX Security Manager could not be setup [log suppressed for 5 minutes]"
            r1 = 0
            r2 = 1
            r14.reset()     // Catch:{ UnsupportedOperationException -> 0x0009 }
            r3 = r2
            goto L_0x000a
        L_0x0009:
            r3 = r1
        L_0x000a:
            r4 = 5
            java.lang.String r6 = "org.apache.xerces.util.SecurityManager"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ SecurityException -> 0x003c, ClassNotFoundException -> 0x005b, all -> 0x003a }
            java.lang.Object r6 = r6.newInstance()     // Catch:{ SecurityException -> 0x003c, ClassNotFoundException -> 0x005b, all -> 0x003a }
            java.lang.Class r7 = r6.getClass()     // Catch:{ SecurityException -> 0x003c, ClassNotFoundException -> 0x005b, all -> 0x003a }
            java.lang.String r8 = "setEntityExpansionLimit"
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ SecurityException -> 0x003c, ClassNotFoundException -> 0x005b, all -> 0x003a }
            java.lang.Class[] r9 = new java.lang.Class[]{r9}     // Catch:{ SecurityException -> 0x003c, ClassNotFoundException -> 0x005b, all -> 0x003a }
            java.lang.reflect.Method r7 = r7.getMethod(r8, r9)     // Catch:{ SecurityException -> 0x003c, ClassNotFoundException -> 0x005b, all -> 0x003a }
            int r8 = MAX_ENTITY_EXPANSIONS     // Catch:{ SecurityException -> 0x003c, ClassNotFoundException -> 0x005b, all -> 0x003a }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ SecurityException -> 0x003c, ClassNotFoundException -> 0x005b, all -> 0x003a }
            java.lang.Object[] r8 = new java.lang.Object[]{r8}     // Catch:{ SecurityException -> 0x003c, ClassNotFoundException -> 0x005b, all -> 0x003a }
            r7.invoke(r6, r8)     // Catch:{ SecurityException -> 0x003c, ClassNotFoundException -> 0x005b, all -> 0x003a }
            java.lang.String r7 = "http://apache.org/xml/properties/security-manager"
            r14.setProperty(r7, r6)     // Catch:{ SecurityException -> 0x003c, ClassNotFoundException -> 0x005b, all -> 0x003a }
            r6 = r2
            goto L_0x005c
        L_0x003a:
            r6 = move-exception
            goto L_0x003f
        L_0x003c:
            r13 = move-exception
            goto L_0x00ae
        L_0x003f:
            long r7 = java.lang.System.currentTimeMillis()
            long r9 = LAST_LOG
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MINUTES
            long r11 = r11.toMillis(r4)
            long r9 = r9 + r11
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x005b
            org.slf4j.Logger r7 = LOG
            r7.warn((java.lang.String) r0, (java.lang.Throwable) r6)
            long r6 = java.lang.System.currentTimeMillis()
            LAST_LOG = r6
        L_0x005b:
            r6 = r1
        L_0x005c:
            if (r6 != 0) goto L_0x0088
            java.lang.String r7 = "http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit"
            int r8 = MAX_ENTITY_EXPANSIONS     // Catch:{ SAXException -> 0x006b }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ SAXException -> 0x006b }
            r14.setProperty(r7, r8)     // Catch:{ SAXException -> 0x006b }
            r1 = r2
            goto L_0x0088
        L_0x006b:
            r2 = move-exception
            long r7 = java.lang.System.currentTimeMillis()
            long r9 = LAST_LOG
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MINUTES
            long r4 = r11.toMillis(r4)
            long r9 = r9 + r4
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x0088
            org.slf4j.Logger r4 = LOG
            r4.warn((java.lang.String) r0, (java.lang.Throwable) r2)
            long r4 = java.lang.System.currentTimeMillis()
            LAST_LOG = r4
        L_0x0088:
            if (r3 != 0) goto L_0x0092
            if (r6 == 0) goto L_0x0092
            org.apache.tika.utils.XMLReaderUtils$XercesPoolSAXParser r0 = new org.apache.tika.utils.XMLReaderUtils$XercesPoolSAXParser
            r0.<init>(r13, r14)
            return r0
        L_0x0092:
            if (r3 == 0) goto L_0x009c
            if (r6 == 0) goto L_0x009c
            org.apache.tika.utils.XMLReaderUtils$Xerces2PoolSAXParser r0 = new org.apache.tika.utils.XMLReaderUtils$Xerces2PoolSAXParser
            r0.<init>(r13, r14)
            return r0
        L_0x009c:
            if (r3 == 0) goto L_0x00a8
            if (r6 != 0) goto L_0x00a8
            if (r1 == 0) goto L_0x00a8
            org.apache.tika.utils.XMLReaderUtils$BuiltInPoolSAXParser r0 = new org.apache.tika.utils.XMLReaderUtils$BuiltInPoolSAXParser
            r0.<init>(r13, r14)
            return r0
        L_0x00a8:
            org.apache.tika.utils.XMLReaderUtils$UnrecognizedPoolSAXParser r0 = new org.apache.tika.utils.XMLReaderUtils$UnrecognizedPoolSAXParser
            r0.<init>(r13, r14)
            return r0
        L_0x00ae:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.utils.XMLReaderUtils.buildPoolParser(int, javax.xml.parsers.SAXParser):org.apache.tika.utils.XMLReaderUtils$PoolSAXParser");
    }

    /* access modifiers changed from: private */
    public static void clearReader(XMLReader xMLReader) {
        if (xMLReader != null) {
            xMLReader.setContentHandler(IGNORING_CONTENT_HANDLER);
            xMLReader.setDTDHandler(IGNORING_DTD_HANDLER);
            xMLReader.setEntityResolver(IGNORING_SAX_ENTITY_RESOLVER);
            xMLReader.setErrorHandler(IGNORING_ERROR_HANDLER);
        }
    }

    private static int determineMaxEntityExpansions() {
        String property = System.getProperty(JAXP_ENTITY_EXPANSION_LIMIT_KEY);
        if (property != null) {
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException unused) {
                LOG.warn("Couldn't parse an integer for the entity expansion limit: {}; backing off to default: {}", property, 20);
            }
        }
        return 20;
    }

    public static String getAttrValue(String str, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (str.equals(attributes.getLocalName(i))) {
                return attributes.getValue(i);
            }
        }
        return null;
    }

    public static DocumentBuilder getDocumentBuilder() throws TikaException {
        try {
            DocumentBuilder newDocumentBuilder = getDocumentBuilderFactory().newDocumentBuilder();
            newDocumentBuilder.setEntityResolver(IGNORING_SAX_ENTITY_RESOLVER);
            newDocumentBuilder.setErrorHandler((ErrorHandler) null);
            return newDocumentBuilder;
        } catch (ParserConfigurationException e) {
            throw new TikaException("XML parser not available", e);
        }
    }

    public static DocumentBuilderFactory getDocumentBuilderFactory() {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setExpandEntityReferences(false);
        newInstance.setNamespaceAware(true);
        newInstance.setValidating(false);
        trySetSAXFeature(newInstance, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        trySetSAXFeature(newInstance, "http://xml.org/sax/features/external-general-entities", false);
        trySetSAXFeature(newInstance, "http://xml.org/sax/features/external-parameter-entities", false);
        trySetSAXFeature(newInstance, "http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        trySetSAXFeature(newInstance, "http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
        trySetXercesSecurityManager(newInstance);
        return newInstance;
    }

    public static int getMaxEntityExpansions() {
        return MAX_ENTITY_EXPANSIONS;
    }

    public static int getPoolSize() {
        return POOL_SIZE;
    }

    public static SAXParser getSAXParser() throws TikaException {
        try {
            SAXParser newSAXParser = getSAXParserFactory().newSAXParser();
            trySetXercesSecurityManager(newSAXParser);
            return newSAXParser;
        } catch (ParserConfigurationException e) {
            throw new TikaException("Unable to configure a SAX parser", e);
        } catch (SAXException e2) {
            throw new TikaException("Unable to create a SAX parser", e2);
        }
    }

    public static SAXParserFactory getSAXParserFactory() {
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        newInstance.setValidating(false);
        trySetSAXFeature(newInstance, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        trySetSAXFeature(newInstance, "http://xml.org/sax/features/external-general-entities", false);
        trySetSAXFeature(newInstance, "http://xml.org/sax/features/external-parameter-entities", false);
        trySetSAXFeature(newInstance, "http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        trySetSAXFeature(newInstance, "http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
        return newInstance;
    }

    public static Transformer getTransformer() throws TikaException {
        try {
            TransformerFactory newInstance = TransformerFactory.newInstance();
            newInstance.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
            trySetTransformerAttribute(newInstance, "http://javax.xml.XMLConstants/property/accessExternalDTD", "");
            trySetTransformerAttribute(newInstance, "http://javax.xml.XMLConstants/property/accessExternalStylesheet", "");
            return newInstance.newTransformer();
        } catch (TransformerConfigurationException | TransformerFactoryConfigurationError e) {
            throw new TikaException("Transformer not available", e);
        }
    }

    public static XMLInputFactory getXMLInputFactory() {
        XMLInputFactory newFactory = XMLInputFactory.newFactory();
        tryToSetStaxProperty(newFactory, "javax.xml.stream.isNamespaceAware", true);
        tryToSetStaxProperty(newFactory, "javax.xml.stream.isValidating", false);
        newFactory.b(IGNORING_STAX_ENTITY_RESOLVER);
        trySetStaxSecurityManager(newFactory);
        return newFactory;
    }

    public static XMLReader getXMLReader() throws TikaException {
        try {
            XMLReader xMLReader = getSAXParser().getXMLReader();
            xMLReader.setEntityResolver(IGNORING_SAX_ENTITY_RESOLVER);
            return xMLReader;
        } catch (SAXException e) {
            throw new TikaException("Unable to create an XMLReader", e);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ InputSource lambda$static$0(String str, String str2) throws SAXException, IOException {
        return new InputSource(new StringReader(""));
    }

    private static /* synthetic */ Object lambda$static$1(String str, String str2, String str3, String str4) throws XMLStreamException {
        return "";
    }

    public static void parseSAX(InputStream inputStream, ContentHandler contentHandler, ParseContext parseContext) throws TikaException, IOException, SAXException {
        PoolSAXParser poolSAXParser;
        SAXParser sAXParser = (SAXParser) parseContext.get(SAXParser.class);
        if (sAXParser == null) {
            PoolSAXParser acquireSAXParser = acquireSAXParser();
            poolSAXParser = acquireSAXParser;
            sAXParser = acquireSAXParser.b();
        } else {
            poolSAXParser = null;
        }
        try {
            sAXParser.parse(inputStream, new OfflineContentHandler(contentHandler));
        } finally {
            if (poolSAXParser != null) {
                releaseParser(poolSAXParser);
            }
        }
    }

    private static void releaseDOMBuilder(PoolDOMBuilder poolDOMBuilder) {
        if (poolDOMBuilder.b() == POOL_GENERATION.get()) {
            try {
                poolDOMBuilder.c();
            } catch (UnsupportedOperationException unused) {
            }
            ReentrantReadWriteLock reentrantReadWriteLock = DOM_READ_WRITE_LOCK;
            reentrantReadWriteLock.readLock().lock();
            try {
                if (!DOM_BUILDERS.offer(poolDOMBuilder)) {
                    LOG.warn("DocumentBuilder not taken back into pool.  If you haven't resized the pool, this could be a sign that there are more calls to 'acquire' than to 'release'");
                }
                reentrantReadWriteLock.readLock().unlock();
            } catch (Throwable th) {
                DOM_READ_WRITE_LOCK.readLock().unlock();
                throw th;
            }
        }
    }

    private static void releaseParser(PoolSAXParser poolSAXParser) {
        try {
            poolSAXParser.c();
        } catch (UnsupportedOperationException unused) {
        }
        if (poolSAXParser.a() == POOL_GENERATION.get()) {
            ReentrantReadWriteLock reentrantReadWriteLock = SAX_READ_WRITE_LOCK;
            reentrantReadWriteLock.readLock().lock();
            try {
                if (!SAX_PARSERS.offer(poolSAXParser)) {
                    LOG.warn("SAXParser not taken back into pool.  If you haven't resized the pool this could be a sign that there are more calls to 'acquire' than to 'release'");
                }
                reentrantReadWriteLock.readLock().unlock();
            } catch (Throwable th) {
                SAX_READ_WRITE_LOCK.readLock().unlock();
                throw th;
            }
        }
    }

    public static void setMaxEntityExpansions(int i) {
        MAX_ENTITY_EXPANSIONS = i;
    }

    /* JADX INFO: finally extract failed */
    public static void setPoolSize(int i) throws TikaException {
        SAX_READ_WRITE_LOCK.writeLock().lock();
        try {
            Iterator<PoolSAXParser> it = SAX_PARSERS.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            SAX_PARSERS.clear();
            SAX_PARSERS = new ArrayBlockingQueue<>(i);
            int incrementAndGet = POOL_GENERATION.incrementAndGet();
            for (int i2 = 0; i2 < i; i2++) {
                SAX_PARSERS.offer(buildPoolParser(incrementAndGet, getSAXParserFactory().newSAXParser()));
            }
            SAX_READ_WRITE_LOCK.writeLock().unlock();
            DOM_READ_WRITE_LOCK.writeLock().lock();
            try {
                DOM_BUILDERS.clear();
                DOM_BUILDERS = new ArrayBlockingQueue<>(i);
                for (int i3 = 0; i3 < i; i3++) {
                    DOM_BUILDERS.offer(new PoolDOMBuilder(POOL_GENERATION.get(), getDocumentBuilder()));
                }
                DOM_READ_WRITE_LOCK.writeLock().unlock();
                POOL_SIZE = i;
            } catch (Throwable th) {
                DOM_READ_WRITE_LOCK.writeLock().unlock();
                throw th;
            }
        } catch (ParserConfigurationException | SAXException e) {
            throw new TikaException("problem creating sax parser", e);
        } catch (Throwable th2) {
            SAX_READ_WRITE_LOCK.writeLock().unlock();
            throw th2;
        }
    }

    private static void trySetSAXFeature(SAXParserFactory sAXParserFactory, String str, boolean z) {
        try {
            sAXParserFactory.setFeature(str, z);
        } catch (SecurityException e) {
            throw e;
        } catch (Exception e2) {
            LOG.warn("SAX Feature unsupported: {}", str, e2);
        } catch (AbstractMethodError e3) {
            LOG.warn("Cannot set SAX feature because outdated XML parser in classpath: {}", str, e3);
        }
    }

    private static void trySetStaxSecurityManager(XMLInputFactory xMLInputFactory) {
        try {
            xMLInputFactory.a("http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit", Integer.valueOf(MAX_ENTITY_EXPANSIONS));
        } catch (IllegalArgumentException unused) {
            try {
                xMLInputFactory.a("com.ctc.wstx.maxEntityCount", Integer.valueOf(MAX_ENTITY_EXPANSIONS));
            } catch (IllegalArgumentException unused2) {
                if (!HAS_WARNED_STAX.getAndSet(true)) {
                    Logger logger = LOG;
                    logger.warn("Could not set limit on maximum entity expansions for: " + xMLInputFactory.getClass());
                }
            }
        }
    }

    private static void trySetTransformerAttribute(TransformerFactory transformerFactory, String str, String str2) {
        try {
            transformerFactory.setAttribute(str, str2);
        } catch (SecurityException e) {
            throw e;
        } catch (Exception e2) {
            LOG.warn("Transformer Attribute unsupported: {}", str, e2);
        } catch (AbstractMethodError e3) {
            LOG.warn("Cannot set Transformer attribute because outdated XML parser in classpath: {}", str, e3);
        }
    }

    private static void trySetXercesSecurityManager(DocumentBuilderFactory documentBuilderFactory) {
        try {
            Object newInstance = Class.forName(new String[]{XERCES_SECURITY_MANAGER}[0]).newInstance();
            newInstance.getClass().getMethod("setEntityExpansionLimit", new Class[]{Integer.TYPE}).invoke(newInstance, new Object[]{Integer.valueOf(MAX_ENTITY_EXPANSIONS)});
            documentBuilderFactory.setAttribute(XERCES_SECURITY_MANAGER_PROPERTY, newInstance);
        } catch (ClassNotFoundException unused) {
            try {
                documentBuilderFactory.setAttribute("http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit", Integer.valueOf(MAX_ENTITY_EXPANSIONS));
            } catch (IllegalArgumentException e) {
                if (System.currentTimeMillis() > LAST_LOG + TimeUnit.MINUTES.toMillis(5)) {
                    LOG.warn("SAX Security Manager could not be setup [log suppressed for 5 minutes]", (Throwable) e);
                    LAST_LOG = System.currentTimeMillis();
                }
            }
        } catch (Throwable th) {
            if (System.currentTimeMillis() > LAST_LOG + TimeUnit.MINUTES.toMillis(5)) {
                LOG.warn("SAX Security Manager could not be setup [log suppressed for 5 minutes]", th);
                LAST_LOG = System.currentTimeMillis();
            }
            documentBuilderFactory.setAttribute("http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit", Integer.valueOf(MAX_ENTITY_EXPANSIONS));
        }
    }

    private static void tryToSetStaxProperty(XMLInputFactory xMLInputFactory, String str, boolean z) {
        try {
            xMLInputFactory.a(str, Boolean.valueOf(z));
        } catch (IllegalArgumentException e) {
            LOG.warn("StAX Feature unsupported: {}", str, e);
        }
    }

    private static void trySetSAXFeature(DocumentBuilderFactory documentBuilderFactory, String str, boolean z) {
        try {
            documentBuilderFactory.setFeature(str, z);
        } catch (Exception e) {
            LOG.warn("SAX Feature unsupported: {}", str, e);
        } catch (AbstractMethodError e2) {
            LOG.warn("Cannot set SAX feature because outdated XML parser in classpath: {}", str, e2);
        }
    }

    public static Document buildDOM(Reader reader, ParseContext parseContext) throws TikaException, IOException, SAXException {
        PoolDOMBuilder poolDOMBuilder;
        DocumentBuilder documentBuilder = (DocumentBuilder) parseContext.get(DocumentBuilder.class);
        if (documentBuilder == null) {
            PoolDOMBuilder acquireDOMBuilder = acquireDOMBuilder();
            poolDOMBuilder = acquireDOMBuilder;
            documentBuilder = acquireDOMBuilder.a();
        } else {
            poolDOMBuilder = null;
        }
        try {
            return documentBuilder.parse(new InputSource(reader));
        } finally {
            if (poolDOMBuilder != null) {
                releaseDOMBuilder(poolDOMBuilder);
            }
        }
    }

    public static void parseSAX(Reader reader, ContentHandler contentHandler, ParseContext parseContext) throws TikaException, IOException, SAXException {
        PoolSAXParser poolSAXParser;
        SAXParser sAXParser = (SAXParser) parseContext.get(SAXParser.class);
        if (sAXParser == null) {
            PoolSAXParser acquireSAXParser = acquireSAXParser();
            poolSAXParser = acquireSAXParser;
            sAXParser = acquireSAXParser.b();
        } else {
            poolSAXParser = null;
        }
        try {
            sAXParser.parse(new InputSource(reader), new OfflineContentHandler(contentHandler));
        } finally {
            if (poolSAXParser != null) {
                releaseParser(poolSAXParser);
            }
        }
    }

    public static Document buildDOM(Path path) throws TikaException, IOException, SAXException {
        InputStream newInputStream = Files.newInputStream(path, new OpenOption[0]);
        try {
            Document buildDOM = buildDOM(newInputStream);
            if (newInputStream != null) {
                newInputStream.close();
            }
            return buildDOM;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    /* access modifiers changed from: private */
    public static void trySetXercesSecurityManager(SAXParser sAXParser) {
        try {
            Object newInstance = Class.forName(new String[]{XERCES_SECURITY_MANAGER}[0]).newInstance();
            newInstance.getClass().getMethod("setEntityExpansionLimit", new Class[]{Integer.TYPE}).invoke(newInstance, new Object[]{Integer.valueOf(MAX_ENTITY_EXPANSIONS)});
            sAXParser.setProperty(XERCES_SECURITY_MANAGER_PROPERTY, newInstance);
        } catch (ClassNotFoundException unused) {
            try {
                sAXParser.setProperty("http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit", Integer.valueOf(MAX_ENTITY_EXPANSIONS));
            } catch (SAXException e) {
                if (System.currentTimeMillis() > LAST_LOG + TimeUnit.MINUTES.toMillis(5)) {
                    LOG.warn("SAX Security Manager could not be setup [log suppressed for 5 minutes]", (Throwable) e);
                    LAST_LOG = System.currentTimeMillis();
                }
            }
        } catch (Throwable th) {
            if (System.currentTimeMillis() > LAST_LOG + TimeUnit.MINUTES.toMillis(5)) {
                LOG.warn("SAX Security Manager could not be setup [log suppressed for 5 minutes]", th);
                LAST_LOG = System.currentTimeMillis();
            }
            sAXParser.setProperty("http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit", Integer.valueOf(MAX_ENTITY_EXPANSIONS));
        }
    }

    public static Document buildDOM(String str) throws TikaException, IOException, SAXException {
        PoolDOMBuilder acquireDOMBuilder = acquireDOMBuilder();
        try {
            return acquireDOMBuilder.a().parse(str);
        } finally {
            releaseDOMBuilder(acquireDOMBuilder);
        }
    }

    public static Document buildDOM(InputStream inputStream) throws TikaException, IOException, SAXException {
        PoolDOMBuilder acquireDOMBuilder = acquireDOMBuilder();
        try {
            return acquireDOMBuilder.a().parse(inputStream);
        } finally {
            releaseDOMBuilder(acquireDOMBuilder);
        }
    }
}
