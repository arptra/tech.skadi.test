package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.xr.interconnect.common.IMessageSendListener;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/interconnect/business/messenger/RelayTask;", "", "identifier", "", "receiverDeviceId", "", "data", "", "listener", "Lcom/upuphone/xr/interconnect/common/IMessageSendListener;", "(ILjava/lang/String;[BLcom/upuphone/xr/interconnect/common/IMessageSendListener;)V", "getData", "()[B", "getIdentifier", "()I", "getListener", "()Lcom/upuphone/xr/interconnect/common/IMessageSendListener;", "getReceiverDeviceId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class RelayTask {
    @NotNull
    private final byte[] data;
    private final int identifier;
    @Nullable
    private final IMessageSendListener listener;
    @NotNull
    private final String receiverDeviceId;

    public RelayTask(int i, @NotNull String str, @NotNull byte[] bArr, @Nullable IMessageSendListener iMessageSendListener) {
        Intrinsics.checkNotNullParameter(str, "receiverDeviceId");
        Intrinsics.checkNotNullParameter(bArr, "data");
        this.identifier = i;
        this.receiverDeviceId = str;
        this.data = bArr;
        this.listener = iMessageSendListener;
    }

    public static /* synthetic */ RelayTask copy$default(RelayTask relayTask, int i, String str, byte[] bArr, IMessageSendListener iMessageSendListener, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = relayTask.identifier;
        }
        if ((i2 & 2) != 0) {
            str = relayTask.receiverDeviceId;
        }
        if ((i2 & 4) != 0) {
            bArr = relayTask.data;
        }
        if ((i2 & 8) != 0) {
            iMessageSendListener = relayTask.listener;
        }
        return relayTask.copy(i, str, bArr, iMessageSendListener);
    }

    public final int component1() {
        return this.identifier;
    }

    @NotNull
    public final String component2() {
        return this.receiverDeviceId;
    }

    @NotNull
    public final byte[] component3() {
        return this.data;
    }

    @Nullable
    public final IMessageSendListener component4() {
        return this.listener;
    }

    @NotNull
    public final RelayTask copy(int i, @NotNull String str, @NotNull byte[] bArr, @Nullable IMessageSendListener iMessageSendListener) {
        Intrinsics.checkNotNullParameter(str, "receiverDeviceId");
        Intrinsics.checkNotNullParameter(bArr, "data");
        return new RelayTask(i, str, bArr, iMessageSendListener);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RelayTask)) {
            return false;
        }
        RelayTask relayTask = (RelayTask) obj;
        return this.identifier == relayTask.identifier && Intrinsics.areEqual((Object) this.receiverDeviceId, (Object) relayTask.receiverDeviceId) && Intrinsics.areEqual((Object) this.data, (Object) relayTask.data) && Intrinsics.areEqual((Object) this.listener, (Object) relayTask.listener);
    }

    @NotNull
    public final byte[] getData() {
        return this.data;
    }

    public final int getIdentifier() {
        return this.identifier;
    }

    @Nullable
    public final IMessageSendListener getListener() {
        return this.listener;
    }

    @NotNull
    public final String getReceiverDeviceId() {
        return this.receiverDeviceId;
    }

    public int hashCode() {
        int hashCode = ((((Integer.hashCode(this.identifier) * 31) + this.receiverDeviceId.hashCode()) * 31) + Arrays.hashCode(this.data)) * 31;
        IMessageSendListener iMessageSendListener = this.listener;
        return hashCode + (iMessageSendListener == null ? 0 : iMessageSendListener.hashCode());
    }

    @NotNull
    public String toString() {
        int i = this.identifier;
        String str = this.receiverDeviceId;
        String arrays = Arrays.toString(this.data);
        IMessageSendListener iMessageSendListener = this.listener;
        return "RelayTask(identifier=" + i + ", receiverDeviceId=" + str + ", data=" + arrays + ", listener=" + iMessageSendListener + ")";
    }
}
