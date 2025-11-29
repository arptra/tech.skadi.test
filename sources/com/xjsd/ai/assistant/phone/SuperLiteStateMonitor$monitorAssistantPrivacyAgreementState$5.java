package com.xjsd.ai.assistant.phone;

import com.xjsd.ai.assistant.phone.helper.AssistantProtocolHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "value", "", "d", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
public final class SuperLiteStateMonitor$monitorAssistantPrivacyAgreementState$5<T> implements FlowCollector {

    /* renamed from: a  reason: collision with root package name */
    public static final SuperLiteStateMonitor$monitorAssistantPrivacyAgreementState$5 f8533a = new SuperLiteStateMonitor$monitorAssistantPrivacyAgreementState$5();

    public final Object d(boolean z, Continuation continuation) {
        AssistantProtocolHelper.f8558a.b(z);
        return Unit.INSTANCE;
    }

    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return d(((Boolean) obj).booleanValue(), continuation);
    }
}
