package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.google.android.gms.actions.SearchIntents;
import com.honey.account.constant.AccountConstantKt;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\f\b\u0007\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0002EFB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0006J\u001f\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\nH\u0016¢\u0006\u0004\b \u0010\u000eJ\u0015\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0000¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010(R\u001a\u0010-\u001a\u00020)8\u0006X\u0004¢\u0006\f\n\u0004\b*\u0010+\u0012\u0004\b,\u0010\u000eR\u001a\u00101\u001a\u00020.8\u0006X\u0004¢\u0006\f\n\u0004\b\"\u0010/\u0012\u0004\b0\u0010\u000eR\"\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007028\u0006X\u0004¢\u0006\f\n\u0004\b3\u00104\u0012\u0004\b5\u0010\u000eR\"\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d028\u0006X\u0004¢\u0006\f\n\u0004\b7\u00108\u0012\u0004\b9\u0010\u000eR\u001a\u0010?\u001a\u00020;8\u0002X\u0004¢\u0006\f\n\u0004\b<\u0010=\u0012\u0004\b>\u0010\u000eR$\u0010B\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u00038\u0016@RX\u000e¢\u0006\f\n\u0004\bA\u0010%\u001a\u0004\b<\u0010'R\u0014\u0010D\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010C¨\u0006G"}, d2 = {"Landroidx/room/RoomSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteProgram;", "", "capacity", "<init>", "(I)V", "", "query", "initArgCount", "", "i", "(Ljava/lang/String;I)V", "release", "()V", "statement", "b", "(Landroidx/sqlite/db/SupportSQLiteProgram;)V", "index", "L", "", "value", "F", "(IJ)V", "", "R", "(ID)V", "B", "(ILjava/lang/String;)V", "", "H", "(I[B)V", "close", "other", "d", "(Landroidx/room/RoomSQLiteQuery;)V", "a", "I", "getCapacity", "()I", "Ljava/lang/String;", "", "c", "[J", "getLongBindings$annotations", "longBindings", "", "[D", "getDoubleBindings$annotations", "doubleBindings", "", "e", "[Ljava/lang/String;", "getStringBindings$annotations", "stringBindings", "f", "[[B", "getBlobBindings$annotations", "blobBindings", "", "g", "[I", "getBindingTypes$annotations", "bindingTypes", "<set-?>", "h", "argCount", "()Ljava/lang/String;", "sql", "Binding", "Companion", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
@RestrictTo
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    public static final Companion i = new Companion((DefaultConstructorMarker) null);
    public static final TreeMap j = new TreeMap();

    /* renamed from: a  reason: collision with root package name */
    public final int f1756a;
    public volatile String b;
    public final long[] c;
    public final double[] d;
    public final String[] e;
    public final byte[][] f;
    public final int[] g;
    public int h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/room/RoomSQLiteQuery$Binding;", "", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface Binding {
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\u0003R\u0014\u0010\r\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Landroidx/room/RoomSQLiteQuery$Companion;", "", "<init>", "()V", "", "query", "", "argumentCount", "Landroidx/room/RoomSQLiteQuery;", "a", "(Ljava/lang/String;I)Landroidx/room/RoomSQLiteQuery;", "", "b", "BLOB", "I", "DOUBLE", "LONG", "NULL", "STRING", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomSQLiteQuery a(String str, int i) {
            Intrinsics.checkNotNullParameter(str, SearchIntents.EXTRA_QUERY);
            TreeMap treeMap = RoomSQLiteQuery.j;
            synchronized (treeMap) {
                Map.Entry ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
                if (ceilingEntry != null) {
                    treeMap.remove(ceilingEntry.getKey());
                    RoomSQLiteQuery roomSQLiteQuery = (RoomSQLiteQuery) ceilingEntry.getValue();
                    roomSQLiteQuery.i(str, i);
                    Intrinsics.checkNotNullExpressionValue(roomSQLiteQuery, "sqliteQuery");
                    return roomSQLiteQuery;
                }
                Unit unit = Unit.INSTANCE;
                RoomSQLiteQuery roomSQLiteQuery2 = new RoomSQLiteQuery(i, (DefaultConstructorMarker) null);
                roomSQLiteQuery2.i(str, i);
                return roomSQLiteQuery2;
            }
        }

        public final void b() {
            TreeMap treeMap = RoomSQLiteQuery.j;
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator it = treeMap.descendingKeySet().iterator();
                Intrinsics.checkNotNullExpressionValue(it, "queryPool.descendingKeySet().iterator()");
                while (true) {
                    int i = size - 1;
                    if (size > 0) {
                        it.next();
                        it.remove();
                        size = i;
                    } else {
                        return;
                    }
                }
            }
        }

        public Companion() {
        }
    }

    public /* synthetic */ RoomSQLiteQuery(int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2);
    }

    public static final RoomSQLiteQuery c(String str, int i2) {
        return i.a(str, i2);
    }

    public void B(int i2, String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        this.g[i2] = 4;
        this.e[i2] = str;
    }

    public void F(int i2, long j2) {
        this.g[i2] = 2;
        this.c[i2] = j2;
    }

    public void H(int i2, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, AccountConstantKt.RESPONSE_VALUE);
        this.g[i2] = 5;
        this.f[i2] = bArr;
    }

    public void L(int i2) {
        this.g[i2] = 1;
    }

    public void R(int i2, double d2) {
        this.g[i2] = 3;
        this.d[i2] = d2;
    }

    public String a() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void b(SupportSQLiteProgram supportSQLiteProgram) {
        Intrinsics.checkNotNullParameter(supportSQLiteProgram, "statement");
        int g2 = g();
        if (1 <= g2) {
            int i2 = 1;
            while (true) {
                int i3 = this.g[i2];
                if (i3 == 1) {
                    supportSQLiteProgram.L(i2);
                } else if (i3 == 2) {
                    supportSQLiteProgram.F(i2, this.c[i2]);
                } else if (i3 == 3) {
                    supportSQLiteProgram.R(i2, this.d[i2]);
                } else if (i3 == 4) {
                    String str = this.e[i2];
                    if (str != null) {
                        supportSQLiteProgram.B(i2, str);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else if (i3 == 5) {
                    byte[] bArr = this.f[i2];
                    if (bArr != null) {
                        supportSQLiteProgram.H(i2, bArr);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
                if (i2 != g2) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public void close() {
    }

    public final void d(RoomSQLiteQuery roomSQLiteQuery) {
        Intrinsics.checkNotNullParameter(roomSQLiteQuery, "other");
        int g2 = roomSQLiteQuery.g() + 1;
        System.arraycopy(roomSQLiteQuery.g, 0, this.g, 0, g2);
        System.arraycopy(roomSQLiteQuery.c, 0, this.c, 0, g2);
        System.arraycopy(roomSQLiteQuery.e, 0, this.e, 0, g2);
        System.arraycopy(roomSQLiteQuery.f, 0, this.f, 0, g2);
        System.arraycopy(roomSQLiteQuery.d, 0, this.d, 0, g2);
    }

    public int g() {
        return this.h;
    }

    public final void i(String str, int i2) {
        Intrinsics.checkNotNullParameter(str, SearchIntents.EXTRA_QUERY);
        this.b = str;
        this.h = i2;
    }

    public final void release() {
        TreeMap treeMap = j;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f1756a), this);
            i.b();
            Unit unit = Unit.INSTANCE;
        }
    }

    public RoomSQLiteQuery(int i2) {
        this.f1756a = i2;
        int i3 = i2 + 1;
        this.g = new int[i3];
        this.c = new long[i3];
        this.d = new double[i3];
        this.e = new String[i3];
        this.f = new byte[i3][];
    }
}
