package androidx.window.embedding;

import android.app.Activity;
import androidx.window.core.ExperimentalWindowApi;
import io.netty.util.internal.StringUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/window/embedding/SplitInfo;", "", "Landroidx/window/embedding/ActivityStack;", "primaryActivityStack", "secondaryActivityStack", "", "splitRatio", "<init>", "(Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/ActivityStack;F)V", "Landroid/app/Activity;", "activity", "", "a", "(Landroid/app/Activity;)Z", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroidx/window/embedding/ActivityStack;", "b", "()Landroidx/window/embedding/ActivityStack;", "c", "F", "d", "()F", "window_release"}, k = 1, mv = {1, 6, 0})
@ExperimentalWindowApi
public final class SplitInfo {

    /* renamed from: a  reason: collision with root package name */
    public final ActivityStack f2011a;
    public final ActivityStack b;
    public final float c;

    public SplitInfo(ActivityStack activityStack, ActivityStack activityStack2, float f) {
        Intrinsics.checkNotNullParameter(activityStack, "primaryActivityStack");
        Intrinsics.checkNotNullParameter(activityStack2, "secondaryActivityStack");
        this.f2011a = activityStack;
        this.b = activityStack2;
        this.c = f;
    }

    public final boolean a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return this.f2011a.a(activity) || this.b.a(activity);
    }

    public final ActivityStack b() {
        return this.f2011a;
    }

    public final ActivityStack c() {
        return this.b;
    }

    public final float d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitInfo)) {
            return false;
        }
        SplitInfo splitInfo = (SplitInfo) obj;
        return Intrinsics.areEqual((Object) this.f2011a, (Object) splitInfo.f2011a) && Intrinsics.areEqual((Object) this.b, (Object) splitInfo.b) && this.c == splitInfo.c;
    }

    public int hashCode() {
        return (((this.f2011a.hashCode() * 31) + this.b.hashCode()) * 31) + Float.hashCode(this.c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SplitInfo:{");
        sb.append("primaryActivityStack=" + b() + StringUtil.COMMA);
        sb.append("secondaryActivityStack=" + c() + StringUtil.COMMA);
        sb.append("splitRatio=" + d() + '}');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
