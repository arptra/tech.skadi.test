package com.upuphone.ar.transcribe.phone.db;

import androidx.room.Dao;
import com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity;
import java.util.List;
import kotlin.Metadata;

@Dao
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H'¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H'¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\u001c\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/db/AiDao;", "", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;", "bean", "", "h", "(Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;)J", "", "b", "(Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;)I", "", "recordId", "c", "(Ljava/lang/String;)Lcom/upuphone/ar/transcribe/phone/db/entity/AiSummaryEntity;", "i", "", "f", "(Ljava/lang/String;)V", "", "Lcom/upuphone/ar/transcribe/phone/db/entity/AiTodoEntity;", "", "e", "(Ljava/util/List;)[Ljava/lang/Long;", "j", "(Ljava/util/List;)I", "g", "(Ljava/lang/String;)Ljava/util/List;", "d", "a", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface AiDao {
    void a(String str);

    int b(AiSummaryEntity aiSummaryEntity);

    AiSummaryEntity c(String str);

    List d(String str);

    Long[] e(List list);

    void f(String str);

    List g(String str);

    long h(AiSummaryEntity aiSummaryEntity);

    AiSummaryEntity i(String str);

    int j(List list);
}
