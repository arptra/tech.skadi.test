package androidx.constraintlayout.core.parser;

import java.util.ArrayList;
import java.util.Iterator;

public class CLContainer extends CLElement {
    public ArrayList e;

    public int size() {
        return this.e.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            CLElement cLElement = (CLElement) it.next();
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append(cLElement);
        }
        return super.toString() + " = <" + sb + " >";
    }
}
