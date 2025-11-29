package com.upuphone.ar.tici.phone.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0016\u0010\f\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"com/upuphone/ar/tici/phone/utils/ReaderTextSequence$iterator$1", "", "", "", "hasNext", "()Z", "a", "()Ljava/lang/String;", "Ljava/lang/String;", "nextValue", "b", "Z", "done", "Ljava/lang/StringBuffer;", "c", "Ljava/lang/StringBuffer;", "stringBuffer", "", "d", "I", "charsCopied", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class ReaderTextSequence$iterator$1 implements Iterator<String>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    public String f5997a;
    public boolean b;
    public final StringBuffer c = new StringBuffer();
    public int d;
    public final /* synthetic */ ReaderTextSequence e;

    public ReaderTextSequence$iterator$1(ReaderTextSequence readerTextSequence) {
        this.e = readerTextSequence;
    }

    /* renamed from: a */
    public String next() {
        if (hasNext()) {
            String str = this.f5997a;
            this.f5997a = null;
            Intrinsics.checkNotNull(str);
            return str;
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        if (this.f5997a == null || !this.b) {
            char[] cArr = new char[this.e.c];
            int read = this.e.f5996a.read(cArr);
            if (read >= 0) {
                this.c.append(cArr, 0, read);
            } else {
                this.b = true;
            }
            int i = this.d + read;
            this.d = i;
            if (i >= this.e.b) {
                this.f5997a = this.c.toString();
                this.b = true;
            } else if (this.c.length() >= this.e.c) {
                String substring = this.c.substring(0, this.e.c);
                String substring2 = this.c.substring(this.e.c);
                this.c.setLength(0);
                this.c.append(substring2);
                this.f5997a = substring;
            }
        }
        return this.f5997a != null;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
