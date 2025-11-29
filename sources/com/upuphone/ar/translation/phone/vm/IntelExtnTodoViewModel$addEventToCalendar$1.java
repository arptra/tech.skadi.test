package com.upuphone.ar.translation.phone.vm;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.CalendarContract;
import androidx.lifecycle.ViewModelKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import com.upuphone.ar.translation.utils.DateUtils;
import com.xjsd.ai.assistant.protocol.schedule.Event;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$addEventToCalendar$1", f = "IntelExtnTodoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class IntelExtnTodoViewModel$addEventToCalendar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IntelExtnTodo $extnTodo;
    int label;
    final /* synthetic */ IntelExtnTodoViewModel this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$addEventToCalendar$1$1", f = "IntelExtnTodoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$addEventToCalendar$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(intelExtnTodoViewModel, insert, intelExtnTodo3, r, continuation);
            r0.L$0 = obj;
            return r0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x00ac, code lost:
            if (r3 != null) goto L_0x00b5;
         */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
            /*
                r12 = this;
                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r12.label
                if (r0 != 0) goto L_0x00bb
                kotlin.ResultKt.throwOnFailure(r13)
                java.lang.Object r13 = r12.L$0
                kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
                com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel r13 = r1
                androidx.lifecycle.MutableLiveData r13 = r13.f
                android.net.Uri r0 = r2
                java.lang.String r1 = "IntelExtnTodoViewModel"
                if (r0 == 0) goto L_0x00ae
                com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel r2 = r1
                com.upuphone.ar.translation.phone.bean.IntelExtnTodo r3 = r3
                long r4 = r4
                int r6 = com.upuphone.ar.translation.phone.R.string.tl_already_sync_to_calendar
                r2.V(r6)
                java.lang.String r0 = r0.getLastPathSegment()
                if (r0 == 0) goto L_0x00a7
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                long r6 = java.lang.Long.parseLong(r0)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r8 = "addEventToCalendar 成功 "
                r0.append(r8)
                r0.append(r6)
                java.lang.String r0 = r0.toString()
                com.upuphone.ar.translation.ext.LogExt.j(r0, r1)
                android.net.Uri r0 = android.provider.CalendarContract.Events.CONTENT_URI
                java.lang.String r0 = r0.getAuthority()
                android.os.Bundle r8 = new android.os.Bundle
                r8.<init>()
                java.lang.String r9 = "force"
                r10 = 1
                r8.putBoolean(r9, r10)
                java.lang.String r9 = "expedited"
                r8.putBoolean(r9, r10)
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                r9 = 0
                android.content.ContentResolver.requestSync(r9, r0, r8)
                android.app.Application r0 = r2.A()
                android.content.ContentResolver r0 = r0.getContentResolver()
                android.net.Uri r2 = android.provider.CalendarContract.Reminders.CONTENT_URI
                android.content.ContentValues r8 = new android.content.ContentValues
                r8.<init>()
                java.lang.String r9 = "event_id"
                java.lang.Long r11 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
                r8.put(r9, r11)
                java.lang.String r9 = "method"
                java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
                r8.put(r9, r11)
                r9 = 10
                java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
                java.lang.String r11 = "minutes"
                r8.put(r11, r9)
                r0.insert(r2, r8)
                java.lang.Class<com.upuphone.ar.translation.phone.bean.IntelExtnTodo> r0 = com.upuphone.ar.translation.phone.bean.IntelExtnTodo.class
                java.lang.Object r0 = com.upuphone.ar.translation.ext.AnyExtKt.a(r3, r0)
                com.upuphone.ar.translation.phone.bean.IntelExtnTodo r0 = (com.upuphone.ar.translation.phone.bean.IntelExtnTodo) r0
                r0.setCalendarId(r4)
                r0.setCalendarEventId(r6)
                r0.setAddedSchedule(r10)
                if (r0 != 0) goto L_0x00a5
                goto L_0x00a7
            L_0x00a5:
                r3 = r0
                goto L_0x00ac
            L_0x00a7:
                java.lang.String r0 = "addEventToCalendar 成功, eventId异常（null）"
                com.upuphone.ar.translation.ext.LogExt.j(r0, r1)
            L_0x00ac:
                if (r3 != 0) goto L_0x00b5
            L_0x00ae:
                com.upuphone.ar.translation.phone.bean.IntelExtnTodo r3 = r3
                java.lang.String r12 = "addEventToCalendar 失败"
                com.upuphone.ar.translation.ext.LogExt.j(r12, r1)
            L_0x00b5:
                r13.setValue(r3)
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            L_0x00bb:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel$addEventToCalendar$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnTodoViewModel$addEventToCalendar$1(IntelExtnTodo intelExtnTodo, IntelExtnTodoViewModel intelExtnTodoViewModel, Continuation<? super IntelExtnTodoViewModel$addEventToCalendar$1> continuation) {
        super(2, continuation);
        this.$extnTodo = intelExtnTodo;
        this.this$0 = intelExtnTodoViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IntelExtnTodoViewModel$addEventToCalendar$1(this.$extnTodo, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        long j;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IntelExtnTodo intelExtnTodo = this.$extnTodo;
            LogExt.j("addEventToCalendar extnTodo=" + intelExtnTodo, "IntelExtnTodoViewModel");
            final long r = this.this$0.queryOrAddCalendarId();
            String startTime = this.$extnTodo.getStartTime();
            String endTime = this.$extnTodo.getEndTime();
            Ref.LongRef longRef = new Ref.LongRef();
            if (!StringsKt.isBlank(startTime)) {
                j = DateUtils.b(startTime);
                long b = StringsKt.isBlank(endTime) ^ true ? DateUtils.b(endTime) : DateUtils.h(startTime) ? DateUtils.a(startTime) : ((long) 3600000) + j;
                longRef.element = b;
                if (j > b) {
                    longRef.element = ((long) 3600000) + j;
                }
            } else {
                j = DateUtils.f(1);
                longRef.element = ((long) 3600000) + j;
            }
            ContentResolver contentResolver = this.this$0.A().getContentResolver();
            Uri uri = CalendarContract.Events.CONTENT_URI;
            ContentValues contentValues = new ContentValues();
            IntelExtnTodo intelExtnTodo2 = this.$extnTodo;
            contentValues.put(Event.START_TIME, Boxing.boxLong(j));
            contentValues.put(Event.END_TIME, Boxing.boxLong(longRef.element));
            contentValues.put("title", intelExtnTodo2.getContent());
            contentValues.put("description", intelExtnTodo2.getContent());
            contentValues.put(Event.CALENDAR_ID, Boxing.boxLong(r));
            contentValues.put(Event.TIME_ZONE, "UTC");
            Unit unit = Unit.INSTANCE;
            final Uri insert = contentResolver.insert(uri, contentValues);
            CoroutineScope a2 = ViewModelKt.a(this.this$0);
            MainCoroutineDispatcher c = Dispatchers.c();
            final IntelExtnTodoViewModel intelExtnTodoViewModel = this.this$0;
            final IntelExtnTodo intelExtnTodo3 = this.$extnTodo;
            Job unused = BuildersKt__Builders_commonKt.d(a2, c, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 2, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((IntelExtnTodoViewModel$addEventToCalendar$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
