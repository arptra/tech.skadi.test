package io.flutter.embedding.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

public class AndroidTouchProcessor {
    @VisibleForTesting
    static final int BYTES_PER_FIELD = 8;
    @VisibleForTesting
    static final int DEFAULT_HORIZONTAL_SCROLL_FACTOR = 48;
    @VisibleForTesting
    static final int DEFAULT_VERTICAL_SCROLL_FACTOR = 48;
    private static final Matrix IDENTITY_TRANSFORM = new Matrix();
    private static final int IMPLICIT_VIEW_ID = 0;
    private static final int POINTER_DATA_FIELD_COUNT = 36;
    private static final int POINTER_DATA_FLAG_BATCHED = 1;
    private static final String TAG = "AndroidTouchProcessor";
    private int cachedVerticalScrollFactor;
    @NonNull
    private final MotionEventTracker motionEventTracker;
    private final Map<Integer, float[]> ongoingPans = new HashMap();
    @NonNull
    private final FlutterRenderer renderer;
    private final boolean trackMotionEvents;

    public @interface PointerChange {
        public static final int ADD = 1;
        public static final int CANCEL = 0;
        public static final int DOWN = 4;
        public static final int HOVER = 3;
        public static final int MOVE = 5;
        public static final int PAN_ZOOM_END = 9;
        public static final int PAN_ZOOM_START = 7;
        public static final int PAN_ZOOM_UPDATE = 8;
        public static final int REMOVE = 2;
        public static final int UP = 6;
    }

    public @interface PointerDeviceKind {
        public static final int INVERTED_STYLUS = 3;
        public static final int MOUSE = 1;
        public static final int STYLUS = 2;
        public static final int TOUCH = 0;
        public static final int TRACKPAD = 4;
        public static final int UNKNOWN = 5;
    }

    public @interface PointerSignalKind {
        public static final int NONE = 0;
        public static final int SCALE = 3;
        public static final int SCROLL = 1;
        public static final int SCROLL_INERTIA_CANCEL = 2;
        public static final int UNKNOWN = 4;
    }

    public AndroidTouchProcessor(@NonNull FlutterRenderer flutterRenderer, boolean z) {
        this.renderer = flutterRenderer;
        this.motionEventTracker = MotionEventTracker.getInstance();
        this.trackMotionEvents = z;
    }

    private void addPointerForIndex(MotionEvent motionEvent, int i, int i2, int i3, Matrix matrix, ByteBuffer byteBuffer) {
        addPointerForIndex(motionEvent, i, i2, i3, matrix, byteBuffer, (Context) null);
    }

    private float getHorizontalScrollFactor(@NonNull Context context) {
        return ViewConfiguration.get(context).getScaledHorizontalScrollFactor();
    }

    @PointerChange
    private int getPointerChangeForAction(int i) {
        if (i == 0) {
            return 4;
        }
        if (i == 1) {
            return 6;
        }
        if (i == 5) {
            return 4;
        }
        if (i == 6) {
            return 6;
        }
        if (i == 2) {
            return 5;
        }
        if (i == 7) {
            return 3;
        }
        if (i == 3) {
            return 0;
        }
        return i == 8 ? 3 : -1;
    }

    @PointerChange
    private int getPointerChangeForPanZoom(int i) {
        if (i == 4) {
            return 7;
        }
        if (i == 5) {
            return 8;
        }
        return (i == 6 || i == 0) ? 9 : -1;
    }

