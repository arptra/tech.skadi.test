package org.apache.tika.fork;

import org.apache.tika.metadata.Metadata;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class MetadataContentHandler extends DefaultHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Metadata f10071a;

    public MetadataContentHandler(Metadata metadata) {
        this.f10071a = metadata;
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if ("meta".equals(str2)) {
            this.f10071a.add(attributes.getValue("name"), attributes.getValue("content"));
        }
    }
}
