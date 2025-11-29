package com.upuphone.xr.sapp.audio;

import android.media.AudioRecord;
import com.upuphone.star.core.log.ULog;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AudioRecordChannel$startReadingThread$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AudioRecordChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AudioRecordChannel$startReadingThread$1(AudioRecordChannel audioRecordChannel) {
        super(0);
        this.this$0 = audioRecordChannel;
    }

    public final void invoke() {
        while (this.this$0.b && this.this$0.f6644a != null) {
            int d = this.this$0.c;
            byte[] bArr = new byte[d];
            try {
                AudioRecord b = this.this$0.f6644a;
                Intrinsics.checkNotNull(b);
                this.this$0.j(bArr, b.read(bArr, 0, d));
            } catch (Exception e) {
                ULog.Delegate delegate = ULog.f6446a;
                String stackTraceToString = ExceptionsKt.stackTraceToString(e);
                delegate.g("AudioRecordChannel", "读取录音数据异常！exception=" + stackTraceToString);
                this.this$0.h(3, 103);
                this.this$0.b = false;
                this.this$0.f6644a = null;
            }
        }
    }
}
