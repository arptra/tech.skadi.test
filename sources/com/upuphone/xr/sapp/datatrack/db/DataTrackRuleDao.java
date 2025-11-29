package com.upuphone.xr.sapp.datatrack.db;

import androidx.room.Dao;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Dao
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005H§@¢\u0006\u0004\b\b\u0010\tJ,\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H§@¢\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H§@¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/db/DataTrackRuleDao;", "", "", "Lcom/upuphone/xr/sapp/datatrack/DataTrackRule;", "list", "", "b", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "deviceType", "", "eventUseTypes", "c", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "event", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface DataTrackRuleDao {
    Object a(Continuation continuation);

    Object b(List list, Continuation continuation);

    Object c(String str, List list, Continuation continuation);

    Object d(String str, String str2, List list, Continuation continuation);
}
