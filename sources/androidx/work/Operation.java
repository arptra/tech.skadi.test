package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;

public interface Operation {

    /* renamed from: a  reason: collision with root package name */
    public static final State.SUCCESS f2064a = new State.SUCCESS();
    public static final State.IN_PROGRESS b = new State.IN_PROGRESS();

    public static abstract class State {

        public static final class FAILURE extends State {

            /* renamed from: a  reason: collision with root package name */
            public final Throwable f2065a;

            public FAILURE(Throwable th) {
                this.f2065a = th;
            }

            public Throwable a() {
                return this.f2065a;
            }

            public String toString() {
                return "FAILURE (" + this.f2065a.getMessage() + ")";
            }
        }

        public static final class IN_PROGRESS extends State {
            public String toString() {
                return "IN_PROGRESS";
            }

            public IN_PROGRESS() {
            }
        }

        public static final class SUCCESS extends State {
            public String toString() {
                return "SUCCESS";
            }

            public SUCCESS() {
            }
        }
    }

    ListenableFuture getResult();
}
