package io.ktor.utils.io;

import com.honey.account.i.a;
import io.ktor.utils.io.internal.ClosedElement;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nByteBufferChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteBufferChannel.kt\nio/ktor/utils/io/ByteBufferChannel$writeSuspension$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ByteBufferChannel.kt\nio/ktor/utils/io/ByteBufferChannel\n*L\n1#1,2411:1\n1#2:2412\n1#2:2416\n2341#3,3:2413\n2345#3,6:2417\n*S KotlinDebug\n*F\n+ 1 ByteBufferChannel.kt\nio/ktor/utils/io/ByteBufferChannel$writeSuspension$1\n*L\n2280#1:2416\n2280#1:2413,3\n2280#1:2417,6\n*E\n"})
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "ucont", "Lkotlin/coroutines/Continuation;", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ByteBufferChannel$writeSuspension$1 extends Lambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeSuspension$1(ByteBufferChannel byteBufferChannel) {
        super(1);
        this.this$0 = byteBufferChannel;
    }

    @NotNull
    public final Object invoke(@NotNull Continuation<? super Unit> continuation) {
        Throwable c;
        Intrinsics.checkNotNullParameter(continuation, "ucont");
        int Y = this.this$0.writeSuspensionSize;
        while (true) {
            ClosedElement V = this.this$0.O0();
            if (V != null && (c = V.c()) != null) {
                Void unused = ByteBufferChannelKt.b(c);
                throw new KotlinNothingValueException();
            } else if (!this.this$0.C2(Y)) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m20constructorimpl(Unit.INSTANCE));
                break;
            } else {
                ByteBufferChannel byteBufferChannel = this.this$0;
                Continuation<? super Unit> intercepted = IntrinsicsKt.intercepted(continuation);
                ByteBufferChannel byteBufferChannel2 = this.this$0;
                while (byteBufferChannel.U0() == null) {
                    if (byteBufferChannel2.C2(Y)) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ByteBufferChannel.p;
                        if (a.a(atomicReferenceFieldUpdater, byteBufferChannel, (Object) null, intercepted)) {
                            if (byteBufferChannel2.C2(Y) || !a.a(atomicReferenceFieldUpdater, byteBufferChannel, intercepted, (Object) null)) {
                                break;
                            }
                        }
                    }
                }
                throw new IllegalStateException("Operation is already in progress".toString());
            }
        }
        this.this$0.N0(Y);
        if (this.this$0.T1()) {
            this.this$0.L1();
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}
