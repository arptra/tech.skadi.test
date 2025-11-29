package org.apache.tika.parser;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.transform.Transformer;
import org.apache.tika.exception.TikaException;
import org.apache.tika.utils.XMLReaderUtils;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

public class ParseContext implements Serializable {
    private static final long serialVersionUID = -5921436862145826534L;
    private final Map<String, Object> context = new HashMap();

    private DocumentBuilderFactory getDocumentBuilderFactory() {
        DocumentBuilderFactory documentBuilderFactory = (DocumentBuilderFactory) get(DocumentBuilderFactory.class);
        return documentBuilderFactory != null ? documentBuilderFactory : XMLReaderUtils.getDocumentBuilderFactory();
    }

    public <T> T get(Class<T> cls) {
        return this.context.get(cls.getName());
    }

    public DocumentBuilder getDocumentBuilder() throws TikaException {
        DocumentBuilder documentBuilder = (DocumentBuilder) get(DocumentBuilder.class);
        return documentBuilder != null ? documentBuilder : XMLReaderUtils.getDocumentBuilder();
    }

    public SAXParser getSAXParser() throws TikaException {
        SAXParser sAXParser = (SAXParser) get(SAXParser.class);
        return sAXParser != null ? sAXParser : XMLReaderUtils.getSAXParser();
    }

    public SAXParserFactory getSAXParserFactory() {
        SAXParserFactory sAXParserFactory = (SAXParserFactory) get(SAXParserFactory.class);
        if (sAXParserFactory == null) {
            sAXParserFactory = SAXParserFactory.newInstance();
            sAXParserFactory.setNamespaceAware(true);
            sAXParserFactory.setValidating(false);
            try {
                sAXParserFactory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
            } catch (ParserConfigurationException | SAXNotRecognizedException | SAXNotSupportedException unused) {
            }
        }
        return sAXParserFactory;
    }

    public Transformer getTransformer() throws TikaException {
        Transformer transformer = (Transformer) get(Transformer.class);
        return transformer != null ? transformer : XMLReaderUtils.getTransformer();
    }

    public XMLInputFactory getXMLInputFactory() {
        XMLInputFactory xMLInputFactory = (XMLInputFactory) get(XMLInputFactory.class);
        return xMLInputFactory != null ? xMLInputFactory : XMLReaderUtils.getXMLInputFactory();
    }

    public XMLReader getXMLReader() throws TikaException {
        XMLReader xMLReader = (XMLReader) get(XMLReader.class);
        return xMLReader != null ? xMLReader : XMLReaderUtils.getXMLReader();
    }

    public <T> void set(Class<T> cls, T t) {
        if (t != null) {
            this.context.put(cls.getName(), t);
        } else {
            this.context.remove(cls.getName());
        }
    }

    public <T> T get(Class<T> cls, T t) {
        T t2 = get(cls);
        return t2 != null ? t2 : t;
    }
}
