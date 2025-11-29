package com.upuphone.ar.transcribe.phone.db;

import androidx.room.Dao;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.upuphone.ar.transcribe.phone.db.entity.MessageEntity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Dao
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J/\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H'¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\bH'¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH'¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000fH'¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0002H'¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00072\u0006\u0010\u001f\u001a\u00020\u000fH'¢\u0006\u0004\b!\u0010\"J#\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\f\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u0007H'¢\u0006\u0004\b$\u0010\u0014J\u0017\u0010&\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020 H'¢\u0006\u0004\b&\u0010'J\u001f\u0010)\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0002H'¢\u0006\u0004\b)\u0010\u001eJ\u0017\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020\u000fH'¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020+2\u0006\u0010.\u001a\u00020\u000fH\u0017¢\u0006\u0004\b/\u0010-J\u0017\u00102\u001a\u00020+2\u0006\u00101\u001a\u000200H\u0017¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020+2\u0006\u00104\u001a\u000200H'¢\u0006\u0004\b5\u00103J\u0017\u00106\u001a\u00020+2\u0006\u00101\u001a\u000200H'¢\u0006\u0004\b6\u00103J\u001d\u0010:\u001a\b\u0012\u0004\u0012\u0002090\u00072\u0006\u00108\u001a\u000207H'¢\u0006\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/db/TcbDao;", "", "", "account", "", "limit", "offset", "", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "f", "(Ljava/lang/String;II)Ljava/util/List;", "Lcom/upuphone/ar/transcribe/phone/bean/IdTitleBean;", "q", "(Ljava/lang/String;)Ljava/util/List;", "entity", "", "o", "(Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;)J", "", "a", "(Ljava/util/List;)[Ljava/lang/Long;", "id", "j", "(J)I", "n", "(J)Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "count", "()I", "newTitle", "g", "(JLjava/lang/String;)I", "transcribeId", "Lcom/upuphone/ar/transcribe/phone/db/entity/MessageEntity;", "e", "(J)Ljava/util/List;", "messages", "i", "message", "h", "(Lcom/upuphone/ar/transcribe/phone/db/entity/MessageEntity;)J", "newMessage", "p", "transId", "", "m", "(J)V", "tranId", "c", "", "transIds", "l", "([J)V", "ids", "b", "k", "Landroidx/sqlite/db/SupportSQLiteQuery;", "query", "Lcom/upuphone/ar/transcribe/phone/bean/SearchBean;", "d", "(Landroidx/sqlite/db/SupportSQLiteQuery;)Ljava/util/List;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface TcbDao {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void a(TcbDao tcbDao, long j) {
            tcbDao.j(j);
            tcbDao.m(j);
        }

        public static void b(TcbDao tcbDao, long[] jArr) {
            Intrinsics.checkNotNullParameter(jArr, "transIds");
            tcbDao.b(jArr);
            tcbDao.k(jArr);
        }
    }

    Long[] a(List list);

    void b(long[] jArr);

    void c(long j);

    int count();

    List d(SupportSQLiteQuery supportSQLiteQuery);

    List e(long j);

    List f(String str, int i, int i2);

    int g(long j, String str);

    long h(MessageEntity messageEntity);

    Long[] i(List list);

    int j(long j);

    void k(long[] jArr);

    void l(long[] jArr);

    void m(long j);

    TranscribeBean n(long j);

    long o(TranscribeBean transcribeBean);

    int p(long j, String str);

    List q(String str);
}
