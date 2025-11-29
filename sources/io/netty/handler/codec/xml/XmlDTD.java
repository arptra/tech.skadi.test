package io.netty.handler.codec.xml;

public class XmlDTD {
    private final String text;

    public XmlDTD(String str) {
        this.text = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        XmlDTD xmlDTD = (XmlDTD) obj;
        String str = this.text;
        return str == null ? xmlDTD.text == null : str.equals(xmlDTD.text);
    }

    public int hashCode() {
        String str = this.text;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String text() {
        return this.text;
    }

    public String toString() {
        return "XmlDTD{text='" + this.text + '\'' + '}';
    }
}
