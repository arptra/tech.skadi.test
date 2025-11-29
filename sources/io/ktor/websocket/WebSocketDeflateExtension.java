package io.ktor.websocket;

import io.ktor.util.AttributeKey;
import io.ktor.websocket.Frame;
import io.ktor.websocket.internals.DeflaterUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension({"SMAP\nWebSocketDeflateExtension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebSocketDeflateExtension.kt\nio/ktor/websocket/WebSocketDeflateExtension\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,240:1\n1#2:241\n*E\n"})
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000201B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R.\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00138\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0011\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010(\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\u0016\u0010.\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010#¨\u00062"}, d2 = {"Lio/ktor/websocket/WebSocketDeflateExtension;", "Lio/ktor/websocket/WebSocketExtension;", "Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "config", "<init>", "(Lio/ktor/websocket/WebSocketDeflateExtension$Config;)V", "", "Lio/ktor/websocket/WebSocketExtensionHeader;", "negotiatedProtocols", "", "d", "(Ljava/util/List;)Z", "Lio/ktor/websocket/Frame;", "frame", "b", "(Lio/ktor/websocket/Frame;)Lio/ktor/websocket/Frame;", "c", "a", "Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "Lio/ktor/websocket/WebSocketExtensionFactory;", "Lio/ktor/websocket/WebSocketExtensionFactory;", "getFactory", "()Lio/ktor/websocket/WebSocketExtensionFactory;", "factory", "Ljava/util/List;", "()Ljava/util/List;", "protocols", "Ljava/util/zip/Inflater;", "Ljava/util/zip/Inflater;", "inflater", "Ljava/util/zip/Deflater;", "e", "Ljava/util/zip/Deflater;", "deflater", "f", "Z", "getOutgoingNoContextTakeover$ktor_websockets", "()Z", "setOutgoingNoContextTakeover$ktor_websockets", "(Z)V", "outgoingNoContextTakeover", "g", "getIncomingNoContextTakeover$ktor_websockets", "setIncomingNoContextTakeover$ktor_websockets", "incomingNoContextTakeover", "h", "decompressIncoming", "i", "Companion", "Config", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
public final class WebSocketDeflateExtension implements WebSocketExtension<Config> {
    public static final Companion i = new Companion((DefaultConstructorMarker) null);
    public static final AttributeKey j = new AttributeKey("WebsocketDeflateExtension");
    public static final boolean k = true;

    /* renamed from: a  reason: collision with root package name */
    public final Config f9140a;
    public final WebSocketExtensionFactory b = i;
    public final List c;
    public final Inflater d;
    public final Deflater e;
    public boolean f;
    public boolean g;
    public boolean h;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/websocket/WebSocketDeflateExtension$Companion;", "Lio/ktor/websocket/WebSocketExtensionFactory;", "Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "Lio/ktor/websocket/WebSocketDeflateExtension;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "config", "b", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/websocket/WebSocketDeflateExtension;", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
    public static final class Companion implements WebSocketExtensionFactory<Config, WebSocketDeflateExtension> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        public WebSocketDeflateExtension a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "config");
            Config config = new Config();
            function1.invoke(config);
            return new WebSocketDeflateExtension(config);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R4\u0010\"\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001b\u0012\u0004\u0012\u00020\u001c0\u001a8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R.\u0010%\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\b0\u001a8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u0013\u0010\u001f\"\u0004\b$\u0010!¨\u0006&"}, d2 = {"Lio/ktor/websocket/WebSocketDeflateExtension$Config;", "", "<init>", "()V", "", "Lio/ktor/websocket/WebSocketExtensionHeader;", "a", "()Ljava/util/List;", "", "Z", "b", "()Z", "setClientNoContextTakeOver", "(Z)V", "clientNoContextTakeOver", "e", "setServerNoContextTakeOver", "serverNoContextTakeOver", "", "c", "I", "d", "()I", "setCompressionLevel", "(I)V", "compressionLevel", "Lkotlin/Function1;", "", "", "Lkotlin/jvm/functions/Function1;", "getManualConfig$ktor_websockets", "()Lkotlin/jvm/functions/Function1;", "setManualConfig$ktor_websockets", "(Lkotlin/jvm/functions/Function1;)V", "manualConfig", "Lio/ktor/websocket/Frame;", "setCompressCondition$ktor_websockets", "compressCondition", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
    public static final class Config {

        /* renamed from: a  reason: collision with root package name */
        public boolean f9141a;
        public boolean b;
        public int c = -1;
        public Function1 d = WebSocketDeflateExtension$Config$manualConfig$1.INSTANCE;
        public Function1 e = WebSocketDeflateExtension$Config$compressCondition$1.INSTANCE;

        public final List a() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.f9141a) {
                arrayList2.add("client_no_context_takeover");
            }
            if (this.b) {
                arrayList2.add("server_no_context_takeover");
            }
            arrayList.add(new WebSocketExtensionHeader("permessage-deflate", arrayList2));
            this.d.invoke(arrayList);
            return arrayList;
        }

        public final boolean b() {
            return this.f9141a;
        }

        public final Function1 c() {
            return this.e;
        }

        public final int d() {
            return this.c;
        }

        public final boolean e() {
            return this.b;
        }
    }

    public WebSocketDeflateExtension(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f9140a = config;
        this.c = config.a();
        this.d = new Inflater(true);
        this.e = new Deflater(config.d(), true);
    }

    public List a() {
        return this.c;
    }

    public Frame b(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        if ((!(frame instanceof Frame.Text) && !(frame instanceof Frame.Binary)) || !((Boolean) this.f9140a.c().invoke(frame)).booleanValue()) {
            return frame;
        }
        byte[] a2 = DeflaterUtilsKt.a(this.e, frame.b());
        if (this.f) {
            this.e.reset();
        }
        return Frame.i.a(frame.c(), frame.d(), a2, k, frame.f(), frame.g());
    }

    public Frame c(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        if (!WebSocketDeflateExtensionKt.b(frame) && !this.h) {
            return frame;
        }
        this.h = true;
        byte[] c2 = DeflaterUtilsKt.c(this.d, frame.b());
        if (this.g) {
            this.d.reset();
        }
        if (frame.c()) {
            this.h = false;
        }
        return Frame.i.a(frame.c(), frame.d(), c2, !k, frame.f(), frame.g());
    }

    public boolean d(List list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "negotiatedProtocols");
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((WebSocketExtensionHeader) obj).a(), (Object) "permessage-deflate")) {
                break;
            }
        }
        WebSocketExtensionHeader webSocketExtensionHeader = (WebSocketExtensionHeader) obj;
        if (webSocketExtensionHeader == null) {
            return false;
        }
        this.g = this.f9140a.e();
        this.f = this.f9140a.b();
        for (Pair pair : webSocketExtensionHeader.c()) {
            String str = (String) pair.component1();
            String str2 = (String) pair.component2();
            switch (str.hashCode()) {
                case -708713803:
                    if (!str.equals("client_no_context_takeover")) {
                        continue;
                    } else if (StringsKt.isBlank(str2)) {
                        this.f = true;
                        break;
                    } else {
                        throw new IllegalStateException(("WebSocket permessage-deflate extension parameter client_no_context_takeover shouldn't have a value. Current: " + str2).toString());
                    }
                case 646404390:
                    if (str.equals("client_max_window_bits") && !StringsKt.isBlank(str2) && Integer.parseInt(str2) != 15) {
                        throw new IllegalStateException("Only 15 window size is supported.".toString());
                    }
                case 1266201133:
                    if (!str.equals("server_no_context_takeover")) {
                        continue;
                    } else if (StringsKt.isBlank(str2)) {
                        this.g = true;
                        break;
                    } else {
                        throw new IllegalStateException(("WebSocket permessage-deflate extension parameter server_no_context_takeover shouldn't have a value. Current: " + str2).toString());
                    }
                case 2034279582:
                    str.equals("server_max_window_bits");
                    break;
            }
        }
        return true;
    }
}
