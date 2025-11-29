package com.rousetime.android_startup.model;

import com.rousetime.android_startup.StartupListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0001\u0018B/\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\u0012R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/rousetime/android_startup/model/StartupConfig;", "", "Lcom/rousetime/android_startup/model/LoggerLevel;", "loggerLevel", "", "awaitTimeout", "Lcom/rousetime/android_startup/StartupListener;", "listener", "", "openStatistic", "<init>", "(Lcom/rousetime/android_startup/model/LoggerLevel;JLcom/rousetime/android_startup/StartupListener;Ljava/lang/Boolean;)V", "a", "Lcom/rousetime/android_startup/model/LoggerLevel;", "c", "()Lcom/rousetime/android_startup/model/LoggerLevel;", "b", "J", "()J", "Lcom/rousetime/android_startup/StartupListener;", "()Lcom/rousetime/android_startup/StartupListener;", "d", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "Builder", "android-startup_release"}, k = 1, mv = {1, 4, 0})
public final class StartupConfig {

    /* renamed from: a  reason: collision with root package name */
    public final LoggerLevel f9829a;
    public final long b;
    public final StartupListener c;
    public final Boolean d;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/rousetime/android_startup/model/StartupConfig$Builder;", "", "<init>", "()V", "Lcom/rousetime/android_startup/model/LoggerLevel;", "level", "c", "(Lcom/rousetime/android_startup/model/LoggerLevel;)Lcom/rousetime/android_startup/model/StartupConfig$Builder;", "", "timeoutMilliSeconds", "b", "(J)Lcom/rousetime/android_startup/model/StartupConfig$Builder;", "Lcom/rousetime/android_startup/model/StartupConfig;", "a", "()Lcom/rousetime/android_startup/model/StartupConfig;", "Lcom/rousetime/android_startup/model/LoggerLevel;", "mLoggerLevel", "Ljava/lang/Long;", "mAwaitTimeout", "Lcom/rousetime/android_startup/StartupListener;", "Lcom/rousetime/android_startup/StartupListener;", "mListener", "", "d", "Ljava/lang/Boolean;", "mOpenStatistics", "e", "Companion", "android-startup_release"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {
        public static final Companion e = new Companion((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        public LoggerLevel f9830a;
        public Long b;
        public StartupListener c;
        public Boolean d = Boolean.TRUE;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/rousetime/android_startup/model/StartupConfig$Builder$Companion;", "", "()V", "AWAIT_TIMEOUT", "", "android-startup_release"}, k = 1, mv = {1, 1, 16})
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final StartupConfig a() {
            LoggerLevel loggerLevel = this.f9830a;
            if (loggerLevel == null) {
                loggerLevel = LoggerLevel.NONE;
            }
            LoggerLevel loggerLevel2 = loggerLevel;
            Long l = this.b;
            return new StartupConfig(loggerLevel2, l != null ? l.longValue() : 10000, this.c, this.d, (DefaultConstructorMarker) null);
        }

        public final Builder b(long j) {
            this.b = Long.valueOf(j);
            return this;
        }

        public final Builder c(LoggerLevel loggerLevel) {
            this.f9830a = loggerLevel;
            return this;
        }
    }

    public StartupConfig(LoggerLevel loggerLevel, long j, StartupListener startupListener, Boolean bool) {
        this.f9829a = loggerLevel;
        this.b = j;
        this.c = startupListener;
        this.d = bool;
    }

    public final long a() {
        return this.b;
    }

    public final StartupListener b() {
        return this.c;
    }

    public final LoggerLevel c() {
        return this.f9829a;
    }

    public final Boolean d() {
        return this.d;
    }

    public /* synthetic */ StartupConfig(LoggerLevel loggerLevel, long j, StartupListener startupListener, Boolean bool, DefaultConstructorMarker defaultConstructorMarker) {
        this(loggerLevel, j, startupListener, bool);
    }
}
