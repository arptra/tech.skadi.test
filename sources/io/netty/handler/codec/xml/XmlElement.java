package io.netty.handler.codec.xml;

import java.util.LinkedList;
import java.util.List;

public abstract class XmlElement {
    private final String name;
    private final String namespace;
    private final List<XmlNamespace> namespaces = new LinkedList();
    private final String prefix;

    public XmlElement(String str, String str2, String str3) {
        this.name = str;
        this.namespace = str2;
        this.prefix = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        XmlElement xmlElement = (XmlElement) obj;
        if (!this.name.equals(xmlElement.name)) {
            return false;
        }
        String str = this.namespace;
        if (str == null ? xmlElement.namespace != null : !str.equals(xmlElement.namespace)) {
            return false;
        }
        if (!this.namespaces.equals(xmlElement.namespaces)) {
            return false;
        }
        String str2 = this.prefix;
        return str2 == null ? xmlElement.prefix == null : str2.equals(xmlElement.prefix);
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.namespace;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.prefix;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode2 + i) * 31) + this.namespaces.hashCode();
    }

    public String name() {
        return this.name;
    }

    public String namespace() {
        return this.namespace;
    }

    public List<XmlNamespace> namespaces() {
        return this.namespaces;
    }

    public String prefix() {
        return this.prefix;
    }

    public String toString() {
        return ", name='" + this.name + '\'' + ", namespace='" + this.namespace + '\'' + ", prefix='" + this.prefix + '\'' + ", namespaces=" + this.namespaces;
    }
}
