package org.apache.tika.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;

public class XMPContentHandler extends SafeContentHandler {
    public static final Attributes e = new AttributesImpl();

    public void endDocument() {
        endElement("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "RDF", "rdf:RDF");
        endPrefixMapping("xmp");
        endPrefixMapping("rdf");
        super.endDocument();
    }

    public void startDocument() {
        super.startDocument();
        startPrefixMapping("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        startPrefixMapping("xmp", "http://ns.adobe.com/xap/1.0/");
        startElement("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "RDF", "rdf:RDF", e);
    }
}
