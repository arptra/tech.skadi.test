package org.apache.tika.sax;

import java.util.Arrays;
import org.apache.tika.metadata.Metadata;
import org.xml.sax.SAXException;

public class StandardsExtractingContentHandler extends ContentHandlerDecorator {
    public final Metadata b;
    public final StringBuilder c;
    public int d;
    public double e;

    public void characters(char[] cArr, int i, int i2) {
        try {
            int i3 = this.d;
            if (i3 > -1) {
                int length = i3 - this.c.length();
                if (length <= i2) {
                    i2 = length;
                }
            }
            this.c.append(new String(Arrays.copyOfRange(cArr, i, i + i2)));
            super.characters(cArr, i, i2);
        } catch (SAXException e2) {
            a(e2);
        }
    }

    public void endDocument() {
        super.endDocument();
        for (StandardReference standardReference : StandardsText.a(this.c.toString(), this.e)) {
            this.b.add("standard_references", standardReference.toString());
        }
    }
}
