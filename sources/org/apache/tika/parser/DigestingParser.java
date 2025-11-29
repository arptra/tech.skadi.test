package org.apache.tika.parser;

import java.io.IOException;
import java.io.InputStream;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class DigestingParser extends ParserDecorator {
    private final Digester digester;
    private final boolean skipContainerDocument;

    public interface Digester {
        void a(InputStream inputStream, Metadata metadata, ParseContext parseContext);
    }

    public interface DigesterFactory {
        boolean a();

        Digester build();
    }

    public interface Encoder {
        String encode(byte[] bArr);
    }

    public DigestingParser(Parser parser, Digester digester2, boolean z) {
        super(parser);
        this.digester = digester2;
        this.skipContainerDocument = z;
    }

    private boolean shouldDigest(Metadata metadata) {
        if (this.digester == null) {
            return false;
        }
        if (!this.skipContainerDocument) {
            return true;
        }
        Integer num = metadata.getInt(TikaCoreProperties.f7113a);
        return (num == null || num.intValue() == 0) ? false : true;
    }

    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
        TemporaryResources temporaryResources = new TemporaryResources();
        TikaInputStream g = TikaInputStream.g(inputStream, temporaryResources, metadata);
        try {
            if (shouldDigest(metadata)) {
                this.digester.a(g, metadata, parseContext);
            }
            super.parse(g, contentHandler, metadata, parseContext);
            temporaryResources.dispose();
        } catch (Throwable th) {
            temporaryResources.dispose();
            throw th;
        }
    }
}
