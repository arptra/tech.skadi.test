package com.upuphone.ar.fastrecord.phone.starrynet.bean.phone;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/phone/RecordPhoneRequestPreStart;", "", "isOpen", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordPhoneRequestPreStart {
    private final boolean isOpen;

    public RecordPhoneRequestPreStart(boolean z) {
        this.isOpen = z;
    }

    public static /* synthetic */ RecordPhoneRequestPreStart copy$default(RecordPhoneRequestPreStart recordPhoneRequestPreStart, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = recordPhoneRequestPreStart.isOpen;
        }
        return recordPhoneRequestPreStart.copy(z);
    }

    public final boolean component1() {
        return this.isOpen;
    }

    @NotNull
    public final RecordPhoneRequestPreStart copy(boolean z) {
        return new RecordPhoneRequestPreStart(z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RecordPhoneRequestPreStart) && this.isOpen == ((RecordPhoneRequestPreStart) obj).isOpen;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isOpen);
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    @NotNull
    public String toString() {
        boolean z = this.isOpen;
        return "RecordPhoneRequestPreStart(isOpen=" + z + ")";
    }
}
