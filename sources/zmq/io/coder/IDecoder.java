package zmq.io.coder;

import java.nio.ByteBuffer;
import zmq.Msg;
import zmq.util.ValueReference;

public interface IDecoder {

    public interface Step {

        public enum Result {
            MORE_DATA(0),
            DECODED(1),
            ERROR(-1);
            
            private final int code;

            private Result(int i) {
                this.code = i;
            }
        }

        Result apply();
    }

    Msg a();

    Step.Result b(ByteBuffer byteBuffer, int i, ValueReference valueReference);

    void destroy();

    ByteBuffer getBuffer();
}
