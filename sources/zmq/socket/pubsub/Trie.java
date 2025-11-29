package zmq.socket.pubsub;

import java.nio.ByteBuffer;
import zmq.Msg;
import zmq.pipe.Pipe;
import zmq.util.Utils;

class Trie {

    /* renamed from: a  reason: collision with root package name */
    public int f3663a = 0;
    public byte b = 0;
    public int c = 0;
    public int d = 0;
    public Trie[] e = null;

    public interface ITrieHandler {
        void a(byte[] bArr, int i, Pipe pipe);
    }

    public boolean a(Msg msg, int i, int i2) {
        if (i2 == 0) {
            int i3 = this.f3663a + 1;
            this.f3663a = i3;
            return i3 == 1;
        }
        byte e2 = msg.e(i);
        byte b2 = this.b;
        if (e2 < b2 || e2 >= this.c + b2) {
            int i4 = this.c;
            if (i4 == 0) {
                this.b = e2;
                this.c = 1;
                this.e = null;
            } else if (i4 == 1) {
                Trie trie = this.e[0];
                int i5 = (b2 < e2 ? e2 - b2 : b2 - e2) + 1;
                this.c = i5;
                this.e = new Trie[i5];
                byte min = (byte) Math.min(b2, e2);
                this.b = min;
                this.e[b2 - min] = trie;
            } else if (b2 < e2) {
                int i6 = (e2 - b2) + 1;
                this.c = i6;
                this.e = f(this.e, i6, true);
            } else {
                int i7 = (b2 + i4) - e2;
                this.c = i7;
                this.e = f(this.e, i7, false);
                this.b = e2;
            }
        }
        if (this.c == 1) {
            if (this.e == null) {
                Trie[] trieArr = new Trie[1];
                this.e = trieArr;
                trieArr[0] = new Trie();
                this.d++;
            }
            return this.e[0].a(msg, i + 1, i2 - 1);
        }
        Trie[] trieArr2 = this.e;
        byte b3 = this.b;
        if (trieArr2[e2 - b3] == null) {
            trieArr2[e2 - b3] = new Trie();
            this.d++;
        }
        return this.e[e2 - this.b].a(msg, i + 1, i2 - 1);
    }

    public void b(ITrieHandler iTrieHandler, Pipe pipe) {
        c((byte[]) null, 0, 0, iTrieHandler, pipe);
    }

    public final void c(byte[] bArr, int i, int i2, ITrieHandler iTrieHandler, Pipe pipe) {
        if (this.f3663a > 0) {
            iTrieHandler.a(bArr, i, pipe);
        }
        if (i >= i2) {
            i2 = i + 256;
            bArr = Utils.h(bArr, i2);
        }
        int i3 = this.c;
        if (i3 != 0) {
            if (i3 == 1) {
                bArr[i] = this.b;
                this.e[0].c(bArr, 1 + i, i2, iTrieHandler, pipe);
                return;
            }
            for (int i4 = 0; i4 != this.c; i4++) {
                bArr[i] = (byte) (this.b + i4);
                Trie trie = this.e[i4];
                if (trie != null) {
                    trie.c(bArr, i + 1, i2, iTrieHandler, pipe);
                }
            }
        }
    }

    public boolean d(ByteBuffer byteBuffer) {
        byte b2;
        byte b3;
        int limit = byteBuffer.limit();
        int i = 0;
        while (r8.f3663a <= 0) {
            if (limit != 0 && (b2 = byteBuffer.get(i)) >= (b3 = r8.b)) {
                int i2 = r8.c;
                if (b2 < b3 + i2) {
                    if (i2 == 1) {
                        r8 = r8.e[0];
                    } else {
                        r8 = r8.e[b2 - b3];
                        if (r8 == null) {
                            return false;
                        }
                    }
                    i++;
                    limit--;
                }
            }
            return false;
        }
        return true;
    }

    public final boolean e() {
        return this.f3663a == 0 && this.d == 0;
    }

    public final Trie[] f(Trie[] trieArr, int i, boolean z) {
        return (Trie[]) Utils.i(Trie.class, trieArr, i, z);
    }

    public boolean g(Msg msg, int i, int i2) {
        byte b2;
        int i3;
        int i4 = 1;
        if (i2 == 0) {
            int i5 = this.f3663a;
            if (i5 == 0) {
                return false;
            }
            int i6 = i5 - 1;
            this.f3663a = i6;
            return i6 == 0;
        }
        byte e2 = msg.e(i);
        int i7 = this.c;
        if (i7 == 0 || e2 < (b2 = this.b) || e2 >= b2 + i7) {
            return false;
        }
        Trie trie = i7 == 1 ? this.e[0] : this.e[e2 - b2];
        if (trie == null) {
            return false;
        }
        boolean g = trie.g(msg, i + 1, i2 - 1);
        if (trie.e()) {
            int i8 = this.c;
            Trie trie2 = null;
            if (i8 == 1) {
                this.e = null;
                this.c = 0;
                this.d--;
            } else {
                Trie[] trieArr = this.e;
                byte b3 = this.b;
                trieArr[e2 - b3] = null;
                int i9 = this.d - 1;
                this.d = i9;
                if (i9 == 1) {
                    if (e2 == b3) {
                        trie2 = trieArr[i8 - 1];
                        this.b = (byte) (b3 + (i8 - 1));
                    } else if (e2 == (b3 + i8) - 1) {
                        trie2 = trieArr[0];
                    }
                    this.e = new Trie[]{trie2};
                    this.c = 1;
                } else if (e2 == b3) {
                    int i10 = 1;
                    while (true) {
                        i3 = this.c;
                        if (i10 >= i3) {
                            break;
                        } else if (this.e[i10] != null) {
                            b3 = (byte) (i10 + this.b);
                            break;
                        } else {
                            i10++;
                        }
                    }
                    int i11 = i3 - (b3 - this.b);
                    this.c = i11;
                    this.e = f(this.e, i11, true);
                    this.b = b3;
                } else if (e2 == (b3 + i8) - 1) {
                    while (true) {
                        int i12 = this.c;
                        if (i4 >= i12) {
                            break;
                        } else if (this.e[(i12 - 1) - i4] != null) {
                            i8 = i12 - i4;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    this.c = i8;
                    this.e = f(this.e, i8, false);
                }
            }
        }
        return g;
    }
}
