package org.apache.tika.extractor;

import java.io.Serializable;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;

public interface EmbeddedDocumentExtractorFactory extends Serializable {
    EmbeddedDocumentExtractor newInstance(Metadata metadata, ParseContext parseContext);
}
