package org.apache.tika.pipes;

import java.io.Serializable;
import java.util.Objects;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.pipes.emitter.EmitKey;
import org.apache.tika.pipes.fetcher.FetchKey;

public class FetchEmitTuple implements Serializable {
    public static final ON_PARSE_EXCEPTION DEFAULT_ON_PARSE_EXCEPTION = ON_PARSE_EXCEPTION.EMIT;
    private EmitKey emitKey;
    private final FetchKey fetchKey;
    private HandlerConfig handlerConfig;
    private final String id;
    private final Metadata metadata;
    private final ON_PARSE_EXCEPTION onParseException;

    public enum ON_PARSE_EXCEPTION {
        SKIP,
        EMIT
    }

    public FetchEmitTuple(String str, FetchKey fetchKey2, EmitKey emitKey2) {
        this(str, fetchKey2, emitKey2, new Metadata(), HandlerConfig.DEFAULT_HANDLER_CONFIG, DEFAULT_ON_PARSE_EXCEPTION);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FetchEmitTuple fetchEmitTuple = (FetchEmitTuple) obj;
        if (Objects.equals(this.id, fetchEmitTuple.id) && Objects.equals(this.fetchKey, fetchEmitTuple.fetchKey) && Objects.equals(this.emitKey, fetchEmitTuple.emitKey) && Objects.equals(this.metadata, fetchEmitTuple.metadata) && this.onParseException == fetchEmitTuple.onParseException) {
            return Objects.equals(this.handlerConfig, fetchEmitTuple.handlerConfig);
        }
        return false;
    }

    public EmitKey getEmitKey() {
        return this.emitKey;
    }

    public FetchKey getFetchKey() {
        return this.fetchKey;
    }

    public HandlerConfig getHandlerConfig() {
        HandlerConfig handlerConfig2 = this.handlerConfig;
        return handlerConfig2 == null ? HandlerConfig.DEFAULT_HANDLER_CONFIG : handlerConfig2;
    }

    public String getId() {
        return this.id;
    }

    public Metadata getMetadata() {
        return this.metadata;
    }

    public ON_PARSE_EXCEPTION getOnParseException() {
        return this.onParseException;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        FetchKey fetchKey2 = this.fetchKey;
        int hashCode2 = (hashCode + (fetchKey2 != null ? fetchKey2.hashCode() : 0)) * 31;
        EmitKey emitKey2 = this.emitKey;
        int hashCode3 = (hashCode2 + (emitKey2 != null ? emitKey2.hashCode() : 0)) * 31;
        Metadata metadata2 = this.metadata;
        int hashCode4 = (hashCode3 + (metadata2 != null ? metadata2.hashCode() : 0)) * 31;
        ON_PARSE_EXCEPTION on_parse_exception = this.onParseException;
        int hashCode5 = (hashCode4 + (on_parse_exception != null ? on_parse_exception.hashCode() : 0)) * 31;
        HandlerConfig handlerConfig2 = this.handlerConfig;
        if (handlerConfig2 != null) {
            i = handlerConfig2.hashCode();
        }
        return hashCode5 + i;
    }

    public void setEmitKey(EmitKey emitKey2) {
        this.emitKey = emitKey2;
    }

    public void setHandlerConfig(HandlerConfig handlerConfig2) {
        this.handlerConfig = handlerConfig2;
    }

    public String toString() {
        return "FetchEmitTuple{id='" + this.id + '\'' + ", fetchKey=" + this.fetchKey + ", emitKey=" + this.emitKey + ", metadata=" + this.metadata + ", onParseException=" + this.onParseException + ", handlerConfig=" + this.handlerConfig + '}';
    }

    public FetchEmitTuple(String str, FetchKey fetchKey2, EmitKey emitKey2, ON_PARSE_EXCEPTION on_parse_exception) {
        this(str, fetchKey2, emitKey2, new Metadata(), HandlerConfig.DEFAULT_HANDLER_CONFIG, on_parse_exception);
    }

    public FetchEmitTuple(String str, FetchKey fetchKey2, EmitKey emitKey2, Metadata metadata2) {
        this(str, fetchKey2, emitKey2, metadata2, HandlerConfig.DEFAULT_HANDLER_CONFIG, DEFAULT_ON_PARSE_EXCEPTION);
    }

    public FetchEmitTuple(String str, FetchKey fetchKey2, EmitKey emitKey2, Metadata metadata2, HandlerConfig handlerConfig2, ON_PARSE_EXCEPTION on_parse_exception) {
        this.id = str;
        this.fetchKey = fetchKey2;
        this.emitKey = emitKey2;
        this.metadata = metadata2;
        this.handlerConfig = handlerConfig2;
        this.onParseException = on_parse_exception;
    }
}
