package com.honey.account.sb;

import java.nio.file.Path;
import java.util.function.Function;

public final /* synthetic */ class c implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Path f7614a;

    public /* synthetic */ c(Path path) {
        this.f7614a = path;
    }

    public final Object apply(Object obj) {
        return this.f7614a.relativize((Path) obj);
    }
}
