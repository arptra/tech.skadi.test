package org.apache.tika.pipes;

import org.apache.tika.pipes.emitter.EmitData;

public class PipesResult {
    public static final PipesResult d = new PipesResult(STATUS.CLIENT_UNAVAILABLE_WITHIN_MS);
    public static final PipesResult e = new PipesResult(STATUS.TIMEOUT);
    public static final PipesResult f = new PipesResult(STATUS.OOM);
    public static final PipesResult g = new PipesResult(STATUS.UNSPECIFIED_CRASH);
    public static final PipesResult h = new PipesResult(STATUS.EMIT_SUCCESS);
    public static final PipesResult i = new PipesResult(STATUS.INTERRUPTED_EXCEPTION);
    public static final PipesResult j = new PipesResult(STATUS.EMPTY_OUTPUT);

    /* renamed from: a  reason: collision with root package name */
    public final STATUS f3296a;
    public final EmitData b;
    public final String c;

    public enum STATUS {
        CLIENT_UNAVAILABLE_WITHIN_MS,
        FETCHER_INITIALIZATION_EXCEPTION,
        FETCH_EXCEPTION,
        EMPTY_OUTPUT,
        PARSE_EXCEPTION_NO_EMIT,
        PARSE_EXCEPTION_EMIT,
        PARSE_SUCCESS,
        PARSE_SUCCESS_WITH_EXCEPTION,
        OOM,
        TIMEOUT,
        UNSPECIFIED_CRASH,
        NO_EMITTER_FOUND,
        EMIT_SUCCESS,
        EMIT_SUCCESS_PARSE_EXCEPTION,
        EMIT_EXCEPTION,
        INTERRUPTED_EXCEPTION,
        NO_FETCHER_FOUND
    }

    public PipesResult(STATUS status, EmitData emitData, String str) {
        this.f3296a = status;
        this.b = emitData;
        this.c = str;
    }

    public EmitData a() {
        return this.b;
    }

    public STATUS b() {
        return this.f3296a;
    }

    public String toString() {
        return "PipesResult{status=" + this.f3296a + ", emitData=" + this.b + ", message='" + this.c + '\'' + '}';
    }

    public PipesResult(STATUS status) {
        this(status, (EmitData) null, (String) null);
    }

    public PipesResult(STATUS status, String str) {
        this(status, (EmitData) null, str);
    }

    public PipesResult(EmitData emitData) {
        this(STATUS.PARSE_SUCCESS, emitData, (String) null);
    }

    public PipesResult(EmitData emitData, String str) {
        this(STATUS.PARSE_SUCCESS_WITH_EXCEPTION, emitData, str);
    }
}
