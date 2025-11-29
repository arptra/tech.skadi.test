package com.upuphone.xr.interconnect.business.messenger;

import com.meizu.common.widget.MzContactsContract;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.main.dispatcher.MainDispatcher;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.log.PayloadLoggingKt;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class MessageTxProcessor$localSend$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ Integer $identifier;
    final /* synthetic */ IMessageSendListener $listener;
    final /* synthetic */ String $receiver;
    final /* synthetic */ String $sender;
    final /* synthetic */ String $text;
    final /* synthetic */ MessageTxProcessor this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor$localSend$1$2", f = "MessageTxProcessor.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor$localSend$1$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(messageTxProcessor, iMessageSendListener2, intValue, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.b(50, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ILog.i(messageTxProcessor.getTag(), "localSend onSuccess callback");
            IMessageSendListener iMessageSendListener = iMessageSendListener2;
            if (iMessageSendListener != null) {
                MessageTxProcessor messageTxProcessor = messageTxProcessor;
                final int i2 = intValue;
                messageTxProcessor.safeCall(iMessageSendListener, new Function1<IMessageSendListener, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((IMessageSendListener) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull IMessageSendListener iMessageSendListener) {
                        Intrinsics.checkNotNullParameter(iMessageSendListener, "$this$safeCall");
                        iMessageSendListener.onSuccess(String.valueOf(i2));
                    }
                });
            }
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageTxProcessor$localSend$1(Integer num, MessageTxProcessor messageTxProcessor, String str, String str2, IMessageSendListener iMessageSendListener, String str3, byte[] bArr) {
        super(0);
        this.$identifier = num;
        this.this$0 = messageTxProcessor;
        this.$sender = str;
        this.$receiver = str2;
        this.$listener = iMessageSendListener;
        this.$text = str3;
        this.$data = bArr;
    }

    public final void invoke() {
        Integer num = this.$identifier;
        final int intValue = num != null ? num.intValue() : this.this$0.getIdSource();
        String access$getTag = this.this$0.getTag();
        String str = this.$sender;
        String str2 = this.$receiver;
        IMessageSendListener iMessageSendListener = this.$listener;
        String stringify = iMessageSendListener != null ? PrettyPrintExtKt.stringify(iMessageSendListener) : null;
        ILog.d(access$getTag, "Sending local tx #" + intValue + " from " + str + " to " + str2 + " with " + stringify + ".");
        String access$getTag2 = this.this$0.getTag();
        String str3 = this.$text;
        String limitSizePrint = str3 != null ? PayloadLoggingKt.limitSizePrint(str3) : null;
        byte[] bArr = this.$data;
        String samplePrint = bArr != null ? PayloadLoggingKt.samplePrint(bArr) : null;
        ILog.v(access$getTag2, "Content local tx : " + limitSizePrint + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD + samplePrint + " ");
        MainDispatcher mainDispatcher = InterconnectManager.getInstance().getMainDispatcher();
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        String str4 = this.$sender;
        String str5 = this.$receiver;
        String str6 = this.$text;
        byte[] bArr2 = this.$data;
        starryNetMessage.setId(String.valueOf(intValue));
        starryNetMessage.setSenderPkg(str4);
        starryNetMessage.setReceiverPkg(str5);
        starryNetMessage.setMessage(str6);
        starryNetMessage.setData(bArr2);
        mainDispatcher.dispatch(starryNetMessage);
        CoroutineScope scope = PetaStepSerializer.Companion.getScope();
        final MessageTxProcessor messageTxProcessor = this.this$0;
        final IMessageSendListener iMessageSendListener2 = this.$listener;
        Job unused = BuildersKt__Builders_commonKt.d(scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2((Continuation<? super AnonymousClass2>) null), 3, (Object) null);
    }
}
