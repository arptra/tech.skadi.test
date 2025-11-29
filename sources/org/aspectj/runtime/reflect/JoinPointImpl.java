package org.aspectj.runtime.reflect;

import java.util.Stack;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;
import org.aspectj.runtime.internal.AroundClosure;

class JoinPointImpl implements ProceedingJoinPoint {
    Object _this;
    private AroundClosure arc = null;
    private InheritableThreadLocalAroundClosureStack arcs = null;
    Object[] args;
    JoinPoint.StaticPart staticPart;
    Object target;

    public static class EnclosingStaticPartImpl extends StaticPartImpl implements JoinPoint.EnclosingStaticPart {
        public EnclosingStaticPartImpl(int i, String str, Signature signature, SourceLocation sourceLocation) {
            super(i, str, signature, sourceLocation);
        }
    }

    public static class InheritableThreadLocalAroundClosureStack extends InheritableThreadLocal<Stack<AroundClosure>> {
        public Stack<AroundClosure> childValue(Stack<AroundClosure> stack) {
            return (Stack) stack.clone();
        }

        public Stack<AroundClosure> initialValue() {
            return new Stack<>();
        }
    }

    public JoinPointImpl(JoinPoint.StaticPart staticPart2, Object obj, Object obj2, Object[] objArr) {
        this.staticPart = staticPart2;
        this._this = obj;
        this.target = obj2;
        this.args = objArr;
    }

    public Object[] getArgs() {
        if (this.args == null) {
            this.args = new Object[0];
        }
        Object[] objArr = this.args;
        Object[] objArr2 = new Object[objArr.length];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        return objArr2;
    }

    public String getKind() {
        return this.staticPart.getKind();
    }

    public Signature getSignature() {
        return this.staticPart.getSignature();
    }

    public SourceLocation getSourceLocation() {
        return this.staticPart.getSourceLocation();
    }

    public JoinPoint.StaticPart getStaticPart() {
        return this.staticPart;
    }

    public Object getTarget() {
        return this.target;
    }

    public Object getThis() {
        return this._this;
    }

    public Object proceed() throws Throwable {
        InheritableThreadLocalAroundClosureStack inheritableThreadLocalAroundClosureStack = this.arcs;
        if (inheritableThreadLocalAroundClosureStack == null) {
            AroundClosure aroundClosure = this.arc;
            if (aroundClosure == null) {
                return null;
            }
            return aroundClosure.run(aroundClosure.getState());
        }
        AroundClosure aroundClosure2 = (AroundClosure) ((Stack) inheritableThreadLocalAroundClosureStack.get()).peek();
        return aroundClosure2.run(aroundClosure2.getState());
    }

    public void set$AroundClosure(AroundClosure aroundClosure) {
        this.arc = aroundClosure;
    }

    public void stack$AroundClosure(AroundClosure aroundClosure) {
        if (this.arcs == null) {
            this.arcs = new InheritableThreadLocalAroundClosureStack();
        }
        if (aroundClosure == null) {
            ((Stack) this.arcs.get()).pop();
        } else {
            ((Stack) this.arcs.get()).push(aroundClosure);
        }
    }

    public final String toLongString() {
        return this.staticPart.toLongString();
    }

    public final String toShortString() {
        return this.staticPart.toShortString();
    }

    public final String toString() {
        return this.staticPart.toString();
    }

    public static class StaticPartImpl implements JoinPoint.StaticPart {
        private int id;
        String kind;
        Signature signature;
        SourceLocation sourceLocation;

        public StaticPartImpl(int i, String str, Signature signature2, SourceLocation sourceLocation2) {
            this.kind = str;
            this.signature = signature2;
            this.sourceLocation = sourceLocation2;
            this.id = i;
        }

        public int getId() {
            return this.id;
        }

        public String getKind() {
            return this.kind;
        }

        public Signature getSignature() {
            return this.signature;
        }

        public SourceLocation getSourceLocation() {
            return this.sourceLocation;
        }

        public final String toLongString() {
            return toString(StringMaker.longStringMaker);
        }

        public final String toShortString() {
            return toString(StringMaker.shortStringMaker);
        }

        public String toString(StringMaker stringMaker) {
            return stringMaker.makeKindName(getKind()) + "(" + ((SignatureImpl) getSignature()).toString(stringMaker) + ")";
        }

        public final String toString() {
            return toString(StringMaker.middleStringMaker);
        }
    }

    public Object proceed(Object[] objArr) throws Throwable {
        AroundClosure aroundClosure;
        int i;
        InheritableThreadLocalAroundClosureStack inheritableThreadLocalAroundClosureStack = this.arcs;
        if (inheritableThreadLocalAroundClosureStack == null) {
            aroundClosure = this.arc;
        } else {
            aroundClosure = (AroundClosure) ((Stack) inheritableThreadLocalAroundClosureStack.get()).peek();
        }
        if (aroundClosure == null) {
            return null;
        }
        int flags = aroundClosure.getFlags();
        int i2 = 0;
        boolean z = (65536 & flags) != 0;
        int i3 = (flags & 4096) != 0 ? 1 : 0;
        int i4 = (flags & 256) != 0 ? 1 : 0;
        boolean z2 = (flags & 16) != 0;
        boolean z3 = (flags & 1) != 0;
        Object[] state = aroundClosure.getState();
        int i5 = ((!z2 || z) ? 0 : 1) + i3;
        if (i3 == 0 || i4 == 0) {
            i = 0;
        } else {
            state[0] = objArr[0];
            i = 1;
        }
        if (z2 && z3) {
            if (z) {
                i = i4 + 1;
                state[0] = objArr[i4];
            } else {
                char c = (i3 == 0 || i4 == 0) ? (char) 0 : 1;
                int i6 = (i3 == 0 || i4 == 0) ? 0 : 1;
                if (z2 && z3 && !z) {
                    i2 = 1;
                }
                state[i3] = objArr[c];
                i = i6 + i2;
            }
        }
        for (int i7 = i; i7 < objArr.length; i7++) {
            state[(i7 - i) + i5] = objArr[i7];
        }
        return aroundClosure.run(state);
    }
}
