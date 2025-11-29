package com.ucar.vehiclesdk.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.easy.logger.EasyLog;
import java.io.ByteArrayOutputStream;

public class BitmapUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5483a = "BitmapUtil";

    public static Bitmap a(byte[] bArr) {
        try {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            EasyLog.d(f5483a, "decodeByteArray exception", e);
            return null;
        }
    }

    public static byte[] b(Context context, int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        decodeResource.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        decodeResource.recycle();
        return byteArrayOutputStream.toByteArray();
    }
}
