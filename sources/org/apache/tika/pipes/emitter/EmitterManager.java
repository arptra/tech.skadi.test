package org.apache.tika.pipes.emitter;

import java.util.Map;
import org.apache.tika.config.ConfigBase;

public class EmitterManager extends ConfigBase {

    /* renamed from: a  reason: collision with root package name */
    public final Map f3304a;

    public Emitter J(String str) {
        Emitter emitter = (Emitter) this.f3304a.get(str);
        if (emitter != null) {
            return emitter;
        }
        throw new IllegalArgumentException("Can't find emitter for prefix: " + str);
    }
}
