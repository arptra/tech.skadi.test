package com.upuphone.runasone.share.lib.bean;

import android.net.Uri;
import android.text.TextUtils;
import com.upuphone.runasone.share.lib.utils.LogUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StarryNetFile {
    public static final String TAG = "StarryNetFile";
    private String mFileName;
    private long mFileSize;
    private Uri mFileURI;
    private String mMimeType;
    private String mPath;

    public StarryNetFile(String str, String str2, Uri uri, long j, String str3) {
        this.mFileName = str;
        this.mMimeType = str2;
        this.mFileURI = uri;
        this.mFileSize = j;
        this.mPath = str3;
    }

    public File changeFileName(String str, String str2, String str3, int i) {
        File file = new File(str + File.separator + str2 + " (" + i + ")" + str3);
        return file.exists() ? changeFileName(str, str2, str3, i + 1) : file;
    }

    public boolean delete() {
        File file = new File(this.mPath + File.separator + this.mFileName);
        return file.exists() && file.delete();
    }

    public String getFileName() {
        return this.mFileName;
    }

    public long getFileSize() {
        return this.mFileSize;
    }

    public Uri getFileURI() {
        return this.mFileURI;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public OutputStream getOutputStream() throws IOException {
        File file = new File(this.mPath + File.separator + this.mFileName);
        try {
            File file2 = new File(this.mPath);
            if (!file2.exists()) {
                file2.mkdir();
            }
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new FileOutputStream(file);
    }

    public String getPath() {
        return this.mPath;
    }

    public boolean isComplete() {
        File file = new File(this.mPath + File.separator + this.mFileName);
        return file.exists() && file.length() == this.mFileSize;
    }

    public void rename() {
        if (TextUtils.isEmpty(this.mPath)) {
            this.mPath = Constants.FILE_SAVE_LOCATION;
        }
        File file = new File(this.mPath);
        if (!file.isDirectory() && !file.mkdir()) {
            this.mPath = Constants.FILE_SAVE_LOCATION;
            LogUtil.d(TAG, "Can't create base directory " + file.getPath());
        }
        LogUtil.d(TAG, "rename = " + this.mFileName);
    }

    public void setFileName(String str) {
        this.mFileName = str;
    }

    public void setFileSize(long j) {
        this.mFileSize = j;
    }

    public void setFileURI(Uri uri) {
        this.mFileURI = uri;
    }

    public void setMimeType(String str) {
        this.mMimeType = str;
    }

    public void setPath(String str) {
        this.mPath = str;
    }
}
