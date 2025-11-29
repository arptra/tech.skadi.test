package org.apache.tika.sax;

import java.io.Serializable;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.xml.sax.ContentHandler;

public interface ContentHandlerDecoratorFactory extends Serializable {
    @Deprecated
    ContentHandler decorate(ContentHandler contentHandler, Metadata metadata);

    ContentHandler decorate(ContentHandler contentHandler, Metadata metadata, ParseContext parseContext);
}
