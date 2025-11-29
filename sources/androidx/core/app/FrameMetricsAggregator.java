package androidx.core.app;

import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class FrameMetricsAggregator {

    @RequiresApi
    public static class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {

        /* renamed from: a  reason: collision with root package name */
        public int f648a;
        public SparseIntArray[] b;

        /* renamed from: androidx.core.app.FrameMetricsAggregator$FrameMetricsApi24Impl$1  reason: invalid class name */
        public class AnonymousClass1 implements Window.OnFrameMetricsAvailableListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FrameMetricsApi24Impl f649a;

            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
                FrameMetricsApi24Impl frameMetricsApi24Impl = this.f649a;
                if ((frameMetricsApi24Impl.f648a & 1) != 0) {
                    frameMetricsApi24Impl.a(frameMetricsApi24Impl.b[0], frameMetrics.getMetric(8));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl2 = this.f649a;
                if ((frameMetricsApi24Impl2.f648a & 2) != 0) {
                    frameMetricsApi24Impl2.a(frameMetricsApi24Impl2.b[1], frameMetrics.getMetric(1));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl3 = this.f649a;
                if ((frameMetricsApi24Impl3.f648a & 4) != 0) {
                    frameMetricsApi24Impl3.a(frameMetricsApi24Impl3.b[2], frameMetrics.getMetric(3));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl4 = this.f649a;
                if ((frameMetricsApi24Impl4.f648a & 8) != 0) {
                    frameMetricsApi24Impl4.a(frameMetricsApi24Impl4.b[3], frameMetrics.getMetric(4));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl5 = this.f649a;
                if ((frameMetricsApi24Impl5.f648a & 16) != 0) {
                    frameMetricsApi24Impl5.a(frameMetricsApi24Impl5.b[4], frameMetrics.getMetric(5));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl6 = this.f649a;
                if ((frameMetricsApi24Impl6.f648a & 64) != 0) {
                    frameMetricsApi24Impl6.a(frameMetricsApi24Impl6.b[6], frameMetrics.getMetric(7));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl7 = this.f649a;
                if ((frameMetricsApi24Impl7.f648a & 32) != 0) {
                    frameMetricsApi24Impl7.a(frameMetricsApi24Impl7.b[5], frameMetrics.getMetric(6));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl8 = this.f649a;
                if ((frameMetricsApi24Impl8.f648a & 128) != 0) {
                    frameMetricsApi24Impl8.a(frameMetricsApi24Impl8.b[7], frameMetrics.getMetric(0));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl9 = this.f649a;
                if ((frameMetricsApi24Impl9.f648a & 256) != 0) {
                    frameMetricsApi24Impl9.a(frameMetricsApi24Impl9.b[8], frameMetrics.getMetric(2));
                }
            }
        }

        public void a(SparseIntArray sparseIntArray, long j) {
            if (sparseIntArray != null) {
                int i = (int) ((500000 + j) / 1000000);
                if (j >= 0) {
                    sparseIntArray.put(i, sparseIntArray.get(i) + 1);
                }
            }
        }
    }

    public static class FrameMetricsBaseImpl {
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface MetricType {
    }
}
