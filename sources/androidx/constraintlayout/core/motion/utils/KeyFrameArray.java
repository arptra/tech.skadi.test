package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;

public class KeyFrameArray {

    public static class CustomArray {

        /* renamed from: a  reason: collision with root package name */
        public int[] f504a;
        public CustomAttribute[] b;
        public int c;

        public int a(int i) {
            return this.f504a[i];
        }

        public int b() {
            return this.c;
        }

        public CustomAttribute c(int i) {
            return this.b[this.f504a[i]];
        }
    }

    public static class CustomVar {

        /* renamed from: a  reason: collision with root package name */
        public int[] f505a;
        public CustomVariable[] b;
        public int c;

        public int a(int i) {
            return this.f505a[i];
        }

        public int b() {
            return this.c;
        }

        public CustomVariable c(int i) {
            return this.b[this.f505a[i]];
        }
    }

    public static class FloatArray {
    }
}
