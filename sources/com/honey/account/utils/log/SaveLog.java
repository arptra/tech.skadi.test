package com.honey.account.utils.log;

import android.util.Log;
import com.honey.account.h2.c;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0014\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001cJ\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0005H\u0002R\u000e\u0010\u0007\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/honey/account/utils/log/SaveLog;", "", "mStorageCount", "", "mFilePath", "", "(ILjava/lang/String;)V", "FILE_SUFFIX_NAME", "TAG", "mBufferedWriter", "Ljava/io/BufferedWriter;", "getMFilePath", "()Ljava/lang/String;", "setMFilePath", "(Ljava/lang/String;)V", "getMStorageCount", "()I", "setMStorageCount", "(I)V", "cleanOldLogFile", "", "dir", "Ljava/io/File;", "close", "open", "save", "", "logList", "", "write", "logText", "ComparatorByLastModified", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SaveLog {
    @NotNull
    private final String FILE_SUFFIX_NAME = ".log.txt";
    @NotNull
    private final String TAG = "SaveLog";
    @Nullable
    private BufferedWriter mBufferedWriter;
    @NotNull
    private String mFilePath;
    private int mStorageCount;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/honey/account/utils/log/SaveLog$ComparatorByLastModified;", "Ljava/util/Comparator;", "Ljava/io/File;", "()V", "compare", "", "f1", "f2", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ComparatorByLastModified implements Comparator<File> {
        public int compare(@NotNull File file, @NotNull File file2) {
            Intrinsics.checkNotNullParameter(file, "f1");
            Intrinsics.checkNotNullParameter(file2, "f2");
            int i = ((file.lastModified() - file2.lastModified()) > 0 ? 1 : ((file.lastModified() - file2.lastModified()) == 0 ? 0 : -1));
            if (i > 0) {
                return -1;
            }
            return i == 0 ? 0 : 1;
        }
    }

    public SaveLog(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "mFilePath");
        this.mStorageCount = i;
        this.mFilePath = str;
    }

    private final void cleanOldLogFile(File file) {
        if (this.mStorageCount < 0) {
            this.mStorageCount = 0;
        }
        File[] listFiles = file.listFiles(new c(this));
        if (listFiles != null && listFiles.length > this.mStorageCount) {
            Arrays.sort(listFiles, new ComparatorByLastModified());
            int length = listFiles.length;
            for (int i = this.mStorageCount; i < length; i++) {
                listFiles[i].delete();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final boolean cleanOldLogFile$lambda$0(SaveLog saveLog, File file) {
        Intrinsics.checkNotNullParameter(saveLog, "this$0");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.endsWith$default(name, saveLog.FILE_SUFFIX_NAME, false, 2, (Object) null);
    }

    private final void close() throws IOException {
        BufferedWriter bufferedWriter = this.mBufferedWriter;
        if (bufferedWriter != null) {
            bufferedWriter.flush();
        }
        BufferedWriter bufferedWriter2 = this.mBufferedWriter;
        if (bufferedWriter2 != null) {
            bufferedWriter2.close();
        }
        this.mBufferedWriter = null;
    }

    private final void open() throws IOException {
        File file = new File(this.mFilePath);
        if (file.exists() || file.mkdirs()) {
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String str = this.mFilePath;
            File file2 = new File(str, format + this.FILE_SUFFIX_NAME);
            if (!file2.exists()) {
                if (!file2.createNewFile()) {
                    String str2 = this.TAG;
                    Log.e(str2, "create new file " + format + " failed !!!");
                } else {
                    cleanOldLogFile(file);
                }
            }
            this.mBufferedWriter = new BufferedWriter(new FileWriter(file2, true));
            return;
        }
        throw new IOException("create " + this.mFilePath + " dir failed.");
    }

    private final void write(String str) throws IOException {
        BufferedWriter bufferedWriter = this.mBufferedWriter;
        if (bufferedWriter != null) {
            bufferedWriter.write(str);
        }
        BufferedWriter bufferedWriter2 = this.mBufferedWriter;
        if (bufferedWriter2 != null) {
            bufferedWriter2.write("\r\n");
        }
    }

    @NotNull
    public final String getMFilePath() {
        return this.mFilePath;
    }

    public final int getMStorageCount() {
        return this.mStorageCount;
    }

    public final boolean save(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "logList");
        if (list.size() == 0) {
            return false;
        }
        try {
            open();
            for (String write : list) {
                write(write);
            }
            try {
                close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                close();
                return false;
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (Throwable th) {
            try {
                close();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    public final void setMFilePath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mFilePath = str;
    }

    public final void setMStorageCount(int i) {
        this.mStorageCount = i;
    }
}
