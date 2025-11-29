package org.apache.tika.parser;

import java.io.IOException;
import java.io.InputStream;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.exception.TikaException;
import org.apache.tika.extractor.EmbeddedDocumentExtractor;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaTypeRegistry;
import org.apache.tika.parser.RecursiveParserWrapper;
import org.apache.tika.sax.SecureContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class AutoDetectParser extends CompositeParser {
    private static final long serialVersionUID = 6110455808615143122L;
    private AutoDetectParserConfig autoDetectParserConfig;
    private Detector detector;

    public AutoDetectParser() {
        this(TikaConfig.m());
    }

    private static Parser buildFallbackParser(TikaConfig tikaConfig) {
        Parser y = tikaConfig.y();
        Parser fallback = y instanceof DefaultParser ? ((DefaultParser) y).getFallback() : new EmptyParser();
        return tikaConfig.j().getDigesterFactory() == null ? fallback : new DigestingParser(fallback, tikaConfig.j().getDigesterFactory().build(), tikaConfig.j().getDigesterFactory().a());
    }

    private SecureContentHandler createSecureContentHandler(ContentHandler contentHandler, TikaInputStream tikaInputStream, AutoDetectParserConfig autoDetectParserConfig2) {
        SecureContentHandler secureContentHandler = new SecureContentHandler(contentHandler, tikaInputStream);
        if (autoDetectParserConfig2 == null) {
            return secureContentHandler;
        }
        if (autoDetectParserConfig2.getOutputThreshold() != null) {
            secureContentHandler.h(autoDetectParserConfig2.getOutputThreshold().longValue());
        }
        if (autoDetectParserConfig2.getMaximumCompressionRatio() != null) {
            secureContentHandler.e(autoDetectParserConfig2.getMaximumCompressionRatio().longValue());
        }
        if (autoDetectParserConfig2.getMaximumDepth() != null) {
            secureContentHandler.f(autoDetectParserConfig2.getMaximumDepth().intValue());
        }
        if (autoDetectParserConfig2.getMaximumPackageEntryDepth() != null) {
            secureContentHandler.g(autoDetectParserConfig2.getMaximumPackageEntryDepth().intValue());
        }
        return secureContentHandler;
    }

    private ContentHandler decorateHandler(ContentHandler contentHandler, Metadata metadata, ParseContext parseContext, AutoDetectParserConfig autoDetectParserConfig2) {
        if (parseContext.get(RecursiveParserWrapper.RecursivelySecureContentHandler.class) != null) {
            return autoDetectParserConfig2.getContentHandlerDecoratorFactory().decorate(contentHandler, metadata, parseContext);
        }
        ParseRecord parseRecord = (ParseRecord) parseContext.get(ParseRecord.class);
        return (parseRecord == null || parseRecord.e() == 0) ? autoDetectParserConfig2.getContentHandlerDecoratorFactory().decorate(contentHandler, metadata, parseContext) : contentHandler;
    }

    private static Parser getParser(TikaConfig tikaConfig) {
        return tikaConfig.j().getDigesterFactory() == null ? tikaConfig.y() : new DigestingParser(tikaConfig.y(), tikaConfig.j().getDigesterFactory().build(), tikaConfig.j().getDigesterFactory().a());
    }

    private void initializeEmbeddedDocumentExtractor(Metadata metadata, ParseContext parseContext) {
        Class cls = EmbeddedDocumentExtractor.class;
        if (parseContext.get(cls) == null) {
            Class cls2 = Parser.class;
            if (((Parser) parseContext.get(cls2)) == null) {
                parseContext.set(cls2, this);
            }
            parseContext.set(cls, this.autoDetectParserConfig.getEmbeddedDocumentExtractorFactory().newInstance(metadata, parseContext));
        }
    }

    private void maybeSpool(TikaInputStream tikaInputStream, AutoDetectParserConfig autoDetectParserConfig2, Metadata metadata) throws IOException {
        if (tikaInputStream.T() || autoDetectParserConfig2.getSpoolToDisk() == null) {
            return;
        }
        if (autoDetectParserConfig2.getSpoolToDisk().longValue() == 0) {
            tikaInputStream.J();
            metadata.set("Content-Length", Long.toString(tikaInputStream.w()));
        } else if (metadata.get("Content-Length") != null) {
            try {
                if (Long.parseLong(metadata.get("Content-Length")) > autoDetectParserConfig2.getSpoolToDisk().longValue()) {
                    tikaInputStream.J();
                    metadata.set("Content-Length", Long.toString(tikaInputStream.w()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    public Detector getDetector() {
        return this.detector;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064 A[Catch:{ SAXException -> 0x008a, all -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068 A[Catch:{ SAXException -> 0x008a, all -> 0x0040 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.io.InputStream r5, org.xml.sax.ContentHandler r6, org.apache.tika.metadata.Metadata r7, org.apache.tika.parser.ParseContext r8) throws java.io.IOException, org.xml.sax.SAXException, org.apache.tika.exception.TikaException {
        /*
            r4 = this;
            org.apache.tika.parser.AutoDetectParserConfig r0 = r4.autoDetectParserConfig
            org.apache.tika.metadata.writefilter.MetadataWriteFilterFactory r0 = r0.getMetadataWriteFilterFactory()
            if (r0 == 0) goto L_0x0015
            org.apache.tika.parser.AutoDetectParserConfig r0 = r4.autoDetectParserConfig
            org.apache.tika.metadata.writefilter.MetadataWriteFilterFactory r0 = r0.getMetadataWriteFilterFactory()
            org.apache.tika.metadata.writefilter.MetadataWriteFilter r0 = r0.newInstance()
            r7.setMetadataWriteFilter(r0)
        L_0x0015:
            org.apache.tika.io.TemporaryResources r0 = new org.apache.tika.io.TemporaryResources
            r0.<init>()
            org.apache.tika.io.TikaInputStream r5 = org.apache.tika.io.TikaInputStream.g(r5, r0, r7)     // Catch:{ all -> 0x0040 }
            org.apache.tika.parser.AutoDetectParserConfig r1 = r4.autoDetectParserConfig     // Catch:{ all -> 0x0040 }
            r4.maybeSpool(r5, r1, r7)     // Catch:{ all -> 0x0040 }
            org.apache.tika.detect.Detector r1 = r4.detector     // Catch:{ all -> 0x0040 }
            org.apache.tika.mime.MediaType r1 = r1.detect(r5, r7)     // Catch:{ all -> 0x0040 }
            org.apache.tika.metadata.Property r2 = org.apache.tika.metadata.TikaCoreProperties.x     // Catch:{ all -> 0x0040 }
            java.lang.String r3 = r7.get((org.apache.tika.metadata.Property) r2)     // Catch:{ all -> 0x0040 }
            if (r3 == 0) goto L_0x0042
            java.lang.String r2 = r7.get((org.apache.tika.metadata.Property) r2)     // Catch:{ all -> 0x0040 }
            java.lang.String r3 = r1.toString()     // Catch:{ all -> 0x0040 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0040 }
            if (r2 != 0) goto L_0x004b
            goto L_0x0042
        L_0x0040:
            r4 = move-exception
            goto L_0x008f
        L_0x0042:
            java.lang.String r2 = "Content-Type"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0040 }
            r7.set((java.lang.String) r2, (java.lang.String) r1)     // Catch:{ all -> 0x0040 }
        L_0x004b:
            java.lang.Object r1 = r5.z()     // Catch:{ all -> 0x0040 }
            if (r1 != 0) goto L_0x0070
            org.apache.tika.parser.AutoDetectParserConfig r1 = r4.autoDetectParserConfig     // Catch:{ all -> 0x0040 }
            boolean r1 = r1.getThrowOnZeroBytes()     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x0070
            r1 = 1
            r5.mark(r1)     // Catch:{ all -> 0x0040 }
            int r1 = r5.read()     // Catch:{ all -> 0x0040 }
            r2 = -1
            if (r1 == r2) goto L_0x0068
            r5.reset()     // Catch:{ all -> 0x0040 }
            goto L_0x0070
        L_0x0068:
            org.apache.tika.exception.ZeroByteFileException r4 = new org.apache.tika.exception.ZeroByteFileException     // Catch:{ all -> 0x0040 }
            java.lang.String r5 = "InputStream must have > 0 bytes"
            r4.<init>(r5)     // Catch:{ all -> 0x0040 }
            throw r4     // Catch:{ all -> 0x0040 }
        L_0x0070:
            org.apache.tika.parser.AutoDetectParserConfig r1 = r4.autoDetectParserConfig     // Catch:{ all -> 0x0040 }
            org.xml.sax.ContentHandler r6 = r4.decorateHandler(r6, r7, r8, r1)     // Catch:{ all -> 0x0040 }
            if (r6 == 0) goto L_0x007f
            org.apache.tika.parser.AutoDetectParserConfig r1 = r4.autoDetectParserConfig     // Catch:{ all -> 0x0040 }
            org.apache.tika.sax.SecureContentHandler r6 = r4.createSecureContentHandler(r6, r5, r1)     // Catch:{ all -> 0x0040 }
            goto L_0x0080
        L_0x007f:
            r6 = 0
        L_0x0080:
            r4.initializeEmbeddedDocumentExtractor(r7, r8)     // Catch:{ all -> 0x0040 }
            super.parse(r5, r6, r7, r8)     // Catch:{ SAXException -> 0x008a }
            r0.dispose()
            return
        L_0x008a:
            r4 = move-exception
            r6.i(r4)     // Catch:{ all -> 0x0040 }
            throw r4     // Catch:{ all -> 0x0040 }
        L_0x008f:
            r0.dispose()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.parser.AutoDetectParser.parse(java.io.InputStream, org.xml.sax.ContentHandler, org.apache.tika.metadata.Metadata, org.apache.tika.parser.ParseContext):void");
    }

    public void setAutoDetectParserConfig(AutoDetectParserConfig autoDetectParserConfig2) {
        this.autoDetectParserConfig = autoDetectParserConfig2;
    }

    public void setDetector(Detector detector2) {
        this.detector = detector2;
    }

    public AutoDetectParser(Detector detector2) {
        this(TikaConfig.m());
        setDetector(detector2);
    }

    public AutoDetectParser(Parser... parserArr) {
        this(new DefaultDetector(), parserArr);
    }

    public AutoDetectParser(Detector detector2, Parser... parserArr) {
        super(MediaTypeRegistry.getDefaultRegistry(), parserArr);
        setDetector(detector2);
        setAutoDetectParserConfig(AutoDetectParserConfig.DEFAULT);
    }

    public AutoDetectParser(TikaConfig tikaConfig) {
        super(tikaConfig.w(), getParser(tikaConfig));
        setFallback(buildFallbackParser(tikaConfig));
        setDetector(tikaConfig.u());
        setAutoDetectParserConfig(tikaConfig.j());
    }

    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata) throws IOException, SAXException, TikaException {
        ParseContext parseContext = new ParseContext();
        parseContext.set(Parser.class, this);
        parse(inputStream, contentHandler, metadata, parseContext);
    }
}
