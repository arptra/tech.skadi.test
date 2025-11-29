package javax.xml.stream.util;

import javax.xml.stream.XMLEventReader;

public class EventReaderDelegate implements XMLEventReader {

    /* renamed from: a  reason: collision with root package name */
    public XMLEventReader f3698a;

    public boolean hasNext() {
        return this.f3698a.hasNext();
    }

    public Object next() {
        return this.f3698a.next();
    }

    public void remove() {
        this.f3698a.remove();
    }
}
