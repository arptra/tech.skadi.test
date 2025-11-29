package io.netty.handler.codec.xml;

public class XmlNamespace {
    private final String prefix;
    private final String uri;

    public XmlNamespace(String str, String str2) {
        this.prefix = str;
        this.uri = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        XmlNamespace xmlNamespace = (XmlNamespace) obj;
        String str = this.prefix;
        if (str == null ? xmlNamespace.prefix != null : !str.equals(xmlNamespace.prefix)) {
            return false;
        }
        String str2 = this.uri;
        return str2 == null ? xmlNamespace.uri == null : str2.equals(xmlNamespace.uri);
    }

    public int hashCode() {
        String str = this.prefix;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.uri;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String prefix() {
        return this.prefix;
    }

    public String toString() {
        return "XmlNamespace{prefix='" + this.prefix + '\'' + ", uri='" + this.uri + '\'' + '}';
    }

    public String uri() {
        return this.uri;
    }
}
