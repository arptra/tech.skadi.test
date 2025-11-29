package com.upuphone.runasone.utils.log.file;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MapBufferWrite implements ILogWrite {
    private static final int MAP_SIZE = 65536;
    private FileChannel channel;
    private final File logRootPath;
    private MappedByteBuffer mapBuf;
    private RandomAccessFile raf;

    public MapBufferWrite(Context context) {
        File file = new File(context.getFilesDir(), "CoreLog");
        this.logRootPath = file;
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    private String getDay() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
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
            deleteCacheLog(this.logRootPath);
        } catch (Exception e) {
            Log.e(ILogWrite.TAG_PREFIX, e.toString());
        }
    }

    private void writeInner(String str) {
        if (this.mapBuf != null) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            if (this.mapBuf.remaining() < bytes.length) {
                reset();
            }
            this.mapBuf.put(bytes);
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

    public void flush() {
        MappedByteBuffer mappedByteBuffer = this.mapBuf;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.force();
        }
    }

    public synchronized void write(String str) {
        if (this.mapBuf != null || init()) {
            writeInner(str);
        }
    }
}
