package org.apache.tika.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MediaTypeRegistry;
import org.apache.tika.parser.multiple.AbstractMultipleParser;
import org.apache.tika.parser.multiple.FallbackParser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class ParserDecorator extends AbstractParser {
    private static final long serialVersionUID = -3861669115439125268L;
    private final Parser parser;

    public ParserDecorator(Parser parser2) {
        this.parser = parser2;
    }

    public static final Parser withFallbacks(Collection<? extends Parser> collection, Set<MediaType> set) {
        FallbackParser fallbackParser = new FallbackParser(MediaTypeRegistry.getDefaultRegistry(), AbstractMultipleParser.MetadataPolicy.KEEP_ALL, collection);
        return (set == null || set.isEmpty()) ? fallbackParser : withTypes(fallbackParser, set);
    }

    public static final Parser withTypes(Parser parser2, final Set<MediaType> set) {
        return new ParserDecorator(parser2) {
            private static final long serialVersionUID = -7345051519565330731L;

            public String getDecorationName() {
                return "With Types";
            }

            public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
                return set;
            }
        };
    }

    public static final Parser withoutTypes(Parser parser2, final Set<MediaType> set) {
        return new ParserDecorator(parser2) {
            private static final long serialVersionUID = 7979614774021768609L;

            public String getDecorationName() {
                return "Without Types";
            }

            public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
                HashSet hashSet = new HashSet(ParserDecorator.super.getSupportedTypes(parseContext));
                hashSet.removeAll(set);
                return hashSet;
            }
        };
    }

    public String getDecorationName() {
        return null;
    }

    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return this.parser.getSupportedTypes(parseContext);
    }

    public Parser getWrappedParser() {
        return this.parser;
    }

    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
        this.parser.parse(inputStream, contentHandler, metadata, parseContext);
    }
}
