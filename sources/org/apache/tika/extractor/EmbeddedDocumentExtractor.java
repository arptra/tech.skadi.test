package org.apache.tika.extractor;

import java.io.InputStream;
import org.apache.tika.metadata.Metadata;
import org.xml.sax.ContentHandler;

public interface EmbeddedDocumentExtractor {
    void a(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, boolean z);

    boolean b(Metadata metadata);
}
