package io.ktor.websocket.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a=\u0010\u000b\u001a\u00020\n*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\t\u001a\u00060\u0007j\u0002`\bH@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\r\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\t\u001a\u00060\u0007j\u0002`\bH@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/WebSocketSession;", "", "data", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "Lio/ktor/serialization/WebsocketContentConverter;", "converter", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "charset", "", "b", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websocket-serialization"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nWebsocketChannelSerialization.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebsocketChannelSerialization.kt\nio/ktor/websocket/serialization/WebsocketChannelSerializationKt\n+ 2 TypeInfoJvm.kt\nio/ktor/util/reflect/TypeInfoJvmKt\n*L\n1#1,124:1\n17#2,3:125\n17#2,3:128\n*S KotlinDebug\n*F\n+ 1 WebsocketChannelSerialization.kt\nio/ktor/websocket/serialization/WebsocketChannelSerializationKt\n*L\n29#1:125,3\n74#1:128,3\n*E\n"})
public final class WebsocketChannelSerializationKt {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0093 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(io.ktor.websocket.WebSocketSession r16, io.ktor.util.reflect.TypeInfo r17, io.ktor.serialization.WebsocketContentConverter r18, java.nio.charset.Charset r19, kotlin.coroutines.Continuation r20) {
        /*
            r0 = r20
            boolean r1 = r0 instanceof io.ktor.websocket.serialization.WebsocketChannelSerializationKt$receiveDeserializedBase$2
            if (r1 == 0) goto L_0x0015
            r1 = r0
            io.ktor.websocket.serialization.WebsocketChannelSerializationKt$receiveDeserializedBase$2 r1 = (io.ktor.websocket.serialization.WebsocketChannelSerializationKt$receiveDeserializedBase$2) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001a
        L_0x0015:
            io.ktor.websocket.serialization.WebsocketChannelSerializationKt$receiveDeserializedBase$2 r1 = new io.ktor.websocket.serialization.WebsocketChannelSerializationKt$receiveDeserializedBase$2
            r1.<init>(r0)
        L_0x001a:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            r5 = 2
            r6 = 1
            if (r3 == 0) goto L_0x0053
            if (r3 == r6) goto L_0x0040
            if (r3 != r5) goto L_0x0038
            java.lang.Object r2 = r1.L$1
            io.ktor.websocket.Frame r2 = (io.ktor.websocket.Frame) r2
            java.lang.Object r1 = r1.L$0
            io.ktor.util.reflect.TypeInfo r1 = (io.ktor.util.reflect.TypeInfo) r1
            kotlin.ResultKt.throwOnFailure(r0)
            r10 = r2
            goto L_0x0089
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0040:
            java.lang.Object r3 = r1.L$2
            java.nio.charset.Charset r3 = (java.nio.charset.Charset) r3
            java.lang.Object r7 = r1.L$1
            io.ktor.serialization.WebsocketContentConverter r7 = (io.ktor.serialization.WebsocketContentConverter) r7
            java.lang.Object r8 = r1.L$0
            io.ktor.util.reflect.TypeInfo r8 = (io.ktor.util.reflect.TypeInfo) r8
            kotlin.ResultKt.throwOnFailure(r0)
            r15 = r8
            r8 = r3
            r3 = r15
            goto L_0x006f
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlinx.coroutines.channels.ReceiveChannel r0 = r16.i()
            r3 = r17
            r1.L$0 = r3
            r7 = r18
            r1.L$1 = r7
            r8 = r19
            r1.L$2 = r8
            r1.label = r6
            java.lang.Object r0 = r0.K(r1)
            if (r0 != r2) goto L_0x006f
            return r2
        L_0x006f:
            r12 = r0
            io.ktor.websocket.Frame r12 = (io.ktor.websocket.Frame) r12
            boolean r0 = r7.c(r12)
            if (r0 == 0) goto L_0x00e6
            r1.L$0 = r3
            r1.L$1 = r12
            r1.L$2 = r4
            r1.label = r5
            java.lang.Object r0 = r7.a(r8, r3, r12, r1)
            if (r0 != r2) goto L_0x0087
            return r2
        L_0x0087:
            r1 = r3
            r10 = r12
        L_0x0089:
            kotlin.reflect.KClass r2 = r1.b()
            boolean r2 = r2.isInstance(r0)
            if (r2 == 0) goto L_0x0094
            return r0
        L_0x0094:
            if (r0 != 0) goto L_0x00af
            kotlin.reflect.KType r0 = r1.a()
            if (r0 == 0) goto L_0x00a3
            boolean r0 = r0.isMarkedNullable()
            if (r0 != r6) goto L_0x00a3
            return r4
        L_0x00a3:
            io.ktor.serialization.WebsocketDeserializeException r0 = new io.ktor.serialization.WebsocketDeserializeException
            r11 = 2
            r12 = 0
            java.lang.String r8 = "Frame has null content"
            r9 = 0
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12)
            throw r0
        L_0x00af:
            io.ktor.serialization.WebsocketDeserializeException r2 = new io.ktor.serialization.WebsocketDeserializeException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Can't deserialize value: expected value of type "
            r3.append(r4)
            kotlin.reflect.KClass r1 = r1.b()
            java.lang.String r1 = r1.getSimpleName()
            r3.append(r1)
            java.lang.String r1 = ", got "
            r3.append(r1)
            java.lang.Class r0 = r0.getClass()
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            java.lang.String r0 = r0.getSimpleName()
            r3.append(r0)
            java.lang.String r8 = r3.toString()
            r11 = 2
            r12 = 0
            r9 = 0
            r7 = r2
            r7.<init>(r8, r9, r10, r11, r12)
            throw r2
        L_0x00e6:
            io.ktor.serialization.WebsocketDeserializeException r0 = new io.ktor.serialization.WebsocketDeserializeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Converter doesn't support frame type "
            r1.append(r2)
            io.ktor.websocket.FrameType r2 = r12.d()
            java.lang.String r2 = r2.name()
            r1.append(r2)
            java.lang.String r10 = r1.toString()
            r13 = 2
            r14 = 0
            r11 = 0
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.serialization.WebsocketChannelSerializationKt.a(io.ktor.websocket.WebSocketSession, io.ktor.util.reflect.TypeInfo, io.ktor.serialization.WebsocketContentConverter, java.nio.charset.Charset, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(io.ktor.websocket.WebSocketSession r5, java.lang.Object r6, io.ktor.util.reflect.TypeInfo r7, io.ktor.serialization.WebsocketContentConverter r8, java.nio.charset.Charset r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.websocket.serialization.WebsocketChannelSerializationKt$sendSerializedBase$2
            if (r0 == 0) goto L_0x0013
            r0 = r10
            io.ktor.websocket.serialization.WebsocketChannelSerializationKt$sendSerializedBase$2 r0 = (io.ktor.websocket.serialization.WebsocketChannelSerializationKt$sendSerializedBase$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.websocket.serialization.WebsocketChannelSerializationKt$sendSerializedBase$2 r0 = new io.ktor.websocket.serialization.WebsocketChannelSerializationKt$sendSerializedBase$2
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x005c
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            java.lang.Object r5 = r0.L$0
            io.ktor.websocket.WebSocketSession r5 = (io.ktor.websocket.WebSocketSession) r5
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x004a
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r10)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r10 = r8.b(r9, r7, r6, r0)
            if (r10 != r1) goto L_0x004a
            return r1
        L_0x004a:
            io.ktor.websocket.Frame r10 = (io.ktor.websocket.Frame) r10
            kotlinx.coroutines.channels.SendChannel r5 = r5.o()
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r5 = r5.L(r10, r0)
            if (r5 != r1) goto L_0x005c
            return r1
        L_0x005c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.serialization.WebsocketChannelSerializationKt.b(io.ktor.websocket.WebSocketSession, java.lang.Object, io.ktor.util.reflect.TypeInfo, io.ktor.serialization.WebsocketContentConverter, java.nio.charset.Charset, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
