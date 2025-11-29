package org.apache.tika.pipes;

import java.util.Map;
import java.util.Set;
import org.apache.tika.config.Initializable;
import org.apache.tika.config.InitializableProblemHandler;
import org.apache.tika.exception.TikaConfigException;

public abstract class PipesReporterBase extends PipesReporter implements Initializable {
    public final Set b;
    public final Set c;
    public StatusFilter d;

    public static class AcceptAllFilter extends StatusFilter {
        public AcceptAllFilter() {
            super();
        }
    }

    public static class ExcludesFilter extends StatusFilter {

        /* renamed from: a  reason: collision with root package name */
        public final Set f3294a;

        public ExcludesFilter(Set set) {
            super();
            this.f3294a = set;
        }
    }

    public static class IncludesFilter extends StatusFilter {

        /* renamed from: a  reason: collision with root package name */
        public final Set f3295a;

        public IncludesFilter(Set set) {
            super();
            this.f3295a = set;
        }
    }

    public static abstract class StatusFilter {
        public StatusFilter() {
        }
    }

    public final StatusFilter b(Set set, Set set2) {
        if (set.size() <= 0 || set2.size() <= 0) {
            return set.size() > 0 ? new IncludesFilter(set) : set2.size() > 0 ? new ExcludesFilter(set2) : new AcceptAllFilter();
        }
        throw new TikaConfigException("Only one of includes and excludes may have any contents");
    }

    public void checkInitialization(InitializableProblemHandler initializableProblemHandler) {
    }

    public void initialize(Map map) {
        this.d = b(this.b, this.c);
    }
}
