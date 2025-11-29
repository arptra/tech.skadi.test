package io.netty.handler.codec.xml;

public class XmlProcessingInstruction {
    private final String data;
    private final String target;

    public XmlProcessingInstruction(String str, String str2) {
        this.data = str;
        this.target = str2;
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
        XmlProcessingInstruction xmlProcessingInstruction = (XmlProcessingInstruction) obj;
        String str = this.data;
        if (str == null ? xmlProcessingInstruction.data != null : !str.equals(xmlProcessingInstruction.data)) {
            return false;
        }
        String str2 = this.target;
        return str2 == null ? xmlProcessingInstruction.target == null : str2.equals(xmlProcessingInstruction.target);
    }

    public int hashCode() {
        String str = this.data;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.target;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String target() {
        return this.target;
    }

    public String toString() {
        return "XmlProcessingInstruction{data='" + this.data + '\'' + ", target='" + this.target + '\'' + '}';
    }
}
