package org.slf4j.spi;

import org.slf4j.Logger;
import org.slf4j.event.DefaultLoggingEvent;
import org.slf4j.event.Level;

public class DefaultLoggingEventBuilder implements LoggingEventBuilder, CallerBoundaryAware {

    /* renamed from: a  reason: collision with root package name */
    public DefaultLoggingEvent f3468a;
    public Logger b;

    /* renamed from: org.slf4j.spi.DefaultLoggingEventBuilder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3469a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.slf4j.event.Level[] r0 = org.slf4j.event.Level.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3469a = r0
                org.slf4j.event.Level r1 = org.slf4j.event.Level.TRACE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3469a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.slf4j.event.Level r1 = org.slf4j.event.Level.DEBUG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3469a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.slf4j.event.Level r1 = org.slf4j.event.Level.INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3469a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.slf4j.event.Level r1 = org.slf4j.event.Level.WARN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3469a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.slf4j.event.Level r1 = org.slf4j.event.Level.ERROR     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.slf4j.spi.DefaultLoggingEventBuilder.AnonymousClass1.<clinit>():void");
        }
    }

    public DefaultLoggingEventBuilder(Logger logger, Level level) {
        this.b = logger;
        this.f3468a = new DefaultLoggingEvent(level, logger);
    }
}
