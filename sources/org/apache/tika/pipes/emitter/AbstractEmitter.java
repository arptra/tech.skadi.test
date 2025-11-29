package org.apache.tika.pipes.emitter;

import java.util.Iterator;
import java.util.List;

public abstract class AbstractEmitter implements Emitter {
    public void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            EmitData emitData = (EmitData) it.next();
            b(emitData.getEmitKey().getEmitKey(), emitData.getMetadataList());
        }
    }
}
