package org.apache.tika.pipes;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.tika.config.Initializable;
import org.apache.tika.config.InitializableProblemHandler;
import org.apache.tika.exception.TikaConfigException;

public class CompositePipesReporter extends PipesReporter implements Initializable {
    public List b;

    public void a(FetchEmitTuple fetchEmitTuple, PipesResult pipesResult, long j) {
        for (PipesReporter a2 : this.b) {
            a2.a(fetchEmitTuple, pipesResult, j);
        }
    }

    public void checkInitialization(InitializableProblemHandler initializableProblemHandler) {
        List list = this.b;
        if (list == null) {
            throw new TikaConfigException("must specify 'pipesReporters'");
        } else if (list.size() == 0) {
            throw new TikaConfigException("must specify at least one pipes reporter");
        }
    }

    public void close() {
        IOException e = null;
        for (PipesReporter close : this.b) {
            try {
                close.close();
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public void initialize(Map map) {
    }
}
