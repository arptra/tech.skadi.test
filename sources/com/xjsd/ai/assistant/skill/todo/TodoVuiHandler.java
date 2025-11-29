package com.xjsd.ai.assistant.skill.todo;

import com.xjsd.ai.assistant.common.Communicator;
import com.xjsd.ai.assistant.common.UnSupportFeatureManager;
import com.xjsd.ai.assistant.common.handler.VuiHandler;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.NewFunctionCompact;
import com.xjsd.ai.assistant.phone.event.DomainChangeEvent;
import com.xjsd.ai.assistant.phone.event.UserAbortEvent;
import com.xjsd.ai.assistant.phone.vui.todo.TodoEntry;
import com.xjsd.ai.assistant.protocol.BusinessDataType;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.todo.TodoBusinessData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 =2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH@¢\u0006\u0004\b\u0017\u0010\u0018JD\u0010 \u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH@¢\u0006\u0004\b \u0010!J \u0010$\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"H@¢\u0006\u0004\b$\u0010%J*\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aH@¢\u0006\u0004\b(\u0010)J!\u0010.\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b.\u0010/J\u001f\u00102\u001a\u00020\f2\u0006\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\fH\u0002¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\f2\u0006\u00100\u001a\u00020\u001aH\u0002¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\fH\u0002¢\u0006\u0004\b7\u00108R$\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\f09j\b\u0012\u0004\u0012\u00020\f`:8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010;¨\u0006?"}, d2 = {"Lcom/xjsd/ai/assistant/skill/todo/TodoVuiHandler;", "Lcom/xjsd/ai/assistant/common/handler/VuiHandler;", "<init>", "()V", "Lcom/xjsd/ai/assistant/phone/event/UserAbortEvent;", "event", "", "onReceiveUserAbortEvent", "(Lcom/xjsd/ai/assistant/phone/event/UserAbortEvent;)V", "Lcom/xjsd/ai/assistant/phone/event/DomainChangeEvent;", "onReceiveDomainChangeEvent", "(Lcom/xjsd/ai/assistant/phone/event/DomainChangeEvent;)V", "", "getHandleType", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/protocol/VuiModel;", "model", "", "a", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)Z", "enable", "p", "(Z)V", "k", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "target", "Ljava/util/Date;", "startTime", "endTime", "timeText", "time", "query", "l", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/alibaba/fastjson/JSONObject;", "payload", "m", "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;", "n", "(Ljava/util/Date;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "type", "", "data", "o", "(ILjava/lang/Object;)V", "date", "format", "j", "(Ljava/util/Date;Ljava/lang/String;)Ljava/lang/String;", "i", "(Ljava/util/Date;)Ljava/lang/String;", "formatDate", "q", "(Ljava/lang/String;)Ljava/util/Date;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mSupportIntent", "b", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTodoVuiHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TodoVuiHandler.kt\ncom/xjsd/ai/assistant/skill/todo/TodoVuiHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,449:1\n766#2:450\n857#2,2:451\n*S KotlinDebug\n*F\n+ 1 TodoVuiHandler.kt\ncom/xjsd/ai/assistant/skill/todo/TodoVuiHandler\n*L\n415#1:450\n415#1:451,2\n*E\n"})
public final class TodoVuiHandler implements VuiHandler {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);
    public static String c;
    public static TodoEntry d;

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f8703a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u000b\u0010\nR(\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@BX\u000e¢\u0006\f\n\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/xjsd/ai/assistant/skill/todo/TodoVuiHandler$Companion;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;", "todoEntry", "", "b", "(Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;)V", "e", "(Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "", "value", "mUpdateTodoTargetStatus", "Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "TAG", "mContextTodoEntry", "Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void b(TodoEntry todoEntry) {
            Intrinsics.checkNotNullParameter(todoEntry, "todoEntry");
            TodoVuiHandler.d = todoEntry;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object c(com.xjsd.ai.assistant.phone.vui.todo.TodoEntry r5, kotlin.coroutines.Continuation r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion$deleteTodo$1
                if (r0 == 0) goto L_0x0013
                r0 = r6
                com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion$deleteTodo$1 r0 = (com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion$deleteTodo$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion$deleteTodo$1 r0 = new com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion$deleteTodo$1
                r0.<init>(r4, r6)
            L_0x0018:
                java.lang.Object r4 = r0.result
                java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r0.label
                r2 = 1
                if (r1 == 0) goto L_0x0031
                if (r1 != r2) goto L_0x0029
                kotlin.ResultKt.throwOnFailure(r4)
                goto L_0x0043
            L_0x0029:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L_0x0031:
                kotlin.ResultKt.throwOnFailure(r4)
                com.xjsd.ai.assistant.phone.vui.todo.TodoRepository r4 = com.xjsd.ai.assistant.phone.vui.todo.TodoRepository.f8656a
                com.xjsd.ai.assistant.phone.vui.todo.TodoEntry[] r5 = new com.xjsd.ai.assistant.phone.vui.todo.TodoEntry[]{r5}
                r0.label = r2
                java.lang.Object r4 = r4.f(r5, r0)
                if (r4 != r6) goto L_0x0043
                return r6
            L_0x0043:
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                if (r4 == 0) goto L_0x005e
                com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r4 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
                r4.<init>()
                com.xjsd.ai.assistant.template.TtsTodoTemplate r5 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO03_R02
                com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r4 = r4.e(r5)
                com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r4 = r4.a()
                r4.c()
                goto L_0x0070
            L_0x005e:
                com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r4 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
                r4.<init>()
                com.xjsd.ai.assistant.template.TtsTodoTemplate r5 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO03_R01
                com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r4 = r4.e(r5)
                com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r4 = r4.a()
                r4.c()
            L_0x0070:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.todo.TodoVuiHandler.Companion.c(com.xjsd.ai.assistant.phone.vui.todo.TodoEntry, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final void d(String str) {
            TodoVuiHandler.c = str;
            if (str != null) {
                ILog.a("TodoVuiHandler", "修改待办状态为->" + str);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0092  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object e(com.xjsd.ai.assistant.phone.vui.todo.TodoEntry r5, kotlin.coroutines.Continuation r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion$updateTodo$1
                if (r0 == 0) goto L_0x0013
                r0 = r6
                com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion$updateTodo$1 r0 = (com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion$updateTodo$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion$updateTodo$1 r0 = new com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion$updateTodo$1
                r0.<init>(r4, r6)
            L_0x0018:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L_0x0035
                if (r2 != r3) goto L_0x002d
                java.lang.Object r4 = r0.L$0
                com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion r4 = (com.xjsd.ai.assistant.skill.todo.TodoVuiHandler.Companion) r4
                kotlin.ResultKt.throwOnFailure(r6)
                goto L_0x0077
            L_0x002d:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L_0x0035:
                kotlin.ResultKt.throwOnFailure(r6)
                java.lang.String r6 = com.xjsd.ai.assistant.skill.todo.TodoVuiHandler.c
                boolean r2 = android.text.TextUtils.isEmpty(r6)
                if (r2 == 0) goto L_0x005d
                com.xjsd.ai.assistant.skill.todo.TodoVuiHandler.d = r5
                com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r4 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
                r4.<init>()
                com.xjsd.ai.assistant.template.TtsTodoTemplate r5 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO04_R07
                com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r4 = r4.e(r5)
                r5 = 2
                com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$PhoneTts r4 = r4.g(r5)
                com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r4 = r4.a()
                r4.c()
                goto L_0x00a8
            L_0x005d:
                java.lang.String r2 = "completed"
                boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r6)
                r5.setCompleted(r6)
                com.xjsd.ai.assistant.phone.vui.todo.TodoRepository r6 = com.xjsd.ai.assistant.phone.vui.todo.TodoRepository.f8656a
                com.xjsd.ai.assistant.phone.vui.todo.TodoEntry[] r5 = new com.xjsd.ai.assistant.phone.vui.todo.TodoEntry[]{r5}
                r0.L$0 = r4
                r0.label = r3
                java.lang.Object r6 = r6.o(r5, r0)
                if (r6 != r1) goto L_0x0077
                return r1
            L_0x0077:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r5 = r6.booleanValue()
                if (r5 == 0) goto L_0x0092
                com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
                r5.<init>()
                com.xjsd.ai.assistant.template.TtsTodoTemplate r6 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO04_R02
                com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r5 = r5.e(r6)
                com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = r5.a()
                r5.c()
                goto L_0x00a4
            L_0x0092:
                com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
                r5.<init>()
                com.xjsd.ai.assistant.template.TtsTodoTemplate r6 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO04_R01
                com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r5 = r5.e(r6)
                com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r5 = r5.a()
                r5.c()
            L_0x00a4:
                r5 = 0
                r4.d(r5)
            L_0x00a8:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.todo.TodoVuiHandler.Companion.e(com.xjsd.ai.assistant.phone.vui.todo.TodoEntry, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public Companion() {
        }
    }

    public TodoVuiHandler() {
        HashSet hashSet = new HashSet();
        this.f8703a = hashSet;
        EventBus.c().o(this);
        hashSet.add("create");
        hashSet.add("delete");
        hashSet.add("update");
        hashSet.add("select");
        hashSet.add("complete");
    }

    public boolean a(VuiModel vuiModel) {
        Intrinsics.checkNotNullParameter(vuiModel, "model");
        ILog.a("TodoVuiHandler", "handle: 待办垂域数据->" + vuiModel);
        p(false);
        if (!DeviceUtils.b() || NewFunctionCompact.c()) {
            String name = vuiModel.getHeader().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
            String lowerCase = name.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!this.f8703a.contains(lowerCase)) {
                return false;
            }
            String string = vuiModel.getPayload().getString("index");
            if (string == null || StringsKt.isBlank(string)) {
                Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new TodoVuiHandler$handle$1(this, vuiModel, (Continuation<? super TodoVuiHandler$handle$1>) null), 3, (Object) null);
                return true;
            }
            ILog.a("TodoVuiHandler", "handle: 多伦操作发给眼镜执行，index->" + string);
            return false;
        }
        UnSupportFeatureManager.f8414a.c();
        return true;
    }

    public String getHandleType() {
        return VuiModelType.TODO;
    }

    public final String i(Date date) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final String j(Date date, String str) {
        String format = new SimpleDateFormat(str).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x029e, code lost:
        r1 = (java.util.List) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02a4, code lost:
        if (r1.isEmpty() == false) goto L_0x02b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02a6, code lost:
        new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder().e(com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO03_R06).a().c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02bd, code lost:
        if (r1.size() != 1) goto L_0x02d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02bf, code lost:
        r7.L$0 = null;
        r7.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02d2, code lost:
        if (b.c((com.xjsd.ai.assistant.phone.vui.todo.TodoEntry) r1.get(0), r7) != r8) goto L_0x02fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02d4, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x02d5, code lost:
        r0.o(1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02f6, code lost:
        com.xjsd.ai.assistant.common.UnSupportFeatureManager.f8414a.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02fd, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0316, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0157, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0172, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01ae, code lost:
        r1 = (java.util.List) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01b4, code lost:
        if (r1.isEmpty() == false) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01b8, code lost:
        if (com.xjsd.ai.assistant.phone.VoiceAssistantApi.isOversea == false) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01ba, code lost:
        new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder().e(com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO01_R03).o(r5).a().c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01d6, code lost:
        new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder().e(com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO01_R03).o(r5).k(io.netty.handler.codec.rtsp.RtspHeaders.Values.TIME, r5).a().c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01f6, code lost:
        r2 = java.lang.String.valueOf(r1.size());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0202, code lost:
        if (com.xjsd.ai.assistant.phone.VoiceAssistantApi.isOversea == false) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0208, code lost:
        if (r1.size() != 1) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x020a, code lost:
        new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder().e(com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO01_R04).g(2).a().c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0222, code lost:
        new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder().e(com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO01_R02).o(r2).k("num", r2).g(2).a().c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0245, code lost:
        new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder().e(com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO01_R02).o(r5, r2).k(io.netty.handler.codec.rtsp.RtspHeaders.Values.TIME, r5).k("num", r2).g(2).a().c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x026c, code lost:
        r0.o(3, r1);
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k(com.xjsd.ai.assistant.protocol.VuiModel r23, kotlin.coroutines.Continuation r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            boolean r2 = r1 instanceof com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$handleByPhone$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$handleByPhone$1 r2 = (com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$handleByPhone$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0018
            int r3 = r3 - r4
            r2.label = r3
        L_0x0016:
            r7 = r2
            goto L_0x001e
        L_0x0018:
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$handleByPhone$1 r2 = new com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$handleByPhone$1
            r2.<init>(r0, r1)
            goto L_0x0016
        L_0x001e:
            java.lang.Object r1 = r7.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r4 = 0
            java.lang.String r6 = "time"
            r9 = 2
            r10 = 1
            switch(r2) {
                case 0: goto L_0x0063;
                case 1: goto L_0x005e;
                case 2: goto L_0x0059;
                case 3: goto L_0x0050;
                case 4: goto L_0x004b;
                case 5: goto L_0x0046;
                case 6: goto L_0x0037;
                default: goto L_0x002f;
            }
        L_0x002f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0037:
            java.lang.Object r0 = r7.L$1
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r2 = r7.L$0
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler r2 = (com.xjsd.ai.assistant.skill.todo.TodoVuiHandler) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r5 = r0
            r0 = r2
            goto L_0x01ae
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0170
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x02fb
        L_0x0050:
            java.lang.Object r0 = r7.L$0
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler r0 = (com.xjsd.ai.assistant.skill.todo.TodoVuiHandler) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x029e
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0314
        L_0x005e:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0155
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.xjsd.ai.assistant.protocol.vui.Header r1 = r23.getHeader()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "getName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r1 = r1.toLowerCase()
            java.lang.String r2 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.alibaba.fastjson.JSONObject r2 = r23.getPayload()
            java.lang.String r11 = r2.getString(r6)
            java.lang.String r12 = ""
            if (r11 != 0) goto L_0x008a
            r11 = r12
        L_0x008a:
            java.lang.String r13 = "invalid"
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x00ab
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r0.<init>()
            com.xjsd.ai.assistant.template.TtsCalTemplate r1 = com.xjsd.ai.assistant.template.TtsCalTemplate.CAL02_R03
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r0 = r0.e(r1)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$PhoneTts r0 = r0.g(r9)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = r0.a()
            r0.c()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00ab:
            java.lang.String r13 = "query"
            java.lang.String r19 = r2.getString(r13)
            java.lang.String r13 = "target"
            java.lang.String r13 = r2.getString(r13)
            if (r13 != 0) goto L_0x00bd
            r20 = r12
            goto L_0x00bf
        L_0x00bd:
            r20 = r13
        L_0x00bf:
            java.lang.String r13 = "time_text"
            java.lang.String r13 = r2.getString(r13)
            if (r13 != 0) goto L_0x00ca
            r15 = r12
            goto L_0x00cb
        L_0x00ca:
            r15 = r13
        L_0x00cb:
            int r13 = r11.length()
            if (r13 <= 0) goto L_0x010e
            java.lang.String r13 = "past"
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r13)
            if (r13 != 0) goto L_0x010e
            java.lang.String r13 = ","
            java.lang.String[] r14 = new java.lang.String[]{r13}
            r17 = 6
            r18 = 0
            r16 = 0
            r21 = 0
            r13 = r11
            r5 = r15
            r15 = r16
            r16 = r21
            java.util.List r13 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r13, (java.lang.String[]) r14, (boolean) r15, (int) r16, (int) r17, (java.lang.Object) r18)
            java.lang.Object r14 = r13.get(r4)
            java.lang.String r14 = (java.lang.String) r14
            java.util.Date r14 = r0.q(r14)
            int r15 = r13.size()
            if (r15 <= r10) goto L_0x010c
            java.lang.Object r13 = r13.get(r10)
            java.lang.String r13 = (java.lang.String) r13
            java.util.Date r13 = r0.q(r13)
            goto L_0x0111
        L_0x010c:
            r13 = 0
            goto L_0x0111
        L_0x010e:
            r5 = r15
            r13 = 0
            r14 = 0
        L_0x0111:
            int r15 = r1.hashCode()
            java.lang.String r4 = "status"
            java.lang.String r3 = "completed"
            switch(r15) {
                case -1352294148: goto L_0x02ee;
                case -1335458389: goto L_0x0271;
                case -906021636: goto L_0x0173;
                case -838846263: goto L_0x0158;
                case -599445191: goto L_0x011f;
                default: goto L_0x011d;
            }
        L_0x011d:
            goto L_0x02f6
        L_0x011f:
            java.lang.String r0 = "complete"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0129
            goto L_0x02f6
        L_0x0129:
            com.xjsd.ai.assistant.phone.vui.todo.TodoEntry r0 = d
            if (r0 != 0) goto L_0x0134
            com.xjsd.ai.assistant.common.UnSupportFeatureManager r0 = com.xjsd.ai.assistant.common.UnSupportFeatureManager.f8414a
            r0.c()
            goto L_0x02fb
        L_0x0134:
            java.lang.String r1 = "confirm"
            java.lang.String r1 = r2.getString(r1)
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion r2 = b
            java.lang.String r4 = "yes"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
            if (r1 == 0) goto L_0x0146
            goto L_0x0149
        L_0x0146:
            java.lang.String r3 = "uncompleted"
        L_0x0149:
            r2.d(r3)
            r7.label = r10
            java.lang.Object r0 = r2.e(r0, r7)
            if (r0 != r8) goto L_0x0155
            return r8
        L_0x0155:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0158:
            java.lang.String r3 = "update"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0163
            goto L_0x02f6
        L_0x0163:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r1 = 5
            r7.label = r1
            java.lang.Object r0 = r0.m(r5, r2, r7)
            if (r0 != r8) goto L_0x0170
            return r8
        L_0x0170:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0173:
            java.lang.String r11 = "select"
            boolean r1 = r1.equals(r11)
            if (r1 != 0) goto L_0x017d
            goto L_0x02f6
        L_0x017d:
            java.lang.String r1 = r2.getString(r4)
            if (r1 != 0) goto L_0x0184
            goto L_0x0185
        L_0x0184:
            r12 = r1
        L_0x0185:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x01a0
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r0.<init>()
            com.xjsd.ai.assistant.template.TtsTodoTemplate r1 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO03_R07
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r0 = r0.e(r1)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = r0.a()
            r0.c()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x01a0:
            r7.L$0 = r0
            r7.L$1 = r5
            r1 = 6
            r7.label = r1
            java.lang.Object r1 = r0.n(r14, r13, r7)
            if (r1 != r8) goto L_0x01ae
            return r8
        L_0x01ae:
            java.util.List r1 = (java.util.List) r1
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x01f6
            boolean r0 = com.xjsd.ai.assistant.phone.VoiceAssistantApi.isOversea
            if (r0 == 0) goto L_0x01d6
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r0.<init>()
            com.xjsd.ai.assistant.template.TtsTodoTemplate r1 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO01_R03
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r0 = r0.e(r1)
            java.lang.String[] r1 = new java.lang.String[]{r5}
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r0 = r0.o(r1)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = r0.a()
            r0.c()
            goto L_0x02fb
        L_0x01d6:
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r0.<init>()
            com.xjsd.ai.assistant.template.TtsTodoTemplate r1 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO01_R03
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r0 = r0.e(r1)
            java.lang.String[] r1 = new java.lang.String[]{r5}
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r0 = r0.o(r1)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r0 = r0.k(r6, r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = r0.a()
            r0.c()
            goto L_0x02fb
        L_0x01f6:
            int r2 = r1.size()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            boolean r3 = com.xjsd.ai.assistant.phone.VoiceAssistantApi.isOversea
            java.lang.String r4 = "num"
            if (r3 == 0) goto L_0x0245
            int r3 = r1.size()
            if (r3 != r10) goto L_0x0222
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r2 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r2.<init>()
            com.xjsd.ai.assistant.template.TtsTodoTemplate r3 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO01_R04
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r2 = r2.e(r3)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$PhoneTts r2 = r2.g(r9)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r2 = r2.a()
            r2.c()
        L_0x0220:
            r2 = 3
            goto L_0x026c
        L_0x0222:
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r3 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r3.<init>()
            com.xjsd.ai.assistant.template.TtsTodoTemplate r5 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO01_R02
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r3 = r3.e(r5)
            java.lang.String[] r5 = new java.lang.String[]{r2}
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r3 = r3.o(r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r2 = r3.k(r4, r2)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$PhoneTts r2 = r2.g(r9)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r2 = r2.a()
            r2.c()
            goto L_0x0220
        L_0x0245:
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r3 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r3.<init>()
            com.xjsd.ai.assistant.template.TtsTodoTemplate r7 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO01_R02
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r3 = r3.e(r7)
            java.lang.String[] r7 = new java.lang.String[]{r5, r2}
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r3 = r3.o(r7)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r3 = r3.k(r6, r5)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r2 = r3.k(r4, r2)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$PhoneTts r2 = r2.g(r9)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r2 = r2.a()
            r2.c()
            goto L_0x0220
        L_0x026c:
            r0.o(r2, r1)
            goto L_0x02fb
        L_0x0271:
            java.lang.String r5 = "delete"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x027b
            goto L_0x02f6
        L_0x027b:
            java.lang.String r1 = r2.getString(r4)
            if (r1 != 0) goto L_0x0282
            goto L_0x0283
        L_0x0282:
            r12 = r1
        L_0x0283:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r3)
            if (r1 != 0) goto L_0x02d9
            java.lang.String r1 = "all"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0292
            goto L_0x02d9
        L_0x0292:
            r7.L$0 = r0
            r1 = 3
            r7.label = r1
            java.lang.Object r1 = r0.n(r14, r13, r7)
            if (r1 != r8) goto L_0x029e
            return r8
        L_0x029e:
            java.util.List r1 = (java.util.List) r1
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x02b9
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r0.<init>()
            com.xjsd.ai.assistant.template.TtsTodoTemplate r1 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO03_R06
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r0 = r0.e(r1)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = r0.a()
            r0.c()
            goto L_0x02fb
        L_0x02b9:
            int r2 = r1.size()
            if (r2 != r10) goto L_0x02d5
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion r0 = b
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.xjsd.ai.assistant.phone.vui.todo.TodoEntry r1 = (com.xjsd.ai.assistant.phone.vui.todo.TodoEntry) r1
            r2 = 0
            r7.L$0 = r2
            r2 = 4
            r7.label = r2
            java.lang.Object r0 = r0.c(r1, r7)
            if (r0 != r8) goto L_0x02fb
            return r8
        L_0x02d5:
            r0.o(r10, r1)
            goto L_0x02fb
        L_0x02d9:
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r0.<init>()
            com.xjsd.ai.assistant.template.TtsTodoTemplate r1 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO03_R07
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r0 = r0.e(r1)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = r0.a()
            r0.c()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x02ee:
            java.lang.String r2 = "create"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x02fe
        L_0x02f6:
            com.xjsd.ai.assistant.common.UnSupportFeatureManager r0 = com.xjsd.ai.assistant.common.UnSupportFeatureManager.f8414a
            r0.c()
        L_0x02fb:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x02fe:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r19)
            r7.label = r9
            r0 = r22
            r1 = r20
            r2 = r14
            r3 = r13
            r4 = r5
            r5 = r11
            r6 = r19
            java.lang.Object r0 = r0.l(r1, r2, r3, r4, r5, r6, r7)
            if (r0 != r8) goto L_0x0314
            return r8
        L_0x0314:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.todo.TodoVuiHandler.k(com.xjsd.ai.assistant.protocol.VuiModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object l(java.lang.String r25, java.util.Date r26, java.util.Date r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, kotlin.coroutines.Continuation r31) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r6 = r26
            r7 = r27
            r2 = r31
            boolean r3 = r2 instanceof com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$handleCreateTodo$1
            if (r3 == 0) goto L_0x001e
            r3 = r2
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$handleCreateTodo$1 r3 = (com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$handleCreateTodo$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = r4 & r5
            if (r8 == 0) goto L_0x001e
            int r4 = r4 - r5
            r3.label = r4
        L_0x001c:
            r15 = r3
            goto L_0x0024
        L_0x001e:
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$handleCreateTodo$1 r3 = new com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$handleCreateTodo$1
            r3.<init>(r0, r2)
            goto L_0x001c
        L_0x0024:
            java.lang.Object r2 = r15.result
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r15.label
            r13 = 2
            java.lang.String r12 = "TodoVuiHandler"
            r11 = 1
            if (r3 == 0) goto L_0x004d
            if (r3 != r11) goto L_0x0045
            java.lang.Object r0 = r15.L$1
            com.xjsd.ai.assistant.phone.vui.todo.TodoEntry r0 = (com.xjsd.ai.assistant.phone.vui.todo.TodoEntry) r0
            java.lang.Object r1 = r15.L$0
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler r1 = (com.xjsd.ai.assistant.skill.todo.TodoVuiHandler) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r4 = r0
            r0 = r1
            r1 = r2
            r2 = r12
            goto L_0x01df
        L_0x0045:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r2)
            int r2 = r25.length()
            if (r2 != 0) goto L_0x0072
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r1 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r1.<init>()
            com.xjsd.ai.assistant.template.TtsTodoTemplate r2 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO02_R03
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r1 = r1.e(r2)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$PhoneTts r1 = r1.g(r13)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r1 = r1.a()
            r1.c()
            r0.p(r11)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0072:
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            if (r6 != 0) goto L_0x007c
        L_0x0079:
            r4 = r1
            goto L_0x0166
        L_0x007c:
            java.lang.String r3 = "MM/dd HH:mm"
            java.lang.String r4 = " "
            if (r7 != 0) goto L_0x0099
            java.lang.String r3 = r0.j(r6, r3)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r4)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            goto L_0x0079
        L_0x0099:
            int r5 = r26.getYear()
            int r8 = r27.getYear()
            java.lang.String r9 = "-"
            if (r5 == r8) goto L_0x00c9
            java.lang.String r3 = "yyyy/MM/dd HH:mm"
            java.lang.String r5 = r0.j(r6, r3)
            java.lang.String r3 = r0.j(r7, r3)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            r8.append(r9)
            r8.append(r3)
            r8.append(r4)
            r8.append(r1)
            java.lang.String r1 = r8.toString()
            goto L_0x0079
        L_0x00c9:
            int r5 = r26.getMonth()
            int r8 = r27.getMonth()
            if (r5 != r8) goto L_0x0144
            int r5 = r26.getDate()
            int r8 = r27.getDate()
            if (r5 == r8) goto L_0x00de
            goto L_0x0144
        L_0x00de:
            int r5 = r26.getHours()
            int r8 = r27.getHours()
            java.lang.String r10 = "HH:mm"
            if (r5 != r8) goto L_0x0122
            java.lang.String r5 = "mm:ss"
            java.lang.String r5 = r0.j(r7, r5)
            java.lang.String r8 = "59:59"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r8)
            if (r5 == 0) goto L_0x0122
            int r5 = r27.getSeconds()
            int r5 = r5 + r11
            r7.setSeconds(r5)
            java.lang.String r3 = r0.j(r6, r3)
            java.lang.String r5 = r0.j(r7, r10)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r3)
            r8.append(r9)
            r8.append(r5)
            r8.append(r4)
            r8.append(r1)
            java.lang.String r1 = r8.toString()
            goto L_0x0079
        L_0x0122:
            java.lang.String r3 = r0.j(r6, r3)
            java.lang.String r5 = r0.j(r7, r10)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r3)
            r8.append(r9)
            r8.append(r5)
            r8.append(r4)
            r8.append(r1)
            java.lang.String r1 = r8.toString()
            goto L_0x0079
        L_0x0144:
            java.lang.String r5 = r0.j(r6, r3)
            java.lang.String r3 = r0.j(r7, r3)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            r8.append(r9)
            r8.append(r3)
            r8.append(r4)
            r8.append(r1)
            java.lang.String r1 = r8.toString()
            goto L_0x0079
        L_0x0166:
            java.lang.String r16 = r0.i(r2)
            com.xjsd.ai.assistant.phone.vui.todo.TodoEntry r10 = new com.xjsd.ai.assistant.phone.vui.todo.TodoEntry
            r17 = 1
            r18 = 0
            r2 = 0
            r5 = 0
            java.lang.String r19 = ""
            java.lang.String r20 = ""
            r1 = r10
            r6 = r26
            r7 = r27
            r8 = r29
            r9 = r28
            r25 = r10
            r10 = r30
            r11 = r16
            r21 = r12
            r12 = r19
            r13 = r20
            r22 = r14
            r14 = r17
            r23 = r15
            r15 = r18
            r1.<init>(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            java.lang.String r1 = com.xjsd.ai.assistant.json.GsonUtils.e(r25)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "handle: 插入待办->"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r2 = r21
            com.xjsd.ai.assistant.log.ILog.a(r2, r1)
            java.lang.String r1 = r25.getTodoContent()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "handle: 待办详情->"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.xjsd.ai.assistant.log.ILog.a(r2, r1)
            com.xjsd.ai.assistant.phone.vui.todo.TodoRepository r1 = com.xjsd.ai.assistant.phone.vui.todo.TodoRepository.f8656a
            r3 = r23
            r3.L$0 = r0
            r4 = r25
            r3.L$1 = r4
            r5 = 1
            r3.label = r5
            java.lang.Object r1 = r1.e(r4, r3)
            r3 = r22
            if (r1 != r3) goto L_0x01df
            return r3
        L_0x01df:
            java.lang.Number r1 = (java.lang.Number) r1
            long r5 = r1.longValue()
            r7 = -1
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0227
            java.lang.String r1 = com.xjsd.ai.assistant.json.GsonUtils.e(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "handle: 插入数据库后待办->"
            r3.append(r5)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.xjsd.ai.assistant.log.ILog.a(r2, r1)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r1 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r1.<init>()
            com.xjsd.ai.assistant.template.TtsTodoTemplate r2 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO02_R01
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r1 = r1.e(r2)
            r2 = 2
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$PhoneTts r1 = r1.g(r2)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r1 = r1.a()
            r1.c()
            com.xjsd.ai.assistant.phone.vui.todo.TodoEntry[] r1 = new com.xjsd.ai.assistant.phone.vui.todo.TodoEntry[]{r4}
            java.util.ArrayList r1 = kotlin.collections.CollectionsKt.arrayListOf(r1)
            r2 = 0
            r0.o(r2, r1)
            goto L_0x0239
        L_0x0227:
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r0.<init>()
            com.xjsd.ai.assistant.template.TtsTodoTemplate r1 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO02_R02
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r0 = r0.e(r1)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = r0.a()
            r0.c()
        L_0x0239:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.todo.TodoVuiHandler.l(java.lang.String, java.util.Date, java.util.Date, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m(java.lang.String r19, com.alibaba.fastjson.JSONObject r20, kotlin.coroutines.Continuation r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r21
            boolean r3 = r2 instanceof com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$handleUpdateTodo$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$handleUpdateTodo$1 r3 = (com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$handleUpdateTodo$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001e
        L_0x0019:
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$handleUpdateTodo$1 r3 = new com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$handleUpdateTodo$1
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 2
            r8 = 0
            r9 = 1
            if (r5 == 0) goto L_0x0050
            if (r5 == r9) goto L_0x003d
            if (r5 != r7) goto L_0x0035
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0178
        L_0x0035:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003d:
            java.lang.Object r0 = r3.L$1
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r3.L$0
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler r1 = (com.xjsd.ai.assistant.skill.todo.TodoVuiHandler) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r17 = r2
            r2 = r0
            r0 = r1
            r1 = r17
            goto L_0x010e
        L_0x0050:
            kotlin.ResultKt.throwOnFailure(r2)
            java.lang.String r2 = "status"
            java.lang.String r2 = r1.getString(r2)
            java.lang.String r5 = "invalid"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r10 == 0) goto L_0x0077
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r0.<init>()
            com.xjsd.ai.assistant.template.TtsTodoTemplate r1 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO03_R07
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r0 = r0.e(r1)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = r0.a()
            r0.c()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0077:
            java.lang.String r10 = "target"
            java.lang.String r10 = r1.getString(r10)
            java.lang.String r11 = "time"
            java.lang.String r11 = r1.getString(r11)
            if (r2 == 0) goto L_0x008d
            boolean r12 = kotlin.text.StringsKt.isBlank(r2)
            if (r12 == 0) goto L_0x00b3
        L_0x008d:
            if (r10 == 0) goto L_0x0095
            boolean r10 = kotlin.text.StringsKt.isBlank(r10)
            if (r10 == 0) goto L_0x009e
        L_0x0095:
            if (r11 == 0) goto L_0x00b3
            boolean r10 = kotlin.text.StringsKt.isBlank(r11)
            if (r10 == 0) goto L_0x009e
            goto L_0x00b3
        L_0x009e:
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r0.<init>()
            com.xjsd.ai.assistant.template.TtsTodoTemplate r1 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO03_R07
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r0 = r0.e(r1)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = r0.a()
            r0.c()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00b3:
            java.lang.String r10 = "old_time"
            java.lang.String r11 = r1.getString(r10)
            if (r11 == 0) goto L_0x00ff
            boolean r1 = kotlin.text.StringsKt.isBlank(r11)
            if (r1 == 0) goto L_0x00c2
            goto L_0x00ff
        L_0x00c2:
            java.lang.String r1 = "past"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r1)
            if (r1 != 0) goto L_0x00ff
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r5)
            if (r1 != 0) goto L_0x00ff
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            java.lang.String r1 = ","
            java.lang.String[] r12 = new java.lang.String[]{r1}
            r15 = 6
            r16 = 0
            r13 = 0
            r14 = 0
            java.util.List r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r11, (java.lang.String[]) r12, (boolean) r13, (int) r14, (int) r15, (java.lang.Object) r16)
            java.lang.Object r5 = r1.get(r6)
            java.lang.String r5 = (java.lang.String) r5
            java.util.Date r5 = r0.q(r5)
            int r10 = r1.size()
            if (r10 <= r9) goto L_0x00fd
            java.lang.Object r1 = r1.get(r9)
            java.lang.String r1 = (java.lang.String) r1
            java.util.Date r1 = r0.q(r1)
            goto L_0x0101
        L_0x00fd:
            r1 = r8
            goto L_0x0101
        L_0x00ff:
            r1 = r8
            r5 = r1
        L_0x0101:
            r3.L$0 = r0
            r3.L$1 = r2
            r3.label = r9
            java.lang.Object r1 = r0.n(r5, r1, r3)
            if (r1 != r4) goto L_0x010e
            return r4
        L_0x010e:
            java.util.List r1 = (java.util.List) r1
            boolean r5 = r1.isEmpty()
            if (r5 == 0) goto L_0x0129
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r0.<init>()
            com.xjsd.ai.assistant.template.TtsTodoTemplate r1 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO03_R06
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r0 = r0.e(r1)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = r0.a()
            r0.c()
            goto L_0x0178
        L_0x0129:
            int r5 = r1.size()
            if (r5 != r9) goto L_0x016f
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x0157
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = new com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder
            r0.<init>()
            com.xjsd.ai.assistant.template.TtsTodoTemplate r2 = com.xjsd.ai.assistant.template.TtsTodoTemplate.TODO04_R07
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$TemplateTts r0 = r0.e(r2)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder$PhoneTts r0 = r0.g(r7)
            com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder r0 = r0.a()
            r0.c()
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion r0 = b
            java.lang.Object r1 = r1.get(r6)
            com.xjsd.ai.assistant.phone.vui.todo.TodoEntry r1 = (com.xjsd.ai.assistant.phone.vui.todo.TodoEntry) r1
            r0.b(r1)
            goto L_0x0178
        L_0x0157:
            java.lang.Object r0 = r1.get(r6)
            com.xjsd.ai.assistant.phone.vui.todo.TodoEntry r0 = (com.xjsd.ai.assistant.phone.vui.todo.TodoEntry) r0
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion r1 = b
            r1.d(r2)
            r3.L$0 = r8
            r3.L$1 = r8
            r3.label = r7
            java.lang.Object r0 = r1.e(r0, r3)
            if (r0 != r4) goto L_0x0178
            return r4
        L_0x016f:
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$Companion r3 = b
            r3.d(r2)
            r2 = 5
            r0.o(r2, r1)
        L_0x0178:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.todo.TodoVuiHandler.m(java.lang.String, com.alibaba.fastjson.JSONObject, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.util.Date r6, java.util.Date r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$queryTodoListFromRepo$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$queryTodoListFromRepo$1 r0 = (com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$queryTodoListFromRepo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$queryTodoListFromRepo$1 r0 = new com.xjsd.ai.assistant.skill.todo.TodoVuiHandler$queryTodoListFromRepo$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x003f
            if (r1 == r4) goto L_0x003b
            if (r1 == r3) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x006d
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x005f
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004f
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r5)
            if (r6 != 0) goto L_0x0052
            com.xjsd.ai.assistant.phone.vui.todo.TodoRepository r5 = com.xjsd.ai.assistant.phone.vui.todo.TodoRepository.f8656a
            r0.label = r4
            java.lang.Object r5 = r5.g(r0)
            if (r5 != r8) goto L_0x004f
            return r8
        L_0x004f:
            java.util.List r5 = (java.util.List) r5
            goto L_0x006f
        L_0x0052:
            if (r7 != 0) goto L_0x0062
            com.xjsd.ai.assistant.phone.vui.todo.TodoRepository r5 = com.xjsd.ai.assistant.phone.vui.todo.TodoRepository.f8656a
            r0.label = r3
            java.lang.Object r5 = r5.i(r6, r0)
            if (r5 != r8) goto L_0x005f
            return r8
        L_0x005f:
            java.util.List r5 = (java.util.List) r5
            goto L_0x006f
        L_0x0062:
            com.xjsd.ai.assistant.phone.vui.todo.TodoRepository r5 = com.xjsd.ai.assistant.phone.vui.todo.TodoRepository.f8656a
            r0.label = r2
            java.lang.Object r5 = r5.h(r6, r7, r0)
            if (r5 != r8) goto L_0x006d
            return r8
        L_0x006d:
            java.util.List r5 = (java.util.List) r5
        L_0x006f:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x0078:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0090
            java.lang.Object r7 = r5.next()
            r8 = r7
            com.xjsd.ai.assistant.phone.vui.todo.TodoEntry r8 = (com.xjsd.ai.assistant.phone.vui.todo.TodoEntry) r8
            boolean r8 = r8.getCompleted()
            r8 = r8 ^ r4
            if (r8 == 0) goto L_0x0078
            r6.add(r7)
            goto L_0x0078
        L_0x0090:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.skill.todo.TodoVuiHandler.n(java.util.Date, java.util.Date, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void o(int i, Object obj) {
        TodoBusinessData todoBusinessData = new TodoBusinessData(i);
        todoBusinessData.setPayload(obj);
        String e = GsonUtils.e(todoBusinessData);
        ILog.a("TodoVuiHandler", "sendBusinessData: 发送给眼镜的数据->" + e);
        Communicator.a(BusinessDataType.TODO, todoBusinessData, new TodoVuiHandler$sendBusinessData$1$1());
    }

    @Subscribe
    public final void onReceiveDomainChangeEvent(@NotNull DomainChangeEvent domainChangeEvent) {
        Intrinsics.checkNotNullParameter(domainChangeEvent, "event");
        if (Intrinsics.areEqual((Object) domainChangeEvent.b(), (Object) getHandleType()) && !Intrinsics.areEqual((Object) domainChangeEvent.a(), (Object) getHandleType())) {
            ILog.a("TodoVuiHandler", "onReceiveDomainChangeEvent: 跨域了，重置标记");
            p(false);
        }
    }

    @Subscribe
    public final void onReceiveUserAbortEvent(@NotNull UserAbortEvent userAbortEvent) {
        Intrinsics.checkNotNullParameter(userAbortEvent, "event");
        ILog.a("TodoVuiHandler", "onReceiveUserAbortEvent: clean cache data");
        d = null;
        b.d((String) null);
        p(false);
    }

    public final void p(boolean z) {
        CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
        if (cacheAbility != null) {
            cacheAbility.cache("todo_multi_wakeup", Boolean.valueOf(z));
        }
    }

    public final Date q(String str) {
        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        return parse;
    }
}
