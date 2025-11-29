package org.apache.tika.sax;

import java.io.Writer;
import org.apache.tika.sax.xpath.Matcher;
import org.apache.tika.sax.xpath.MatchingContentHandler;
import org.apache.tika.sax.xpath.XPathParser;
import org.xml.sax.ContentHandler;

public class BodyContentHandler extends ContentHandlerDecorator {
    public static final XPathParser b;
    public static final Matcher c;

    static {
        XPathParser xPathParser = new XPathParser("xhtml", "http://www.w3.org/1999/xhtml");
        b = xPathParser;
        c = xPathParser.b("/xhtml:html/xhtml:body/descendant::node()");
    }

    public BodyContentHandler(ContentHandler contentHandler) {
        super(new MatchingContentHandler(contentHandler, c));
    }

    public BodyContentHandler(Writer writer) {
        this((ContentHandler) new WriteOutContentHandler(writer));
    }

    public BodyContentHandler() {
        this((ContentHandler) new WriteOutContentHandler());
    }
}
