package io.ktor.websocket;

import io.ktor.websocket.WebSocketExtension;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0001J(\u0010\t\u001a\u00028\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/websocket/WebSocketExtensionFactory;", "", "ConfigType", "Lio/ktor/websocket/WebSocketExtension;", "ExtensionType", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "config", "a", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/websocket/WebSocketExtension;", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
public interface WebSocketExtensionFactory<ConfigType, ExtensionType extends WebSocketExtension<ConfigType>> {
    WebSocketExtension a(Function1 function1);
}
