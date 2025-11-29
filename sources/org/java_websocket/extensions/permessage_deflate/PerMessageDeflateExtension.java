package org.java_websocket.extensions.permessage_deflate;

import com.meizu.common.widget.MzContactsContract;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.extensions.CompressionExtension;
import org.java_websocket.extensions.ExtensionRequestData;
import org.java_websocket.extensions.IExtension;
import org.java_websocket.framing.ContinuousFrame;
import org.java_websocket.framing.DataFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;

public class PerMessageDeflateExtension extends CompressionExtension {
    public static final byte[] g = {0, 0, -1, -1};

    /* renamed from: a  reason: collision with root package name */
    public int f3398a = 1024;
    public boolean b = true;
    public boolean c = false;
    public Map d = new LinkedHashMap();
    public Inflater e = new Inflater(true);
    public Deflater f = new Deflater(-1, true);

    public static boolean j(byte[] bArr) {
        if (bArr.length < 4) {
            return false;
        }
        int length = bArr.length;
        int i = 0;
        while (true) {
            byte[] bArr2 = g;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr2[i] != bArr[(length - bArr2.length) + i]) {
                return false;
            }
            i++;
        }
    }

    public IExtension a() {
        return new PerMessageDeflateExtension();
    }

    public boolean b(String str) {
        String[] split = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
        int length = split.length;
        int i = 0;
        while (i < length) {
            ExtensionRequestData c2 = ExtensionRequestData.c(split[i]);
            if (!"permessage-deflate".equalsIgnoreCase(c2.a())) {
                i++;
            } else {
                c2.b();
                return true;
            }
        }
        return false;
    }

    public void c(Framedata framedata) {
        if (framedata instanceof DataFrame) {
            byte[] array = framedata.a().array();
            if (array.length >= this.f3398a) {
                if (!(framedata instanceof ContinuousFrame)) {
                    ((DataFrame) framedata).k(true);
                }
                this.f.setInput(array);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int deflate = this.f.deflate(bArr, 0, 1024, 2);
                    if (deflate <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, deflate);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                int length = byteArray.length;
                if (framedata.f()) {
                    if (j(byteArray)) {
                        length -= g.length;
                    }
                    if (this.b) {
                        this.f.end();
                        this.f = new Deflater(-1, true);
                    }
                }
                ((FramedataImpl1) framedata).j(ByteBuffer.wrap(byteArray, 0, length));
            }
        }
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("permessage-deflate; server_no_context_takeover");
        sb.append(this.c ? "; client_no_context_takeover" : "");
        return sb.toString();
    }

    public boolean e(String str) {
        String[] split = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
        int length = split.length;
        int i = 0;
        while (i < length) {
            ExtensionRequestData c2 = ExtensionRequestData.c(split[i]);
            if (!"permessage-deflate".equalsIgnoreCase(c2.a())) {
                i++;
            } else {
                this.d.putAll(c2.b());
                if (this.d.containsKey("client_no_context_takeover")) {
                    this.c = true;
                }
                return true;
            }
        }
        return false;
    }

    public void f(Framedata framedata) {
        if (framedata instanceof DataFrame) {
            if (!framedata.b() && framedata.d() != Opcode.CONTINUOUS) {
                return;
            }
            if (framedata.d() != Opcode.CONTINUOUS || !framedata.b()) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    i(framedata.a().array(), byteArrayOutputStream);
                    if (this.e.getRemaining() > 0) {
                        this.e = new Inflater(true);
                        i(framedata.a().array(), byteArrayOutputStream);
                    }
                    if (framedata.f()) {
                        i(g, byteArrayOutputStream);
                        if (this.c) {
                            this.e = new Inflater(true);
                        }
                    }
                    ((FramedataImpl1) framedata).j(ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size()));
                } catch (DataFormatException e2) {
                    throw new InvalidDataException(1008, e2.getMessage());
                }
            } else {
                throw new InvalidDataException(1008, "RSV1 bit can only be set for the first frame.");
            }
        }
    }

    public String g() {
        this.d.put("client_no_context_takeover", "");
        this.d.put("server_no_context_takeover", "");
        return "permessage-deflate; server_no_context_takeover; client_no_context_takeover";
    }

    public void h(Framedata framedata) {
        if (!(framedata instanceof ContinuousFrame) || (!framedata.b() && !framedata.c() && !framedata.e())) {
            super.h(framedata);
            return;
        }
        throw new InvalidFrameException("bad rsv RSV1: " + framedata.b() + " RSV2: " + framedata.c() + " RSV3: " + framedata.e());
    }

    public final void i(byte[] bArr, ByteArrayOutputStream byteArrayOutputStream) {
        this.e.setInput(bArr);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int inflate = this.e.inflate(bArr2);
            if (inflate > 0) {
                byteArrayOutputStream.write(bArr2, 0, inflate);
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "PerMessageDeflateExtension";
    }
}
