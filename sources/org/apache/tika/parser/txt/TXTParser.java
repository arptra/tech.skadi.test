package org.apache.tika.parser.txt;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.tika.detect.AutoDetectReader;
import org.apache.tika.detect.EncodingDetector;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AbstractEncodingDetectorParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.XHTMLContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class TXTParser extends AbstractEncodingDetectorParser {
    private static final Set<MediaType> SUPPORTED_TYPES = Collections.singleton(MediaType.TEXT_PLAIN);
    private static final long serialVersionUID = -6656102320836888910L;

    public TXTParser() {
    }

    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return SUPPORTED_TYPES;
    }

    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
        MediaType parse;
        AutoDetectReader autoDetectReader = new AutoDetectReader(new CloseShieldInputStream(inputStream), metadata, getEncodingDetector(parseContext));
        try {
            String str = metadata.get("Content-Type");
            MediaType mediaType = MediaType.TEXT_PLAIN;
            if (!(str == null || (parse = MediaType.parse(str)) == null)) {
                mediaType = parse;
            }
            Charset c = autoDetectReader.c();
            metadata.set("Content-Type", new MediaType(mediaType, c).toString());
            metadata.set("Content-Encoding", c.name());
            XHTMLContentHandler xHTMLContentHandler = new XHTMLContentHandler(contentHandler, metadata);
            xHTMLContentHandler.startDocument();
            xHTMLContentHandler.r("p");
            char[] cArr = new char[4096];
            for (int read = autoDetectReader.read(cArr); read != -1; read = autoDetectReader.read(cArr)) {
                xHTMLContentHandler.characters(cArr, 0, read);
            }
            xHTMLContentHandler.n("p");
            xHTMLContentHandler.endDocument();
            autoDetectReader.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public TXTParser(EncodingDetector encodingDetector) {
        super(encodingDetector);
    }
}
