package com.upuphone.ar.translation.phone.dao;

import androidx.room.Dao;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import java.util.List;
import kotlin.Metadata;

@Dao
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u00020\n2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\b\"\u00020\u0003H'¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH'¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH'¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/upuphone/ar/translation/phone/dao/IntelExtnTodoDao;", "", "", "Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;", "todoList", "", "a", "(Ljava/util/List;)Ljava/util/List;", "", "todos", "", "f", "([Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;)V", "", "accountId", "recognizeId", "", "deleteStatus", "b", "(Ljava/lang/String;Ljava/lang/String;I)V", "", "isReported", "h", "(Ljava/lang/String;Ljava/lang/String;Z)V", "d", "(Ljava/util/List;)V", "c", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "g", "(Ljava/lang/String;Ljava/lang/String;I)Ljava/util/List;", "e", "(Ljava/lang/String;Ljava/lang/String;)I", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface IntelExtnTodoDao {
    List a(List list);

    void b(String str, String str2, int i);

    List c(String str, String str2);

    void d(List list);

    int e(String str, String str2);

    void f(IntelExtnTodo... intelExtnTodoArr);

    List g(String str, String str2, int i);

    void h(String str, String str2, boolean z);
}
