package top.zibin.luban;

import java.io.InputStream;
import top.zibin.luban.io.ArrayPoolProvide;

public abstract class InputStreamAdapter implements InputStreamProvider {
    public abstract InputStream a();

    public void close() {
        ArrayPoolProvide.d().a();
    }

    public InputStream open() {
        return a();
    }
}
