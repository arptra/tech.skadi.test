package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import com.honey.account.constant.AccountConstantKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\tH\u0001¢\u0006\u0004\b\n\u0010\u000bJ \u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\fH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"androidx/room/RoomSQLiteQuery$Companion$copyFrom$1", "Landroidx/sqlite/db/SupportSQLiteProgram;", "", "index", "", "value", "", "H", "(I[B)V", "", "R", "(ID)V", "", "F", "(IJ)V", "L", "(I)V", "", "B", "(ILjava/lang/String;)V", "close", "()V", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class RoomSQLiteQuery$Companion$copyFrom$1 implements SupportSQLiteProgram {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RoomSQLiteQuery f1757a;

    public void B(int i, String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        this.f1757a.B(i, str);
    }

    public void F(int i, long j) {
        this.f1757a.F(i, j);
    }

    public void H(int i, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, AccountConstantKt.RESPONSE_VALUE);
        this.f1757a.H(i, bArr);
    }

    public void L(int i) {
        this.f1757a.L(i);
    }

    public void R(int i, double d) {
        this.f1757a.R(i, d);
    }

    public void close() {
        this.f1757a.close();
    }
}
