package androidx.constraintlayout.core;

public class GoalRow extends ArrayRow {
    public void c(SolverVariable solverVariable) {
        super.c(solverVariable);
        solverVariable.m--;
    }
}
