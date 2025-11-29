package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.Entity;
import androidx.work.Data;
import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\b\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/work/impl/model/WorkProgress;", "", "", "workSpecId", "Landroidx/work/Data;", "progress", "<init>", "(Ljava/lang/String;Landroidx/work/Data;)V", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Landroidx/work/Data;", "()Landroidx/work/Data;", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
@RestrictTo
@Entity
public final class WorkProgress {

    /* renamed from: a  reason: collision with root package name */
    public final String f2179a;
    public final Data b;

    public WorkProgress(String str, Data data) {
        Intrinsics.checkNotNullParameter(str, "workSpecId");
        Intrinsics.checkNotNullParameter(data, PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS);
        this.f2179a = str;
        this.b = data;
    }

    public final Data a() {
        return this.b;
    }

    public final String b() {
        return this.f2179a;
    }
}
