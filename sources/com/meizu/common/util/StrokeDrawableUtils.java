package com.meizu.common.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.PictureDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.LruCache;

public class StrokeDrawableUtils {
    private static final int DEF_STROKE_RADIUS = 1;
    private static final int EFFECTIVE_COLOR = -16777216;
    private static final int MAX_LENGTH = 1000;
    private static final int STROKE_ALPHA_VALUE = 78;
    private static final int STROKE_RECT_ALPHA_VALUE = 26;
    private static final Object syncStroke = new Object();
    private static final Object syncStrokeRect = new Object();

    public static class StrokeLruCache {
        private static BlurMaskFilter mBlurMaskFilter;
        private static final int mCacheSize;
        private static final int mMaxMemory;
        private static LruCache<String, Bitmap> mMemoryCache;
        private static Canvas mStrokeCanvas;
        private static Paint mStrokePaint;

        static {
            int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
            mMaxMemory = maxMemory;
            int i = maxMemory / 8;
            mCacheSize = i;
            mMemoryCache = new LruCache<String, Bitmap>(i) {
                public int sizeOf(String str, Bitmap bitmap) {
                    return bitmap.getByteCount() / 1024;
                }
            };
        }

        private StrokeLruCache() {
        }

        public static Bitmap getExtraAlphaBitmap(int i, int i2, int i3, Bitmap bitmap) {
            String str = String.valueOf(i3) + String.valueOf(i) + String.valueOf(i2);
            Bitmap bitmap2 = mMemoryCache.get(str);
            if (bitmap2 != null) {
                return bitmap2;
            }
            BlurMaskFilter obtainBlurMaskFilter = obtainBlurMaskFilter();
            Paint obtainStokePaint = obtainStokePaint();
            obtainStokePaint.setMaskFilter(obtainBlurMaskFilter);
            Bitmap extractAlpha = bitmap.extractAlpha(obtainStokePaint, new int[2]);
            mMemoryCache.put(str, extractAlpha);
            return extractAlpha;
        }

        public static BlurMaskFilter obtainBlurMaskFilter() {
            if (mBlurMaskFilter == null) {
                mBlurMaskFilter = new BlurMaskFilter(1.0f, BlurMaskFilter.Blur.OUTER);
            }
            return mBlurMaskFilter;
        }

        public static Paint obtainStokePaint() {
            if (mStrokePaint == null) {
                mStrokePaint = new Paint();
            }
            return mStrokePaint;
        }

        public static Canvas obtainStrokeCanvas() {
            if (mStrokeCanvas == null) {
                mStrokeCanvas = new Canvas();
            }
            return mStrokeCanvas;
        }
    }

