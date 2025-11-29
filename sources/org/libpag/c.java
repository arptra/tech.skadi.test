package org.libpag;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.hardware.HardwareBuffer;

abstract class c {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f3427a;
        int b;
        long c;
        private PAGDecoder d;

        public synchronized boolean a() {
            return this.d != null;
        }

        public synchronized boolean b() {
            return this.f3427a > 0 && this.b > 0;
        }

        public synchronized int c() {
            PAGDecoder pAGDecoder;
            pAGDecoder = this.d;
            return pAGDecoder == null ? 0 : pAGDecoder.numFrames();
        }

        public synchronized void d() {
            PAGDecoder pAGDecoder = this.d;
            if (pAGDecoder != null) {
                pAGDecoder.release();
                this.d = null;
            }
        }

        public synchronized void e() {
            d();
            this.f3427a = 0;
            this.b = 0;
            this.c = 0;
        }

        public synchronized boolean a(int i) {
            PAGDecoder pAGDecoder;
            pAGDecoder = this.d;
            return pAGDecoder != null && pAGDecoder.checkFrameChanged(i);
        }

        public synchronized boolean a(int i, HardwareBuffer hardwareBuffer) {
            PAGDecoder pAGDecoder;
            pAGDecoder = this.d;
            return (pAGDecoder == null || hardwareBuffer == null || !pAGDecoder.readFrame(i, hardwareBuffer)) ? false : true;
        }

        public synchronized boolean a(Bitmap bitmap, int i) {
            PAGDecoder pAGDecoder;
            pAGDecoder = this.d;
            return (pAGDecoder == null || bitmap == null || !pAGDecoder.copyFrameTo(bitmap, i)) ? false : true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean a(org.libpag.PAGComposition r4, int r5, int r6, float r7) {
            /*
                r3 = this;
                monitor-enter(r3)
                if (r4 == 0) goto L_0x004a
                if (r5 <= 0) goto L_0x004a
                if (r6 <= 0) goto L_0x004a
                r0 = 0
                int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r0 > 0) goto L_0x000d
                goto L_0x004a
            L_0x000d:
                int r0 = r4.width()     // Catch:{ all -> 0x0022 }
                int r1 = r4.height()     // Catch:{ all -> 0x0022 }
                r2 = 1065353216(0x3f800000, float:1.0)
                if (r0 < r1) goto L_0x0024
                float r5 = (float) r5     // Catch:{ all -> 0x0022 }
                float r5 = r5 * r2
                int r6 = r4.width()     // Catch:{ all -> 0x0022 }
            L_0x001f:
                float r6 = (float) r6     // Catch:{ all -> 0x0022 }
                float r5 = r5 / r6
                goto L_0x002b
            L_0x0022:
                r4 = move-exception
                goto L_0x0048
            L_0x0024:
                float r5 = (float) r6     // Catch:{ all -> 0x0022 }
                float r5 = r5 * r2
                int r6 = r4.height()     // Catch:{ all -> 0x0022 }
                goto L_0x001f
            L_0x002b:
                org.libpag.PAGDecoder r5 = org.libpag.PAGDecoder.Make(r4, r7, r5)     // Catch:{ all -> 0x0022 }
                r3.d = r5     // Catch:{ all -> 0x0022 }
                int r5 = r5.width()     // Catch:{ all -> 0x0022 }
                r3.f3427a = r5     // Catch:{ all -> 0x0022 }
                org.libpag.PAGDecoder r5 = r3.d     // Catch:{ all -> 0x0022 }
                int r5 = r5.height()     // Catch:{ all -> 0x0022 }
                r3.b = r5     // Catch:{ all -> 0x0022 }
                long r4 = r4.duration()     // Catch:{ all -> 0x0022 }
                r3.c = r4     // Catch:{ all -> 0x0022 }
                monitor-exit(r3)
                r3 = 1
                return r3
            L_0x0048:
                monitor-exit(r3)
                throw r4
            L_0x004a:
                monitor-exit(r3)
                r3 = 0
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: org.libpag.c.a.a(org.libpag.PAGComposition, int, int, float):boolean");
        }
    }

    public static double a(int i, int i2) {
        if (i2 <= 1 || i < 0) {
            return 0.0d;
        }
        if (i >= i2 - 1) {
            return 1.0d;
        }
        return ((((double) i) * 1.0d) + 0.1d) / ((double) i2);
    }

    public static Matrix a(int i, int i2, int i3, int i4, int i5) {
        Matrix matrix = new Matrix();
        if (i != 0 && i2 > 0 && i3 > 0 && i4 > 0 && i5 > 0) {
            float f = (float) i4;
            float f2 = (float) i2;
            float f3 = (f * 1.0f) / f2;
            float f4 = (float) i5;
            float f5 = (float) i3;
            float f6 = (1.0f * f4) / f5;
            if (i == 1) {
                matrix.setScale(f3, f6);
            } else if (i != 3) {
                float min = Math.min(f3, f6);
                matrix.setScale(min, min);
                if (f3 < f6) {
                    matrix.postTranslate(0.0f, (f4 - (f5 * min)) * 0.5f);
                } else {
                    matrix.postTranslate((f - (f2 * min)) * 0.5f, 0.0f);
                }
            } else {
                float max = Math.max(f3, f6);
                matrix.setScale(max, max);
                if (f3 > f6) {
                    matrix.postTranslate(0.0f, (f4 - (f5 * max)) * 0.5f);
                } else {
                    matrix.postTranslate((f - (f2 * max)) * 0.5f, 0.0f);
                }
            }
        }
        return matrix;
    }

    private static double a(double d, double d2) {
        return d - (((double) ((int) Math.floor(d / d2))) * d2);
    }

    public static int a(double d, int i) {
        if (i <= 1) {
            return 0;
        }
        double a2 = a(d, 1.0d);
        if (a2 <= 0.0d && d != 0.0d) {
            a2 += 1.0d;
        }
        int floor = (int) Math.floor(a2 * ((double) i));
        return floor == i ? i - 1 : floor;
    }
}