    @PointerDeviceKind
    private int getPointerDeviceTypeForToolType(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 2;
        }
        if (i != 3) {
            return i != 4 ? 5 : 3;
        }
        return 1;
    }

    private float getVerticalScrollFactor(@NonNull Context context) {
        return getVerticalScrollFactorAbove26(context);
    }

    @TargetApi(26)
    private float getVerticalScrollFactorAbove26(@NonNull Context context) {
        return ViewConfiguration.get(context).getScaledVerticalScrollFactor();
    }

    private int getVerticalScrollFactorPre26(@NonNull Context context) {
        if (this.cachedVerticalScrollFactor == 0) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 48;
            }
            this.cachedVerticalScrollFactor = (int) typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.cachedVerticalScrollFactor;
    }

    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent, @NonNull Context context) {
        boolean isFromSource = motionEvent.isFromSource(2);
        boolean z = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (!isFromSource || !z) {
            return false;
        }
        int pointerChangeForAction = getPointerChangeForAction(motionEvent.getActionMasked());
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 288);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, IDENTITY_TRANSFORM, allocateDirect, context);
        if (allocateDirect.position() % 288 == 0) {
            this.renderer.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
            return true;
        }
        throw new AssertionError("Packet position is not on field boundary.");
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        return onTouchEvent(motionEvent, IDENTITY_TRANSFORM);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addPointerForIndex(android.view.MotionEvent r26, int r27, int r28, int r29, android.graphics.Matrix r30, java.nio.ByteBuffer r31, android.content.Context r32) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            r3 = r28
            r4 = r31
            r5 = r32
            r6 = 1
            r7 = 0
            r8 = 2
            r9 = -1
            if (r3 != r9) goto L_0x0013
            return
        L_0x0013:
            int r10 = r26.getPointerId(r27)
            int r11 = r26.getToolType(r27)
            int r11 = r0.getPointerDeviceTypeForToolType(r11)
            float r12 = r26.getX(r27)
            float r13 = r26.getY(r27)
            float[] r14 = new float[r8]
            r14[r7] = r12
            r14[r6] = r13
            r12 = r30
            r12.mapPoints(r14)
            r12 = 4
            r7 = 0
            if (r11 != r6) goto L_0x0058
            int r16 = r26.getButtonState()
            r13 = r16 & 31
            r17 = r10
            long r9 = (long) r13
            int r13 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r13 != 0) goto L_0x0067
            int r13 = r26.getSource()
            r15 = 8194(0x2002, float:1.1482E-41)
            if (r13 != r15) goto L_0x0067
            if (r3 != r12) goto L_0x0067
            java.util.Map<java.lang.Integer, float[]> r12 = r0.ongoingPans
            java.lang.Integer r13 = java.lang.Integer.valueOf(r17)
            r12.put(r13, r14)
            goto L_0x0067
        L_0x0058:
            r17 = r10
            r9 = 2
            if (r11 != r9) goto L_0x0066
            int r9 = r26.getButtonState()
            int r9 = r9 >> r12
            r9 = r9 & 15
            long r9 = (long) r9
            goto L_0x0067
        L_0x0066:
            r9 = r7
        L_0x0067:
            java.util.Map<java.lang.Integer, float[]> r12 = r0.ongoingPans
            java.lang.Integer r13 = java.lang.Integer.valueOf(r17)
            boolean r12 = r12.containsKey(r13)
            if (r12 == 0) goto L_0x007d
            int r13 = r0.getPointerChangeForPanZoom(r3)
            r15 = -1
            if (r13 != r15) goto L_0x007b
            return
        L_0x007b:
            r15 = r13
            goto L_0x007e
        L_0x007d:
            r15 = -1
        L_0x007e:
            boolean r13 = r0.trackMotionEvents
            if (r13 == 0) goto L_0x008f
            io.flutter.embedding.android.MotionEventTracker r13 = r0.motionEventTracker
            io.flutter.embedding.android.MotionEventTracker$MotionEventId r13 = r13.track(r1)
            long r18 = r13.getId()
            r6 = r18
            goto L_0x0090
        L_0x008f:
            r6 = r7
        L_0x0090:
            int r8 = r26.getActionMasked()
            r13 = 8
            if (r8 != r13) goto L_0x009a
            r8 = 1
            goto L_0x009b
        L_0x009a:
            r8 = 0
        L_0x009b:
            long r20 = r26.getEventTime()
            r22 = 1000(0x3e8, double:4.94E-321)
            r24 = r14
            long r13 = r20 * r22
            r4.putLong(r6)
            r4.putLong(r13)
            if (r12 == 0) goto L_0x00b7
            long r6 = (long) r15
            r4.putLong(r6)
            r6 = 4
            r4.putLong(r6)
            goto L_0x00bf
        L_0x00b7:
            long r6 = (long) r3
            r4.putLong(r6)
            long r6 = (long) r11
            r4.putLong(r6)
        L_0x00bf:
            long r6 = (long) r8
            r4.putLong(r6)
            r3 = r17
            long r6 = (long) r3
            r4.putLong(r6)
            r6 = 0
            r4.putLong(r6)
            if (r12 == 0) goto L_0x00ef
            java.util.Map<java.lang.Integer, float[]> r6 = r0.ongoingPans
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            java.lang.Object r6 = r6.get(r7)
            float[] r6 = (float[]) r6
            r7 = 0
            r13 = r6[r7]
            double r13 = (double) r13
            r4.putDouble(r13)
            r14 = 1
            r6 = r6[r14]
            r17 = r15
            double r14 = (double) r6
            r4.putDouble(r14)
            r7 = 8
            goto L_0x0101
        L_0x00ef:
            r17 = r15
            r7 = 0
            r6 = r24[r7]
            r7 = 8
            double r14 = (double) r6
            r4.putDouble(r14)
            r6 = 1
            r14 = r24[r6]
            double r14 = (double) r14
            r4.putDouble(r14)
        L_0x0101:
            r14 = 0
            r4.putDouble(r14)
            r4.putDouble(r14)
            r4.putLong(r9)
            r9 = 0
            r4.putLong(r9)
            r4.putLong(r9)
            float r6 = r26.getPressure(r27)
            double r9 = (double) r6
            r4.putDouble(r9)
            android.view.InputDevice r6 = r26.getDevice()
            if (r6 == 0) goto L_0x0140
            android.view.InputDevice r6 = r26.getDevice()
            r13 = 2
            android.view.InputDevice$MotionRange r6 = r6.getMotionRange(r13)
            r13 = r14
            r15 = r17
            if (r6 == 0) goto L_0x013d
            float r9 = r6.getMin()
            double r9 = (double) r9
            float r6 = r6.getMax()
            r17 = r8
            double r7 = (double) r6
            goto L_0x0147
        L_0x013d:
            r17 = r8
            goto L_0x0144
        L_0x0140:
            r13 = r14
            r15 = r17
            goto L_0x013d
        L_0x0144:
            r9 = r13
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        L_0x0147:
            r4.putDouble(r9)
            r4.putDouble(r7)
            r6 = 2
            if (r11 != r6) goto L_0x015e
            r7 = 24
            float r7 = r1.getAxisValue(r7, r2)
            double r7 = (double) r7
            r4.putDouble(r7)
            r4.putDouble(r13)
            goto L_0x0164
        L_0x015e:
            r4.putDouble(r13)
            r4.putDouble(r13)
        L_0x0164:
            float r7 = r26.getSize(r27)
            double r7 = (double) r7
            r4.putDouble(r7)
            float r7 = r26.getToolMajor(r27)
            double r7 = (double) r7
            r4.putDouble(r7)
            float r7 = r26.getToolMinor(r27)
            double r7 = (double) r7
            r4.putDouble(r7)
            r4.putDouble(r13)
            r4.putDouble(r13)
            r7 = 8
            float r7 = r1.getAxisValue(r7, r2)
            double r7 = (double) r7
            r4.putDouble(r7)
            r6 = 2
            if (r11 != r6) goto L_0x019c
            r6 = 25
            float r6 = r1.getAxisValue(r6, r2)
            double r6 = (double) r6
            r4.putDouble(r6)
        L_0x0199:
            r6 = r29
            goto L_0x01a0
        L_0x019c:
            r4.putDouble(r13)
            goto L_0x0199
        L_0x01a0:
            long r6 = (long) r6
            r4.putLong(r6)
            r6 = 9
            r7 = r17
            r8 = 1
            if (r7 != r8) goto L_0x01d2
            if (r5 == 0) goto L_0x01b8
            float r7 = r0.getHorizontalScrollFactor(r5)
            double r7 = (double) r7
            float r5 = r0.getVerticalScrollFactor(r5)
            double r9 = (double) r5
            goto L_0x01bb
        L_0x01b8:
            r7 = 4631952216750555136(0x4048000000000000, double:48.0)
            r9 = r7
        L_0x01bb:
            r5 = 10
            float r5 = r1.getAxisValue(r5, r2)
            float r5 = -r5
            double r13 = (double) r5
            double r7 = r7 * r13
            float r1 = r1.getAxisValue(r6, r2)
            float r1 = -r1
            double r1 = (double) r1
            double r9 = r9 * r1
            r4.putDouble(r7)
            r4.putDouble(r9)
            goto L_0x01d9
        L_0x01d2:
            r1 = r13
            r4.putDouble(r1)
            r4.putDouble(r1)
        L_0x01d9:
            if (r12 == 0) goto L_0x01fe
            java.util.Map<java.lang.Integer, float[]> r1 = r0.ongoingPans
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            java.lang.Object r1 = r1.get(r2)
            float[] r1 = (float[]) r1
            r2 = 0
            r5 = r24[r2]
            r2 = r1[r2]
            float r5 = r5 - r2
            double r7 = (double) r5
            r4.putDouble(r7)
            r2 = 1
            r5 = r24[r2]
            r1 = r1[r2]
            float r5 = r5 - r1
            double r1 = (double) r5
            r4.putDouble(r1)
            r1 = 0
            goto L_0x0206
        L_0x01fe:
            r1 = 0
            r4.putDouble(r1)
            r4.putDouble(r1)
        L_0x0206:
            r4.putDouble(r1)
            r4.putDouble(r1)
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r4.putDouble(r7)
            r4.putDouble(r1)
            r1 = 0
            r4.putLong(r1)
            if (r12 == 0) goto L_0x0226
            if (r15 != r6) goto L_0x0226
            java.util.Map<java.lang.Integer, float[]> r0 = r0.ongoingPans
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0.remove(r1)
        L_0x0226:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.AndroidTouchProcessor.addPointerForIndex(android.view.MotionEvent, int, int, int, android.graphics.Matrix, java.nio.ByteBuffer, android.content.Context):void");
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent, @NonNull Matrix matrix) {
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(pointerCount * 288);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        int actionMasked = motionEvent.getActionMasked();
        int pointerChangeForAction = getPointerChangeForAction(motionEvent.getActionMasked());
        boolean z = actionMasked == 0 || actionMasked == 5;
        boolean z2 = !z && (actionMasked == 1 || actionMasked == 6);
        if (z) {
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, matrix, allocateDirect);
        } else if (z2) {
            for (int i = 0; i < pointerCount; i++) {
                if (i != motionEvent.getActionIndex() && motionEvent.getToolType(i) == 1) {
                    addPointerForIndex(motionEvent, i, 5, 1, matrix, allocateDirect);
                }
            }
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, matrix, allocateDirect);
        } else {
            for (int i2 = 0; i2 < pointerCount; i2++) {
                addPointerForIndex(motionEvent, i2, pointerChangeForAction, 0, matrix, allocateDirect);
            }
        }
        if (allocateDirect.position() % 288 == 0) {
            this.renderer.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
            return true;
        }
        throw new AssertionError("Packet position is not on field boundary");
    }
}
