package okhttp3.internal.connection;

import com.meizu.common.widget.MzContactsContract;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0002J8\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0002J\u0006\u0010'\u001a\u00020$J\n\u0010(\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lokhttp3/internal/connection/ExchangeFinder;", "", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "address", "Lokhttp3/Address;", "call", "Lokhttp3/internal/connection/RealCall;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "getAddress$okhttp", "()Lokhttp3/Address;", "connectionShutdownCount", "", "nextRouteToTry", "Lokhttp3/Route;", "otherFailureCount", "refusedStreamCount", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "find", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "findConnection", "Lokhttp3/internal/connection/RealConnection;", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "", "findHealthyConnection", "doExtensiveHealthChecks", "retryAfterFailure", "retryRoute", "sameHostAndPort", "url", "Lokhttp3/HttpUrl;", "trackFailure", "", "e", "Ljava/io/IOException;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExchangeFinder {
    @NotNull
    private final Address address;
    @NotNull
    private final RealCall call;
    @NotNull
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    @NotNull
    private final EventListener eventListener;
    @Nullable
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    @Nullable
    private RouteSelector.Selection routeSelection;
    @Nullable
    private RouteSelector routeSelector;

    public ExchangeFinder(@NotNull RealConnectionPool realConnectionPool, @NotNull Address address2, @NotNull RealCall realCall, @NotNull EventListener eventListener2) {
        Intrinsics.checkNotNullParameter(realConnectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(address2, MzContactsContract.MzContactColumns.ADDRESS);
        Intrinsics.checkNotNullParameter(realCall, "call");
        Intrinsics.checkNotNullParameter(eventListener2, "eventListener");
        this.connectionPool = realConnectionPool;
        this.address = address2;
        this.call = realCall;
        this.eventListener = eventListener2;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final okhttp3.internal.connection.RealConnection findConnection(int r15, int r16, int r17, int r18, boolean r19) throws java.io.IOException {
        /*
            r14 = this;
            r1 = r14
            okhttp3.internal.connection.RealCall r0 = r1.call
            boolean r0 = r0.isCanceled()
            if (r0 != 0) goto L_0x0175
            okhttp3.internal.connection.RealCall r0 = r1.call
            okhttp3.internal.connection.RealConnection r2 = r0.getConnection()
            r3 = 0
            if (r2 == 0) goto L_0x005f
            monitor-enter(r2)
            boolean r0 = r2.getNoNewExchanges()     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x0030
            okhttp3.Route r0 = r2.route()     // Catch:{ all -> 0x002e }
            okhttp3.Address r0 = r0.address()     // Catch:{ all -> 0x002e }
            okhttp3.HttpUrl r0 = r0.url()     // Catch:{ all -> 0x002e }
            boolean r0 = r14.sameHostAndPort(r0)     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x002c
            goto L_0x0030
        L_0x002c:
            r0 = r3
            goto L_0x0036
        L_0x002e:
            r0 = move-exception
            goto L_0x005d
        L_0x0030:
            okhttp3.internal.connection.RealCall r0 = r1.call     // Catch:{ all -> 0x002e }
            java.net.Socket r0 = r0.releaseConnectionNoEvents$okhttp()     // Catch:{ all -> 0x002e }
        L_0x0036:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002e }
            monitor-exit(r2)
            okhttp3.internal.connection.RealCall r4 = r1.call
            okhttp3.internal.connection.RealConnection r4 = r4.getConnection()
            if (r4 == 0) goto L_0x0050
            if (r0 != 0) goto L_0x0044
            return r2
        L_0x0044:
            java.lang.String r0 = "Check failed."
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0050:
            if (r0 == 0) goto L_0x0055
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r0)
        L_0x0055:
            okhttp3.EventListener r0 = r1.eventListener
            okhttp3.internal.connection.RealCall r4 = r1.call
            r0.connectionReleased(r4, r2)
            goto L_0x005f
        L_0x005d:
            monitor-exit(r2)
            throw r0
        L_0x005f:
            r0 = 0
            r1.refusedStreamCount = r0
            r1.connectionShutdownCount = r0
            r1.otherFailureCount = r0
            okhttp3.internal.connection.RealConnectionPool r2 = r1.connectionPool
            okhttp3.Address r4 = r1.address
            okhttp3.internal.connection.RealCall r5 = r1.call
            boolean r2 = r2.callAcquirePooledConnection(r4, r5, r3, r0)
            if (r2 == 0) goto L_0x0083
            okhttp3.internal.connection.RealCall r0 = r1.call
            okhttp3.internal.connection.RealConnection r0 = r0.getConnection()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            okhttp3.EventListener r2 = r1.eventListener
            okhttp3.internal.connection.RealCall r1 = r1.call
            r2.connectionAcquired(r1, r0)
            return r0
        L_0x0083:
            okhttp3.Route r2 = r1.nextRouteToTry
            if (r2 == 0) goto L_0x008e
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r1.nextRouteToTry = r3
        L_0x008c:
            r4 = r3
            goto L_0x00f3
        L_0x008e:
            okhttp3.internal.connection.RouteSelector$Selection r2 = r1.routeSelection
            if (r2 == 0) goto L_0x00a5
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r2 = r2.hasNext()
            if (r2 == 0) goto L_0x00a5
            okhttp3.internal.connection.RouteSelector$Selection r0 = r1.routeSelection
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            okhttp3.Route r2 = r0.next()
            goto L_0x008c
        L_0x00a5:
            okhttp3.internal.connection.RouteSelector r2 = r1.routeSelector
            if (r2 != 0) goto L_0x00c0
            okhttp3.internal.connection.RouteSelector r2 = new okhttp3.internal.connection.RouteSelector
            okhttp3.Address r4 = r1.address
            okhttp3.internal.connection.RealCall r5 = r1.call
            okhttp3.OkHttpClient r5 = r5.getClient()
            okhttp3.internal.connection.RouteDatabase r5 = r5.getRouteDatabase()
            okhttp3.internal.connection.RealCall r6 = r1.call
            okhttp3.EventListener r7 = r1.eventListener
            r2.<init>(r4, r5, r6, r7)
            r1.routeSelector = r2
        L_0x00c0:
            okhttp3.internal.connection.RouteSelector$Selection r2 = r2.next()
            r1.routeSelection = r2
            java.util.List r4 = r2.getRoutes()
            okhttp3.internal.connection.RealCall r5 = r1.call
            boolean r5 = r5.isCanceled()
            if (r5 != 0) goto L_0x016d
            okhttp3.internal.connection.RealConnectionPool r5 = r1.connectionPool
            okhttp3.Address r6 = r1.address
            okhttp3.internal.connection.RealCall r7 = r1.call
            boolean r0 = r5.callAcquirePooledConnection(r6, r7, r4, r0)
            if (r0 == 0) goto L_0x00ef
            okhttp3.internal.connection.RealCall r0 = r1.call
            okhttp3.internal.connection.RealConnection r0 = r0.getConnection()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            okhttp3.EventListener r2 = r1.eventListener
            okhttp3.internal.connection.RealCall r1 = r1.call
            r2.connectionAcquired(r1, r0)
            return r0
        L_0x00ef:
            okhttp3.Route r2 = r2.next()
        L_0x00f3:
            okhttp3.internal.connection.RealConnection r13 = new okhttp3.internal.connection.RealConnection
            okhttp3.internal.connection.RealConnectionPool r0 = r1.connectionPool
            r13.<init>(r0, r2)
            okhttp3.internal.connection.RealCall r0 = r1.call
            r0.setConnectionToCancel(r13)
            okhttp3.internal.connection.RealCall r11 = r1.call     // Catch:{ all -> 0x0166 }
            okhttp3.EventListener r12 = r1.eventListener     // Catch:{ all -> 0x0166 }
            r5 = r13
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            r10 = r19
            r5.connect(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0166 }
            okhttp3.internal.connection.RealCall r0 = r1.call
            r0.setConnectionToCancel(r3)
            okhttp3.internal.connection.RealCall r0 = r1.call
            okhttp3.OkHttpClient r0 = r0.getClient()
            okhttp3.internal.connection.RouteDatabase r0 = r0.getRouteDatabase()
            okhttp3.Route r3 = r13.route()
            r0.connected(r3)
            okhttp3.internal.connection.RealConnectionPool r0 = r1.connectionPool
            okhttp3.Address r3 = r1.address
            okhttp3.internal.connection.RealCall r5 = r1.call
            r6 = 1
            boolean r0 = r0.callAcquirePooledConnection(r3, r5, r4, r6)
            if (r0 == 0) goto L_0x014d
            okhttp3.internal.connection.RealCall r0 = r1.call
            okhttp3.internal.connection.RealConnection r0 = r0.getConnection()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r1.nextRouteToTry = r2
            java.net.Socket r2 = r13.socket()
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r2)
            okhttp3.EventListener r2 = r1.eventListener
            okhttp3.internal.connection.RealCall r1 = r1.call
            r2.connectionAcquired(r1, r0)
            return r0
        L_0x014d:
            monitor-enter(r13)
            okhttp3.internal.connection.RealConnectionPool r0 = r1.connectionPool     // Catch:{ all -> 0x0163 }
            r0.put(r13)     // Catch:{ all -> 0x0163 }
            okhttp3.internal.connection.RealCall r0 = r1.call     // Catch:{ all -> 0x0163 }
            r0.acquireConnectionNoEvents(r13)     // Catch:{ all -> 0x0163 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0163 }
            monitor-exit(r13)
            okhttp3.EventListener r0 = r1.eventListener
            okhttp3.internal.connection.RealCall r1 = r1.call
            r0.connectionAcquired(r1, r13)
            return r13
        L_0x0163:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        L_0x0166:
            r0 = move-exception
            okhttp3.internal.connection.RealCall r1 = r1.call
            r1.setConnectionToCancel(r3)
            throw r0
        L_0x016d:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Canceled"
            r0.<init>(r1)
            throw r0
        L_0x0175:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Canceled"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ExchangeFinder.findConnection(int, int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    private final RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            RealConnection findConnection = findConnection(i, i2, i3, i4, z);
            if (findConnection.isHealthy(z2)) {
                return findConnection;
            }
            findConnection.noNewExchanges$okhttp();
            if (this.nextRouteToTry == null) {
                RouteSelector.Selection selection = this.routeSelection;
                boolean z3 = true;
                if (selection != null ? selection.hasNext() : true) {
                    continue;
                } else {
                    RouteSelector routeSelector2 = this.routeSelector;
                    if (routeSelector2 != null) {
                        z3 = routeSelector2.hasNext();
                    }
                    if (!z3) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    private final Route retryRoute() {
        RealConnection connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0 || (connection = this.call.getConnection()) == null) {
            return null;
        }
        synchronized (connection) {
            if (connection.getRouteFailureCount$okhttp() != 0) {
                return null;
            }
            if (!Util.canReuseConnectionFor(connection.route().address().url(), this.address.url())) {
                return null;
            }
            Route route = connection.route();
            return route;
        }
    }

    @NotNull
    public final ExchangeCodec find(@NotNull OkHttpClient okHttpClient, @NotNull RealInterceptorChain realInterceptorChain) {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        Intrinsics.checkNotNullParameter(realInterceptorChain, "chain");
        try {
            return findHealthyConnection(realInterceptorChain.getConnectTimeoutMillis$okhttp(), realInterceptorChain.getReadTimeoutMillis$okhttp(), realInterceptorChain.getWriteTimeoutMillis$okhttp(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), !Intrinsics.areEqual((Object) realInterceptorChain.getRequest$okhttp().method(), (Object) "GET")).newCodec$okhttp(okHttpClient, realInterceptorChain);
        } catch (RouteException e) {
            trackFailure(e.getLastConnectException());
            throw e;
        } catch (IOException e2) {
            trackFailure(e2);
            throw new RouteException(e2);
        }
    }

    @NotNull
    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final boolean retryAfterFailure() {
        RouteSelector routeSelector2;
        if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if (this.nextRouteToTry != null) {
            return true;
        }
        Route retryRoute = retryRoute();
        if (retryRoute != null) {
            this.nextRouteToTry = retryRoute;
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        if ((selection == null || !selection.hasNext()) && (routeSelector2 = this.routeSelector) != null) {
            return routeSelector2.hasNext();
        }
        return true;
    }

    public final boolean sameHostAndPort(@NotNull HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter(httpUrl, "url");
        HttpUrl url = this.address.url();
        return httpUrl.port() == url.port() && Intrinsics.areEqual((Object) httpUrl.host(), (Object) url.host());
    }

    public final void trackFailure(@NotNull IOException iOException) {
        Intrinsics.checkNotNullParameter(iOException, "e");
        this.nextRouteToTry = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
            this.refusedStreamCount++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.connectionShutdownCount++;
        } else {
            this.otherFailureCount++;
        }
    }
}
