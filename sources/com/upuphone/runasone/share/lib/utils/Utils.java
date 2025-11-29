package com.upuphone.runasone.share.lib.utils;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.upuphone.runasone.channel.linker.starrystack.NetworkUtils;
import com.upuphone.runasone.share.lib.UupShareService;
import com.upuphone.runasone.share.lib.bean.StarryNetFile;
import com.upuphone.runasone.share.lib.bean.StarryNetFiles;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public final class Utils {
    private static final String TAG = "Utils";
    private static volatile Utils mInstance;

    public static String getDisplayName(Uri uri) {
        if (!uri.getScheme().startsWith("content")) {
            return new File(uri.getPath()).getName();
        }
        Cursor query = UupShareService.getContext().getContentResolver().query(uri, new String[]{"_size", "_display_name", "mime_type", "_data"}, (String) null, (String[]) null, (String) null);
        return query.getString(query.getColumnIndex("_display_name"));
    }

    public static Utils getInstance() {
        if (mInstance == null) {
            synchronized (Utils.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new Utils();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mInstance;
    }

    public static String getMD5Three(Uri uri) {
        LogUtil.d("FileUtils", "md5 start ");
        try {
            InputStream openInputStream = UupShareService.getContext().getContentResolver().openInputStream(uri);
            byte[] bArr = new byte[8192];
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            int i = 0;
            while (true) {
                int read = openInputStream.read(bArr);
                if (read == -1 || i >= 896) {
                    openInputStream.close();
                    byte[] digest = instance.digest();
                    StringBuilder sb = new StringBuilder();
                } else {
                    instance.update(bArr, 0, read);
                    i++;
                }
            }
            openInputStream.close();
            byte[] digest2 = instance.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b : digest2) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb2.append(hexString);
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public StarryNetFiles generateStarryNetFiles(Uri[] uriArr, String str, String str2) {
        int i;
        String str3;
        long j;
        String str4;
        String str5;
        Uri[] uriArr2 = uriArr;
        int length = uriArr2.length;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j2 = -1;
        while (true) {
            String str6 = null;
            if (i2 < uriArr2.length) {
                Uri uri = uriArr2[i2];
                LogUtil.d(TAG, "uri(" + i2 + ") = " + uri);
                try {
                    if (uri.getScheme().startsWith("content")) {
                        Cursor query = UupShareService.getContext().getContentResolver().query(uri, new String[]{"_size", "_display_name", "mime_type", "_data"}, (String) null, (String[]) null, (String) null);
                        if (query == null || !query.moveToNext()) {
                            int i3 = i2;
                        } else {
                            i = i2;
                            long j3 = (long) query.getInt(query.getColumnIndex("_size"));
                            try {
                                String string = query.getString(query.getColumnIndex("_display_name"));
                                LogUtil.d(TAG, "generateStarryNetFiles, path = " + null);
                                if (string == null) {
                                    string = Integer.toString(i);
                                }
                                str5 = string;
                                j = j3;
                                str4 = null;
                                str3 = null;
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                i2 = i + 1;
                            }
                        }
                    } else {
                        i = i2;
                        if (uri.getScheme().startsWith("file")) {
                            String path = uri.getPath();
                            File file = new File(uri.getPath());
                            if (file.exists()) {
                                long length2 = file.length();
                                String name = file.getName();
                                int lastIndexOf = name.lastIndexOf(".");
                                if (lastIndexOf >= 0) {
                                    str6 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(lastIndexOf + 1));
                                }
                                str3 = path;
                                str5 = name;
                                j = length2;
                                str4 = str6;
                            } else {
                                throw new FileNotFoundException();
                            }
                        } else {
                            str5 = null;
                            str4 = null;
                            str3 = null;
                            j = -1;
                        }
                    }
                    j2 += j;
                    arrayList.add(new StarryNetFile(str5, str4, uri, j, str3));
                } catch (Exception e2) {
                    e = e2;
                    i = i2;
                    e.printStackTrace();
                    i2 = i + 1;
                }
                i2 = i + 1;
            } else if (arrayList.size() <= 0) {
                return null;
            } else {
                return new StarryNetFiles(str2, str, ((StarryNetFile) arrayList.get(0)).getFileName(), length, getFilesMimeType(arrayList), j2, 0, 0, arrayList);
            }
        }
        int i32 = i2;
        throw new FileNotFoundException();
    }

    public byte[] generateThunmbnail(StarryNetFiles starryNetFiles) {
        new Matrix().postScale(0.1f, 0.1f);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap createVideoThumbnail = (starryNetFiles == null || !starryNetFiles.getMimeType().contains("image")) ? (starryNetFiles == null || !starryNetFiles.getMimeType().contains("video")) ? null : ThumbnailUtils.createVideoThumbnail(starryNetFiles.getLstFiles().get(0).getPath(), 1) : BitmapFactory.decodeFile(starryNetFiles.getLstFiles().get(0).getPath());
        if (createVideoThumbnail != null) {
            createVideoThumbnail.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream);
            int height = createVideoThumbnail.getHeight();
            int width = createVideoThumbnail.getWidth();
            starryNetFiles.setTbHeight(height);
            starryNetFiles.setTbWidth(width);
            LogUtil.d(TAG, "generateThunmbnail, width = " + width + ", height = " + height);
            StringBuilder sb = new StringBuilder();
            sb.append("generateThunmbnail byte size = ");
            sb.append(byteArrayOutputStream.toByteArray().length);
            LogUtil.d(TAG, sb.toString());
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int generateUseablePort() {
        int i = 60000;
        while (i < 65535) {
            try {
                try {
                    ServerSocket serverSocket = new ServerSocket(i);
                    i = serverSocket.getLocalPort();
                    serverSocket.close();
                    break;
                } catch (IOException e) {
                    e = e;
                    i++;
                    LogUtil.e(TAG, "IOException" + e.getMessage());
                }
            } catch (IOException e2) {
                e = e2;
            }
        }
        return i;
    }

    public long getFileTotalSize(Uri[] uriArr) {
        int columnIndex;
        if (uriArr == null) {
            return 0;
        }
        long j = 0;
        for (Uri uri : uriArr) {
            try {
                if (uri.getScheme().startsWith("content")) {
                    Cursor query = UupShareService.getContext().getContentResolver().query(uri, new String[]{"_size", "_display_name", "mime_type", "_data"}, (String) null, (String[]) null, (String) null);
                    if (query == null || !query.moveToNext()) {
                        throw new FileNotFoundException();
                    } else if ((j == 0 || j == -1) && (columnIndex = query.getColumnIndex("_size")) != -1) {
                        j = query.getLong(columnIndex);
                    }
                } else if (uri.getScheme().startsWith("file")) {
                    File file = new File(uri.getPath());
                    if (file.exists()) {
                        j = file.length();
                    } else {
                        throw new FileNotFoundException();
                    }
                } else {
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return j;
    }

    public String getFilesMimeType(List<StarryNetFile> list) {
        int lastIndexOf;
        Iterator<StarryNetFile> it = list.iterator();
        String str = null;
        String str2 = null;
        while (true) {
            if (it.hasNext()) {
                String mimeType = it.next().getMimeType();
                if (mimeType == null || (lastIndexOf = mimeType.lastIndexOf("/")) < 0) {
                    break;
                }
                String substring = mimeType.substring(0, lastIndexOf);
                String substring2 = mimeType.substring(lastIndexOf + 1);
                if (str == null) {
                    str2 = substring2;
                    str = substring;
                } else if (!str.equals(substring)) {
                    break;
                } else if (!str2.equals(substring2)) {
                    str2 = "*";
                }
            } else {
                break;
            }
        }
        str = "*";
        str2 = str;
        return str + File.separator + str2;
    }

    public String getP2PIpAddress() {
        try {
            for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (t.getName().contains("p2p")) {
                    for (T t2 : Collections.list(t.getInetAddresses())) {
                        if (!t2.isLoopbackAddress() && (t2 instanceof Inet4Address)) {
                            String upperCase = t2.getHostAddress().toUpperCase();
                            if (upperCase.contains("192.168.")) {
                                return upperCase;
                            }
                        }
                    }
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.d(TAG, "error in parsing");
        }
        LogUtil.d(TAG, "returning empty ip address");
        return NetworkUtils.UNKNOWN;
    }

    public String getRandomString() {
        return UUID.randomUUID().toString();
    }
}
