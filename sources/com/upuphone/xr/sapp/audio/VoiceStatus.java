package com.upuphone.xr.sapp.audio;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/audio/VoiceStatus;", "", "()V", "Data", "Wakeup", "Lcom/upuphone/xr/sapp/audio/VoiceStatus$Data;", "Lcom/upuphone/xr/sapp/audio/VoiceStatus$Wakeup;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class VoiceStatus {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/audio/VoiceStatus$Data;", "Lcom/upuphone/xr/sapp/audio/VoiceStatus;", "", "status", "", "bytes", "<init>", "(I[B)V", "a", "I", "getStatus", "()I", "b", "[B", "()[B", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Data extends VoiceStatus {

        /* renamed from: a  reason: collision with root package name */
        public final int f6646a;
        public final byte[] b;

        public Data(int i, byte[] bArr) {
            super((DefaultConstructorMarker) null);
            this.f6646a = i;
            this.b = bArr;
        }

        public final byte[] a() {
            return this.b;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/upuphone/xr/sapp/audio/VoiceStatus$Wakeup;", "Lcom/upuphone/xr/sapp/audio/VoiceStatus;", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Wakeup extends VoiceStatus {

        /* renamed from: a  reason: collision with root package name */
        public static final Wakeup f6647a = new Wakeup();

        public Wakeup() {
            super((DefaultConstructorMarker) null);
        }
    }

    public /* synthetic */ VoiceStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public VoiceStatus() {
    }
}
