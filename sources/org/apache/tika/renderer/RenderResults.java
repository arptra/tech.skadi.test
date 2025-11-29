package org.apache.tika.renderer;

import java.io.Closeable;
import org.apache.tika.io.TemporaryResources;

public class RenderResults implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final TemporaryResources f3316a;

    public void close() {
        this.f3316a.close();
    }
}
