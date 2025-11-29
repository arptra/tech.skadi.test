package com.upuphone.xr.interconnect.business.messenger.compat;

import com.google.protobuf.ByteString;
import com.upuphone.xr.interconnect.entity.ConnectMsg;
import com.upuphone.xr.interconnect.entity.StarryNetMessageData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002y\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u0001j\u0002`\fB\u0005¢\u0006\u0002\u0010\rJ5\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/interconnect/business/messenger/compat/Version0MessageAdapter;", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "name", "identifier", "", "sender", "receiver", "text", "", "data", "Lcom/upuphone/xr/interconnect/business/messenger/MessageAdapter;", "()V", "invoke", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVersion0MessageAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Version0MessageAdapter.kt\ncom/upuphone/xr/interconnect/business/messenger/compat/Version0MessageAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,19:1\n1#2:20\n*E\n"})
public final class Version0MessageAdapter implements Function5<Integer, String, String, String, byte[], byte[]> {
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return invoke(((Number) obj).intValue(), (String) obj2, (String) obj3, (String) obj4, (byte[]) obj5);
    }

    @NotNull
    public byte[] invoke(int i, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "sender");
        Intrinsics.checkNotNullParameter(str2, "receiver");
        StarryNetMessageData.Builder newBuilder = StarryNetMessageData.newBuilder();
        newBuilder.setSenderPkg(str);
        newBuilder.setReceiverPkg(str2);
        if (str3 != null) {
            newBuilder.setMessage(str3);
        }
        if (bArr != null) {
            newBuilder.setData(ByteString.copyFrom(bArr));
        }
        byte[] byteArray = ((ConnectMsg) ConnectMsg.newBuilder().setData(((StarryNetMessageData) newBuilder.build()).toByteString()).build()).toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }
}
