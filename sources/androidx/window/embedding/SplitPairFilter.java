package androidx.window.embedding;

import android.content.ComponentName;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0019"}, d2 = {"Landroidx/window/embedding/SplitPairFilter;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/content/ComponentName;", "a", "Landroid/content/ComponentName;", "getPrimaryActivityName", "()Landroid/content/ComponentName;", "primaryActivityName", "b", "getSecondaryActivityName", "secondaryActivityName", "c", "Ljava/lang/String;", "getSecondaryActivityIntentAction", "secondaryActivityIntentAction", "window_release"}, k = 1, mv = {1, 6, 0})
@ExperimentalWindowApi
public final class SplitPairFilter {

    /* renamed from: a  reason: collision with root package name */
    public final ComponentName f2012a;
    public final ComponentName b;
    public final String c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairFilter)) {
            return false;
        }
        SplitPairFilter splitPairFilter = (SplitPairFilter) obj;
        return Intrinsics.areEqual((Object) this.f2012a, (Object) splitPairFilter.f2012a) && Intrinsics.areEqual((Object) this.b, (Object) splitPairFilter.b) && Intrinsics.areEqual((Object) this.c, (Object) splitPairFilter.c);
    }

    public int hashCode() {
        int hashCode = ((this.f2012a.hashCode() * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + this.f2012a + ", secondaryActivityName=" + this.b + ", secondaryActivityAction=" + this.c + '}';
    }
}