    public static Drawable createRectStrokeDrawable(Drawable drawable, Resources resources) {
        BitmapDrawable bitmapDrawable;
        synchronized (syncStrokeRect) {
            try {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
                if (createBitmap != null) {
                    createBitmap.eraseColor(0);
                    Canvas obtainStrokeCanvas = StrokeLruCache.obtainStrokeCanvas();
                    obtainStrokeCanvas.setBitmap(createBitmap);
                    drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                    drawable.draw(obtainStrokeCanvas);
                    obtainStrokeCanvas.save();
                    Paint obtainStokePaint = StrokeLruCache.obtainStokePaint();
                    obtainStokePaint.setStrokeWidth(1.0f);
                    obtainStokePaint.setColor(EFFECTIVE_COLOR);
                    obtainStokePaint.setAlpha(26);
                    obtainStokePaint.setStyle(Paint.Style.STROKE);
                    obtainStrokeCanvas.drawRect(1.0f, 1.0f, (float) (intrinsicWidth - 1), (float) (intrinsicHeight - 1), obtainStokePaint);
                    bitmapDrawable = new BitmapDrawable(resources, createBitmap);
                } else {
                    bitmapDrawable = null;
                }
                if (bitmapDrawable != null) {
                    drawable = bitmapDrawable;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return drawable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000a, code lost:
        r2 = r11.getIntrinsicHeight() + 2;
        r3 = r11.getIntrinsicWidth() + 2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.drawable.Drawable createStrokeDrawable(android.graphics.drawable.Drawable r11, android.content.res.Resources r12, java.lang.Boolean r13) {
        /*
            java.lang.Object r13 = syncStroke
            monitor-enter(r13)
            android.graphics.Bitmap r0 = drawable2Bitmap(r11)     // Catch:{ all -> 0x0070 }
            r1 = 0
            if (r0 == 0) goto L_0x0072
            int r2 = r11.getIntrinsicHeight()     // Catch:{ all -> 0x0070 }
            int r2 = r2 + 2
            int r3 = r11.getIntrinsicWidth()     // Catch:{ all -> 0x0070 }
            int r3 = r3 + 2
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0070 }
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r3, r2, r4)     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x0072
            int r5 = r11.hashCode()     // Catch:{ all -> 0x0070 }
            r6 = 0
            r4.eraseColor(r6)     // Catch:{ all -> 0x0070 }
            android.graphics.Canvas r7 = com.meizu.common.util.StrokeDrawableUtils.StrokeLruCache.obtainStrokeCanvas()     // Catch:{ all -> 0x0070 }
            r7.setBitmap(r4)     // Catch:{ all -> 0x0070 }
            android.graphics.Paint r8 = com.meizu.common.util.StrokeDrawableUtils.StrokeLruCache.obtainStokePaint()     // Catch:{ all -> 0x0070 }
            android.graphics.Bitmap r5 = com.meizu.common.util.StrokeDrawableUtils.StrokeLruCache.getExtraAlphaBitmap(r3, r2, r5, r0)     // Catch:{ all -> 0x0070 }
            r8.reset()     // Catch:{ all -> 0x0070 }
            r9 = 78
            r8.setAlpha(r9)     // Catch:{ all -> 0x0070 }
            int r9 = r5.getWidth()     // Catch:{ all -> 0x0070 }
            int r9 = r3 - r9
            int r9 = r9 >> 1
            float r9 = (float) r9     // Catch:{ all -> 0x0070 }
            int r10 = r5.getHeight()     // Catch:{ all -> 0x0070 }
            int r10 = r2 - r10
            int r10 = r10 >> 1
            float r10 = (float) r10     // Catch:{ all -> 0x0070 }
            r7.drawBitmap(r5, r9, r10, r8)     // Catch:{ all -> 0x0070 }
            int r5 = r0.getWidth()     // Catch:{ all -> 0x0070 }
            int r5 = r3 - r5
            int r5 = r5 >> 1
            float r5 = (float) r5     // Catch:{ all -> 0x0070 }
            int r8 = r0.getHeight()     // Catch:{ all -> 0x0070 }
            int r8 = r2 - r8
            int r8 = r8 >> 1
            float r8 = (float) r8     // Catch:{ all -> 0x0070 }
            r7.drawBitmap(r0, r5, r8, r1)     // Catch:{ all -> 0x0070 }
            android.graphics.drawable.BitmapDrawable r1 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x0070 }
            r1.<init>(r12, r4)     // Catch:{ all -> 0x0070 }
            r1.setBounds(r6, r6, r3, r2)     // Catch:{ all -> 0x0070 }
            goto L_0x0072
        L_0x0070:
            r11 = move-exception
            goto L_0x0078
        L_0x0072:
            if (r1 != 0) goto L_0x0075
            goto L_0x0076
        L_0x0075:
            r11 = r1
        L_0x0076:
            monitor-exit(r13)     // Catch:{ all -> 0x0070 }
            return r11
        L_0x0078:
            monitor-exit(r13)     // Catch:{ all -> 0x0070 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.common.util.StrokeDrawableUtils.createStrokeDrawable(android.graphics.drawable.Drawable, android.content.res.Resources, java.lang.Boolean):android.graphics.drawable.Drawable");
    }

    private static Bitmap drawable2Bitmap(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable != null && drawable.getIntrinsicHeight() <= 1000 && drawable.getIntrinsicWidth() <= 1000) {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            if (((drawable instanceof NinePatchDrawable) || (drawable instanceof StateListDrawable) || (drawable instanceof GradientDrawable) || (drawable instanceof InsetDrawable) || (drawable instanceof LayerDrawable) || (drawable instanceof LevelListDrawable) || (drawable instanceof PaintDrawable) || (drawable instanceof PictureDrawable) || (drawable instanceof RotateDrawable) || (drawable instanceof ScaleDrawable) || (drawable instanceof ShapeDrawable) || (drawable instanceof ClipDrawable)) && drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0 && (createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888)) != null) {
                Canvas obtainStrokeCanvas = StrokeLruCache.obtainStrokeCanvas();
                obtainStrokeCanvas.setBitmap(createBitmap);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                drawable.draw(obtainStrokeCanvas);
                return createBitmap;
            }
        }
        return null;
    }

    @Deprecated
    public static Drawable createStrokeDrawable(Drawable drawable, Resources resources) {
        return createStrokeDrawable(drawable, resources, Boolean.TRUE);
    }
}
