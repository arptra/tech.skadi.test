package com.bumptech.glide.load.data.mediastore;

import java.io.File;

class FileService {
    public boolean a(File file) {
        return file.exists();
    }

    public File b(String str) {
        return new File(str);
    }

    public long c(File file) {
        return file.length();
    }
}
