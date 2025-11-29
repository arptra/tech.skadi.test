package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.AssetFileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UriLoader<Data> implements ModelLoader<Uri, Data> {
    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "content", "android.resource"})));

    /* renamed from: a  reason: collision with root package name */
    public final LocalUriFetcherFactory f2593a;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Uri, AssetFileDescriptor>, LocalUriFetcherFactory<AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f2594a;

        public AssetFileDescriptorFactory(ContentResolver contentResolver) {
            this.f2594a = contentResolver;
        }

        public DataFetcher a(Uri uri) {
            return new AssetFileDescriptorLocalUriFetcher(this.f2594a, uri);
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, LocalUriFetcherFactory<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f2595a;

        public FileDescriptorFactory(ContentResolver contentResolver) {
            this.f2595a = contentResolver;
        }

        public DataFetcher a(Uri uri) {
            return new FileDescriptorLocalUriFetcher(this.f2595a, uri);
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    public interface LocalUriFetcherFactory<Data> {
        DataFetcher a(Uri uri);
    }

    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream>, LocalUriFetcherFactory<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f2596a;

        public StreamFactory(ContentResolver contentResolver) {
            this.f2596a = contentResolver;
        }

        public DataFetcher a(Uri uri) {
            return new StreamLocalUriFetcher(this.f2596a, uri);
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    public UriLoader(LocalUriFetcherFactory localUriFetcherFactory) {
        this.f2593a = localUriFetcherFactory;
    }

    /* renamed from: c */
    public ModelLoader.LoadData a(Uri uri, int i, int i2, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(uri), this.f2593a.a(uri));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return b.contains(uri.getScheme());
    }
}
