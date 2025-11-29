package androidx.constraintlayout.core;

import androidx.constraintlayout.core.Pools;

public class Cache {

    /* renamed from: a  reason: collision with root package name */
    public Pools.Pool f478a = new Pools.SimplePool(256);
    public Pools.Pool b = new Pools.SimplePool(256);
    public Pools.Pool c = new Pools.SimplePool(256);
    public SolverVariable[] d = new SolverVariable[32];
}
