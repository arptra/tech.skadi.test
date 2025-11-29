package org.java_websocket.drafts;

import com.google.common.net.HttpHeaders;
import com.google.common.primitives.SignedBytes;
import com.here.posclient.UpdateOptions;
import com.upuphone.runasone.channel.linker.websocket.WsUtil;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExceededException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.extensions.DefaultExtension;
import org.java_websocket.extensions.IExtension;
import org.java_websocket.framing.BinaryFrame;
import org.java_websocket.framing.CloseFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.framing.TextFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.protocols.IProtocol;
import org.java_websocket.protocols.Protocol;
import org.java_websocket.util.Base64;
import org.java_websocket.util.Charsetfunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Draft_6455 extends Draft {
    public final Logger c;
    public IExtension d;
    public IExtension e;
    public List f;
    public IExtension g;
    public IProtocol h;
    public List i;
    public Framedata j;
    public final List k;
    public ByteBuffer l;
    public final SecureRandom m;
    public int n;

    public class TranslatedPayloadMetaData {

        /* renamed from: a  reason: collision with root package name */
        public int f3396a;
        public int b;

        public TranslatedPayloadMetaData(int i, int i2) {
            this.f3396a = i;
            this.b = i2;
        }

        public final int c() {
            return this.f3396a;
        }

        public final int d() {
            return this.b;
        }
    }

    public Draft_6455() {
        this(Collections.emptyList());
    }

    public final void A() {
        long G = G();
        if (G > ((long) this.n)) {
            B();
            this.c.trace("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(this.n), Long.valueOf(G));
            throw new LimitExceededException(this.n);
        }
    }

    public final void B() {
        synchronized (this.k) {
            this.k.clear();
        }
    }

    public final HandshakeState C(String str) {
        for (IProtocol iProtocol : this.i) {
            if (iProtocol.b(str)) {
                this.h = iProtocol;
                this.c.trace("acceptHandshake - Matching protocol found: {}", (Object) iProtocol);
                return HandshakeState.MATCHED;
            }
        }
        return HandshakeState.NOT_MATCHED;
    }

    public final ByteBuffer D(Framedata framedata) {
        ByteBuffer a2 = framedata.a();
        int i2 = 0;
        boolean z = this.f3395a == Role.CLIENT;
        int Q = Q(a2);
        ByteBuffer allocate = ByteBuffer.allocate((Q > 1 ? Q + 1 : Q) + 1 + (z ? 4 : 0) + a2.remaining());
        byte E = (byte) (E(framedata.d()) | ((byte) (framedata.f() ? -128 : 0)));
        if (framedata.b()) {
            E = (byte) (E | O(1));
        }
        if (framedata.c()) {
            E = (byte) (E | O(2));
        }
        if (framedata.e()) {
            E = (byte) (O(3) | E);
        }
        allocate.put(E);
        byte[] Y = Y((long) a2.remaining(), Q);
        if (Q == 1) {
            allocate.put((byte) (Y[0] | K(z)));
        } else if (Q == 2) {
            allocate.put((byte) (K(z) | 126));
            allocate.put(Y);
        } else if (Q == 8) {
            allocate.put((byte) (K(z) | Byte.MAX_VALUE));
            allocate.put(Y);
        } else {
            throw new IllegalStateException("Size representation not supported/specified");
        }
        if (z) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.m.nextInt());
            allocate.put(allocate2.array());
            while (a2.hasRemaining()) {
                allocate.put((byte) (a2.get() ^ allocate2.get(i2 % 4)));
                i2++;
            }
        } else {
            allocate.put(a2);
            a2.flip();
        }
        allocate.flip();
        return allocate;
    }

    public final byte E(Opcode opcode) {
        if (opcode == Opcode.CONTINUOUS) {
            return 0;
        }
        if (opcode == Opcode.TEXT) {
            return 1;
        }
        if (opcode == Opcode.BINARY) {
            return 2;
        }
        if (opcode == Opcode.CLOSING) {
            return 8;
        }
        if (opcode == Opcode.PING) {
            return 9;
        }
        if (opcode == Opcode.PONG) {
            return 10;
        }
        throw new IllegalArgumentException("Don't know how to handle " + opcode.toString());
    }

    public final String F(String str) {
        try {
            return Base64.g(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public final long G() {
        long j2;
        synchronized (this.k) {
            try {
                j2 = 0;
                for (ByteBuffer limit : this.k) {
                    j2 += (long) limit.limit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j2;
    }

    public IExtension H() {
        return this.d;
    }

    public List I() {
        return this.f;
    }

    public List J() {
        return this.i;
    }

    public final byte K(boolean z) {
        return z ? Byte.MIN_VALUE : 0;
    }

    public int L() {
        return this.n;
    }

    public final ByteBuffer M() {
        ByteBuffer allocate;
        synchronized (this.k) {
            try {
                long j2 = 0;
                for (ByteBuffer limit : this.k) {
                    j2 += (long) limit.limit();
                }
                A();
                allocate = ByteBuffer.allocate((int) j2);
                for (ByteBuffer put : this.k) {
                    allocate.put(put);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        allocate.flip();
        return allocate;
    }

    public IProtocol N() {
        return this.h;
    }

    public final byte O(int i2) {
        if (i2 == 1) {
            return SignedBytes.MAX_POWER_OF_TWO;
        }
        if (i2 != 2) {
            return i2 != 3 ? (byte) 0 : 16;
        }
        return 32;
    }

    public final String P() {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
        return simpleDateFormat.format(instance.getTime());
    }

    public final int Q(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 125) {
            return 1;
        }
        return byteBuffer.remaining() <= 65535 ? 2 : 8;
    }

    public final void R(WebSocketImpl webSocketImpl, RuntimeException runtimeException) {
        this.c.error("Runtime exception during onWebsocketMessage", (Throwable) runtimeException);
        webSocketImpl.w().f(webSocketImpl, runtimeException);
    }

    public final void S(WebSocketImpl webSocketImpl, Framedata framedata) {
        try {
            webSocketImpl.w().i(webSocketImpl, framedata.a());
        } catch (RuntimeException e2) {
            R(webSocketImpl, e2);
        }
    }

    public final void T(WebSocketImpl webSocketImpl, Framedata framedata) {
        String str;
        int i2;
        if (framedata instanceof CloseFrame) {
            CloseFrame closeFrame = (CloseFrame) framedata;
            i2 = closeFrame.o();
            str = closeFrame.p();
        } else {
            i2 = 1005;
            str = "";
        }
        if (webSocketImpl.u() == ReadyState.CLOSING) {
            webSocketImpl.f(i2, str, true);
        } else if (k() == CloseHandshakeType.TWOWAY) {
            webSocketImpl.b(i2, str, true);
        } else {
            webSocketImpl.n(i2, str, false);
        }
    }

    public final void U(WebSocketImpl webSocketImpl, Framedata framedata, Opcode opcode) {
        Opcode opcode2 = Opcode.CONTINUOUS;
        if (opcode != opcode2) {
            W(framedata);
        } else if (framedata.f()) {
            V(webSocketImpl, framedata);
        } else if (this.j == null) {
            this.c.error("Protocol error: Continuous frame sequence was not started.");
            throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
        }
        if (opcode == Opcode.TEXT && !Charsetfunctions.b(framedata.a())) {
            this.c.error("Protocol error: Payload is not UTF8");
            throw new InvalidDataException(1007);
        } else if (opcode == opcode2 && this.j != null) {
            z(framedata.a());
        }
    }

    public final void V(WebSocketImpl webSocketImpl, Framedata framedata) {
        if (this.j != null) {
            z(framedata.a());
            A();
            if (this.j.d() == Opcode.TEXT) {
                ((FramedataImpl1) this.j).j(M());
                ((FramedataImpl1) this.j).h();
                try {
                    webSocketImpl.w().g(webSocketImpl, Charsetfunctions.e(this.j.a()));
                } catch (RuntimeException e2) {
                    R(webSocketImpl, e2);
                }
            } else if (this.j.d() == Opcode.BINARY) {
                ((FramedataImpl1) this.j).j(M());
                ((FramedataImpl1) this.j).h();
                try {
                    webSocketImpl.w().i(webSocketImpl, this.j.a());
                } catch (RuntimeException e3) {
                    R(webSocketImpl, e3);
                }
            }
            this.j = null;
            B();
            return;
        }
        this.c.trace("Protocol error: Previous continuous frame sequence not completed.");
        throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
    }

    public final void W(Framedata framedata) {
        if (this.j == null) {
            this.j = framedata;
            z(framedata.a());
            A();
            return;
        }
        this.c.trace("Protocol error: Previous continuous frame sequence not completed.");
        throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
    }

    public final void X(WebSocketImpl webSocketImpl, Framedata framedata) {
        try {
            webSocketImpl.w().g(webSocketImpl, Charsetfunctions.e(framedata.a()));
        } catch (RuntimeException e2) {
            R(webSocketImpl, e2);
        }
    }

    public final byte[] Y(long j2, int i2) {
        byte[] bArr = new byte[i2];
        int i3 = (i2 * 8) - 8;
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) ((int) (j2 >>> (i3 - (i4 * 8))));
        }
        return bArr;
    }

    public final Opcode Z(byte b) {
        if (b == 0) {
            return Opcode.CONTINUOUS;
        }
        if (b == 1) {
            return Opcode.TEXT;
        }
        if (b == 2) {
            return Opcode.BINARY;
        }
        switch (b) {
            case 8:
                return Opcode.CLOSING;
            case 9:
                return Opcode.PING;
            case 10:
                return Opcode.PONG;
            default:
                throw new InvalidFrameException("Unknown opcode " + ((short) b));
        }
    }

    public HandshakeState a(ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
        if (!c(serverHandshake)) {
            this.c.trace("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return HandshakeState.NOT_MATCHED;
        } else if (!clientHandshake.g("Sec-WebSocket-Key") || !serverHandshake.g("Sec-WebSocket-Accept")) {
            this.c.trace("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return HandshakeState.NOT_MATCHED;
        } else {
            if (!F(clientHandshake.e("Sec-WebSocket-Key")).equals(serverHandshake.e("Sec-WebSocket-Accept"))) {
                this.c.trace("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return HandshakeState.NOT_MATCHED;
            }
            HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
            String e2 = serverHandshake.e(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS);
            Iterator it = this.f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IExtension iExtension = (IExtension) it.next();
                if (iExtension.b(e2)) {
                    this.d = iExtension;
                    handshakeState = HandshakeState.MATCHED;
                    this.c.trace("acceptHandshakeAsClient - Matching extension found: {}", (Object) iExtension);
                    break;
                }
            }
            HandshakeState C = C(serverHandshake.e("Sec-WebSocket-Protocol"));
            HandshakeState handshakeState2 = HandshakeState.MATCHED;
            if (C == handshakeState2 && handshakeState == handshakeState2) {
                return handshakeState2;
            }
            this.c.trace("acceptHandshakeAsClient - No matching extension or protocol found.");
            return HandshakeState.NOT_MATCHED;
        }
    }

    public final Framedata a0(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i2 = 2;
            c0(remaining, 2);
            byte b = byteBuffer.get();
            boolean z = (b >> 8) != 0;
            boolean z2 = (b & SignedBytes.MAX_POWER_OF_TWO) != 0;
            boolean z3 = (b & 32) != 0;
            boolean z4 = (b & 16) != 0;
            byte b2 = byteBuffer.get();
            boolean z5 = (b2 & Byte.MIN_VALUE) != 0;
            int i3 = (byte) (b2 & Byte.MAX_VALUE);
            Opcode Z = Z((byte) (b & 15));
            if (i3 < 0 || i3 > 125) {
                TranslatedPayloadMetaData d0 = d0(byteBuffer, Z, i3, remaining, 2);
                i3 = d0.c();
                i2 = d0.d();
            }
            b0((long) i3);
            c0(remaining, i2 + (z5 ? 4 : 0) + i3);
            ByteBuffer allocate = ByteBuffer.allocate(d(i3));
            if (z5) {
                byte[] bArr = new byte[4];
                byteBuffer.get(bArr);
                for (int i4 = 0; i4 < i3; i4++) {
                    allocate.put((byte) (byteBuffer.get() ^ bArr[i4 % 4]));
                }
            } else {
                allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                byteBuffer.position(byteBuffer.position() + allocate.limit());
            }
            FramedataImpl1 g2 = FramedataImpl1.g(Z);
            g2.i(z);
            g2.k(z2);
            g2.l(z3);
            g2.m(z4);
            allocate.flip();
            g2.j(allocate);
            if (g2.d() != Opcode.CONTINUOUS) {
                if (g2.b() || g2.c() || g2.e()) {
                    this.g = H();
                } else {
                    this.g = this.e;
                }
            }
            if (this.g == null) {
                this.g = this.e;
            }
            this.g.h(g2);
            this.g.f(g2);
            if (this.c.isTraceEnabled()) {
                this.c.trace("afterDecoding({}): {}", Integer.valueOf(g2.a().remaining()), g2.a().remaining() > 1000 ? "too big to display" : new String(g2.a().array()));
            }
            g2.h();
            return g2;
        }
        throw new IllegalArgumentException();
    }

    public HandshakeState b(ClientHandshake clientHandshake) {
        if (r(clientHandshake) != 13) {
            this.c.trace("acceptHandshakeAsServer - Wrong websocket version.");
            return HandshakeState.NOT_MATCHED;
        }
        HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
        String e2 = clientHandshake.e(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS);
        Iterator it = this.f.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IExtension iExtension = (IExtension) it.next();
            if (iExtension.e(e2)) {
                this.d = iExtension;
                handshakeState = HandshakeState.MATCHED;
                this.c.trace("acceptHandshakeAsServer - Matching extension found: {}", (Object) iExtension);
                break;
            }
        }
        HandshakeState C = C(clientHandshake.e("Sec-WebSocket-Protocol"));
        HandshakeState handshakeState2 = HandshakeState.MATCHED;
        if (C == handshakeState2 && handshakeState == handshakeState2) {
            return handshakeState2;
        }
        this.c.trace("acceptHandshakeAsServer - No matching extension or protocol found.");
        return HandshakeState.NOT_MATCHED;
    }

    public final void b0(long j2) {
        if (j2 <= UpdateOptions.SOURCE_ANY) {
            int i2 = this.n;
            if (j2 > ((long) i2)) {
                this.c.trace("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(i2), Long.valueOf(j2));
                throw new LimitExceededException("Payload limit reached.", this.n);
            } else if (j2 < 0) {
                this.c.trace("Limit underflow: Payloadsize is to little...");
                throw new LimitExceededException("Payloadsize is to little...");
            }
        } else {
            this.c.trace("Limit exedeed: Payloadsize is to big...");
            throw new LimitExceededException("Payloadsize is to big...");
        }
    }

    public final void c0(int i2, int i3) {
        if (i2 < i3) {
            this.c.trace("Incomplete frame: maxpacketsize < realpacketsize");
            throw new IncompleteException(i3);
        }
    }

    public final TranslatedPayloadMetaData d0(ByteBuffer byteBuffer, Opcode opcode, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (opcode == Opcode.PING || opcode == Opcode.PONG || opcode == Opcode.CLOSING) {
            this.c.trace("Invalid frame: more than 125 octets");
            throw new InvalidFrameException("more than 125 octets");
        }
        if (i2 == 126) {
            i5 = i4 + 2;
            c0(i3, i5);
            byte[] bArr = new byte[3];
            bArr[1] = byteBuffer.get();
            bArr[2] = byteBuffer.get();
            i6 = new BigInteger(bArr).intValue();
        } else {
            i5 = i4 + 8;
            c0(i3, i5);
            byte[] bArr2 = new byte[8];
            for (int i7 = 0; i7 < 8; i7++) {
                bArr2[i7] = byteBuffer.get();
            }
            long longValue = new BigInteger(bArr2).longValue();
            b0(longValue);
            i6 = (int) longValue;
        }
        return new TranslatedPayloadMetaData(i6, i5);
    }

    public Draft e() {
        ArrayList arrayList = new ArrayList();
        for (IExtension a2 : I()) {
            arrayList.add(a2.a());
        }
        ArrayList arrayList2 = new ArrayList();
        for (IProtocol a3 : J()) {
            arrayList2.add(a3.a());
        }
        return new Draft_6455(arrayList, arrayList2, this.n);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Draft_6455 draft_6455 = (Draft_6455) obj;
        if (this.n != draft_6455.L()) {
            return false;
        }
        IExtension iExtension = this.d;
        if (iExtension == null ? draft_6455.H() != null : !iExtension.equals(draft_6455.H())) {
            return false;
        }
        IProtocol iProtocol = this.h;
        return iProtocol != null ? iProtocol.equals(draft_6455.N()) : draft_6455.N() == null;
    }

    public ByteBuffer f(Framedata framedata) {
        H().c(framedata);
        if (this.c.isTraceEnabled()) {
            this.c.trace("afterEnconding({}): {}", Integer.valueOf(framedata.a().remaining()), framedata.a().remaining() > 1000 ? "too big to display" : new String(framedata.a().array()));
        }
        return D(framedata);
    }

    public List g(String str, boolean z) {
        TextFrame textFrame = new TextFrame();
        textFrame.j(ByteBuffer.wrap(Charsetfunctions.f(str)));
        textFrame.n(z);
        try {
            textFrame.h();
            return Collections.singletonList(textFrame);
        } catch (InvalidDataException e2) {
            throw new NotSendableException((Throwable) e2);
        }
    }

    public List h(ByteBuffer byteBuffer, boolean z) {
        BinaryFrame binaryFrame = new BinaryFrame();
        binaryFrame.j(byteBuffer);
        binaryFrame.n(z);
        try {
            binaryFrame.h();
            return Collections.singletonList(binaryFrame);
        } catch (InvalidDataException e2) {
            throw new NotSendableException((Throwable) e2);
        }
    }

    public int hashCode() {
        IExtension iExtension = this.d;
        int i2 = 0;
        int hashCode = (iExtension != null ? iExtension.hashCode() : 0) * 31;
        IProtocol iProtocol = this.h;
        if (iProtocol != null) {
            i2 = iProtocol.hashCode();
        }
        int i3 = this.n;
        return ((hashCode + i2) * 31) + (i3 ^ (i3 >>> 32));
    }

    public CloseHandshakeType k() {
        return CloseHandshakeType.TWOWAY;
    }

    public ClientHandshakeBuilder m(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.a("Upgrade", WsUtil.WEB_SOCKET_PATH);
        clientHandshakeBuilder.a("Connection", "Upgrade");
        byte[] bArr = new byte[16];
        this.m.nextBytes(bArr);
        clientHandshakeBuilder.a("Sec-WebSocket-Key", Base64.g(bArr));
        clientHandshakeBuilder.a("Sec-WebSocket-Version", "13");
        StringBuilder sb = new StringBuilder();
        for (IExtension iExtension : this.f) {
            if (!(iExtension.g() == null || iExtension.g().length() == 0)) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(iExtension.g());
            }
        }
        if (sb.length() != 0) {
            clientHandshakeBuilder.a(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS, sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (IProtocol iProtocol : this.i) {
            if (iProtocol.c().length() != 0) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(iProtocol.c());
            }
        }
        if (sb2.length() != 0) {
            clientHandshakeBuilder.a("Sec-WebSocket-Protocol", sb2.toString());
        }
        return clientHandshakeBuilder;
    }

    public HandshakeBuilder n(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) {
        serverHandshakeBuilder.a("Upgrade", WsUtil.WEB_SOCKET_PATH);
        serverHandshakeBuilder.a("Connection", clientHandshake.e("Connection"));
        String e2 = clientHandshake.e("Sec-WebSocket-Key");
        if (e2 == null || "".equals(e2)) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        serverHandshakeBuilder.a("Sec-WebSocket-Accept", F(e2));
        if (H().d().length() != 0) {
            serverHandshakeBuilder.a(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS, H().d());
        }
        if (!(N() == null || N().c().length() == 0)) {
            serverHandshakeBuilder.a("Sec-WebSocket-Protocol", N().c());
        }
        serverHandshakeBuilder.d("Web Socket Protocol Handshake");
        serverHandshakeBuilder.a("Server", "TooTallNate Java-WebSocket");
        serverHandshakeBuilder.a("Date", P());
        return serverHandshakeBuilder;
    }

    public void o(WebSocketImpl webSocketImpl, Framedata framedata) {
        Opcode d2 = framedata.d();
        if (d2 == Opcode.CLOSING) {
            T(webSocketImpl, framedata);
        } else if (d2 == Opcode.PING) {
            webSocketImpl.w().n(webSocketImpl, framedata);
        } else if (d2 == Opcode.PONG) {
            webSocketImpl.M();
            webSocketImpl.w().m(webSocketImpl, framedata);
        } else if (!framedata.f() || d2 == Opcode.CONTINUOUS) {
            U(webSocketImpl, framedata, d2);
        } else if (this.j != null) {
            this.c.error("Protocol error: Continuous frame sequence not completed.");
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        } else if (d2 == Opcode.TEXT) {
            X(webSocketImpl, framedata);
        } else if (d2 == Opcode.BINARY) {
            S(webSocketImpl, framedata);
        } else {
            this.c.error("non control or continious frame expected");
            throw new InvalidDataException(1002, "non control or continious frame expected");
        }
    }

    public void s() {
        this.l = null;
        IExtension iExtension = this.d;
        if (iExtension != null) {
            iExtension.reset();
        }
        this.d = new DefaultExtension();
        this.h = null;
    }

    public String toString() {
        String draft = super.toString();
        if (H() != null) {
            draft = draft + " extension: " + H().toString();
        }
        if (N() != null) {
            draft = draft + " protocol: " + N().toString();
        }
        return draft + " max frame size: " + this.n;
    }

    public List u(ByteBuffer byteBuffer) {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.l == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.l.remaining();
                if (remaining2 > remaining) {
                    this.l.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.l.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(a0((ByteBuffer) this.l.duplicate().position(0)));
                this.l = null;
            } catch (IncompleteException e2) {
                ByteBuffer allocate = ByteBuffer.allocate(d(e2.getPreferredSize()));
                this.l.rewind();
                allocate.put(this.l);
                this.l = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(a0(byteBuffer));
            } catch (IncompleteException e3) {
                byteBuffer.reset();
                ByteBuffer allocate2 = ByteBuffer.allocate(d(e3.getPreferredSize()));
                this.l = allocate2;
                allocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public final void z(ByteBuffer byteBuffer) {
        synchronized (this.k) {
            this.k.add(byteBuffer);
        }
    }

    public Draft_6455(List list) {
        this(list, Collections.singletonList(new Protocol("")));
    }

    public Draft_6455(List list, List list2) {
        this(list, list2, Integer.MAX_VALUE);
    }

    public Draft_6455(List list, List list2, int i2) {
        this.c = LoggerFactory.k(Draft_6455.class);
        this.d = new DefaultExtension();
        this.e = new DefaultExtension();
        this.m = new SecureRandom();
        if (list == null || list2 == null || i2 < 1) {
            throw new IllegalArgumentException();
        }
        this.f = new ArrayList(list.size());
        this.i = new ArrayList(list2.size());
        this.k = new ArrayList();
        Iterator it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (((IExtension) it.next()).getClass().equals(DefaultExtension.class)) {
                z = true;
            }
        }
        this.f.addAll(list);
        if (!z) {
            List list3 = this.f;
            list3.add(list3.size(), this.d);
        }
        this.i.addAll(list2);
        this.n = i2;
        this.g = null;
    }
}
