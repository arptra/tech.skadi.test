package org.aspectj.internal.lang.reflect;

import org.aspectj.lang.reflect.PerClauseKind;
import org.aspectj.lang.reflect.PointcutBasedPerClause;
import org.aspectj.lang.reflect.PointcutExpression;

public class PointcutBasedPerClauseImpl extends PerClauseImpl implements PointcutBasedPerClause {
    private final PointcutExpression pointcutExpression;

    /* renamed from: org.aspectj.internal.lang.reflect.PointcutBasedPerClauseImpl$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$aspectj$lang$reflect$PerClauseKind;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.aspectj.lang.reflect.PerClauseKind[] r0 = org.aspectj.lang.reflect.PerClauseKind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$aspectj$lang$reflect$PerClauseKind = r0
                org.aspectj.lang.reflect.PerClauseKind r1 = org.aspectj.lang.reflect.PerClauseKind.PERCFLOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$aspectj$lang$reflect$PerClauseKind     // Catch:{ NoSuchFieldError -> 0x001d }
                org.aspectj.lang.reflect.PerClauseKind r1 = org.aspectj.lang.reflect.PerClauseKind.PERCFLOWBELOW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$aspectj$lang$reflect$PerClauseKind     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.aspectj.lang.reflect.PerClauseKind r1 = org.aspectj.lang.reflect.PerClauseKind.PERTARGET     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$aspectj$lang$reflect$PerClauseKind     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.aspectj.lang.reflect.PerClauseKind r1 = org.aspectj.lang.reflect.PerClauseKind.PERTHIS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.aspectj.internal.lang.reflect.PointcutBasedPerClauseImpl.AnonymousClass1.<clinit>():void");
        }
    }

    public PointcutBasedPerClauseImpl(PerClauseKind perClauseKind, String str) {
        super(perClauseKind);
        this.pointcutExpression = new PointcutExpressionImpl(str);
    }

    public PointcutExpression getPointcutExpression() {
        return this.pointcutExpression;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = AnonymousClass1.$SwitchMap$org$aspectj$lang$reflect$PerClauseKind[getKind().ordinal()];
        if (i == 1) {
            sb.append("percflow(");
        } else if (i == 2) {
            sb.append("percflowbelow(");
        } else if (i == 3) {
            sb.append("pertarget(");
        } else if (i == 4) {
            sb.append("perthis(");
        }
        sb.append(this.pointcutExpression.asString());
        sb.append(")");
        return sb.toString();
    }
}
