package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

public class HorizontalWidgetRun extends WidgetRun {
    public static int[] k = new int[2];

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f540a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType[] r0 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f540a = r0
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f540a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f540a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.AnonymousClass1.<clinit>():void");
        }
    }

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.h.e = DependencyNode.Type.LEFT;
        this.i.e = DependencyNode.Type.RIGHT;
        this.f = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02ba, code lost:
        if (r14 != 1) goto L_0x031f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.constraintlayout.core.widgets.analyzer.Dependency r17) {
        /*
            r16 = this;
            r8 = r16
            int[] r0 = androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.AnonymousClass1.f540a
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = r8.j
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 3
            r9 = 1
            r10 = 0
            if (r0 == r9) goto L_0x0029
            if (r0 == r1) goto L_0x0023
            if (r0 == r2) goto L_0x0017
            goto L_0x002e
        L_0x0017:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.S
            r3 = r17
            r8.n(r3, r1, r0, r10)
            return
        L_0x0023:
            r3 = r17
            r16.o(r17)
            goto L_0x002e
        L_0x0029:
            r3 = r17
            r16.p(r17)
        L_0x002e:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.e
            boolean r0 = r0.j
            r11 = 1056964608(0x3f000000, float:0.5)
            if (r0 != 0) goto L_0x031f
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r3) goto L_0x031f
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.b
            int r3 = r0.w
            if (r3 == r1) goto L_0x0302
            if (r3 == r2) goto L_0x0046
            goto L_0x031f
        L_0x0046:
            int r1 = r0.x
            r3 = -1
            if (r1 == 0) goto L_0x008f
            if (r1 != r2) goto L_0x004e
            goto L_0x008f
        L_0x004e:
            int r0 = r0.y()
            if (r0 == r3) goto L_0x007a
            if (r0 == 0) goto L_0x006b
            if (r0 == r9) goto L_0x005a
            r0 = r10
            goto L_0x0088
        L_0x005a:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r0.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.e
            int r1 = r1.g
            float r1 = (float) r1
            float r0 = r0.x()
        L_0x0067:
            float r1 = r1 * r0
        L_0x0068:
            float r1 = r1 + r11
            int r0 = (int) r1
            goto L_0x0088
        L_0x006b:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r0.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.e
            int r1 = r1.g
            float r1 = (float) r1
            float r0 = r0.x()
            float r1 = r1 / r0
            goto L_0x0068
        L_0x007a:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r0.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.e
            int r1 = r1.g
            float r1 = (float) r1
            float r0 = r0.x()
            goto L_0x0067
        L_0x0088:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r8.e
            r1.d(r0)
            goto L_0x031f
        L_0x008f:
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r0.f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r12 = r1.h
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r13 = r1.i
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f
            if (r1 == 0) goto L_0x009d
            r1 = r9
            goto L_0x009e
        L_0x009d:
            r1 = r10
        L_0x009e:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f
            if (r2 == 0) goto L_0x00a6
            r2 = r9
            goto L_0x00a7
        L_0x00a6:
            r2 = r10
        L_0x00a7:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f
            if (r4 == 0) goto L_0x00af
            r4 = r9
            goto L_0x00b0
        L_0x00af:
            r4 = r10
        L_0x00b0:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f
            if (r5 == 0) goto L_0x00b8
            r5 = r9
            goto L_0x00b9
        L_0x00b8:
            r5 = r10
        L_0x00b9:
            int r14 = r0.y()
            if (r1 == 0) goto L_0x0200
            if (r2 == 0) goto L_0x0200
            if (r4 == 0) goto L_0x0200
            if (r5 == 0) goto L_0x0200
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.b
            float r15 = r0.x()
            boolean r0 = r12.j
            if (r0 == 0) goto L_0x012e
            boolean r0 = r13.j
            if (r0 == 0) goto L_0x012e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.h
            boolean r1 = r0.c
            if (r1 == 0) goto L_0x012d
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.i
            boolean r1 = r1.c
            if (r1 != 0) goto L_0x00e0
            goto L_0x012d
        L_0x00e0:
            java.util.List r0 = r0.l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.h
            int r1 = r1.f
            int r2 = r0 + r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.i
            java.util.List r0 = r0.l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.i
            int r1 = r1.f
            int r3 = r0 - r1
            int r0 = r12.g
            int r1 = r12.f
            int r4 = r0 + r1
            int r0 = r13.g
            int r1 = r13.f
            int r5 = r0 - r1
            int[] r1 = k
            r0 = r16
            r6 = r15
            r7 = r14
            r0.q(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.e
            int[] r1 = k
            r1 = r1[r10]
            r0.d(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.e
            int[] r1 = k
            r1 = r1[r9]
            r0.d(r1)
        L_0x012d:
            return
        L_0x012e:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.h
            boolean r1 = r0.j
            if (r1 == 0) goto L_0x018b
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.i
            boolean r2 = r1.j
            if (r2 == 0) goto L_0x018b
            boolean r2 = r12.c
            if (r2 == 0) goto L_0x018a
            boolean r2 = r13.c
            if (r2 != 0) goto L_0x0143
            goto L_0x018a
        L_0x0143:
            int r2 = r0.g
            int r0 = r0.f
            int r2 = r2 + r0
            int r0 = r1.g
            int r1 = r1.f
            int r3 = r0 - r1
            java.util.List r0 = r12.l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.g
            int r1 = r12.f
            int r4 = r0 + r1
            java.util.List r0 = r13.l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.g
            int r1 = r13.f
            int r5 = r0 - r1
            int[] r1 = k
            r0 = r16
            r6 = r15
            r7 = r14
            r0.q(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.e
            int[] r1 = k
            r1 = r1[r10]
            r0.d(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.e
            int[] r1 = k
            r1 = r1[r9]
            r0.d(r1)
            goto L_0x018b
        L_0x018a:
            return
        L_0x018b:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.h
            boolean r1 = r0.c
            if (r1 == 0) goto L_0x01ff
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.i
            boolean r1 = r1.c
            if (r1 == 0) goto L_0x01ff
            boolean r1 = r12.c
            if (r1 == 0) goto L_0x01ff
            boolean r1 = r13.c
            if (r1 != 0) goto L_0x01a0
            goto L_0x01ff
        L_0x01a0:
            java.util.List r0 = r0.l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.h
            int r1 = r1.f
            int r2 = r0 + r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.i
            java.util.List r0 = r0.l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.i
            int r1 = r1.f
            int r3 = r0 - r1
            java.util.List r0 = r12.l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.g
            int r1 = r12.f
            int r4 = r0 + r1
            java.util.List r0 = r13.l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.g
            int r1 = r13.f
            int r5 = r0 - r1
            int[] r1 = k
            r0 = r16
            r6 = r15
            r7 = r14
            r0.q(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.e
            int[] r1 = k
            r1 = r1[r10]
            r0.d(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.e
            int[] r1 = k
            r1 = r1[r9]
            r0.d(r1)
            goto L_0x031f
        L_0x01ff:
            return
        L_0x0200:
            if (r1 == 0) goto L_0x0289
            if (r4 == 0) goto L_0x0289
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.h
            boolean r0 = r0.c
            if (r0 == 0) goto L_0x0288
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.i
            boolean r0 = r0.c
            if (r0 != 0) goto L_0x0212
            goto L_0x0288
        L_0x0212:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.b
            float r0 = r0.x()
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.h
            java.util.List r1 = r1.l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.h
            int r2 = r2.f
            int r1 = r1 + r2
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.i
            java.util.List r2 = r2.l
            java.lang.Object r2 = r2.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r8.i
            int r4 = r4.f
            int r2 = r2 - r4
            if (r14 == r3) goto L_0x0265
            if (r14 == 0) goto L_0x0265
            if (r14 == r9) goto L_0x0242
            goto L_0x031f
        L_0x0242:
            int r2 = r2 - r1
            int r1 = r8.g(r2, r10)
            float r2 = (float) r1
            float r2 = r2 / r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.g(r2, r9)
            if (r2 == r3) goto L_0x0255
            float r1 = (float) r3
            float r1 = r1 * r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x0255:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.e
            r0.d(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.e
            r0.d(r3)
            goto L_0x031f
        L_0x0265:
            int r2 = r2 - r1
            int r1 = r8.g(r2, r10)
            float r2 = (float) r1
            float r2 = r2 * r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.g(r2, r9)
            if (r2 == r3) goto L_0x0278
            float r1 = (float) r3
            float r1 = r1 / r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x0278:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.e
            r0.d(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.e
            r0.d(r3)
            goto L_0x031f
        L_0x0288:
            return
        L_0x0289:
            if (r2 == 0) goto L_0x031f
            if (r5 == 0) goto L_0x031f
            boolean r0 = r12.c
            if (r0 == 0) goto L_0x0301
            boolean r0 = r13.c
            if (r0 != 0) goto L_0x0296
            goto L_0x0301
        L_0x0296:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.b
            float r0 = r0.x()
            java.util.List r1 = r12.l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.g
            int r2 = r12.f
            int r1 = r1 + r2
            java.util.List r2 = r13.l
            java.lang.Object r2 = r2.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.g
            int r4 = r13.f
            int r2 = r2 - r4
            if (r14 == r3) goto L_0x02df
            if (r14 == 0) goto L_0x02bd
            if (r14 == r9) goto L_0x02df
            goto L_0x031f
        L_0x02bd:
            int r2 = r2 - r1
            int r1 = r8.g(r2, r9)
            float r2 = (float) r1
            float r2 = r2 * r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.g(r2, r10)
            if (r2 == r3) goto L_0x02d0
            float r1 = (float) r3
            float r1 = r1 / r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x02d0:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.e
            r0.d(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.e
            r0.d(r1)
            goto L_0x031f
        L_0x02df:
            int r2 = r2 - r1
            int r1 = r8.g(r2, r9)
            float r2 = (float) r1
            float r2 = r2 / r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.g(r2, r10)
            if (r2 == r3) goto L_0x02f2
            float r1 = (float) r3
            float r1 = r1 * r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x02f2:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.e
            r0.d(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.e
            r0.d(r1)
            goto L_0x031f
        L_0x0301:
            return
        L_0x0302:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.M()
            if (r0 == 0) goto L_0x031f
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r0.e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.e
            boolean r1 = r0.j
            if (r1 == 0) goto L_0x031f
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r8.b
            float r1 = r1.B
            int r0 = r0.g
            float r0 = (float) r0
            float r0 = r0 * r1
            float r0 = r0 + r11
            int r0 = (int) r0
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r8.e
            r1.d(r0)
        L_0x031f:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.h
            boolean r1 = r0.c
            if (r1 == 0) goto L_0x043f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.i
            boolean r2 = r1.c
            if (r2 != 0) goto L_0x032d
            goto L_0x043f
        L_0x032d:
            boolean r0 = r0.j
            if (r0 == 0) goto L_0x033c
            boolean r0 = r1.j
            if (r0 == 0) goto L_0x033c
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.e
            boolean r0 = r0.j
            if (r0 == 0) goto L_0x033c
            return
        L_0x033c:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.e
            boolean r0 = r0.j
            if (r0 != 0) goto L_0x0386
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x0386
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.b
            int r1 = r0.w
            if (r1 != 0) goto L_0x0386
            boolean r0 = r0.k0()
            if (r0 != 0) goto L_0x0386
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.h
            java.util.List r0 = r0.l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.i
            java.util.List r1 = r1.l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r0 = r0.g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.h
            int r3 = r2.f
            int r0 = r0 + r3
            int r1 = r1.g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r8.i
            int r3 = r3.f
            int r1 = r1 + r3
            int r3 = r1 - r0
            r2.d(r0)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.i
            r0.d(r1)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.e
            r0.d(r3)
            return
        L_0x0386:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.e
            boolean r0 = r0.j
            if (r0 != 0) goto L_0x03ea
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x03ea
            int r0 = r8.f545a
            if (r0 != r9) goto L_0x03ea
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.h
            java.util.List r0 = r0.l
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03ea
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.i
            java.util.List r0 = r0.l
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03ea
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.h
            java.util.List r0 = r0.l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.i
            java.util.List r1 = r1.l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r0 = r0.g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.h
            int r2 = r2.f
            int r0 = r0 + r2
            int r1 = r1.g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.i
            int r2 = r2.f
            int r1 = r1 + r2
            int r1 = r1 - r0
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.e
            int r0 = r0.m
            int r0 = java.lang.Math.min(r1, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r8.b
            int r2 = r1.A
            int r1 = r1.z
            int r0 = java.lang.Math.max(r1, r0)
            if (r2 <= 0) goto L_0x03e5
            int r0 = java.lang.Math.min(r2, r0)
        L_0x03e5:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r8.e
            r1.d(r0)
        L_0x03ea:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.e
            boolean r0 = r0.j
            if (r0 != 0) goto L_0x03f1
            return
        L_0x03f1:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.h
            java.util.List r0 = r0.l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.i
            java.util.List r1 = r1.l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r2 = r0.g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r8.h
            int r3 = r3.f
            int r2 = r2 + r3
            int r3 = r1.g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r8.i
            int r4 = r4.f
            int r3 = r3 + r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r8.b
            float r4 = r4.A()
            if (r0 != r1) goto L_0x0420
            int r2 = r0.g
            int r3 = r1.g
            r4 = r11
        L_0x0420:
            int r3 = r3 - r2
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.e
            int r0 = r0.g
            int r3 = r3 - r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.h
            float r1 = (float) r2
            float r1 = r1 + r11
            float r2 = (float) r3
            float r2 = r2 * r4
            float r1 = r1 + r2
            int r1 = (int) r1
            r0.d(r1)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.i
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.h
            int r1 = r1.g
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r8.e
            int r2 = r2.g
            int r1 = r1 + r2
            r0.d(r1)
        L_0x043f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.a(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }

    public void d() {
        ConstraintWidget M;
        ConstraintWidget M2;
        ConstraintWidget constraintWidget = this.b;
        if (constraintWidget.f530a) {
            this.e.d(constraintWidget.Y());
        }
        if (!this.e.j) {
            ConstraintWidget.DimensionBehaviour C = this.b.C();
            this.d = C;
            if (C != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (C == dimensionBehaviour && (M2 = this.b.M()) != null && (M2.C() == ConstraintWidget.DimensionBehaviour.FIXED || M2.C() == dimensionBehaviour)) {
                    int Y = (M2.Y() - this.b.Q.f()) - this.b.S.f();
                    b(this.h, M2.e.h, this.b.Q.f());
                    b(this.i, M2.e.i, -this.b.S.f());
                    this.e.d(Y);
                    return;
                } else if (this.d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.e.d(this.b.Y());
                }
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour2 == dimensionBehaviour3 && (M = this.b.M()) != null && (M.C() == ConstraintWidget.DimensionBehaviour.FIXED || M.C() == dimensionBehaviour3)) {
                b(this.h, M.e.h, this.b.Q.f());
                b(this.i, M.e.i, -this.b.S.f());
                return;
            }
        }
        DimensionDependency dimensionDependency = this.e;
        if (dimensionDependency.j) {
            ConstraintWidget constraintWidget2 = this.b;
            if (constraintWidget2.f530a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.Y;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f;
                if (constraintAnchor2 == null || constraintAnchorArr[1].f == null) {
                    if (constraintAnchor2 != null) {
                        DependencyNode h = h(constraintAnchor);
                        if (h != null) {
                            b(this.h, h, this.b.Y[0].f());
                            b(this.i, this.h, this.e.g);
                            return;
                        }
                        return;
                    }
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                    if (constraintAnchor3.f != null) {
                        DependencyNode h2 = h(constraintAnchor3);
                        if (h2 != null) {
                            b(this.i, h2, -this.b.Y[1].f());
                            b(this.h, this.i, -this.e.g);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget2 instanceof Helper) && constraintWidget2.M() != null && this.b.q(ConstraintAnchor.Type.CENTER).f == null) {
                        b(this.h, this.b.M().e.h, this.b.Z());
                        b(this.i, this.h, this.e.g);
                        return;
                    } else {
                        return;
                    }
                } else if (constraintWidget2.k0()) {
                    this.h.f = this.b.Y[0].f();
                    this.i.f = -this.b.Y[1].f();
                    return;
                } else {
                    DependencyNode h3 = h(this.b.Y[0]);
                    if (h3 != null) {
                        b(this.h, h3, this.b.Y[0].f());
                    }
                    DependencyNode h4 = h(this.b.Y[1]);
                    if (h4 != null) {
                        b(this.i, h4, -this.b.Y[1].f());
                    }
                    this.h.b = true;
                    this.i.b = true;
                    return;
                }
            }
        }
        if (this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.b;
            int i = constraintWidget3.w;
            if (i == 2) {
                ConstraintWidget M3 = constraintWidget3.M();
                if (M3 != null) {
                    DimensionDependency dimensionDependency2 = M3.f.e;
                    this.e.l.add(dimensionDependency2);
                    dimensionDependency2.k.add(this.e);
                    DimensionDependency dimensionDependency3 = this.e;
                    dimensionDependency3.b = true;
                    dimensionDependency3.k.add(this.h);
                    this.e.k.add(this.i);
                }
            } else if (i == 3) {
                if (constraintWidget3.x == 3) {
                    this.h.f538a = this;
                    this.i.f538a = this;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget3.f;
                    verticalWidgetRun.h.f538a = this;
                    verticalWidgetRun.i.f538a = this;
                    dimensionDependency.f538a = this;
                    if (constraintWidget3.m0()) {
                        this.e.l.add(this.b.f.e);
                        this.b.f.e.k.add(this.e);
                        VerticalWidgetRun verticalWidgetRun2 = this.b.f;
                        verticalWidgetRun2.e.f538a = this;
                        this.e.l.add(verticalWidgetRun2.h);
                        this.e.l.add(this.b.f.i);
                        this.b.f.h.k.add(this.e);
                        this.b.f.i.k.add(this.e);
                    } else if (this.b.k0()) {
                        this.b.f.e.l.add(this.e);
                        this.e.k.add(this.b.f.e);
                    } else {
                        this.b.f.e.l.add(this.e);
                    }
                } else {
                    DimensionDependency dimensionDependency4 = constraintWidget3.f.e;
                    dimensionDependency.l.add(dimensionDependency4);
                    dimensionDependency4.k.add(this.e);
                    this.b.f.h.k.add(this.e);
                    this.b.f.i.k.add(this.e);
                    DimensionDependency dimensionDependency5 = this.e;
                    dimensionDependency5.b = true;
                    dimensionDependency5.k.add(this.h);
                    this.e.k.add(this.i);
                    this.h.l.add(this.e);
                    this.i.l.add(this.e);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.Y;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.f;
        if (constraintAnchor5 == null || constraintAnchorArr2[1].f == null) {
            if (constraintAnchor5 != null) {
                DependencyNode h5 = h(constraintAnchor4);
                if (h5 != null) {
                    b(this.h, h5, this.b.Y[0].f());
                    c(this.i, this.h, 1, this.e);
                    return;
                }
                return;
            }
            ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
            if (constraintAnchor6.f != null) {
                DependencyNode h6 = h(constraintAnchor6);
                if (h6 != null) {
                    b(this.i, h6, -this.b.Y[1].f());
                    c(this.h, this.i, -1, this.e);
                }
            } else if (!(constraintWidget4 instanceof Helper) && constraintWidget4.M() != null) {
                b(this.h, this.b.M().e.h, this.b.Z());
                c(this.i, this.h, 1, this.e);
            }
        } else if (constraintWidget4.k0()) {
            this.h.f = this.b.Y[0].f();
            this.i.f = -this.b.Y[1].f();
        } else {
            DependencyNode h7 = h(this.b.Y[0]);
            DependencyNode h8 = h(this.b.Y[1]);
            if (h7 != null) {
                h7.b(this);
            }
            if (h8 != null) {
                h8.b(this);
            }
            this.j = WidgetRun.RunType.CENTER;
        }
    }

    public void e() {
        DependencyNode dependencyNode = this.h;
        if (dependencyNode.j) {
            this.b.q1(dependencyNode.g);
        }
    }

    public void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.e.c();
        this.g = false;
    }

    public boolean m() {
        return this.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.b.w == 0;
    }

    public final void q(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 == -1) {
            int i8 = (int) ((((float) i7) * f) + 0.5f);
            int i9 = (int) ((((float) i6) / f) + 0.5f);
            if (i8 <= i6) {
                iArr[0] = i8;
                iArr[1] = i7;
            } else if (i9 <= i7) {
                iArr[0] = i6;
                iArr[1] = i9;
            }
        } else if (i5 == 0) {
            iArr[0] = (int) ((((float) i7) * f) + 0.5f);
            iArr[1] = i7;
        } else if (i5 == 1) {
            iArr[0] = i6;
            iArr[1] = (int) ((((float) i6) * f) + 0.5f);
        }
    }

    public void r() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        this.e.j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.b.v();
    }
}
