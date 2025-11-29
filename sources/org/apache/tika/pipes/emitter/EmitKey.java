package org.apache.tika.pipes.emitter;

import java.io.Serializable;
import java.util.Objects;

public class EmitKey implements Serializable {
    private static final long serialVersionUID = -3861669115439125268L;
    private String emitKey;
    private String emitterName;

    public EmitKey() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EmitKey emitKey2 = (EmitKey) obj;
        if (!Objects.equals(this.emitterName, emitKey2.emitterName)) {
            return false;
        }
        return Objects.equals(this.emitKey, emitKey2.emitKey);
    }

    public String getEmitKey() {
        return this.emitKey;
    }

    public String getEmitterName() {
        return this.emitterName;
    }

    public int hashCode() {
        String str = this.emitterName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.emitKey;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "EmitterKey{emitterName='" + this.emitterName + '\'' + ", emitterKey='" + this.emitKey + '\'' + '}';
    }

    public EmitKey(String str, String str2) {
        this.emitterName = str;
        this.emitKey = str2;
    }
}
