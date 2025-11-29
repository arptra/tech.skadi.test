package javax.xml.stream;

import com.meizu.common.widget.MzContactsContract;

public class XMLStreamException extends Exception {
    protected Location location;
    protected Throwable nested;

    public XMLStreamException() {
    }

    public Location getLocation() {
        return this.location;
    }

    public Throwable getNestedException() {
        return this.nested;
    }

    public XMLStreamException(String str) {
        super(str);
    }

    public XMLStreamException(Throwable th) {
        this.nested = th;
    }

    public XMLStreamException(String str, Throwable th) {
        super(str);
        this.nested = th;
    }

    public XMLStreamException(String str, Location location2, Throwable th) {
        super("ParseError at [row,col]:[" + location2.getLineNumber() + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + location2.a() + "]\n" + "Message: " + str);
        this.nested = th;
        this.location = location2;
    }

    public XMLStreamException(String str, Location location2) {
        super("ParseError at [row,col]:[" + location2.getLineNumber() + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + location2.a() + "]\n" + "Message: " + str);
        this.location = location2;
    }
}
