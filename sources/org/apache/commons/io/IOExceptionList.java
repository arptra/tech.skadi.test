package org.apache.commons.io;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class IOExceptionList extends IOException {
    private static final long serialVersionUID = 1;
    private final List<? extends Throwable> causeList;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public IOExceptionList(List<? extends Throwable> list) {
        this(String.format("%,d exceptions: %s", new Object[]{Integer.valueOf(list == null ? 0 : list.size()), list}), list);
    }

    public <T extends Throwable> T getCause(int i) {
        return (Throwable) this.causeList.get(i);
    }

    public <T extends Throwable> List<T> getCauseList() {
        return this.causeList;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IOExceptionList(String str, List<? extends Throwable> list) {
        super(str, (list == null || list.isEmpty()) ? null : (Throwable) list.get(0));
        this.causeList = list == null ? Collections.emptyList() : list;
    }

    public <T extends Throwable> T getCause(int i, Class<T> cls) {
        return (Throwable) cls.cast(this.causeList.get(i));
    }

    public <T extends Throwable> List<T> getCauseList(Class<T> cls) {
        return this.causeList;
    }
}
