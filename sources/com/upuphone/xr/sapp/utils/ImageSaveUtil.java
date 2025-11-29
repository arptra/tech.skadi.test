package com.upuphone.xr.sapp.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.upuphone.star.core.log.ULog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/utils/ImageSaveUtil;", "", "<init>", "()V", "Landroid/graphics/Bitmap;", "bitmap", "", "path", "", "b", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "a", "(Ljava/lang/String;)Landroid/graphics/Bitmap;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ImageSaveUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final ImageSaveUtil f7892a = new ImageSaveUtil();

    public final Bitmap a(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        try {
            return BitmapFactory.decodeStream(new FileInputStream(new File(str)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void b(Bitmap bitmap, String str) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(str, "path");
        if (!Environment.getExternalStorageState().equals("mounted")) {
            ULog.f6446a.a("ImageSaveUtil", "saveBitmap: 1return");
            return;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            ULog.Delegate delegate = ULog.f6446a;
            String absolutePath = file.getAbsolutePath();
            delegate.a("ImageSaveUtil", "saveBitmap: " + absolutePath);
        } catch (IOException e) {
            e.printStackTrace();
            ULog.f6446a.a("ImageSaveUtil", "saveBitmap: 2return");
        }
    }
}
