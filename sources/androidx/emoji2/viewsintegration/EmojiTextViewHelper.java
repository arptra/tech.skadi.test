package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;

public final class EmojiTextViewHelper {

    /* renamed from: a  reason: collision with root package name */
    public final HelperInternal f1242a;

    public static class HelperInternal {
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        public boolean b() {
            return false;
        }

        public void c(boolean z) {
        }

        public void d(boolean z) {
        }

        public TransformationMethod e(TransformationMethod transformationMethod) {
            return transformationMethod;
        }
    }

    @RequiresApi
    public static class HelperInternal19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f1243a;
        public final EmojiInputFilter b;
        public boolean c = true;

        public HelperInternal19(TextView textView) {
            this.f1243a = textView;
            this.b = new EmojiInputFilter(textView);
        }

        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.c ? h(inputFilterArr) : f(inputFilterArr);
        }

        public boolean b() {
            return this.c;
        }

        public void c(boolean z) {
            if (z) {
                l();
            }
        }

        public void d(boolean z) {
            this.c = z;
            l();
            k();
        }

        public TransformationMethod e(TransformationMethod transformationMethod) {
            return this.c ? m(transformationMethod) : j(transformationMethod);
        }

        public final InputFilter[] f(InputFilter[] inputFilterArr) {
            for (EmojiInputFilter emojiInputFilter : inputFilterArr) {
                if (emojiInputFilter == this.b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, r0);
            inputFilterArr2[r0] = this.b;
            return inputFilterArr2;
        }

        public final SparseArray g(InputFilter[] inputFilterArr) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < inputFilterArr.length; i++) {
                InputFilter inputFilter = inputFilterArr[i];
                if (inputFilter instanceof EmojiInputFilter) {
                    sparseArray.put(i, inputFilter);
                }
            }
            return sparseArray;
        }

        public final InputFilter[] h(InputFilter[] inputFilterArr) {
            SparseArray g = g(inputFilterArr);
            if (g.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length - g.size())];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (g.indexOfKey(i2) < 0) {
                    inputFilterArr2[i] = inputFilterArr[i2];
                    i++;
                }
            }
            return inputFilterArr2;
        }

        public void i(boolean z) {
            this.c = z;
        }

        public final TransformationMethod j(TransformationMethod transformationMethod) {
            return transformationMethod instanceof EmojiTransformationMethod ? ((EmojiTransformationMethod) transformationMethod).a() : transformationMethod;
        }

        public final void k() {
            this.f1243a.setFilters(a(this.f1243a.getFilters()));
        }

        public void l() {
            this.f1243a.setTransformationMethod(e(this.f1243a.getTransformationMethod()));
        }

        public final TransformationMethod m(TransformationMethod transformationMethod) {
            return (!(transformationMethod instanceof EmojiTransformationMethod) && !(transformationMethod instanceof PasswordTransformationMethod)) ? new EmojiTransformationMethod(transformationMethod) : transformationMethod;
        }
    }

    @RequiresApi
    public static class SkippingHelper19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        public final HelperInternal19 f1244a;

        public SkippingHelper19(TextView textView) {
            this.f1244a = new HelperInternal19(textView);
        }

        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return f() ? inputFilterArr : this.f1244a.a(inputFilterArr);
        }

        public boolean b() {
            return this.f1244a.b();
        }

        public void c(boolean z) {
            if (!f()) {
                this.f1244a.c(z);
            }
        }

        public void d(boolean z) {
            if (f()) {
                this.f1244a.i(z);
            } else {
                this.f1244a.d(z);
            }
        }

        public TransformationMethod e(TransformationMethod transformationMethod) {
            return f() ? transformationMethod : this.f1244a.e(transformationMethod);
        }

        public final boolean f() {
            return !EmojiCompat.h();
        }
    }

    public EmojiTextViewHelper(TextView textView, boolean z) {
        Preconditions.i(textView, "textView cannot be null");
        if (!z) {
            this.f1242a = new SkippingHelper19(textView);
        } else {
            this.f1242a = new HelperInternal19(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f1242a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f1242a.b();
    }

    public void c(boolean z) {
        this.f1242a.c(z);
    }

    public void d(boolean z) {
        this.f1242a.d(z);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f1242a.e(transformationMethod);
    }
}
