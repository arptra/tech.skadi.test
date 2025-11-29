package top.zibin.luban;

import java.io.InputStream;

public interface InputStreamProvider {
    void close();

    int getIndex();

    String getPath();

    InputStream open();
}
