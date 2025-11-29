package org.apache.tika.sax;

import java.util.Arrays;
import org.apache.tika.metadata.Metadata;
import org.xml.sax.SAXException;

public class PhoneExtractingContentHandler extends ContentHandlerDecorator {
    public final Metadata b;
    public final StringBuilder c;

    public void characters(char[] cArr, int i, int i2) {
        try {
            this.c.append(new String(Arrays.copyOfRange(cArr, i, i + i2)));
            super.characters(cArr, i, i2);
        } catch (SAXException e) {
            a(e);
        }
    }

    public void endDocument() {
        super.endDocument();
        for (String add : CleanPhoneText.b(this.c.toString())) {
            this.b.add("phonenumbers", add);
        }
    }
}
