package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.TypeEvaluator;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.PathParser;

@RestrictTo
public class AnimatorInflaterCompat {

    public static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {

        /* renamed from: a  reason: collision with root package name */
        public PathParser.PathDataNode[] f1897a;

        /* renamed from: a */
        public PathParser.PathDataNode[] evaluate(float f, PathParser.PathDataNode[] pathDataNodeArr, PathParser.PathDataNode[] pathDataNodeArr2) {
            if (PathParser.b(pathDataNodeArr, pathDataNodeArr2)) {
                if (!PathParser.b(this.f1897a, pathDataNodeArr)) {
                    this.f1897a = PathParser.f(pathDataNodeArr);
                }
                for (int i = 0; i < pathDataNodeArr.length; i++) {
                    this.f1897a[i].h(pathDataNodeArr[i], pathDataNodeArr2[i], f);
                }
                return this.f1897a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    public static Animator a(Context context, int i) {
        return AnimatorInflater.loadAnimator(context, i);
    }
}
