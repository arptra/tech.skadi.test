package com.xjsd.ai.assistant.flutter.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/util/PcmEncodedData;", "", "()V", "ByteData", "FlagData", "Lcom/xjsd/ai/assistant/flutter/util/PcmEncodedData$ByteData;", "Lcom/xjsd/ai/assistant/flutter/util/PcmEncodedData$FlagData;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class PcmEncodedData {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/util/PcmEncodedData$ByteData;", "Lcom/xjsd/ai/assistant/flutter/util/PcmEncodedData;", "", "data", "<init>", "([B)V", "a", "[B", "()[B", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class ByteData extends PcmEncodedData {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f8496a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ByteData(byte[] bArr) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bArr, "data");
            this.f8496a = bArr;
        }

        public final byte[] a() {
            return this.f8496a;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/util/PcmEncodedData$FlagData;", "Lcom/xjsd/ai/assistant/flutter/util/PcmEncodedData;", "success", "", "(Z)V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FlagData extends PcmEncodedData {
        public FlagData(boolean z) {
            super((DefaultConstructorMarker) null);
        }
    }

    public /* synthetic */ PcmEncodedData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public PcmEncodedData() {
    }
}
