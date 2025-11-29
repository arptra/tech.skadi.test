package com.upuphone.datatrack.base.db;

import androidx.room.Dao;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Dao
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000bJ\u001b\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\tH§@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/upuphone/datatrack/base/db/AppTrackDao;", "", "Lcom/upuphone/datatrack/base/db/AppTrack;", "appTrack", "", "b", "(Lcom/upuphone/datatrack/base/db/AppTrack;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "count", "", "c", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "", "pkgName", "e", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ids", "f", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datatrack-base_release"}, k = 1, mv = {1, 7, 1})
public interface AppTrackDao {
    Object a(String str, int i, Continuation continuation);

    Object b(AppTrack appTrack, Continuation continuation);

    Object c(int i, Continuation continuation);

    Object d(Continuation continuation);

    Object e(String str, Continuation continuation);

    Object f(List list, Continuation continuation);

    Object g(int i, Continuation continuation);
}
