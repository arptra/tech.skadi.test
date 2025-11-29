package com.xjsd.ai.assistant.skill.todo;

import com.xjsd.ai.assistant.common.handler.BusinessHandler;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.protocol.BusinessData;
import com.xjsd.ai.assistant.protocol.BusinessDataType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/xjsd/ai/assistant/skill/todo/TodoBusinessHandler;", "Lcom/xjsd/ai/assistant/common/handler/BusinessHandler;", "<init>", "()V", "Lcom/xjsd/ai/assistant/protocol/BusinessDataType;", "getHandleType", "()Lcom/xjsd/ai/assistant/protocol/BusinessDataType;", "Lcom/xjsd/ai/assistant/protocol/BusinessData;", "businessData", "", "a", "(Lcom/xjsd/ai/assistant/protocol/BusinessData;)V", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TodoBusinessHandler implements BusinessHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8702a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/skill/todo/TodoBusinessHandler$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void a(BusinessData businessData) {
        Intrinsics.checkNotNullParameter(businessData, "businessData");
        String e = GsonUtils.e(businessData);
        ILog.a("TodoBusinessHandler", "handle: 处理待办业务数据->" + e);
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new TodoBusinessHandler$handle$1(businessData, (Continuation<? super TodoBusinessHandler$handle$1>) null), 3, (Object) null);
    }

    public BusinessDataType getHandleType() {
        return BusinessDataType.TODO;
    }
}
