package org.apache.tika.sax;

import com.meizu.common.widget.MzContactsContract;
import io.netty.handler.ssl.ApplicationProtocolNames;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.AttributesImpl;

public class XHTMLContentHandler extends SafeContentHandler {
    public static final Set j = t("p", "h1", ApplicationProtocolNames.HTTP_2, "h3", "h4", "h5", "h6", "div", "ul", "ol", "dl", "pre", "hr", "blockquote", MzContactsContract.MzContactColumns.ADDRESS, "fieldset", "table", "form", "noscript", "li", "dt", "dd", "noframes", "br", "tr", "select", "option", "link", "script");
    public static final char[] k = {10};
    public static final char[] l = {9};
    public static final Set m = t("title", "link", "base", "meta", "script");
    public static final Set n = t("head", "frameset");
    public static final Set o = t("li", "dd", "dt", "td", "th", "frame");
    public static final Attributes p = new AttributesImpl();
    public final Metadata e;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;

    public XHTMLContentHandler(ContentHandler contentHandler, Metadata metadata) {
        super(contentHandler);
        this.e = metadata;
    }

    public static Set t(String... strArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(strArr)));
    }

    public void characters(char[] cArr, int i2, int i3) {
        o(this.i);
        super.characters(cArr, i2, i3);
    }

    public void endDocument() {
        o(this.i);
        if (this.i) {
            super.endElement("http://www.w3.org/1999/xhtml", "frameset", "frameset");
        } else {
            super.endElement("http://www.w3.org/1999/xhtml", "body", "body");
        }
        super.endElement("http://www.w3.org/1999/xhtml", "html", "html");
        endPrefixMapping("");
        super.endDocument();
    }

    public void endElement(String str, String str2, String str3) {
        if (!n.contains(str3)) {
            super.endElement(str, str2, str3);
            if ("http://www.w3.org/1999/xhtml".equals(str) && j.contains(str3)) {
                q();
            }
        }
    }

    public boolean h(int i2) {
        if (super.h(i2)) {
            return true;
        }
        return 127 <= i2 && i2 <= 159;
    }

    public void m(String str) {
        if (str != null && str.length() > 0) {
            characters(str.toCharArray(), 0, str.length());
        }
    }

    public void n(String str) {
        endElement("http://www.w3.org/1999/xhtml", str, str);
    }

    public final void o(boolean z) {
        p();
        if (!this.h) {
            this.h = true;
            this.i = z;
            for (String str : this.e.names()) {
                if (!str.equals("title")) {
                    for (String str2 : this.e.getValues(str)) {
                        if (str2 != null) {
                            AttributesImpl attributesImpl = new AttributesImpl();
                            AttributesImpl attributesImpl2 = attributesImpl;
                            attributesImpl.addAttribute("", "name", "name", "CDATA", str);
                            attributesImpl2.addAttribute("", "content", "content", "CDATA", str2);
                            super.startElement("http://www.w3.org/1999/xhtml", "meta", "meta", attributesImpl2);
                            super.endElement("http://www.w3.org/1999/xhtml", "meta", "meta");
                            q();
                        }
                    }
                }
            }
            Attributes attributes = p;
            super.startElement("http://www.w3.org/1999/xhtml", "title", "title", attributes);
            String str3 = this.e.get(TikaCoreProperties.L);
            if (str3 == null || str3.length() <= 0) {
                super.characters(new char[0], 0, 0);
            } else {
                char[] charArray = str3.toCharArray();
                super.characters(charArray, 0, charArray.length);
            }
            super.endElement("http://www.w3.org/1999/xhtml", "title", "title");
            q();
            super.endElement("http://www.w3.org/1999/xhtml", "head", "head");
            q();
            if (this.i) {
                super.startElement("http://www.w3.org/1999/xhtml", "frameset", "frameset", attributes);
            } else {
                super.startElement("http://www.w3.org/1999/xhtml", "body", "body", attributes);
            }
        }
    }

    public final void p() {
        if (!this.g) {
            this.g = true;
            AttributesImpl attributesImpl = new AttributesImpl();
            String str = this.e.get("Content-Language");
            if (str != null) {
                attributesImpl.addAttribute("", "lang", "lang", "CDATA", str);
            }
            super.startElement("http://www.w3.org/1999/xhtml", "html", "html", attributesImpl);
            q();
            super.startElement("http://www.w3.org/1999/xhtml", "head", "head", p);
            q();
        }
    }

    public void q() {
        char[] cArr = k;
        ignorableWhitespace(cArr, 0, cArr.length);
    }

    public void r(String str) {
        startElement("http://www.w3.org/1999/xhtml", str, str, p);
    }

    public void s(String str, String str2, String str3) {
        AttributesImpl attributesImpl = new AttributesImpl();
        attributesImpl.addAttribute("", str2, str2, "CDATA", str3);
        startElement("http://www.w3.org/1999/xhtml", str, str, attributesImpl);
    }

    public void startDocument() {
        if (!this.f) {
            this.f = true;
            super.startDocument();
            startPrefixMapping("", "http://www.w3.org/1999/xhtml");
        }
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (str3.equals("frameset")) {
            o(true);
        } else if (!n.contains(str3)) {
            if (m.contains(str3)) {
                p();
            } else {
                o(false);
            }
            if ("http://www.w3.org/1999/xhtml".equals(str) && o.contains(str3)) {
                char[] cArr = l;
                ignorableWhitespace(cArr, 0, cArr.length);
            }
            super.startElement(str, str2, str3, attributes);
        }
    }
}
