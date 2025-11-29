package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;
import com.here.posclient.UpdateOptions;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class RopeByteString extends ByteString {
    static final int[] minLengthByDepth = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private static final long serialVersionUID = 1;
    /* access modifiers changed from: private */
    public final ByteString left;
    private final int leftLength;
    /* access modifiers changed from: private */
    public final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    public static class Balancer {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayDeque f1132a;

        public Balancer() {
            this.f1132a = new ArrayDeque();
        }

        public final ByteString b(ByteString byteString, ByteString byteString2) {
            c(byteString);
            c(byteString2);
            ByteString byteString3 = (ByteString) this.f1132a.pop();
            while (!this.f1132a.isEmpty()) {
                byteString3 = new RopeByteString((ByteString) this.f1132a.pop(), byteString3);
            }
            return byteString3;
        }

        public final void c(ByteString byteString) {
            if (byteString.isBalanced()) {
                e(byteString);
            } else if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                c(ropeByteString.left);
                c(ropeByteString.right);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
        }

        public final int d(int i) {
            int binarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, i);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        public final void e(ByteString byteString) {
            int d = d(byteString.size());
            int[] iArr = RopeByteString.minLengthByDepth;
            int i = iArr[d + 1];
            if (this.f1132a.isEmpty() || ((ByteString) this.f1132a.peek()).size() >= i) {
                this.f1132a.push(byteString);
                return;
            }
            int i2 = iArr[d];
            ByteString byteString2 = (ByteString) this.f1132a.pop();
            while (!this.f1132a.isEmpty() && ((ByteString) this.f1132a.peek()).size() < i2) {
                byteString2 = new RopeByteString((ByteString) this.f1132a.pop(), byteString2);
            }
            RopeByteString ropeByteString = new RopeByteString(byteString2, byteString);
            while (!this.f1132a.isEmpty()) {
                if (((ByteString) this.f1132a.peek()).size() >= RopeByteString.minLengthByDepth[d(ropeByteString.size()) + 1]) {
                    break;
                }
                ropeByteString = new RopeByteString((ByteString) this.f1132a.pop(), ropeByteString);
            }
            this.f1132a.push(ropeByteString);
        }
    }

    public static final class PieceIterator implements Iterator<ByteString.LeafByteString> {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayDeque f1133a;
        public ByteString.LeafByteString b;

        public final ByteString.LeafByteString a(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.f1133a.push(ropeByteString);
                byteString = ropeByteString.left;
            }
            return (ByteString.LeafByteString) byteString;
        }

        public final ByteString.LeafByteString b() {
            ByteString.LeafByteString a2;
            do {
                ArrayDeque arrayDeque = this.f1133a;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    return null;
                }
                a2 = a(((RopeByteString) this.f1133a.pop()).right);
            } while (a2.isEmpty());
            return a2;
        }

        /* renamed from: c */
        public ByteString.LeafByteString next() {
            ByteString.LeafByteString leafByteString = this.b;
            if (leafByteString != null) {
                this.b = b();
                return leafByteString;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return this.b != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public PieceIterator(ByteString byteString) {
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                ArrayDeque arrayDeque = new ArrayDeque(ropeByteString.getTreeDepth());
                this.f1133a = arrayDeque;
                arrayDeque.push(ropeByteString);
                this.b = a(ropeByteString.left);
                return;
            }
            this.f1133a = null;
            this.b = (ByteString.LeafByteString) byteString;
        }
    }

    public static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return concatenateBytes(byteString, byteString2);
        }
        if (byteString instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString) byteString;
            if (ropeByteString.right.size() + byteString2.size() < 128) {
                return new RopeByteString(ropeByteString.left, concatenateBytes(ropeByteString.right, byteString2));
            } else if (ropeByteString.left.getTreeDepth() > ropeByteString.right.getTreeDepth() && ropeByteString.getTreeDepth() > byteString2.getTreeDepth()) {
                return new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
            }
        }
        return size >= minLengthByDepth[Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1] ? new RopeByteString(byteString, byteString2) : new Balancer().b(byteString, byteString2);
    }

    private static ByteString concatenateBytes(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[(size + size2)];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return ByteString.wrap(bArr);
    }

    private boolean equalsFragments(ByteString byteString) {
        PieceIterator pieceIterator = new PieceIterator(this);
        ByteString.LeafByteString leafByteString = (ByteString.LeafByteString) pieceIterator.next();
        PieceIterator pieceIterator2 = new PieceIterator(byteString);
        ByteString.LeafByteString leafByteString2 = (ByteString.LeafByteString) pieceIterator2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = leafByteString.size() - i;
            int size2 = leafByteString2.size() - i2;
            int min = Math.min(size, size2);
            if (!(i == 0 ? leafByteString.equalsRange(leafByteString2, i2, min) : leafByteString2.equalsRange(leafByteString, i, min))) {
                return false;
            }
            i3 += min;
            int i4 = this.totalLength;
            if (i3 < i4) {
                if (min == size) {
                    leafByteString = (ByteString.LeafByteString) pieceIterator.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    leafByteString2 = (ByteString.LeafByteString) pieceIterator2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public static RopeByteString newInstanceForTest(ByteString byteString, ByteString byteString2) {
        return new RopeByteString(byteString, byteString2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList();
        PieceIterator pieceIterator = new PieceIterator(this);
        while (pieceIterator.hasNext()) {
            arrayList.add(pieceIterator.next().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    public byte byteAt(int i) {
        ByteString.checkIndex(i, this.totalLength);
        return internalByteAt(i);
    }

    public void copyTo(ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }

    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.leftLength;
        if (i4 <= i5) {
            this.left.copyToInternal(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.right.copyToInternal(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.left.copyToInternal(bArr, i, i2, i6);
            this.right.copyToInternal(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        int peekCachedHashCode = peekCachedHashCode();
        int peekCachedHashCode2 = byteString.peekCachedHashCode();
        if (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) {
            return equalsFragments(byteString);
        }
        return false;
    }

    public int getTreeDepth() {
        return this.treeDepth;
    }

    public byte internalByteAt(int i) {
        int i2 = this.leftLength;
        return i < i2 ? this.left.internalByteAt(i) : this.right.internalByteAt(i - i2);
    }

    public boolean isBalanced() {
        return this.totalLength >= minLengthByDepth[this.treeDepth];
    }

    public boolean isValidUtf8() {
        int partialIsValidUtf8 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString byteString = this.right;
        return byteString.partialIsValidUtf8(partialIsValidUtf8, 0, byteString.size()) == 0;
    }

    public CodedInputStream newCodedInput() {
        return CodedInputStream.f(new RopeInputStream());
    }

    public InputStream newInput() {
        return new RopeInputStream();
    }

    public int partialHash(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.leftLength;
        if (i4 <= i5) {
            return this.left.partialHash(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.right.partialHash(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.right.partialHash(this.left.partialHash(i, i2, i6), 0, i3 - i6);
    }

    public int partialIsValidUtf8(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.leftLength;
        if (i4 <= i5) {
            return this.left.partialIsValidUtf8(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.right.partialIsValidUtf8(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(i, i2, i6), 0, i3 - i6);
    }

    public int size() {
        return this.totalLength;
    }

    public ByteString substring(int i, int i2) {
        int checkRange = ByteString.checkRange(i, i2, this.totalLength);
        if (checkRange == 0) {
            return ByteString.EMPTY;
        }
        if (checkRange == this.totalLength) {
            return this;
        }
        int i3 = this.leftLength;
        return i2 <= i3 ? this.left.substring(i, i2) : i >= i3 ? this.right.substring(i - i3, i2 - i3) : new RopeByteString(this.left.substring(i), this.right.substring(0, i2 - this.leftLength));
    }

    public String toStringInternal(Charset charset) {
        return new String(toByteArray(), charset);
    }

    public Object writeReplace() {
        return ByteString.wrap(toByteArray());
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    public void writeToInternal(OutputStream outputStream, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = this.leftLength;
        if (i3 <= i4) {
            this.left.writeToInternal(outputStream, i, i2);
        } else if (i >= i4) {
            this.right.writeToInternal(outputStream, i - i4, i2);
        } else {
            int i5 = i4 - i;
            this.left.writeToInternal(outputStream, i, i5);
            this.right.writeToInternal(outputStream, 0, i2 - i5);
        }
    }

    public void writeToReverse(ByteOutput byteOutput) throws IOException {
        this.right.writeToReverse(byteOutput);
        this.left.writeToReverse(byteOutput);
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.left = byteString;
        this.right = byteString2;
        int size = byteString.size();
        this.leftLength = size;
        this.totalLength = size + byteString2.size();
        this.treeDepth = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    public ByteString.ByteIterator iterator() {
        return new ByteString.AbstractByteIterator() {

            /* renamed from: a  reason: collision with root package name */
            public final PieceIterator f1131a;
            public ByteString.ByteIterator b = b();

            {
                this.f1131a = new PieceIterator(RopeByteString.this);
            }

            public final ByteString.ByteIterator b() {
                if (this.f1131a.hasNext()) {
                    return this.f1131a.next().iterator();
                }
                return null;
            }

            public boolean hasNext() {
                return this.b != null;
            }

            public byte nextByte() {
                ByteString.ByteIterator byteIterator = this.b;
                if (byteIterator != null) {
                    byte nextByte = byteIterator.nextByte();
                    if (!this.b.hasNext()) {
                        this.b = b();
                    }
                    return nextByte;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public void writeTo(ByteOutput byteOutput) throws IOException {
        this.left.writeTo(byteOutput);
        this.right.writeTo(byteOutput);
    }

    public class RopeInputStream extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        public PieceIterator f1134a;
        public ByteString.LeafByteString b;
        public int c;
        public int d;
        public int e;
        public int f;

        public RopeInputStream() {
            b();
        }

        public final void a() {
            int i;
            if (this.b != null && this.d == (i = this.c)) {
                this.e += i;
                this.d = 0;
                if (this.f1134a.hasNext()) {
                    ByteString.LeafByteString c2 = this.f1134a.next();
                    this.b = c2;
                    this.c = c2.size();
                    return;
                }
                this.b = null;
                this.c = 0;
            }
        }

        public int available() {
            return RopeByteString.this.size() - (this.e + this.d);
        }

        public final void b() {
            PieceIterator pieceIterator = new PieceIterator(RopeByteString.this);
            this.f1134a = pieceIterator;
            ByteString.LeafByteString c2 = pieceIterator.next();
            this.b = c2;
            this.c = c2.size();
            this.d = 0;
            this.e = 0;
        }

        public final int c(byte[] bArr, int i, int i2) {
            int i3 = i2;
            while (true) {
                if (i3 <= 0) {
                    break;
                }
                a();
                if (this.b != null) {
                    int min = Math.min(this.c - this.d, i3);
                    if (bArr != null) {
                        this.b.copyTo(bArr, this.d, i, min);
                        i += min;
                    }
                    this.d += min;
                    i3 -= min;
                } else if (i3 == i2) {
                    return -1;
                }
            }
            return i2 - i3;
        }

        public void mark(int i) {
            this.f = this.e + this.d;
        }

        public boolean markSupported() {
            return true;
        }

        public int read(byte[] bArr, int i, int i2) {
            bArr.getClass();
            if (i >= 0 && i2 >= 0 && i2 <= bArr.length - i) {
                return c(bArr, i, i2);
            }
            throw new IndexOutOfBoundsException();
        }

        public synchronized void reset() {
            b();
            c((byte[]) null, 0, this.f);
        }

        public long skip(long j) {
            if (j >= 0) {
                if (j > UpdateOptions.SOURCE_ANY) {
                    j = 2147483647L;
                }
                return (long) c((byte[]) null, 0, (int) j);
            }
            throw new IndexOutOfBoundsException();
        }

        public int read() {
            a();
            ByteString.LeafByteString leafByteString = this.b;
            if (leafByteString == null) {
                return -1;
            }
            int i = this.d;
            this.d = i + 1;
            return leafByteString.byteAt(i) & 255;
        }
    }
}
