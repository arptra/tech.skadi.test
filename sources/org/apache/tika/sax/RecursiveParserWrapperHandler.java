package org.apache.tika.sax;

import java.util.LinkedList;
import java.util.List;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.metadata.filter.MetadataFilter;
import org.apache.tika.metadata.filter.NoOpFilter;
import org.apache.tika.utils.ParserUtils;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RecursiveParserWrapperHandler extends AbstractRecursiveParserWrapperHandler {
    private final MetadataFilter metadataFilter;
    protected final List<Metadata> metadataList;

    public RecursiveParserWrapperHandler(ContentHandlerFactory contentHandlerFactory) {
        this(contentHandlerFactory, -1, NoOpFilter.NOOP_FILTER);
    }

    public void addContent(ContentHandler contentHandler, Metadata metadata) {
        String obj;
        if (!contentHandler.getClass().equals(DefaultHandler.class) && (obj = contentHandler.toString()) != null && obj.trim().length() > 0) {
            metadata.add(TikaCoreProperties.g, obj);
            metadata.add(TikaCoreProperties.f, contentHandler.getClass().getSimpleName());
        }
    }

    public void endDocument(ContentHandler contentHandler, Metadata metadata) throws SAXException {
        super.endDocument(contentHandler, metadata);
        addContent(contentHandler, metadata);
        try {
            this.metadataFilter.filter(metadata);
            if (metadata.size() > 0) {
                this.metadataList.add(0, ParserUtils.a(metadata));
            }
        } catch (TikaException e) {
            throw new SAXException(e);
        }
    }

    public void endEmbeddedDocument(ContentHandler contentHandler, Metadata metadata) throws SAXException {
        super.endEmbeddedDocument(contentHandler, metadata);
        addContent(contentHandler, metadata);
        try {
            this.metadataFilter.filter(metadata);
            if (metadata.size() > 0) {
                this.metadataList.add(ParserUtils.a(metadata));
            }
        } catch (TikaException e) {
            throw new SAXException(e);
        }
    }

    public List<Metadata> getMetadataList() {
        return this.metadataList;
    }

    public void startEmbeddedDocument(ContentHandler contentHandler, Metadata metadata) throws SAXException {
        super.startEmbeddedDocument(contentHandler, metadata);
    }

    public RecursiveParserWrapperHandler(ContentHandlerFactory contentHandlerFactory, int i) {
        this(contentHandlerFactory, i, NoOpFilter.NOOP_FILTER);
    }

    public RecursiveParserWrapperHandler(ContentHandlerFactory contentHandlerFactory, int i, MetadataFilter metadataFilter2) {
        super(contentHandlerFactory, i);
        this.metadataList = new LinkedList();
        this.metadataFilter = metadataFilter2;
    }
}
