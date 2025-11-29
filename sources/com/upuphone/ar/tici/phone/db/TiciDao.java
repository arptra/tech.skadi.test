package com.upuphone.ar.tici.phone.db;

import androidx.room.Dao;
import com.upuphone.ar.tici.phone.db.entity.TiciContentPart;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Dao
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\b\u0010\u0006J \u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H§@¢\u0006\u0004\b\f\u0010\rJ(\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H§@¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H§@¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0011H§@¢\u0006\u0004\b\u0019\u0010\u0014J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0011H§@¢\u0006\u0004\b\u001a\u0010\u0014J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004H§@¢\u0006\u0004\b\u001b\u0010\u0016J\u001e\u0010\u001e\u001a\u00020\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cH§@¢\u0006\u0004\b\u001e\u0010\u001fJ,\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001cH§@¢\u0006\u0004\b!\u0010\"J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010\u0012\u001a\u00020\u0011H§@¢\u0006\u0004\b#\u0010\u0014J&\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u001c2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\tH§@¢\u0006\u0004\b&\u0010'J.\u0010)\u001a\b\u0012\u0004\u0012\u00020%0\u001c2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\tH§@¢\u0006\u0004\b)\u0010*J\u0012\u0010+\u001a\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b+\u0010,J\u001a\u0010-\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0004H§@¢\u0006\u0004\b-\u0010\u0016J\u0018\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0004H§@¢\u0006\u0004\b/\u0010\u0016J\u001e\u00101\u001a\u00020\u00072\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cH§@¢\u0006\u0004\b1\u0010\u001fJ\u001e\u00104\u001a\u00020\u00072\f\u00103\u001a\b\u0012\u0004\u0012\u0002020\u001cH§@¢\u0006\u0004\b4\u0010\u001fJ\"\u00106\u001a\u0004\u0018\u0001022\u0006\u0010.\u001a\u00020\u00042\u0006\u00105\u001a\u00020\tH§@¢\u0006\u0004\b6\u00107J\u0018\u00109\u001a\u00020\u00072\u0006\u00108\u001a\u000202H§@¢\u0006\u0004\b9\u0010:J(\u0010<\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00042\u0006\u00105\u001a\u00020\t2\u0006\u0010;\u001a\u00020\u0011H§@¢\u0006\u0004\b<\u0010=J\u0018\u0010>\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0004H§@¢\u0006\u0004\b>\u0010\u0016J\u001e\u0010?\u001a\b\u0012\u0004\u0012\u0002020\u001c2\u0006\u0010.\u001a\u00020\u0004H§@¢\u0006\u0004\b?\u0010\u0016J\u001e\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\u0006\u0010.\u001a\u00020\u0004H§@¢\u0006\u0004\b@\u0010\u0016J&\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\u0006\u0010.\u001a\u00020\u00042\u0006\u00105\u001a\u00020\tH§@¢\u0006\u0004\bA\u00107J&\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\u0006\u0010.\u001a\u00020\u00042\u0006\u00105\u001a\u00020\tH§@¢\u0006\u0004\bB\u00107J\"\u0010C\u001a\u0004\u0018\u00010\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u00105\u001a\u00020\tH§@¢\u0006\u0004\bC\u00107¨\u0006D"}, d2 = {"Lcom/upuphone/ar/tici/phone/db/TiciDao;", "", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "ticiEntity", "", "s", "(Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "n", "", "index", "id", "x", "(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentPage", "w", "(IIJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "userId", "h", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "q", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "C", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "k", "B", "", "ids", "y", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fileTypes", "m", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "count", "Lcom/upuphone/ar/tici/phone/data/TiciHistory;", "c", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "time", "u", "(Ljava/lang/String;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "r", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "A", "ticiId", "f", "ticiIds", "v", "Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;", "list", "p", "partIndex", "b", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ticiContentPart", "t", "(Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paragraphIndexes", "g", "(JILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "a", "z", "j", "o", "l", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public interface TiciDao {
    Object A(long j, Continuation continuation);

    Object B(long j, Continuation continuation);

    Object C(String str, long j, Continuation continuation);

    Object a(long j, Continuation continuation);

    Object b(long j, int i, Continuation continuation);

    Object c(String str, int i, Continuation continuation);

    Object d(String str, Continuation continuation);

    Object e(long j, Continuation continuation);

    Object f(long j, Continuation continuation);

    Object g(long j, int i, String str, Continuation continuation);

    Object h(String str, Continuation continuation);

    Object i(String str, Continuation continuation);

    Object j(long j, int i, Continuation continuation);

    Object k(String str, Continuation continuation);

    Object l(long j, int i, Continuation continuation);

    Object m(String str, List list, Continuation continuation);

    Object n(TiciEntity ticiEntity, Continuation continuation);

    Object o(long j, int i, Continuation continuation);

    Object p(List list, Continuation continuation);

    Object q(long j, Continuation continuation);

    Object r(Continuation continuation);

    Object s(TiciEntity ticiEntity, Continuation continuation);

    Object t(TiciContentPart ticiContentPart, Continuation continuation);

    Object u(String str, long j, int i, Continuation continuation);

    Object v(List list, Continuation continuation);

    Object w(int i, int i2, long j, Continuation continuation);

    Object x(int i, long j, Continuation continuation);

    Object y(List list, Continuation continuation);

    Object z(long j, Continuation continuation);
}
