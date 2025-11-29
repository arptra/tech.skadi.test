package org.apache.commons.lang3.builder;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.Validate;

public class DiffResult<T> implements Iterable<Diff<?>> {
    private static final String DIFFERS_STRING = "differs from";
    public static final String OBJECTS_SAME_STRING = "";
    private final List<Diff<?>> diffList;
    private final T lhs;
    private final T rhs;
    private final ToStringStyle style;

    public DiffResult(T t, T t2, List<Diff<?>> list, ToStringStyle toStringStyle) {
        Validate.notNull(t, "lhs", new Object[0]);
        Validate.notNull(t2, "rhs", new Object[0]);
        Validate.notNull(list, "diffList", new Object[0]);
        this.diffList = list;
        this.lhs = t;
        this.rhs = t2;
        if (toStringStyle == null) {
            this.style = ToStringStyle.DEFAULT_STYLE;
        } else {
            this.style = toStringStyle;
        }
    }

    public List<Diff<?>> getDiffs() {
        return Collections.unmodifiableList(this.diffList);
    }

    public T getLeft() {
        return this.lhs;
    }

    public int getNumberOfDiffs() {
        return this.diffList.size();
    }

    public T getRight() {
        return this.rhs;
    }

    public ToStringStyle getToStringStyle() {
        return this.style;
    }

    public Iterator<Diff<?>> iterator() {
        return this.diffList.iterator();
    }

    public String toString() {
        return toString(this.style);
    }

    public String toString(ToStringStyle toStringStyle) {
        if (this.diffList.isEmpty()) {
            return "";
        }
        ToStringBuilder toStringBuilder = new ToStringBuilder(this.lhs, toStringStyle);
        ToStringBuilder toStringBuilder2 = new ToStringBuilder(this.rhs, toStringStyle);
        for (Diff next : this.diffList) {
            toStringBuilder.append(next.getFieldName(), next.getLeft());
            toStringBuilder2.append(next.getFieldName(), next.getRight());
        }
        return String.format("%s %s %s", new Object[]{toStringBuilder.build(), DIFFERS_STRING, toStringBuilder2.build()});
    }
}
