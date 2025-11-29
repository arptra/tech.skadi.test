package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.AbstractMessageLite.Builder;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.MessageLite;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode = 0;

    public interface InternalOneOfEnum {
    }

    public static void c(Iterable iterable, List list) {
        Builder.c(iterable, list);
    }

    public int d() {
        throw new UnsupportedOperationException();
    }

    public int e(Schema schema) {
        int d = d();
        if (d != -1) {
            return d;
        }
        int serializedSize = schema.getSerializedSize(this);
        h(serializedSize);
        return serializedSize;
    }

    public final String f(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public UninitializedMessageException g() {
        return new UninitializedMessageException((MessageLite) this);
    }

    public void h(int i) {
        throw new UnsupportedOperationException();
    }

    public void i(OutputStream outputStream) {
        CodedOutputStream n0 = CodedOutputStream.n0(outputStream, CodedOutputStream.Q(getSerializedSize()));
        b(n0);
        n0.k0();
    }

    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream o0 = CodedOutputStream.o0(bArr);
            b(o0);
            o0.k();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(f("byte array"), e);
        }
    }

    public ByteString toByteString() {
        try {
            ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(getSerializedSize());
            b(newCodedBuilder.b());
            return newCodedBuilder.a();
        } catch (IOException e) {
            throw new RuntimeException(f("ByteString"), e);
        }
    }

    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {
        public static void c(Iterable iterable, List list) {
            Internal.a(iterable);
            if (iterable instanceof LazyStringList) {
                List underlyingElements = ((LazyStringList) iterable).getUnderlyingElements();
                LazyStringList lazyStringList = (LazyStringList) list;
                int size = list.size();
                for (Object next : underlyingElements) {
                    if (next == null) {
                        String str = "Element at index " + (lazyStringList.size() - size) + " is null.";
                        for (int size2 = lazyStringList.size() - 1; size2 >= size; size2--) {
                            lazyStringList.remove(size2);
                        }
                        throw new NullPointerException(str);
                    } else if (next instanceof ByteString) {
                        lazyStringList.g((ByteString) next);
                    } else {
                        lazyStringList.add((String) next);
                    }
                }
            } else if (iterable instanceof PrimitiveNonBoxingCollection) {
                list.addAll((Collection) iterable);
            } else {
                d(iterable, list);
            }
        }

        public static void d(Iterable iterable, List list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (Object next : iterable) {
                if (next == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(next);
            }
        }

        public static UninitializedMessageException m(MessageLite messageLite) {
            return new UninitializedMessageException(messageLite);
        }

        /* renamed from: e */
        public abstract Builder clone();

        public final String f(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        public abstract Builder g(AbstractMessageLite abstractMessageLite);

        public Builder h(CodedInputStream codedInputStream) {
            return i(codedInputStream, ExtensionRegistryLite.b());
        }

        public abstract Builder i(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

        /* renamed from: j */
        public Builder a(MessageLite messageLite) {
            if (getDefaultInstanceForType().getClass().isInstance(messageLite)) {
                return g((AbstractMessageLite) messageLite);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        /* renamed from: k */
        public Builder mergeFrom(byte[] bArr) {
            return l(bArr, 0, bArr.length);
        }

        public Builder l(byte[] bArr, int i, int i2) {
            try {
                CodedInputStream j = CodedInputStream.j(bArr, i, i2);
                h(j);
                j.a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException(f("byte array"), e2);
            }
        }

        public static final class LimitedInputStream extends FilterInputStream {

            /* renamed from: a  reason: collision with root package name */
            public int f1043a;

            public int available() {
                return Math.min(super.available(), this.f1043a);
            }

            public int read() {
                if (this.f1043a <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.f1043a--;
                }
                return read;
            }

            public long skip(long j) {
                long skip = super.skip(Math.min(j, (long) this.f1043a));
                if (skip >= 0) {
                    this.f1043a = (int) (((long) this.f1043a) - skip);
                }
                return skip;
            }

            public int read(byte[] bArr, int i, int i2) {
                int i3 = this.f1043a;
                if (i3 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i, Math.min(i2, i3));
                if (read >= 0) {
                    this.f1043a -= read;
                }
                return read;
            }
        }
    }
}
