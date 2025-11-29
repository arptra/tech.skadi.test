package zmq.io.mechanism;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import zmq.Options;
import zmq.ZMQ;
import zmq.io.SessionBase;
import zmq.io.mechanism.curve.CurveClientMechanism;
import zmq.io.mechanism.curve.CurveServerMechanism;
import zmq.io.mechanism.gssapi.GssapiClientMechanism;
import zmq.io.mechanism.gssapi.GssapiServerMechanism;
import zmq.io.mechanism.plain.PlainClientMechanism;
import zmq.io.mechanism.plain.PlainServerMechanism;
import zmq.io.net.Address;

public enum Mechanisms {
    NULL {
        public void check(Options options) {
        }

        public Mechanism create(SessionBase sessionBase, Address address, Options options) {
            return new NullMechanism(sessionBase, address, options);
        }
    },
    PLAIN {
        public void check(Options options) {
            if (!options.H) {
                HashSet hashSet = new HashSet(2);
                String str = options.J;
                if (str == null || str.length() >= 256) {
                    hashSet.add("user name invalid");
                }
                String str2 = options.K;
                if (str2 == null || str2.length() >= 256) {
                    hashSet.add("password is invalid");
                }
                if (!hashSet.isEmpty()) {
                    throw new IllegalStateException("Plain mechanism definition incomplete: " + hashSet);
                }
            }
        }

        public Mechanism create(SessionBase sessionBase, Address address, Options options) {
            return options.H ? new PlainServerMechanism(sessionBase, address, options) : new PlainClientMechanism(sessionBase, options);
        }
    },
    CURVE {
        public void check(Options options) {
            byte[] bArr;
            HashSet hashSet = new HashSet(3);
            byte[] bArr2 = options.L;
            if (bArr2 == null || bArr2.length != 32) {
                hashSet.add("public key is invalid");
            }
            byte[] bArr3 = options.M;
            if (bArr3 == null || bArr3.length != 32) {
                hashSet.add("secret key is invalid");
            }
            if (!options.H && ((bArr = options.N) == null || bArr.length != 32)) {
                hashSet.add("not a server and no server public key given");
            }
            if (!hashSet.isEmpty()) {
                throw new IllegalStateException("Curve mechanism definition incomplete: " + hashSet);
            }
        }

        public Mechanism create(SessionBase sessionBase, Address address, Options options) {
            return options.H ? new CurveServerMechanism(sessionBase, address, options) : new CurveClientMechanism(sessionBase, options);
        }
    },
    GSSAPI {
        public void check(Options options) {
            throw new UnsupportedOperationException("GSSAPI mechanism is not yet implemented");
        }

        public Mechanism create(SessionBase sessionBase, Address address, Options options) {
            return options.H ? new GssapiServerMechanism(sessionBase, address, options) : new GssapiClientMechanism(sessionBase, options);
        }
    };

    public abstract void check(Options options);

    public abstract Mechanism create(SessionBase sessionBase, Address address, Options options);

    public boolean isMechanism(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[20];
        byteBuffer.get(bArr, 0, 20);
        return Arrays.equals(bArr, Arrays.copyOf(name().getBytes(ZMQ.c), 20));
    }
}
