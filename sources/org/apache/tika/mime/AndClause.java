package org.apache.tika.mime;

import java.util.Arrays;

class AndClause implements Clause {
    private final Clause[] clauses;

    public AndClause(Clause... clauseArr) {
        this.clauses = clauseArr;
    }

    public boolean eval(byte[] bArr) {
        for (Clause eval : this.clauses) {
            if (!eval.eval(bArr)) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        int i = 0;
        for (Clause size : this.clauses) {
            i += size.size();
        }
        return i;
    }

    public String toString() {
        return "and" + Arrays.toString(this.clauses);
    }
}
