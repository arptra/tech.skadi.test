package org.apache.tika.renderer;

import java.io.Closeable;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.tika.io.TemporaryResources;

public class RenderResult implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public TemporaryResources f3314a;

    /* renamed from: org.apache.tika.renderer.RenderResult$1  reason: invalid class name */
    class AnonymousClass1 implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f3315a;

        public void close() {
            Files.delete((Path) this.f3315a);
        }
    }

    public enum STATUS {
        SUCCESS,
        EXCEPTION,
        TIMEOUT
    }

    public void close() {
        this.f3314a.close();
    }
}
