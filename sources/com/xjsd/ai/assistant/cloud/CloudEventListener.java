package com.xjsd.ai.assistant.cloud;

import com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse;

public interface CloudEventListener {
    void a(String str, String str2);

    void b(byte[] bArr);

    void c(EndToEndResponse endToEndResponse);
}
