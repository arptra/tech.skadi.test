package org.libpag;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;

public class TraceImage {
    public static void Trace(String str, ByteBuffer byteBuffer, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(byteBuffer);
        Log.i(str, "Image(width = " + createBitmap.getWidth() + ", height = " + createBitmap.getHeight() + ")");
    }
}
