package org.java_websocket.framing;

import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidFrameException;

public abstract class ControlFrame extends FramedataImpl1 {
    public ControlFrame(Opcode opcode) {
        super(opcode);
    }

    public void h() {
        if (!f()) {
            throw new InvalidFrameException("Control frame can't have fin==false set");
        } else if (b()) {
            throw new InvalidFrameException("Control frame can't have rsv1==true set");
        } else if (c()) {
            throw new InvalidFrameException("Control frame can't have rsv2==true set");
        } else if (e()) {
            throw new InvalidFrameException("Control frame can't have rsv3==true set");
        }
    }
}
