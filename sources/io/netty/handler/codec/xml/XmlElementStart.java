package io.netty.handler.codec.xml;

import java.util.LinkedList;
import java.util.List;

public class XmlElementStart extends XmlElement {
    private final List<XmlAttribute> attributes = new LinkedList();

    public XmlElementStart(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public List<XmlAttribute> attributes() {
        return this.attributes;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        return this.attributes.equals(((XmlElementStart) obj).attributes);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.attributes.hashCode();
    }

    public String toString() {
        return "XmlElementStart{attributes=" + this.attributes + super.toString() + "} ";
    }
}
