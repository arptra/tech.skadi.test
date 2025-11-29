package com.upuphone.ar.transcribe.phone.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Database
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/db/TcbDb;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lcom/upuphone/ar/transcribe/phone/db/TcbDao;", "o", "()Lcom/upuphone/ar/transcribe/phone/db/TcbDao;", "Lcom/upuphone/ar/transcribe/phone/db/AiDao;", "n", "()Lcom/upuphone/ar/transcribe/phone/db/AiDao;", "a", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class TcbDb extends RoomDatabase {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6095a = new Companion((DefaultConstructorMarker) null);
    public static TcbDb b;
    public static final TcbDb$Companion$MIGRATION_1_2$1 c = new TcbDb$Companion$MIGRATION_1_2$1();
    public static final TcbDb$Companion$MIGRATION_2_3$1 d = new TcbDb$Companion$MIGRATION_2_3$1();
    public static final TcbDb$Companion$MIGRATION_3_4$1 e = new TcbDb$Companion$MIGRATION_3_4$1();
    public static final TcbDb$Companion$MIGRATION_4_5$1 f = new TcbDb$Companion$MIGRATION_4_5$1();
    public static final TcbDb$Companion$MIGRATION_5_6$1 g = new TcbDb$Companion$MIGRATION_5_6$1();
    public static final TcbDb$Companion$MIGRATION_6_7$1 h = new TcbDb$Companion$MIGRATION_6_7$1();
    public static final TcbDb$Companion$MIGRATION_7_8$1 i = new TcbDb$Companion$MIGRATION_7_8$1();
    public static final TcbDb$Companion$MIGRATION_8_9$1 j = new TcbDb$Companion$MIGRATION_8_9$1();

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0006*\b\f\u000f\u0012\u0015\u0018\u001b\u001e!\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/db/TcbDb$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/upuphone/ar/transcribe/phone/db/TcbDb;", "a", "(Landroid/content/Context;)Lcom/upuphone/ar/transcribe/phone/db/TcbDb;", "", "DB_NAME", "Ljava/lang/String;", "com/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_1_2$1", "MIGRATION_1_2", "Lcom/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_1_2$1;", "com/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_2_3$1", "MIGRATION_2_3", "Lcom/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_2_3$1;", "com/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_3_4$1", "MIGRATION_3_4", "Lcom/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_3_4$1;", "com/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_4_5$1", "MIGRATION_4_5", "Lcom/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_4_5$1;", "com/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_5_6$1", "MIGRATION_5_6", "Lcom/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_5_6$1;", "com/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_6_7$1", "MIGRATION_6_7", "Lcom/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_6_7$1;", "com/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_7_8$1", "MIGRATION_7_8", "Lcom/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_7_8$1;", "com/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_8_9$1", "MIGRATION_8_9", "Lcom/upuphone/ar/transcribe/phone/db/TcbDb$Companion$MIGRATION_8_9$1;", "instance", "Lcom/upuphone/ar/transcribe/phone/db/TcbDb;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TcbDb a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            TcbDb d = TcbDb.b;
            if (d == null) {
                synchronized (this) {
                    d = TcbDb.b;
                    if (d == null) {
                        TcbDb tcbDb = (TcbDb) Room.a(context, TcbDb.class, "tcb_history").b(TcbDb.c, TcbDb.d, TcbDb.e, TcbDb.f, TcbDb.g, TcbDb.h, TcbDb.i, TcbDb.j).d();
                        TcbDb.b = tcbDb;
                        d = tcbDb;
                    }
                }
            }
            return d;
        }

        public Companion() {
        }
    }

    public abstract AiDao n();

    public abstract TcbDao o();
}
