package com.upuphone.xr.sapp.monitor.notification.cache;

import androidx.room.Dao;
import com.upuphone.xr.sapp.monitor.notification.model.WechatMissedCallModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Dao
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH§@¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004H§@¢\u0006\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/cache/WechatMissedCallDao;", "Lcom/upuphone/xr/sapp/monitor/notification/cache/BaseDao;", "Lcom/upuphone/xr/sapp/monitor/notification/model/WechatMissedCallModel;", "element", "", "b", "(Lcom/upuphone/xr/sapp/monitor/notification/model/WechatMissedCallModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "name", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface WechatMissedCallDao extends BaseDao<WechatMissedCallModel> {
    Object a(String str, Continuation continuation);

    Object b(WechatMissedCallModel wechatMissedCallModel, Continuation continuation);

    Object c(Continuation continuation);

    Object d(Continuation continuation);
}
