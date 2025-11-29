package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$addEventToCalendar$1", f = "FastRecordTodoViewModel.kt", i = {0}, l = {466}, m = "invokeSuspend", n = {"uri"}, s = {"L$0"})
public final class FastRecordTodoViewModel$addEventToCalendar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<RecordTodoItemEntity, Unit> $callback;
    final /* synthetic */ RecordTodoItemEntity $extnTodo;
    Object L$0;
    int label;
    final /* synthetic */ FastRecordTodoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTodoViewModel$addEventToCalendar$1(RecordTodoItemEntity recordTodoItemEntity, FastRecordTodoViewModel fastRecordTodoViewModel, Function1<? super RecordTodoItemEntity, Unit> function1, Continuation<? super FastRecordTodoViewModel$addEventToCalendar$1> continuation) {
        super(2, continuation);
        this.$extnTodo = recordTodoItemEntity;
        this.this$0 = fastRecordTodoViewModel;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordTodoViewModel$addEventToCalendar$1(this.$extnTodo, this.this$0, this.$callback, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x010c, code lost:
        r5 = r14.getLastPathSegment();
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            java.lang.String r2 = "TodoViewModel"
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 != r3) goto L_0x0016
            java.lang.Object r13 = r13.L$0
            android.net.Uri r13 = (android.net.Uri) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0167
        L_0x0016:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r14)
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r14 = r13.$extnTodo
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "addEventToCalendar extnTodo="
            r1.append(r4)
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r14, r2)
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r14 = r13.this$0
            long r4 = r14.queryOrAddCalendarId()
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r14 = r13.$extnTodo
            java.lang.String r14 = r14.getStart_time()
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r1 = r13.$extnTodo
            java.lang.String r1 = r1.getEnd_time()
            kotlin.jvm.internal.Ref$LongRef r6 = new kotlin.jvm.internal.Ref$LongRef
            r6.<init>()
            boolean r7 = kotlin.text.StringsKt.isBlank(r14)
            r7 = r7 ^ r3
            r8 = 3600000(0x36ee80, float:5.044674E-39)
            if (r7 == 0) goto L_0x00a5
            com.upuphone.ar.fastrecord.phone.utils.RecordDateUtil r7 = com.upuphone.ar.fastrecord.phone.utils.RecordDateUtil.INSTANCE
            long r9 = r7.dateStrToTimestamp(r14)
            boolean r11 = kotlin.text.StringsKt.isBlank(r1)
            r11 = r11 ^ r3
            if (r11 == 0) goto L_0x006a
            long r11 = r7.dateStrToTimestamp(r1)
            goto L_0x009a
        L_0x006a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r11 = "addEventToCalendar isStartOfDay startTime = "
            r1.append(r11)
            r1.append(r14)
            java.lang.String r11 = " "
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r1, r2)
            boolean r1 = r7.isStartOfDay(r14)
            if (r1 == 0) goto L_0x0093
            java.lang.String r1 = "addEventToCalendar isStartOfDay true"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r1, r2)
            long r11 = r7.dateStrToEndOfDayTimestamp(r14)
            goto L_0x009a
        L_0x0093:
            java.lang.String r14 = "addEventToCalendar isStartOfDay false"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r14, r2)
            long r11 = (long) r8
            long r11 = r11 + r9
        L_0x009a:
            r6.element = r11
            int r14 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r14 <= 0) goto L_0x00af
            long r7 = (long) r8
            long r7 = r7 + r9
            r6.element = r7
            goto L_0x00af
        L_0x00a5:
            com.upuphone.ar.fastrecord.phone.utils.RecordDateUtil r14 = com.upuphone.ar.fastrecord.phone.utils.RecordDateUtil.INSTANCE
            long r9 = r14.hourlyTime(r3)
            long r7 = (long) r8
            long r7 = r7 + r9
            r6.element = r7
        L_0x00af:
            com.upuphone.xr.sapp.context.SdkContext r14 = com.upuphone.xr.sapp.context.SdkContext.f6675a
            com.upuphone.xr.sapp.context.AppContext r14 = r14.c()
            android.content.Context r14 = r14.getContext()
            android.content.ContentResolver r14 = r14.getContentResolver()
            android.net.Uri r1 = android.provider.CalendarContract.Events.CONTENT_URI
            android.content.ContentValues r7 = new android.content.ContentValues
            r7.<init>()
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r8 = r13.$extnTodo
            java.lang.String r11 = "dtstart"
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r9)
            r7.put(r11, r9)
            long r9 = r6.element
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r9)
            java.lang.String r9 = "dtend"
            r7.put(r9, r6)
            java.lang.String r6 = r8.getContentTemp()
            java.lang.String r9 = "title"
            r7.put(r9, r6)
            java.lang.String r6 = "description"
            java.lang.String r8 = r8.getContentTemp()
            r7.put(r6, r8)
            java.lang.String r6 = "calendar_id"
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
            r7.put(r6, r8)
            java.lang.String r6 = "eventTimezone"
            java.lang.String r8 = "UTC"
            r7.put(r6, r8)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            android.net.Uri r14 = r14.insert(r1, r7)
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r6 = r13.$extnTodo
            r6.setCalendarId(r4)
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r4 = r13.$extnTodo
            if (r14 == 0) goto L_0x0117
            java.lang.String r5 = r14.getLastPathSegment()
            if (r5 == 0) goto L_0x0117
            long r5 = java.lang.Long.parseLong(r5)
            goto L_0x0119
        L_0x0117:
            r5 = 0
        L_0x0119:
            r4.setCalendarEventId(r5)
            java.lang.String r1 = r1.getAuthority()
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r5 = "force"
            r4.putBoolean(r5, r3)
            java.lang.String r5 = "expedited"
            r4.putBoolean(r5, r3)
            r5 = 0
            android.content.ContentResolver.requestSync(r5, r1, r4)
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r1 = r13.$extnTodo
            r1.setAddSchedule(r3)
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r1 = r13.$extnTodo
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "addEventToCalendar = "
            r4.append(r6)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r1, r2)
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$addEventToCalendar$1$2 r4 = new com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$addEventToCalendar$1$2
            kotlin.jvm.functions.Function1<com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity, kotlin.Unit> r6 = r13.$callback
            com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity r7 = r13.$extnTodo
            r4.<init>(r6, r7, r5)
            r13.L$0 = r14
            r13.label = r3
            java.lang.Object r13 = kotlinx.coroutines.BuildersKt.g(r1, r4, r13)
            if (r13 != r0) goto L_0x0166
            return r0
        L_0x0166:
            r13 = r14
        L_0x0167:
            if (r13 == 0) goto L_0x016a
            goto L_0x016b
        L_0x016a:
            r3 = 0
        L_0x016b:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "addEventToCalendar success = "
            r13.append(r14)
            r13.append(r3)
            java.lang.String r13 = r13.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r13, r2)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel$addEventToCalendar$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordTodoViewModel$addEventToCalendar$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
