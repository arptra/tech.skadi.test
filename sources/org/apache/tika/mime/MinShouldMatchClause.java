package org.apache.tika.mime;

import java.util.List;

class MinShouldMatchClause implements Clause {
    private final List<Clause> clauses;
    private final int min;

    public MinShouldMatchClause(int i, List<Clause> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("clauses must be not null with size > 0");
        } else if (i > list.size()) {
            throw new IllegalArgumentException("min (" + i + ") cannot be > clauses.size (" + list.size() + ")");
        } else if (i > 0) {
            this.min = i;
            this.clauses = list;
        } else {
            throw new IllegalArgumentException("min cannot be <= 0: " + i);
        }
    }

    public boolean eval(byte[] bArr) {
        int i = 0;
        for (Clause eval : this.clauses) {
            if (eval.eval(bArr) && (i = i + 1) >= this.min) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        int i = 0;
        for (Clause size : this.clauses) {
            i = Math.max(i, size.size());
        }
        return i;
    }

    public String toString() {
        return "minShouldMatch (min: " + this.min + ") " + this.clauses;
    }
}
