package org.apache.tika.sax;

import com.meizu.common.util.LunarCalendar;
import java.util.Stack;
import org.apache.tika.metadata.Metadata;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;

public class DIFContentHandler extends DefaultHandler {
    public static final char[] f = {10};
    public static final char[] g = {9};
    public static final Attributes h = new AttributesImpl();

    /* renamed from: a  reason: collision with root package name */
    public final Stack f3320a;
    public final Stack b;
    public final ContentHandler c;
    public final Metadata d;
    public boolean e;

    public void characters(char[] cArr, int i, int i2) {
        String str = new String(cArr, i, i2);
        this.b.push(str);
        if (((String) this.f3320a.peek()).equals("Entry_Title")) {
            ContentHandler contentHandler = this.c;
            char[] cArr2 = f;
            contentHandler.characters(cArr2, 0, cArr2.length);
            ContentHandler contentHandler2 = this.c;
            char[] cArr3 = g;
            contentHandler2.characters(cArr3, 0, cArr3.length);
            this.c.startElement("", "h3", "h3", h);
            String str2 = "Title: " + str;
            this.c.characters(str2.toCharArray(), 0, str2.length());
            this.c.endElement("", "h3", "h3");
        }
        if (((String) this.f3320a.peek()).equals("Southernmost_Latitude") || ((String) this.f3320a.peek()).equals("Northernmost_Latitude") || ((String) this.f3320a.peek()).equals("Westernmost_Longitude") || ((String) this.f3320a.peek()).equals("Easternmost_Longitude")) {
            ContentHandler contentHandler3 = this.c;
            char[] cArr4 = f;
            contentHandler3.characters(cArr4, 0, cArr4.length);
            ContentHandler contentHandler4 = this.c;
            char[] cArr5 = g;
            contentHandler4.characters(cArr5, 0, cArr5.length);
            this.c.characters(cArr5, 0, cArr5.length);
            ContentHandler contentHandler5 = this.c;
            Attributes attributes = h;
            contentHandler5.startElement("", "tr", "tr", attributes);
            this.c.startElement("", "td", "td", attributes);
            String str3 = ((String) this.f3320a.peek()) + " : ";
            this.c.characters(str3.toCharArray(), 0, str3.length());
            this.c.endElement("", "td", "td");
            this.c.startElement("", "td", "td", attributes);
            this.c.characters(str.toCharArray(), 0, str.length());
            this.c.endElement("", "td", "td");
            this.c.endElement("", "tr", "tr");
        }
    }

    public void endDocument() {
        this.c.endDocument();
    }

    public void endElement(String str, String str2, String str3) {
        if (str2.equals("Spatial_Coverage")) {
            ContentHandler contentHandler = this.c;
            char[] cArr = f;
            contentHandler.characters(cArr, 0, cArr.length);
            ContentHandler contentHandler2 = this.c;
            char[] cArr2 = g;
            contentHandler2.characters(cArr2, 0, cArr2.length);
            this.c.endElement("", "table", "table");
        }
        if (this.e) {
            Stack stack = (Stack) this.f3320a.clone();
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                if (sb.length() == 0) {
                    sb = new StringBuilder((String) stack.pop());
                } else {
                    sb.insert(0, ((String) stack.pop()) + LunarCalendar.DATE_SEPARATOR);
                }
            }
            this.d.add(sb.toString(), (String) this.b.peek());
            this.e = false;
        }
        this.f3320a.pop();
        this.b.pop();
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) {
        this.c.ignorableWhitespace(cArr, i, i2);
    }

    public void setDocumentLocator(Locator locator) {
        this.c.setDocumentLocator(locator);
    }

    public void startDocument() {
        this.c.startDocument();
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.e = true;
        if (str2.equals("Spatial_Coverage")) {
            ContentHandler contentHandler = this.c;
            char[] cArr = f;
            contentHandler.characters(cArr, 0, cArr.length);
            ContentHandler contentHandler2 = this.c;
            char[] cArr2 = g;
            contentHandler2.characters(cArr2, 0, cArr2.length);
            ContentHandler contentHandler3 = this.c;
            Attributes attributes2 = h;
            contentHandler3.startElement("", "h3", "h3", attributes2);
            this.c.characters("Geographic Data: ".toCharArray(), 0, 17);
            this.c.endElement("", "h3", "h3");
            this.c.characters(cArr, 0, cArr.length);
            this.c.characters(cArr2, 0, cArr2.length);
            this.c.startElement("", "table", "table", attributes2);
        }
        this.f3320a.push(str2);
    }

    public String toString() {
        return this.c.toString();
    }
}
