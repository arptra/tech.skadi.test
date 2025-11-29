package androidx.work.impl.model;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.List;
import kotlin.Metadata;

@Dao
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0018\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u0019\u0010\nJ\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eH'¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\"\u0010\u0018J\u0017\u0010#\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b#\u0010\u0018J\u001f\u0010%\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0014H'¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u0004\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b*\u0010+J#\u0010-\u001a\b\u0012\u0004\u0012\u00020)0\u000e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH'¢\u0006\u0004\b-\u0010.J)\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u000e0/2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH'¢\u0006\u0004\b0\u00101J\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020)0\u000e2\u0006\u00102\u001a\u00020\u0007H'¢\u0006\u0004\b3\u0010\u0011J\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020)0\u000e2\u0006\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\b4\u0010\u0011J\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000e2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b5\u0010\u0011J\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u00102\u001a\u00020\u0007H'¢\u0006\u0004\b6\u0010\u0011J\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\b7\u0010\u0011J\u0015\u00108\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH'¢\u0006\u0004\b8\u00109J\u000f\u0010;\u001a\u00020:H'¢\u0006\u0004\b;\u0010<J\u001f\u0010>\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u001eH'¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0014H'¢\u0006\u0004\b@\u0010AJ\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010B\u001a\u00020\u0014H'¢\u0006\u0004\bC\u0010DJ\u0015\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH'¢\u0006\u0004\bE\u00109J\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010F\u001a\u00020\u0014H'¢\u0006\u0004\bG\u0010DJ\u0015\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH'¢\u0006\u0004\bH\u00109J\u0015\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH'¢\u0006\u0004\bI\u00109J\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010J\u001a\u00020\u001eH'¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\u0004H'¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u0014H'¢\u0006\u0004\bO\u0010AJ\u001f\u0010Q\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0014H'¢\u0006\u0004\bQ\u0010&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006RÀ\u0006\u0001"}, d2 = {"Landroidx/work/impl/model/WorkSpecDao;", "", "Landroidx/work/impl/model/WorkSpec;", "workSpec", "", "d", "(Landroidx/work/impl/model/WorkSpec;)V", "", "id", "a", "(Ljava/lang/String;)V", "y", "(Ljava/lang/String;)Landroidx/work/impl/model/WorkSpec;", "name", "", "Landroidx/work/impl/model/WorkSpec$IdAndState;", "B", "(Ljava/lang/String;)Ljava/util/List;", "Landroidx/work/WorkInfo$State;", "state", "", "l", "(Landroidx/work/WorkInfo$State;Ljava/lang/String;)I", "g", "(Ljava/lang/String;)I", "u", "Landroidx/work/Data;", "output", "D", "(Ljava/lang/String;Landroidx/work/Data;)V", "", "enqueueTime", "m", "(Ljava/lang/String;J)V", "G", "q", "overrideGeneration", "t", "(Ljava/lang/String;I)V", "f", "(Ljava/lang/String;)Landroidx/work/WorkInfo$State;", "Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "x", "(Ljava/lang/String;)Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "ids", "H", "(Ljava/util/List;)Ljava/util/List;", "Landroidx/lifecycle/LiveData;", "r", "(Ljava/util/List;)Landroidx/lifecycle/LiveData;", "tag", "F", "j", "i", "h", "e", "n", "()Ljava/util/List;", "", "o", "()Z", "startTime", "A", "(Ljava/lang/String;J)I", "z", "()I", "schedulerLimit", "C", "(I)Ljava/util/List;", "p", "maxLimit", "k", "w", "E", "startingAt", "v", "(J)Ljava/util/List;", "b", "()V", "s", "stopReason", "c", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
@SuppressLint({"UnknownNullness"})
public interface WorkSpecDao {
    int A(String str, long j);

    List B(String str);

    List C(int i);

    void D(String str, Data data);

    List E();

    List F(String str);

    int G(String str);

    List H(List list);

    void a(String str);

    void b();

    void c(String str, int i);

    void d(WorkSpec workSpec);

    List e(String str);

    WorkInfo.State f(String str);

    int g(String str);

    List h(String str);

    List i(String str);

    List j(String str);

    List k(int i);

    int l(WorkInfo.State state, String str);

    void m(String str, long j);

    List n();

    boolean o();

    List p();

    int q(String str);

    LiveData r(List list);

    int s();

    void t(String str, int i);

    void u(String str);

    List v(long j);

    List w();

    WorkSpec.WorkInfoPojo x(String str);

    WorkSpec y(String str);

    int z();
}
