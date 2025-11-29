package com.upuphone.starryshare;

import android.os.Environment;
import java.io.File;

public class FileTransferDelegate {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6549a;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getPath());
        String str = File.separator;
        sb.append(str);
        sb.append(Environment.DIRECTORY_DOWNLOADS);
        sb.append(str);
        sb.append("Uup Share");
        f6549a = sb.toString();
    }
}
