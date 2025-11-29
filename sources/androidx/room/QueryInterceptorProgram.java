package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import com.honey.account.constant.AccountConstantKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J!\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001b8\u0000X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e¨\u0006 "}, d2 = {"Landroidx/room/QueryInterceptorProgram;", "Landroidx/sqlite/db/SupportSQLiteProgram;", "<init>", "()V", "", "index", "", "L", "(I)V", "", "value", "F", "(IJ)V", "", "R", "(ID)V", "", "B", "(ILjava/lang/String;)V", "", "H", "(I[B)V", "close", "bindIndex", "", "b", "(ILjava/lang/Object;)V", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "bindArgsCache", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class QueryInterceptorProgram implements SupportSQLiteProgram {

    /* renamed from: a  reason: collision with root package name */
    public final List f1748a = new ArrayList();

    public void B(int i, String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        b(i, str);
    }

    public void F(int i, long j) {
        b(i, Long.valueOf(j));
    }

    public void H(int i, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, AccountConstantKt.RESPONSE_VALUE);
        b(i, bArr);
    }

    public void L(int i) {
        b(i, (Object) null);
    }

    public void R(int i, double d) {
        b(i, Double.valueOf(d));
    }

    public final List a() {
        return this.f1748a;
    }

    public final void b(int i, Object obj) {
        int size;
        int i2 = i - 1;
        if (i2 >= this.f1748a.size() && (size = this.f1748a.size()) <= i2) {
            while (true) {
                this.f1748a.add((Object) null);
                if (size == i2) {
                    break;
                }
                size++;
            }
        }
        this.f1748a.set(i2, obj);
    }

    public void close() {
    }
}
