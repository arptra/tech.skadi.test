package org.apache.tika.sax;

import com.honey.account.nc.a;
import com.honey.account.nc.b;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.AttributesImpl;

public class SafeContentHandler extends ContentHandlerDecorator {
    public static final char[] d = {65533};
    public final Output b = new a(this);
    public final Output c = new b(this);

    public interface Output {
        void a(char[] cArr, int i, int i2);
    }

    public static class StringOutput implements Output {

        /* renamed from: a  reason: collision with root package name */
        public final StringBuilder f3325a;

        public StringOutput() {
            this.f3325a = new StringBuilder();
        }

        public void a(char[] cArr, int i, int i2) {
            this.f3325a.append(cArr, i, i2);
        }

        public String toString() {
            return this.f3325a.toString();
        }
    }

    public SafeContentHandler(ContentHandler contentHandler) {
        super(contentHandler);
    }

    public void characters(char[] cArr, int i, int i2) {
        g(cArr, i, i2, this.b);
    }

    public void endDocument() {
        super.endDocument();
    }

    public void endElement(String str, String str2, String str3) {
        super.endElement(str, str2, str3);
    }

    public final void g(char[] cArr, int i, int i2, Output output) {
        int i3 = i2 + i;
        int i4 = i;
        while (i < i3) {
            int codePointAt = Character.codePointAt(cArr, i, i3);
            int charCount = Character.charCount(codePointAt) + i;
            if (h(codePointAt)) {
                if (i > i4) {
                    output.a(cArr, i4, i - i4);
                }
                l(output);
                i4 = charCount;
            }
            i = charCount;
        }
        output.a(cArr, i4, i3 - i4);
    }

    public boolean h(int i) {
        return i < 32 ? (i == 9 || i == 10 || i == 13) ? false : true : i < 57344 ? i > 55295 : i < 65536 ? i > 65533 : i > 1114111;
    }

    public final boolean i(String str) {
        char[] charArray = str.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            int codePointAt = Character.codePointAt(charArray, i);
            if (h(codePointAt)) {
                return true;
            }
            i += Character.charCount(codePointAt);
        }
        return false;
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) {
        g(cArr, i, i2, this.c);
    }

    public final /* synthetic */ void j(char[] cArr, int i, int i2) {
        super.characters(cArr, i, i2);
    }

    public final /* synthetic */ void k(char[] cArr, int i, int i2) {
        super.ignorableWhitespace(cArr, i, i2);
    }

    public void l(Output output) {
        char[] cArr = d;
        output.a(cArr, 0, cArr.length);
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        int i = 0;
        while (true) {
            if (i >= attributes.getLength()) {
                break;
            } else if (i(attributes.getValue(i))) {
                AttributesImpl attributesImpl = new AttributesImpl();
                for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                    String value = attributes.getValue(i2);
                    if (i2 >= i && i(value)) {
                        StringOutput stringOutput = new StringOutput();
                        g(value.toCharArray(), 0, value.length(), stringOutput);
                        value = stringOutput.toString();
                    }
                    attributesImpl.addAttribute(attributes.getURI(i2), attributes.getLocalName(i2), attributes.getQName(i2), attributes.getType(i2), value);
                }
                attributes = attributesImpl;
            } else {
                i++;
            }
        }
        super.startElement(str, str2, str3, attributes);
    }
}
