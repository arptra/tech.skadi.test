package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;

public abstract class DownsampleStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final DownsampleStrategy f2623a = new AtLeast();
    public static final DownsampleStrategy b = new AtMost();
    public static final DownsampleStrategy c = new FitCenter();
    public static final DownsampleStrategy d = new CenterInside();
    public static final DownsampleStrategy e;
    public static final DownsampleStrategy f = new None();
    public static final DownsampleStrategy g;
    public static final Option h;
    public static final boolean i = true;

    public static class AtLeast extends DownsampleStrategy {
        public SampleSizeRounding a(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        public float b(int i, int i2, int i3, int i4) {
            int min = Math.min(i2 / i4, i / i3);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(min));
        }
    }

    public static class AtMost extends DownsampleStrategy {
        public SampleSizeRounding a(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.MEMORY;
        }

        public float b(int i, int i2, int i3, int i4) {
            int ceil = (int) Math.ceil((double) Math.max(((float) i2) / ((float) i4), ((float) i) / ((float) i3)));
            int i5 = 1;
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i5 = 0;
            }
            return 1.0f / ((float) (max << i5));
        }
    }

    public static class CenterInside extends DownsampleStrategy {
        public SampleSizeRounding a(int i, int i2, int i3, int i4) {
            return b(i, i2, i3, i4) == 1.0f ? SampleSizeRounding.QUALITY : DownsampleStrategy.c.a(i, i2, i3, i4);
        }

        public float b(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, DownsampleStrategy.c.b(i, i2, i3, i4));
        }
    }

    public static class CenterOutside extends DownsampleStrategy {
        public SampleSizeRounding a(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        public float b(int i, int i2, int i3, int i4) {
            return Math.max(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
        }
    }

    public static class FitCenter extends DownsampleStrategy {
        public SampleSizeRounding a(int i, int i2, int i3, int i4) {
            return DownsampleStrategy.i ? SampleSizeRounding.QUALITY : SampleSizeRounding.MEMORY;
        }

        public float b(int i, int i2, int i3, int i4) {
            if (DownsampleStrategy.i) {
                return Math.min(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
            }
            int max = Math.max(i2 / i4, i / i3);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(max));
        }
    }

    public static class None extends DownsampleStrategy {
        public SampleSizeRounding a(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        public float b(int i, int i2, int i3, int i4) {
            return 1.0f;
        }
    }

    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    static {
        CenterOutside centerOutside = new CenterOutside();
        e = centerOutside;
        g = centerOutside;
        h = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", centerOutside);
    }

    public abstract SampleSizeRounding a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}
