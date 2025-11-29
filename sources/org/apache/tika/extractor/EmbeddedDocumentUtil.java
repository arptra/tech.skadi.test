package org.apache.tika.extractor;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Iterator;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.Detector;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.CompositeParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.ParserDecorator;
import org.apache.tika.parser.PasswordProvider;
import org.apache.tika.parser.StatefulParser;
import org.apache.tika.utils.ExceptionUtils;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class EmbeddedDocumentUtil implements Serializable {
    private final ParseContext context;
    private Detector detector;
    private final EmbeddedDocumentExtractor embeddedDocumentExtractor;
    private MimeTypes mimeTypes;
    private TikaConfig tikaConfig;

    public EmbeddedDocumentUtil(ParseContext parseContext) {
        this.context = parseContext;
        this.embeddedDocumentExtractor = getEmbeddedDocumentExtractor(parseContext);
    }

    private static boolean equals(Parser parser, Class cls) {
        if (parser == null) {
            return false;
        }
        return parser.getClass().equals(cls);
    }

    private static Parser findInComposite(CompositeParser compositeParser, Class cls, ParseContext parseContext) {
        Iterator<Parser> it = compositeParser.getAllComponentParsers().iterator();
        while (it.hasNext()) {
            Parser next = it.next();
            if (equals(next, cls)) {
                return next;
            }
            if (next instanceof ParserDecorator) {
                next = findInDecorated((ParserDecorator) next, cls);
            }
            if (equals(next, cls)) {
                return next;
            }
            if (next instanceof CompositeParser) {
                next = findInComposite((CompositeParser) next, cls, parseContext);
            }
            if (equals(next, cls)) {
                return next;
            }
        }
        return null;
    }

    private static Parser findInDecorated(ParserDecorator parserDecorator, Class cls) {
        Parser wrappedParser = parserDecorator.getWrappedParser();
        return (!equals(wrappedParser, cls) && (wrappedParser instanceof ParserDecorator)) ? findInDecorated((ParserDecorator) wrappedParser, cls) : wrappedParser;
    }

    public static EmbeddedDocumentExtractor getEmbeddedDocumentExtractor(ParseContext parseContext) {
        Class cls = EmbeddedDocumentExtractor.class;
        EmbeddedDocumentExtractor embeddedDocumentExtractor2 = (EmbeddedDocumentExtractor) parseContext.get(cls);
        if (embeddedDocumentExtractor2 != null) {
            return embeddedDocumentExtractor2;
        }
        Class cls2 = Parser.class;
        if (((Parser) parseContext.get(cls2)) == null) {
            TikaConfig tikaConfig2 = (TikaConfig) parseContext.get(TikaConfig.class);
            if (tikaConfig2 == null) {
                parseContext.set(cls2, new AutoDetectParser());
            } else {
                parseContext.set(cls2, new AutoDetectParser(tikaConfig2));
            }
        }
        ParsingEmbeddedDocumentExtractor parsingEmbeddedDocumentExtractor = new ParsingEmbeddedDocumentExtractor(parseContext);
        parseContext.set(cls, parsingEmbeddedDocumentExtractor);
        return parsingEmbeddedDocumentExtractor;
    }

    public static Parser getStatelessParser(ParseContext parseContext) {
        Parser parser = (Parser) parseContext.get(Parser.class);
        if (parser == null) {
            return null;
        }
        return parser instanceof StatefulParser ? ((StatefulParser) parser).getWrappedParser() : parser;
    }

    public static void recordEmbeddedStreamException(Throwable th, Metadata metadata) {
        metadata.add(TikaCoreProperties.n, ExceptionUtils.a(th));
    }

    public static void recordException(Throwable th, Metadata metadata) {
        metadata.add(TikaCoreProperties.l, ExceptionUtils.a(th));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.tika.parser.Parser tryToFindExistingLeafParser(java.lang.Class r3, org.apache.tika.parser.ParseContext r4) {
        /*
            java.lang.Class<org.apache.tika.parser.Parser> r0 = org.apache.tika.parser.Parser.class
            java.lang.Object r0 = r4.get(r0)
            org.apache.tika.parser.Parser r0 = (org.apache.tika.parser.Parser) r0
            boolean r1 = equals(r0, r3)
            if (r1 == 0) goto L_0x000f
            return r0
        L_0x000f:
            r1 = 0
            if (r0 == 0) goto L_0x002e
            boolean r2 = r0 instanceof org.apache.tika.parser.ParserDecorator
            if (r2 == 0) goto L_0x001c
            org.apache.tika.parser.ParserDecorator r0 = (org.apache.tika.parser.ParserDecorator) r0
            org.apache.tika.parser.Parser r0 = findInDecorated(r0, r3)
        L_0x001c:
            boolean r2 = equals(r0, r3)
            if (r2 == 0) goto L_0x0023
            return r0
        L_0x0023:
            boolean r2 = r0 instanceof org.apache.tika.parser.CompositeParser
            if (r2 == 0) goto L_0x002e
            org.apache.tika.parser.CompositeParser r0 = (org.apache.tika.parser.CompositeParser) r0
            org.apache.tika.parser.Parser r4 = findInComposite(r0, r3, r4)
            goto L_0x002f
        L_0x002e:
            r4 = r1
        L_0x002f:
            if (r4 == 0) goto L_0x0038
            boolean r3 = equals(r4, r3)
            if (r3 == 0) goto L_0x0038
            return r4
        L_0x0038:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.extractor.EmbeddedDocumentUtil.tryToFindExistingLeafParser(java.lang.Class, org.apache.tika.parser.ParseContext):org.apache.tika.parser.Parser");
    }

    @Deprecated
    public TikaConfig getConfig() {
        TikaConfig tikaConfig2 = (TikaConfig) this.context.get(TikaConfig.class);
        return tikaConfig2 == null ? TikaConfig.m() : tikaConfig2;
    }

    public Detector getDetector() {
        Detector detector2 = (Detector) this.context.get(Detector.class);
        if (detector2 != null) {
            return detector2;
        }
        Detector detector3 = this.detector;
        if (detector3 != null) {
            return detector3;
        }
        Detector u = getTikaConfig().u();
        this.detector = u;
        return u;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015 A[SYNTHETIC, Splitter:B:8:0x0015] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getExtension(org.apache.tika.io.TikaInputStream r5, org.apache.tika.metadata.Metadata r6) {
        /*
            r4 = this;
            java.lang.String r0 = "Content-Type"
            java.lang.String r1 = r6.get((java.lang.String) r0)
            org.apache.tika.mime.MimeTypes r2 = r4.getMimeTypes()
            if (r1 == 0) goto L_0x0011
            org.apache.tika.mime.MimeType r1 = r2.forName(r1)     // Catch:{ MimeTypeException -> 0x0011 }
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            r3 = 0
            if (r1 != 0) goto L_0x0029
            org.apache.tika.detect.Detector r4 = r4.getDetector()     // Catch:{ IOException | MimeTypeException -> 0x0029 }
            org.apache.tika.mime.MediaType r4 = r4.detect(r5, r6)     // Catch:{ IOException | MimeTypeException -> 0x0029 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException | MimeTypeException -> 0x0029 }
            org.apache.tika.mime.MimeType r1 = r2.forName(r4)     // Catch:{ IOException | MimeTypeException -> 0x0029 }
            r3 = 1
            r5.reset()     // Catch:{ IOException | MimeTypeException -> 0x0029 }
        L_0x0029:
            if (r1 == 0) goto L_0x0039
            if (r3 == 0) goto L_0x0034
            java.lang.String r4 = r1.toString()
            r6.set((java.lang.String) r0, (java.lang.String) r4)
        L_0x0034:
            java.lang.String r4 = r1.getExtension()
            return r4
        L_0x0039:
            java.lang.String r4 = ".bin"
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.extractor.EmbeddedDocumentUtil.getExtension(org.apache.tika.io.TikaInputStream, org.apache.tika.metadata.Metadata):java.lang.String");
    }

    public MimeTypes getMimeTypes() {
        MimeTypes mimeTypes2 = (MimeTypes) this.context.get(MimeTypes.class);
        if (mimeTypes2 != null) {
            return mimeTypes2;
        }
        MimeTypes mimeTypes3 = this.mimeTypes;
        if (mimeTypes3 != null) {
            return mimeTypes3;
        }
        MimeTypes x = getTikaConfig().x();
        this.mimeTypes = x;
        return x;
    }

    public PasswordProvider getPasswordProvider() {
        return (PasswordProvider) this.context.get(PasswordProvider.class);
    }

    public TikaConfig getTikaConfig() {
        if (this.tikaConfig == null) {
            TikaConfig tikaConfig2 = (TikaConfig) this.context.get(TikaConfig.class);
            this.tikaConfig = tikaConfig2;
            if (tikaConfig2 == null) {
                this.tikaConfig = TikaConfig.m();
            }
        }
        return this.tikaConfig;
    }

    public void parseEmbedded(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, boolean z) throws IOException, SAXException {
        this.embeddedDocumentExtractor.a(inputStream, contentHandler, metadata, z);
    }

    public boolean shouldParseEmbedded(Metadata metadata) {
        return getEmbeddedDocumentExtractor().b(metadata);
    }

    private EmbeddedDocumentExtractor getEmbeddedDocumentExtractor() {
        return this.embeddedDocumentExtractor;
    }
}
