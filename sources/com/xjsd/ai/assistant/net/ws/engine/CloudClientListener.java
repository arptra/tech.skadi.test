package com.xjsd.ai.assistant.net.ws.engine;

import com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/xjsd/ai/assistant/net/ws/engine/CloudClientListener;", "", "Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;", "response", "", "c", "(Lcom/xjsd/ai/assistant/net/ws/protocol/EndToEndResponse;)V", "", "byteArray", "e", "([B)V", "", "code", "", "msg", "d", "(ILjava/lang/String;)V", "lib_assistant_release"}, k = 1, mv = {1, 9, 0})
public interface CloudClientListener {
    void c(EndToEndResponse endToEndResponse);

    void d(int i, String str);

    void e(byte[] bArr);
}
