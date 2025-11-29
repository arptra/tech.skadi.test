package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.nio.ByteBuffer;

@RequiresApi
@AnyThread
public final class MetadataRepo {

    /* renamed from: a  reason: collision with root package name */
    public final MetadataList f1211a;
    public final char[] b;
    public final Node c = new Node(1024);
    public final Typeface d;

    @RestrictTo
    public static class Node {

        /* renamed from: a  reason: collision with root package name */
        public final SparseArray f1212a;
        public EmojiMetadata b;

        public Node() {
            this(1);
        }

        public Node a(int i) {
            SparseArray sparseArray = this.f1212a;
            if (sparseArray == null) {
                return null;
            }
            return (Node) sparseArray.get(i);
        }

        public final EmojiMetadata b() {
            return this.b;
        }

        public void c(EmojiMetadata emojiMetadata, int i, int i2) {
            Node a2 = a(emojiMetadata.b(i));
            if (a2 == null) {
                a2 = new Node();
                this.f1212a.put(emojiMetadata.b(i), a2);
            }
            if (i2 > i) {
                a2.c(emojiMetadata, i + 1, i2);
            } else {
                a2.b = emojiMetadata;
            }
        }

        public Node(int i) {
            this.f1212a = new SparseArray(i);
        }
    }

    public MetadataRepo(Typeface typeface, MetadataList metadataList) {
        this.d = typeface;
        this.f1211a = metadataList;
        this.b = new char[(metadataList.l() * 2)];
        a(metadataList);
    }

    public static MetadataRepo b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            TraceCompat.a("EmojiCompat.MetadataRepo.create");
            return new MetadataRepo(typeface, MetadataListReader.b(byteBuffer));
        } finally {
            TraceCompat.b();
        }
    }

    public final void a(MetadataList metadataList) {
        int l = metadataList.l();
        for (int i = 0; i < l; i++) {
            EmojiMetadata emojiMetadata = new EmojiMetadata(this, i);
            Character.toChars(emojiMetadata.f(), this.b, i * 2);
            h(emojiMetadata);
        }
    }

    public char[] c() {
        return this.b;
    }

    public MetadataList d() {
        return this.f1211a;
    }

    public int e() {
        return this.f1211a.m();
    }

    public Node f() {
        return this.c;
    }

    public Typeface g() {
        return this.d;
    }

    public void h(EmojiMetadata emojiMetadata) {
        Preconditions.i(emojiMetadata, "emoji metadata cannot be null");
        Preconditions.b(emojiMetadata.c() > 0, "invalid metadata codepoint length");
        this.c.c(emojiMetadata, 0, emojiMetadata.c() - 1);
    }
}
