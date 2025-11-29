package top.zibin.luban;

import java.io.File;

public interface OnNewCompressListener {
    void a(String str, File file);

    void b(String str, Throwable th);

    void onStart();
}
