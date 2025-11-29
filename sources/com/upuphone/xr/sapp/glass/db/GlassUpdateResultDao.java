package com.upuphone.xr.sapp.glass.db;

import androidx.room.Dao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Dao
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H§@¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H§@¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H§@¢\u0006\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/sapp/glass/db/GlassUpdateResultDao;", "", "Lcom/upuphone/xr/sapp/glass/db/GlassUpdateResultEntity;", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "id", "d", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "entity", "", "a", "(Lcom/upuphone/xr/sapp/glass/db/GlassUpdateResultEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface GlassUpdateResultDao {
    Object a(GlassUpdateResultEntity glassUpdateResultEntity, Continuation continuation);

    Object b(Continuation continuation);

    Object c(GlassUpdateResultEntity glassUpdateResultEntity, Continuation continuation);

    Object d(long j, Continuation continuation);
}
