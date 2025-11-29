package org.apache.tika.sax;

import com.honey.account.constant.AccountConstantKt;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class ToXMLContentHandler extends ToTextContentHandler {
    public final Map d;
    public final String e;
    public boolean f;
    public ElementInfo g;

    public static class ElementInfo {

        /* renamed from: a  reason: collision with root package name */
        public final ElementInfo f3333a;
        public final Map b;

        public ElementInfo(ElementInfo elementInfo, Map map) {
            this.f3333a = elementInfo;
            if (map.isEmpty()) {
                this.b = Collections.emptyMap();
            } else {
                this.b = new HashMap(map);
            }
        }

        public String b(String str) {
            String str2 = (String) this.b.get(str);
            if (str2 != null) {
                return str2;
            }
            ElementInfo elementInfo = this.f3333a;
            if (elementInfo != null) {
                return elementInfo.b(str);
            }
            if (str == null || str.length() == 0) {
                return "";
            }
            throw new SAXException("Namespace " + str + " not declared");
        }

        public String c(String str, String str2) {
            String b2 = b(str);
            if (b2.length() <= 0) {
                return str2;
            }
            return b2 + AccountConstantKt.CODE_SEPARTOR + str2;
        }
    }

    public ToXMLContentHandler(OutputStream outputStream, String str) {
        super(outputStream, str);
        this.d = new HashMap();
        this.f = false;
        this.e = str;
    }

    public final void a() {
        if (this.f) {
            b(Typography.greater);
            this.f = false;
        }
    }

    public void b(char c) {
        super.characters(new char[]{c}, 0, 1);
    }

    public void c(String str) {
        super.characters(str.toCharArray(), 0, str.length());
    }

    public void characters(char[] cArr, int i, int i2) {
        a();
        e(cArr, i, i2 + i, false);
    }

    public final int d(char[] cArr, int i, int i2, String str) {
        super.characters(cArr, i, i2 - i);
        b(Typography.amp);
        c(str);
        b(';');
        return i2 + 1;
    }

    public final void e(char[] cArr, int i, int i2, boolean z) {
        int i3 = i;
        while (i < i2) {
            char c = cArr[i];
            if (c == '<') {
                i3 = d(cArr, i3, i, "lt");
            } else if (c == '>') {
                i3 = d(cArr, i3, i, "gt");
            } else if (c == '&') {
                i3 = d(cArr, i3, i, "amp");
            } else if (!z || c != '\"') {
                i++;
            } else {
                i3 = d(cArr, i3, i, "quot");
            }
            i = i3;
        }
        super.characters(cArr, i3, i2 - i3);
    }

    public void endElement(String str, String str2, String str3) {
        if (this.f) {
            c(" />");
            this.f = false;
        } else {
            c("</");
            c(str3);
            b(Typography.greater);
        }
        this.d.clear();
        this.g = this.g.f3333a;
    }

    public void startDocument() {
        if (this.e != null) {
            c("<?xml version=\"1.0\" encoding=\"");
            c(this.e);
            c("\"?>\n");
        }
        this.g = null;
        this.d.clear();
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        a();
        this.g = new ElementInfo(this.g, this.d);
        b(Typography.less);
        c(this.g.c(str, str2));
        for (int i = 0; i < attributes.getLength(); i++) {
            b(' ');
            c(this.g.c(attributes.getURI(i), attributes.getLocalName(i)));
            b('=');
            b('\"');
            char[] charArray = attributes.getValue(i).toCharArray();
            e(charArray, 0, charArray.length, true);
            b('\"');
        }
        for (Map.Entry entry : this.d.entrySet()) {
            b(' ');
            c("xmlns");
            String str4 = (String) entry.getValue();
            if (str4.length() > 0) {
                b(':');
                c(str4);
            }
            b('=');
            b('\"');
            char[] charArray2 = ((String) entry.getKey()).toCharArray();
            e(charArray2, 0, charArray2.length, true);
            b('\"');
        }
        this.d.clear();
        this.f = true;
    }

    public void startPrefixMapping(String str, String str2) {
        try {
            ElementInfo elementInfo = this.g;
            if (elementInfo != null && str.equals(elementInfo.b(str2))) {
                return;
            }
        } catch (SAXException unused) {
        }
        this.d.put(str2, str);
    }

    public ToXMLContentHandler() {
        this.d = new HashMap();
        this.f = false;
        this.e = null;
    }
}
