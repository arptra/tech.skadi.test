package org.apache.tika.sax;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import kotlin.text.Typography;

public class ToHTMLContentHandler extends ToXMLContentHandler {
    public static final Set h = new HashSet(Arrays.asList(new String[]{"area", "base", "basefont", "br", "col", "frame", "hr", "img", "input", "isindex", "link", "meta", "param"}));

    public ToHTMLContentHandler(OutputStream outputStream, String str) {
        super(outputStream, str);
    }

    public void endElement(String str, String str2, String str3) {
        if (this.f) {
            b(Typography.greater);
            this.f = false;
            if (h.contains(str2)) {
                this.d.clear();
                return;
            }
        }
        super.endElement(str, str2, str3);
    }

    public void startDocument() {
    }

    public ToHTMLContentHandler() {
    }
}
