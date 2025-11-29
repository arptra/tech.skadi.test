package io.netty.handler.codec.xml;

public class XmlEntityReference {
    private final String name;
    private final String text;

    public XmlEntityReference(String str, String str2) {
        this.name = str;
        this.text = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        XmlEntityReference xmlEntityReference = (XmlEntityReference) obj;
        String str = this.name;
        if (str == null ? xmlEntityReference.name != null : !str.equals(xmlEntityReference.name)) {
            return false;
        }
        String str2 = this.text;
        return str2 != null ? str2.equals(xmlEntityReference.text) : xmlEntityReference.text == null;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.text;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String name() {
        return this.name;
    }

    public String text() {
        return this.text;
    }

    public String toString() {
        return "XmlEntityReference{name='" + this.name + '\'' + ", text='" + this.text + '\'' + '}';
    }
}
