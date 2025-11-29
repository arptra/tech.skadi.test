package com.upuphone.xr.interconnect.business.messenger.compat;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.xr.interconnect.entity.StarryNetMessageData;
import com.upuphone.xr.interconnect.util.StarryNetMessageConvertUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.log.PayloadLoggingKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u000026\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001j\u0002`\tB\u0005¢\u0006\u0002\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/interconnect/business/messenger/compat/Version1MessageConsumer;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "data", "", "logTag", "", "Lcom/upuphone/xr/interconnect/business/messenger/MessageConsumer;", "()V", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Version1MessageConsumer implements Function2<byte[], String, Unit> {
    @NotNull
    private final CoroutineScope mainScope = CoroutineScopeKt.a(Dispatchers.a());

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((byte[]) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public void invoke(@NotNull byte[] bArr, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        Intrinsics.checkNotNullParameter(str, "logTag");
        ILog.d(str, "Parsing message as version 1.");
        try {
            StarryNetMessageData parseFrom = StarryNetMessageData.parseFrom(bArr);
            int identifier = parseFrom.getIdentifier();
            String senderPkg = parseFrom.getSenderPkg();
            String receiverPkg = parseFrom.getReceiverPkg();
            ILog.d(str, "#" + identifier + " is from " + senderPkg + " to " + receiverPkg + ".");
            String message = parseFrom.getMessage();
            String str2 = null;
            String limitSizePrint = message != null ? PayloadLoggingKt.limitSizePrint(message) : null;
            ByteString data = parseFrom.getData();
            if (data != null) {
                str2 = PayloadLoggingKt.samplePrint(data);
            }
            ILog.v(str, "Content: " + limitSizePrint + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD + str2);
            MessagePetaStepSerializer.Companion.getInstance().serializeMsg("command msg", new Version1MessageConsumer$invoke$1$1(str, StarryNetMessageConvertUtil.convert(parseFrom)));
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            String localizedMessage = e.getLocalizedMessage();
            ILog.d(str, "Parsing as version 1 message failed: " + localizedMessage + ".");
        }
    }
}
