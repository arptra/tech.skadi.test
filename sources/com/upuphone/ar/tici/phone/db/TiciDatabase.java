package com.upuphone.ar.tici.phone.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Database
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/tici/phone/db/TiciDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lcom/upuphone/ar/tici/phone/db/TiciDao;", "f", "()Lcom/upuphone/ar/tici/phone/db/TiciDao;", "a", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@TypeConverters
public abstract class TiciDatabase extends RoomDatabase {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f5967a = new Companion((DefaultConstructorMarker) null);
    public static volatile TiciDatabase b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/upuphone/ar/tici/phone/db/TiciDatabase$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/upuphone/ar/tici/phone/db/TiciDatabase;", "b", "(Landroid/content/Context;)Lcom/upuphone/ar/tici/phone/db/TiciDatabase;", "", "a", "(Landroid/content/Context;)V", "INSTANCE", "Lcom/upuphone/ar/tici/phone/db/TiciDatabase;", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, Dispatchers.b(), (CoroutineStart) null, new TiciDatabase$Companion$clearOldData$1(context, (Continuation<? super TiciDatabase$Companion$clearOldData$1>) null), 2, (Object) null);
        }

        public final TiciDatabase b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            TiciDatabase d = TiciDatabase.b;
            if (d == null) {
                synchronized (this) {
                    d = TiciDatabase.b;
                    if (d == null) {
                        RoomDatabase d2 = Room.a(context, TiciDatabase.class, "tici_v2").f().d();
                        TiciDatabase.b = (TiciDatabase) d2;
                        TiciDatabase.f5967a.a(context);
                        d = (TiciDatabase) d2;
                    }
                }
            }
            return d;
        }

        public Companion() {
        }
    }

    public abstract TiciDao f();
}
