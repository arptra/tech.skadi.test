package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtension;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionData;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class PerMessageDeflateClientExtensionHandshaker implements WebSocketClientExtensionHandshaker {
    private final boolean allowClientNoContext;
    private final boolean allowClientWindowSize;
    /* access modifiers changed from: private */
    public final int compressionLevel;
    private final WebSocketExtensionFilterProvider extensionFilterProvider;
    private final boolean requestedServerNoContext;
    private final int requestedServerWindowSize;

    public final class PermessageDeflateExtension implements WebSocketClientExtension {
        private final boolean clientNoContext;
        private final int clientWindowSize;
        private final WebSocketExtensionFilterProvider extensionFilterProvider;
        private final boolean serverNoContext;
        private final int serverWindowSize;

        public PermessageDeflateExtension(boolean z, int i, boolean z2, int i2, WebSocketExtensionFilterProvider webSocketExtensionFilterProvider) {
            this.serverNoContext = z;
            this.serverWindowSize = i;
            this.clientNoContext = z2;
            this.clientWindowSize = i2;
            this.extensionFilterProvider = webSocketExtensionFilterProvider;
        }

        public WebSocketExtensionDecoder newExtensionDecoder() {
            return new PerMessageDeflateDecoder(this.serverNoContext, this.extensionFilterProvider.decoderFilter());
        }

        public WebSocketExtensionEncoder newExtensionEncoder() {
            return new PerMessageDeflateEncoder(PerMessageDeflateClientExtensionHandshaker.this.compressionLevel, this.clientWindowSize, this.clientNoContext, this.extensionFilterProvider.encoderFilter());
        }

        public int rsv() {
            return 4;
        }
    }

    public PerMessageDeflateClientExtensionHandshaker() {
        this(6, ZlibCodecFactory.isSupportingWindowSizeAndMemLevel(), 15, false, false);
    }

    public WebSocketClientExtension handshakeExtension(WebSocketExtensionData webSocketExtensionData) {
        if (!"permessage-deflate".equals(webSocketExtensionData.name())) {
            return null;
        }
        Iterator<Map.Entry<String, String>> it = webSocketExtensionData.parameters().entrySet().iterator();
        boolean z = false;
        boolean z2 = true;
        int i = 15;
        int i2 = 15;
        boolean z3 = false;
        boolean z4 = false;
        while (z2 && it.hasNext()) {
            Map.Entry next = it.next();
            if ("client_max_window_bits".equalsIgnoreCase((String) next.getKey())) {
                if (this.allowClientWindowSize && (i2 = Integer.parseInt((String) next.getValue())) <= 15 && i2 >= 8) {
                }
            } else if ("server_max_window_bits".equalsIgnoreCase((String) next.getKey())) {
                i = Integer.parseInt((String) next.getValue());
                if (i <= 15 && i >= 8) {
                }
            } else if ("client_no_context_takeover".equalsIgnoreCase((String) next.getKey())) {
                if (this.allowClientNoContext) {
                    z4 = true;
                }
            } else if ("server_no_context_takeover".equalsIgnoreCase((String) next.getKey())) {
                z3 = true;
            }
            z2 = false;
        }
        if ((!this.requestedServerNoContext || z3) && this.requestedServerWindowSize >= i) {
            z = z2;
        }
        if (!z) {
            return null;
        }
        return new PermessageDeflateExtension(z3, i, z4, i2, this.extensionFilterProvider);
    }

    public WebSocketExtensionData newRequestData() {
        HashMap hashMap = new HashMap(4);
        if (this.requestedServerNoContext) {
            hashMap.put("server_no_context_takeover", (Object) null);
        }
        if (this.allowClientNoContext) {
            hashMap.put("client_no_context_takeover", (Object) null);
        }
        int i = this.requestedServerWindowSize;
        if (i != 15) {
            hashMap.put("server_max_window_bits", Integer.toString(i));
        }
        if (this.allowClientWindowSize) {
            hashMap.put("client_max_window_bits", (Object) null);
        }
        return new WebSocketExtensionData("permessage-deflate", hashMap);
    }

    public PerMessageDeflateClientExtensionHandshaker(int i, boolean z, int i2, boolean z2, boolean z3) {
        this(i, z, i2, z2, z3, WebSocketExtensionFilterProvider.DEFAULT);
    }

    public PerMessageDeflateClientExtensionHandshaker(int i, boolean z, int i2, boolean z2, boolean z3, WebSocketExtensionFilterProvider webSocketExtensionFilterProvider) {
        if (i2 > 15 || i2 < 8) {
            throw new IllegalArgumentException("requestedServerWindowSize: " + i2 + " (expected: 8-15)");
        } else if (i < 0 || i > 9) {
            throw new IllegalArgumentException("compressionLevel: " + i + " (expected: 0-9)");
        } else {
            this.compressionLevel = i;
            this.allowClientWindowSize = z;
            this.requestedServerWindowSize = i2;
            this.allowClientNoContext = z2;
            this.requestedServerNoContext = z3;
            this.extensionFilterProvider = (WebSocketExtensionFilterProvider) ObjectUtil.checkNotNull(webSocketExtensionFilterProvider, "extensionFilterProvider");
        }
    }
}
