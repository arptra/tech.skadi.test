package org.apache.tika.sax;

import com.honey.account.constant.AccountConstantKt;
import java.util.Map;
import javax.xml.namespace.QName;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;

public class ElementMappingContentHandler extends ContentHandlerDecorator {
    public final Map b;

    public static class TargetElement {

        /* renamed from: a  reason: collision with root package name */
        public final QName f3321a;
        public final Map b;

        public QName a() {
            return this.f3321a;
        }

        public Attributes b(Attributes attributes) {
            AttributesImpl attributesImpl = new AttributesImpl();
            for (int i = 0; i < attributes.getLength(); i++) {
                QName qName = (QName) this.b.get(new QName(attributes.getURI(i), attributes.getLocalName(i)));
                if (qName != null) {
                    attributesImpl.addAttribute(qName.getNamespaceURI(), qName.getLocalPart(), ElementMappingContentHandler.c(qName), attributes.getType(i), attributes.getValue(i));
                }
            }
            return attributesImpl;
        }
    }

    public static final String c(QName qName) {
        String prefix = qName.getPrefix();
        if (prefix.length() <= 0) {
            return qName.getLocalPart();
        }
        return prefix + AccountConstantKt.CODE_SEPARTOR + qName.getLocalPart();
    }

    public void endElement(String str, String str2, String str3) {
        TargetElement targetElement = (TargetElement) this.b.get(new QName(str, str2));
        if (targetElement != null) {
            QName a2 = targetElement.a();
            super.endElement(a2.getNamespaceURI(), a2.getLocalPart(), c(a2));
        }
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        TargetElement targetElement = (TargetElement) this.b.get(new QName(str, str2));
        if (targetElement != null) {
            QName a2 = targetElement.a();
            super.startElement(a2.getNamespaceURI(), a2.getLocalPart(), c(a2), targetElement.b(attributes));
        }
    }
}
