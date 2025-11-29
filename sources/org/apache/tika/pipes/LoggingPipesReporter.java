package org.apache.tika.pipes;

import org.slf4j.Logger;

public class LoggingPipesReporter extends PipesReporter {
    public Logger b;

    public void a(FetchEmitTuple fetchEmitTuple, PipesResult pipesResult, long j) {
        this.b.debug("{} {} {}", fetchEmitTuple, pipesResult, Long.valueOf(j));
    }
}
