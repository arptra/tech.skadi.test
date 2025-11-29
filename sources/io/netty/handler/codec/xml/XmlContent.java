package io.netty.handler.codec.xml;

public abstract class XmlContent {
    private final String data;

    public XmlContent(String str) {
        this.data = str;
    }

    public String data() {
        return this.data;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        XmlContent xmlContent = (XmlContent) obj;
        String str = this.data;
        return str == null ? xmlContent.data == null : str.equals(xmlContent.data);
    }

    public int hashCode() {
        String str = this.data;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "XmlContent{data='" + this.data + '\'' + '}';
    }
}
