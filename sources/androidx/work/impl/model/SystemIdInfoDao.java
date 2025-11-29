package androidx.work.impl.model;

import androidx.room.Dao;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Dao
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H'¢\u0006\u0004\b\u0018\u0010\u0019ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Landroidx/work/impl/model/SystemIdInfoDao;", "", "Landroidx/work/impl/model/SystemIdInfo;", "systemIdInfo", "", "d", "(Landroidx/work/impl/model/SystemIdInfo;)V", "", "workSpecId", "", "generation", "b", "(Ljava/lang/String;I)Landroidx/work/impl/model/SystemIdInfo;", "Landroidx/work/impl/model/WorkGenerationalId;", "id", "e", "(Landroidx/work/impl/model/WorkGenerationalId;)Landroidx/work/impl/model/SystemIdInfo;", "g", "(Ljava/lang/String;I)V", "i", "(Ljava/lang/String;)V", "c", "(Landroidx/work/impl/model/WorkGenerationalId;)V", "", "f", "()Ljava/util/List;", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
public interface SystemIdInfoDao {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static SystemIdInfo a(SystemIdInfoDao systemIdInfoDao, WorkGenerationalId workGenerationalId) {
            Intrinsics.checkNotNullParameter(workGenerationalId, "id");
            return SystemIdInfoDao.super.e(workGenerationalId);
        }

        public static void b(SystemIdInfoDao systemIdInfoDao, WorkGenerationalId workGenerationalId) {
            Intrinsics.checkNotNullParameter(workGenerationalId, "id");
            SystemIdInfoDao.super.c(workGenerationalId);
        }
    }

    SystemIdInfo b(String str, int i);

    void c(WorkGenerationalId workGenerationalId) {
        Intrinsics.checkNotNullParameter(workGenerationalId, "id");
        g(workGenerationalId.b(), workGenerationalId.a());
    }

    void d(SystemIdInfo systemIdInfo);

    SystemIdInfo e(WorkGenerationalId workGenerationalId) {
        Intrinsics.checkNotNullParameter(workGenerationalId, "id");
        return b(workGenerationalId.b(), workGenerationalId.a());
    }

    List f();

    void g(String str, int i);

    void i(String str);
}
