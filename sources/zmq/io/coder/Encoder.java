package zmq.io.coder;

import zmq.util.Errno;

public abstract class Encoder extends EncoderBase {
    public final Runnable j = new Runnable() {
        public void run() {
            Encoder.this.h();
        }
    };
    public final Runnable k = new Runnable() {
        public void run() {
            Encoder.this.g();
        }
    };

    public Encoder(Errno errno, int i) {
        super(errno, i);
    }

    public abstract void g();

    public abstract void h();
}
