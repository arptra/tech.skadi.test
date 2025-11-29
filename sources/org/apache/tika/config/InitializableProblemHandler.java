package org.apache.tika.config;

public interface InitializableProblemHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final InitializableProblemHandler f4133a = new InitializableProblemHandler() {
        public String toString() {
            return "IGNORE";
        }
    };
    public static final InitializableProblemHandler b = new InitializableProblemHandler() {
        public String toString() {
            return "INFO";
        }
    };
    public static final InitializableProblemHandler c;
    public static final InitializableProblemHandler d = new InitializableProblemHandler() {
        public String toString() {
            return "THROW";
        }
    };
    public static final InitializableProblemHandler e;

    static {
        AnonymousClass3 r0 = new InitializableProblemHandler() {
            public String toString() {
                return "WARN";
            }
        };
        c = r0;
        e = r0;
    }
}
