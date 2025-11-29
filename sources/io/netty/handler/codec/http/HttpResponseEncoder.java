package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;

public class HttpResponseEncoder extends HttpObjectEncoder<HttpResponse> {
    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return super.acceptOutboundMessage(obj) && !(obj instanceof HttpRequest);
    }

    public void encodeInitialLine(ByteBuf byteBuf, HttpResponse httpResponse) throws Exception {
        httpResponse.protocolVersion().encode(byteBuf);
        byteBuf.writeByte(32);
        httpResponse.status().encode(byteBuf);
        ByteBufUtil.writeShortBE(byteBuf, 3338);
    }

    public boolean isContentAlwaysEmpty(HttpResponse httpResponse) {
        HttpResponseStatus status = httpResponse.status();
        if (status.codeClass() == HttpStatusClass.INFORMATIONAL) {
            if (status.code() == HttpResponseStatus.SWITCHING_PROTOCOLS.code()) {
                return httpResponse.headers().contains((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_VERSION);
            }
            return true;
        } else if (status.code() == HttpResponseStatus.NO_CONTENT.code() || status.code() == HttpResponseStatus.NOT_MODIFIED.code() || status.code() == HttpResponseStatus.RESET_CONTENT.code()) {
            return true;
        } else {
            return false;
        }
    }

    public void sanitizeHeadersBeforeEncode(HttpResponse httpResponse, boolean z) {
        if (z) {
            HttpResponseStatus status = httpResponse.status();
            if (status.codeClass() == HttpStatusClass.INFORMATIONAL || status.code() == HttpResponseStatus.NO_CONTENT.code()) {
                httpResponse.headers().remove((CharSequence) HttpHeaderNames.CONTENT_LENGTH);
                httpResponse.headers().remove((CharSequence) HttpHeaderNames.TRANSFER_ENCODING);
            } else if (status.code() == HttpResponseStatus.RESET_CONTENT.code()) {
                httpResponse.headers().remove((CharSequence) HttpHeaderNames.TRANSFER_ENCODING);
                httpResponse.headers().setInt(HttpHeaderNames.CONTENT_LENGTH, 0);
            }
        }
    }
}
