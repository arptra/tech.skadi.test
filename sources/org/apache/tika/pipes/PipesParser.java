package org.apache.tika.pipes;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PipesParser implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final List f3292a;

    public void close() {
        ArrayList arrayList = new ArrayList();
        for (PipesClient close : this.f3292a) {
            try {
                close.close();
            } catch (IOException e) {
                arrayList.add(e);
            }
        }
        if (arrayList.size() > 0) {
            throw ((IOException) arrayList.get(0));
        }
    }
}
