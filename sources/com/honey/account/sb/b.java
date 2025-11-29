package com.honey.account.sb;

import java.nio.file.Path;
import java.util.function.Predicate;
import org.apache.commons.io.file.PathFilter;
import org.apache.commons.io.file.PathUtils;

public final /* synthetic */ class b implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PathFilter f7613a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ b(PathFilter pathFilter, boolean z) {
        this.f7613a = pathFilter;
        this.b = z;
    }

    public final boolean test(Object obj) {
        return PathUtils.lambda$walk$2(this.f7613a, this.b, (Path) obj);
    }
}
