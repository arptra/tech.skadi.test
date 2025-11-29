package org.apache.tika.config;

import org.slf4j.LoggerFactory;

public interface LoadErrorHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final LoadErrorHandler f4134a = new LoadErrorHandler() {
        public void a(String str, Throwable th) {
        }

        public String toString() {
            return "IGNORE";
        }
    };
    public static final LoadErrorHandler b = new LoadErrorHandler() {
        public void a(String str, Throwable th) {
            LoggerFactory.l(str).warn("Unable to load {}", str, th);
        }

        public String toString() {
            return "WARN";
        }
    };
    public static final LoadErrorHandler c = new LoadErrorHandler() {
        public void a(String str, Throwable th) {
            throw new RuntimeException("Unable to load " + str, th);
        }

        public String toString() {
            return "THROW";
        }
    };

    void a(String str, Throwable th);
}
