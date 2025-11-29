package org.apache.tika.sax;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.extra.tools.a;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class LinkContentHandler extends DefaultHandler {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList f3324a;
    public final List b;
    public final boolean c;

    public void characters(char[] cArr, int i, int i2) {
        Iterator it = this.f3324a.iterator();
        while (it.hasNext()) {
            ((LinkBuilder) it.next()).a(cArr, i, i2);
        }
    }

    public void endElement(String str, String str2, String str3) {
        if (!this.f3324a.isEmpty() && "http://www.w3.org/1999/xhtml".equals(str)) {
            if ((a.f3359a.equals(str2) || "img".equals(str2) || "link".equals(str2) || "script".equals(str2) || "iframe".equals(str2)) && ((LinkBuilder) this.f3324a.getFirst()).c().equals(str2)) {
                this.b.add(((LinkBuilder) this.f3324a.removeFirst()).b(this.c));
            }
        }
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) {
        characters(cArr, i, i2);
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (!"http://www.w3.org/1999/xhtml".equals(str)) {
            return;
        }
        if (a.f3359a.equals(str2)) {
            LinkBuilder linkBuilder = new LinkBuilder(a.f3359a);
            linkBuilder.f(attributes.getValue("", "href"));
            linkBuilder.e(attributes.getValue("", "title"));
            linkBuilder.d(attributes.getValue("", "rel"));
            this.f3324a.addFirst(linkBuilder);
        } else if ("link".equals(str2)) {
            LinkBuilder linkBuilder2 = new LinkBuilder("link");
            linkBuilder2.f(attributes.getValue("", "href"));
            linkBuilder2.d(attributes.getValue("", "rel"));
            this.f3324a.addFirst(linkBuilder2);
        } else if ("script".equals(str2)) {
            if (attributes.getValue("", "src") != null) {
                LinkBuilder linkBuilder3 = new LinkBuilder("script");
                linkBuilder3.f(attributes.getValue("", "src"));
                this.f3324a.addFirst(linkBuilder3);
            }
        } else if ("iframe".equals(str2)) {
            LinkBuilder linkBuilder4 = new LinkBuilder("iframe");
            linkBuilder4.f(attributes.getValue("", "src"));
            this.f3324a.addFirst(linkBuilder4);
        } else if ("img".equals(str2)) {
            LinkBuilder linkBuilder5 = new LinkBuilder("img");
            linkBuilder5.f(attributes.getValue("", "src"));
            linkBuilder5.e(attributes.getValue("", "title"));
            linkBuilder5.d(attributes.getValue("", "rel"));
            this.f3324a.addFirst(linkBuilder5);
            String value = attributes.getValue("", "alt");
            if (value != null) {
                char[] charArray = value.toCharArray();
                characters(charArray, 0, charArray.length);
            }
        }
    }
}
