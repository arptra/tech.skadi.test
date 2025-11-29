package org.apache.tika.pipes;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import org.apache.tika.sax.BasicContentHandlerFactory;

public class HandlerConfig implements Serializable {
    public static final HandlerConfig DEFAULT_HANDLER_CONFIG = new HandlerConfig(BasicContentHandlerFactory.HANDLER_TYPE.TEXT, PARSE_MODE.RMETA, -1, -1, true);
    private static final long serialVersionUID = -3861669115439125268L;
    int maxEmbeddedResources = -1;
    PARSE_MODE parseMode;
    boolean throwOnWriteLimitReached = true;
    private BasicContentHandlerFactory.HANDLER_TYPE type = BasicContentHandlerFactory.HANDLER_TYPE.TEXT;
    int writeLimit = -1;

    public enum PARSE_MODE {
        RMETA,
        CONCATENATE;

        public static PARSE_MODE parseMode(String str) {
            int i = 0;
            for (PARSE_MODE parse_mode : values()) {
                if (parse_mode.name().equalsIgnoreCase(str)) {
                    return parse_mode;
                }
            }
            StringBuilder sb = new StringBuilder();
            PARSE_MODE[] values = values();
            int length = values.length;
            int i2 = 0;
            while (i < length) {
                PARSE_MODE parse_mode2 = values[i];
                int i3 = i2 + 1;
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(parse_mode2.name().toLowerCase(Locale.US));
                i++;
                i2 = i3;
            }
            throw new IllegalArgumentException("mode must be one of: (" + sb + "). I regret I do not understand: " + str);
        }
    }

    public HandlerConfig(BasicContentHandlerFactory.HANDLER_TYPE handler_type, PARSE_MODE parse_mode, int i, int i2, boolean z) {
        PARSE_MODE parse_mode2 = PARSE_MODE.RMETA;
        this.type = handler_type;
        this.parseMode = parse_mode;
        this.writeLimit = i;
        this.maxEmbeddedResources = i2;
        this.throwOnWriteLimitReached = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HandlerConfig handlerConfig = (HandlerConfig) obj;
        return this.writeLimit == handlerConfig.writeLimit && this.maxEmbeddedResources == handlerConfig.maxEmbeddedResources && this.throwOnWriteLimitReached == handlerConfig.throwOnWriteLimitReached && this.type == handlerConfig.type && this.parseMode == handlerConfig.parseMode;
    }

    public int getMaxEmbeddedResources() {
        return this.maxEmbeddedResources;
    }

    public PARSE_MODE getParseMode() {
        return this.parseMode;
    }

    public BasicContentHandlerFactory.HANDLER_TYPE getType() {
        return this.type;
    }

    public int getWriteLimit() {
        return this.writeLimit;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.type, Integer.valueOf(this.writeLimit), Integer.valueOf(this.maxEmbeddedResources), Boolean.valueOf(this.throwOnWriteLimitReached), this.parseMode});
    }

    public boolean isThrowOnWriteLimitReached() {
        return this.throwOnWriteLimitReached;
    }

    public String toString() {
        return "HandlerConfig{type=" + this.type + ", writeLimit=" + this.writeLimit + ", maxEmbeddedResources=" + this.maxEmbeddedResources + ", throwOnWriteLimitReached=" + this.throwOnWriteLimitReached + ", parseMode=" + this.parseMode + '}';
    }
}
