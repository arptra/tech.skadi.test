package org.apache.tika.mime;

import java.util.List;

class OrClause implements Clause {
    private final List<Clause> clauses;

    public OrClause(List<Clause> list) {
        this.clauses = list;
    }

    public boolean eval(byte[] bArr) {
        for (Clause eval : this.clauses) {
            if (eval.eval(bArr)) {
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
        return "or" + this.clauses;
    }
}
