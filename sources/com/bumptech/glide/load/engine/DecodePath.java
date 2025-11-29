package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DecodePath<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    public final Class f2480a;
    public final List b;
    public final ResourceTranscoder c;
    public final Pools.Pool d;
    public final String e;

    public interface DecodeCallback<ResourceType> {
        Resource a(Resource resource);
    }

    public DecodePath(Class cls, Class cls2, Class cls3, List list, ResourceTranscoder resourceTranscoder, Pools.Pool pool) {
        this.f2480a = cls;
        this.b = list;
        this.c = resourceTranscoder;
        this.d = pool;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public Resource a(DataRewinder dataRewinder, int i, int i2, Options options, DecodeCallback decodeCallback) {
        return this.c.a(decodeCallback.a(b(dataRewinder, i, i2, options)), options);
    }

    public final Resource b(DataRewinder dataRewinder, int i, int i2, Options options) {
        List list = (List) Preconditions.d(this.d.acquire());
        try {
            return c(dataRewinder, i, i2, options, list);
        } finally {
            this.d.a(list);
        }
    }

    public final Resource c(DataRewinder dataRewinder, int i, int i2, Options options, List list) {
        int size = this.b.size();
        Resource resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            ResourceDecoder resourceDecoder = (ResourceDecoder) this.b.get(i3);
            try {
                if (resourceDecoder.a(dataRewinder.a(), options)) {
                    resource = resourceDecoder.b(dataRewinder.a(), i, i2, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + resourceDecoder, e2);
                }
                list.add(e2);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.e, (List<Throwable>) new ArrayList(list));
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f2480a + ", decoders=" + this.b + ", transcoder=" + this.c + '}';
    }
}
