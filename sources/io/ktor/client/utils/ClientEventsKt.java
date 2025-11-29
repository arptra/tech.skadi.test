package io.ktor.client.utils;

import io.ktor.events.EventDefinition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0002\u0010\u0004\"\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0006\u0010\u0004\"\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00008\u0006¢\u0006\f\n\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u0004\"\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00008\u0006¢\u0006\f\n\u0004\b\r\u0010\u0003\u001a\u0004\b\r\u0010\u0004\"\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00008\u0006¢\u0006\f\n\u0004\b\n\u0010\u0003\u001a\u0004\b\t\u0010\u0004¨\u0006\u0010"}, d2 = {"Lio/ktor/events/EventDefinition;", "Lio/ktor/client/request/HttpRequestBuilder;", "a", "Lio/ktor/events/EventDefinition;", "()Lio/ktor/events/EventDefinition;", "HttpRequestCreated", "b", "HttpRequestIsReadyForSending", "Lio/ktor/client/statement/HttpResponse;", "c", "e", "HttpResponseReceived", "Lio/ktor/client/utils/HttpResponseReceiveFail;", "d", "HttpResponseReceiveFailed", "HttpResponseCancelled", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
public final class ClientEventsKt {

    /* renamed from: a  reason: collision with root package name */
    public static final EventDefinition f8930a = new EventDefinition();
    public static final EventDefinition b = new EventDefinition();
    public static final EventDefinition c = new EventDefinition();
    public static final EventDefinition d = new EventDefinition();
    public static final EventDefinition e = new EventDefinition();

    public static final EventDefinition a() {
        return f8930a;
    }

    public static final EventDefinition b() {
        return b;
    }

    public static final EventDefinition c() {
        return e;
    }

    public static final EventDefinition d() {
        return d;
    }

    public static final EventDefinition e() {
        return c;
    }
}
