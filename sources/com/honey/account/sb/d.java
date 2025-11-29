package com.honey.account.sb;

import java.nio.file.Path;
import java.util.function.Predicate;
import org.apache.commons.io.file.PathFilter;
import org.apache.commons.io.file.PathUtils;

public final /* synthetic */ class d implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PathFilter f7615a;

    public /* synthetic */ d(PathFilter pathFilter) {
        this.f7615a = pathFilter;
    }

    public final boolean test(Object obj) {
        return PathUtils.lambda$filterPaths$0(this.f7615a, (Path) obj);
    }
}
