package org.apache.tika.pipes;

import java.io.Closeable;

public abstract class PipesReporter implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public static final PipesReporter f3293a = new PipesReporter() {
        public void a(FetchEmitTuple fetchEmitTuple, PipesResult pipesResult, long j) {
        }
    };

    public abstract void a(FetchEmitTuple fetchEmitTuple, PipesResult pipesResult, long j);

    public void close() {
    }
}
