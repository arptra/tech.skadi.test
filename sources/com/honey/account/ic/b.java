package com.honey.account.ic;

import java.io.Closeable;
import java.nio.file.Path;
import org.apache.tika.io.TemporaryResources;

public final /* synthetic */ class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Path f9204a;

    public /* synthetic */ b(Path path) {
        this.f9204a = path;
    }

    public final void close() {
        TemporaryResources.j(this.f9204a);
    }
}
