package io.netty.handler.ssl;

import io.netty.handler.ssl.OpenSslSessionCache;
import io.netty.util.AsciiString;
import java.util.HashMap;
import java.util.Map;

final class OpenSslClientSessionCache extends OpenSslSessionCache {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Map<HostPort, OpenSslSessionCache.NativeSslSession> sessions = new HashMap();

    public static final class HostPort {
        private final int hash;
        private final String host;
        private final int port;

        public HostPort(String str, int i) {
            this.host = str;
            this.port = i;
            this.hash = (AsciiString.hashCode(str) * 31) + i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof HostPort)) {
                return false;
            }
            HostPort hostPort = (HostPort) obj;
            return this.port == hostPort.port && this.host.equalsIgnoreCase(hostPort.host);
        }

        public int hashCode() {
            return this.hash;
        }

        public String toString() {
            return "HostPort{host='" + this.host + '\'' + ", port=" + this.port + '}';
        }
    }

    static {
        Class<OpenSslClientSessionCache> cls = OpenSslClientSessionCache.class;
    }

    public OpenSslClientSessionCache(OpenSslEngineMap openSslEngineMap) {
        super(openSslEngineMap);
    }

    private static HostPort keyFor(String str, int i) {
        if (str != null || i >= 1) {
            return new HostPort(str, i);
        }
        return null;
    }

    public synchronized void clear() {
        super.clear();
        this.sessions.clear();
    }

    public boolean sessionCreated(OpenSslSessionCache.NativeSslSession nativeSslSession) {
        HostPort keyFor = keyFor(nativeSslSession.getPeerHost(), nativeSslSession.getPeerPort());
        if (keyFor == null || this.sessions.containsKey(keyFor)) {
            return false;
        }
        this.sessions.put(keyFor, nativeSslSession);
        return true;
    }

    public void sessionRemoved(OpenSslSessionCache.NativeSslSession nativeSslSession) {
        HostPort keyFor = keyFor(nativeSslSession.getPeerHost(), nativeSslSession.getPeerPort());
        if (keyFor != null) {
            this.sessions.remove(keyFor);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        if (r3 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        if (r5.shouldBeSingleUse() == false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        r5.invalidate();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
        r5.updateLastAccessedTime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSession(long r3, java.lang.String r5, int r6) {
        /*
            r2 = this;
            io.netty.handler.ssl.OpenSslClientSessionCache$HostPort r5 = keyFor(r5, r6)
            if (r5 != 0) goto L_0x0007
            return
        L_0x0007:
            monitor-enter(r2)
            java.util.Map<io.netty.handler.ssl.OpenSslClientSessionCache$HostPort, io.netty.handler.ssl.OpenSslSessionCache$NativeSslSession> r6 = r2.sessions     // Catch:{ all -> 0x0014 }
            java.lang.Object r5 = r6.get(r5)     // Catch:{ all -> 0x0014 }
            io.netty.handler.ssl.OpenSslSessionCache$NativeSslSession r5 = (io.netty.handler.ssl.OpenSslSessionCache.NativeSslSession) r5     // Catch:{ all -> 0x0014 }
            if (r5 != 0) goto L_0x0016
            monitor-exit(r2)     // Catch:{ all -> 0x0014 }
            return
        L_0x0014:
            r3 = move-exception
            goto L_0x003d
        L_0x0016:
            boolean r6 = r5.isValid()     // Catch:{ all -> 0x0014 }
            if (r6 != 0) goto L_0x0025
            io.netty.handler.ssl.OpenSslSessionId r3 = r5.sessionId()     // Catch:{ all -> 0x0014 }
            r2.removeSessionWithId(r3)     // Catch:{ all -> 0x0014 }
            monitor-exit(r2)     // Catch:{ all -> 0x0014 }
            return
        L_0x0025:
            long r0 = r5.session()     // Catch:{ all -> 0x0014 }
            boolean r3 = io.netty.internal.tcnative.SSL.setSession(r3, r0)     // Catch:{ all -> 0x0014 }
            monitor-exit(r2)     // Catch:{ all -> 0x0014 }
            if (r3 == 0) goto L_0x003c
            boolean r2 = r5.shouldBeSingleUse()
            if (r2 == 0) goto L_0x0039
            r5.invalidate()
        L_0x0039:
            r5.updateLastAccessedTime()
        L_0x003c:
            return
        L_0x003d:
            monitor-exit(r2)     // Catch:{ all -> 0x0014 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.OpenSslClientSessionCache.setSession(long, java.lang.String, int):void");
    }
}
