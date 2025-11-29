package com.meizu.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import io.netty.handler.codec.http2.Http2CodecUtil;
import java.lang.ref.WeakReference;

public class BitmapUtil {
    private static final float SCALE_FACTOR = 4.0f;
    private static final String TAG = "BitmapUtil";

    public static Bitmap big(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postScale(SCALE_FACTOR, SCALE_FACTOR);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap blurFastBlur(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        Bitmap small = small(bitmap);
        Bitmap fastBlur = FastBlurUtil.fastBlur(small, f);
        WeakReference weakReference = new WeakReference(FastBlurUtil.getOverlayBitmap(fastBlur, Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND));
        try {
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            if (!small.isRecycled()) {
                small.recycle();
            }
            if (fastBlur != null && !fastBlur.isRecycled()) {
                fastBlur.recycle();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (Bitmap) weakReference.get();
    }

    public static Bitmap blurRenderScript(Context context, Bitmap bitmap, float f) {
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        RenderScript create = RenderScript.create(context);
        Allocation createFromBitmap = Allocation.createFromBitmap(create, copy, Allocation.MipmapControl.MIPMAP_FULL, 128);
        Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        create2.setInput(createFromBitmap);
        create2.setRadius(f);
        create2.forEach(createTyped);
        createTyped.copyTo(copy);
        bitmap.recycle();
        return copy;
    }

    public static Bitmap small(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postScale(0.25f, 0.25f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap topCrop(int i, int i2, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = (((float) i) * 1.0f) / ((float) width);
        Matrix matrix = new Matrix();
        matrix.setScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, width, Math.min(height, (int) (((float) i2) / f)), matrix, true);
    }
}
