package org.apache.tika.sax;

import org.extra.tools.a;
import org.xml.sax.Attributes;

public class RichTextContentHandler extends WriteOutContentHandler {
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        super.startElement(str, str2, str3, attributes);
        if ("img".equals(str2) && attributes.getValue("alt") != null) {
            String str4 = "[image: " + attributes.getValue("alt") + ']';
            characters(str4.toCharArray(), 0, str4.length());
        }
        if (a.f3359a.equals(str2) && attributes.getValue("name") != null) {
            String str5 = "[bookmark: " + attributes.getValue("name") + ']';
            characters(str5.toCharArray(), 0, str5.length());
        }
    }
}
