package com.upuphone.runasone.utils.log.file;

import android.content.Context;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FileWrite implements ILogWrite {
    private static final int CHECK_LOG_FILE = 600;
    private int count = 0;
    private final File logRootPath;
    private String oldDay;
    private Writer writer;

    public FileWrite(Context context) {
        File file = new File(context.getFilesDir(), "CoreLog");
        this.logRootPath = file;
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    private String getDay() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    public void close() {
        Writer writer2 = this.writer;
        if (writer2 != null) {
            try {
                writer2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void flush() {
        Writer writer2 = this.writer;
        if (writer2 != null) {
            try {
                writer2.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void write(String str) {
        try {
            if (this.writer == null) {
                this.oldDay = getDay();
                this.writer = new BufferedWriter(new FileWriter(new File(this.logRootPath, getDay()), true), 4096);
                deleteCacheLog(this.logRootPath);
            }
            this.count++;
            this.writer.write(str);
            if (this.count > CHECK_LOG_FILE) {
                if (!getDay().equals(this.oldDay)) {
                    this.writer.close();
                    this.writer = null;
                }
                this.count = 0;
            }
        } catch (Exception e) {
            Log.e(ILogWrite.TAG_PREFIX, e.toString());
        }
    }
}
