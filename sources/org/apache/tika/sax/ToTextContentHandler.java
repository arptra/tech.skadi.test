package org.apache.tika.sax;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ToTextContentHandler extends DefaultHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Writer f3332a;
    public int b;
    public int c;

    public ToTextContentHandler(Writer writer) {
        this.b = 0;
        this.c = 0;
        this.f3332a = writer;
    }

    public void characters(char[] cArr, int i, int i2) {
        if (this.b + this.c == 0) {
            try {
                this.f3332a.write(cArr, i, i2);
            } catch (IOException e) {
                throw new SAXException("Error writing: " + new String(cArr, i, i2), e);
            }
        }
    }

    public void endDocument() {
        try {
            this.f3332a.flush();
        } catch (IOException e) {
            throw new SAXException("Error flushing character output", e);
        }
    }

    public void endElement(String str, String str2, String str3) {
        String upperCase = str3 == null ? "" : str3.toUpperCase(Locale.ENGLISH);
        if (upperCase.equals("STYLE")) {
            this.b--;
        }
        if (upperCase.equals("SCRIPT")) {
            this.c--;
        }
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) {
        characters(cArr, i, i2);
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        String upperCase = str3 == null ? "" : str3.toUpperCase(Locale.ENGLISH);
        if (upperCase.equals("STYLE")) {
            this.b++;
        }
        if (upperCase.equals("SCRIPT")) {
            this.c++;
        }
    }

    public String toString() {
        return this.f3332a.toString();
    }

    public ToTextContentHandler(OutputStream outputStream, String str) {
        this(new OutputStreamWriter(outputStream, str));
    }

    public ToTextContentHandler() {
        this(new StringWriter());
    }
}
