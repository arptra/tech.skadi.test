package com.upuphone.starryshare.bean;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.upuphone.starrycommon.utils.GsonUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class FileInfo implements Parcelable {
    public static final Parcelable.Creator<FileInfo> CREATOR = new Parcelable.Creator<FileInfo>() {
        /* renamed from: a */
        public FileInfo createFromParcel(Parcel parcel) {
            return new FileInfo(parcel);
        }

        /* renamed from: b */
        public FileInfo[] newArray(int i) {
            return new FileInfo[i];
        }
    };
    public static final int FLAG_DEFAULT = 0;
    public static final int FLAG_FAILURE = -1;
    public static final int FLAG_SUCCESS = 1;
    private long beginOfFile;
    private transient String desStorage;
    private transient String extra;
    private String filePath;
    private transient int fileType;
    private String md5;
    private String name;
    private int result;
    private long size;
    private transient String sizeDesc;
    private String taskId;
    private transient Uri uri;

    public FileInfo() {
    }

    public static String toJsonStr(List<FileInfo> list) {
        return GsonUtils.c(list);
    }

    public static List<FileInfo> toLists(String str) {
        return GsonUtils.b(str, FileInfo.class);
    }

    public int describeContents() {
        return 0;
    }

    public long getBeginOfFile() {
        return this.beginOfFile;
    }

    public String getDesStorage() {
        return this.desStorage;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getFileType() {
        return this.fileType;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getName() {
        return this.name;
    }

    public int getResult() {
        return this.result;
    }

    public long getSize() {
        return this.size;
    }

    public String getSizeDesc() {
        return this.sizeDesc;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public Uri getUri() {
        return this.uri;
    }

    public void setBeginOfFile(long j) {
        this.beginOfFile = j;
    }

    public void setDesStorage(String str) {
        this.desStorage = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileType(int i) {
        this.fileType = i;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setSizeDesc(String str) {
        this.sizeDesc = str;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public String toString() {
        return "FileInfo{filePath='" + this.filePath + '\'' + ", fileType=" + this.fileType + ", size=" + this.size + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.filePath);
        parcel.writeInt(this.fileType);
        parcel.writeLong(this.size);
        parcel.writeString(this.name);
        parcel.writeString(this.sizeDesc);
        parcel.writeString(this.extra);
        parcel.writeInt(this.result);
        parcel.writeParcelable(this.uri, i);
        parcel.writeString(this.taskId);
        parcel.writeLong(this.beginOfFile);
        parcel.writeString(this.md5);
        parcel.writeString(this.desStorage);
    }

    public FileInfo(String str, Uri uri2, Context context) {
        String str2;
        this.uri = uri2;
        this.taskId = str;
        String str3 = "";
        long j = -1;
        try {
            if (uri2.getScheme().startsWith("content")) {
                Cursor query = context.getContentResolver().query(uri2, new String[]{"_size", "_display_name", "mime_type", "_data"}, (String) null, (String[]) null, (String) null);
                if (query == null || !query.moveToNext()) {
                    throw new FileNotFoundException();
                }
                j = context.getContentResolver().openFileDescriptor(uri2, "r").getStatSize();
                String string = query.getString(query.getColumnIndex("_display_name"));
                try {
                    String path = uri2.getPath();
                    String path2 = string == null ? uri2.getPath() : string;
                    str2 = path;
                    str3 = path2;
                } catch (Exception e) {
                    e = e;
                    String str4 = string;
                    str2 = str3;
                    str3 = str4;
                    e.printStackTrace();
                    this.name = str3;
                    this.size = j;
                    this.filePath = str2;
                }
                this.name = str3;
                this.size = j;
                this.filePath = str2;
            }
            if (uri2.getScheme().startsWith("file")) {
                str2 = uri2.getPath();
                try {
                    File file = new File(uri2.getPath());
                    if (file.exists()) {
                        j = file.length();
                        str3 = file.getName();
                    } else {
                        throw new FileNotFoundException();
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    this.name = str3;
                    this.size = j;
                    this.filePath = str2;
                }
            } else {
                str2 = str3;
            }
            this.name = str3;
            this.size = j;
            this.filePath = str2;
        } catch (Exception e3) {
            e = e3;
            str2 = str3;
            e.printStackTrace();
            this.name = str3;
            this.size = j;
            this.filePath = str2;
        }
    }

    public FileInfo(Parcel parcel) {
        this.filePath = parcel.readString();
        this.fileType = parcel.readInt();
        this.size = parcel.readLong();
        this.name = parcel.readString();
        this.sizeDesc = parcel.readString();
        this.extra = parcel.readString();
        this.result = parcel.readInt();
        this.uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.taskId = parcel.readString();
        this.beginOfFile = parcel.readLong();
        this.md5 = parcel.readString();
        this.desStorage = parcel.readString();
    }
}
