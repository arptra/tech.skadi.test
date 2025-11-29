package org.java_websocket.framing;

import org.java_websocket.enums.Opcode;

public abstract class DataFrame extends FramedataImpl1 {
    public DataFrame(Opcode opcode) {
        super(opcode);
    }

    public void h() {
    }
}
