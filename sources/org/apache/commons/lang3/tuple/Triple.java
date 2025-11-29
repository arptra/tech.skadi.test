package org.apache.commons.lang3.tuple;

import com.meizu.common.widget.MzContactsContract;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang3.builder.CompareToBuilder;

public abstract class Triple<L, M, R> implements Comparable<Triple<L, M, R>>, Serializable {
    public static final Triple<?, ?, ?>[] EMPTY_ARRAY = new TripleAdapter[0];
    private static final long serialVersionUID = 1;

    public static final class TripleAdapter<L, M, R> extends Triple<L, M, R> {
        private static final long serialVersionUID = 1;

        private TripleAdapter() {
        }

        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return Triple.super.compareTo((Triple) obj);
        }

        public L getLeft() {
            return null;
        }

        public M getMiddle() {
            return null;
        }

        public R getRight() {
            return null;
        }
    }

    public static <L, M, R> Triple<L, M, R>[] emptyArray() {
        return EMPTY_ARRAY;
    }

    public static <L, M, R> Triple<L, M, R> of(L l, M m, R r) {
        return new ImmutableTriple(l, m, r);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return Objects.equals(getLeft(), triple.getLeft()) && Objects.equals(getMiddle(), triple.getMiddle()) && Objects.equals(getRight(), triple.getRight());
    }

    public abstract L getLeft();

    public abstract M getMiddle();

    public abstract R getRight();

    public int hashCode() {
        return Objects.hashCode(getRight()) ^ (Objects.hashCode(getLeft()) ^ Objects.hashCode(getMiddle()));
    }

    public String toString() {
        return "(" + getLeft() + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + getMiddle() + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + getRight() + ")";
    }

    public int compareTo(Triple<L, M, R> triple) {
        return new CompareToBuilder().append(getLeft(), (Object) triple.getLeft()).append(getMiddle(), (Object) triple.getMiddle()).append(getRight(), (Object) triple.getRight()).toComparison();
    }

    public String toString(String str) {
        return String.format(str, new Object[]{getLeft(), getMiddle(), getRight()});
    }
}
