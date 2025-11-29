package org.apache.tika.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.tika.exception.CorruptedFileException;
import org.apache.tika.exception.EncryptedDocumentException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.exception.WriteLimitReachedException;
import org.apache.tika.exception.ZeroByteFileException;
import org.apache.tika.io.FilenameUtils;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MediaType;
import org.apache.tika.sax.AbstractRecursiveParserWrapperHandler;
import org.apache.tika.sax.SecureContentHandler;
import org.apache.tika.utils.ParserUtils;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class RecursiveParserWrapper extends ParserDecorator {
    private static final long serialVersionUID = 9086536568120690938L;
    /* access modifiers changed from: private */
    public final boolean catchEmbeddedExceptions;

    public class EmbeddedParserDecorator extends StatefulParser {
        private static final long serialVersionUID = 207648200464263337L;
        private String embeddedIdPath;
        private String location;
        private final ParserState parserState;

        public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
            String str;
            if (!this.parserState.f3251a.hasHitMaximumEmbeddedResources()) {
                String str2 = this.location + RecursiveParserWrapper.this.getResourceName(metadata, this.parserState);
                metadata.add(TikaCoreProperties.b, str2);
                if (this.embeddedIdPath.equals("/")) {
                    str = this.embeddedIdPath + ParserState.d(this.parserState);
                } else {
                    str = this.embeddedIdPath + "/" + ParserState.d(this.parserState);
                }
                String str3 = str;
                metadata.add(TikaCoreProperties.c, str3);
                metadata.set(TikaCoreProperties.d, this.parserState.c);
                ContentHandler newContentHandler = this.parserState.f3251a.getNewContentHandler();
                this.parserState.f3251a.startEmbeddedDocument(newContentHandler, metadata);
                Class cls = Parser.class;
                Parser parser = (Parser) parseContext.get(cls);
                parseContext.set(cls, new EmbeddedParserDecorator(getWrappedParser(), str2, str3, this.parserState));
                long currentTimeMillis = System.currentTimeMillis();
                RecursivelySecureContentHandler recursivelySecureContentHandler = (RecursivelySecureContentHandler) parseContext.get(RecursivelySecureContentHandler.class);
                ContentHandler j = recursivelySecureContentHandler.j;
                recursivelySecureContentHandler.l(newContentHandler);
                try {
                    super.parse(inputStream, recursivelySecureContentHandler, metadata, parseContext);
                } catch (SAXException e) {
                    if (WriteLimitReachedException.isWriteLimitReached(e)) {
                        metadata.add(TikaCoreProperties.k, BooleanUtils.TRUE);
                        throw e;
                    } else if (RecursiveParserWrapper.this.catchEmbeddedExceptions) {
                        ParserUtils.f(this, e, metadata);
                    } else {
                        throw e;
                    }
                } catch (CorruptedFileException e2) {
                    throw e2;
                } catch (TikaException e3) {
                    if (e3 instanceof EncryptedDocumentException) {
                        metadata.set(TikaCoreProperties.g0, true);
                    }
                    if (parseContext.get(ZeroByteFileException.IgnoreZeroByteFileException.class) == null || !(e3 instanceof ZeroByteFileException)) {
                        if (RecursiveParserWrapper.this.catchEmbeddedExceptions) {
                            ParserUtils.f(this, e3, metadata);
                        } else {
                            throw e3;
                        }
                    }
                } catch (Throwable th) {
                    parseContext.set(cls, parser);
                    recursivelySecureContentHandler.l(j);
                    metadata.set(TikaCoreProperties.e, Long.toString(System.currentTimeMillis() - currentTimeMillis));
                    this.parserState.f3251a.endEmbeddedDocument(newContentHandler, metadata);
                    throw th;
                }
                parseContext.set(cls, parser);
                recursivelySecureContentHandler.l(j);
                metadata.set(TikaCoreProperties.e, Long.toString(System.currentTimeMillis() - currentTimeMillis));
                this.parserState.f3251a.endEmbeddedDocument(newContentHandler, metadata);
            }
        }

        private EmbeddedParserDecorator(Parser parser, String str, String str2, ParserState parserState2) {
            super(parser);
            this.embeddedIdPath = null;
            this.location = str;
            if (!str.endsWith("/")) {
                this.location += "/";
            }
            this.embeddedIdPath = str2;
            this.parserState = parserState2;
        }
    }

    public static class ParserState {

        /* renamed from: a  reason: collision with root package name */
        public final AbstractRecursiveParserWrapperHandler f3251a;
        public int b;
        public int c;

        public static /* synthetic */ int b(ParserState parserState) {
            int i = parserState.b + 1;
            parserState.b = i;
            return i;
        }

        public static /* synthetic */ int d(ParserState parserState) {
            int i = parserState.c + 1;
            parserState.c = i;
            return i;
        }

        public ParserState(AbstractRecursiveParserWrapperHandler abstractRecursiveParserWrapperHandler) {
            this.b = 0;
            this.c = 0;
            this.f3251a = abstractRecursiveParserWrapperHandler;
        }
    }

    public static class RecursivelySecureContentHandler extends SecureContentHandler {
        public ContentHandler j;
        public final int k;
        public final boolean l;
        public final ParseContext m;
        public boolean n = false;
        public int o = 0;

        public RecursivelySecureContentHandler(ContentHandler contentHandler, TikaInputStream tikaInputStream, int i, boolean z, ParseContext parseContext) {
            super(contentHandler, tikaInputStream);
            this.j = contentHandler;
            this.k = i;
            this.l = z;
            this.m = parseContext;
        }

        public void characters(char[] cArr, int i, int i2) {
            if (!this.n) {
                int i3 = this.k;
                if (i3 < 0) {
                    super.characters(cArr, i, i2);
                    return;
                }
                int min = Math.min(i3 - this.o, i2);
                super.characters(cArr, i, min);
                if (min < i2) {
                    k();
                }
            }
        }

        public void endElement(String str, String str2, String str3) {
            this.j.endElement(str, str2, str3);
        }

        public void ignorableWhitespace(char[] cArr, int i, int i2) {
            if (!this.n) {
                int i3 = this.k;
                if (i3 < 0) {
                    super.ignorableWhitespace(cArr, i, i2);
                    return;
                }
                int min = Math.min(i3 - this.o, i2);
                super.ignorableWhitespace(cArr, i, min);
                if (min < i2) {
                    k();
                }
            }
        }

        public final void k() {
            this.n = true;
            if (!this.l) {
                ParseRecord parseRecord = (ParseRecord) this.m.get(ParseRecord.class);
                if (parseRecord != null) {
                    parseRecord.k(true);
                    return;
                }
                return;
            }
            throw new WriteLimitReachedException(this.k);
        }

        public void l(ContentHandler contentHandler) {
            b(contentHandler);
            this.j = contentHandler;
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            this.j.startElement(str, str2, str3, attributes);
        }
    }

    public RecursiveParserWrapper(Parser parser) {
        this(parser, true);
    }

    /* access modifiers changed from: private */
    public String getResourceName(Metadata metadata, ParserState parserState) {
        String str;
        if (metadata.get("resourceName") != null) {
            str = metadata.get("resourceName");
        } else if (metadata.get("embeddedRelationshipId") != null) {
            str = metadata.get("embeddedRelationshipId");
        } else {
            Property property = TikaCoreProperties.i0;
            if (metadata.get(property) != null) {
                str = "version-number-" + metadata.get(property);
            } else {
                str = "embedded-" + ParserState.b(parserState);
            }
        }
        return FilenameUtils.a(str);
    }

    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return getWrappedParser().getSupportedTypes(parseContext);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a7 A[SYNTHETIC, Splitter:B:22:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b5 A[Catch:{ all -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bc A[Catch:{ all -> 0x00ad }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.io.InputStream r17, org.xml.sax.ContentHandler r18, org.apache.tika.metadata.Metadata r19, org.apache.tika.parser.ParseContext r20) throws java.io.IOException, org.xml.sax.SAXException, org.apache.tika.exception.TikaException {
        /*
            r16 = this;
            r0 = r18
            r1 = r19
            r8 = r20
            boolean r2 = r0 instanceof org.apache.tika.sax.AbstractRecursiveParserWrapperHandler
            if (r2 == 0) goto L_0x00e6
            org.apache.tika.parser.RecursiveParserWrapper$ParserState r7 = new org.apache.tika.parser.RecursiveParserWrapper$ParserState
            r2 = r0
            org.apache.tika.sax.AbstractRecursiveParserWrapperHandler r2 = (org.apache.tika.sax.AbstractRecursiveParserWrapperHandler) r2
            r3 = 0
            r7.<init>(r2)
            org.apache.tika.parser.RecursiveParserWrapper$EmbeddedParserDecorator r3 = new org.apache.tika.parser.RecursiveParserWrapper$EmbeddedParserDecorator
            org.apache.tika.parser.Parser r11 = r16.getWrappedParser()
            java.lang.String r13 = "/"
            r15 = 0
            java.lang.String r12 = "/"
            r9 = r3
            r10 = r16
            r14 = r7
            r9.<init>(r11, r12, r13, r14)
            java.lang.Class<org.apache.tika.parser.Parser> r4 = org.apache.tika.parser.Parser.class
            r8.set(r4, r3)
            org.apache.tika.sax.AbstractRecursiveParserWrapperHandler r3 = r7.f3251a
            org.xml.sax.ContentHandler r9 = r3.getNewContentHandler()
            long r10 = java.lang.System.currentTimeMillis()
            org.apache.tika.sax.AbstractRecursiveParserWrapperHandler r3 = r7.f3251a
            r3.startDocument()
            org.apache.tika.io.TemporaryResources r12 = new org.apache.tika.io.TemporaryResources
            r12.<init>()
            boolean r0 = r0 instanceof org.apache.tika.sax.AbstractRecursiveParserWrapperHandler
            if (r0 == 0) goto L_0x005d
            org.apache.tika.sax.ContentHandlerFactory r0 = r2.getContentHandlerFactory()
            boolean r2 = r0 instanceof org.apache.tika.sax.WriteLimiter
            if (r2 == 0) goto L_0x005d
            org.apache.tika.sax.WriteLimiter r0 = (org.apache.tika.sax.WriteLimiter) r0
            int r2 = r0.getWriteLimit()
            boolean r0 = r0.isThrowOnWriteLimitReached()
            r6 = r0
            r5 = r2
        L_0x005a:
            r0 = r17
            goto L_0x0062
        L_0x005d:
            r0 = -1
            r2 = 1
            r5 = r0
            r6 = r2
            goto L_0x005a
        L_0x0062:
            org.apache.tika.io.TikaInputStream r0 = org.apache.tika.io.TikaInputStream.g(r0, r12, r1)     // Catch:{ all -> 0x009f }
            org.apache.tika.parser.RecursiveParserWrapper$RecursivelySecureContentHandler r13 = new org.apache.tika.parser.RecursiveParserWrapper$RecursivelySecureContentHandler     // Catch:{ all -> 0x009f }
            r2 = r13
            r3 = r9
            r4 = r0
            r14 = r7
            r7 = r20
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x009d }
            java.lang.Class<org.apache.tika.parser.RecursiveParserWrapper$RecursivelySecureContentHandler> r2 = org.apache.tika.parser.RecursiveParserWrapper.RecursivelySecureContentHandler.class
            r8.set(r2, r13)     // Catch:{ all -> 0x009d }
            org.apache.tika.parser.Parser r2 = r16.getWrappedParser()     // Catch:{ all -> 0x009d }
            r2.parse(r0, r13, r1, r8)     // Catch:{ all -> 0x009d }
        L_0x007d:
            r12.dispose()
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r10
            org.apache.tika.metadata.Property r0 = org.apache.tika.metadata.TikaCoreProperties.e
            java.lang.String r2 = java.lang.Long.toString(r2)
            r1.set((org.apache.tika.metadata.Property) r0, (java.lang.String) r2)
            org.apache.tika.sax.AbstractRecursiveParserWrapperHandler r0 = r14.f3251a
            r0.endDocument(r9, r1)
            org.apache.tika.sax.AbstractRecursiveParserWrapperHandler r0 = r14.f3251a
            r0.endDocument()
            goto L_0x00bb
        L_0x009d:
            r0 = move-exception
            goto L_0x00a1
        L_0x009f:
            r0 = move-exception
            r14 = r7
        L_0x00a1:
            boolean r2 = r0 instanceof org.apache.tika.exception.EncryptedDocumentException     // Catch:{ all -> 0x00ad }
            java.lang.String r3 = "true"
            if (r2 == 0) goto L_0x00af
            org.apache.tika.metadata.Property r2 = org.apache.tika.metadata.TikaCoreProperties.g0     // Catch:{ all -> 0x00ad }
            r1.set((org.apache.tika.metadata.Property) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00ad }
            goto L_0x00af
        L_0x00ad:
            r0 = move-exception
            goto L_0x00c6
        L_0x00af:
            boolean r2 = org.apache.tika.exception.WriteLimitReachedException.isWriteLimitReached(r0)     // Catch:{ all -> 0x00ad }
            if (r2 == 0) goto L_0x00bc
            org.apache.tika.metadata.Property r0 = org.apache.tika.metadata.TikaCoreProperties.k     // Catch:{ all -> 0x00ad }
            r1.set((org.apache.tika.metadata.Property) r0, (java.lang.String) r3)     // Catch:{ all -> 0x00ad }
            goto L_0x007d
        L_0x00bb:
            return
        L_0x00bc:
            java.lang.String r2 = org.apache.tika.utils.ExceptionUtils.a(r0)     // Catch:{ all -> 0x00ad }
            org.apache.tika.metadata.Property r3 = org.apache.tika.metadata.TikaCoreProperties.h     // Catch:{ all -> 0x00ad }
            r1.add((org.apache.tika.metadata.Property) r3, (java.lang.String) r2)     // Catch:{ all -> 0x00ad }
            throw r0     // Catch:{ all -> 0x00ad }
        L_0x00c6:
            r12.dispose()
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r10
            org.apache.tika.metadata.Property r4 = org.apache.tika.metadata.TikaCoreProperties.e
            java.lang.String r2 = java.lang.Long.toString(r2)
            r1.set((org.apache.tika.metadata.Property) r4, (java.lang.String) r2)
            org.apache.tika.sax.AbstractRecursiveParserWrapperHandler r2 = r14.f3251a
            r2.endDocument(r9, r1)
            org.apache.tika.sax.AbstractRecursiveParserWrapperHandler r1 = r14.f3251a
            r1.endDocument()
            throw r0
        L_0x00e6:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "ContentHandler must implement RecursiveParserWrapperHandler"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.parser.RecursiveParserWrapper.parse(java.io.InputStream, org.xml.sax.ContentHandler, org.apache.tika.metadata.Metadata, org.apache.tika.parser.ParseContext):void");
    }

    public RecursiveParserWrapper(Parser parser, boolean z) {
        super(parser);
        this.catchEmbeddedExceptions = z;
    }
}
