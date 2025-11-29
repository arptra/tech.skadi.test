package org.apache.tika.extractor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.StatefulParser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserContainerExtractor implements ContainerExtractor {
    private static final long serialVersionUID = 2261131045580861514L;
    /* access modifiers changed from: private */
    public final Detector detector;
    /* access modifiers changed from: private */
    public final Parser parser;

    public class RecursiveParser extends StatefulParser {
        private final ContainerExtractor extractor;
        private final EmbeddedResourceHandler handler;

        public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
            return ParserContainerExtractor.this.parser.getSupportedTypes(parseContext);
        }

        public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
            TikaInputStream b;
            TemporaryResources temporaryResources = new TemporaryResources();
            try {
                TikaInputStream g = TikaInputStream.g(inputStream, temporaryResources, metadata);
                String str = metadata.get("resourceName");
                MediaType detect = ParserContainerExtractor.this.detector.detect(g, metadata);
                if (this.extractor == null) {
                    this.handler.a(str, detect, g);
                } else {
                    b = TikaInputStream.b(g.u());
                    this.handler.a(str, detect, b);
                    if (b != null) {
                        b.close();
                    }
                    ContainerExtractor containerExtractor = this.extractor;
                    containerExtractor.extract(g, containerExtractor, this.handler);
                }
                temporaryResources.dispose();
                return;
            } catch (Throwable th) {
                temporaryResources.dispose();
                throw th;
            }
            throw th;
        }

        private RecursiveParser(Parser parser, ContainerExtractor containerExtractor, EmbeddedResourceHandler embeddedResourceHandler) {
            super(parser);
            this.extractor = containerExtractor;
            this.handler = embeddedResourceHandler;
        }
    }

    public ParserContainerExtractor() {
        this(TikaConfig.m());
    }

    public void extract(TikaInputStream tikaInputStream, ContainerExtractor containerExtractor, EmbeddedResourceHandler embeddedResourceHandler) throws IOException, TikaException {
        ParseContext parseContext = new ParseContext();
        Class<Parser> cls = Parser.class;
        parseContext.set(cls, new RecursiveParser(this.parser, containerExtractor, embeddedResourceHandler));
        try {
            this.parser.parse(tikaInputStream, new DefaultHandler(), new Metadata(), parseContext);
        } catch (SAXException e) {
            throw new TikaException("Unexpected SAX exception", e);
        }
    }

    public boolean isSupported(TikaInputStream tikaInputStream) throws IOException {
        return this.parser.getSupportedTypes(new ParseContext()).contains(this.detector.detect(tikaInputStream, new Metadata()));
    }

    public ParserContainerExtractor(TikaConfig tikaConfig) {
        this(new AutoDetectParser(tikaConfig), new DefaultDetector(tikaConfig.x()));
    }

    public ParserContainerExtractor(Parser parser2, Detector detector2) {
        this.parser = parser2;
        this.detector = detector2;
    }
}
