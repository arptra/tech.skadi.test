package com.upuphone.runasone.relay.lib.utils.log.file;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.honey.account.j6.a;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class MapBufferWirte implements ILogWrite {
    private static final int MAP_SIZE = 65536;
    private static final int SAVE_LOG_COUNT = 10;
    private FileChannel channel;
    private File logRootPath;
    private MappedByteBuffer mapBuf;
    private RandomAccessFile raf;

    public MapBufferWirte(Context context) {
        File file = new File(context.getFilesDir(), "RunAsOneLog");
        this.logRootPath = file;
        if (!file.exists()) {
            this.logRootPath.mkdirs();
        }
    }

    private String getDay() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private boolean init() {
        try {
            File file = new File(this.logRootPath, getDay());
            boolean writable = file.setWritable(true, false);
            boolean readable = file.setReadable(true, false);
            Log.d(ILogWrite.TAG_PREFIX, writable + " , " + readable);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.raf = randomAccessFile;
            FileChannel channel2 = randomAccessFile.getChannel();
            this.channel = channel2;
            this.mapBuf = channel2.map(FileChannel.MapMode.READ_WRITE, channel2.size(), PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
            return true;
        } catch (Exception e) {
            Log.e(ILogWrite.TAG_PREFIX, e.toString());
            return false;
        }
    }

    private void reset() {
        try {
            close();
            init();
            deleteCacheLog();
        } catch (Exception e) {
            Log.e(ILogWrite.TAG_PREFIX, e.toString());
        }
    }

    private synchronized void wirteInner(String str) {
        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            if (this.mapBuf.remaining() < bytes.length) {
                reset();
            }
            this.mapBuf.put(bytes);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void close() {
        try {
            MappedByteBuffer mappedByteBuffer = this.mapBuf;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.force();
            }
            FileChannel fileChannel = this.channel;
            if (fileChannel != null) {
                fileChannel.close();
            }
            RandomAccessFile randomAccessFile = this.raf;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.mapBuf = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCacheLog() {
        File[] listFiles;
        File file = this.logRootPath;
        if (file != null && (listFiles = file.listFiles()) != null && listFiles.length != 0 && listFiles.length > 10) {
            Arrays.sort(listFiles, Comparator.comparing(new a()));
            for (int i = 0; i < listFiles.length - 10; i++) {
                File file2 = listFiles[i];
                if (file2 != null) {
                    file2.delete();
                }
            }
        }
    }

    public void flush() {
        MappedByteBuffer mappedByteBuffer = this.mapBuf;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.force();
        }
    }

    public void wirte(String str) {
        if (this.mapBuf == null) {
            init();
        }
        wirteInner(str);
    }
}
