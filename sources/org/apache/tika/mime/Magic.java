package org.apache.tika.mime;

class Magic implements Clause, Comparable<Magic> {
    private final Clause clause;
    private final int priority;
    private final String string;
    private final MimeType type;

    public Magic(MimeType mimeType, int i, Clause clause2) {
        this.type = mimeType;
        this.priority = i;
        this.clause = clause2;
        this.string = "[" + i + "/" + clause2 + "]";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Magic)) {
            return false;
        }
        Magic magic = (Magic) obj;
        return this.type.equals(magic.type) && this.string.equals(magic.string);
    }

    public boolean eval(byte[] bArr) {
        return this.clause.eval(bArr);
    }

    public int getPriority() {
        return this.priority;
    }

    public MimeType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.string.hashCode() ^ this.type.hashCode();
    }

    public int size() {
        return this.clause.size();
    }

    public String toString() {
        return this.string;
    }

    public int compareTo(Magic magic) {
        int i = magic.priority - this.priority;
        if (i == 0) {
            i = magic.size() - size();
        }
        if (i == 0) {
            i = magic.type.compareTo(this.type);
        }
        return i == 0 ? magic.string.compareTo(this.string) : i;
    }
}
