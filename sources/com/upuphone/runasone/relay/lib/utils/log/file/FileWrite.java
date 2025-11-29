package com.upuphone.runasone.relay.lib.utils.log.file;

import android.content.Context;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileWrite implements ILogWrite {
    private File logRootPath;
    private String oldDay;
    private Writer writer;

    public FileWrite(Context context) {
        File file = new File(context.getFilesDir(), "RunAsOneLog");
        this.logRootPath = file;
        if (!file.exists()) {
            this.logRootPath.mkdirs();
        }
    }

    private String getDay() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
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

    public void wirte(String str) {
        try {
            if (getDay().equals(this.oldDay)) {
                if (this.writer == null) {
                }
                this.writer.write(str);
            }
            Writer writer2 = this.writer;
            if (writer2 != null) {
                writer2.close();
            }
            this.oldDay = getDay();
            this.writer = new BufferedWriter(new FileWriter(new File(this.logRootPath, getDay()), true), 4096);
            this.writer.write(str);
        } catch (Exception e) {
            Log.e(ILogWrite.TAG_PREFIX, e.toString());
        }
    }
}
