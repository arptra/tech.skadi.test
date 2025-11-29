package com.xjsd.ai.assistant.phone.vui.todo;

import androidx.datastore.preferences.core.PreferencesKeys;
import com.xjsd.ai.assistant.log.ILog;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001&\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH@¢\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0013\u001a\u00020\u00122\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0011\"\u00020\fH@¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001a\u00020\u00122\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0011\"\u00020\fH@¢\u0006\u0004\b\u0015\u0010\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0016H@¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u00162\u0006\u0010\u001a\u001a\u00020\u0019H@¢\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u00162\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019H@¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0003R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010/\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/todo/TodoRepository;", "", "<init>", "()V", "", "mzUid", "", "m", "(Ljava/lang/String;)V", "Lcom/xjsd/ai/assistant/phone/vui/todo/TodoDao;", "k", "()Lcom/xjsd/ai/assistant/phone/vui/todo/TodoDao;", "Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;", "todoEntry", "", "e", "(Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "f", "([Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "o", "", "g", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/Date;", "targetTime", "i", "(Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startTime", "endTime", "h", "(Ljava/util/Date;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "l", "n", "b", "Ljava/lang/String;", "accountId", "com/xjsd/ai/assistant/phone/vui/todo/TodoRepository$MIGRATION_1_2$1", "c", "Lcom/xjsd/ai/assistant/phone/vui/todo/TodoRepository$MIGRATION_1_2$1;", "MIGRATION_1_2", "Lcom/xjsd/ai/assistant/phone/vui/todo/TodoDatabase;", "d", "Lkotlin/Lazy;", "j", "()Lcom/xjsd/ai/assistant/phone/vui/todo/TodoDatabase;", "database", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TodoRepository {

    /* renamed from: a  reason: collision with root package name */
    public static final TodoRepository f8656a = new TodoRepository();
    public static String b = "";
    public static final TodoRepository$MIGRATION_1_2$1 c = new TodoRepository$MIGRATION_1_2$1();
    public static final Lazy d = LazyKt.lazy(TodoRepository$database$2.INSTANCE);

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(com.xjsd.ai.assistant.phone.vui.todo.TodoEntry r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.xjsd.ai.assistant.phone.vui.todo.TodoRepository$add$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.xjsd.ai.assistant.phone.vui.todo.TodoRepository$add$1 r0 = (com.xjsd.ai.assistant.phone.vui.todo.TodoRepository$add$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.phone.vui.todo.TodoRepository$add$1 r0 = new com.xjsd.ai.assistant.phone.vui.todo.TodoRepository$add$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.String r6 = b
            r5.setAccountId(r6)
            com.xjsd.ai.assistant.phone.vui.todo.TodoDatabase r4 = r4.j()
            com.xjsd.ai.assistant.phone.vui.todo.TodoDao r4 = r4.d()
            r0.label = r3
            java.lang.Object r6 = r4.a(r5, r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            java.lang.Number r6 = (java.lang.Number) r6
            long r4 = r6.longValue()
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.vui.todo.TodoRepository.e(com.xjsd.ai.assistant.phone.vui.todo.TodoEntry, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(com.xjsd.ai.assistant.phone.vui.todo.TodoEntry[] r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.xjsd.ai.assistant.phone.vui.todo.TodoRepository$delete$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.xjsd.ai.assistant.phone.vui.todo.TodoRepository$delete$1 r0 = (com.xjsd.ai.assistant.phone.vui.todo.TodoRepository$delete$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.phone.vui.todo.TodoRepository$delete$1 r0 = new com.xjsd.ai.assistant.phone.vui.todo.TodoRepository$delete$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 != r2) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r4)     // Catch:{ all -> 0x0029 }
            goto L_0x0052
        L_0x0029:
            r4 = move-exception
            goto L_0x0059
        L_0x002b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r4)
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x0029 }
            com.xjsd.ai.assistant.phone.vui.todo.TodoRepository r4 = f8656a     // Catch:{ all -> 0x0029 }
            com.xjsd.ai.assistant.phone.vui.todo.TodoDatabase r4 = r4.j()     // Catch:{ all -> 0x0029 }
            com.xjsd.ai.assistant.phone.vui.todo.TodoDao r4 = r4.d()     // Catch:{ all -> 0x0029 }
            int r1 = r5.length     // Catch:{ all -> 0x0029 }
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r1)     // Catch:{ all -> 0x0029 }
            com.xjsd.ai.assistant.phone.vui.todo.TodoEntry[] r5 = (com.xjsd.ai.assistant.phone.vui.todo.TodoEntry[]) r5     // Catch:{ all -> 0x0029 }
            r0.label = r2     // Catch:{ all -> 0x0029 }
            java.lang.Object r4 = r4.d(r5, r0)     // Catch:{ all -> 0x0029 }
            if (r4 != r6) goto L_0x0052
            return r6
        L_0x0052:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0029 }
            java.lang.Object r4 = kotlin.Result.m20constructorimpl(r4)     // Catch:{ all -> 0x0029 }
            goto L_0x0063
        L_0x0059:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m20constructorimpl(r4)
        L_0x0063:
            boolean r4 = kotlin.Result.m27isSuccessimpl(r4)
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.vui.todo.TodoRepository.f(com.xjsd.ai.assistant.phone.vui.todo.TodoEntry[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object g(Continuation continuation) {
        return j().d().b(b, continuation);
    }

    public final Object h(Date date, Date date2, Continuation continuation) {
        return j().d().e(b, date, date2, continuation);
    }

    public final Object i(Date date, Continuation continuation) {
        return j().d().h(b, date, continuation);
    }

    public final TodoDatabase j() {
        return (TodoDatabase) d.getValue();
    }

    public final TodoDao k() {
        return j().d();
    }

    public final void l() {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new TodoRepository$migrationData$1((Continuation<? super TodoRepository$migrationData$1>) null), 3, (Object) null);
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "mzUid");
        if (!Intrinsics.areEqual((Object) b, (Object) str)) {
            b = str;
            l();
        }
    }

    public final void n() {
        ILog.a("TodoRepository", "storeMigrationDataSuccess: 存储数据迁移成功标记");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new TodoRepository$storeMigrationDataSuccess$1(PreferencesKeys.a("migration_1_2"), (Continuation<? super TodoRepository$storeMigrationDataSuccess$1>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object o(com.xjsd.ai.assistant.phone.vui.todo.TodoEntry[] r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.xjsd.ai.assistant.phone.vui.todo.TodoRepository$update$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.xjsd.ai.assistant.phone.vui.todo.TodoRepository$update$1 r0 = (com.xjsd.ai.assistant.phone.vui.todo.TodoRepository$update$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.phone.vui.todo.TodoRepository$update$1 r0 = new com.xjsd.ai.assistant.phone.vui.todo.TodoRepository$update$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 != r2) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r4)     // Catch:{ all -> 0x0029 }
            goto L_0x0052
        L_0x0029:
            r4 = move-exception
            goto L_0x0059
        L_0x002b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r4)
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x0029 }
            com.xjsd.ai.assistant.phone.vui.todo.TodoRepository r4 = f8656a     // Catch:{ all -> 0x0029 }
            com.xjsd.ai.assistant.phone.vui.todo.TodoDatabase r4 = r4.j()     // Catch:{ all -> 0x0029 }
            com.xjsd.ai.assistant.phone.vui.todo.TodoDao r4 = r4.d()     // Catch:{ all -> 0x0029 }
            int r1 = r5.length     // Catch:{ all -> 0x0029 }
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r1)     // Catch:{ all -> 0x0029 }
            com.xjsd.ai.assistant.phone.vui.todo.TodoEntry[] r5 = (com.xjsd.ai.assistant.phone.vui.todo.TodoEntry[]) r5     // Catch:{ all -> 0x0029 }
            r0.label = r2     // Catch:{ all -> 0x0029 }
            java.lang.Object r4 = r4.c(r5, r0)     // Catch:{ all -> 0x0029 }
            if (r4 != r6) goto L_0x0052
            return r6
        L_0x0052:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0029 }
            java.lang.Object r4 = kotlin.Result.m20constructorimpl(r4)     // Catch:{ all -> 0x0029 }
            goto L_0x0063
        L_0x0059:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m20constructorimpl(r4)
        L_0x0063:
            boolean r4 = kotlin.Result.m27isSuccessimpl(r4)
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.vui.todo.TodoRepository.o(com.xjsd.ai.assistant.phone.vui.todo.TodoEntry[], kotlin.coroutines.Continuation):java.lang.Object");
    }
}
